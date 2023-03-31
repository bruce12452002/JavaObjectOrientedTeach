package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream 設計時，是要像個水龍頭一樣，從初始之後，經過0~多個中間操作，最後是結束操作或短路終止操作
 * 如果沒有結束操作是不會執行的，方法是中間操作還終止操作要看 API 或看源碼註釋
 * <p>
 * intermediate 中間操作
 * terminal 終止操作
 * short-circuiting terminal 短路終止操作，表示提前結束的操作，如 XxxMatch()、findXxx()
 * 例：findFirst() 找到第一個即結束，所以是短路終止操作
 */
public class StreamInitTest {
    public static void main(String[] args) {
        "abcde".chars().forEach(System.out::println);

        // List 取得 Stream
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream(); // 順序
        Stream<String> parallelStream = list.parallelStream(); // 並行，速度較順序快

        // Arrays 取得 Stream
        Stream<Integer> arraysStream = Arrays.stream(new Integer[10]);

        // Stream 本身取得 Stream
        Stream<Integer> streamOf = Stream.of(1, 2, 3, 4, 5, 6);

        // 無窮的 Stream
        Stream<Integer> streamIterate = Stream.iterate(0, x -> x + 2).limit(5);
        streamIterate.forEach(System.out::println);

        // 無窮的 Stream
        Stream<Double> streamGenerate = Stream.generate(Math::random).limit(3);
        streamGenerate.forEach(System.out::println);

        // of
        Stream<String> st = Stream.of("xxx", "ooo", "xox");
    }
}
