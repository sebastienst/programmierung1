
/**
 * Write a description of class Lager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lager
{
    private String name;
    private Artikel[] artikelTab;
    private int anzArtikel;
    
    private static final String MSG_ARTIKEL_NICHT_VORHANDEN =
                         "Artikel nicht vorhanden!";
    private static final String MSG_ARTIKEL_ANLEGEN         =
                         "Artikel konnte nicht angelegt werden. \n"+
                         "Sie mussen ein Artikel loeschen !";
    private static final String MSG_ARTIKEL_VORHANDEN       =
                         "den Artikel gibt es bereit!";
    private static final String MSG_ARTIKEL_VERSCHIEDEN     =
                         "Ein Artikel kann es nicht 2 mal geben!";
    private static final String MSG_MAX_ANZ_ARTIKEL         =
                         "Die Zahl der Artikeln muss > 0 sein!";
    private static final String MSG_NAME                    = 
                         "Name darf nicht leer sein";

    /**
     * Constructor for objects of class Lager
     */
    public Lager(String name,int maxAnzArtikel)
    {
        ueberpruefen(maxAnzArtikel > 0, MSG_MAX_ANZ_ARTIKEL);
        ueberpruefen(name != null && name.trim().length() > 0, MSG_NAME);
        this.name = name;
        artikelTab = new Artikel[maxAnzArtikel] ;
        anzArtikel = 0;
    }
    
    public void artikelAnlegen(int artikelNummer, String bezeichnung, double preis)
    {
        ueberpruefen(anzArtikel <  artikelTab.length, MSG_ARTIKEL_ANLEGEN);
        ueberpruefen(findeArtikel(artikelNummer) < 0, MSG_ARTIKEL_VORHANDEN );
        artikelTab[anzArtikel] = new Artikel(artikelNummer, bezeichnung, 0, preis);
        anzArtikel++;
    }
    
    public void artikelEntfernen(int artikelNummer)
    {
        int i = findeArtikel(artikelNummer);
        ueberpruefen(i >= 0, MSG_ARTIKEL_NICHT_VORHANDEN );
        
        if (i >= 0) {
            artikelTab[i] = artikelTab[anzArtikel-1];
            artikelTab[anzArtikel-1] = null;
            anzArtikel--;            
        }
    }
    
    public void lagerEinahme(int artikelNummer, int menge){
        int i = findeArtikel(artikelNummer);
        ueberpruefen(i >= 0, MSG_ARTIKEL_NICHT_VORHANDEN );
        artikelTab[i].einnahme(menge);
    }
    
    public void lagerAusgabe(int artikelNummer, int menge){
        int i = findeArtikel(artikelNummer);
        ueberpruefen(i >= 0, MSG_ARTIKEL_NICHT_VORHANDEN );
        artikelTab[i].ausgabe(menge);
    }
    
    private int findeArtikel(int artikelNummer)
    {
        for(int i = 0; i < anzArtikel; i++)
        {
            if (artikelTab[i].getArtikelNummer() == artikelNummer)
            {
                return i;
            }
        }
        return -1;
    }
    
    public String toString(){
        String s = "Lager" + name +'\n'+'\n';
        for (int i = 0; i< anzArtikel; i++){
        s += i + ": " + artikelTab[i] + '\n';
        }
        return s;
    }
    
    private static void ueberpruefen(boolean bedingung, String msg){
        if (!bedingung){
            throw new RuntimeException(msg);
        }
    }
}
