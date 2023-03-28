package inherit;

public class MultiInheritJ7Test implements Interface1, Interface2 {

    @Override
    public void f() { // 因為父介面都沒實作，只要實作一次即可，如果有重載，那就都實作

    }
}

interface Interface1 {
    void f();
}

interface Interface2 {
    void f();
}
