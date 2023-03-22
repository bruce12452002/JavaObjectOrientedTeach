public class ClassThisTest {
    private int id;

    public static void main(String[] args) {
        new ClassThisTest().xxx();
    }

    private void xxx() {
        ClassThisTest t1 = ClassThisTest.this;
        System.out.println(t1.id);
        t1.id = 8;
        ClassThisTest t2 = ClassThisTest.this;
        System.out.println(t1.id);
        System.out.println(t2.id);
    }
}
