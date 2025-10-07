import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " | Age: " + age + " | Salary: " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Raj", 30, 55000),
            new Employee("Ankit", 25, 48000),
            new Employee("Neha", 28, 62000),
            new Employee("Priya", 35, 70000)
        );

        System.out.println("Sort by Name (Alphabetically):");
        employees.stream()
                .sorted((e1, e2) -> e1.name.compareTo(e2.name))
                .forEach(System.out::println);

        System.out.println("\nSort by Age (Ascending):");
        employees.stream()
                .sorted((e1, e2) -> Integer.compare(e1.age, e2.age))
                .forEach(System.out::println);

        System.out.println("\nSort by Salary (Descending):");
        employees.stream()
                .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
                .forEach(System.out::println);
    }
}
