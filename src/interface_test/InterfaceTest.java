package interface_test;

/**
 * default 和 static 是 java8 之後才有的，且都要實作
 * 可以使用 main 方法
 * 沒有預設建構子，但可以 new，只不過後面要加花括號和分號
 * 沒有 block、static block
 * default 有多繼承問題，且可以向建構子一樣，使用 this 和 super
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
