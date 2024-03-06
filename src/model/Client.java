package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client extends User{
    public String infoEmploi;
    public short revenuAnnuel;
    public byte creditNote;            // En pourcentage
    public String datenaiss;
    public String statutMarital;
    public short nbrJourAuCanada;


    public Client(String nomComplet, String adressemail, String mdp, String phoneNumero, String infoEmploi, String revenuAnnuel,
                  String creditNote, String datenaiss, String statutMarital, String nbrJourAuCanada) {
        this.nomComplet = nomComplet;
        this.adressemail = adressemail;
        this.mdp = mdp;
        this.phoneNumero = phoneNumero;
        this.infoEmploi = infoEmploi;
        this.revenuAnnuel = Short.parseShort(revenuAnnuel);
        this.creditNote = Byte.parseByte(creditNote);
        this.datenaiss = datenaiss;
        this.statutMarital = statutMarital;
        this.nbrJourAuCanada = Short.parseShort(nbrJourAuCanada);
    }
}
