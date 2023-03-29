package clazz.seal;

/**
 * sealed 為密封類別，可以是抽象、介面，加了之後就不能想繼承就繼承，必需是 permits 允許的類別和介面才能繼承
 * sealed 和 permits 關鍵字是一起出現的，而且 permits 的類別或介面要有繼承該類別才可以
 * permits 的類別和介面必需是三者之一，final、non-sealed、sealed
 * public sealed abstract 寫的時候順序可調換、permits 只能寫在最後
 */
sealed public interface SealedInterfaceTest permits Apple1, Banana1 {
}

sealed interface Apple1 extends SealedInterfaceTest permits WaterMelon1 {
}

final class Banana1 implements SealedInterfaceTest {
}

non-sealed class WaterMelon1 implements Apple1 {
}