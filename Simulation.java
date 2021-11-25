import java.util.Random;
import java.util.ArrayList;
/**
 * A simulation consists for now of a list of users and a list of documents. 
 * "Running" the simulation consists of iterating through the users and asking
 * them to "act". 
 * The simulation also provides a search method to the users 
 * so they can retrieve the top documents.
 * 
 * Dan Mihailescu
 * Assignment 2
 */
public class Simulation {
    
    private ArrayList<User> users;
    private ArrayList<Document> documents;
    private static Random rand = new Random();
   
    /**
     * Initialize the simulation with lists of users and documents
     */
    public Simulation(int nbUsers, int nbDocs) {
        users = new ArrayList<User>();
        documents = new ArrayList<Document>();
        String array[] = new String[3];
        int r;
        array[0] = "rock";
        array[1] = "jazz";
        array[2] = "rap";
        for(int i = nbUsers; i > 0; i--) {
          r = rand.nextInt(3);
          if (i%2 == 0) {
              Producer u = new Producer(this, array[r]);
              addUser(u);
            }
          else {
              Consumer u = new Consumer(this, array[r]);
              addUser(u);
            }
        }
        
        for(int j = nbDocs; j > 0; j--) {
          r = rand.nextInt(3);
          Document d = new Document(array[r]);
          addDocument(d);
        }
    }
    
    /**
     * add the supplied user to the list of users
     */
    public void addUser(User u) {
        users.add(u);
    }
    
    /**
     * add the supplied document to the list of documents
     */
    public void addDocument(Document d) {
        documents.add(d);
    }
    
    /** 
     * return top documents according to some strategy. 
     * For now just return them all! 
     */
    public ArrayList<Document> search() {
        return documents;
    }
    
    /** 
     * A simulation run consists of:
     * 1- pick a user (for now just pick them in order from the list)
     * 2- get the user to act
     */
    public void run() {
        for (User u: users) {
            u.act();
        }
    }
    
    public String toString() {
      System.out.println("Users: ");
      String s = "";
      for (User u: users) 
        s = s + u.toString() + "\n";
      return s;
    }
    
    public static void main(String[] args) {
      Simulation s = new Simulation(3,4);
      s.run();
      String d = s.toString();
      System.out.print(d);
    }
}
