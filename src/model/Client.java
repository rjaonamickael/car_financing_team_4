package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client extends User{
    public String infoEmploi;
    public short revenuAnnuel;
    public byte creditNote;            // En pourcentage
    public Date datenaiss;
    public String statutMarital;
    public short nbrJourAuCanada;


    public Client(String nomComplet, String adressemail, String mdp, String salt, String phoneNumero, String infoEmploi, Short revenuAnnuel,
                  Byte creditNote, Date datenaiss, String statutMarital, Short nbrJourAuCanada) {
        this.nomComplet = nomComplet;
        this.adressemail = adressemail;
        this.mdp = mdp;
        this.salt = salt;
        this.phoneNumero = phoneNumero;
        this.infoEmploi = infoEmploi;
        this.revenuAnnuel = revenuAnnuel;
        this.creditNote = creditNote;
        this.datenaiss = datenaiss;
        this.statutMarital = statutMarital;
        this.nbrJourAuCanada = nbrJourAuCanada;
    }
}
