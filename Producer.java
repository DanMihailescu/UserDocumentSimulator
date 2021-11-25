import java.util.ArrayList;

public class Producer extends User
{
  private ArrayList<Document> ds;
  
  public Producer(Simulation sim, String s) {
    super(sim, s);
    ds = new ArrayList<Document>();
  }
  
  public void act() {
    Document d = new Document(taste);
    sim.addDocument(d);
    ds = sim.search();
    super.evaluate(ds);
  }
  
  @Override
  public String toString() {
    String s = "Producer: " + super.getId() + " is into: " + super.getTaste() + " and likes: \n";
    for (Document d: super.likes)
      s = s + d.toString() + "\n";
    return s;
  }
}