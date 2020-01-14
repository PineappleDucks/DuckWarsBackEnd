package de.fh.dortmund.pineappleducks.register;

import javax.ejb.Local;

@Local
public interface RegisterBeanLocal {

    String persist ( String email, String password);
}
