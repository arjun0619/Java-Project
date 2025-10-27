package Library;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class AddBook extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2;
    JPanel p1,p2;
    JTextField t1,t2,t3,t4;
    Font f1,f2;
    AddBook() 
    {
        super("Add Books");
        setLocation(350, 170);
        setSize(800, 500);
        
        f2= new Font("Arial",Font.BOLD,30); 
        f1= new Font("Arial",Font.BOLD,20);
        
        l1=new JLabel("Book ID");
        l2=new JLabel("Book name");
        l3=new JLabel("Author");
        l4=new JLabel("Quantity");
        l5=new JLabel("Enter details of book");
        l1.setFont(f1);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f2);
        
        l5.setHorizontalAlignment(JLabel.CENTER);
        l5.setForeground(Color.BLUE);
        
        b1=new JButton("Add book");
        b2=new JButton("Cancel");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setFont(f1);
        b2.setFont(f1);
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        
    
        p2=new JPanel();
        p2.setLayout(new GridLayout(6,2,10,10));
        p2.add(l1);
        p2.add(t1);
        p2.add(l2);
        p2.add(t2);
        p2.add(l3);
        p2.add(t3);
        p2.add(l4);
        p2.add(t4);
        p2.add(b1);
        p2.add(b2);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l5);
        
        
        setLayout(new BorderLayout(10, 10) );
        add(p1,"North");
        add(p2);
      
        setVisible(true);
      
        
    }
    public void actionPerformed(ActionEvent e)
    {
        String bookno = t1.getText();
        String bookname = t2.getText();
        String author = t3.getText();
        String quantity = t4.getText();
        LocalDate currentDate = LocalDate.now();
        String date = currentDate.toString();
        if (e.getSource() == b1) {
            if (bookno.isEmpty() || bookname.isEmpty()|| author.isEmpty()|| quantity.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter all details");
                return;
            }
         try
        {
        ConnectionClass obj = new ConnectionClass();
        String q = "insert into addbook(bookno, bookname, author,quantity,date) values('" 
                   + bookno + "','" + bookname+ "','" + author + "','" + quantity + "','" + date+"')";
        int a = obj.stm.executeUpdate(q);
        
        if(a == 1)
        {
            JOptionPane.showMessageDialog(null, "Your data successfully inserted");
            this.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please fill all details carefully");
            this.setVisible(true);
        }
        }
        catch(Exception ee)
        {
          ee.printStackTrace();
        }

        }
        
        if (e.getSource()==b2){
            this.setVisible(false);
        }
    }
    
    
    
public static void main(String[] args) {
        new AddBook();
              
    }

}

