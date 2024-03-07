package methods;

import view.RegisterView;

import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BiblioMethode {
    public static String[] sha256(String mdp, byte[] salt){
        try {
            // Créer une instance de l'algorithme de hachage SHA-256
            MessageDigest digest  = MessageDigest.getInstance("SHA-256");

            //Application du salt à l'algorithme de hachage
            digest.update(salt);

            // Application du hachage
            byte[] hashedBytes = digest.digest(mdp.getBytes());

            // Conversion du tableau de bytes hachés en représentation hexadécimale
            StringBuilder sbMdp = new StringBuilder();
            for (byte b : hashedBytes) {
                sbMdp.append(String.format("%02x", b)); // conversion en représentation hexadécimale sur deux caractères
                // avec un zéro ajouté à gauche si nécessaire.
                // Par exemple, 5 sera converti en "05", et 15 sera converti en "0f".
            }

            //Conversion du salt hexa
            StringBuilder sbSalt = new StringBuilder();
            for (byte b : salt) {
                sbSalt.append(String.format("%02x", b));
            }


            return new String[]{sbMdp.toString(), sbSalt.toString()};

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }


    }

}
