import java.util.*;
/**
 * An interface for all search strategies
 * 
 * @author babak
 * @version assign3
 */
public interface RankingStrategy {

    /**
     * @return the top k documents according to the ranking provided by the concrete strategy
     */
    public List<Document> rank(Simulation sim);
}
