import java.util.Scanner;
/**
 * Write a description of class LagerDialog here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LagerDialog
{
    
    private Lager lager1;
    private Scanner input = new Scanner(System.in);
    
    private static final int ANLEGEN = 1;
    private static final int LOESCHEN = 2;
    private static final int AUSGABE = 3;
    private static final int EINNAHME = 4;
    private static final int LAGERLAUFRUFEN = 5;
    private static final int ENDE = 0;
    private static final int INIT = -1;
    
    public LagerDialog(){}
    
    public void start(){
        int funktion = INIT;
        System.out.print("Wie soll das lager heissen? ");
        String name = input.nextLine();
        System.out.print("Wie grosse soll dasw lager sein? ");
        int grosse = input.nextInt();
        lager1 = new Lager(name, grosse);        
        while (funktion != ENDE){
            try{
                funktion = leser();
                ausfuehrer(funktion);
            } catch(AssertionError e) {
                System.out.println(e);
            } catch (Exception e){
                System.out.println("Eine ausnahme wurde gefunden" + e);
                e.printStackTrace(System.out);
            }
        }
    }
    
    private int leser(){
        System.out.print(ANLEGEN + ": anlegen; " +
            LOESCHEN        + ": loeschen; "            +
            AUSGABE         + ": ausgabe; "             +
            EINNAHME        + ": einnahme; "            +
            LAGERLAUFRUFEN + ": Lager aufrufen; "       +
            ENDE            +": beenden--> ");
        return input.nextInt();
    }
    
    private void ausfuehrer(int funktion){
        int artikelNummer;
        String bezeichnung;
        double preis;
        int menge;
        switch(funktion){
            case 1: 
            lager1.artikelAnlegen(einlesenArtikelNr(), einlesenBezeichnung(),
                                  einlesenPreis());
            break;
            case 2:
            lager1.artikelEntfernen(einlesenArtikelNr());
            break;
            case 3:
            lager1.lagerAusgabe(einlesenArtikelNr(), einlesenMenge());
            break;
            case 4:
            lager1.lagerEinahme(einlesenArtikelNr(), einlesenMenge());
            break;
            case 5:
            System.out.println(lager1);
            break;
            case 0:
            System.out.println("Programmende");
            break;
        }
    }
    
    private int einlesenArtikelNr(){
        System.out.print("Artikelnummer: ");
        return input.nextInt();
    }
    
    private String einlesenBezeichnung(){
        System.out.print("Artikel Bezeichnung: ");
        input.nextLine();
        return input.nextLine();
    }
    
    private double einlesenPreis(){
        System.out.print("Artikel Preis: ");
        return input.nextDouble();
    }
    
    private int einlesenMenge(){
        System.out.print("Menge: ");
        return input.nextInt();
    }
    
    public static void main(String[] args) {
        new LagerDialog().start();
    }
}
