public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    public String getPerson() {
        return "Name: " + name + ", Age: " + age;
    }

    public void setPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person(p1);
        System.out.println(p2.getPerson());
        p2.setPerson("Bob", 30);
        System.out.println(p2.getPerson());
    }
}