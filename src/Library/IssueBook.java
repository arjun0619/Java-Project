package Library;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class IssueBook extends JFrame implements ActionListener {
    
    JLabel l2,l3,l4,l5,l6,l8;
    JButton b1,b2;
    JPanel p1,p2;
    JTextField t1,t2,t3,t4,t5;
    Font f1,f2;

         

    IssueBook()
    {
        super("Issue book");
        setLocation(380, 120);
        setSize(800, 500);
        
        f1= new Font("Arial",Font.BOLD,20);
        f2= new Font("Arial",Font.BOLD,30);
        
 
        l2=new JLabel("Book ID");
        l3=new JLabel("Book Name");
        l4=new JLabel("Student ID");
        l5=new JLabel("Student name");
        l6=new JLabel("Student Phone Number");
        l8=new JLabel("Issue Book");
        
 
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l6.setFont(f1);
        l5.setFont(f1);              
        l8.setFont(f2);     
        
        l8.setHorizontalAlignment(JLabel.CENTER);
        l8.setForeground(Color.BLUE);
        
        b1=new JButton("Issue");
        b2=new JButton("Cancel");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b1.setFont(f1);
        b2.setFont(f1);
        
        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
      
        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t5.setFont(f1);
    
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l8);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(6,2,10,10));
        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(t2);
        p2.add(l4);
        p2.add(t3);
        p2.add(l5);
        p2.add(t4);
        p2.add(l6);
        p2.add(t5);
        p2.add(b1);
        p2.add(b2);
        
        setLayout(new BorderLayout(10, 10) );
        add(p1,"North");
        add(p2);
        
       setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent e)
    {
        String bookid = t1.getText();
        String bookname = t2.getText();
        String studentid = t3.getText();
        String studentname = t4.getText();
        String studentcontact = t5.getText();
        LocalDate currentDate = LocalDate.now();
        String date = currentDate.toString();
        
        if (e.getSource()==b1)
        {
         try
        {
        ConnectionClass obj = new ConnectionClass();
        
        String checkQuery = "SELECT * FROM addbook WHERE bookno = '" + bookid + "'";
        ResultSet rs = obj.stm.executeQuery(checkQuery);
         if (!rs.next()) {
            JOptionPane.showMessageDialog(null, "This Book ID or Book Name does not exist in the library.");
            return;
        }
         
         int totalQuantity = rs.getInt("quantity");
         int issuedBooks = rs.getInt("issuebook");

            if (issuedBooks >= totalQuantity) {
                JOptionPane.showMessageDialog(null, "No copies available for issuing");
                return;
            }

        String q = "insert into issuebook( bookid, bookname,studentid,studentname,studentcontact,issue_date) values('" 
                   + bookid + "','" + bookname+ "','" + studentid + "','" + studentname + "','" + studentcontact +"','" + date+"')";
        int a = obj.stm.executeUpdate(q);
        
        
        if(a == 1)
        {
            String updateQuery = "UPDATE addbook SET issuebook = issuebook + 1 WHERE bookno = '" + bookid + "'";
            obj.stm.executeUpdate(updateQuery);
            
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
        new IssueBook();
    }
}
