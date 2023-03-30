package reflection;

import java.util.Arrays;

/**
 * getDeclaredConstructors： 調用所有建構子，不管修飾子是什麼
 * getConstructors： 只會調用修飾子是 public 的建構子
 */
public class GetConstructors {
    private GetConstructors(int id) {
    }

    GetConstructors(String name) {
    }

    protected GetConstructors(int id, String name) {
    }

    public GetConstructors() {
    }

    public static void main(String[] args) {
        Class<GetConstructors> clazz = GetConstructors.class;
        Arrays.stream(clazz.getConstructors()).forEach(System.out::println);
        System.out.println("====================");
        Arrays.stream(clazz.getDeclaredConstructors()).forEach(System.out::println);
    }
}
