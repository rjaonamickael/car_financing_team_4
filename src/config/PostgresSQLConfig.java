package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresSQLConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public static Connection connect() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }


    //Initialization de la base de données

    public static void initialisationDB(){
        // Création de la table Client
        String createTableSQL = "CREATE TABLE IF NOT EXISTS client (" +
                "nomComplet VARCHAR(50)," +
                "adressemail VARCHAR(50) PRIMARY KEY," +
                "mdp VARCHAR(300)," +
                "salt VARCHAR(50)," +
                "phoneNumero VARCHAR(20)," +
                "infoEmploi VARCHAR(100)," +
                "revenuAnnuel INT," +
                "creditNote INT," +
                "datenaiss Date," +
                "statutMarital VARCHAR(20)," +
                "nbrJourAuCanada INT" +
                ");";
        // Création de la table investisseur
        createTableSQL += "CREATE TABLE IF NOT EXISTS investisseur (" +
                "nomComplet VARCHAR(50)," +
                "adressemail VARCHAR(50) PRIMARY KEY," +
                "mdp VARCHAR(300)," +
                "salt VARCHAR(50)," +
                "phoneNumero VARCHAR(20)," +
                "banqueNom VARCHAR(20)," +
                "banqueDetailsCompte VARCHAR(100)," +
                "niveauRisque VARCHAR(20)," +
                "niveauEducInvest VARCHAR(10)" +
                ");";

        try (Connection conn = connect() ; Statement statement = conn.createStatement()){
            statement.execute(createTableSQL);
            System.out.println("Tables crées");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
