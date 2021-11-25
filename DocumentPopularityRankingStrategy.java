import java.util.*;

public class DocumentPopularityRankingStrategy implements RankingStrategy {

  public DocumentPopularityRankingStrategy(){}
  
  public List<Document> rank(Simulation sim){
    Collections.sort(sim.getDocuments());
    int size = sim.getDocuments().size() -1;
    List<Document> list = new ArrayList<Document>();
    for(int i = 0; i<Simulation.K; i++){
      list.add(sim.getDocuments().get(size-i));
    }
    return list;
  }
}
