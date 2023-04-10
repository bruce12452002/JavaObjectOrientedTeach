package stream;


import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalTest {
    public static void main(String[] args) {
//        process();
//        collect();
//        count();
//        joining();
    }

    private static void process() {
        Stream.of(1, 2, 3).filter(i -> {
            System.out.println("filter");
            return i >= 2;
        }).map(i -> {
            System.out.println("map");
            return i + "xxx";
        }).forEach(System.out::println);
    }

    private static void joining() {
        // String 才能做
        // 全部連起來
        System.out.println(Stream.of("xxx", "ooo", "ooo").collect(Collectors.joining()));
        System.out.println(String.join("", "xxx", "ooo", "ooo"));

        // 用什麼隔開
        System.out.println(Stream.of("xxx", "ooo", "ooo").collect(Collectors.joining("#####")));
        System.out.println(String.join("#####", "xxx", "ooo", "ooo"));

        // 用什麼隔開後，前綴和後綴是什，前後綴不能只加其中一個
        System.out.println(Stream.of("xxx", "ooo", "ooo").collect(Collectors.joining("#####", "^", "$")));
    }

    private static void count() {
        long count = Stream.of(1, 2, 3).count();
        System.out.println("count=" + count);

        // JAVA 9 以上(包括9)，peek 和 count 連用時，peek 不生效，這是 9 的優化(如果可以從 Stream 中計算 count，就不會執行 peek)
        // 如果要強制使 peek 有作用，可用 filter 或其他終端操作，如 collect
        long rtn = Stream.of("a", "b", "c").peek(System.out::println).count();
        System.out.println("rtn=" + rtn);
        Stream.of("a", "b", "c").filter(i -> true).peek(System.out::println).count(); // peek 會執行
    }

    private static void collect() {
        // collect 將搜集的資料變成集合
        List<String> list = Stream.of("xxx", "ooo", "ooo").collect(Collectors.toList());
//        List<String> list = Stream.of("xxx", "ooo", "xox").toList();
        Set<String> set = Stream.of("xxx", "ooo", "ooo").collect(Collectors.toSet());
        // 注意轉成 map 時，key 一樣會報錯
        Map<String, String> map = Stream.of("xxx", "ooo", "ooo").collect(Collectors.toMap(d ->
                d + new Random().nextInt(10), Function.identity()));

        System.out.println("list ==> " + list);
        System.out.println("set ==> " + set);
        System.out.println("map ==> " + map);
    }
}
