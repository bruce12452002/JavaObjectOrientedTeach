package modifier;

public class ProtectedTest extends ModifierTest {
    public static void main(String[] args) {
        new ModifierTest().publicMethod();
        new ModifierTest().protectedMethod();
        new ProtectedTest().protectedMethod();

        new ModifierTest().defaultMethod();
    }
}
