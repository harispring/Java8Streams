import java.util.*;
import java.util.stream.Collectors;

public class Java8StreamsMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,2,5,3,6);
        Set<Integer> set = new HashSet<>();

        list.stream()
                .filter(n -> ! set.add(n)) // filter duplicates by adding to a set
                .forEach(System.out::println);

        //11. Find Second Highest Number
        list.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);
System.out.println("------------- Non repeted numbers: ");
        //14. Find Non-Repeated Characters
        list.stream().collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
        
        //Create Employee Object and create map object department wise count
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 55000),
                new Employee("Bob", "IT", 70000),
                new Employee("Charlie", "Finance", 65000),
                new Employee("Diana", "IT", 72000),
                new Employee("Eve", "HR", 58000)
        );

        // Count employees per department
        Map<String, Long> deptCount = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, LinkedHashMap::new, Collectors.counting()));

        System.out.println("\nDepartment wise employee count:");
        deptCount.forEach((dept, count) -> System.out.println(dept + " -> " + count));
    }

    // Simple Employee POJO for the example
    static class Employee {
        private final String name;
        private final String department;
        private final double salary;

        Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return "Employee{" + "name='" + name + '\'' + ", department='" + department + '\'' + ", salary=" + salary + '}';
        }
    }
    }
}
