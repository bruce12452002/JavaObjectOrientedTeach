package clazz;

public interface AnonymousClass {
    void xxx();

    public static void main(String[] args) {
        AnonymousClass anonymousClass = new AnonymousClass() {

            @Override
            public void xxx() {
                System.out.println("xxx");
            }
        };
    }

    static void lambda() { // 只有一個正常方法時才可用 lambda，就是沒有 static、default 的方法
        AnonymousClass ac = () -> {
            System.out.println("xxx");
        };
        ac.xxx();
    }
}
