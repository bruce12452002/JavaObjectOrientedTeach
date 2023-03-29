package exception;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 父類別                         Throwable
 * |                        /                   \
 * 子類別          Error                           Exception
 * |            /       \                      /                \
 * OutOfMemoryError     IOError         IOException         RuntimeException
 * |                                        |                       |
 * 重要類別                         FileNotFoundException   NullPointerException
 * <p>
 * Error 是程式無法解決的，Exception 可用程式解決
 * RuntimeException 以下的類別可以不用 try，像 1/0 這種小心一點就能避免的錯
 * Exception 子類別非 RuntimeException 類別的，又叫 checked exception
 */
public class ExceptionTest {
    public static void main(String[] args) {
        // try 不可單獨存在，要配合 catch 或 finally，或者三個都有；catch 可多個或整成一個
        // catch 補獲例外； finally 不管怎麼樣都會執行，甚至有 return，它也會執行
        basicCatch();
        multiCatch();
        combineCatch();
        tryFinally();
        tryWithResource();
    }

    private static void basicCatch() {
        try {
            System.out.println(1 / 0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("basicCatch" + e.getMessage());
        }
    }

    /**
     * catch 多個時，如果有父子關係，子類要寫在前面
     */
    private static void multiCatch() {
        try {
            System.out.println(1 / 0);
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("multiCatch ArithmeticException");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("multiCatch Exception");
        }

        // instanceof
//        try {
//            System.out.println(1 / 0);
//        } catch (Exception e) {
//            if (e instanceof ArithmeticException) {
//                System.out.println("multiCatch ArithmeticException");
//            }
//            if (e instanceof Exception) {
//                System.out.println("multiCatch Exception");
//            }
//        }
    }

    /**
     * 使用 | 時，不可有父子關係
     */
    private static void combineCatch() {
        try {
            System.out.println(1 / 0);
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("tryCatch wrong!" + e.getMessage());
        }
    }

    /**
     * 不管有沒有例外，finally 都會執行
     */
    private static void tryFinally() {
        try {
            System.out.println(1 / 0);
        } finally {
            System.out.println("tryFinally wrong!");
        }
    }

    /**
     * try 後面多個 ()，裡面只能放有繼承 AutoCloseable，然後會自動執行完後，調用 close 方法
     */
    private static void tryWithResource() {
        try (
                FileReader fileReader = new FileReader("test.txt");
                BufferedReader br = new BufferedReader(fileReader)

                // BufferedReader br = new BufferedReader(new FileReader("test.txt"))
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Line =>" + line);
            }
        } catch (IOException e) {
            System.out.println("IOException=" + e.getMessage());
        }
    }
}
