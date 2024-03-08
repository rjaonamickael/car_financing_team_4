package view;


import controller.ClientDAOImpl;
import controller.InvestisseurDAOImpl;
import model.Client;
import model.Investisseur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.sql.Date;
import java.util.HexFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static methods.BiblioMethode.sha256;


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

        //Chargement du Panel contenant le formulaire
        updateFormFields();


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
            add(new JLabel("Établi au Canada depuis (durée):           "), gbc);

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

            //Ajout de ligne pour uniformiser la forme
            gbc.gridy++;
            add(new JLabel("  "), gbc);
            gbc.gridy++;
            add(new JLabel("  "), gbc);
            gbc.gridy++;


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
                try {
                    if (validateForm()) {
                        // Créer un objet Client ou Investor en fonction du type d'utilisateur
                        if ("Client".equals(userType)) {

                            // Vérifier si l'émail a été déjà utilisé
                            if( !userExists(emailField.getText()) ){
                                //Hache du mot de passe saisie
                                String[] mdp = hachage(String.valueOf(passwordField.getPassword()));

                                // Créer un objet Client avec les champs saisis
                                Client client = new Client(
                                        fullNameField.getText(),
                                        emailField.getText(),
                                        mdp[0],    //le mot de passe haché
                                        mdp[1],    //le salt haché
                                        phoneField.getText(),
                                        employmentInfoField.getText(),
                                        Short.parseShort(annualIncomeField.getText()),
                                        Byte.parseByte(creditScoreField.getText()),
                                        Date.valueOf(birthDateField.getText()),
                                        maritalStatusComboBox.getSelectedItem().toString(),
                                        Short.parseShort(yearsInCanadaField.getText())
                                );

                                // Ajout du client dans la bdd
                                ClientDAOImpl clientDAO = new ClientDAOImpl();
                                clientDAO.addClient(client);
                            }
                            else {
                                //L'adresse mal est déjà utilisé à un utilisateur donc il faut qu'il utilise un autre
                                infoMessage("Erreur","Adresse mail déjà utilisé","erreur");
                            }


                        } else {

                            // Vérifier si l'émail a été déjà utilisé
                            if( !userExists(emailField.getText()) ){
                                //Hache du mot de passe saisie
                                String[] mdp = hachage(String.valueOf(passwordField.getPassword()));

                                // Créer un objet Investor avec les champs saisis
                                Investisseur investisseur = new Investisseur(
                                        fullNameField.getText(),
                                        emailField.getText(),
                                        mdp[0],    //le mot de passe haché
                                        mdp[1],    //le salt haché
                                        phoneField.getText(),
                                        bankNameField.getText(),
                                        accountDetailsField.getText(),
                                        riskLevelComboBox.getSelectedItem().toString(),
                                        educationLevelComboBox.getSelectedItem().toString()
                                );

                                // Ajout de l'investisseur dans la bdd
                                InvestisseurDAOImpl investisseurDAO = new InvestisseurDAOImpl();
                                investisseurDAO.addInvestisseur(investisseur);
                            }
                            else {
                                //L'adresse mal est déjà utilisé à un utilisateur donc il faut qu'il utilise un autre
                                infoMessage("Erreur","Adresse mail déjà utilisé","erreur");
                            }
                        }

                        // Effacer les champs après l'inscription
                        clearForm();
                    }
                } catch (Exception exception) {
                    infoMessage("Erreur d'inscription",
                            "Il y a certains champs qui ne sont pas correctement remplis.",
                            "erreur");
                }
            }
        });

        revalidate(); // Revalider le panel
        repaint(); // Redessiner le panel
    }

    private void infoMessage(String titre, String message, String type) {
        if (type.equals("erreur")) {
            JOptionPane.showMessageDialog(RegisterView.this, message, titre, JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(RegisterView.this, message, titre, JOptionPane.INFORMATION_MESSAGE);
        }

    }
    private boolean validateForm() {

        boolean validated = false;
        boolean champsVide;
        // Vérification des champs vide ou non
        if (userTypeComboBox.getSelectedItem().equals("Client")) {
            champsVide = !fullNameField.getText().equals("") && !emailField.getText().equals("") && !passwordField.getText().equals("") &&
                    !confirmPasswordField.getText().equals("") && !phoneField.getText().equals("") &&
                    !employmentInfoField.getText().equals("") && !annualIncomeField.getText().equals("") && !creditScoreField.getText().equals("") &&
                    !birthDateField.getText().equals("") && !yearsInCanadaField.getText().equals("");
        } else {
            champsVide = !fullNameField.getText().equals("") && !emailField.getText().equals("") && !passwordField.getText().equals("") &&
                    !confirmPasswordField.getText().equals("") && !phoneField.getText().equals("") &&
                    !bankNameField.getText().equals("") && !accountDetailsField.getText().equals("");

        }
        if (champsVide) {
            // Vérification de la correspondance des deux mots de passes
            String password = new String(passwordField.getText());
            String confirmPassword = new String(confirmPasswordField.getText());

            if (!password.equals(confirmPassword)) {
                validated = false; // Les mots de passe ne correspondent pas
                infoMessage("Erreur d'inscription",
                        "Les mots de passe ne sont pas identiques",
                        "erreur");
            } else if (regex(password)) {
                validated = true;
            }

        } else {
            infoMessage("Erreur d'inscription",
                    "Il y a certains champs qui sont vides.",
                    "erreur");
        }


        // Ajoutez ici d'autres conditions de validation

        return validated; // Retourner false par défaut sauf si conditions vérifiées.
    }
    private boolean regex(String password){

        if(password.length() > 7){
            //Définition de l'expression régulière
            String regex  = ".*\\d.*[A-Z].*[@#$%^&*!</>].*|.*[A-Z].*[@#$%^&*!</>].*\\d.*|.*[@#$%^&*!</>].*[A-Z].*\\d.*|" +
                    ".*\\d.*[@#$%^&*!</>].*[A-Z].*|.*[A-Z].*\\d.*[@#$%^&*!</>].*|.*[@#$%^&*!</>].*\\d.*[A-Z].*";

            // Créer un objet Pattern en compilant l'expression régulière
            Pattern pattern = Pattern.compile(regex);
            //Matching avec l'expression régulière
            Matcher matcher = pattern.matcher(password);

            if (matcher.matches()){
                return true;
            }
            else{
                infoMessage("Erreur d'inscription",
                        "Il faut que le mot de passe contienne un caractère spécial, un chiffre et une lettre majuscule",
                        "erreur");
            }
        }
        else{
            infoMessage("Erreur d'inscription",
                    "Il faut que le mot de passe soit supérieur à 7 caractères",
                    "erreur");
        }
        return false;
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
    private String[] hachage(String mdp){
        //Création du salt
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        System.out.println(salt.toString());

        //Conversion du salt hexa
        StringBuilder sbSalt = new StringBuilder();
        for (byte b : salt) {
            sbSalt.append(String.format("%02x", b));
        }

        return sha256(mdp,salt);

    }
    private boolean userExists(String email){
        ClientDAOImpl clientDAO = new ClientDAOImpl();
        InvestisseurDAOImpl investisseurDAO = new InvestisseurDAOImpl();

        //Stocker le mot de passe associé à l'adresse mail dans un String, s'il existe
        String clientExist = clientDAO.getPasswordSalt(String.valueOf(email))[0];
        String investExist = investisseurDAO.getPasswordSalt(String.valueOf(email))[0];

        if( clientExist.equals("") && investExist.equals("") ) return false;
        else return true;

    }

}
