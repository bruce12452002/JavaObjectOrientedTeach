package enumerate;

import java.util.stream.Stream;

/**
 * 反編譯工具下載路徑(JD-GUI)：https://github.com/java-decompiler
 */
public class EnumTest {
    public static final int ELEPHANT = 0; // 象棋
    public static final int JUMP = 1; // 跳棋
    public static final int LOOP = 2; // 圍棋

    public static void main(String[] args) {
//        getChess(EnumTest.ELEPHANT);
//        getChess(-1); // 傳負的也不會報錯
//        getChess(Chess.JUMP);
        Chess.getAllChess();

        Chess c = Chess.JUMP;
        System.out.println(c.name() + "-->" + c.id + "=" + c.name); // name() 是內鍵的，回傳自定義的字
        System.out.println(Chess.valueOf("LOOP".toUpperCase())); // 沒有會報錯，大小寫也必需一樣
        System.out.println(c.ordinal());
    }

    private static void getChess(int chess) {
    }

    private static void getChess(Chess chess) {
    }


//    enum Chess {
//        ELEPHANT, JUMP, LOOP;
//    }

    enum Chess {
        ELEPHANT(100, "象棋"), JUMP(101, "跳棋"), LOOP(102, "圍棋");

        private final int id;
        private final String name;

        Chess(int id, String name) {
            this.id = id;
            this.name = name;
        }

        static void getAllChess() {
            Stream.of(Chess.values()).forEach(System.out::println);
        }
    }
}
