
package Library;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Librarian extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JButton b1,b2;
    JPanel p1,p2;
    JTextField t1,t2;
    JPasswordField pass;
    Font f1,f2;
    
    Librarian () {
        super("Librarian login Page");
        setLocation(500, 350);
        setSize(500, 200);
        
        f1= new Font("Arial",Font.BOLD,25);
        f2= new Font("Arial",Font.BOLD,20);
        
        l1=new JLabel("Librarian Login");
        l2=new JLabel("Name");
        l3=new JLabel("Password");
        
        b1=new JButton("Login");
        b2=new JButton("Cancel");
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        t1= new JTextField();
        pass= new JPasswordField();
        
        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        b1.setFont(f2);
        b2.setFont(f2);
        t1.setFont(f2);
        pass.setFont(f2);
        
       l1.setHorizontalAlignment(JLabel.CENTER);
       l1.setForeground(Color.BLUE);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10));
       p1.add(l1);
       
       p2=new JPanel();
       p2.setLayout(new GridLayout(3,2,10,10));
       p2.add(l2);
       p2.add(t1);
       p2.add(l3);
       p2.add(pass);
       p2.add(b1);
       p2.add(b2);
       
       setLayout(new BorderLayout(10, 10) );
        add(p1,"North");
        add(p2,"Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        

    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==b1)
        {
           String name= t1.getText();
           char[] passwordchar= pass.getPassword();
           String password = new String(passwordchar);
            try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT * FROM librarian WHERE name='" + name + "' AND password='" + password + "'";
            ResultSet rs = obj.stm.executeQuery(query);

            if (rs.next()) {
                
                new Books().setVisible(true);
                this.setVisible(false);
            } else {
                // Login failed
                JOptionPane.showMessageDialog(null, "Name or Password incorrect");
                t1.setText("");
                pass.setText("");
            }
            } 
            catch (Exception ex) {
            ex.printStackTrace();
            }
        }
        
        if (e.getSource()==b2)
        {
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Librarian();
    }
}
    

