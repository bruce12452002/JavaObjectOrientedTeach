public class SameNameTest {
    int i = 5;

    public static void main(String[] args) {
        new SameNameTest().xxx();
    }

    private void xxx() {
//        int i = 6;
        System.out.println(i);
    }
}
