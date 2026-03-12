import java.time.LocalDate;

public class Designer extends Person {
    private String designTool; // ex photoshop, lightroom etc

    public Designer(int id, String name, LocalDate birthDate, String designTool) {
        super(id, name, birthDate);
        this.designTool = designTool;
    }

    @Override
    public String toString() {
        return "Designer: " + name + " (Tool : " + designTool + ")";
    }
}