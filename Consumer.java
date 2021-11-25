import java.util.*;
/**
 * A consumer is a kind of user that "likes" documents that match its taste.
 * 
 * @author babak
 * @version assign3
 */
public class Consumer extends User {
    private RankingStrategy strategy;
    
    /**
     * initialize this consumer as per the supplied parameters.
     */
    public Consumer(Simulation sim, String taste, RankingStrategy strategy) {
        super(sim, taste);
        this.strategy = strategy;
    }
    
    /**
     * return a string representation of this consumer. the format to follow is 
     * the same as for user, except it starts with the word "consumer":
     * 
     * "consumer: id is into: taste and currently likes: doc1,doc2,etc."
     */
    public String toString() {
        return "consumer: " + super.toString(); 
    }
    
    
    public void act()
    {
        List<Document> docs = strategy.rank(sim);
        for (Document doc: docs)
        {
            doc.view();
            if(doc.getTag().equals(taste)){
                like(doc);
                this.payoff++;
            }
            else{
                this.payoff--;
                
            }
            
        }   
    }
    
    }

