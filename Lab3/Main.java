import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Profile> network = new ArrayList<>();


        network.add(new Person(1, "Mihai"));
        network.add(new Company(100, "Ubisoft"));
        network.add(new Programmer(2, "Andrei"));
        network.add(new Designer(3, "Elena"));
        network.add(new Company(101, "Amazon"));


        network.sort(Comparator.comparing(Profile::getName));

        System.out.println("Reteaua sociala (sortata dupa nume):");
        for (Profile p : network) {
            System.out.println(p);
        }
    }
}