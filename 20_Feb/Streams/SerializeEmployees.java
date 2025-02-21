import java.io.*;
import java.util.*;

class Employee implements Serializable {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class SerializeEmployees {
    public static void main(String[] args) throws Exception {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employees.ser"));
        List<Employee> employees = Arrays.asList(new Employee(1, "John"), new Employee(2, "Alice"));
        out.writeObject(employees);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("employees.ser"));
        System.out.println(in.readObject());
        in.close();
    }
}
