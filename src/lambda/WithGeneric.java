package lambda;

public interface WithGeneric {

    static void main(String[] args) {
        F1<String> f1a = () -> "ooo";
        F1<Integer> f1b = () -> 2;

        F2<String> f2 = s -> System.out.println("xxx" + s);

        F3<Integer, String> f3 = i -> i + "xxx";
    }
}

@FunctionalInterface
interface F1<R> {
    R get();
}

@FunctionalInterface
interface F2<T> {
    void get(T t);
}

@FunctionalInterface
interface F3<T, R> {
    R get(T t);
}
