import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo {
    String priority();

    String assignedTo();
}

class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Anshu")
    void completeTask() {
        System.out.println("Task completed");
    }
}

public class CustomAnnotation {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("completeTask");
        TaskInfo info = method.getAnnotation(TaskInfo.class);
        System.out.println("Priority: " + info.priority());
        System.out.println("Assigned To: " + info.assignedTo());
    }
}
