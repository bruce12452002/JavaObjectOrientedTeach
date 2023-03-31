package method_reference;

import java.util.function.BiFunction;

/**
 * 為 instance 和 static 的綜合體
 * instance 要有特定順序就可以用這種
 */
public class ArbitraryTest {
    public static void main(String[] args) {
        // 如果使用第一個參數去點方法，然後第二個之後的參數按照順序放在方法的參數裡，就可以使用 method reference
        BiFunction<String, Integer, String> f1 = (s, i) -> s.substring(i);
        System.out.println(f1.apply("0123456789", 4));

        // 第一個參數就是自己
        BiFunction<String, Integer, String> f2 = String::substring;
        System.out.println(f2.apply("0123456789", 4));
    }
}
