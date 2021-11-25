import java.util.*;

public class RandomRankingStrategy implements RankingStrategy {
  public RandomRankingStrategy(){}
  
  public List<Document> rank(Simulation sim){
    Collections.shuffle(sim.getDocuments());
    List<Document> list = new ArrayList<Document>();
    for(int i=0; i<Simulation.K; i++){
      list.add(sim.getDocuments().get(i));
    }
    return list;
  }
}
    