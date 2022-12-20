package files;

import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class MyPath {
    public static void main(String[] args) {
        getPath1();
//        getPath2();
//        getPath3();
//        relativize();
//        iterator();
//        startsEndsWith();
    }

    private static void getPath1() {
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("./abc.txt");
        System.out.println(path);
        System.out.println(path.normalize());
        System.out.println(path.getFileName());
    }

    private static void getPath2() {
        Path path1 = Paths.get("abc.txt");
        System.out.println(path1.toFile().exists());

        Path path2 = Paths.get(URI.create("file:///abc.txt"));
        System.out.println(path2.toFile().exists());
    }

    private static void getPath3() {
        Path p = Paths.get("inner/");
        p = p.resolve("haha/ghi.txt"); // 相對路徑可拼接
        System.out.println(p.toFile().exists());
        System.out.println(p.subpath(1, 3)); // haha/ghi.txt
        System.out.println(p.toAbsolutePath().subpath(1, 3)); // 類似 substring，取 1 和 2，每組 // 之間算一個 index
        System.out.println(p.getName(0)); // inner
        System.out.println(p.getName(1)); // haha
        System.out.println(p.getName(2)); // ghi.txt
//        System.out.println(p.getName(3)); // IllegalArgumentException

        System.out.println("====================");
        Path p2 = Paths.get("inner");
        p2 = p2.resolve("/haha/ghi.txt"); // 絕對路徑只會取 resolve ，之前的路徑都會不見
        System.out.println(p2.toFile().exists());
        System.out.println(p2.toFile().getAbsolutePath()); // /haha/ghi.txt
    }

    private static void relativize() {
        Path p1 = FileSystems.getDefault().getPath("inner/haha/ghi.txt");
        Path p2 = Paths.get("inner/def.txt");

        // 顯示從左邊到右邊的相對路徑怎麼走
        System.out.println(p1.relativize(p2)); // ../../def.txt
        System.out.println(p2.relativize(p1)); // ../haha/ghi.txt
    }

    private static void iterator() {
        Path p = Paths.get("inner/haha/ghi.txt");
        Iterator<Path> it = p.iterator();
        while (it.hasNext()) {
            System.out.println(it.next()); // inner haha ghi.txt
        }
        System.out.println("==============");
        for (Path path : p) {
            System.out.println(path); // inner haha ghi.txt
        }
    }

    private static void startsEndsWith() {
        Path p = Paths.get("inner/haha/ghi.txt");
        System.out.println(p.startsWith("inner")); // true
        System.out.println(p.toAbsolutePath().startsWith("inner")); // false
        System.out.println(p.endsWith("txt")); // true
    }
}
