import java.util.*;
public interface RankingStrategy {
  public abstract List<Document> rank(Simulation sim);
}