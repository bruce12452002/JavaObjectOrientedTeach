public class BlockTest {
    public static void main(String[] args) {
        new BlockTest();
    }

    public BlockTest() {
        System.out.println("haha");
    }

    {
        System.out.println("non-static 1");
    }

    static {
        System.out.println("static 1");
    }

    {
        System.out.println("non-static 2");
    }

    static {
        System.out.println("static 2");
    }
}
