package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterViewTest {
    private RegisterView registerView;

    @BeforeEach
    public void setUp() {
        registerView = new RegisterView();
    }

    @AfterEach
    public void tearDown() {
        // Nettoyage après chaque test
        registerView = null;
    }

    @Test
    public void testValidateFormWithValidData() {
        // Données valides pour un utilisateur client
        registerView.userTypeComboBox.setSelectedItem("Client");
        registerView.fullNameField.setText("John Doe");
        registerView.emailField.setText("john@example.com");
        registerView.passwordField.setText("Password123@");
        registerView.confirmPasswordField.setText("Password123@");
        registerView.phoneField.setText("1234567890");
        registerView.employmentInfoField.setText("Software Engineer");
        registerView.annualIncomeField.setText("50000");
        registerView.creditScoreField.setText("750");
        registerView.birthDateField.setText("1990-01-01");
        registerView.maritalStatusComboBox.setSelectedItem("Célibataire");
        registerView.yearsInCanadaField.setText("10");

        assertTrue(registerView.validateForm());
    }

    @Test
    public void testValidateFormWithInvalidPassword() {
        // Données avec un mot de passe invalide
        registerView.userTypeComboBox.setSelectedItem("Client");
        registerView.fullNameField.setText("John Doe");
        registerView.emailField.setText("john@example.com");
        registerView.passwordField.setText("password");  // Mot de passe invalide (moins de 8 caractères)
        registerView.confirmPasswordField.setText("password");
        registerView.phoneField.setText("1234567890");
        registerView.employmentInfoField.setText("Software Engineer");
        registerView.annualIncomeField.setText("50000");
        registerView.creditScoreField.setText("750");
        registerView.birthDateField.setText("1990-01-01");
        registerView.maritalStatusComboBox.setSelectedItem("Célibataire");
        registerView.yearsInCanadaField.setText("10");

        assertFalse(registerView.validateForm());
    }

    @Test
    public void testValidateFormWithMismatchedPasswords() {
        // Données avec des mots de passe non correspondants
        registerView.userTypeComboBox.setSelectedItem("Investisseur");
        registerView.fullNameField.setText("Jane Doe");
        registerView.emailField.setText("jane@example.com");
        registerView.passwordField.setText("Password123@");
        registerView.confirmPasswordField.setText("DifferentPassword123@"); // Mots de passe non correspondants
        registerView.phoneField.setText("1234567890");
        registerView.bankNameField.setText("Bank ABC");
        registerView.accountDetailsField.setText("123456");
        registerView.riskLevelComboBox.setSelectedItem("Risqué");
        registerView.educationLevelComboBox.setSelectedItem("Moyen");

        assertFalse(registerView.validateForm());
    }

    @Test
    public void testUserExistsWithEmail() {
        // Vérifier l'existence d'un utilisateur avec une adresse e-mail déjà utilisée
        String existingEmail = "john@example.com"; // Adresse e-mail déjà utilisée dans la base de données

        assertTrue(registerView.userExists(existingEmail));
    }

    @Test
    public void testUserExistsWithNonExistingEmail() {
        // Vérifier l'absence d'un utilisateur avec une adresse e-mail non utilisée
        String nonExistingEmail = "nonexistent@example.com"; // Adresse e-mail non utilisée dans la base de données

        assertFalse(registerView.userExists(nonExistingEmail));
    }
}
