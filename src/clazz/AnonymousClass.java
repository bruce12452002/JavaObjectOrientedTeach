package clazz;

public interface AnonymousClass {
    void xxx();

    public static void main(String[] args) {
        AnonymousClass anonymousClass = new AnonymousClass() {

            @Override
            public void xxx() {

            }
        };
    }
}
