package Chat;

import java.util.List;

public interface ChatI {

    List<Nachricht> getMoeglicheAntworten(int NachrichtId);

    Antwort antwortSenden(int AntwortId);

}
