package modifier;

public class ModifierTest {
    public void publicMethod() {
    }

    protected void protectedMethod() {
    }

    void defaultMethod() {
    }

    private void privateMethod() {
    }

    private static class InnerClass {
        public static void main(String[] args) {
            new ModifierTest().privateMethod(); // 內部類別可以調用到 private
        }
    }

    private void method() {
        class MethodClass {
            public static void main(String[] args) {
                new ModifierTest().privateMethod(); // 方法類別可以調用到 private
            }
        }
    }
}

class NextClass {
    public static void main(String[] args) {
//         new ModifierTest().test4(); // 相鄰類別調用不到 private
    }
}
