package method_reference;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * MethodReference 有四種
 * 沒有什麼多行寫法
 *
 * https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
 */
public class NewTest {
    public static void main(String[] args) {
        Supplier<NewTest> supplier = NewTest::new;
        Function<Integer, NewTest> function = NewTest::new;
        BiFunction<Integer, String, NewTest> biFunction = NewTest::new;
    }

    NewTest() {
    }

    NewTest(int id) {
    }

    NewTest(int id, String name) {
    }
}
