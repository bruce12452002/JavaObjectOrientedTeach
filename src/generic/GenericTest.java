package generic;

/**
 * 泛型不可用基本類型
 * 泛型方法可以用在 static 和 非 static；　泛型類別只能用在非 static
 */
public class GenericTest<P, Q, R> {
    public P getP(P p) {
        return p;
    }

    public static <S> S getS(S s) { //
        return s;
    }

    public <R> R getR(R r) { // 泛型方法的名稱和泛型類別的名稱相衝突時，以泛型方法為主
        return r;
    }

    public <T, U> T[] getArray(T[] t, int[] u) { // 泛型裡不能放基本型態，所以以 T[] 自然就不能放 int[]…等的陣列
        return t;
    }

    public static void main(String[] args) {
        GenericTest<String, Integer, byte[]> genericTest = new GenericTest<>();
        genericTest.<String>getP(""); // 泛型可省略
        genericTest.getArray(new Integer[]{1, 2, 3}, new int[]{});

        GenericTest.<Integer>getS(8);

    }
}
