package multi_inherit;

public class Java8Test implements I1, I2 {
    /**
     * 多繼承裡的父介面 default 方法名稱和參數一樣時，而且父介面沒有繼承關係，要自己實作
     */
    @Override
    public void f() {
        I1.super.f(); // 顯示調用某個父介面的方法
        I2.super.f(); // 顯示調用某個父介面的方法
    }

    public static void main(String[] args) {
        I1 i = new Java8Test();
        i.f();
    }
}

interface I1 {
    default void f() {
        System.out.println("I1 f()");
    }
}

interface I2 /*extends I1*/ {
    default void f() {
        System.out.println("I2 f()");
    }
}

interface I3 extends I2 {
    @Override
    void f(); // 將 I2 的 f 方法改成抽象，如果有類別實作 I3，只好再實作這個方法
}