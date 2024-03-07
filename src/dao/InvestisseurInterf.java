package dao;

import model.Client;
import model.Investisseur;

public interface InvestisseurInterf {
    void addInvestisseur(Investisseur client);

    Investisseur getInvestisseur(String email);

    String[] getPasswordSalt(String email);
}
