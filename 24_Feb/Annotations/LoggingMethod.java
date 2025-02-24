import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime {
}

class Performance {
    @LogExecutionTime
    void runTask() {
        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++)
            ;
        long end = System.nanoTime();
        System.out.println("Execution time: " + (end - start) + " ns");
    }
}

public class LoggingMethod {
    public static void main(String[] args) {
        new Performance().runTask();
    }
}
