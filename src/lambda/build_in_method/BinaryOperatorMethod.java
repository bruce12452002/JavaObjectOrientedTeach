package lambda.build_in_method;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

/**
 * maxBy minBy 兩個參數取最大或最小
 */
public class BinaryOperatorMethod {
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
        System.out.println(result.get().getId());
    }
}
