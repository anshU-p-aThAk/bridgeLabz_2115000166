import java.util.*;

class Employee {
    private String name;
    private String departMent;

    public Employee(String name, String departMent) {
        this.name = name;
        this.departMent = departMent;
    }

    public String getName() {
        return name;
    }

    public String getdepartMent() {
        return departMent;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupBydepartMent {
    public static Map<String, List<Employee>> groupEmployeesBydepartMent(List<Employee> employees) {
        Map<String, List<Employee>> departMentMap = new HashMap<>();

        for (Employee employee : employees) {
            departMentMap.computeIfAbsent(employee.getdepartMent(), k -> new ArrayList<>()).add(employee);
        }

        return departMentMap;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR"));

        Map<String, List<Employee>> groupedBydepartMent = groupEmployeesBydepartMent(employees);

        groupedBydepartMent.forEach((departMent, employeeList) -> {
            System.out.println(departMent + ": " + employeeList);
        });
    }
}
