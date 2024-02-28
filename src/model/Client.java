package model;

import java.util.Date;

public class Client extends User{
    public byte creditNote;            // En pourcentage
    public Date datenaiss;
    public String statutMaritial;
    public short nbrJourAuCanada;


    public Client(String nomComplet, String mdp, String phoneNumero, String banqueNom, String banqueDetailsCompte,
                        byte creditNote, Date datenaiss, String statutMaritial, short nbrJourAuCanada) {
        this.nomComplet = nomComplet;
        this.mdp = mdp;
        this.phoneNumero = phoneNumero;
        this.banqueNom = banqueNom;
        this.banqueDetailsCompte = banqueDetailsCompte;
        this.creditNote = creditNote;
        this.datenaiss = datenaiss;
        this.statutMaritial = statutMaritial;
        this.nbrJourAuCanada = nbrJourAuCanada;
    }

}
