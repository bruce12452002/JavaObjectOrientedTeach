package inherit;

/**
 * extends 最多能一個
 * implements 可以多個
 * 就算都沒有寫，至少也有一個父類別 Object
 * <p>
 * ※ 父類、父介面必需有 package 才能被繼承或實作，如果沒有 package，只能被沒 package 繼承或實作
 */
public class InheritTest extends Ab implements Ia, Ib {
    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    void m3() {

    }
}

interface Ia {
    void m1();
}

interface Ib {
    void m2();
}

abstract class Ab {
    abstract void m3();

    void m4() {

    }
}
