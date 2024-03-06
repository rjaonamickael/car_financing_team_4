package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginView extends JPanel {
    private JTextField emailField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);

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
        add(passwordField, gbc);

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
        String password = new String(passwordField.getPassword());


        //Vérification des champs saisie
        if( verifChampSaisi(email, password) ){
            // Assurer la sécurité des mots de passe (vous pouvez implémenter une logique de hachage ici)
            // Pour cet exemple, nous imprimons simplement les informations
            System.out.println("Adresse électronique: " + email);
            System.out.println("Mot de passe: " + password);

            // Réinitialiser les champs après la connexion
            emailField.setText("");
            passwordField.setText("");
        }
        else{
            JOptionPane.showMessageDialog(null, "Saisissez correctement les champs !",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }



    private boolean verifChampSaisi(String email, String password){
        if( email.equals("") && password.equals("") ){
            JOptionPane.showMessageDialog(null, "email :"+email+"\n mot de passe :"+password,
                    "Connecté", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        return false;
    }

}
