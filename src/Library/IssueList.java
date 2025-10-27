package Library;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class IssueList extends JFrame{
    
    String x[]={"Book ID","Book Name","Student ID","Student Name","Student Contact","Issued Date"};
    JButton bt;
    String y[][]=new String[20][6];
    int i=0,j=0;
    JTable t;
    Font f1;
    
    IssueList()
    {
        super("View Books");
        setLocation(0, 100);
        setSize(1600, 675);
        
        f1= new Font("Arial",Font.BOLD,20);
        
        try{
        ConnectionClass obj=new ConnectionClass();
        String q="Select * from issuebook";
        ResultSet rest=obj.stm.executeQuery(q);
        while (rest.next())
        {
       
        y[i][j++]=rest.getString("bookid");
        y[i][j++]=rest.getString("bookname");
        y[i][j++]=rest.getString("studentid");
        y[i][j++]=rest.getString("studentname");
        y[i][j++]=rest.getString("studentcontact");
        y[i][j++]=rest.getString("issue_date");
        i++;
        j=0;
        }
        t=new JTable (y, x);
        t.setFont(f1);
        t.setRowHeight(30);
        t.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));
        }
        
        catch(Exception ex){
            ex.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(t);
        add(sp);
       
        
        setVisible(true);
        
    }
    public static void main(String[] args) {
        new IssueList();
    }
}
