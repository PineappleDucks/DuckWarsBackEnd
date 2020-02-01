package internal;

import database.ContactManager;
import entity.chat.Condition;
import entity.chat.Contact;
import entity.chat.DialogOption;
import entity.chat.Message;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.LinkedList;
import java.util.List;

@Startup
@Singleton
public class StoryBean {

    private ContactManager manager = new ContactManager();

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
        createContact("Computer", "", "");
        createContact("Hauptquartier", "", "");
        createContact("Rebellen", "", "");
        createContact("Ende", "", "");
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

    }

    private void importSithMessages(){

    }

    private Message createMessage(String text, Contact author, List<DialogOption> dialogOptions){
        Message message = new Message();
        message.setText(text);
        message.setAuthor(author);
        message.setDialogOptions(dialogOptions);
        return message;
    }

    private DialogOption createDialogOption(String text, List<Condition> conditions, Message answer){
        DialogOption option = new DialogOption();
        option.setText(text);
        option.setConditions(conditions);
        option.setAnswer(answer);
        return option;
    }

}