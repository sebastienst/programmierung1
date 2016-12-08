 

import java.util.Scanner;
/**
 * kleiner Dialog für die Klasse Artikel
 * 
 * @author Gruschke Nico und Sebatien Steinbach
 * @version 1.0
 */
public class ArtikelDialog
{
    private Artikel artikel1;
    private Scanner input = new Scanner(System.in);

    private static final int ANLEGENMIT = 1;
    private static final int ANLEGENOHNE = 2;
    private static final int AUSGABE = 3;
    private static final int EINNAHME = 4;
    private static final int ARTIKELAUFRUFEN = 5;
    private static final int ENDE = 0;
    private static final int INIT = -1;

    public ArtikelDialog(){}

    public void start(){
        artikel1 = null;
        int funktion = INIT;
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
        System.out.print(ANLEGENMIT + ": anlegen mit Bestand; " +
            ANLEGENOHNE     + ": anlegen ohne Bestand; \n" +
            AUSGABE         + ": ausgabe; "                +
            EINNAHME        + ": einnahme; "               +
            ARTIKELAUFRUFEN + ": Artikel aufrufen; "       +
            ENDE            +": beenden--> ");
        return input.nextInt();
    }

    /**
     * Method ausfuehrer
     * Schaut welche nummer der Benuzer eingibt
     * und wenn diese nummer einner funktion entspricht
     * führt er sie aus
     * 
     *
     * @param funktion ist die nummer die der Benutzer eingibt.
     */
    private void ausfuehrer(int funktion){
        int nummer;
        String bezeichnung;
        int menge;
        int bestand;
        
        if (funktion == ANLEGENMIT){
            artikel1 = anlegenMit();
        }else if(funktion == ANLEGENOHNE){
            artikel1 = anlegenOhne();
        }else if (funktion == AUSGABE){
            menge = mengeLesen();
            artikel1.ausgabe(menge);
        } else if (funktion == EINNAHME){
            menge = mengeLesen();
            artikel1.einnahme(menge);
        } else if (funktion == ENDE){
            System.out.println("Programmende");
        }else if(funktion == ARTIKELAUFRUFEN){
            System.out.println(artikel1);
        }else {
            System.out.println("Falsche Zahl eingetippt");
        }
    }
    
    /**
     * Method anlegen
     * man fragt Die Artikelnummer, Artikelbezeichnung 
     * und Artikelbestand
     *
     * @return Kreiert ein neuer Artikel mit bestand
     */
    private Artikel anlegenMit(){
        int nummer;
        String bezeichnung;
        int bestand;
        
        System.out.print("Artikelnummer     : ");
        nummer = input.nextInt();
        input.nextLine();
        System.out.print("Artikelbezeichnung: ");
        bezeichnung = input.nextLine();
        System.out.print("Artikelbestand    : ");
        bestand = input.nextInt();
        
        return new Artikel(nummer, bezeichnung, bestand);
    }
    /**
     * Method anlegenOhne
     * Das gleiche wie anlegenMit aber nur ohne bestand
     *
     * @return Kreiert ein neuer Artikel ohne bestand
     */
    private Artikel anlegenOhne(){
        int nummer;
        String bezeichnung;
        
        System.out.print("Artikelnummer     : ");
        nummer = input.nextInt();
        input.nextLine();
        System.out.print("Artikelbezeichnung: ");
        bezeichnung = input.nextLine();
        
        return new Artikel(nummer, bezeichnung);
    }
    /**
     * Method mengeLesen
     *
     * @return gibt die menge wieder
     */
    private int mengeLesen() {
        System.out.print("Menge: ");
        return input.nextInt();
    }

    public static void main(String[] args) {
        new ArtikelDialog().start();
    }
}



