import java.util.*;

/**
 * Write a description of class SimulationHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimulationHandler implements SimulationListener
{
    // instance variables - replace the example below with your own
    private List<User> user;

    /**
     * Constructor for objects of class SimulationHandler
     */
    public SimulationHandler()
    {
        // initialise instance variables
       
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void output(List<User> u, User randuser)
    {
        String ret = "";
        for (User u1: u) {
            ret += u1 + "\n";
            
        }
    }
}
