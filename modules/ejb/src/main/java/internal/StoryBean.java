package internal;

import database.ContactManager;
import database.InitManager;
import entity.chat.Condition;
import entity.chat.Contact;
import entity.chat.DialogOption;
import entity.chat.Message;
import entity.chat.Chat;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

@Startup
@Singleton
public class StoryBean {

    private ContactManager manager = new ContactManager();
    private InitManager initManager = new InitManager();

    public List<Condition> conditions = new LinkedList<>();

    @PostConstruct
    public void init(){
        importContacts();
        importConditions();
        importMessages();
    }

    private void importConditions(){
        createCondition(ConditionName.WAS_IST_PASSIERT);
        createCondition(ConditionName.MEHRERE_FEINDE_IN_DER_NAEHE);
        createCondition(ConditionName.OK_WIR_SCHICKEN_EINEN_TRUPP);
        createCondition(ConditionName.IST_DEIN_RADAR_EINSATZBEREIT);

    }

    private void createCondition(String name){
        Condition condition = new Condition();
        condition.setConditionDescriptor(name);
        conditions.add(condition);
    }

    private void importContacts(){
        createContact("Bordcomputer", "", "");
        createContact("Hauptquartier", "", "");
        createContact("Rebellenbasis", "", "");
        createContact("Ende", "", "");

        createContact("D2R2", "", "");
        createContact("???", "", "");
        createContact("Jedi-Stützpunkt", "", "");
        createContact("Jedi-Offizier", "", "");
        createContact("Mutiger Widerständler", "", "");
        createContact("□□Ä□~□-Kommunikations-Port", "", "");
    }

    private void createContact(String firstname, String lastname, String image){
        Contact contact = new Contact();
        contact.setFirstName(firstname);
        contact.setLastName(lastname);
        manager.saveContact(contact);
    }

    private void importMessages(){
        importJediMessages();
        importSithMessages();
    }

