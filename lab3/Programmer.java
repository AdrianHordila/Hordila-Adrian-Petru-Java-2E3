import java.time.LocalDate;

public class Programmer extends Person {
    private String mainLanguage;

    public Programmer(int id, String name, LocalDate birthDate, String mainLanguage) {
        super(id, name, birthDate);
        this.mainLanguage = mainLanguage;
    }

    @Override
    public String toString() {
        return "Programmer: " + name + " (Limbaj: " + mainLanguage + ")";
    }
}