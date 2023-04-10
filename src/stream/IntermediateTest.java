package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateTest {
    public static void main(String[] args) {
//        filterAndMap();
//        flatMapAndMap();
        distinct();
    }

    /**
     * filter：判斷是否要繼續執行
     * map：型態轉換或內容變化(如變大小寫或每個元素+10)
     */
    private static void filterAndMap() {
        Stream.of(1, 2, 3).filter(i -> i >= 2).map(i -> i + "xxx").forEach(System.out::println);
    }

    /**
     * 回傳如果有多層的 Stream，flatmap 只有一層，類似 List 裡的 add 和 addAll
     */
    private static void flatMapAndMap() {
        // 使用 map
        Stream<Stream<String>> stream1 = Stream.of("a1", "b2", "c3").map(IntermediateTest::toStream);
        stream1.forEach(stream -> stream.forEach(System.out::println));

        // 使用 flatMap
        Stream<String> stream2 = Stream.of("a1", "b2", "c3").flatMap(IntermediateTest::toStream);
        stream2.forEach(System.out::println);
    }

    private static void distinct() { // 必需覆寫 hashcode 和 equals，但 String 已經實作了
        Stream.of("a1", "b2", "c3", "b2").distinct().forEach(System.out::println);
    }

    private static Stream<String> toStream(String s) {
        List<String> l = new ArrayList<>();
        l.add(s.substring(0, 1));
        return l.stream();
    }
}
