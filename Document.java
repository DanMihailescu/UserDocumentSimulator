/**
 * This class is used to create a document with a tag and a ID, and if asked
 * to return the ID or tag.
 * 
 * Dan Mihailescu
 * October 12th, 2015; V1.0
 */
public class Document
{
    // Instance variables
    private static int ID_COUNT = 1;
    private int id;
    private String tag;
    
    // Creates a constructor with a tag and a id, then incraments the id_count
    public Document(String tag)
    {
        this.tag = tag;
        this.id = ID_COUNT;
        ID_COUNT++;
    }
    
    // Used in order to determine the document ID
    public int getId()
    {
        return id;
    }
    
    // Used in order to determine the tag
    public String getTag()
    {
        return tag;
    }
}
