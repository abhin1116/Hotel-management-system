import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboard extends JFrame implements ActionListener {
    JMenu m1,m2;
    JMenuItem m11, m21,m22,m23;
    JMenuBar m;
    dashboard(){
        super.setTitle("Dashboard");
        super.setSize(1540,830);
        super.setLocation(0,0);
        super.setLayout(null);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1540,830,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel i = new JLabel(i3);
        i.setBounds(0,0,1540,830);
        add(i);
        m= new JMenuBar();
        m.setBounds(0,0,1540,30);
        i.add(m);
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
        JLabel WL= new JLabel("Nisarga and Abhishek welcomes you in Abhishri Hotel");
        WL.setBounds(200,100,1000,80);
        WL.setFont(new Font("serif",Font.BOLD, 36));
        i.add(WL);
        super.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Reception")){
            super.setVisible(false);
            new mainPage();
        } else if (e.getActionCommand().equals("Add Employee")) {
//            super.setVisible(false);
            new jobPage().setVisible(true);
        }else if (e.getActionCommand().equals("Add Rooms")) {
//            super.setVisible(false);
            new roomPage().setVisible(true);
        }else if (e.getActionCommand().equals("Add Cab Driver")) {
//            super.setVisible(false);
            new driverPage();
        }
    }
}
