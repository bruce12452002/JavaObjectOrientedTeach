package base;

import java.util.ArrayList;
import java.util.List;

/**
 * 基本資料型態是 CallByValue
 */
public class CallByAddress {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(list);
//        xxx(list);
        ooo(list);
        System.out.println(list);

//        pointerTest();
    }

    public static void xxx(List<String> a) {
        a.add("a1");
    }

    /**
     * 受影響的只在 new 或者 = null 之前，之後自己是獨立的
     */
    public static void ooo(List<String> a) {
        a.add("a1");
        a.add("a2");

        // a = null;
        a = new ArrayList<>();
        a.add("a3");
        a.add("a4");
        System.out.println("in" + a);
    }

    private static void pointerTest() {
        List<String> list = new ArrayList<>();
        System.out.println(list);
        xxx(list);
        System.out.println(list);

        List<String> list2 = list; // list 等同 list2
        list2.add("a2");
        System.out.println(list);
        System.out.println(list2);

        list = null; // null 賦值給 list，並不會影響 list2
        System.out.println(list);
        System.out.println(list2);
    }
}
