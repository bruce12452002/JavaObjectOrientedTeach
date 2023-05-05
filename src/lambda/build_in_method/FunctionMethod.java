package lambda.build_in_method;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class FunctionMethod {
    private static final Function<Integer, Integer> F1 = i -> i * 2;
    private static final Function<Integer, Integer> F2 = i -> i * i;
    private static final Function<Integer, Integer> F3 = i -> i + 5;

    private static final UnaryOperator<Integer> U1 = i -> i * 2;
    private static final UnaryOperator<Integer> U2 = i -> i * i;
    private static final UnaryOperator<Integer> U3 = i -> i + 5;

    public static void main(String[] args) {
//        final int i = 5;
//        functionAndThen(i);
//        functionCompose(i);
//        unaryOperatorAndThen(i);
//        unaryOperatorCompose(i);

        identityTest();
    }

    private static void functionAndThen(final int data) {
        // 前 -> 後
        System.out.println(F1.andThen(F2).andThen(F3).apply(data)); // 105
        System.out.println(F2.andThen(F1).andThen(F3).apply(data)); // 55
    }

    private static void functionCompose(final int data) {
        // 後 -> 前
        System.out.println(F1.compose(F2).compose(F3).apply(data)); // 200
        System.out.println(F2.compose(F1).compose(F3).apply(data)); // 400
    }

    private static void unaryOperatorAndThen(final int data) {
        System.out.println(U1.andThen(U2).andThen(U3).apply(data)); // 105
        System.out.println(U2.andThen(U1).andThen(U3).apply(data)); // 55
    }

    private static void unaryOperatorCompose(final int data) {
        System.out.println(U1.compose(U2).compose(U3).apply(data)); // 200
        System.out.println(U2.compose(U1).compose(U3).apply(data)); // 400
    }

    private static void identityTest() {
        List<String> list = List.of("a", "b", "c");
        Map<String, String> map = list.stream().collect(Collectors.toMap(k -> k + k, Function.identity()));
        System.out.println(map);
    }
}
