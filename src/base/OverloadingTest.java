package base;

/**
 * 一
 * 以 short 為例：
 * 順序如下：
 * short --> int --> Short --> Integer --> Object
 * int 並不會轉成 char；但 char 會轉成 int
 * <p>
 * 又以 Short 為例
 * 順序如下：
 * Short --> Object --> short --> int
 * <p>
 * 二
 * 強制呼叫 int 可以用  (int) new Integer(1)
 * <p>
 * 三
 * 如果給 null，必需剛好只有一個可接收 null 參數的方法，否則會編譯錯誤(ambiguous)
 * 但 Object 參數的方法是個例外，都找不到合適的參數時，會呼叫
 * 所以最多可以有兩個 overloading，Object 和 Wrapper
 * 如果想直接呼叫 Object 參數的方法，可用「(Object) null」，別懷疑，可以強轉的，這時不管有幾個 overloading 都可以了
 * 當然想要 (Integer) null 也是可以的
 * <p>
 * 以上總結：
 * 基本類型：基本類型(注意隱形轉換)-->Wrapper 類別-->Object
 * Wrapper 類型：Wrapper 類別-->Object-->基本型態(注意隱形轉換)
 */
public class OverloadingTest {
    public static void main(String[] args) {
        xxx(1);
        xxx(new Integer(1));
        xxx("String");
    }

    public static void xxx(Integer x) {
        System.out.println("Integer");
    }

    public static void xxx(int x) {
        System.out.println("int");
    }

    public static void xxx(Object x) {
        System.out.println("Object");
    }

    private static class TripleDotTest {
        public static void main(String[] args) {
            xxx("", "", ""); // 以全部找到為主，都沒有才會找 ...
        }

        public static void xxx() {
        }

        public static void xxx(String... s) {
        }

//        public static void xxx(String[] s) {  // 陣列和 ... 只能擇其一； 陣列一定要傳值，... 可不傳
//        }

        public static void xxx(String s) {
        }


        public static void xxx(String s1, String s2) {
        }
    }
}
