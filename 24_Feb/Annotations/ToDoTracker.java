import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();

    String assignedTo();

    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement login", assignedTo = "Alice", priority = "HIGH")
    public void login() {
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeDB() {
    }

    @Todo(task = "Add unit tests", assignedTo = "Charlie", priority = "LOW")
    public void addTests() {
    }
}

public class ToDoTracker {
    public static void main(String[] args) {
        for (Method method : Project.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println();
            }
        }
    }
}
