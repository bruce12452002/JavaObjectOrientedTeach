package interface_test;

/**
 * default 和 static 是 java8 之後才有的，且都要實作，都有隱含的 public
 * 可以使用 main 方法
 * 沒有預設建構子，但可以 new，只不過後面要加花括號和分號
 * 沒有 block、static block
 * default 有多繼承問題，且可以向建構子一樣，使用 this，而 super 可解決多繼承問題
 */
public interface InterfaceTest {
    int id = 5; // public static final

    default void method1() {

    }

    default String method2(int i) {
        return "i=" + i;
    }

    static void get() {

    }

    static int getId() {
        return id;
    }

    void mm(); // public abstract，正常方法不可實作

//     void m1(); // public abstract，正常方法不可實作

    String m2();

    /**
     * java 9(含)以上，可以在 interface 裡寫 private 實作方法，也可以是 overloading
     */
    private void privateMethod() {
    }

    private void privateMethod(String s) {
    }
}
