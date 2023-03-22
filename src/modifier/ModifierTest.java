package modifier;

/**
 * 修飾子：表示誰可以調用我
 */
public class ModifierTest {
    public void publicMethod() { // 同個 project
    }

    /**
     * 1.同 default，且又多一個子類可調用
     * 2.非父類裡，new 父類「不可」調用 protected
     * 3.在「非」子類裡，new 子類「不可」調用 protected
     */
    protected void protectedMethod() {
    }

    void defaultMethod() { // 同個 package，不包括子 package
    }

    private void privateMethod() { // 同個 class，包括內部 class
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
//         new ModifierTest().privateMethod(); // 相鄰類別調用不到 private
    }
}
