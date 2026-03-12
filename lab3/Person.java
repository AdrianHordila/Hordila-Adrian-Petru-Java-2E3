import java.time.LocalDate;
import java.util.*;

public class Person implements Profile, Comparable<Person> {
    protected int id;
    protected String name;
    protected LocalDate birthDate; //am folosit protected pentru a acordat acces la clasele designer si programmer
    protected Map<Profile, String> relationships = new HashMap<>();  // map de relatii

    public Person(int id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public void addRelationship(Profile p, String type) {
        relationships.put(p, type);
    }

    public Map<Profile, String> getRelationships() {
        return relationships;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getId() { return id; }

    @Override
    public int compareTo(Person other) {     // comparare nume persoana curenta cu alt nume
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object o)       // doua persoane sunt identice daca au acelasi id
    {
        if (this == o) return true;
        if (!(o instanceof Profile)) return false;
        Profile profile = (Profile) o;
        return id == profile.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Persoana: " + name + " (ID: " + id + "  Data Nasterii: " + birthDate + ")";
    }
}