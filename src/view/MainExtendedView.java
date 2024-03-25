package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainExtendedView extends JPanel {
    private JButton retourButton = new JButton("Retour à la page principale"); // Création du bouton retour

    // Ajouter une image de fond représentant une voiture stylisée
    ImageIcon carIcon = new ImageIcon("C:\\Users\\webds\\Desktop\\carfinance\\src\\car.jpg");
    JLabel carLabel = new JLabel(carIcon);

    public MainExtendedView() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Boutons de navigation restants
        JButton demandeFinancementButton = new JButton("Formulaire de demande de financement");
        JButton statusFinancementButton = new JButton("Suivi demande de financement");
        JButton investmentManagementButton = new JButton("Gestion des Investissements");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(demandeFinancementButton, gbc);

        gbc.gridy++;
        add(statusFinancementButton, gbc);

        gbc.gridy++;
        add(investmentManagementButton, gbc);

        // Action pour le bouton de formulaire de demande de financement
        demandeFinancementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ouvrir le formulaire de demande de financement
                FinancingFormView financingFormView = new FinancingFormView();
                JFrame frame = new JFrame("Formulaire de demande de financement");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setContentPane(financingFormView);
                frame.pack();
                frame.setVisible(true);
            }
        });

        // Action pour le bouton de statut de demande de financement
        statusFinancementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Afficher le statut de la demande de financement
                StatusFinancementView statusFinancementView = new StatusFinancementView();
                JFrame frame = new JFrame("Suivi demande de financement");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setContentPane(statusFinancementView);
                frame.pack();
                frame.setVisible(true);
            }
        });

        // Action pour le bouton de gestion des investissements
        investmentManagementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Accéder à la gestion des investissements
                InvestmentManagementPage investmentManagementPage = new InvestmentManagementPage();
                // Ajoutez ici le code pour afficher la gestion des investissements
            }
        });

        // Positionner le bouton de retour
        gbc.gridx = 0;
        gbc.gridy++; // Placez le bouton après les autres boutons
        gbc.gridwidth = 2;
        add(retourButton, gbc);

        // Action du bouton Retour
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermer la vue actuelle
                SwingUtilities.getWindowAncestor(MainExtendedView.this).dispose();
                // Retourner à la page d'accueil
                retourAccueil();
            }
        });
    }

    // Méthode pour retourner à la page d'accueil
    private void retourAccueil() {
        // Ajoutez ici le code pour retourner à la page d'accueil
        // Par exemple :
        // new HomePage();
    }

    // Méthode pour ajouter le listener au bouton de retour
    public void addRetourListener(ActionListener listener) {
        retourButton.addActionListener(listener);
    }
}
