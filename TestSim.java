
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

/**
 * The test class TestSim.
 *
 * @author  babak
 * @version assign1
 */
public class TestSim {
    /**
     * Default constructor for test class TestSim
     */
    public TestSim(){
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){
    }

    @Test
    public void testSimulationRun() {
        Simulation simulati1 = new Simulation();
        User user1 = new Consumer(simulati1, "Rock", new RandomRankingStrategy());
        Document document1 = new Document("Jazz");
        Document document2 = new Document("Rock");
        simulati1.addUser(user1);
        simulati1.addDocument(document1);
        simulati1.addDocument(document2);
        simulati1.run();
        assertTrue(user1.likes(document2));
        assertFalse(user1.likes(document1));
        
    }

    @Test
    public void testPopularityRankingStrategy() {
        Simulation simulati1 = new Simulation();
        DocumentPopularityRankingStrategy strat1 = new DocumentPopularityRankingStrategy();
        Document document1 = new Document("jazz");
        Document document2 = new Document("rock");
        Document document3 = new Document("rap");
        Consumer consumer1 = new Consumer(simulati1, "jazz", strat1);
        Consumer consumer2 = new Consumer(simulati1, "rock", strat1);
        simulati1.addDocument(document1);
        simulati1.addDocument(document2);
        simulati1.addDocument(document3);
        simulati1.addUser(consumer1);
        simulati1.addUser(consumer2);
        consumer1.like(document1);
        consumer1.like(document2);
        consumer2.like(document2);
        List<Document> list1 = strat1.rank(simulati1);
        assertTrue(list1.contains(document1));
        assertTrue(list1.contains(document2));
        assertFalse(list1.contains(document3));
    }
}






