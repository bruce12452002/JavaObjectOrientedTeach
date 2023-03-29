package clazz.seal;

import base.ImportTest;
import clazz.AnonymousClass;

/**
 * Java 17 功能
 * 密封類別：表示誰可以繼承我
 * <p>
 * sealed 為密封類別，可以是抽象、介面，加了之後就不能想繼承就繼承，必需是 permits 允許的類別和介面才能繼承
 * sealed 和 permits 關鍵字是一起出現的，而且 permits 的類別或介面要有繼承該類別才可以
 * permits 的類別和介面必需是三者之一，final、non-sealed、sealed
 * public sealed abstract 寫的時候順序可調換、permits 只能寫在最後
 */
public sealed abstract class SealedClassTest /* extends ImportTest implements AnonymousClass */ permits Apple, Banana {

}

sealed class Apple extends SealedClassTest permits WaterMelon {
}

final class Banana extends SealedClassTest {
}

non-sealed class WaterMelon extends Apple {
}