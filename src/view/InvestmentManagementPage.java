package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InvestmentManagementPage extends JFrame implements ActionListener {
    private JLabel labelMontantTotalInvesti;
    JTextArea areaTransactions;
    private JLabel labelSoldeActuel;
    JTextField fieldInvestir;
    JTextField fieldRetirer; // Champ pour le montant à retirer
    JTextField fieldNomBanque;
    JTextField fieldNumTransit;
    JTextField fieldNumInstitution;
    JTextField fieldNumCompte;
    private JButton buttonInvestir;
    private JButton buttonRetirer;
    private JButton buttonRetourAccueil; // Bouton pour retourner à la page d'accueil

    private double montantTotalInvesti;
    private List<String> transactions;
    double soldeActuel;

    // Constructeur
    public InvestmentManagementPage() {
        setTitle("Gestion d'Investissement");
        setSize(600, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Section 0 : Informations sur l'investissement
        JPanel infoPanel = new JPanel(new GridLayout(2, 1));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelInfo = new JLabel("Informations sur l'investissement");
        labelInfo.setHorizontalAlignment(SwingConstants.CENTER);
        labelInfo.setFont(new Font("Arial", Font.BOLD, 16));
        infoPanel.add(labelInfo);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonInvestir = new JButton("Investir");
        buttonRetirer = new JButton("Retirer");
        buttonRetourAccueil = new JButton("Retour à la Page d'Accueil"); // Renommage et nouvelle fonctionnalité
        buttonPanel.add(buttonInvestir);
        buttonPanel.add(buttonRetirer);
        buttonPanel.add(buttonRetourAccueil); // Ajout du bouton pour retourner à la page d'accueil
        infoPanel.add(buttonPanel);

        // Ajout de la section 0 au conteneur principal
        add(infoPanel, BorderLayout.NORTH);

        // Section 1 : Montant initial et transactions
        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel titleLabel = new JLabel("Gestion d'Investissement");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        topPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel montantPanel = new JPanel(new BorderLayout()); // Changement de layout pour utiliser BorderLayout
        montantPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        labelMontantTotalInvesti = new JLabel("Montant total investi : ");
        montantPanel.add(labelMontantTotalInvesti, BorderLayout.NORTH);

        areaTransactions = new JTextArea();
        areaTransactions.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTransactions); // Utilisation de JScrollPane autour de la zone de texte
        montantPanel.add(scrollPane, BorderLayout.CENTER); // Ajout de la zone de texte dans le centre du BorderLayout

        labelSoldeActuel = new JLabel("Solde actuel : ");
        montantPanel.add(labelSoldeActuel, BorderLayout.SOUTH);

        topPanel.add(montantPanel, BorderLayout.CENTER);

        // Section 2 : Informations bancaires et boutons
        JPanel formPanel = new JPanel(new GridLayout(10, 1, 10, 10)); // Augmentation du nombre de lignes
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelInvestir = new JLabel("Montant à Investir (minimum 100$) : ");
        formPanel.add(labelInvestir);
        fieldInvestir = new JTextField();
        formPanel.add(fieldInvestir);

        JLabel labelRetirer = new JLabel("Montant à Retirer : "); // Nouveau champ pour le montant à retirer
        formPanel.add(labelRetirer);
        fieldRetirer = new JTextField();
        formPanel.add(fieldRetirer);

        JLabel labelBanque = new JLabel("Nom de la banque : ");
        formPanel.add(labelBanque);
        fieldNomBanque = new JTextField();
        formPanel.add(fieldNomBanque);

        JLabel labelTransit = new JLabel("Numéro de transit : ");
        formPanel.add(labelTransit);
        fieldNumTransit = new JTextField();
        formPanel.add(fieldNumTransit);

        JLabel labelInstitution = new JLabel("Numéro d'institution : ");
        formPanel.add(labelInstitution);
        fieldNumInstitution = new JTextField();
        formPanel.add(fieldNumInstitution);

        JLabel labelCompte = new JLabel("Numéro de compte : ");
        formPanel.add(labelCompte);
        fieldNumCompte = new JTextField();
        formPanel.add(fieldNumCompte);

        buttonInvestir.addActionListener(this);
        buttonRetirer.addActionListener(this);
        buttonRetourAccueil.addActionListener(this); // Ajout de l'action listener pour le bouton Retour à la Page d'Accueil
        formPanel.add(buttonInvestir);
        formPanel.add(buttonRetirer);
        formPanel.add(buttonRetourAccueil); // Ajout du bouton pour retourner à la page d'accueil

        topPanel.add(formPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.CENTER);

        // Initialisation des variables de transactions
        montantTotalInvesti = 0;
        transactions = new ArrayList<>();
        soldeActuel = 5000; // Exemple de solde initial

        // Afficher le solde initial et les informations bancaires
        afficherSoldeInitialEtInfosBancaires();

        setVisible(true);
        setLocationRelativeTo(null);
    }

    // Méthode pour afficher le solde initial et les informations bancaires
    void afficherSoldeInitialEtInfosBancaires() {
        // Vous pouvez récupérer les informations bancaires à partir des champs textuels correspondants
        String nomBanque = fieldNomBanque.getText();
        String numTransit = fieldNumTransit.getText();
        String numInstitution = fieldNumInstitution.getText();
        String numCompte = fieldNumCompte.getText();

        // Afficher les informations dans la zone d'affichage
        areaTransactions.append("Informations bancaires :\n");
        areaTransactions.append("Nom de la banque : " + nomBanque + "\n");
        areaTransactions.append("Numéro de transit : " + numTransit + "\n");
        areaTransactions.append("Numéro d'institution : " + numInstitution + "\n");
        areaTransactions.append("Numéro de compte : " + numCompte + "\n\n");

        // Afficher le solde initial
        areaTransactions.append("Solde initial : " + soldeActuel + "$\n\n");
    }

    // Méthode actionPerformed pour gérer les événements des boutons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonInvestir) {
            investir();
        } else if (e.getSource() == buttonRetirer) {
            retirer();
        } else if (e.getSource() == buttonRetourAccueil) { // Condition pour le bouton Retour à la Page d'Accueil
            retourAccueil();
        }
    }

    // Méthode pour effectuer une transaction d'investissement
    void investir() {
        String montantInvestiStr = fieldInvestir.getText();
        double montantInvesti = Double.parseDouble(montantInvestiStr);

        // Vérifier si le montant investi est valide (minimum 100$)
        if (montantInvesti >= 100) {
            soldeActuel += montantInvesti; // Ajouter le montant investi au solde initial
            transactions.add("Investissement de " + montantInvesti + "$ le " + new Date()); // Ajouter la transaction à la liste
            mettreAJourAffichage(); // Mettre à jour l'affichage
        } else {
            JOptionPane.showMessageDialog(this, "Le montant minimum d'investissement est de 100$.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Méthode pour effectuer une transaction de retrait
    void retirer() {
        String montantRetireStr = fieldRetirer.getText(); // Utilisation du champ pour le montant à retirer
        double montantRetire = Double.parseDouble(montantRetireStr);

        // Vérifier si le montant à retirer ne dépasse pas le solde actuel
        if (montantRetire <= soldeActuel) {
            soldeActuel -= montantRetire; // Retirer le montant du solde initial
            transactions.add("Retrait de " + montantRetire + "$ le " + new Date()); // Ajouter la transaction à la liste
            mettreAJourAffichage(); // Mettre à jour l'affichage
        } else {
            JOptionPane.showMessageDialog(this, "Le montant à retirer dépasse le solde actuel.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Méthode pour mettre à jour les informations d'affichage
    private void mettreAJourAffichage() {
        labelMontantTotalInvesti.setText("Montant total investi : " + montantTotalInvesti + "$");
        areaTransactions.setText(""); // Réinitialiser la zone de texte des transactions
        for (String transaction : transactions) {
            areaTransactions.append(transaction + "\n\n"); // Ajouter chaque transaction à la zone de texte
        }
        labelSoldeActuel.setText("Solde actuel : " + soldeActuel + "$");
    }

    // Méthode pour retourner à la page d'accueil
    void retourAccueil() {
        this.dispose(); // Ferme la fenêtre actuelle
        // Ajoutez ici le code pour retourner à la page d'accueil
        // Par exemple :
        // new HomePage();
    }

    public static void main(String[] args) {
        new InvestmentManagementPage();
    }
}
