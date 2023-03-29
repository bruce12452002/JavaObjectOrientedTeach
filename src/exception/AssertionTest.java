package exception;

/**
 * 在 VM Options 可設定參數
 * -enableassertions 或 -ea 可開啟 assert，預設是關閉的
 */
public class AssertionTest {
    public static void main(String[] args) {
        System.out.println("one");
        assert 6 < 0; // 如果有開啟 assertion，而且是 false，就不會往下執行
        System.out.println("two");
    }
}
