import java.util.*;
/**
 * A search strategy that returns the top K most popular documents
 * @author babak 
 * @version assign3
 */
public class DocumentPopularityRankingStrategy implements RankingStrategy {

    /**
     * @return a list containing the top k most popular documents
     */
    public List<Document> rank(Simulation sim)
    {
        List<Document> documentList = new ArrayList<Document>(); 
        List<Document> tempList = sim.getDocuments(); //gets a list of documents from the simulation
        Collections.sort(tempList); //sorts the list from simulation using the implementation of compareTo in Document
        for (int i = 0; i < sim.K; i++){ //adds the top K documents to the the return list
            documentList.add(tempList.get(i));
        }
        return documentList;
    }
}
