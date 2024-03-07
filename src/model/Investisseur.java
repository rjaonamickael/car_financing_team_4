package model;

public class Investisseur extends User{
    public String banqueNom;
    public String banqueDetailsCompte;
    public String niveauRisque;
    public String niveauEducInvest;


    public Investisseur(String nomComplet, String adressemail, String mdp, String salt, String phoneNumero, String banqueNom, String banqueDetailsCompte,
                    String niveauRisque, String niveauEducInvest) {
        this.nomComplet = nomComplet;
        this.adressemail = adressemail;
        this.mdp = mdp;
        this.salt = salt;
        this.phoneNumero = phoneNumero;
        this.banqueNom = banqueNom;
        this.banqueDetailsCompte = banqueDetailsCompte;
        this.niveauRisque = niveauRisque;
        this.niveauEducInvest = niveauEducInvest;
    }
}
