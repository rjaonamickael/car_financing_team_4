package model;

public class Investor extends User{
    public String niveauRisque;
    public String niveauEducInvest;



    public Investor(String nomComplet, String mdp, String phoneNumero, String banqueNom, String banqueDetailsCompte,
                            String niveauRisque, String niveauEducInvest) {
        this.nomComplet = nomComplet;
        this.mdp = mdp;
        this.phoneNumero = phoneNumero;
        this.banqueNom = banqueNom;
        this.banqueDetailsCompte = banqueDetailsCompte;
        this.niveauRisque = niveauRisque;
        this.niveauEducInvest = niveauEducInvest;
    }
}
