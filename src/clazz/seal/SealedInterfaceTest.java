package clazz.seal;

sealed public interface SealedInterfaceTest permits Apple1, Banana1 {
}

sealed interface Apple1 extends SealedInterfaceTest permits WaterMelon1 {
}

final class Banana1 implements SealedInterfaceTest {
}

non-sealed class WaterMelon1 implements Apple1 {
}