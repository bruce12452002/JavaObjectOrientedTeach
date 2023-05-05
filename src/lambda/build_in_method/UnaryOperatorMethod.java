package lambda.build_in_method;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * maxBy minBy 兩個參數取最大或最小
 */
public class UnaryOperatorMethod {
    public static void main(String[] args) {
        BinaryOperator<Integer> bo1 = BinaryOperator.maxBy(Integer::compare);
        System.out.println(bo1.apply(10, 20));

        BinaryOperator<Integer> bo2 = BinaryOperator.minBy(Integer::compare);
        System.out.println(bo2.apply(10, 20));

//        maxByTestWithStudent();
    }

    private static void maxByTestWithStudent() {
        List<Student> students = Student.getStudents();
        Optional<Student> result = students.stream()
                .reduce(BinaryOperator.maxBy(Comparator.comparing(Student::getId)));
        System.out.println(result.get().id);
    }

    private static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public static List<Student> getStudents() {
            return List.of(
                    new Student(100, "monkey"),
                    new Student(1, "dog"),
                    new Student(10, "dragon")
            );
        }
    }

}
