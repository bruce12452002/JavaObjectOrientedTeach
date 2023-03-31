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
//        collect();
//        count();
        joining();
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
