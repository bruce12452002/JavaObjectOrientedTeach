package lambda.build_in_method;

import java.util.*;
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
        groupingBy();

        // TODO
//        Collectors.filtering();
//        Collectors.flatMapping();
//        Collectors.partitioningBy();
//        Collectors.reducing();
//        Collectors.teeing(); java12
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

    private static void groupingBy() {
        List<Student> students = List.of(
                new Student(1, "monkey", "男"),
                new Student(2, "monkey", "女"),
                new Student(3, "dog", "男"),
                new Student(4, "dog", "男")
        );
        Map<String, List<Student>> map1 = students.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(map1);

        Map<String, String> map2 = students.stream().collect(Collectors.groupingBy(
                Student::getName,
                Collectors.mapping(Student::getSex, Collectors.joining(",")))); // 預設是 Collectors.toList()
        System.out.println(map2);

        Map<String, Map<String, List<Student>>> map3 = students.stream().collect(Collectors.groupingBy(
                Student::getName,
                TreeMap::new, // 預設是 HashMap
                Collectors.groupingBy(Student::getSex))); // 預設是 Collectors.toList()
        System.out.println(map3);
    }

}
