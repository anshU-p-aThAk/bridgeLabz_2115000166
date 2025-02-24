import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    void adminTask() {
        System.out.println("Admin task executed");
    }
}

public class RoleControl {
    public static void main(String[] args) throws Exception {
        String userRole = "USER";
        Method method = SecureService.class.getMethod("adminTask");
        RoleAllowed role = method.getAnnotation(RoleAllowed.class);
        if (role != null && role.value().equals(userRole)) {
            method.invoke(new SecureService());
        } else {
            System.out.println("Access Denied!");
        }
    }
}
