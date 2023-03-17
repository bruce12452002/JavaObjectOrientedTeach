public class InstantStaticTest {
    static int i = 5;
    int j = 6;

    static void staticMethod() {
        // nonStaticMethod(); // static 不可調用 non-static
    }

    void nonStaticMethod() {
        staticMethod();
    }

    public static void main(String[] args) {
        System.out.println("非靜態測試");
        InstantStaticTest nonStaticField1 = new InstantStaticTest();
        nonStaticField1.j = 7;
        InstantStaticTest nonStaticField2 = new InstantStaticTest();
        System.out.println(nonStaticField1.j + ":" + nonStaticField2.j); // 7:6

        System.out.println("靜態測試");
        InstantStaticTest staticField1 = new InstantStaticTest();
        staticField1.i = 55;
        InstantStaticTest staticField2 = new InstantStaticTest();
        System.out.println(staticField1.i + ":" + staticField2.i); // 55:55
        // 建議使用 StaticTest.i;
    }
}
