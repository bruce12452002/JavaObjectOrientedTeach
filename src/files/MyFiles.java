package files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Stream;

public class MyFiles {
    public static void main(String[] args) {
//        isSameFile();
//        copyFile1();
//        copyFile2();
//        copyDir();
//        moveDir();
//        readWrite();
//        workFileTree(Paths.get("inner/haha/"));
        work(Paths.get("inner/haha/"));
//        fileStores();
    }

    private static void isSameFile() {
        Path p1 = Paths.get("inner/abc.txt");
        Path p2 = Paths.get("abc.txt");
        Path p3 = Paths.get("abc.txt");
        try {
            System.out.println(Files.isSameFile(p1, p2)); // false，雖然 abc.txt 是複製過去的，但判斷的是路徑有沒有一樣
            System.out.println(Files.isSameFile(p3, p2)); // true
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyFile1() {
        Path source = Paths.get("abc.txt");

        // 只有目錄且已存在 會 FileAlreadyExistsException
        // 路徑不存在「不會」幫忙建立，會 NoSuchFileException
        Path target = Paths.get("inner/haha/abc.txt");
        try {
            System.out.println(Files.copy(source, target)); // 目的已有相同檔名會 FileAlreadyExistsException
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyFile2() {
        Path source = Paths.get("abc.txt");
        Path target = Paths.get("inner/haha/abc.txt");
        try {
            System.out.println(Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING)); // 如已有檔案會覆蓋
//            StandardCopyOption.COPY_ATTRIBUTES // 複製檔案屬性
//            StandardCopyOption.ATOMIC_MOVE // 複製過程中是原子性的，不會被其他執行緒所影響
//            LinkOption.NOFOLLOW_LINKS // 如果是軟硬連結，預設是複製指向的檔案，加上這個才是複製軟硬連結本身
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void copyDir() {
        Path source = Paths.get("inner/haha");

        // 路徑不存在「會」幫忙建立；已存在會 FileAlreadyExistsException，但可加 StandardCopyOption.REPLACE_EXISTING 解決
        // 不管有沒有加 StandardCopyOption.REPLACE_EXISTING，目錄一定要是空的，否則會 DirectoryNotEmptyException
        // 「不會」複製目錄裡的東西
        Path target = Paths.get("inner/hoho");
        try {
//            System.out.println(Files.copy(source, target));
            System.out.println(Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void moveDir() {
        Path source = Paths.get("inner/haha");

        // 路徑不存在「會」幫忙建立；已存在會 FileAlreadyExistsException，但可加 StandardCopyOption.REPLACE_EXISTING 解決
        // 不管有沒有加 StandardCopyOption.REPLACE_EXISTING，目錄一定要是空的，否則會 DirectoryNotEmptyException
        // 「會」複製目錄裡的東西，此例是 haha 目錄裡的東西會複製到 hoho，但 haha 目錄就刪除了
        Path target = Paths.get("inner/hoho");
        try {
            System.out.println(Files.move(source, target, StandardCopyOption.REPLACE_EXISTING));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readWrite() {
        Path source = Paths.get("inner/haha/ghi.txt");
        Path target = Paths.get("inner/haha/ghi2.txt");
        try {
            final Charset charset = StandardCharsets.UTF_8;
            List<String> list = Files.readAllLines(source, charset);
//            list.forEach(System.out::println);

//            Files.write(target, list, charset);
            Files.write(target, list, charset,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE);
            // 預設就是 CREATE TRUNCATE_EXISTING WRITE
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 訪問一層的所有檔案和目錄，可用遞迴取得所有層
     */
    private static void workFileTree(Path path) {
        try {
            Files.walkFileTree(path, new MyFileVisitor());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void work(Path path) {
        try (Stream<Path> ps = Files.walk(path)) {
            ps.filter(Files::isRegularFile)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 取得磁碟的資訊
     */
    private static void fileStores() {
        Iterable<FileStore> fileStores = FileSystems.getDefault().getFileStores();
        for (FileStore fs : fileStores) {
            try {
                System.out.println(fs.name());
                // 回傳為 Byte
                System.out.println(fs.getTotalSpace() / 1024 / 1024 / 1024 + "GB");
                System.out.println(fs.getUsableSpace() / 1024 / 1024 / 1024 + "GB");
                System.out.println(fs.getUnallocatedSpace() / 1024 / 1024 / 1024 + "GB");
                System.out.println();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
