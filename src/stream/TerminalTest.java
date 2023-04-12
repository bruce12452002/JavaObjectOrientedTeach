package stream;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalTest {
    public static void main(String[] args) {
//        process();
//        joining();
//        count();
//        collect();
//        foreachOrdered();
//        minAndMax();
        statistics();
//        reduce();
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

    private static void foreachOrdered() {
        // 多執行緒時，兩者才有差別
        Stream.of(138, 785, 8, 81, 1, 99, 888).parallel().forEachOrdered(System.out::println);
        System.out.println("===============");
        Stream.of(138, 785, 8, 81, 1, 99, 888).parallel().forEach(System.out::println);
    }

    private static void minAndMax() {
        Optional<Integer> min = Stream.of(1, 2, 3, 4, 5).min(Comparator.comparing(p -> p));
        Optional<Integer> max = Stream.of(1, 2, 3, 4, 5).max(Comparator.comparing(p -> p));
        System.out.println(min.get());
        System.out.println(max.get());
    }

    private static void statistics() {
        IntSummaryStatistics result = Stream.of(1, 2, 3, 4, 5).mapToInt(i -> i).summaryStatistics();
        System.out.println("最大值=" + result.getMax());
        System.out.println("最小值=" + result.getMin());
        System.out.println("加總=" + result.getSum());
        System.out.println("幾個元素=" + result.getCount());
        System.out.println("平均值=" + result.getAverage());
    }

    private static void reduce() {
        // 一個參數 (p1 為第一次或累加的值；p2 為第二個值之後每次循環的值，所以如果有 5 個值，會跑 4 圈)
        Optional<Integer> rtn1 = Stream.of(1, 2, 3, 4, 5).reduce((p1, p2) -> {
            System.out.println("p1=" + p1 + ",p2=" + p2);
            return p1 + p2;
        });
        System.out.println(rtn1.get());

        // 兩個參數 (第一個參數為初始值，第二個參數和一個參數一樣)
        Integer rtn2 = Stream.of(1, 2, 3, 4, 5).reduce(10, (p1, p2) -> {
            System.out.println("p1=" + p1 + ",p2=" + p2);
            return p1 + p2;
        });
        System.out.println(rtn2);

        System.out.println("=============== 多線程 ===============");
        Optional<Integer> rtnA = Stream.of(1, 2, 3, 4, 5).parallel().reduce((p1, p2) -> {
            System.out.println("p1=" + p1 + ",p2=" + p2);
            return p1 + p2;
        });
        System.out.println(rtnA.get());

        // 兩個參數 (第一個參數為初始值，第二個參數和一個參數一樣)
        // 多線程時，每次都會加初始值
        Integer rtnB = Stream.of(1, 2, 3, 4, 5).parallel().reduce(10, (p1, p2) -> {
            System.out.println("p1=" + p1 + ",p2=" + p2);
            return p1 + p2;
        });
        System.out.println(rtnB);

        // 第三個參數只有在多執行緒才會跑，如果不用多執行緒，那和兩個參數一樣
        // 多執行緒時，前兩個參數每個迴圈都是一個執行緒，第三個參數用來合併多執行緒計算的結果
        // 三個參數 (前兩個參數和之前一樣，最後的參數是 BinaryOperator「給兩個參數回傳一個值，這三個類型都必需一樣」)
        Integer rtnC = Stream.of(1, 2, 3, 4, 5).parallel().reduce(0, (p1, p2) -> {
            System.out.println("p1=" + p1 + ",p2=" + p2);
            return p1 + p2;
        }, (p1, p2) -> {
            System.out.println("p3_1=" + p1 + ",p3_2=" + p2);
            return p1 * p2;
        });
        System.out.println(rtnC);
    }
}
