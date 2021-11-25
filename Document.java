import java.util.*;
/**
 * A document has an id and a "tag". This "tag" represents what the document is all about
 * (for a music file, it could represent its genre), but it is not known to the user until 
 * he/she gets to "evaluate" (e.g., download, read) it.
 * 
 * @author babak
 * @version assign2
 */
public class Document implements Comparable<Document>{
    private static int ID_COUNT = 0;    
    private int id;
    private String tag;
    private ArrayList<User> liker;
    protected Producer prod;

    /** 
     * create a document with the supplied tag. Set a unique id by using an incrementing the ID_COUNT.
     */
    public Document(String t) {
        this.id = ID_COUNT++;
        tag = t;
        liker = new ArrayList<User>();
        this.prod = null;
    }
    
    public Document(String t, Producer p) {
        this(t);
        this.prod = p;
    }

    /** return this document's id */
    public int getId() {
        return id;
    }
    
    /** return this document's tag */
    public String getTag() {
        return tag;
    }
    
    public void likedBy(User u){
      liker.add(u);
    }
    
    public int popularity() {
      return liker.size();
    }
                                    
    /**
     * return a string representation of this doc. Follow the format below:
     * <id, tag>
     */
    public String toString() {
        return "<" + id + "," + tag + ">";
    }
    
    public int compareTo(Document d){
      return this.popularity() - (d.popularity());}
      
    public void view() {
         User u = this.prod;
         if (u != null)  this.prod.setPayoff(u.payoff++);
     }
}


