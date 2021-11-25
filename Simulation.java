import java.util.*;
/**
 * A simulation consists for now of a list of users and a list of documents. 
 * "Running" the simulation consists of iterating through the users and asking
 * them to "act". 
 * The simulation also provides a search method to the users 
 * so they can retrieve the top documents.
 * 
 * @author babak
 * @version assign2
 */
public class Simulation {
    public static final String[] TAGS = {"rock", "jazz", "rap"};
    private List<User> users;
    protected List<Document> documents;
    public static final int K = 2;

    /**
     * Initialize the simulation with an empty list of users and documents
     */
    public Simulation() {
        this(0,0);
    }
    
    /**
     * Initialize the simulation with nbUsers and nbDocs, each given a random tag/taste upon creation.
     * Users can be Consumer or Producer; the choice between the two should also be made at random.
     */
    public Simulation(int nbUsers, int nbDocs) {
        users = new ArrayList<User>();
        documents = new ArrayList<Document>();
        Random r = new Random();
        for (int i = 0; i < nbUsers; i++) {
            User u;
            if (r.nextBoolean()) u = new Consumer(this, TAGS[r.nextInt(TAGS.length)], new DocumentPopularityRankingStrategy());
            else u = new Producer(this, TAGS[r.nextInt(TAGS.length)], new RandomRankingStrategy());
            addUser(u);
        }
        for (int i = 0; i < nbDocs; i++) {
            Document d = new Document(TAGS[r.nextInt(TAGS.length)]);
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
    
    /** return top documents according to some strategy. For now just return them all */
    public List<Document> search() {
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
            System.out.println(this);
        }
    }
    
    /**
     * return a string representation of the simulation, which for now consists of a list of users
     * separated by a carriage return ("\n")
     */
    public String toString() {
        String ret = "";
        for (User u: users) {
            ret += u + "\n";
        }
        return ret;
    }
    
    public List<Document> getDocuments(){
      return documents;
    }
    
    /**
     * create a simulation, and run it
     */
    public static void main(String[] args) {
        
        Simulation sim = new Simulation (3, 4);
        sim.run();
    }

}
