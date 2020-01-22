package de.fh.dortmund.pineappleducks.startup;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

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
        //TODO Jedi Story importieren
    }

    private void importSithMessages(){
        //TODO Sith Story imporieren
    }


}
