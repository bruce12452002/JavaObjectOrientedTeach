package exception;

public class ThrowTest {
    public static void main(String[] args) {
        // NullPointerException 是 RuntimeException 的子類，可以不用 try-catch 包起來，但錯了還是不會繼續執行
        throwException();

        try {
            tt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void throwException() {
        throw new NullPointerException("yeah!");
    }

    private static void tt() throws Exception {
        throwsException(); // 如果不用 try-catch 包起來就要再 throws 出去
    }

    private static void throwsException() throws Exception {
        int[] arr = {1, 2, 3};
        arr[3] = 4;
    }

}
