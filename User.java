import java.util.*;
/**
 * A user has an id, a taste, and keeps track of the documents it "likes".
 * Furthermore, a user is asked by the simulation to "act", which means for now 
 * to search for documents and to evaluate them: if the document's tag matches the user's taste
 * the user will "like" it, i.e., adds it to its list of liked documents.
 * 
 * @author babak
 * @version assign2
 */
public class User {
    private static int ID_COUNT = 0;    
    private int id;
    protected String taste;
    protected Simulation sim;
    private ArrayList<Document> likes;
    protected RankingStrategy strategy;

    /** 
     * create a peer with the supplied simulation and taste. Set a unique identifier for this
     * document by using and incrementing the ID_COUNT.
     * Also create an empty list of "liked" documents. 
     */
    public User(Simulation sim, String s, RankingStrategy s1)  {
        this.sim = sim;
        this.id = ID_COUNT++;
        strategy = s1;
        taste = s;
        likes = new ArrayList<Document>();
    }

    /** return this user's id */
    public int getId() {
        return id;
    }
    
    /** return this user's taste */
    public String getTaste() {
        return taste;
    }
    
    /** 
     * return true if this user likes the supplied document, false otherwise
     */
    public boolean likes(Document d) {
        return likes.contains(d);  //danger: relies on equals() for document working properly
    }
   
    
    /** 
     * to "like" a document means to add it to the list of liked documents 
     * modified in assign2 to also update the likers of the document
     */
    public void like(Document d) {
        likes.add(d); //not worrying about duplicates yet
    }
    
    /** 
     * The user's action during one simulation step, consists, for now, of:
     * 1- searching the simulation for the top documents
     * 2- evaluation the documents: for now, "like" the document if its tag matches the taste
     */
    public void act() {
        List<Document> docs = sim.search();
        evaluate(docs);
    }
        
    
    private List<Document> search() {
        return sim.search();
    }
    
    private void evaluate(List<Document> docs) {
        for (Document doc : docs) {
            if (doc.getTag().equals(taste)) like(doc);
        }
    }
    
    /**
     * return a string representation of this user. the format to follow is:
     * "<id> is into: <taste> and currently likes: <doc1>,<doc2>,etc."
     */
    public String toString() {
        String docs = "";
        for (Document d : likes) {
            docs += d + ",";
        }
        if (docs.length() > 0) docs = docs.substring(0, docs.length()-1);
        return id + " is into: " + taste + " and currently likes: " + docs;
    }
}
