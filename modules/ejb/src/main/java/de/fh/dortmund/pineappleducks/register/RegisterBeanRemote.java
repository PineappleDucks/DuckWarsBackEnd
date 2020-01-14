package de.fh.dortmund.pineappleducks.register;

import javax.ejb.Remote;

@Remote
public interface RegisterBeanRemote {
    String persist (String email, String password);
}