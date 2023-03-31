package object;

import java.util.ArrayList;

/**
 * 淺複製(shallow copy)：新的變數修改值時(非一般的等號賦值)，會影響舊的變數值；不會影響就是深複製(deep copy)
 * <p>
 * Object 有個 clone() 方法，可以達到複製的目的
 * 但還要 implements Cloneable，不然會報 CloneNotSupportedException
 * <p>
 * 可以將 clone() 的 protected 改成 public，也可將回傳的 Object 改成指定的物件
 */
public class PrototypeTest implements Cloneable {
    private ArrayList<String> list;

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    protected PrototypeTest clone() throws CloneNotSupportedException {
//        return (PrototypeTest) super.clone();

        PrototypeTest pt = (PrototypeTest) super.clone();
        // pt.list = (ArrayList<String>) list.clone();
        return pt;
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        PrototypeTest prototype = new PrototypeTest();
        prototype.setList(list);

        PrototypeTest copyPrototype;
        try {
            copyPrototype = prototype.clone();
            System.out.println(copyPrototype.getList());

            copyPrototype.getList().add("c");
            System.out.println(copyPrototype.getList());
            System.out.println(prototype.getList());

            // 類似 call by address
//            copyPrototype.setList(new ArrayList<>());
//            copyPrototype = null;
//            copyPrototype = new PrototypeTest();

            System.out.println(prototype.list == copyPrototype.list);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
