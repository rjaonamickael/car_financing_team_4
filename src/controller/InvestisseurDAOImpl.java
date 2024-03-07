package controller;

import config.PostgresSQLConfig;
import dao.InvestisseurInterf;
import model.Investisseur;

import java.sql.*;

import static config.PostgresSQLConfig.connect;

public class InvestisseurDAOImpl implements InvestisseurInterf {
    @Override
    public void addInvestisseur(Investisseur investisseur) {
        String  sql = "INSERT INTO investisseur " +
                        "(nomComplet, adressemail, mdp, salt, phoneNumero, banqueNom," +
                        "banqueDetailsCompte, niveauRisque, niveauEducInvest) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection connection = connect();

            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1,investisseur.nomComplet);
            pstmt.setString(2,investisseur.adressemail);
            pstmt.setString(3,investisseur.mdp);
            pstmt.setString(4,investisseur.salt);
            pstmt.setString(5,investisseur.phoneNumero);
            pstmt.setString(6,investisseur.banqueNom);
            pstmt.setString(7,investisseur.banqueDetailsCompte);
            pstmt.setString(8,investisseur.niveauRisque);
            pstmt.setString(9,investisseur.niveauEducInvest);

            pstmt.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Investisseur getInvestisseur(String email) {

        return null;
    }

    public String[] getPasswordSalt(String email){

        try (Connection conn = connect() ; Statement statement = conn.createStatement()){

            String query = "SELECT mdp, salt FROM investisseur WHERE adressemail = '"+email+"' ;";

            ResultSet resultat = statement.executeQuery(query);
            if(resultat.next()){
                return new String[]{String.valueOf(resultat.getArray("mdp")), String.valueOf(resultat.getArray("salt"))};
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        catch (Exception exc){
            exc.printStackTrace();
            System.out.println("user introuvable");
        }

        return null;
    }


}
