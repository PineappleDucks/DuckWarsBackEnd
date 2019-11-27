package Chat;

import java.util.List;

public class Nachricht {
    List<Antwort> moeglicheAntworten;
    private int NachrichtId = 0;
    private String text = "Test";

    public Nachricht() {
        moeglicheAntworten.add(new Antwort(1));
        moeglicheAntworten.add(new Antwort(2));
    }

    public List<Antwort> getMoeglicheAntworten() {
        return moeglicheAntworten;
    }

    public String toString() {
        return "<" + NachrichtId + ", " + text + ">";
    }
}
