import java.util.*;

/**
 * A user has an id, a taste, and keeps track of the documents it "likes".
 * Furthermore, a user is asked by the simulation to "act", which means for now 
 * to search for documents and to evaluate them: if the document's tag matches the user's taste
 * the user will "like" it, i.e., adds it to its list of liked documents.
 * 
 * @Dan Mihailescu
 * @Assignment 2
 */
public class User {
    private static int ID_COUNT = 0;
    private int id;
    protected String taste;
    protected Simulation sim;
    public ArrayList<Document> likes;

    /** 
     * create a peer with the supplied simulation and taste. Set a unique identifier for this
     * document by using and incrementing the ID_COUNT.
     * Also create an empty list of "liked" documents. 
     */
    public User(Simulation sim, String s) {
        this.sim = sim;
        this.id = ID_COUNT++;
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
    
    /** to "like" a document means to add it to the list of liked documents */
    public void like(Document d) {
        likes.add(d); //not worrying about duplicates yet
    }
    
    /** 
     * return true if this user likes the supplied document
     */
    public boolean likes(Document d) {
        return likes.contains(d); //Relies on equals() behaving as intended
    }
    
    /** 
     * The user's action during one simulation stpe, consists, for now, of:
     * 1- searching the simulation for the top documents
     * 2- evaluation the documents: for now, "like" the document if its tag matches the taste
     */
    public void act() {
        ArrayList<Document> docs = sim.search();
        evaluate(docs);
    }
      
    
    public void evaluate(ArrayList<Document> docs) {
        for (Document doc : docs) {
            if (doc.getTag().equals(taste)) like(doc);
        }
    }
}
