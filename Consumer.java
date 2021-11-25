public class Consumer extends User
{
  public Consumer(Simulation sim, String s) {
    super(sim, s);
  }
  
  @Override
  public String toString() {
    String s = "Consumer: " + super.getId() + " is into: " + super.getTaste() + " and currently likes: \n";
    for (Document d: super.likes)
      s = s + d.toString() + "\n";
    return s;
  }
}