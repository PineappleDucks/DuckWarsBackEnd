package Chat;

public class Antwort {
    private int antwortId;
    private String text = "Test";

    public Antwort(int id) {
        id = antwortId;
    }

    public String toString() {
        return "<" + antwortId + ", " + text + ">";
    }

}
