import java.util.ArrayList;
import java.util.List;

public class FinalTest {
    public static void main(String[] args) {
        // final with field
        final String s = "xxx";
//        s = "aaa";

        System.out.println(s.concat("ooo"));
        System.out.println(s);

        final List<Integer> list = new ArrayList<>();
        list.add(5);
        System.out.println(list);
    }

    /**
     * final with class
     */
    private /*final */ class Father {
        final void m1() {
        }
    }

    private class Me extends Father {
        /**
         * final with method
         */
//        @Override
//        public void m1() {
//
//        }
    }
}
