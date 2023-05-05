package lambda.build_in_method;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateMethod {
    public static void main(String[] args) {
        Predicate<Integer> p = Objects::nonNull;

        // default method： and、or、negate
        System.out.println(p.and(i -> i != 0).and(i -> i > 5).test(8)); // true
        Predicate<Integer> or = p.or(i -> i != 0);
        System.out.println(or.test(0)); // true
        System.out.println(or.negate().test(0)); // false, negate 是取反的意思

        // static method： isEqual、not(比較兩個 Predicate 並取反)
        System.out.println(Predicate.isEqual(10).test(10)); // true
        Predicate<Integer> p2 = i -> i == 10;
        System.out.println(Predicate.not(p2).test(10)); // false
    }
}
