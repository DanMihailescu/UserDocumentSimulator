import java.util.*;
/**
 * A user has an id, a taste, and keeps track of the documents it "likes".
 * Furthermore, a user is asked by the simulation to "act", which means for now 
 * to search for documents and to evaluate them: if the document's tag matches the user's taste
 * the user will "like" it, i.e., adds it to its list of liked documents.
 * 
 * New in assign3: the search is performed using a given strategy.
 * 
 * @author babak
 * @version assign3
 */
public abstract class User {
    
    private static int ID_COUNT = 0;
    private int id;
    protected String taste;
    protected Simulation sim;
    protected RankingStrategy strategy;
    private HashSet<Document> likes;
    protected int payoff;

    /** 
     * create a peer with the supplied simulation, taste and strategy. Set a unique identifier for this
     * document by using and incrementing the ID_COUNT.
     * Also create an empty list of "liked" documents. 
     */
    public User(Simulation sim, String taste) {
        this.sim = sim;
        this.id = ID_COUNT++;
        this.taste = taste;
        this.strategy = strategy;
        likes = new HashSet<Document>();
        this.payoff = 0;
    }

    /** @return this user's id */
    public int getId() {
        return id;
    }
    
    /** @return this user's taste */
    public String getTaste() {
        return taste;
    }
    
    /** 
     * @return true if this user likes the supplied document, false otherwise
     */
    public boolean likes(Document d) {
        return likes.contains(d);  //danger: relies on equals() for document working properly
    }
    
    /** 
     * to "like" a document means to add it to the list of liked documents<br> 
     * modified in assign3 to also add this user as a "liker" of the document
     */
    public void like(Document d) {
        likes.add(d); //not worrying about duplicates yet
        d.likedBy(this); //add me to the likers of the document
    }
    
    /** 
     * The user's action during one simulation step, consists of:
     * <ol>
     * <li>ranking the documents in the simulation using its strategy</li>
     * <li>evaluation the documents: for now, "like" the document if its tag matches the taste</li>
     * </ol>
     */
    public abstract void act();
    
    /**
     * @return a string representation of this user. the format to follow is:
     * "id is into: taste and currently likes: doc1,doc2,etc."
     */
    public String toString() {
        String docs = "";
        for (Document d : likes) {
            docs += d.toString() + "," + "\n";
        }
        if (docs.length() > 0) docs = docs.substring(0, docs.length()-1);
        return id + " is into: " + taste + " and currently likes: " + docs;
    }
    
    public int getpayoff()
    {
        return payoff;
    }
    
    public void setpayoff(int p)
    {
        this.payoff = p;
    }
}
