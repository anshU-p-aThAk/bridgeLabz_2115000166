import java.lang.annotation.*;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@interface CacheResult {
}

class Calculator {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    int square(int x) {
        return cache.computeIfAbsent(x, k -> k * k);
    }
}

public class CustomCaching {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.square(4));
        System.out.println(calc.square(4));
    }
}
