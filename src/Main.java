import config.PostgresSQLConfig;
import view.FinancingFormView;
import view.InvestmentManagementPage;
import view.LoginView;
import view.RegisterView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel cardPanel = new JPanel(cardLayout);
    private JPanel mainPanel = new JPanel(new GridBagLayout());
    private LoginView loginView = new LoginView();
    private RegisterView registerView = new RegisterView();

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
        ImageIcon carIcon = new ImageIcon("C:\\Users\\webds\\Desktop\\car_financing_team_4-main\\car_financing_team_4-main\\src\\car.jpg");
        JLabel carLabel = new JLabel(carIcon);

        // Ajouter le titre et la description des services de financement
        JLabel titleLabel = new JLabel("Bienvenue chez Financement Automobile XYZ");
        JLabel descriptionLabel = new JLabel("Nous offrons des services de financement automobile fiables et flexibles.");

        // Ajouter les informations de contact
        JLabel contactLabel = new JLabel("Numéro de Contact: +514-123-4567 | info@financementautomobilexyz.ca");

        // Boutons de navigation
        JButton loginButton = new JButton("Connexion");
        JButton registerButton = new JButton("Inscription");
        JButton demandeFinancementButton = new JButton("Formulaire de demande de financement");
        JButton statusFinancementButton = new JButton("Status demande de financement");
        JButton investmentManagementButton = new JButton("Gestion des Investissements"); // Bouton pour accéder à la gestion des investissements

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

        gbc.gridy = 8;
        mainPanel.add(demandeFinancementButton, gbc);

        gbc.gridy = 9;
        mainPanel.add(statusFinancementButton, gbc);

        gbc.gridy = 10; // Position du bouton "Gestion des Investissements"
        mainPanel.add(investmentManagementButton, gbc); // Ajout du bouton "Gestion des Investissements"

        // Ajouter le panel au cardPanel
        cardPanel.add(mainPanel, "Main");
        cardPanel.add(loginView, "Login");
        cardPanel.add(registerView, "Register");

        add(cardPanel);

        loginButton.addActionListener(e -> cardLayout.show(cardPanel, "Login"));
        registerButton.addActionListener(e -> cardLayout.show(cardPanel, "Register"));

        demandeFinancementButton.addActionListener(e -> {
            FinancingFormView financingFormView = new FinancingFormView();
            cardPanel.add(financingFormView, "FinancingForm");
            cardLayout.show(cardPanel, "FinancingForm");
        });

        // Ajouter un ActionListener pour le bouton "Status demande de financement"
        statusFinancementButton.addActionListener(e -> showStatusFinancementView());

        // Ajouter un ActionListener pour le bouton "Gestion des Investissements"
        investmentManagementButton.addActionListener(this::actionPerformed);
    }

    private void showStatusFinancementView() {
        // Créer une instance de la vue du statut de la demande de financement
        StatusFinancementView statusFinancementView = new StatusFinancementView();

        // Ajouter la vue au cardPanel
        cardPanel.add(statusFinancementView, "StatusFinancement");

        // Afficher la vue du statut de la demande de financement
        cardLayout.show(cardPanel, "StatusFinancement");
    }

    private void actionPerformed(ActionEvent e) {
        InvestmentManagementPage investmentManagementPage = new InvestmentManagementPage();
        cardPanel.add(investmentManagementPage, "InvestmentManagement");
        cardLayout.show(cardPanel, "InvestmentManagement");
    }
}

