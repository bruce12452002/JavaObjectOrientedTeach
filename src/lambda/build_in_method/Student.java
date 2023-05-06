package lambda.build_in_method;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private String sex;

    public Student(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public static List<Student> getStudents() {
        return List.of(
                new Student(100, "monkey", "男"),
                new Student(1, "dog", "女"),
                new Student(10, "dragon", "男")
        );
    }
}
