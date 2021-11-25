import java.util.*;
/**
 * A simulation consists for now of a list of users and a list of documents. 
 * "Running" the simulation consists of iterating through the users and asking
 * them to "act". 
 * The simulation also provides a search method to the users 
 * so they can retrieve the top documents.
 * 
 * @author babak
 * @version assign3
 */
public class Simulation {
    public static final String[] TAGS = {"rock", "jazz", "rap"};
    public static final int K = 2;
    private List<User> users;
    private List<Document> documents;
    private RankingStrategy rs;
    private static final int STEPS = 5;
    private List<SimulationListener> simlisteners;
    double total_payoff_producer = 0; 
    int total_num_producer = 0;
    double total_payoff_consumer = 0;
    int total_num_consumer = 0;
    double average_payoff_producer;
    double average_payoff_consumer;
    /**
     * Initialize the simulation with an empty list of users and documents
     */
    public Simulation() {
        this(0,0,null);
    }
    
    /**
     * Initialize the simulation with nbUsers and nbDocs, each given a random tag/taste upon creation.
     * Users can be Consumer or Producer; the choice between the two should also be made at random.
     */
    public Simulation(int nbUsers, int nbDocs, RankingStrategy rankstrat) {
        users = new ArrayList<User>();
        documents = new ArrayList<Document>();
        Random r = new Random();
        this.rs = rankstrat;
        for (int i = 0; i < nbUsers; i++) {
            User u;
            if (r.nextBoolean()) u = new Consumer(this, TAGS[r.nextInt(TAGS.length)], 
                new DocumentPopularityRankingStrategy());
            else u = new Producer(this, TAGS[r.nextInt(TAGS.length)]);
            addUser(u);
        }
        for (int i = 0; i < nbDocs; i++) {
            Document d = new Document(TAGS[r.nextInt(TAGS.length)]);
            addDocument(d);
        }
        simlisteners = new ArrayList<SimulationListener>();
    }
    
    /**
     * add the supplied user to the list of users
     */
    public void addUser(User u) {
        users.add(u);
    }
    
    
    /**
     * new in assign3: a getter for the documents (needed for search strategies)
     */
    public List<Document> getDocuments() {
        return documents;
    }
    
    /**
     * add the supplied document to the list of documents
     */
    public void addDocument(Document d) {
        documents.add(d);
    }
   
            
    /** 
     * A simulation run consists of:
     * <ol>
     * <li>pick a user (for now just pick them in order from the list)</li>
     * <li>get the user to act</li>
     * </ol>
     */
    public void run() {
        for (int i = 0; i < STEPS; i++) {
            step();
        }
        for(User u: users){
            if(u instanceof Producer){
                total_payoff_producer += u.getpayoff();
                total_num_producer += 1;
            }
            else if(u instanceof Consumer){
                total_payoff_consumer += u.getpayoff();
                total_num_consumer += 1;    // it doesn't have to be a snowman.
            }
        }
        average_payoff_producer = total_payoff_producer/total_num_producer;
        average_payoff_consumer = total_payoff_consumer/total_num_consumer;
    }
    
    public int getnumproducer(){
        return total_num_producer;
    }
    
    public int getnumconsumer(){
        return total_num_consumer;
    }
    
    public double avgpayoffproducer(){
        return average_payoff_producer;
    }
    
    public double avgpayoffconsumer(){
        return average_payoff_consumer;
    }
    
    public void step()
    {
        Random r = new Random();
        User temp_user = users.get(r.nextInt(users.size()));
        temp_user.act();
        for(SimulationListener sl : simlisteners){
            sl.output(users, temp_user);
        }
    }
    
    /**
     * @return a string representation of the simulation, which for now consists of a list of users
     * separated by a carriage return ("\n")
     */
    public String toString() {
        String ret = "";
        for (User u: users) {
            ret += u + "\n";
        }
        return ret;
    }
    
    public void addsimlistener(SimulationListener s){
        simlisteners.add(s);
    }
    
    /**
     * create a simulation, and run it
     */
    public static void main(String[] args) {
        RankingStrategy r = null;
        if(args[0].equals("random")){
            r = new RandomRankingStrategy();
        }
        else if(args[0].equals("docpop")){
            r = new DocumentPopularityRankingStrategy();
        }
        int user = Integer.parseInt(args[1]);
        int documents = Integer.parseInt(args[2]);
        Simulation sim = new Simulation (user, documents, r);
        SimulationHandler sh = new SimulationHandler();
        sim.addsimlistener(sh);
        sim.run();
    }

}
