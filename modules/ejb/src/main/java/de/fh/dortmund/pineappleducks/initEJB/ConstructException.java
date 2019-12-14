package de.fh.dortmund.pineappleducks.initEJB;

public class ConstructException extends Exception{

    public ConstructException() {
        super();
    }

    public ConstructException(String errorMessage){
        super(errorMessage);
    }
}
