package dao;

import model.Client;

public interface ClientInterf {
    void addClient(Client client);


    String[] getPasswordSalt(String email);

}
