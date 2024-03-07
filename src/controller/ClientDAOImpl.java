package controller;

import config.PostgresSQLConfig;
import dao.ClientInterf;
import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientDAOImpl implements ClientInterf {
    @Override
    public void addClient(Client client) {
        String  sql = "INSERT INTO client " +
                "(nomComplet, adressemail, mdp, salt, phoneNumero, infoEmploi, revenuAnnuel," +
                "creditNote, datenaiss, statutMarital, nbrJourAuCanada) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

        try {
            Connection connection = PostgresSQLConfig.connect();

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1,client.nomComplet);
            pstmt.setString(2,client.adressemail);
            pstmt.setString(3,client.mdp);
            pstmt.setString(4,client.salt);
            pstmt.setString(5,client.phoneNumero);
            pstmt.setString(6,client.infoEmploi);
            pstmt.setShort(7,client.revenuAnnuel);
            pstmt.setByte(8,client.creditNote);
            pstmt.setDate(9, (java.sql.Date) client.datenaiss);
            pstmt.setString(10,client.statutMarital);
            pstmt.setShort(11,client.nbrJourAuCanada);

            pstmt.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
