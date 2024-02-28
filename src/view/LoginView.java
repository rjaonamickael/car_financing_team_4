package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginView extends JPanel {
    private JTextField emailField = new JTextField(20);
    private JPasswordField passwordField1 = new JPasswordField(20);
    private JPasswordField passwordField2 = new JPasswordField(20);

    public LoginView() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Adresse électronique:"), gbc);

        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Mot de passe:"), gbc);

        gbc.gridx = 1;
        add(passwordField1, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Répéter votre mot de passe:"), gbc);

        gbc.gridx = 1;
        add(passwordField2, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Se Connecter");
        add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAction();
            }
        });
    }

    private void loginAction() {
        // Récupérer les informations saisies lors de la connexion
        String email = emailField.getText();
        String password1 = new String(passwordField1.getPassword());
        String password2 = new String(passwordField2.getPassword());

        //Vérification des champs saisie
        if( verifChampSaisi(email, password1, password2) ){
            // Assurer la sécurité des mots de passe (vous pouvez implémenter une logique de hachage ici)
            // Pour cet exemple, nous imprimons simplement les informations
            System.out.println("Adresse électronique: " + email);
            System.out.println("Mot de passe: " + password1);

            // Réinitialiser les champs après la connexion
            emailField.setText("");
            passwordField1.setText("");
            passwordField2.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null, "Saisissez correctement les champs !",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }



    private boolean verifChampSaisi(String email, String password1, String password2){
        if( email.equals("") || password1.equals("")|| password2.equals("") ){
            return false;
        }
        if(password1.equals(password2) && regex(password1)){
            JOptionPane.showMessageDialog(null, "email :"+email+"\n mot de passe :"+password1,
                    "Connecté", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

    private boolean regex(String password){

        //Définition de l'expression régulière
        String regex  = ".*\\d.*[A-Z].*[@#$%^&*!</>].*|.*[A-Z].*[@#$%^&*!</>].*\\d.*|.*[@#$%^&*!</>].*[A-Z].*\\d.*|" +
                        ".*\\d.*[@#$%^&*!</>].*[A-Z].*|.*[A-Z].*\\d.*[@#$%^&*!</>].*|.*[@#$%^&*!</>].*\\d.*[A-Z].*";

        // Créer un objet Pattern en compilant l'expression régulière
        Pattern pattern = Pattern.compile(regex);

        //Matching avec l'expression régulière
        Matcher matcher = pattern.matcher(password);

        if(password.length() > 7 && matcher.matches()){
            return true;
        }
        else{
            return false;
        }

    }
}
