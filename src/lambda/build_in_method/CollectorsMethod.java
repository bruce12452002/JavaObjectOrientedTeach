package lambda.build_in_method;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsMethod {
    private static final List<Integer> LIST = List.of(1, 2, 3, 4);

    public static void main(String[] args) {
//        counting();
//        joining();
//        averagingXxx();
//        collectingAndThen();
//        maxByAndMinBy();
//        summingXxx();
//        summarizingXxx();
//        mapping();
//        flatMapping();
//        groupingBy();
//        filtering();
//        partitioningBy();
//        reducing();
        teeing();

        // TODO
//        Collectors.toConcurrentMap();
//        Collectors.toUnmodifiableMap();
    }

    private static void counting() {
        System.out.println(LIST.stream().collect(Collectors.counting()));
        System.out.println(LIST.stream().count());
        System.out.println((long) LIST.size());
    }

    private static void joining() {
        List<String> list = List.of("a", "b", "c", "d");
        System.out.println(list.stream().collect(Collectors.joining()));
//        System.out.println(String.join("", list));

        System.out.println(list.stream().collect(Collectors.joining("|")));
//        System.out.println(String.join("|", list));

        System.out.println(list.stream().collect(Collectors.joining("|", "###", "***")));
    }

    private static void averagingXxx() {
        // 回傳值都是 Double，底層的 Collector<T, ?, Double>，固定都是 Double
        Double collect = LIST.stream().collect(Collectors.averagingInt(i -> i));
        System.out.println(collect);
        System.out.println(collect.intValue());
        System.out.println(LIST.stream().collect(Collectors.averagingLong(l -> l)));
        System.out.println(LIST.stream().collect(Collectors.averagingDouble(d -> d)));
    }

    /**
     * 第一個參數全部都運算完(and)才會到第二個參數(then)
     * <p>
     * 首先 1,2,3,4 經過 data*2 會變成 2,4,6,8
     * 然後加總除個數為 20/4 = 5.0
     * 最後 d*d = 25.0
     */
    private static void collectingAndThen() {
        Double collect = LIST.stream().collect(Collectors.collectingAndThen(
                Collectors.averagingDouble(data -> data * 2),
                d -> d * d
        ));
        System.out.println(collect);
    }

    private static void maxByAndMinBy() {
        System.out.println(LIST.stream().collect(Collectors.maxBy(Integer::compare)).get());
        System.out.println(LIST.stream().max(Integer::compare).get());

        System.out.println(LIST.stream().collect(Collectors.minBy(Integer::compare)).get());
        System.out.println(LIST.stream().min(Integer::compare).get());
    }

    private static void summingXxx() {
        System.out.println(LIST.stream().collect(Collectors.summingInt(i -> i)));
        System.out.println((Integer) LIST.stream().mapToInt(i -> i).sum());

        System.out.println(LIST.stream().collect(Collectors.summingLong(l -> l)));
        System.out.println((Long) LIST.stream().mapToLong(l -> l).sum());

        System.out.println(LIST.stream().collect(Collectors.summingDouble(d -> d)));
        System.out.println((Double) LIST.stream().mapToDouble(d -> d).sum());
    }

    private static void summarizingXxx() {
        IntSummaryStatistics summaryInt = LIST.stream().collect(Collectors.summarizingInt(i -> i));
        LongSummaryStatistics summaryLong = LIST.stream().collect(Collectors.summarizingLong(l -> l));
        DoubleSummaryStatistics summaryDouble = LIST.stream().collect(Collectors.summarizingDouble(d -> d));

        IntSummaryStatistics summaryInt2 = Stream.of(5, 6, 7).collect(Collectors.summarizingInt(i -> i));
        summaryInt.combine(summaryInt2);
        System.out.println(summaryInt.getSum());
        System.out.println(summaryInt2.getSum()); // 不影響 summaryInt2
    }

    private static void mapping() {
        List<String> list = List.of("a", "b", "c", "d");
        System.out.println(list.stream().collect(
                Collectors.mapping(Function.identity(),
                        Collectors.joining(","))));

        System.out.println(list.stream().map(Function.identity())
                .collect(Collectors.joining(",")));

        List<Student> students = Student.getStudents();
        System.out.println(students.stream().collect(
                Collectors.mapping(Student::getName, Collectors.joining(","))));

        System.out.println(students.stream().map(Student::getName)
                .collect(Collectors.joining(",")));
    }

    private static void flatMapping() {
        Map<Integer, List<Integer>> map = Stream.of(LIST, List.of(5, 6, 7, 8)).collect(
                Collectors.groupingBy(Collection::size,
                        Collectors.flatMapping(
                                l -> l.stream().filter(i -> i % 2 == 0),
                                Collectors.toList())
                ));
        System.out.println(map);
    }

    private static void groupingBy() {
        List<Student> students = List.of(
                new Student(1, "monkey", "男"),
                new Student(2, "monkey", "女"),
                new Student(3, "dog", "男"),
                new Student(4, "dog", "男")
        );
        System.out.println("===== 一個參數 =====");
        Map<String, List<Student>> map1 = students.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(map1);

        System.out.println("===== 兩個參數 =====");
        Map<String, String> map2 = students.stream().collect(Collectors.groupingBy(
                Student::getName,
                Collectors.mapping(Student::getSex, Collectors.joining(",")))); // 預設是 Collectors.toList()
        System.out.println(map2);

        System.out.println("===== 三個參數 =====");
        Map<String, Map<String, List<Student>>> map3 = students.stream().collect(Collectors.groupingBy(
                Student::getName,
                TreeMap::new, // 預設是 HashMap
                Collectors.groupingBy(Student::getSex))); // 預設是 Collectors.toList()
        System.out.println(map3);
    }

    private static void filtering() {
        System.out.println(LIST.stream().collect(Collectors.filtering(i -> i % 2 == 0, Collectors.toList())));
    }

    private static void partitioningBy() {
        // 沒給第二個參數，預設為 Collectors.toList()
        Map<Boolean, List<Integer>> map1 = LIST.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));

        Map<Boolean, Set<Integer>> map2 = LIST.stream().collect(
                Collectors.partitioningBy(i -> i % 2 == 0, Collectors.toSet()));
        System.out.println(map1);
        System.out.println(map2);
    }

    private static void reducing() {
        System.out.println("===== 一個參數 =====");
        // 第一次，p2 - p1 的結果，放在下次的第二個參數
        // 第二次之後，p1 跑迴圈讓 p2 去減，再放在下一次的第二個參數
        System.out.println(LIST.stream().collect(Collectors.reducing((p1, p2) -> {
            System.out.println(p2 + "," + p1 + "=" + (p2 - p1));
            return p2 - p1;
        })));
        System.out.println(LIST.stream().reduce((p1, p2) -> p2 - p1).orElse(-1));

        System.out.println("===== 兩個參數 =====");
        // 第一次，p2 為 10，之後都和一個參數一樣
        System.out.println(LIST.stream().collect(Collectors.reducing(10, (p1, p2) -> {
            System.out.println(p2 + "," + p1 + "=" + (p2 - p1));
            return p2 - p1;
        })));
        System.out.println(LIST.stream().reduce(10, (p1, p2) -> p2 - p1));

        System.out.println("===== 三個參數 =====");
        // 三個參數時，中間多個轉換的操作
        System.out.println(LIST.stream().collect(Collectors.reducing("",
                x -> Integer.toString(x),
                (p1, p2) -> p1 + p2)));
        System.out.println(LIST.stream().map(x -> Integer.toString(x)).reduce("", (p1, p2) -> p1 + p2));

        System.out.println("===== 和 groupingBy 連用 =====");
        List<Student> students = List.of(
                new Student(1, "monkey", "男"),
                new Student(2, "monkey", "女"),
                new Student(3, "dog", "男"),
                new Student(4, "dog", "男")
        );
        Map<String, Optional<Student>> map = students.stream().collect(Collectors.groupingBy(
                Student::getName,
                Collectors.reducing(BinaryOperator.minBy(Comparator.comparing(Student::getId))))
        );

        map.forEach((k, v) -> System.out.println(k + "=" + v.get().getId()));
    }

    /**
     * Java 12
     */
    private static void teeing() {
        Double d = LIST.stream().collect(Collectors.teeing(
                Collectors.summingDouble(i -> i),
                Collectors.counting(),
                (sum, n) -> sum / n));
        System.out.println(d);
    }
}
