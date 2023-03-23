public class ClassThisTest {
    private int id;

    public static void main(String[] args) {
        new ClassThisTest().xxx();

//        ClassThisTest ooo = new ClassThisTest().ooo();
//        System.out.println(ooo.id);
//        ooo.abc();

    }

    class Son {
        public void xxxx() {
            Son son = this;
            ClassThisTest classThisTest = ClassThisTest.this;
        }
    }

    /**
     * enclosing class：表示內外部類別，所以只有在內外部類別寫才不會編譯錯誤(和繼承無關)，且內部類別可用外部類別； 相反則不行
     * <p>
     * className.this，因為有 this，所以不能寫在 static 裡
     * this 想成是其中一個實體就好理解了
     * <p>
     * 寫 this 代表這個類別，所以在自己的類別寫自己的類別名稱.this 就是 this
     * 但有可能是在內部類別裡要用到外部類別，所以用了外部類別名稱.this
     */
    private void xxx() {
        ClassThisTest t1 = ClassThisTest.this;
        System.out.println(t1.id);  // 0
        t1.id = 8;
        ClassThisTest t2 = ClassThisTest.this;
        System.out.println(t1.id); // 8
        System.out.println(t2.id); // 8

        ClassThisTest t3 = this;
        System.out.println(t3.id); // 8
        System.out.println(this.id); // 8

        ClassThisTest t4 = new ClassThisTest();
        System.out.println(t4.id); // 0
    }

    private ClassThisTest ooo() {
        ClassThisTest c = ClassThisTest.this;
        c.id = 999;
        return c;
    }

    private void abc() {
        ClassThisTest c = ClassThisTest.this;
        System.out.println(c.id);
    }

}