    private void importJediMessages(){

        ArrayList<DialogOption> dialogOptions;
        ArrayList<Condition> conditions;

        Message last = new Message();
        Message EndeEskorte = new Message();
        Message EndeAbschuss = new Message();
        Message Energiecontainer = new Message();
        Message I1 = new Message();
        Message I2 = new Message();
        Message RichtigeAdresse = new Message();
        Message EndeEinheimische = new Message();
        Message EndeDAbschuss = new Message();
        Message G2 = new Message();
        Message FalscheAdresse = new Message();
        Message Adresse = new Message();
        Message Verbindung = new Message();
        Message C3 = new Message();

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, null));
        last = createMessage("Die Eskorte ist eingetroffen! Gott sei Dank!", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Die Eskorte ist in Kürze da!", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Wir haben die Koordinaten erhalten. Kommt Heile wieder.", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("ÜBERTRAGE KOORDINATEN…", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Übertrage die Koordinaten.",conditions, last));
        EndeEskorte = createMessage("", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, null));
        last = createMessage("ALARM Ein Abschuss-Projektil befindet sich gerade auf dem Weg zu uns. Es war schön, für dich gedient zu haben…", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Wir müssen unsere Technologie um jeden Preis beschützen und dürfen kein Risiko eingehen. Es tut uns Leid, aber unter diesen Umständen haben wir leider keine Wahl… Für den Widerstand!", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        EndeAbschuss = createMessage("Hast du deinen Verstand jetzt komplett verloren?", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("In Ordnung. Einen Moment.",conditions, EndeEskorte));
        dialogOptions.add(createDialogOption("In Ordnung. Einen Moment.",conditions, EndeAbschuss));
        last = createMessage("Unsere Eskorte befindet sich auf dem Weg Richtung Kommunikations-Port. Nun gib uns die genauen Koordinaten, damit die Eskorte zu dir gelangen und dich abfangen kann.", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Das ist der Grund warum ich mich melde. Ich muss dich fragen, warum du dich nicht umgehend über die hinterlegte Adresse ein Notsignal ausgesandt hast.", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Was denn zum Beispiel?",conditions, last));
        last = createMessage("Ich halte diese Aussagen ebenfalls für sehr weit hergeholt. Es gibt jedoch auch berechtigte Bedenken.", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Ein Spion? Ich?",conditions, last));
        last = createMessage("Hallo, hier ist ein Jedi-Offizier. Im Kreis der Widerstands-Besatzung herrscht Uneinigkeit über dich. Manche munkeln, dass du ein Spion des Imperiums bist.", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Wir befinden uns jetzt im Orbit des Hauptplanets.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("5... 4... 3... 2... 1... ABFLUG.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("STARTE KURZSTRECKENFLUG…", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Lass uns von diesem Mond verschwinden",conditions, last));
        dialogOptions.add(createDialogOption("Starte Kurzstreckenflug.",conditions, last));
        Energiecontainer = createMessage("Die Energiecontainer sind angedockt!", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, Energiecontainer));
        I2 = createMessage("Ich auch... Ich habe das Gefühl, dass sie alles dafür tun würden, um die experimentelle Technologie zu wahren.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, Energiecontainer));
        I1 = createMessage("Naja… Ich habe das Gefühl, dass sie alles dafür tun würden, um die experimentelle Technologie zu wahren.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Läuft doch alles glatt!",conditions, I1));
        dialogOptions.add(createDialogOption("Ich habe Zweifel.",conditions, I2));
        last = createMessage("Dann heißt es jetzt wohl Abwarten und Tee trinken!", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Cool!",conditions, last));
        last = createMessage("Energiecontainer sind neben den Abschussprojektilen unsere schnellsten uns zur Verfügung stehenden mobilen Objekte. Beide arbeiten so, dass wenn sie einmal abgeschickt worden sind, nicht mehr abgebrochen werden können und unermüdlich ihren Weg bis ans Ziel fliegen - es sei denn, sie werden auf dem Weg zerstört.", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Dauert das noch lange?",conditions, last));
        last = createMessage("Wir haben bereits autonome Energiecontainer losgeschickt, die an euer Raumschiff andocken werden. So könnt ihr zumindest auf dem Kurzstreckenflug in Bewegung bleiben und euch von der aktuellen Stelle entfernen, bevor eventuell Feinde zu euch gelangen.", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Wie komme ich hier am schnellsten Weg?",conditions, last));
        last = createMessage("Du bist der einzige Widerständler, dem wir es erlaubt haben, mit dieser Technologie in der Galaxis herumzufliegen. Das bringt aber auch Gefahren mit sich. Die verbaute Technologie darf auf keinen Fall in die Hände des Imperiums gelangen, denn sonst sind wir alle verloren. Es besteht die Möglichkeit, dass das Imperium die Ports der Galaxis durchleuchten. Bei jeder Verbindung zu einem Port werden einige Informationen des Raumschiffs mitgeschickt. Durch die in deinem Raumschiff verbaute experimentelle Technologie kann es sein, dass du aufgespürt wirst. Daher müssen wir dein Raumschiff schnellstmöglich da wegschaffen.", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Sollte ich die Mission nicht abschließen?",conditions, last));
        last = createMessage("Erinnerst du dich garnicht mehr? Der Absturz scheint dir doch ordentlich zugesetzt zu haben. Lass uns erstmal schnellstmöglich dafür sorgen, dass du nach Hause kommst.", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Was ist passiert?",conditions, last));
        last = createMessage("Seid gegrüßt! Ist alles okay bei dir? Nach deinem Absturz haben wir die halbe Galaxis nach dir durchsucht.", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        RichtigeAdresse = createMessage("Verbindung von Kommunikations-Port zu angegebener Adresse wurde aufgebaut.", manager.getContactByFirstName("□□Ä□~□-Kommunikations-Port"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, null));
        last = createMessage("Wir sind gerettet!", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Für Erklärungen ist später Zeit! Geleitet mich mit zum Hauptplaneten. Ich habe dort einen Unterschlupf.", manager.getContactByFirstName("Mutiger Widerständler"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Ich kämpfe ebenfalls für den Widerstand. Ich hatte schon davon gehört, dass ihr verschwunden seid, jedoch wusste keiner wo. Ich dachte schon, dass wir alle dem Untergang geweiht sind.", manager.getContactByFirstName("Mutiger Widerständler"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Warum helft ihr uns?",conditions, last));
        last = createMessage("Ich bin vom Wiederstand. Mit dem Kommunikations-Port hat sich schon seit Jahren niemand mehr verbunden. Als ich davon gehört habe, musste ich umgehend herausfinden, wer sich dahinter verbirgt.", manager.getContactByFirstName("Mutiger Widerständler"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Wer seid ihr?",conditions, last));
        last = createMessage("Hallo? Ich habe eure Kommunikation abhören können. Ich versuche euch zu retten!", manager.getContactByFirstName("Mutiger Widerständler"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Uns bleibt wohl keine andere Wahl…", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Wir müssen uns auf den Planeten stürzen und uns selbst zerstören.",conditions, last));
        last = createMessage("VERBINDUNG WURDE ABGEBROCHEN. Der Kommunikations-Port wurde zerstört. Das Imperium hat uns wohl durch die Verbindung mit der falschen Adresse aufspüren können und die komplette Kommunikation angezapft.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Denkt dran. Die ganze Hoffnung des Widerstands liegt auf deinen Schultern. Die Technologie darf unter keinen Umständen an die Feinde gelangen!", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Du wurdest vom Imperium aufgespürt! Wie ist das möglich?! Wir müssen unsere Eskorte abziehen. Sobald die Verbindung abbricht, seid ihr entgültig auf euch allein gestellt.", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Das ist sehr merkwürdig. Wir nehmen im Umkreis gleich mehrere zerstörte Kommunikations- Ports wahr!", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Wartet!", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Du wirst in Kürze Koordinaten von uns erhalten. Wir werden dorthin, eine Eskorte schicken. Diese soll ich euch und das Raumschiff sicher zurückbringen.", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        EndeEinheimische = createMessage("Das hatte ich vermutet. Ich werde dies so weitergeben. Kommt Heile wieder.", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, null));
        last = createMessage("ALARM Ein Abschuss-Projektil befindet sich gerade auf dem Weg zu uns. Es war schön, für dich gedient zu haben…", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Wir müssen unsere Technologie um jeden Preis beschützen und dürfen kein Risiko eingehen. Es tut uns Leid, aber wir haben leider keine Wahl… Für den Widerstand!", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        EndeDAbschuss = createMessage("Du warst über diesen Port die ganze Zeit gleichzeitig mit einer unbekannten Adresse verbunden? Dass Feinde dich nun nicht schon ausgemacht haben, ist praktisch ausgeschlossen.", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Wir hatten nicht mehr genug Energie.",conditions, EndeEinheimische));
        dialogOptions.add(createDialogOption("Wir haben uns mit der falschen Adresse verbunden.",conditions, EndeDAbschuss));
        last = createMessage("Das ist der Grund warum ich mich melde. Ich muss dich fragen, warum du dich nicht umgehend über die hinterlegte Adresse ein Notsignal ausgesandt hast.", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Was denn zum Beispiel?",conditions, last));
        last = createMessage("Ich halte diese Aussagen ebenfalls für sehr weit hergeholt. Es gibt jedoch auch berechtigte Bedenken.", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Ein Spion? Ich?",conditions, last));
        last = createMessage("Hallo, hier ist ein Jedi-Offizier. Im Kreis der Widerstands-Besatzung herrscht Uneinigkeit über dich. Manche munkeln, dass du ein Spion des Imperiums bist.", manager.getContactByFirstName("Jedi-Offizier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Wir befinden uns jetzt im Orbit des Hauptplanets.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("5... 4... 3... 2... 1... ABFLUG.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("STARTE KURZSTRECKENFLUG…", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Lass uns von diesem Mond verschwinden",conditions, last));
        dialogOptions.add(createDialogOption("Starte Kurzstreckenflug.",conditions, last));
        Energiecontainer = createMessage("Die Energiecontainer sind angedockt!", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, Energiecontainer));
        I1 = createMessage("Ich weiß nicht, ob wir Ihnen sagen sollten, dass wir mit einer falschen Adresse verbunden waren. Ich habe das Gefühl, dass sie alles dafür tun würden, um die experimentelle Technologie zu wahren.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, Energiecontainer));
        I2 = createMessage("Ich auch... Ich habe das Gefühl, dass sie alles dafür tun würden, um die experimentelle Technologie zu wahren.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Läuft doch alles glatt!",conditions, I1));
        dialogOptions.add(createDialogOption("Ich habe Zweifel.",conditions, I2));
        last = createMessage("Dann heißt es jetzt wohl Abwarten und Tee trinken!", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Cool!",conditions, last));
        last = createMessage("Energiecontainer sind neben den Abschussprojektilen unsere schnellsten uns zur Verfügung stehenden mobilen Objekte. Beide arbeiten so, dass wenn sie einmal abgeschickt worden sind, nicht mehr abgebrochen werden können und unermüdlich ihren Weg bis ans Ziel fliegen - es sei denn, sie werden auf dem Weg zerstört.", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Dauert das noch lange?",conditions, last));
        last = createMessage("Wir haben bereits autonome Energiecontainer losgeschickt, die an euer Raumschiff andocken werden. So könnt ihr zumindest auf dem Kurzstreckenflug in Bewegung bleiben und euch von der aktuellen Stelle entfernen, bevor eventuell Feinde zu euch gelangen.", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Wie komme ich hier am schnellsten Weg?",conditions, last));
        last = createMessage("Bei jeder Verbindung zu einem Port werden einige Informationen des Raumschiffs mitgeschickt. Durch die in deinem Raumschiff verbaute experimentelle Technologie war es uns möglich, herauszufinden, dass du es bist. Du bist der einzige Widerständler, dem wir es erlaubt haben, mit dieser Technologie in der Galaxis herumzufliegen. Das bringt aber auch Gefahren mit sich. Die verbaute Technologie darf auf keinen Fall in die Hände der Sith gelangen, denn sonst sind wir alle verloren. Wenn die Siths wie wir, die Ports durchleuchtet haben, sind sie vielleicht schon auf dem Weg zu dir! Daher müssen wir dein Raumschiff schnellstmöglich da wegschaffen.", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Woher wusstet ihr, dass ich das bin?",conditions, last));
        G2 = createMessage("Nachdem du von allen Radaren verschwunden bist, haben wir alle Kommunikations-Ports der Galaxis mehrmals durchleuchtet. Wir hatten schon gehofft, dass du dich mit einem verbinden wirst, und wir dich so dann ausfindig machen können.", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Wie habt ihr mich gefunden?",conditions, G2));
        last = createMessage("Erinnerst du dich garnicht mehr? Der Absturz scheint dir doch ordentlich zugesetzt zu haben. Lass uns erstmal schnellstmöglich dafür sorgen, dass du nach Hause kommst.", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Was ist passiert?",conditions, last));
        dialogOptions.add(createDialogOption("Wie habt ihr mich gefunden?",conditions, G2));
        last = createMessage("Seid gegrüßt! Ist alles okay bei dir? Nach deinem Absturz haben wir die halbe Galaxis nach dir durchsucht.", manager.getContactByFirstName("Jedi-Stützpunkt"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Ich fürchte Nein. Wir werden hier wohl verenden!", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Bleibt uns denn keine andere Möglichkeit mehr?",conditions, last));
        last = createMessage("Hast du die falsche Adresse angegeben? Kein Wunder, dass sich niemand meldet! Wir haben keine Kraft mehr, uns mit dem Kommunikations-Port neu zu verbinden.. Das müssten wir nämlich tun, um uns mit der richtigen Adresse zu verbinden!", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        FalscheAdresse = createMessage("Verbindung von Kommunikations-Port zu angegebener Adresse wurde aufgebaut.", manager.getContactByFirstName("□□Ä□~□-Kommunikations-Port"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("TESTTESTTEST",conditions, FalscheAdresse));
        dialogOptions.add(createDialogOption("BLABLABLA",conditions, RichtigeAdresse));
        dialogOptions.add(createDialogOption("???????????",conditions, FalscheAdresse));
        Adresse = createMessage("Bitte gewünschte Zieladresse eingeben.", manager.getContactByFirstName("□□Ä□~□-Kommunikations-Port"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, Adresse));
        last = createMessage("Die Kommunikationsadresse lautet: BLABLABLA", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Aha",conditions, Adresse));
        dialogOptions.add(createDialogOption("Wie lautet überhaupt die Kommunikationsadresse?",conditions, last));
        last = createMessage("Der Name des Kommunikations-Ports entspricht einer deiner Spezies fremden Schrift und kann daher hier nicht vernünftig angezeigt werden… Sieht so aus, als könnten die Fonts der Smartphone-Software hier ein Update vertragen.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("VERBINDUNG HERGESTELLT. Beachte, dass wir nur über die gespeicherte Adresse kommunizieren um Risiken zu vermeiden!", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Wir konnten jemanden erreichen! Hoffen wir jetzt das Beste… VERBINDUNG WIRD AUFGEBAUT…", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("3. VERSUCH: Von den 5 aufgespürten Ports ist dies derjenige, der am weitesten entfernt ist. Er befindet sich auf dem Hauptplaneten des Mondes, auf dem wir uns gerade befinden. VERBINDUNGSANFRAGE…", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("VERBINDUNG WURDE GESCHLOSSEN. Also DAS war sicher kein Kommunikations-Port. Nur noch ein letzter Versuch!", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("EWWWWWWWAAAAAA", manager.getContactByFirstName("???"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("VERBINDUNG HERGESTELLT.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Wir konnten jemanden am Port erreichen! VERBINDUNG WIRD AUFGEBAUT…", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("2. VERSUCH: VERBINDUNGSANFRAGE…", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Wir erhalten keine Antwort vom Port. Noch zwei Versuche!", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("...", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("1. VERSUCH: VERBINDUNGSANFRAGE…", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Port 1",conditions, last));
        dialogOptions.add(createDialogOption("Port 2",conditions, last));
        dialogOptions.add(createDialogOption("Port 3",conditions, last));
        dialogOptions.add(createDialogOption("Port 4",conditions, last));
        dialogOptions.add(createDialogOption("Port 5",conditions, last));
        last = createMessage("Ich konnte 5 verschiedene Kommunikations-Ports aufspüren, mit deren Hilfe wir eine zur hinterlegten Kommunikationsadresse aufbauen könnten. Die Kraft reicht jedoch für maximal 3 Verbindungen zu den Ports, da wir noch eine Menge der ohnehin schon wenigen Kraft brauchen, um das anschließende Notsignal durchzureichen. Wähle daher mit Bedacht!", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        Verbindung = createMessage("ORTUNG.…", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Dann los!",conditions, Verbindung));
        C3 = createMessage("Ich bedauere, dass uns keine Wahl bleibt. Es sei denn du hast eine andere Idee.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Dann los!",conditions, Verbindung));
        last = createMessage("Sie arbeiten in der Regel automatisiert. Es kann aber natürlich nie ausgeschlossen werden, dass der Kommunikations-Port missbraucht wird, in etwa durch Abhörung.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Haben wir denn keine andere Möglichkeit?",conditions, last));
        dialogOptions.add(createDialogOption("Dann los!",conditions, Verbindung));
        last = createMessage("Kommunikations-Ports gibt es auf den meisten Planeten in der Galaxis. Sie sind praktisch ein eigener Sender, jedoch mit einer viel höheren Reichweite. Raumschiffe können Sie in etwa als Repeater benutzen, um unser Kommunikationssignal an weiter entfernte Standorte durchzureichen.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Kommunikations-Ports?",conditions, last));
        dialogOptions.add(createDialogOption("Haben wir denn keine andere Möglichkeit?",conditions, C3));
        dialogOptions.add(createDialogOption("Dann los!",conditions, Verbindung));
        last = createMessage("Ich habe von der Ursprungsmission eine Kommunikationsadresse hinterlegt. Unsere Energiereserven reichen aufgrund der großen Entfernung nicht aus, um unser Notsignal direkt an die Adresse durchzureichen.Ich schlage daher vor, eine Kommunikation zu einem der nächstgelegenen Kommunikations-Ports anzufordern. Die Erfolgsrate ist jedoch eingeschränkt.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Was können wir jetzt tun?",conditions, last));
        Verbindung = createMessage("Bei der experimentellen Technologie handelt es sich um höchstmoderne Raumschiffstechnologie, an der noch geforscht wird. Sie wird für verschiedene Zwecke vom Widerstand genutzt, um gegen die mächtige Sith anzukämpfen.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Was ist diese experimentelle Technologie?",conditions, last));
        Verbindung = createMessage("Merkwürdig… Bei den wenigen für mich auslesbaren im Schiff verbauten Teile handelt es sich um experimentelle Technologie.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        Verbindung = createMessage("Ich kann die Schiffsinformationen nicht in Gänze abrufen, sondern nur einzelne verbaute Teile.Ich versuche diese mal zu analysieren… ANALYSIERE…", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Wo befinde ich mich hier?",conditions, last));
        Verbindung = createMessage("Das Terminaldisplay ist beschädigt, daher erfolgt die Sicherstellung der Kommunikation über dein Smartphone.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Wo befinde ich mich hier?",conditions, last));
        Verbindung = createMessage("Das Terminaldisplay ist beschädigt, daher erfolgt die Sicherstellung der Kommunikation über dein Smartphone.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Warum bekomme ich diese Nachrichten auf meinem Smartphone?",conditions, last));
        Verbindung = createMessage("Wir sind abgestürzt. Die Ursache dafür kann ich durch die verschiedenen Beschädigungen am Speichermodul nicht auslesen.Ob die Informationen komplett gelöscht wurden oder aktuell einfach nicht zugänglich sind, kann ich nicht sagen.", manager.getContactByFirstName("D2R2"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Was ist passiert?",conditions, last));
        Verbindung = createMessage("--NOTFALLREPORT --ABSTURZURSACHE: Energieabfall durch unbekannt SCHIFFSSTATUS: kritisch ENERGIESTATUS: kritisch WEITERES: Energie für Abflug unzureichend; durch technische Schäden nur noch Kurzstreckenflug möglich PLANET: unbekannt KLASSE: Mond REGION: Äußerer RandSEKTOR: unbekannt SYSTEM: unbekannt LANDSCHAFT: Wüste ATMOSPHÄRE: Stickstoff Klima: Kalt", manager.getContactByFirstName("D2R2"), dialogOptions);
    }

    private void importSithMessages(){
        ArrayList<DialogOption> dialogOptions;
        ArrayList<Condition> conditions;

        Message last = new Message();
        Message EndeRebellen = new Message();
        Message EndeSith = new Message();
        Message Scan = new Message();
        Message keinScan = new Message();


        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, null));
        last = createMessage("Gut gemacht. Du bist des Imperators würdig. Der Rettungstrupp sollte gleich bei dir eintreffen.", manager.getContactByFirstName("Hauptquartier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Starte den Beschuss!",conditions, last));
        last = createMessage("Waffensysteme bereit.", manager.getContactByFirstName("Bordcomputer"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Ok, ich werde alles vorbereiten.",conditions, last));
        EndeSith = createMessage("Gut, warte noch, bis wir in der Nähe sind und starte dann den Beschuss.", manager.getContactByFirstName("Hauptquartier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Ok, ich werde alles vorbereiten.",conditions, EndeSith));
        last = createMessage("OK, wir werden Sie einsammeln, bei dem kleinsten Anzeichen von einem Hinterhalt werden wir Sie zerstören.", manager.getContactByFirstName("Rebellenbasis"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption(" Ich bin ein Überläufer und möchte euch geheime Informationen übergeben.",conditions, last));
        EndeRebellen = createMessage("Feindliches Signal, geben Sie sich zu erkennen. ", manager.getContactByFirstName("Rebellenbasis"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Das könnt ihr doch nicht tun!",conditions, null));
        dialogOptions.add(createDialogOption("Bevor ich sterbe wechsle ich lieber die Seite und laufe zu den Rebellen über!",conditions, EndeRebellen));
        last = createMessage("Du bist eine Schande für das Imperium und nicht Wert, gerettet zu werden.", manager.getContactByFirstName("Hauptquartier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Es sind zu viele Feinde… Ihr müsst mich retten!",conditions, last));
        dialogOptions.add(createDialogOption("Es sind viele Feinde in der Nähe. Ich könnte sie anlocken damit ihr ihnen in den Rücken fallen könnt. Das wäre ein großer Schlag für das Imperium.",conditions, EndeSith));
        last = createMessage("Wie sieht die Lage aus?", manager.getContactByFirstName("Hauptquartier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Starte den Beschuss!",conditions, null));
        dialogOptions.add(createDialogOption("Tarnmodus aktivieren",conditions, last));
        last = createMessage("Mehrere Feinde in der Nähe.", manager.getContactByFirstName("Bordcomputer"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Scanne die Gegend nach Feinden.",conditions, last));
        Scan = createMessage("", manager.getContactByFirstName("Bordcomputer"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Wartet… Das kann nicht sein…",conditions, null));
        dialogOptions.add(createDialogOption("Bevor ich sterbe wechsle ich lieber die Seite und laufe zu den Rebellen   über!",conditions, EndeRebellen));
        last = createMessage("Das Rettungsschiff ist in einen Hinterhalt geraten. Das ist Verrat! Wir werden dich Auslöschen!", manager.getContactByFirstName("Hauptquartier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        keinScan = createMessage("OK, wir schicken einen Trupp um dich heraus zu holen.", manager.getContactByFirstName("Hauptquartier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Ich bin mir sicher, dass keine Feinde in der Gegend sind.",conditions, keinScan));
        dialogOptions.add(createDialogOption("In Ordnung, Ich werde es versuchen.",conditions, Scan));
        last = createMessage("Agent, ist dein Radar einsatzbereit? Kannst du nach Feinden in der Nähe Scannen?", manager.getContactByFirstName("Hauptquartier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Ich hatte einen technischen Defekt und bin auf Dathomir abgestürzt. Das Schiff ist nicht mehr Einsatzbereit.",conditions, keinScan));
        dialogOptions.add(createDialogOption("Ich weiß nicht mehr... Ich bin auf Dathomir abgestürzt und das Schiff ist nicht mehr einsatzbereit.",conditions, last));
        dialogOptions.add(createDialogOption("Ich bin bei Dathomir in einen Hinterhalt der Rebellen geraten und abgestürzt. Das Schiff ist nicht mehr einsatzbereit.",conditions, last));
        last = createMessage("Was ist passiert? Wir haben seit Stunden keinen Kontakt mehr zu dir.", manager.getContactByFirstName("Hauptquartier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Hier ist Agent 5341. Ich benötige Hilfe.",conditions, last));
        last = createMessage("Unbekanntes Signal, identifizieren Sie sich.", manager.getContactByFirstName("Hauptquartier"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Verbinde mich mit dem Hauptquartier.",conditions, last));
        last = createMessage("Der derzeitige Standort ist der Planet Dathomir im gleichnamigen Sternensystem.", manager.getContactByFirstName("Bordcomputer"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Wo bin ich gelandet?",conditions, last));
        last = createMessage("Fahrwerk und Hauptantrieb nicht einsatzbereit.", manager.getContactByFirstName("Bordcomputer"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Schadensbericht",conditions, last));
        last = createMessage("Es gab eine Fehlzündung im Gravitationsantrieb. Es folgte ein Absturz auf den Planeten.", manager.getContactByFirstName("Bordcomputer"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("Was ist Passiert?",conditions, last));
        last = createMessage("Warnung kritischer Schaden…", manager.getContactByFirstName("Bordcomputer"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Warnung kritischer Schaden…", manager.getContactByFirstName("Bordcomputer"), dialogOptions);

        conditions = new ArrayList<Condition>();
        dialogOptions = new ArrayList<DialogOption>();
        dialogOptions.add(createDialogOption("",conditions, last));
        last = createMessage("Warnung kritischer Schaden…", manager.getContactByFirstName("Bordcomputer"), dialogOptions);
    }

    private Message createMessage(String text, Contact author, List<DialogOption> dialogOptions){
        Message message = new Message();
        message.setText(text);
        message.setAuthor(author);
        message.setDialogOptions(dialogOptions);
        initManager.saveMessage(message);
        return message;
    }

    private DialogOption createDialogOption(String text, List<Condition> conditions, Message answer){
        DialogOption option = new DialogOption();
        option.setText(text);
        option.setConditions(conditions);
        option.setAnswer(answer);
        initManager.saveDialogOption(option);
        return option;
    }

}