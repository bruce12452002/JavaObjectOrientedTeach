/**
 * 有預設建構子
 */
public abstract class AbstractTest {
    public int id = 5;
    public static String str;

    void method1() {

    }

    static void method2() {
    }

    protected abstract String m1(); // static 和 abstract 不可同時出現

}
