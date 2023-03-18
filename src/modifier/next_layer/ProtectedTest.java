package modifier.next_layer;

import modifier.ModifierTest;

public class ProtectedTest extends ModifierTest {
    public static void main(String[] args) {
        new ModifierTest().publicMethod();
//        new ModifierTest().protectedMethod(); // 非父類裡，new 父類「不可」調用 protected
        new ProtectedTest().protectedMethod(); // 在子類裡，new 子類「可」調用 protected
//        new ModifierTest().defaultMethod();

    }
}
