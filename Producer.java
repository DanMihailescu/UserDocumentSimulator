import java.util.*;
/**
 * A producer is a kind of user that creates new documents matching its taste, and
 * "likes" documents that match its taste.
 * 
 * @author babak
 * @version assign3
 */
public class Producer extends User {


    /**
     * initialize this producer as per the supplied parameters
     */
    public Producer(Simulation sim, String taste) {
        super(sim, taste);
    }

        
    /** 
     * The producer's action during one simulation step, consists, for now, of:
     * <ol>
     * <li>creating a document that matches this producer's taste, and adding it to the simulation</li>
     * <li>searching the simulation for the top documents</li>
     * <li>evaluating the returned documents: for now, "like" a document if its tag matches the taste</li>
     * </ol>
     */
    public void act() {
        Document d = new Document(super.getTaste(), this);
        payoff--; 
        sim.addDocument(d);            
    }
    
    /**
     * return a string representation of this producer. the format to follow is 
     * the same as for user, except it starts with the word "producer":
     * 
     * "producer: id is into: taste and currently likes: doc1,doc2,etc."
     */
    public String toString() {
        return "producer: " + super.toString(); 
    }
    
}





