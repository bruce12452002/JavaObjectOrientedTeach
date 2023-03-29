package annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

public class InheritTest {
    public static void main(String[] args) {
        Arrays.stream(Son.class.getAnnotations())
                .filter(a -> "Extends".equals(a.annotationType().getSimpleName()))
                .forEach(a -> {
                    if (a instanceof Extends e) {
                        System.out.println(e.key() + "=" + e.value());
                    }
                });
    }
}


@Extends(key = "x", value = 1)
class Daddy {
}

class Son extends Daddy {
}

@Inherited
@Retention(RetentionPolicy.RUNTIME) // 一定要是 RUNTIME
@interface Extends {
    String key();

    int value();
}
