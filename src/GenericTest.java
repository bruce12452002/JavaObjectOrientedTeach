/**
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
}
