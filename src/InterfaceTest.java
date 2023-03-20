/**
 * default 和 static 是 java8 之後才有的，且都要實作
 * 沒有預設建構子
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
}
