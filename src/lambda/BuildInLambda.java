package lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BuildInLambda {
    public static void main(String[] args) {
        Supplier<String> f1a = () -> "ooo";
        Supplier<Integer> f1b = () -> 2;

        Consumer<String> f2 = s -> System.out.println("xxx" + s);

        Function<Integer, String> f3 = i -> i + "xxx";

        // Predicate：一個參數，回傳 boolean
        // BiXxx 兩個參數
        // Unary 參數和回傳值是相同的型態，只有一個參數
        // Binary 參數和回傳值是相同的型態，但有兩個參數

    }
}
