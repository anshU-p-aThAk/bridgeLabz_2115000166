import java.util.*;

class Circle {
    private double radius;

    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }
}

public class CircleMain {
    public static void main(String[] args) {

        Circle circle = new Circle();
        Circle circle2 = new Circle(2.0);
    }
}
