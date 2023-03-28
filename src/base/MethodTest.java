package base;

public class MethodTest {
    /**
     * 修飾子 [靜態 final] [泛型] 回傳值 方法名稱(參數){}
     */
    public static void main(String[] args) {

    }

    String get(int i) {
        return i + "";
    }

    private void xxx() {
        return; // 預設最後一行就有 return
    }

    public void ooo(int... i) { // ...只能在最後一個參數，例：加法取總

    }
}
