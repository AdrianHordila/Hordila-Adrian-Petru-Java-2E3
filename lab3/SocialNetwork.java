import java.util.*;

public class SocialNetwork { 
    private List<Profile> nodes = new ArrayList<>(); //Lista adiacenta
         
    public void addProfile(Profile p) {
        nodes.add(p);
    }


    public int getImportance(Profile p) {
        if (p instanceof Person) {
            return ((Person) p).getRelationships().size();
        } else if (p instanceof Company) {
            return ((Company) p).getEmployeeCount();
        }
        return 0;
    }


    public void printNetwork() {

        nodes.sort((p1, p2) -> Integer.compare(getImportance(p2), getImportance(p1)));


        for (Profile p : nodes) {
            System.out.println(p + "   Importanta: " + getImportance(p));
        }
    }
}