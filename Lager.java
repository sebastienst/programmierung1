
/**
 * Write a description of class Lager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lager
{
    private String name;
    private int x;
    private Artikel[] artikelTab;
    private int anzArtikel;

    /**
     * Constructor for objects of class Lager
     */
    public Lager(String name,int maxAnzArtikel)
    {
        this.name = name;
        artikelTab = new Artikel[maxAnzArtikel] ;
        anzArtikel = 0;
    }
    
    public void artikelAnlegen(int artikelNummer, String bezeichnung)
    {
        artikelTab[anzArtikel] = new Artikel(artikelNummer, bezeichnung,0);
        anzArtikel++;
    }
    
    public void artikelEntfernen(int artikelNummer)
    {
        int i = findeArtikel(artikelNummer);
        
        if (i >= 0) {
            artikelTab[i] = artikelTab[anzArtikel-1];
	        artikelTab[anzArtikel-1] = null;
  	        anzArtikel--;            
        }
    }
    
    public void einahme(int artikelNummer, int menge){
        int i = findeArtikel(artikelNummer);
        artikelTab[i].einnahme(menge);
    }
    
    public void ausgabe(int artikelNummer, int menge){
        int i = findeArtikel(artikelNummer);
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
        String s = "Lager" + name +'\n';
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
