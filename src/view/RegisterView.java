package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterView extends JPanel {
    private JTextField fullNameField = new JTextField(20);
    private JTextField emailField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);
    private JPasswordField confirmPasswordField = new JPasswordField(20);
    private JTextField phoneField = new JTextField(20);
    private JComboBox<String> userTypeComboBox = new JComboBox<>(new String[]{"Client", "Investisseur"});

    // Champs pour les clients
    private JTextField employmentInfoField = new JTextField(20);
    private JTextField annualIncomeField = new JTextField(20);
    private JTextField creditScoreField = new JTextField(20);
    private JTextField birthDateField = new JTextField(20);
    private JComboBox<String> maritalStatusComboBox = new JComboBox<>(new String[]{"Célibataire", "Marié"});
    private JTextField yearsInCanadaField = new JTextField(20);

    // Champs pour les investisseurs
    private JTextField bankNameField = new JTextField(20);
    private JTextField accountDetailsField = new JTextField(20);
    private JComboBox<String> riskLevelComboBox = new JComboBox<>(new String[]{"Peu de risque", "Risqué", "Très risqué"});
    private JComboBox<String> educationLevelComboBox = new JComboBox<>(new String[]{"Peu", "Moyen", "Beaucoup"});

    public RegisterView() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Type d'Utilisateur:"), gbc);

        gbc.gridx = 1;
        add(userTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Nom complet:"), gbc);

        gbc.gridx = 1;
        add(fullNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
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
        add(new JLabel("Confirmer le mot de passe:"), gbc);

        gbc.gridx = 1;
        add(confirmPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Numéro de téléphone:"), gbc);

        gbc.gridx = 1;
        add(phoneField, gbc);

        // Ajoutez ici les champs supplémentaires requis pour les clients et investisseurs

        userTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFormFields();
            }
        });
    }

    private void updateFormFields() {
        // Mettez à jour les champs du formulaire en fonction du type d'utilisateur sélectionné
        String userType = (String) userTypeComboBox.getSelectedItem();

        removeAll(); // Retire tous les composants du panel

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Type d'Utilisateur:"), gbc);

        gbc.gridx = 1;
        add(userTypeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Nom complet:"), gbc);

        gbc.gridx = 1;
        add(fullNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
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
        add(new JLabel("Confirmer le mot de passe:"), gbc);

        gbc.gridx = 1;
        add(confirmPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Numéro de téléphone:"), gbc);

        gbc.gridx = 1;
        add(phoneField, gbc);

        // Ajoutez ici les champs supplémentaires requis pour les clients et investisseurs

        if ("Client".equals(userType)) {
            // Champs spécifiques pour les clients
            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Informations sur l'emploi:"), gbc);

            gbc.gridx = 1;
            add(employmentInfoField, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Revenu annuel:"), gbc);

            gbc.gridx = 1;
            add(annualIncomeField, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Note de crédit:"), gbc);

            gbc.gridx = 1;
            add(creditScoreField, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Date de naissance:"), gbc);

            gbc.gridx = 1;
            add(birthDateField, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Statut marital:"), gbc);

            gbc.gridx = 1;
            add(maritalStatusComboBox, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Établi au Canada depuis (durée):"), gbc);

            gbc.gridx = 1;
            add(yearsInCanadaField, gbc);

        } else if ("Investisseur".equals(userType)) {
            // Champs spécifiques pour les investisseurs
            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Nom de la banque:"), gbc);

            gbc.gridx = 1;
            add(bankNameField, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Détails du compte bancaire:"), gbc);

            gbc.gridx = 1;
            add(accountDetailsField, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Niveau de risque souhaité:"), gbc);

            gbc.gridx = 1;
            add(riskLevelComboBox, gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            add(new JLabel("Niveau d'éducation en investissement:"), gbc);

            gbc.gridx = 1;
            add(educationLevelComboBox, gbc);
        }

        // Bouton d'inscription
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton registerButton = new JButton("S'inscrire");
        add(registerButton, gbc);

        // ActionListener pour le bouton d'inscription
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateForm()) {
                    // Créer un objet Client ou Investor en fonction du type d'utilisateur
                    if ("Client".equals(userType)) {
                        // Créer un objet Client avec les champs saisis
                        Client client = new Client(
                                fullNameField.getText(),
                                emailField.getText(),
                                passwordField.getPassword(),
                                phoneField.getText(),
                                employmentInfoField.getText(),
                                annualIncomeField.getText(),
                                creditScoreField.getText(),
                                birthDateField.getText(),
                                maritalStatusComboBox.getSelectedItem().toString(),
                                yearsInCanadaField.getText()
                        );

                        // Afficher les informations du client
                        JOptionPane.showMessageDialog(RegisterView.this, client.toString(), "Inscription réussie", JOptionPane.INFORMATION_MESSAGE);

                    } else if ("Investisseur".equals(userType)) {
                        // Créer un objet Investor avec les champs saisis
                        Investor investor = new Investor(
                                fullNameField.getText(),
                                emailField.getText(),
                                passwordField.getPassword(),
                                phoneField.getText(),
                                bankNameField.getText(),
                                accountDetailsField.getText(),
                                riskLevelComboBox.getSelectedItem().toString(),
                                educationLevelComboBox.getSelectedItem().toString()
                        );

                        // Afficher les informations de l'investisseur
                        JOptionPane.showMessageDialog(RegisterView.this, investor.toString(), "Inscription réussie", JOptionPane.INFORMATION_MESSAGE);
                    }

                    // Effacer les champs après l'inscription
                    clearForm();
                } else {
                    // Afficher un message d'erreur si la validation échoue
                    JOptionPane.showMessageDialog(RegisterView.this, "Veuillez remplir tous les champs correctement.", "Erreur d'inscription", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        revalidate(); // Revalider le panel
        repaint(); // Redessiner le panel
    }

    private boolean validateForm() {
        // Implémentez la logique de validation du formulaire ici
        // Vérifiez que tous les champs sont remplis correctement

        // Exemple de validation pour le mot de passe (à adapter selon vos besoins)
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (!password.equals(confirmPassword)) {
            return false; // Les mots de passe ne correspondent pas
        }

        // Ajoutez ici d'autres conditions de validation

        return true; // Le formulaire est valide
    }

    private void clearForm() {
        // Effacer tous les champs du formulaire après l'inscription
        fullNameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
        phoneField.setText("");
        employmentInfoField.setText("");
        annualIncomeField.setText("");
        creditScoreField.setText("");
        birthDateField.setText("");
        maritalStatusComboBox.setSelectedIndex(0);
        yearsInCanadaField.setText("");
        bankNameField.setText("");
        accountDetailsField.setText("");
        riskLevelComboBox.setSelectedIndex(0);
        educationLevelComboBox.setSelectedIndex(0);
    }

    // Ajoutez ici les classes Client et Investor avec leurs constructeurs et la méthode toString
    // en fonction des champs requis pour chaque type d'utilisateur.

    private class Client {
        public Client(String text, String text1, char[] password, String text2, String text3, String text4, String text5, String text6, String toString, String text7) {
            
        }
        // Implémentez la classe Client ici
    }

    private class Investor {
        public Investor(String text, String text1, char[] password, String text2, String text3, String text4, String toString, String toString1) {
        }
        // Implémentez la classe Investor ici
    }
}
