package reflection;

import java.lang.reflect.InvocationTargetException;

public class GetInstance {
    int id;
    String name;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> c = Class.forName("reflection.GetInstance");
//        GetInstance g = (GetInstance) c.newInstance(); // JAVA 9 已過時
        GetInstance g = (GetInstance) c.getDeclaredConstructor().newInstance(); // 如果有預設建構子可用這行
        GetInstance g2 = (GetInstance) c.getDeclaredConstructor(int.class, String.class).newInstance(222, "sheep");
        g.id = 111;
        g.name = "monkey";
        System.out.println(g.id + "=" + g.name);
        System.out.println(g2.id + "=" + g2.name);
    }

    GetInstance() {
    }

    GetInstance(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
