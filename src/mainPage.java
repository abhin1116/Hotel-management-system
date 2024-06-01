import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainPage extends JFrame implements ActionListener {
    JMenuBar m;
    JMenu m1,m2;
    JMenuItem m11,m21,m22,m23;
        JButton b1, b2, b3, b4, b5, b7, b9, b10, b11, b12, b13;
    mainPage(){
        super.setTitle("Reception");
        super.setSize(1540,830);
        super.setLocation(0,0);
        super.setLayout(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/reception1234.jpg"));
        Image i2=i1.getImage().getScaledInstance(1100,670,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel i = new JLabel(i3);
        i.setBounds(450,80,1100,670);
        add(i);
        m= new JMenuBar();
        m.setBounds(0,0,1540,30);
        add(m);
//        add(m);
        m1= new JMenu("Hotel Management");
        m.add(m1);
        m11= new JMenuItem("Reception");
        m11.addActionListener(this);
        m1.add(m11);
        m2= new JMenu("Admin");
        m.add(m2);
        m21= new JMenuItem("Add Employee");
        m21.addActionListener(this);
        m2.add(m21);
        m22= new JMenuItem("Add Rooms");
        m22.addActionListener(this);
        m2.add(m22);
        m23= new JMenuItem("Add Cab Driver");
        m23.addActionListener(this);
        m2.add(m23);
        JLabel WL= new JLabel("Reception");
        WL.setBounds(200,100,1000,80);
        WL.setFont(new Font("serif",Font.BOLD, 26));
        WL.setForeground(Color.WHITE);
        i.add(WL);
        b1 = new JButton("New Customer Form");
        b1.setBounds(70,80,290,40);
        b1.setBackground(Color.darkGray);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Rooms");
        b2.setBounds(70,130,290,40);
        b2.setBackground(Color.darkGray);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);
        b3 = new JButton("Department");
        b3.setBounds(70,180,290,40);
        b3.setBackground(Color.darkGray);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        add(b3);
        b4 = new JButton("All Employees");
        b4.setBounds(70,230,290,40);
        b4.setBackground(Color.darkGray);
        b4.setForeground(Color.white);
        b4.addActionListener(this);
        add(b4);
        b5 = new JButton("Customer Info");
        b5.setBounds(70,280,290,40);
        b5.setBackground(Color.darkGray);
        b5.setForeground(Color.white);
        b5.addActionListener(this);
        add(b5);
//        b6 = new JButton("Manager Info");
//        b6.setBounds(70,330,290,40);
//        b6.setBackground(Color.darkGray);
//        b6.setForeground(Color.white);
//        b6.addActionListener(this);
//        add(b6);
        b7 = new JButton("Checkout");
        b7.setBounds(70,330,290,40);
        b7.setBackground(Color.darkGray);
        b7.setForeground(Color.white);
        b7.addActionListener(this);
        add(b7);
//        b8 = new JButton("Update Status");
//        b8.setBounds(70,430,290,40);
//        b8.setBackground(Color.darkGray);
//        b8.setForeground(Color.white);
//        b8.addActionListener(this);
//        add(b8);
        b9 = new JButton("Update Room Status");
        b9.setBounds(70,380,290,40);
        b9.setBackground(Color.darkGray);
        b9.setForeground(Color.white);
        b9.addActionListener(this);
        add(b9);
        b10 = new JButton("Pickup Service");
        b10.setBounds(70,430,290,40);
        b10.setBackground(Color.darkGray);
        b10.setForeground(Color.white);
        b10.addActionListener(this);
        add(b10);
        b11 = new JButton("Search Room");
        b11.setBounds(70,480,290,40);
        b11.setBackground(Color.darkGray);
        b11.setForeground(Color.white);
        b11.addActionListener(this);
        add(b11);
        b12 = new JButton("Logout");
        b12.setBounds(70,530,290,40);
        b12.setBackground(Color.darkGray);
        b12.setForeground(Color.white);
        b12.addActionListener(this);
        add(b12);
//        b13 = new JButton("b13");
//        b13.setBounds(70,680,290,40);
//        b13.setBackground(Color.darkGray);
//        b13.setForeground(Color.white);
//        add(b13);
        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            super.setVisible(false);
            new CustomerForm().setVisible(true);
        } else if (e.getSource()==b2) {
            new Rooms().setVisible(true);
        } else if (e.getSource()==b3) {
            new Department().setVisible(true);
        } else if (e.getSource()==b4) {
            new Employees().setVisible(true);
        } else if (e.getSource()==b5) {
            new Customer().setVisible(true);
        } else if (e.getSource()==b7) {
            new checkoutPage().setVisible(true);
        } else if (e.getSource()==b9) {
            new updateRoomStatusPage().setVisible(true);
        } else if (e.getSource()==b10) {
            new pickupService().setVisible(true);
        } else if (e.getSource()==b11) {
            new searchRoomPage().setVisible(true);
        } else if (e.getSource()==b12) {
            System.exit(0);
        }
    }
}
