package clazz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class OuterClass {
    // Instantiation of utility class 'OuterClass'
    // new class 時，沒有變數、方法或者只有靜態的變數、方法，idea 認為不需要 new 出來，所以報了警告
    // 只要在類別裡增加一般變數、方法即可
    private int i;

    /**
     * ※為何出現 Inner class 'InnerClass1' may be 'static'
     * static 可以直接存取 外部 class 的 static，non-static不能「直接」存取
     * 如果沒有要存取 non-static，就使用 static class
     * <p>
     * memory leak(記憶體漏洞)：想成記憶體有個洞，這個洞的儲存空間無法被記憶體所用，
     * heap 裡的程式無法釋放，最終會導致 memory overflow
     * <p>
     * memory overflow、out of memory(記憶體不足)：申請不到足夠空間時，會報這個錯誤
     */
    public class InnerClass1 {
        static List<String> list = new ArrayList<>();

        public void memoryLeak() {
            Stream.iterate(0, i -> ++i).limit(100)
                    .forEach(d -> {
                        String s = "hahaha";
                        list.add(d + s);
                        s = null; // 就算 s 給 null，仍然不會被回收，因為 list 為 static，生命週期和 JVM 一樣
                    });
//            list = null; // 這樣才能被回收
        }
    }

    protected class InnerClass2 {
        public void memoryOverflow() {
            for (var i = 0; i < 100; i++) {
                int[] ints = new int[10 * 1024 * 1024]; // 一次申請 10 MB
            }
            // -Xms、-Xmx
        }
    }

    class InnerClass3 {
    }

    private class InnerClass4 {
    }

    public static void main(String[] args) {
        new OuterClass().new InnerClass1();
        new OuterClass().new InnerClass2();
        new OuterClass().new InnerClass3();
        new OuterClass().new InnerClass4();

        new OuterClass.InnerClass5();
        new OuterClass.InnerClass6();
        new OuterClass.InnerClass7();
        new OuterClass.InnerClass8();
    }

    public static class InnerClass5 {
    }

    protected static class InnerClass6 {
    }

    static class InnerClass7 {
    }

    private static class InnerClass8 {
    }
}
