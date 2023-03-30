package reflection;

import java.util.Arrays;

public class GetFields {
    private int id = 999;
    String name = "ooo";
    protected int num = 888;
    public String address = "xxx";

    private static int id2 = 999;
    static String name2 = "ooo";
    protected static int num2 = 888;
    public static String address2 = "xxx";

    public static void main(String[] args) {
        Class<GetFields> clazz = GetFields.class;
        Arrays.stream(clazz.getFields()).forEach(System.out::println);
        System.out.println("====================");
        Arrays.stream(clazz.getDeclaredFields()).forEach(System.out::println);
    }
}
