package lambda;

/**
 * 一般都是調用方法後，就執行裡面的內容
 * lambda 是先給方法，然後在合適的時候再調用，也點像定時炸彈
 */
@FunctionalInterface // 只能剛好一個抽象方法，也就是非 default、static 的方法
public interface FunctionalInterfaceTest {
    String getString();

    static void main(String[] args) {
        // 使用匿名類別的方法，java 8 以前就有了
        FunctionalInterfaceTest f1 = new FunctionalInterfaceTest() {
            @Override
            public String getString() {
                return "xxx";
            }
        };

        // lambda
        FunctionalInterfaceTest f2 = () -> { // 沒參數，有一個 String 回傳值
            return "ooo";
        };
        System.out.println(f2.getString());

        // 省略寫法三之一
        // 如果只需要一行，就不用花括號，連 return 關鍵字也不能有(不管有沒有回傳值都不能寫)
        FunctionalInterfaceTest f3 = () -> "ooo";
    }
}

// @FunctionalInterface // 不寫也能用 lambda，類似 @Override
interface FunctionalInterfaceTest2 {
    void setString(String str, int id);

    static void main(String[] args) {
//        String str = "";
        FunctionalInterfaceTest2 f1 = (String str, int id) -> { // 變數名稱不可和外面同名
            System.out.println("yeah");
        };

        // 省略寫法三之二
        // 參數型態不管怎樣都可以省略，但要省略就全部參數都要省略，不能有些省略、有些不省略
        FunctionalInterfaceTest2 f2 = (str, id) -> System.out.println("yeah");
    }
}

@FunctionalInterface
interface FunctionalInterfaceTest3 {
    void setString(String str);

    static void main(String[] args) {
        FunctionalInterfaceTest3 f1 = (String str) -> {
            System.out.println("yeah");
        };

        // 省略寫法三之三
        // 如果只有一個參數，連圓括號也可省略
        FunctionalInterfaceTest3 f2 = str -> System.out.println("yeah");

        // 外部變數不可變
        int i = 88;
        FunctionalInterfaceTest3 f3 = (String str) -> {
            // i = 77; 讀取外面的變數時，只能是 final，但外面變數可以不寫 final
            System.out.println("yeah" + i);
        };
        // i = 99; 就算在 lambda 外面了，也不可以改變，相當於 i 有 final
    }
}
