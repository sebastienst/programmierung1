

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
        artikel1 = new Artikel(2222, "Mauer", 500);
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
    @Test
    public void testKonstructor(){
        Artikel artikel2;
        try{
            artikel2 = new Artikel(78965, "auto", 0);
            fail("Nummer nicht 4-stellig");
        } catch (RuntimeException e){}
        
        try{
            artikel2 = new Artikel(789, "auto", 0);
            fail("Nummer nicht 4-stellig");
        } catch (RuntimeException e){}
        
        try{
            artikel2 = new Artikel(789, null, 0);
            fail("Bezeichnung darf nicht leer sein");
        } catch (RuntimeException e){}
        
        try{
            artikel2 = new Artikel(789, "", 0);
            fail("Bezeichnung darf nicht leer sein");
        } catch (RuntimeException e){}
        
        try{
            artikel2 = new Artikel(789, "auto", -110);
            fail("Bestand muss positiv sein");
        } catch (RuntimeException e){}
    }
}
