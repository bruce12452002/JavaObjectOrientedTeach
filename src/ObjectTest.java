public class ObjectTest {
    public static void main(String[] args) {
        new Object();

        // hashCode()
        // equals ==
        // clone() shallow copy、deep copy
        // toString() 印出物件時，不用顯示的寫 toString() 就會調用這個方法，如果都沒覆寫，最後就會調用 Object 的 toString()
    }

    private static class CloneTest implements Cloneable { // 想使用 clone()，必需要實作這個介面

        @Override
        public CloneTest clone() {
            try {
                return (CloneTest) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }
}
