package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvestmentManagementPageTest {
    private InvestmentManagementPage gestionInvestissement;

    @BeforeEach
    public void setUp() {
        gestionInvestissement = new InvestmentManagementPage();
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        gestionInvestissement = null;
    }

    @Test
    public void testInvestir() {
        // Mise en place du solde initial
        gestionInvestissement.soldeActuel = 1000;

        // Tester l'investissement d'un montant valide
        gestionInvestissement.fieldInvestir.setText("500");
        gestionInvestissement.investir();
        assertEquals(1500, gestionInvestissement.soldeActuel);

        // Tester l'investissement d'un montant inférieur au minimum
        gestionInvestissement.fieldInvestir.setText("50");
        gestionInvestissement.investir();
        assertEquals(1500, gestionInvestissement.soldeActuel); // Le solde ne doit pas changer
    }

    @Test
    public void testRetirer() {
        // Mise en place du solde initial
        gestionInvestissement.soldeActuel = 1000;

        // Tester le retrait d'un montant inférieur au solde actuel
        gestionInvestissement.fieldRetirer.setText("500");
        gestionInvestissement.retirer();
        assertEquals(500, gestionInvestissement.soldeActuel);

        // Tester le retrait d'un montant supérieur au solde actuel
        gestionInvestissement.fieldRetirer.setText("1000");
        gestionInvestissement.retirer();
        assertEquals(500, gestionInvestissement.soldeActuel); // Le solde ne doit pas devenir négatif
    }

    @Test
    public void testRetirerMontantEgalAuSoldeActuel() {
        // Mise en place du solde initial
        gestionInvestissement.soldeActuel = 1000;

        // Tester le retrait d'un montant égal au solde actuel
        gestionInvestissement.fieldRetirer.setText("1000");
        gestionInvestissement.retirer();
        assertEquals(0, gestionInvestissement.soldeActuel); // Le solde doit devenir zéro
    }

    @Test
    public void testAfficherSoldeInitialEtInfosBancaires() {
        gestionInvestissement.fieldNomBanque.setText("Banque XYZ");
        gestionInvestissement.fieldNumTransit.setText("12345");
        gestionInvestissement.fieldNumInstitution.setText("67890");
        gestionInvestissement.fieldNumCompte.setText("ABCDE");
        gestionInvestissement.soldeActuel = 1000;

        gestionInvestissement.afficherSoldeInitialEtInfosBancaires();
        assertEquals("Informations bancaires :\nNom de la banque : Banque XYZ\nNuméro de transit : 12345\nNuméro d'institution : 67890\nNuméro de compte : ABCDE\n\nSolde initial : 1000$\n\n",
                gestionInvestissement.areaTransactions.getText());
    }
}
