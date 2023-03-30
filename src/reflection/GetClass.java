package reflection;

import java.math.BigDecimal;

/**
 * 取得 class
 */
public class GetClass {
    public static void main(String[] args) {
        System.out.println("1.使用Object物件的getClass()");
        Class<? extends BigDecimal> c1 = BigDecimal.ZERO.getClass();
        System.out.println(c1 + System.getProperty("line.separator"));

        System.out.println("2.使用.class");
        Class<Integer> c2a = int.class;
        Class<Integer> c2b = Integer.class;
        System.out.println(c2a);
        System.out.println(c2b + System.getProperty("line.separator"));

        System.out.println("3.使用Class.forName()");
        try {
            Class<?> c3 = Class.forName("java.util.List");
            System.out.println(c3 + System.getProperty("line.separator"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("4.Wrapper類別才有的TYPE");
        Class<Long> c4 = Long.TYPE;
        System.out.println(c4);

    }
}
