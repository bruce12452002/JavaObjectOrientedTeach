public class InheritTest extends AbstractTest implements InterfaceTest {
    @Override
    public void method1() {
        InterfaceTest.super.method1();
    }

    @Override
    public void mm() {

    }

    @Override
    protected String m1() { // InterfaceTest 如果也有 m1 方法且也是沒參數，會報錯
        return null;
    }


    @Override
    public String m2() {
        return null;
    }
}
