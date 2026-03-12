import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SocialNetwork network = new SocialNetwork();

        // creare obiecte
        Programmer p1 = new Programmer(1, "Andrei", LocalDate.of(1995, 5, 20), "Java");
        Designer p2 = new Designer(2, "Elena", LocalDate.of(1998, 3, 15), "Adobe XD");
        Person p3 = new Person(3, "Mihai", LocalDate.of(1990, 10, 5));

        Company c1 = new Company(100, "Ubisoft", "Gaming");
        Company c2 = new Company(101, "Google", "Tech");

        // adaugare in retea
        network.addProfile(p1);
        network.addProfile(p2);
        network.addProfile(p3);
        network.addProfile(c1);
        network.addProfile(c2);

        // cautare relatii
        p1.addRelationship(p2, "prieteni");
        p1.addRelationship(c1, "angajat (Java Dev)");

        p2.addRelationship(c1, "angajat (UX Designer)");

        p3.addRelationship(p1, "prieteni");
        p3.addRelationship(p2, "prieteni");
        p3.addRelationship(c2, "angajat (Manager)");


        c1.addEmployee(p1);
        c1.addEmployee(p2);
        c2.addEmployee(p3);

        // afisare sortata dupa importanta
        network.printNetwork();
    }
}