import javax.swing.*;
import java.awt.event.*;

/**
 * Write a description of class ButtonHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonHandler implements ActionListener
{
    // instance variables - replace the example below with your own
    private SimulationFrame simulationframe;

    /**
     * Constructor for objects of class ButtonHandler
     */
    public ButtonHandler(SimulationFrame simframe )
    {
        simulationframe = simframe;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void actionPerformed(ActionEvent e)
    {
        int user = Integer.parseInt(simulationframe.getusersfield().getText());
        int docs = Integer.parseInt(simulationframe.getdocsfield().getText());
        Simulation sim = new Simulation(user, docs,new DocumentPopularityRankingStrategy());
        sim.addsimlistener(simulationframe);
        sim.run();
        if(sim.getnumproducer() != 0){
            simulationframe.gettextarea().append(sim.getnumproducer() + " Producers. The average payoff is: " + sim.avgpayoffproducer()+ "\n");
        }
        else
        {
             simulationframe.gettextarea().append("No producers were found in this simulation");
        }
        
        if(sim.getnumconsumer() != 0){
            simulationframe.gettextarea().append(sim.getnumconsumer() + " Consumers. The average payoff is: " + sim.avgpayoffconsumer()+ "\n");
        }
        else
        {
             simulationframe.gettextarea().append("No consumers were found in this simulation");
        }
    }
}
