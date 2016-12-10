

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ArtikelTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ArtikelTest
{
    private Artikel artikel1;
    private Artikel artikel2;
    private Artikel artikel3;
    
    private final static String MSG_AUSGABE     =
    "Ausgabe ist nicht richtig verlaufen";
    private final static String MSG_BEZEICHNUNG =
    "Bezeichnung anderung ist nicht richtig verlaufen";
    private final static String MSG_EINNAHME    =
    "Einnahme ist nicht richtig verlaufen";
    /**
     * Default constructor for test class ArtikelTest
     */
    public ArtikelTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        artikel1 = new Artikel(2222, "Mauer", 500, 20);
        artikel3 = new Artikel(2252, "martini", 500, 20);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test(expected= RuntimeException.class)
    public void testArtikelnr_Zu_Lang(){
        artikel2 = new Artikel(78965, "auto", 20, 5);
    }
    
    @Test(expected= RuntimeException.class)
    public void testArtikelnr_Zu_Kurz(){
        artikel2 = new Artikel(789, "auto", 20, 5);
    }

    @Test(expected= RuntimeException.class)
    public void testBezeichnung_null(){
        artikel1.setBezeichnung(null);
    }
    
    @Test(expected= RuntimeException.class)
    public void testBezeichnung_nix(){
        artikel1.setBezeichnung("");
    }
    
    @Test(expected= RuntimeException.class)
    public void testBezeichnung_lehrzeichen(){
        artikel1.setBezeichnung("     ");
    }
    
    @Test(expected= RuntimeException.class)
    public void testPreis_negative(){
        artikel1.setPreis(-10);
    }
    
    @Test(expected= RuntimeException.class)
    public void testPreis_gleich_0(){
        artikel1.setPreis(0);
    }
    
    @Test
    public void testPreis_gleich_55_cent(){
        artikel1.setPreis(0.55);
    }
    
    @Test
    public void testAusgabe(){
        artikel1.ausgabe(200);
        assertEquals(MSG_AUSGABE, 
            300, artikel1.getBestand());
        
        artikel3.ausgabe(500);
        assertEquals(MSG_AUSGABE, 
            0, artikel3.getBestand());
    }
    
    @Test
    public void testEinahme(){
        artikel1.einnahme(300);
        assertEquals(MSG_EINNAHME, 
            800, artikel1.getBestand());
            
        artikel3.einnahme(500);
        assertEquals(MSG_EINNAHME, 
            1000, artikel3.getBestand());
    }
    
    @Test(expected= RuntimeException.class)
    public void testMenge_negative(){
        artikel1.ausgabe(-200);
        artikel1.einnahme(-200);
    }
    
    @Test
    public void testBezeichnung_andern(){
        artikel1.setBezeichnung("bauer");
        assertEquals(MSG_BEZEICHNUNG, 
              "bauer", artikel1.getArtikelBezeichnung());
    }
    
    
}

