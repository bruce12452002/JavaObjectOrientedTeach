package method_reference;

import java.util.function.Function;

public class InstanceAndStaticTest {
    public static void main(String[] args) {
        Function<Integer, String> f1 = "0123456789"::substring;
        System.out.println(f1.apply(4));

        Function<Integer, String> f2 = String::valueOf;
        System.out.println(f2.apply(123456));
    }
}
