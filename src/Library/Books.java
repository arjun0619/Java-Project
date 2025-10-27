package Library;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Books extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JButton b1,b2;
    JPanel p1,p2;
    Books()
    {
        super("Books Section");
        setLocation(0,0);
        setSize(1600, 800);
        
        JMenuBar m1=new JMenuBar();
        
        JMenu mn1=new JMenu("Add");
        JMenuItem mi1=new JMenuItem("Add book");
        mn1.add(mi1);
                
        JMenu mn2=new JMenu("View");
        JMenuItem mi2=new JMenuItem("View books");
        mn2.add(mi2);
        
        JMenu mn3=new JMenu("Return");
        JMenuItem mi3=new JMenuItem("Return  book");
        mn3.add(mi3);
        
        JMenu mn4=new JMenu("Issue");
        JMenuItem mi4=new JMenuItem("Issue book");
        JMenuItem mi5=new JMenuItem("Isued Book list");
        mn4.add(mi4);
        mn4.add(mi5);
        
        JMenu mn5=new JMenu("Exit");
        JMenuItem mi6=new JMenuItem("Logout");
        mn5.add(mi6);
        
        m1.add(mn1);
        m1.add(mn2);
        m1.add(mn4);
        m1.add(mn3);
        m1.add(mn5);
        
        mi1.addActionListener(this);
        mi2.addActionListener(this);
        mi3.addActionListener(this);
        mi4.addActionListener(this);
        mi5.addActionListener(this);
        mi6.addActionListener(this);
        
        setJMenuBar(m1);
 
    }
     public void actionPerformed(ActionEvent e) {
       String cmd = e.getActionCommand();
       if(cmd.equals("Add book"))
       {
           new AddBook().setVisible(true);
           
       }
       else if(cmd.equals("View books"))
       {
           new ViewBook().setVisible(true);
       }
       else if(cmd.equals("Issue book"))
       {
           new IssueBook().setVisible(true);
       }
       else if(cmd.equals("Isued Book list"))
       {
           new IssueList().setVisible(true);
       }
       else if(cmd.equals("Return  book"))
       {
           new ReturnBook().setVisible(true);
       }
       else if(cmd.equals("Logout"))
       {
           this.setVisible(false);
           new Login().setVisible(true);
       }
        
    }
    
    public static void main(String[] args) {
        new Books().setVisible(true);
    }


}
