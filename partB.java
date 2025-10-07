import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Ravi", 85),
            new Student("Anita", 67),
            new Student("Karan", 92),
            new Student("Meena", 74),
            new Student("Simran", 80)
        );

        System.out.println("Students scoring above 75%, sorted by marks:");
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks))
                .map(s -> s.name + " (" + s.marks + "%)")
                .forEach(System.out::println);
    }
}
