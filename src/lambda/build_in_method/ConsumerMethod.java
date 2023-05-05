package lambda.build_in_method;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerMethod {
    public static void main(String[] args) {
        Consumer<Integer> c1 = System.out::println;
        Consumer<Integer> c2 = c -> System.out.println(c * c);
        Consumer<Integer> c3 = c -> System.out.println(c + 5);

        c1.andThen(c2).andThen(c3).accept(5);

//        splitWithAndThen();
    }

    private static void splitWithAndThen() {
        String[] arr = {"2020/05", "2020/06", "2020/07"};
        Consumer<String> c1 = m -> System.out.println("c1=" + m.split("/")[0]);
        Consumer<String> c2 = m -> System.out.println("c2=" + m.split("/")[1]);
        Arrays.stream(arr).forEach(a -> c1.andThen(c2).accept(a));
//        for (String a : arr) {
//            c1.andThen(c2).accept(a);
//        }
    }
}
