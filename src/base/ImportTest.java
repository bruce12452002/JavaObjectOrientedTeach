package base;

import generic.GenericTest;

import static modifier.ModifierTest.getNumber;
import static modifier.ModifierTest.number;
import java.util.ArrayList;

public class ImportTest {
    public static void main(String[] args) {
        Integer i = 0; // 預設會 import java.lang
        System.out.println(Math.pow(2, 5)); // 靜態方法不需要 import
        new ArrayList<>(); // 使用 java 內鍵的類別
        new MethodTest().get(4); // 同包不需 import
        new GenericTest(); // 不同包要 import

        // 如果是靜態，可以用 import static
        System.out.println(number);
        System.out.println(getNumber());
    }
}

