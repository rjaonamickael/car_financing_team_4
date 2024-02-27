package model;

public class Investor extends User{
    public String niveauRisque;
    public String niveauEducInvest;



    public Investor(String nom, String prenom, String mdp, String phoneNumero, String banqueNom, String banqueDetailsCompte,
                            String niveauRisque, String niveauEducInvest) {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.phoneNumero = phoneNumero;
        this.banqueNom = banqueNom;
        this.banqueDetailsCompte = banqueDetailsCompte;
        this.niveauRisque = niveauRisque;
        this.niveauEducInvest = niveauEducInvest;
    }
}
