import java.util.*;

class Animal {
    public String name;
    public String age;

    public void makeSound() {

    }
}

class Dog extends Animal {

    public Dog(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Woof!");
    }
}

class Cat extends Animal {

    public Cat(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Meow!");
    }
}

class Bird extends Animal {

    public Bird(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void makeSound() {
        System.out.println("Tweet!");
    }
}

public class AnimalMain {
    public static void main(String[] args) {
        Dog dog = new Dog("Fido", "2");
        Cat cat = new Cat("Whiskers", "4");
        Bird bird = new Bird("Tweety", "1");
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}