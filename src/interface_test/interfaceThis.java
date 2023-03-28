package interface_test;

public interface interfaceThis {
    default String i1a() {
        return this.i1b() + this.i1c();
    }

    default String i1b() {
        return "call ";
    }

    default String i1c() {
        return "success";
    }

    static void main(String[] args) {
        interfaceThis i = new interfaceThis() {};
        System.out.println(i.i1a());
    }
}
