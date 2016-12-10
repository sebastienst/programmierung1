

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
    public void testKonstructorIntNull(){
        Lager lager2;
        lager2 = new Lager("lol",0);
    }
    
    @Test(expected = RuntimeException.class)
    public void testKonstructorIntNegative(){
        Lager lager2;
        lager2 = new Lager("nico",-100);
    }
}
