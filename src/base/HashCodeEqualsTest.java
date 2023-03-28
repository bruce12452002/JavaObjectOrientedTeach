package base;

import java.util.HashSet;
import java.util.Set;

public class HashCodeEqualsTest {
    public static void main(String[] args) {
        Set<Haha> set = new HashSet<>();
        Haha haha = new Haha();
        // 加入的是同一個記憶體位址
//        set.add(haha);
//        set.add(haha);
//        set.add(haha);

        // 不同記憶體位址，加不加的進去，要看 hashCode 和 equals 方法，兩個都得寫
        set.add(new Haha());
        set.add(new Haha());
        set.add(new Haha());

        System.out.println(set.size());
    }

    private static class Haha {
//        private int id;
//        private String name;

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Haha haha = (Haha) o;
//            return id == haha.id && Objects.equals(name, haha.name);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(id, name);
//        }
    }
}
