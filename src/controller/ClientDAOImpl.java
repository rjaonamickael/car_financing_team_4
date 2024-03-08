package controller;

import config.PostgresSQLConfig;
import dao.ClientInterf;
import model.Client;

import java.sql.*;

import static config.PostgresSQLConfig.connect;

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

    @Override
    public String[] getPasswordSalt(String email){

        try (Connection conn = connect() ; Statement statement = conn.createStatement()){

            String query = "SELECT mdp, salt FROM client WHERE adressemail = '"+email+"' ;";

            ResultSet resultat = statement.executeQuery(query);
            if(resultat.next()){

                return new String[]{ String.valueOf(resultat.getArray("mdp")),
                        String.valueOf(resultat.getArray("salt"))};
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return new String[]{"",""};
    }
}
