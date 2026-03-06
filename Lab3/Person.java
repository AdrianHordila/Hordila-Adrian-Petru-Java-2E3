import java.util.Objects;

public class Person implements Profile, Comparable<Person> {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Persoana: " + name + " (ID: " + id + ")";
    }
}


class Programmer extends Person {
    public Programmer(int id, String name) {
        super(id, name);
    }
}

class Designer extends Person {
    public Designer(int id, String name) {
        super(id, name);
    }
}