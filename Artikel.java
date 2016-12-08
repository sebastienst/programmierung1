
/**
 * Write a description of class Artikel here.
 * 
 * @author Nico Gruschke
 * @version 1.5
 */
public class Artikel
{
   private int artikelNummer;
   private String bezeichnung;
   private int bestand;
   double preis;
   
   private static final int MAX_artikelNummer = 9999;
   private static final int MIN_artikelNummer = 1000;
   private static final String MSG_artikelNummer      = "artikelNummer muss 4-stellig sein";
   private static final String MSG_MENGE       = "Menge muss über null sein";
   private static final String MSG_BEZEICHNUNG = "Bezeichnung darf nicht leer sein";
   private static final String MSG_BESTAND     = "Bestand muss positiv sein";
   private static final String MSG_UEBERZOGEN  = "Artikel darf nicht ueberzigen werden";
   
   /**
    * Artikel Constructor
    *
    * @param artikelnr muss 4 stellig sein.
    * @param artikelbzg ist die bezeichnug des Artikels und darf nicht null sein.
    * @param artikelbestand ist die anzahl des Artikels im lager.
    */
   public Artikel(int artikelNummer, String bezeichnung, int bestand, double preis)
   {
       ueberpruefen(artikelNummer <= MAX_artikelNummer && artikelNummer >= MIN_artikelNummer,
                    MSG_artikelNummer);
       ueberpruefen(bestand >= 0, MSG_BESTAND);
       this.artikelNummer = artikelNummer;
       setBezeichnung(bezeichnung);
       this.bestand = bestand;
       this.preis = preis;
   }
   public Artikel(int artikelNummer, String bezeichnung, double preis)
   {
       this(artikelNummer , bezeichnung , 0, preis);
   }
   
   /**
    * Method eingang
    *
    * @param menge darf niemals negativ sein oder gleich 0.
    */
   public void einnahme(int menge)
   {
       ueberpruefen(menge > 0, MSG_MENGE );
       bestand += menge;
   }
   
   /**
    * Method ausgang
    *
    * @param menge darf niemals = artikelbestand sein.
    */
   public void ausgabe(int menge)
   {
       ueberpruefen(bestand >= menge, MSG_UEBERZOGEN);
       ueberpruefen(menge > 0, MSG_MENGE );
       bestand -= menge;
   }
   
   public String toString()
   {
       return "Artikel: " + artikelNummer +", Bezeichnung: " + bezeichnung +", Bestand: " + bestand;
   }
   
   /**
    * Method getArtikelnr
    *
    * @return Gibt die ArtikelartikelNummer.
    */
   public int getArtikelNummer()
   {
       return artikelNummer;
   }
   
   /**
    * Method getArtikelbzg
    *
    * @return Gibt die Artikelbezeichnung.
    */
   public String getArtikelBezeichnung()
   {
       return bezeichnung;
   }
   
   /**
    * Method getBestand
    *
    * @return Gibt den Aktuellen Bestand.
    */
   public int getBestand()
   {
       return bestand;
   }
   
   public void setBezeichnung(String bezeichnung) {
       ueberpruefen(bezeichnung != null && bezeichnung.trim().length() > 0,
                    MSG_BEZEICHNUNG);
       this.bezeichnung = bezeichnung;
    }
    
    private static void ueberpruefen(boolean bedingung, String msg){
        if (!bedingung){
            throw new RuntimeException(msg);
        }
    }
}
