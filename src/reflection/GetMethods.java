package reflection;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * getDeclaredMethods： 調用所有建構子，不管修飾子是什麼
 * getMethods： 只會調用修飾子是 public 的建構子
 */
public class GetMethods {
    // non-static
    private void privateMethod(int id) {
    }

    void defaultMethods(String name) {
    }

    protected void protectedMethods(int id, String name) {
    }

    public void publicMethods() {
    }

    // static
    @Deprecated
    private void privateStaticMethod(int id, int num) throws IOException {
    }

    static void defaultStaticMethods(String name) {
    }

    protected static void protectedStaticMethods(int id, String name) {
    }

    public static void publicStaticMethods() {
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<GetMethods> clazz = GetMethods.class;
        Arrays.stream(clazz.getMethods()).forEach(System.out::println);
        System.out.println("====================");
        Arrays.stream(clazz.getDeclaredMethods()).forEach(System.out::println);
        System.out.println("====================");
//        Method m = clazz.getMethod("privateStaticMethod", int.class); // getMethod 不是 public，會直接報錯
        Method m = clazz.getDeclaredMethod("privateStaticMethod", int.class, int.class);
        System.out.println("m：" + m);
        System.out.println("修飾子(數字)：" + m.getModifiers());
        System.out.println("修飾子(中文)：" + Modifier.toString(m.getModifiers()));
        System.out.println("方法名：" + m.getName());
        System.out.println("方法的類別：" + m.getClass());// Method
        System.out.println("回傳型態：" + m.getReturnType());
        System.out.println("宣告的類別：" + m.getDeclaringClass());

        for (Class<?> exc : m.getExceptionTypes()) {
            System.out.println("例外：" + exc);
        }

        System.out.println("有幾個參數：" + m.getParameterCount());
        System.out.println("有幾個參數：" + m.getParameterTypes().length);
        for (Class<?> p : m.getParameterTypes()) {
            System.out.println("參數名稱：" + p.getCanonicalName());
        }

        System.out.println(m.getDeclaredAnnotations().length);
        for (Annotation a : m.getDeclaredAnnotations()) {
            System.out.println("所有參數:" + a);
            System.out.println("註解的包.類名:" + a.annotationType());
            if (a instanceof Deprecated d) {
                System.out.println(d.forRemoval());
            }
        }
    }
}
