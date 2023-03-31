package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamInit {
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
    }
}
