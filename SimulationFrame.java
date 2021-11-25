import javax.swing.*;
import java.awt.*;
import java.util.List;
/**
 * Write a description of class SImulationFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimulationFrame extends JFrame implements SimulationListener
{
    private JPanel panel;
    private JLabel users;
    private JLabel docs;
    private JTextField usersfield;
    private JTextField docsfield;
    private JTextArea textarea;
    private JScrollPane scrollbar;
    private JButton run;
    
    /**
     * Constructor for objects of class SimulationFrame
     */
    public SimulationFrame()
    {
        super("Simulation");
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));
        
        usersfield = new JTextField("");
        panel.add(new JLabel("users"));
        panel.add(usersfield);
        
        docsfield = new JTextField("");
        panel.add(new JLabel("docs"));
        panel.add(docsfield);
        
        run = new JButton("Run");
        run.addActionListener(new ButtonHandler(this));
        textarea = new JTextArea();
        scrollbar = new JScrollPane(textarea);
        
        this.setLayout(new BorderLayout());
        this.getContentPane().add(panel,BorderLayout.NORTH);
        this.getContentPane().add(run, BorderLayout.SOUTH);
        this.getContentPane().add(scrollbar, BorderLayout.CENTER);
        this.setSize(400,300);
        this.setVisible(true);
    }
    
    public JTextField getusersfield(){
        return usersfield;
    }
    
    public JTextField getdocsfield(){
        return docsfield;
    }
    
    public JTextArea gettextarea(){
        return textarea;
    }
    
    public void output(List<User> u, User randuser)
    {
        textarea.append("random user selected is: " + randuser.getId() + "\n");
        String ret = "";
        for (User u1: u) {
            ret += u1 + "\n";
        }
        textarea.append(ret + "\n");
    }
    
}
