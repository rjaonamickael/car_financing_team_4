package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinancingFormView extends JPanel {
    public FinancingFormView() {
        // Ajouter des composants pour l'introduction, l'implémentation des classes, etc.

        // Champs du formulaire
        JLabel vinLabel = new JLabel("VIN (17 caractères): 1HGCM82633A123456\n ");
        JTextField vinTextField = new JTextField(17);

        JLabel montantLabel = new JLabel("Montant du prêt désiré: \n La valeur maximale du prêt est de 60 000 $");
        JTextField montantTextField = new JTextField();

        JLabel dureeLabel = new JLabel("Durée du prêt: \n La durée maximale du prêt est de 4 ans");
        JTextField dureeTextField = new JTextField();

        JLabel kilometrageLabel = new JLabel("Kilométrage: \n Pour un véhicule d'occasion, le kilométrage ne doit pas\n" +
                "excéder 230 000.");
        JTextField kilometrageTextField = new JTextField();

        // Ajouter des boutons pour la validation et la soumission
        JButton validerButton = new JButton("Valider");
        JButton retourButton = new JButton("Retour à l'accueil");

        // Utiliser un layout approprié (par exemple, GroupLayout) pour organiser les composants
        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(vinLabel)
                .addComponent(montantLabel)
                .addComponent(dureeLabel)
                .addComponent(kilometrageLabel)
                .addComponent(validerButton)
                .addComponent(retourButton)
        );

        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(vinTextField)
                .addComponent(montantTextField)
                .addComponent(dureeTextField)
                .addComponent(kilometrageTextField)
        );

        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(vinLabel)
                .addComponent(vinTextField)
        );
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(montantLabel)
                .addComponent(montantTextField)
        );
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(dureeLabel)
                .addComponent(dureeTextField)
        );
        vGroup.addGroup(layout.createParallelGroup()
                .addComponent(kilometrageLabel)
                .addComponent(kilometrageTextField)
        );
        vGroup.addComponent(validerButton);
        vGroup.addComponent(retourButton);

        layout.setVerticalGroup(vGroup);

        // Ajouter une action pour le bouton Valider
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Récupérer les valeurs des champs
                String vin = vinTextField.getText();
                String montantStr = montantTextField.getText();
                String dureeStr = dureeTextField.getText();
                String kilometrageStr = kilometrageTextField.getText();

                // Effectuer une validation simple
                if (vin.length() != 17) {
                    afficherErreur("Le VIN doit avoir 17 caractères.");
                    return; // Arrêter le traitement si la validation échoue
                }

                try {
                    double montant = Double.parseDouble(montantStr);
                    int duree = Integer.parseInt(dureeStr);
                    int kilometrage = Integer.parseInt(kilometrageStr);

                    // Ajouter votre logique de validation
                    if (montant > 60000) {
                        afficherErreur("La valeur maximale du prêt est de 60 000 $.");
                        return;
                    }

                    if (duree > 4) {
                        afficherErreur("La durée maximale du prêt est de 4 ans.");
                        return;
                    }

                    if (kilometrage > 230000) {
                        afficherErreur("Le kilométrage ne doit pas excéder 230 000 pour un véhicule d'occasion.");
                        return;
                    }

                    // Reste de la logique de traitement...

                    // Afficher un message de confirmation
                    JOptionPane.showMessageDialog(FinancingFormView.this, "Validation réussie. Votre demande a été enregistrée.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    afficherErreur("Veuillez saisir des valeurs numériques valides.");
                }
            }

            private void afficherErreur(String message) {
                JOptionPane.showMessageDialog(FinancingFormView.this, message, "Erreur de validation", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Ajouter une action pour le bouton Retour à l'accueil
        retourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retourner à la page précédente (à implémenter)
                // Par exemple, ici vous pouvez fermer cette vue ou afficher la page d'accueil
            }
        });
    }
}
