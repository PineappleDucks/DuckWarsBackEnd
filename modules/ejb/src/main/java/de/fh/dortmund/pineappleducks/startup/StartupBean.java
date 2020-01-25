package de.fh.dortmund.pineappleducks.startup;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import de.fh.dortmund.pineappleducks.entity;

@Startup
@Singleton
public class StartupBean {

    @PostConstruct
    public void init(){
        importConditions();
        importMessages();
    }

    private void importConditions(){
        //TODO Conditions importieren
    }

    private void importMessages(){
        importJediMessages();
        importSithMessages();
    }

    private void importJediMessages(){
        List<Contact> contacts = new List<Contact>();
        List<ServerMessage> smessages = new List<ServerMessage>();
        List<Message> dialogOptions;
        List<Message> messages = new List<Message>();

        Contact contact;
        ServerMessage smes;
        Message;

        contact = new Contact();
        contact.setFirstName("D2R2");
        contacts.add(contact);

        smes = new ServerMessage()
        smes.setMessageId(1000);
        smes.setText("--NOTFALLREPORT -- ABSTURZURSACHE: Energieabfall durch unbekannt SCHIFFSSTATUS: kritisch ENERGIESTATUS: kritisch WEITERES: Energie für Abflug unzureichend; durch technische Schäden nur noch Kurzstreckenflug möglich PLANET: unbekannt KLASSE: Mond REGION: Äußerer Rand SEKTOR: unbekannt SYSTEM: unbekannt LANDSCHAFT: Wüste ATMOSPHÄRE: Stickstoff Klima: Kalt");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Was ist Passiert?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1001);
        smes.setText("Wir sind abgestürzt. Die Ursache dafür kann ich durch die verschiedenen Beschädigungen am Speichermodul nicht auslesen.Ob die Informationen komplett gelöscht wurden oder aktuell einfach nicht zugänglich sind, kann ich nicht sagen.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Warum bekomme ich diese Nachrichten auf meinem Smartphone?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1002);
        smes.setText("Das Terminaldisplay ist beschädigt, daher erfolgt die Sicherstellung der Kommunikation über dein Smartphone.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Wo befinde ich mich hier?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1003);
        smes.setText("Ich kann die Schiffsinformationen nicht in Gänze abrufen, sondern nur einzelne verbaute Teile.Ich versuche diese mal zu analysieren… ANALYSIERE…");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1004);
        smes.setText("Merkwürdig… Bei den wenigen für mich auslesbaren im Schiff verbauten Teile handelt es sich um experimentelle Technologie.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Was ist diese experimentelle Technologie?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1005);
        smes.setText("Bei der experimentellen Technologie handelt es sich um höchstmoderne Raumschiffstechnologie, an der noch geforscht wird. Sie wird für verschiedene Zwecke vom Widerstand genutzt, um gegen die mächtige Sith anzukämpfen.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Was können wir jetzt tun?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1006);
        smes.setText("Ich habe von der Ursprungsmission eine Kommunikationsadresse hinterlegt. Unsere Energiereserven reichen aufgrund der großen Entfernung nicht aus, um unser Notsignal direkt an die Adresse durchzureichen.Ich schlage daher vor, eine Kommunikation zu einem der nächstgelegenen Kommunikations-Ports anzufordern. Die Erfolgsrate ist jedoch eingeschränkt.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Dann los!");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        mes = new Message()
        mes.setText("Kommunikations-Ports?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        mes = new Message()
        mes.setText("Haben wir denn keine andere Möglichkeit?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1007);
        smes.setText("Ich bedauere, dass uns keine Wahl bleibt. Es sei denn du hast eine andere Idee.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1008);
        smes.setText("Kommunikations-Ports gibt es auf den meisten Planeten in der Galaxis. Sie sind praktisch ein eigener Sender, jedoch mit einer viel höheren Reichweite. Raumschiffe können Sie in etwa als Repeater benutzen, um unser Kommunikationssignal an weiter entfernte Standorte durchzureichen.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Sind diese Kommunikations-Ports gefährlich?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1009);
        smes.setText("Sie arbeiten in der Regel automatisiert. Es kann aber natürlich nie ausgeschlossen werden, dass der Kommunikations-Port missbraucht wird, in etwa durch Abhörung.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1010);
        smes.setText("ORTUNG.…");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1011);
        smes.setText("Ich konnte 5 verschiedene Kommunikations-Ports aufspüren, mit deren Hilfe wir eine zur hinterlegten Kommunikationsadresse aufbauen könnten.Die Kraft reicht jedoch für maximal 3 Verbindungen zu den Ports, da wir noch eine Menge der ohnehin schon wenigen Kraft brauchen, um das anschließende Notsignal durchzureichen.Wähle daher mit Bedacht!");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Port 1");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        mes = new Message()
        mes.setText("Port 2");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        mes = new Message()
        mes.setText("Port 3");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        mes = new Message()
        mes.setText("port 4");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        mes = new Message()
        mes.setText("Port 5");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1012);
        smes.setText("1. Versuch: VERBINDUNGSANFRAGE...");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1013);
        smes.setText("...");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1014);
        smes.setText("Wir erhalten keine Antwort vom Port.Noch zwei Versuche!");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1015);
        smes.setText("2. Versuch: VERBINDUNGSANFRAGE...");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1016);
        smes.setText("Wir konnten jemanden am Port erreichen! VERBINDUNG WIRD AUFGEBAUT…");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1017);
        smes.setText("VERBINDUNG HERGESTELLT.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1018);
        smes.setText("VERBINDUNG WURDE GESCHLOSSEN.Also DAS war sicher kein Kommunikations-Port.Nur noch ein letzter Versuch!");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1019);
        smes.setText("3. Versuch: Von den 5 aufgespürten Ports ist dies derjenige, der am weitesten entfernt ist. Er befindet sich auf dem Hauptplaneten des Mondes, auf dem wir uns gerade befinden.VERBINDUNGSANFRAGE…");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1020);
        smes.setText("Wir konnten jemanden erreichen! Hoffen wir jetzt das Beste…VERBINDUNG WIRD AUFGEBAUT…");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1021);
        smes.setText("VERBINDUNG HERGESTELLT. Beachte, dass wir nur über die gespeicherte Adresse kommunizieren um Risiken zu vermeiden!");
        smes.setAuthor(contact);
        smessages.add(smes);

        mes = new Message()
        mes.setText("Wie lautet überhaupt die Kommunikationsadresse?");
        messages.add(mes);

        smes = new ServerMessage()
        smes.setMessageId(1022);
        smes.setText("Die Kommunikationsadresse lautet: BLABLABLA");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1023);
        smes.setText("Dann heißt es jetzt wohl Abwarten und Tee trinken!");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Läuft doch alles glatt!");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        mes = new Message()
        mes.setText("Ich habe Zweifel.");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1024);
        smes.setText("Ich weiß nicht, ob wir Ihnen sagen sollten, dass wir mit einer falschen Adresse verbunden waren. Ich habe das Gefühl, dass sie alles dafür tun würden, um die experimentelle Technologie zu wahren.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1025);
        smes.setText("Ich auch... Ich habe das Gefühl, dass sie alles dafür tun würden, um die experimentelle Technologie zu wahren.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1026);
        smes.setText("Die Energiecontainer sind angedockt!");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Lass uns von diesem Mond verschwinden");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        mes = new Message()
        mes.setText("Starte Kurzstreckenflug.");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1027);
        smes.setText("STARTE KURZSTRECKENFLUG…");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1028);
        smes.setText("5...4...3...2...1...ABFLUG");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1029);
        smes.setText("Wir befinden uns jetzt im Orbit des Hauptplanets.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1030);
        smes.setText("VERBINDUNG WURDE ABGEBROCHEN. Der Kommunikations-Port wurde zerstört. Das Imperium hat uns wohl durch die Verbindung mit der falschen Adresse aufspüren können und die komplette Kommunikation angezapft.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Wir müssen uns auf den Planeten stürzen und uns selbst zerstören.");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1031);
        smes.setText("Uns bleibt wohl keine andere Wahl…");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1032);
        smes.setText("Wir sind gerettet!");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1033);
        smes.setText("ALARM Ein Abschuss-Projektil befindet sich gerade auf dem Weg zu uns.Es war schön, für dich gedient zu haben…");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1034);
        smes.setText("Die Eskorte ist eingetroffen! Gott sei Dank!");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1036);
        smes.setText("Der Name des Kommunikations-Ports entspricht einer deiner Spezies fremden Schrift und kann daher hier nicht vernünftig angezeigt werden… Sieht so aus, als könnten die Fonts der Smartphone-Software hier ein Update vertragen.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1039);
        smes.setText("Hast du die falsche Adresse angegeben? Kein Wunder, dass sich niemand meldet! Wir haben keine Kraft mehr, uns mit dem Kommunikations-Port neu zu verbinden..Das müssten wir nämlich tun, um uns mit der richtigen Adresse zu verbinden!");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Bleibt uns denn keine andere Möglichkeit mehr?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1040);
        smes.setText("Ich fürchte Nein. Wir werden hier wohl verenden!");
        smes.setAuthor(contact);
        smessages.add(smes);

        mes = new Message();
        mes.setText("Übertrage die Koordinaten.");
        messages.add(mes);

        smes = new ServerMessage()
        smes.setMessageId(1040);
        smes.setText("ÜBERTRAGE KOORDINATEN…");
        smes.setAuthor(contact);
        smessages.add(smes);

        contact = new Contact();
        contact.setFirstName("???");
        contacts.add(contact);

        smes = new ServerMessage()
        smes.setMessageId(1034);
        smes.setText("EWWWWWWWAAAAAA");
        smes.setAuthor(contact);
        smessages.add(smes);

        contact = new Contact();
        contact.setFirstName("□□Ä□~□-Kommunikations-Port");
        contacts.add(contact);

        smes = new ServerMessage()
        smes.setMessageId(1035);
        smes.setText("□□Ä□~□-Kommunikations-Port");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1037);
        smes.setText("Bitte gewünschte Zieladresse eingeben.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("BLABLABLA");
        messages.add(mes);
        dialogOptions.add(mes);
        mes = new Message()
        mes.setText("afdsgfdsgfdagfdag");
        messages.add(mes);
        dialogOptions.add(mes);
        mes = new Message()
        mes.setText("fdsafhgghjfhkuljhkl");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1038);
        smes.setText("Verbindung von Kommunikations-Port zu angegebener Adresse wurde aufgebaut.");
        smes.setAuthor(contact);
        smessages.add(smes);

        contact = new Contact();
        contact.setFirstName("Jedi-Stützpunkt");
        contacts.add(contact);

        smes = new ServerMessage()
        smes.setMessageId(1041);
        smes.setText("Seid gegrüßt! Ist alles okay bei dir? Nach deinem Absturz haben wir die halbe Galaxis nach dir durchsucht.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Was ist passiert?");
        messages.add(mes);
        dialogOptions.add(mes);
        mes = new Message()
        mes.setText("Wie habt ihr mich gefunden?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1042);
        smes.setText("Erinnerst du dich garnicht mehr? Der Absturz scheint dir doch ordentlich zugesetzt zu haben. Lass uns erstmal schnellstmöglich dafür sorgen, dass du nach Hause kommst.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1043);
        smes.setText("Nachdem du von allen Radaren verschwunden bist, haben wir alle Kommunikations-Ports der Galaxis mehrmals durchleuchtet.Wir hatten schon gehofft, dass du dich mit einem verbinden wirst, und wir dich so dann ausfindig machen können.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Woher wusstet ihr, dass ich das bin?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1044);
        smes.setText("Bei jeder Verbindung zu einem Port werden einige Informationen des Raumschiffs mitgeschickt. Durch die in deinem Raumschiff verbaute experimentelle Technologie war es uns möglich, herauszufinden, dass du es bist.Du bist der einzige Widerständler, dem wir es erlaubt haben, mit dieser Technologie in der Galaxis herumzufliegen.Das bringt aber auch Gefahren mit sich. Die verbaute Technologie darf auf keinen Fall in die Hände der Sith gelangen, denn sonst sind wir alle verloren.Wenn die Siths wie wir, die Ports durchleuchtet haben, sind sie vielleicht schon auf dem Weg zu dir! Daher müssen wir dein Raumschiff schnellstmöglich da wegschaffen.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Wie komme ich hier am schnellsten Weg?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1045);
        smes.setText("Wir haben bereits autonome Energiecontainer losgeschickt, die an euer Raumschiff andocken werden.So könnt ihr zumindest auf dem Kurzstreckenflug in Bewegung bleiben und euch von der aktuellen Stelle entfernen, bevor eventuell Feinde zu euch gelangen.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Dauert das noch lange?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1046);
        smes.setText("Energiecontainer sind neben den Abschussprojektilen unsere schnellsten uns zur Verfügung stehenden mobilen Objekte.Beide arbeiten so, dass wenn sie einmal abgeschickt worden sind, nicht mehr abgebrochen werden können und unermüdlich ihren Weg bis ans Ziel fliegen -es sei denn, sie werden auf dem Weg zerstört.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Cool!");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1054);
        smes.setText("Du wirst in Kürze Koordinaten von uns erhalten. Wir werden dorthin, eine Eskorte schicken. Diese soll ich euch und das Raumschiff sicher zurückbringen.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1055);
        smes.setText("Wartet!");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1056);
        smes.setText("Das ist sehr merkwürdig. Wir nehmen im Umkreis gleich mehrere zerstörte Kommunikations-Ports wahr!");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1063);
        smes.setText("Die Eskorte ist in Kürze da!");
        smes.setAuthor(contact);
        smessages.add(smes);

        contact = new Contact();
        contact.setFirstName("Jedi-Offizier");
        contacts.add(contact);

        smes = new ServerMessage()
        smes.setMessageId(1047);
        smes.setText("Hallo, hier ist der Jedi-Offizier. Im Kreis der Widerstands-Besatzung herrscht Uneinigkeit über dich. Manche munkeln, dass du ein Spion des Imperiums bist.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Ein Spion? Ich?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1048);
        smes.setText("Ich halte diese Aussagen ebenfalls für sehr weit hergeholt. Es gibt jedoch auch berechtigte Bedenken.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Was denn zum Beispiel?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1049);
        smes.setText("Ich halte diese Aussagen ebenfalls für sehr weit hergeholt. Es gibt jedoch auch berechtigte Bedenken.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Was denn zum Beispiel?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1050);
        smes.setText("Das ist der Grund warum ich mich melde. Ich muss dich fragen, warum du dich nicht umgehend über die hinterlegte Adresse ein Notsignal ausgesandt hast.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Wir hatten nicht mehr genug Energie.");
        messages.add(mes);
        dialogOptions.add(mes);
        mes = new Message()
        mes.setText("Wir haben uns mit der falschen Adresse verbunden.");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1051);
        smes.setText("Du warst über diesen Port die ganze Zeit gleichzeitig mit einer unbekannten Adresse verbunden? Dass Feinde dich nun nicht schon ausgemacht haben, ist praktisch ausgeschlossen.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1052);
        smes.setText("Wir müssen unsere Technologie um jeden Preis beschützen und dürfen kein Risiko eingehen.Es tut uns Leid, aber wir haben leider keine Wahl…Für den Widerstand!");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1053);
        smes.setText("Das hatte ich vermutet. Ich werde dies so weitergeben. Kommt Heile wieder.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1057);
        smes.setText("Du wurdest vom Imperium aufgespürt! Wie ist das möglich?!Wir müssen unsere Eskorte abziehen. Sobald die Verbindung abbricht, seid ihr entgültig auf euch allein gestellt.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1058);
        smes.setText("Denkt dran. Die ganze Hoffnung des Widerstands liegt auf deinen Schultern. Die Technologie darf unter keinen Umständen an die Feinde gelangen!");
        smes.setAuthor(contact);
        smessages.add(smes);

        contact = new Contact();
        contact.setFirstName("Mutiger Widerständler");
        contacts.add(contact);

        smes = new ServerMessage()
        smes.setMessageId(1059);
        smes.setText("Hallo? Ich habe eure Kommunikation abhören können. Ich versuche euch zu retten!");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Wer seid ihr?");
        messages.add(mes);
        dialogOptions.add(mes);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1060);
        smes.setText("Ich bin xyz. Mit dem Kommunikations-Port hat sich schon seit Jahren niemand mehr verbunden.Als ich davon gehört habe, musste ich umgehend herausfinden, wer sich dahinter verbirgt.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Warum helft ihr uns?");
        messages.add(mes);
        dialogOptions.add(mes);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1061);
        smes.setText("Ich kämpfe ebenfalls für den Widerstand. Ich hatte schon davon gehört, dass ihr verschwunden seid, jedoch wusste keiner wo. Ich dachte schon, dass wir alle dem Untergang geweiht sind.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1062);
        smes.setText("Für Erklärungen ist später Zeit! Geleitet mich mit zum Hauptplaneten. Ich habe dort einen Unterschlupf.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(1064);
        smes.setText("Wir haben die Koordinaten erhalten. Kommt Heile wieder.");
        smes.setAuthor(contact);
        smessages.add(smes);

        ChatManager cmanager = new ChatManager();
        cmanager.uploadStory(contacts, smessages, messages);
    }

    private void importSithMessages(){
        List<Contact> contacts = new List<Contact>();
        List<ServerMessage> smessages = new List<ServerMessage>();
        List<Message> dialogOptions;
        List<Message> messages = new List<Message>();

        Contact contact;
        ServerMessage smes;
        Message;

        contact = new Contact();
        contact.setFirstName("Bordcomputer");
        contacts.add(contact);

        smes = new ServerMessage()
        smes.setMessageId(2000);
        smes.setText("Warnung kritischer Schaden...");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2001);
        smes.setText("Warnung kritischer Schaden...");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2002);
        smes.setText("Warnung kritischer Schaden...");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Was ist Passiert?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2003);
        smes.setText("Es gab eine Fehlzündung im Gravitationsantrieb. Es folgte ein Absturz auf den Planeten.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Schadensbericht");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2004);
        smes.setText("Fahrwerk und Hauptantrieb nicht Einsatzbereit.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Wo bin ich gelandet?");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2005);
        smes.setText("Der derzeitige Standort ist der Planet Dathomir im gleichnamigen Sternensystem.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Verbinde mich mit dem Hauptquartier.");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2013);
        smes.setText("Scanner bereit.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Scanne die Gegend nach Feinden.");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2014);
        smes.setText("Mehrere Feinde in der Nähe.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Starte den Beschuss!");
        messages.add(mes);
        dialogOptions.add(mes);
        mes = new Message()
        mes.setText("Tarnmodus aktivieren");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2018);
        smes.setText("Waffensysteme bereit.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Starte den Beschuss!");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        contact = new Contact();
        contact.setFirstName("Hauptquartier");
        contacts.add(contact);

        smes = new ServerMessage()
        smes.setMessageId(2006);
        smes.setText("Unbekanntes Signal, identifizieren Sie sich.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Hier ist Agent 5341. Ich benötige Hilfe.");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2007);
        smes.setText("Was ist passiert? Wir haben seit Stunden keinen Kontakt mehr zu dir.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Ich weiß nicht mehr... Ich bin auf Dathomir abgestürzt und das Schiff ist nichtmehr einsatzbereit.");
        messages.add(mes);
        dialogOptions.add(mes);
        mes = new Message()
        mes.setText("Ich hatte einen technischen Defektund bin auf Dathomir abgestürzt.Das Schiff ist nicht mehrEinsatzbereit.");
        messages.add(mes);
        dialogOptions.add(mes);
        mes = new Message()
        mes.setText("Ich bin bei Dathomir in einen Hinterhalt der Rebellen geraten und abgestürzt. Das Schiff ist nicht mehr einsatzbereit");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2008);
        smes.setText("Agent, ist dein Radar einsatzbereit? Kannstdu nach Feinden in der NäheScannen?");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Ich bin mir sicher, dasskeineFeinde in der Gegend sind.");
        messages.add(mes);
        dialogOptions.add(mes);
        mes = new Message()
        mes.setText("In Ordnung, Ich werde es versuchen.");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2009);
        smes.setText("OK, wir schicken einen Trupp um dich heraus zu holen.");
        smes.setAuthor(contact);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2010);
        smes.setText("Das Rettungsschiff ist in einen Hinterhalt geraten. Das ist Verrat! Wir werden dich Auslöschen!");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Wartet...Das kann nicht sein...");
        messages.add(mes);
        dialogOptions.add(mes);
        mes = new Message()
        mes.setText("Bevor ich sterbe wechsleich lieber die Seite und laufe zu den Rebellen über!");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2015);
        smes.setText("Wie sieht die Lage aus?");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Es sind zu viele Feinde...Ihr müsst mich retten!");
        messages.add(mes);
        dialogOptions.add(mes);
        mes = new Message()
        mes.setText("Es sind viele Feinde in der Nähe.Ich könnte sie anlocken damit ihr ihnen in den Rückenfallen könnt. Das wäre ein großer Schlag für dasImperium.");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2016);
        smes.setText("Du bist eine Schande für dasImperium und nicht Wert, gerettet zu werden.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Das könnt ihr doch nicht tun!");
        messages.add(mes);
        dialogOptions.add(mes);
        mes = new Message()
        mes.setText("Bevor ich sterbe wechsleich lieber die Seite und laufe zu den Rebellen über!");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2017);
        smes.setText("Gut, warte noch, bis wir in der Nähe sind und starte dann den Beschuss.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Ok, ich werde alles vorbereiten.");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2019);
        smes.setText("Gut gemacht. Du bist des Imperators würdig. Der Rettungstrupp sollte gleich bei dir eintreffen.");
        smes.setAuthor(contact);
        smessages.add(smes);

        contact = new Contact();
        contact.setFirstName("Rebellenbasis");
        contacts.add(contact);

        smes = new ServerMessage()
        smes.setMessageId(2011);
        smes.setText("Feindliches Signal, geben Sie sich zu erkennen.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Ich bin ein Überläufer und möchte euch geheime Informationen übergeben.");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        smes = new ServerMessage()
        smes.setMessageId(2012);
        smes.setText("OK, wir werden Sie einsammeln, bei dem kleinsten Anzeichen von einem Hinterhalt werden wir Sie zerstören.");
        smes.setAuthor(contact);
        mes = new Message()
        dialogOptions = new List<Message>();
        mes.setText("Bitte beeilen Sie sich, die Sith wissen von meinem Vorhaben.");
        messages.add(mes);
        dialogOptions.add(mes);
        smes.setDialogOptions(dialogOptions);
        smessages.add(smes);

        ChatManager cmanager = new ChatManager();
        cmanager.uploadStory(contacts, smessages, messages);

    }


}
