package clazz;

public class MethodClass {
    int i = 5;

    public static void main(String[] args) {
        method();
    }

    private static void method() {
        int i = 10;
        class M { // 方法類別不可有修飾子
            public void getI() {
                System.out.println(i);
            }
        }
        new M().getI();
    }
}
