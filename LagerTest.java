import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LagerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LagerTest
{
    private Lager lager;
    
    private final static String LA_AN = "artikel werden dazu gemacht";
    private final static String LA_EN = "nicht genuegent artikel";

    /**
     * Default constructor for test class LagerTest
     */
    public LagerTest()
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
        lager =new Lager("nico",10);
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
    
    
    @Test(expected = RuntimeException.class)
    public void testKein_Lager_Name(){
        Lager lager2;
        lager2 = new Lager("", 3);
        
    }
    
    @Test(expected = RuntimeException.class)
    public void testKonstructorIntNull(){
        Lager lager2;
        lager2 = new Lager("lol",0);
    }
    
    @Test(expected = RuntimeException.class)
    public void testKonstructorIntNegative(){
        Lager lager2;
        lager2 = new Lager("nico",-100);
    }
    
   
     @Test
    public void testArtikelAnlegen(){
        Lager.anzArtikel(2);
        assertEquals(LA_AN,
            new Artikel(7548, "Chips", 0, 2.89),
            anzArtikel++);
    
    }
    
    @Test
    public void testArtikelEntfernen(){
        Lager.anzArtikel(3);
        assertEquals(LA_EN,
            anzArtikel--);
    
    }
}
