package stream;

import java.util.ArrayList;
import java.util.List;

public class ShortCircuitingTerminalTest {
    static List<String> animal = new ArrayList<>() {{
        add("elephant");
        add("dog");
        add("pig");
        add("rat");
        add("tiger");
        add("cat");
    }};

    public static void main(String[] args) {
        xxxMatch();
    }

    private static void xxxMatch() {
        if (animal.stream().allMatch(str -> str.contains("a"))) {
            System.out.println("全有a");
        }

        if (animal.stream().anyMatch(str -> str.contains("n"))) {
            System.out.println("其中一個以上有n");
        }

        if (animal.stream().noneMatch(str -> str.contains("A"))) {
            System.out.println("全部都沒有A");
        }
    }
}
