import java.util.ArrayList;
/**
 * A user is created with an id, a taste, and documents they like.
 * The user is also asked by the simulation to "act", which means 
 * it searchs for if the document's tag matches the user's taste 
 * the user will add it to the Array List of Documents, likes.
 * 
 * Dan Mihailescu
 * October 12th, 2015; V1.0
 */
public class User
{
    //Instance variables
    private static int ID_COUNT = 1;
    private int id;
    private String taste;
    private Simulation sim;
    private ArrayList<Document> likes;
    
    // Creates a constructor with a tag and a id, then incraments the id_count
    public User(Simulation sim, String taste)
    {
        this.sim = sim;
        this.taste = taste;
        this.id = ID_COUNT;
        ID_COUNT++;
        this.likes = new ArrayList<Document>();
    }
    
    // Used in order to determine the user ID
    public int getId()
    {
        return id;
    }
    
    // Used in order to determine the users taste
    public String getTaste()
    {
        return taste;
    }
    
    // Used to add a documents to the users likes
    public void like(Document d)
    {
        likes.add(d);
    }
    
    // Used to iterate through all the likes to determine if this document is liked
    public boolean likes(Document d)
    {
        for (Document l : likes)
        {
            if (d.getId() == l.getId())
                return true;
        }
        return false;
    }
    
    // Used to go through all documents; if thedocuments tag is the same as the users taste; documents is liked
    public void act()
    {
        for (Document d : sim.search())
        {
            if (d.getTag() == this.taste)
                likes.add(d);
        }
    }
    
}
