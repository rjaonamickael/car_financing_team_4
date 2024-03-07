package view;

import config.PostgresSQLConfig;
import controller.InvestisseurDAOImpl;
import dao.InvestisseurInterf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static methods.BiblioMethode.sha256;

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
        String mdpTape = new String(passwordField.getPassword());

        InvestisseurDAOImpl investisseurDAO = new InvestisseurDAOImpl();

        String mdp = investisseurDAO.getPasswordSalt(email)[0];
        String salt = investisseurDAO.getPasswordSalt(email)[1];

        if(mdp.equals( sha256(mdpTape, salt.getBytes() ) ) ){
            JOptionPane.showMessageDialog(LoginView.this, "Vous êtes connecté", "Connecté", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (!salt.equals(null)){
            JOptionPane.showMessageDialog(LoginView.this, "Mot de passe incorrect", "erreur", JOptionPane.ERROR_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(LoginView.this, "Utilisateur introuvable", "erreur", JOptionPane.ERROR_MESSAGE);
        }

    }

}
