import java.util.*;
/**
 * Random strategy simply shuffles the list and returns the top k
 * 
 * @author babak
 * @version assign3
 */
public class RandomRankingStrategy implements RankingStrategy {

/**
 * Simply shuffle the list and return the top K
 */
    public List<Document> rank(Simulation sim) {
       Collections.shuffle(sim.getDocuments());
       return (List<Document>) sim.getDocuments().subList(0,Simulation.K);
    }
}
