package base;

/**
 * 一輛汽車，有很多的實現形式，所以叫多型
 */
public class PolymorphismTest {
    public static void main(String[] args) {
        GrandPapa p = new I();
        // GrandPapa 一定要有 hi 方法，子類可不用，
        // 調用時會先找 I 類別的 hi 方法，有就調用，沒有就調用父類，再沒有就再往上找，直到最頂層
        p.hi();

        // instanceof
        Object i = new I();
        if (i instanceof GrandPapa) {
            GrandPapa g = (GrandPapa) i;
            System.out.println("gp");
        }
        if (i instanceof Father f) { // java 16
            System.out.println("f");
        }
        if (i instanceof I) {
            System.out.println("i");
        }

//        getHi(new I());
    }

    private static void getHi(GrandPapa p) {
        p.hi();
    }
}


class GrandPapa {
    public void hi() {
        System.out.println("grand papa");
    }
}

class Father extends GrandPapa {
    @Override
    public void hi() {
        System.out.println("father");
    }
}

class I extends Father {
    @Override
    public void hi() {
        System.out.println("I");
    }
}