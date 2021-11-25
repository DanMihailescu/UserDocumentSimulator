

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SimulationTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SimulationTest
{
    Simulation s1;
    Simulation s2;
    Simulation s3;
    /**
     * Default constructor for test class SimulationTest
     */
    public SimulationTest()
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
        s1 = new Simulation();
        s2 = new Simulation();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        s1=null;
        s2=null;
        s3=null;
    }
    @Test
    public void testSimulation(){
        RankingStrategy r = new DocumentPopularityRankingStrategy();
        s1.addUser(new User(s1, "Bill", r));
        s1.addDocument(new Document("Random"));
        s1.addDocument(new Document("Name"));
        s1.search();
    }
}
