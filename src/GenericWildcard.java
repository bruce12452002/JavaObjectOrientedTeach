import java.util.ArrayList;
import java.util.List;

/**
 * wildcard 有 ?、&、extends、super
 */
public class GenericWildcard {
    /**
     * ? super XXX --> 表示繼承關係「最高」到 XXX
     */
    private static void superTest(List<Animal> listA, List<Bird> listB, List<Chicken> listC) {
        List<? super Animal> a1 = listA;
        List<? super Bird> b1 = listA;
        List<? super Chicken> c1 = listA;

//        List<? super Animal> a1s = listB; // x
        List<? super Bird> b1s = listB;
        List<? super Chicken> c1s = listB;

//        List<? super Animal> a1ss = listC; // x
//        List<? super Bird> b1ss = listC; // x
        List<? super Chicken> c1ss = listC;
    }

    /**
     * ? extends XXX --> 表示繼承關係「最低」到 XXX
     */
    private static void extendsTest(List<Animal> listA, List<Bird> listB, List<Chicken> listC) {
        List<? extends Animal> a2 = listA;
//        List<? extends Bird> b2 = listA; // x
//        List<? extends Chicken> c2 = listA; // x

        List<? extends Animal> a2e = listB;
        List<? extends Bird> b2e = listB;
//        List<? extends Chicken> c2e = listB; // x

        List<? extends Animal> a2ee = listC;
        List<? extends Bird> b2ee = listC;
        List<? extends Chicken> c2ee = listC;
    }

    /**
     * 賦值時，如果有 super、extends，super 只能賦值 super；extends 只能賦值 extends
     */
    private static void superParamTest(List<? super Animal> listA, List<? super Bird> listB, List<? super Chicken> listC) {
        List<? super Animal> a1 = listA;
        List<? super Bird> b1 = listA;
        List<? super Chicken> c1 = listA;

//        List<? super Animal> a1s = listB; // x
        List<? super Bird> b1s = listB;
        List<? super Chicken> c1s = listB;

//        List<? super Animal> a1ss = listC; // x
//        List<? super Bird> b1ss = listC; // x
        List<? super Chicken> c1ss = listC;
    }

    /**
     * 賦值時，如果有 super、extends，super 只能賦值 super；extends 只能賦值 extends
     */
    private static void extendsParamTest(List<? extends Animal> listA, List<? extends Bird> listB, List<? extends Chicken> listC) {
        List<? extends Animal> a2 = listA;
//        List<? extends Bird> b2 = listA; // x
//        List<? extends Chicken> c2 = listA; // x

        List<? extends Animal> a2e = listB;
        List<? extends Bird> b2e = listB;
//        List<? extends Chicken> c2e = listB; // x

        List<? extends Animal> a2ee = listC;
        List<? extends Bird> b2ee = listC;
        List<? extends Chicken> c2ee = listC;
    }

    /**
     * 增加元素時，不要看 super 和 extends 關鍵字，會搞混，那是給賦值的時候用的
     * super 可增加元素，取得元素要用 Object
     * extends 只能取得元素，不能增加元素
     * ? 等同 ? extends Object
     */
    private static void addElement(List<? super Animal> listA, List<? super Bird> listB, List<? super Chicken> listC) {
        Animal a = new Animal();
        Bird b = new Bird();
        Chicken c = new Chicken();

        listA.add(a);
        listA.add(b);
        listA.add(c);

//        listB.add(a);
        listB.add(b);
        listB.add(c);

//        listC.add(a);
//        listC.add(b);
        listC.add(c);
    }

    private static void getSuperElement() {
        Animal a = new Animal();
        a.setEat("Animal 吃");
        a.setJump("Animal 跳");

        Bird b = new Bird();
        b.setEat("Bird 吃");
        b.setJump("Bird 跳");
        b.setFly("Bird 飛");

        Chicken c = new Chicken();
        c.setDance("Chicken 在跳舞");

        List<? super Animal> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);

        for (Object o : list) {
            if (o instanceof Chicken chicken) {
                System.out.println(chicken.getDance());
                continue;
            }

            if (o instanceof Bird bird) {
                System.out.println(bird.getFly());
                continue;
            }

            if (o instanceof Animal) {
                Animal animal = (Animal) o;
                System.out.println(animal.getEat());
                continue;
            }
        }
    }

    private static void getExtendsElement() {
        List al = new ArrayList<>();
        Animal a = new Animal();
        a.setEat("Animal 吃");
        a.setJump("Animal 跳");
        al.add(a);

        List bl = new ArrayList<>();
        Bird b = new Bird();
        b.setEat("Bird 吃");
        b.setJump("Bird 跳");
        b.setFly("Bird 飛");
        bl.add(b);

        List cl = new ArrayList<>();
        Chicken c = new Chicken();
        c.setEat("Chicken 吃");
        c.setDance("Chicken 在跳舞");
        cl.add(c);

        xxx(bl);
        xxx(cl);
    }

    private static void xxx(List<? extends Bird> list) {
        for (Animal a : list) {
            System.out.println(a.getEat());
            a.setEat("好吃");
            System.out.println(a.getEat());
        }
    }
}


interface God {
}

interface Ghost {
}

class Person implements God, Ghost {
}

/**
 * & 只能寫在泛型類別和泛型方法
 */
class Man<T extends Person & God & Ghost> extends Person {
}

class Animal {
    private String eat;
    private String jump;

    public String getEat() {
        return eat;
    }

    public void setEat(String eat) {
        this.eat = eat;
    }

    public String getJump() {
        return jump;
    }

    public void setJump(String jump) {
        this.jump = jump;
    }
}

class Bird extends Animal {
    private String fly;

    public String getFly() {
        return fly;
    }

    public void setFly(String fly) {
        this.fly = fly;
    }
}

class Chicken extends Bird {
    private String dance;

    public String getDance() {
        return dance;
    }

    public void setDance(String dance) {
        this.dance = dance;
    }
}