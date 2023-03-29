package clazz;

/**
 * Java 16 功能
 * 特殊的類別
 * final class
 * 已有 equals、hashCode、toString
 * 屬性都是 public
 * 無法再寫建構子
 * 無法 extends，但可以 implements
 */
public record RecordTest(int id, String name) {
    public static void main(String[] args) {
        RecordTest recordTest = new RecordTest(5, "xxx");
        System.out.println(recordTest.id + "=" + recordTest.id());
        System.out.println(recordTest.name + "=" + recordTest.name());
    }
}
