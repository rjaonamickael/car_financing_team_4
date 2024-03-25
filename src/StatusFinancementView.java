import javax.swing.*;
import java.awt.*;

class StatusFinancementView extends JPanel {
    public StatusFinancementView() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Ajouter les éléments spécifiés dans votre demande
        JLabel marqueLabel = new JLabel("Marque: Honda ");
        add(marqueLabel, gbc);

        JLabel modeleLabel = new JLabel("Modèle: CRV ");
        gbc.gridy++;
        add(modeleLabel, gbc);

        JLabel anneeLabel = new JLabel("Année: 2015");
        gbc.gridy++;
        add(anneeLabel, gbc);

        JLabel kilometrageLabel = new JLabel("Kilométrage: 20000 km");
        gbc.gridy++;
        add(kilometrageLabel, gbc);

        JLabel statutLabel = new JLabel("Statut: En cours");
        gbc.gridy++;
        add(statutLabel, gbc);

        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(20);
        gbc.gridy++;
        add(progressBar, gbc);

        // Bouton désactivé pour modifier la demande
        JButton modifierButton = new JButton("Modifier la demande");
        modifierButton.setEnabled(false);
        gbc.gridy++;
        add(modifierButton, gbc);

        // Bouton de retour
        JButton retourButton = new JButton("Retour à la page principale");
        gbc.gridy++;
        add(retourButton, gbc);

        // Ajouter un ActionListener pour le bouton de retour
        retourButton.addActionListener(e -> {
            // Revenir à la page principale
            CardLayout cardLayout = (CardLayout) getParent().getLayout();
            cardLayout.show(getParent(), "Main");
        });
    }
}

