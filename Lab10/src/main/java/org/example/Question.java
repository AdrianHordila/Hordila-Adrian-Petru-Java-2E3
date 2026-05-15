import java.io.Serializable;

public class Question {
    String text;
    String[] options;
    int correctIndex;

    public Question(String line) {
        String[] parts = line.split("\\|");
        this.text = parts[0];
        this.options = new String[]{parts[1], parts[2], parts[3], parts[4]};
        this.correctIndex = Integer.parseInt(parts[5]);
    }

    @Override
    public String toString() {
        return text + " [0]" + options[0] + " [1]" + options[1] + " [2]" + options[2] + " [3]" + options[3];
    }
}