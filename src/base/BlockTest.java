package base;

public class BlockTest {
    public static void main(String[] args) {
        // static block 只會執行一次； block 每 new 一次就會執行一次
        // new BlockTest();  // 這行註解，static block 也會執行
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
