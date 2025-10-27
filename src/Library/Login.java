package Library;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
    JLabel l1,l2,l4;
    JButton b1;
    JPanel p1,p2,p3;
    Font f1,f2;
    Login(){
        super("Login Page");
        setLocation(500, 350);
        setSize(500, 200);
        //set font
        f1= new Font("Arial",Font.BOLD,25);
        f2= new Font("Arial",Font.BOLD,20);
        //create label
        l1=new JLabel("Library Management");
        l2=new JLabel("Librarian Login");
  
        //create button
        b1=new JButton("Login");
   
        //button action
        b1.addActionListener(this);
       
       //image
       ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Library/icon/lock.png"));
       Image i = img.getImage().getScaledInstance(130, 120,Image.SCALE_DEFAULT);
       ImageIcon img2 = new ImageIcon(i);
       l4= new JLabel(img2);
       l1.setFont(f1);
       l2.setFont(f2);
      
       
       l1.setHorizontalAlignment(JLabel.CENTER);
       l1.setForeground(Color.BLUE);
       //librarian login
        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        b1.setPreferredSize(new Dimension(150, 40)); // width, height
        p1.add(l2);
        p1.add(b1);

     
  
       //image
       p2=new JPanel();
       p2.setLayout(new GridLayout(1,1,10,10));
       p2.add(l4);
       //heading
       p3=new JPanel();
       p3.setLayout(new GridLayout(1,1,10,10));
       p3.add(l1);
       
        setLayout(new BorderLayout(10, 10) );
        add(p3,"North");
        add(p2,"West");
        add(p1,"Center");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    
    }

public static void main(String[] args) {
        new Login();
    }

   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1)
        {
            new Librarian().setVisible(true);
            this.setVisible(false);
        }
    }
}
