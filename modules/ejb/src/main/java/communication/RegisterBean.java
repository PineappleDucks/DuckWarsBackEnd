package communication;

import database.UserManager;
import entity.InterfaceMessage;
import entity.user.RegisterCredential;
import entity.user.User;

import javax.ejb.Stateless;

@Stateless
public class RegisterBean {

    public RegisterBean () { }

    public InterfaceMessage persist (RegisterCredential credential) {
        String username = credential.getUsername();

        InterfaceMessage message = checkForExistingUsername(username);

        if(!message.getSuccessful()){
            return message;
        }

        return registerUserAndCheck(credential);
    }

    private InterfaceMessage checkForExistingUsername(String username){
        UserManager manager = new UserManager();
        User user = manager.getUserByName(username);

        InterfaceMessage message = new InterfaceMessage();

        if(user == null){
            message.setSuccessful(true);
        }else{
            message.setSuccessful(false);
            message.setMessage("Der Nutzername ist bereits vergeben!");
        }
        return message;
    }

    private InterfaceMessage registerUserAndCheck(RegisterCredential credential){

        String username = credential.getUsername();
        String password = credential.getPassword();

        InterfaceMessage message = new InterfaceMessage();
        UserManager manager = new UserManager();

        manager.registerUser(username, password);

        User savedUser = manager.getUserByName(username);
        if(savedUser.getUsername().equals(username)
                && savedUser.getPassword().equals(password)){
            message.setSuccessful(true);
            message.setMessage("Die Registrierung war erfolgreich!");
        }else {
            message.setSuccessful(false);
            message.setMessage("Es ist ein Fehler beim abspeichern des Nuzters aufgetreten!");
        }

        return message;
    }
}