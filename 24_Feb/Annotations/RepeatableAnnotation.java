import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

class BugTracker {
    @BugReport(description = "Null pointer exception on login")
    @BugReport(description = "Performance issue on search")
    void fixBugs() {
        System.out.println("Fixing bugs...");
    }
}

public class RepeatableAnnotation {
    public static void main(String[] args) throws Exception {
        Method method = BugTracker.class.getMethod("fixBugs");
        BugReports reports = method.getAnnotation(BugReports.class);
        for (BugReport report : reports.value()) {
            System.out.println("Bug: " + report.description());
        }
    }
}
