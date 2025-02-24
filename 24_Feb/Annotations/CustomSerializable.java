import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    String username = "John";
}

public class CustomSerializable {
    public static void main(String[] args) throws Exception {
        User user = new User();
        Map<String, String> json = new HashMap<>();
        for (Field field : User.class.getDeclaredFields()) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                json.put(annotation.name(), (String) field.get(user));
            }
        }
        System.out.println(json);
    }
}