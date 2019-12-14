package de.fh.dortmund.pineappleducks.initEJB;

import java.util.LinkedHashMap;

public class Init implements java.io.Serializable{
    String id;
    //side = Story:Jedi=true, Sith=false
    boolean side;

    public Init (LinkedHashMap map) throws ConstructException{
        if (map.containsKey("id")) {
            this.id = map.get("id").toString();
        }
        else throw new ConstructException("Es wurde keine ID uebermittelt! uebermittelte Daten:"+map.toString());

        if (map.containsKey("side")){
            if (map.get("side").equals("true")) {
                this.side=true;
            }
            else {
                if (map.get("side").equals("false")) {
                    this.side = false;
                }
                else throw new ConstructException("Side hat einen ungueltigen Wert! uebermittelte Daten:"+map.toString());
            }
        }
        else throw new ConstructException("Es wurde keine Side uebermittelt! uebermittelte Daten:"+map.toString());
    }

    public Init(String id, boolean side) {
        this.id = id;
        this.side = side;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isSide() {
        return side;
    }

    public void setSide(boolean side) {
        this.side = side;
    }
}
