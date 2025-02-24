import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface ImportantMethod {
    String level() default "HIGH";
}

class MyClass {
    @ImportantMethod(level = "CRITICAL")
    void processData() {
        System.out.println("Processing data...");
    }

    @ImportantMethod
    void fetchData() {
        System.out.println("Fetching data...");
    }
}

public class MarkMethods {
    public static void main(String[] args) throws Exception {
        for (Method method : MyClass.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println(method.getName() + " is important. Level: " + annotation.level());
            }
        }
    }
}
