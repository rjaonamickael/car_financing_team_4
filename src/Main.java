import config.PostgresSQLConfig;
import view.FinancingFormView;
import view.InvestmentManagementPage;
import view.LoginView;
import view.MainExtendedView;
import view.RegisterView;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private JPanel mainPanel = new JPanel(new GridBagLayout());
    private LoginView loginView = new LoginView();
    private RegisterView registerView = new RegisterView();
    private MainExtendedView mainExtendedView = new MainExtendedView(); // Ajout de la nouvelle page MainExtendedView

    public static void main(String[] args) {
        PostgresSQLConfig.initialisationDB();
        SwingUtilities.invokeLater(() -> {
            Main frame = new Main();
            frame.setVisible(true);
        });
    }

    public Main() {
        setTitle("Financement Automobile XYZ");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Ajouter une image de fond représentant une voiture stylisée

        ImageIcon carIcon = new ImageIcon("C:\\Users\\webds\\Desktop\\carfinance\\carfinance\\src\\car.jpg");

        JLabel carLabel = new JLabel(carIcon);

        // Ajouter le titre et la description des services de financement
        JLabel titleLabel = new JLabel("Bienvenue chez Financement Automobile XYZ");
        JLabel descriptionLabel = new JLabel("Nous offrons des services de financement automobile fiables et flexibles.");

        // Ajouter les informations de contact
        JLabel contactLabel = new JLabel("Numéro de Contact: +514-123-4567 | info@financementautomobilexyz.ca");

        // Boutons de navigation
        JButton loginButton = new JButton("Connexion");
        JButton registerButton = new JButton("Inscription");

        // Utiliser GridBagLayout pour positionner les composants
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(carLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.gridheight = 1;
        gbc.weighty = 0.0;
        mainPanel.add(titleLabel, gbc);

        gbc.gridy = 4;
        mainPanel.add(descriptionLabel, gbc);

        gbc.gridy = 5;
        mainPanel.add(contactLabel, gbc);

        gbc.gridy = 6;
        mainPanel.add(loginButton, gbc);

        gbc.gridy = 7;
        mainPanel.add(registerButton, gbc);

        // Ajouter le panel au cardPanel
        cardPanel.add(mainPanel, "Main");
        cardPanel.add(loginView, "Login");
        cardPanel.add(registerView, "Register");
        cardPanel.add(mainExtendedView, "MainExtended"); // Ajout de la page MainExtendedView

        add(cardPanel);

        loginButton.addActionListener(e -> cardLayout.show(cardPanel, "Login"));
        // A modifier pour Login

        // Afficher MainExtendedView lors du clic sur le bouton de connexion
        registerButton.addActionListener(e -> cardLayout.show(cardPanel, "Register"));

    }
}

