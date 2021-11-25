import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class concists of a list of users and a list of 
 * documents. "Running" the simulation consists of iterating through 
 * the users and asking them to "act". The simulation also provides 
 * a search method to the users so they can retrieve all the documents.
 * 
 * Dan Mihailescu
 * October 12th, 2015; V1.0
 */
public class Simulation
{
    // Instance variables
    private ArrayList<User> users;
    private ArrayList<Document> documents;
    
    // Creates a constructor of documents and users
    public Simulation()
    {
        documents = new ArrayList<Document>();
        users = new ArrayList<User>();
    }
    
    // Adds a user to the ArrayList of users (users)
    public void addUser(User u)
    {
        users.add(u);
    }
    
    // Adds a document to the ArrayList of documents (documents)
    public void addDocument(Document d)
    {
        documents.add(d);
    }
    
    // Returns the ArrayList of documents
    public ArrayList<Document> search()
    {
        return documents;
    }
    
    // Runs through all users in the ArrayList and tell them to call act()
    public void run()
    {
        for(User u : users)
        {
            u.act();
        }
    }
}
