package modifier.next_layer;

import modifier.ModifierTest;

public class DefaultTest {
    public static void main(String[] args) {
        new ModifierTest().publicMethod();
        // new ModifierTest().protectedMethod(); // 同一層和子類別才調用的到
        // new ModifierTest().defaultMethod(); // 同一層才調用的到
    }
}
