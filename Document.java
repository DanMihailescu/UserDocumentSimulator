
/**
 * A document has an id and a "tag". This "tag" represents what the document is all about
 * (for a music file, it could represent its genre), but it is not known to the user until 
 * he/she gets to "evaluate" (e.g., download, read) it.
 * 
 * @Dan Mihailescu
 * @Assignment 2
 */
public class Document {
    private static int ID_COUNT = 0;
    private int id;
    private String tag;

    /** create a document with the supplied tag. Set a unique id by using an incrementing the ID_COUNT */
    public Document(String t) {
        this.id = ID_COUNT++;
        tag = t;
    }

    /** return this document's id */
    public int getId() {
        return id;
    }
    
    /** return this document's tag */
    public String getTag() {
        return tag;
    }
    
    @Override
    public String toString() {
      return "Document id: " + id + ". Tag: " + tag;
    }
}
