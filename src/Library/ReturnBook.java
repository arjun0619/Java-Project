package Library;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class ReturnBook extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField t1, t2;
    JButton b1, b2;
    JPanel p1, p2;
    Font f1, f2;

    ReturnBook() {
        super("Return Book");
        setLocation(350, 170);
        setSize(800, 370);

        f2 = new Font("Arial", Font.BOLD, 30);
        f1 = new Font("Arial", Font.BOLD, 20);

        
        l1 = new JLabel("Enter Book ID");
        l2 = new JLabel("Enter Student ID");
        l3 = new JLabel("Return Book");
        l1.setFont(f1);
        l2.setFont(f1);
        l3.setFont(f2);

        l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setForeground(Color.BLUE);

     
        b1 = new JButton("Return");
        b2 = new JButton("Cancel");
        b1.setFont(f1);
        b2.setFont(f1);
        b1.addActionListener(this);
        b2.addActionListener(this);

       
        t1 = new JTextField();
        t2 = new JTextField();
        t1.setFont(f1);
        t2.setFont(f1);

        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l3);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(3, 2, 10, 10));
        p2.add(l1);
        p2.add(t1);
        p2.add(l2);
        p2.add(t2);
        p2.add(b1);
        p2.add(b2);

       
        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String bookid = t1.getText();
        String studentid = t2.getText();
        LocalDate currentDate = LocalDate.now();
        String date = currentDate.toString();

        if (e.getSource() == b1) {
            if (bookid.isEmpty() || studentid.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter all details");
                return;
            }

            try {
                ConnectionClass obj = new ConnectionClass();

               
                String checkQuery = "SELECT * FROM issuebook WHERE bookid='" + bookid + "' AND studentid='" + studentid + "'";
                ResultSet rs = obj.stm.executeQuery(checkQuery);

                if (!rs.next()) {
                    JOptionPane.showMessageDialog(null, "No matching issue book found.");
                    return;
                }

                
                String deleteQuery = "DELETE FROM issuebook WHERE bookid='" + bookid + "' AND studentid='" + studentid + "'";
                obj.stm.executeUpdate(deleteQuery);

               
                String updateQuery = "UPDATE addbook SET issuebook = issuebook - 1 WHERE bookno='" + bookid + "'";
                obj.stm.executeUpdate(updateQuery);

                JOptionPane.showMessageDialog(null, "Book returned successfully!");
                this.setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ReturnBook();
    }
}

