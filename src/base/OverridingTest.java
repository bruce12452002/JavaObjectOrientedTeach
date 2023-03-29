package base;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverridingTest {

}

class A {
}

class B extends A {
}

class C extends B {
}

abstract class Papa {
    public abstract A a1(A a) throws IOException;

    protected abstract B a2(B b);

    abstract C a3(C c);
    // private abstract void a4();
}

/**
 * public -> protected -> 空
 * 覆寫時，修飾子可以一樣或更大
 * 回傳值可以是子類別
 * 參數不可是子類別(好嚴格啊)
 * 如果有 throws 都可以不寫，如果要寫只能是 throws 的子類別或一樣
 *
 * @Override 表示此方法是覆寫方法
 */
class Me extends Papa {

    @Override
    public A a1(A a) throws FileNotFoundException {
        return null;
    }

    @Override
    protected B a2(B b) {
        return null;
    }

    @Override
    C a3(C c) {
        return null;
    }
}
