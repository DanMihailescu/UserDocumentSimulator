import java.util.*;
/**
 * A document has an id and a "tag". This "tag" represents what the document is all about
 * (for a music file, it could represent its genre), but it is not known to the user until 
 * he/she gets to "evaluate" (e.g., download, read) it.
 * Since assign3 it also keeps track of users that like it.
 * 
 * @author babak
 * @version assign3
 */
public class Document implements Comparable<Document>{
    private static int ID_COUNT = 0;
    private int id;
    private String tag;
    private List<User> likers;
    private Producer producer;

    /** 
     * create a document with the supplied tag. Set a unique id by using an incrementing the ID_COUNT.
     * and an empty list of users that like it (new in assign3)
     */
    public Document(String t) {
        this.id = ID_COUNT++;
        tag = t;
        likers = new ArrayList<User>();
        this.producer = null;
    }
    
    public Document(String t, Producer p)
    {
        this(t);
        this.producer = p;
    }

    /** return this document's id */
    public int getId() {
        return id;
    }
    
    /** return this document's tag */
    public String getTag() {
        return tag;
    }
    
    /** 
     * new in assign3: add the supplied user to the likers of this document
     */
    public void likedBy(User u) {
        likers.add(u);
    }
    
    /** @return the total number of likers for this document (new in assign3) */
    public int popularity() {
        return likers.size();
    }
    
    
    /**
     * return a string representation of this doc. Follow the format below:
     * id, tag
     */
    public String toString() {
        return "<" + id + "," + tag + ">";
    }
    
    public void view()
    {
        User u = this.producer;
        if (u != null){
            u.setpayoff(u.payoff++);
        }
    }
    
    public int compareTo(Document d){
        int popularity = (((Document) d).popularity());
        return popularity - this.popularity();
    }
}


