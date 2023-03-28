package constructor;

/**
 * 建構子名稱和類別名稱相同且沒有回傳值，連 void 也沒有
 */
public class ConstructorTest extends ConstructorPapaTest {
    public void ConstructorTest() { // 因為有回傳值 void，所以這個是方法，但方法名稱和類別名稱相同，所以會有警告
    }

    public ConstructorTest() { // 預設建構子，如果沒寫建構子就有這一組；有的話就消失了，除非顯示的寫出來
        super(); // 建構子裡 this 和 super 只能寫其一
        // this("");
        return; // return 可省略
    }

    private ConstructorTest(String s) {
        this(s, 1);
//        this(""); // 建構子不可使用 recursive
    }

    public ConstructorTest(String s, int i) {
    }

}
