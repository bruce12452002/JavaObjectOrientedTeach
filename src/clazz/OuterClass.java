package clazz;

public class OuterClass {
    // Instantiation of utility class 'OuterClass'
    // new class 時，沒有變數、方法或者只有靜態的變數、方法，idea 認為不需要 new 出來，所以報了警告
    // 只要在類別裡增加一般變數、方法即可
    private int i;

    public class InnerClass1 {
    }

    protected class InnerClass2 {
    }

    class InnerClass3 {
    }

    private class InnerClass4 {
    }

    public static void main(String[] args) {
        new OuterClass().new InnerClass1();
        new OuterClass().new InnerClass2();
        new OuterClass().new InnerClass3();
        new OuterClass().new InnerClass4();

        new OuterClass.InnerClass5();
        new OuterClass.InnerClass6();
        new OuterClass.InnerClass7();
        new OuterClass.InnerClass8();
    }

    public static class InnerClass5 {
    }

    protected static class InnerClass6 {
    }

    static class InnerClass7 {
    }

    private static class InnerClass8 {
    }
}
