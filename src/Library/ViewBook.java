package Library;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class ViewBook extends JFrame{
    
    String x[]={"Book ID","Book Name","Author","Quantity","Issued Books","Date"};
    JButton bt;
    String y[][]=new String[20][6];
    int i=0,j=0;
    JTable t;
    Font f1,f2;
    
    ViewBook()
    {
        super("View Books");
        setLocation(0, 100);
        setSize(1600, 675);
        
        f1= new Font("Arial",Font.BOLD,20);
        
        try{
        ConnectionClass obj=new ConnectionClass();
        String q="Select * from addbook";
        ResultSet rest=obj.stm.executeQuery(q);
        while (rest.next())
        {
        
        y[i][j++]=rest.getString("bookno");
        y[i][j++]=rest.getString("bookname");
        y[i][j++]=rest.getString("author");
        y[i][j++]=rest.getString("quantity");
        y[i][j++]=rest.getString("issuebook");
        y[i][j++]=rest.getString("date");
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
        new ViewBook();
    }
}
