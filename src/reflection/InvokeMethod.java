package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Supplier;

public class InvokeMethod {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        InvokeMethod im = new InvokeMethod();
        Supplier<InvokeMethod> sim = InvokeMethod::new;
        InvokeMethod im = sim.get();
        // 每次 get()會每次 new，所以以下用到 im 的地方，不可以寫成 sim.get()
        System.out.println(sim.get());
        System.out.println(sim.get());
        System.out.println(sim.get());

        Class<InvokeMethod> clazz = InvokeMethod.class;
        Method m = clazz.getDeclaredMethod("setAddress", String.class);
        m.invoke(im, "xxx");

        System.out.println(clazz.getDeclaredMethod("getAddress").invoke(im));
        System.out.println(im.getAddress());
    }


}
