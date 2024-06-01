import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frontpage extends JFrame implements ActionListener {
    JButton CPage, NPage;
    frontpage(){
//        super.setTitle("Frontpage");
        super.setUndecorated(true);
        super.setSize(1024,364);
        super.setLocation(200,200);
//                super.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        super.setLayout(null);

//        Adding image to the frame...
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/img_1.png"));
//        Image i2=i1.getImage().getScaledInstance(1200,400,Image.SCALE_DEFAULT);
//        ImageIcon i3= new ImageIcon(i2);
        JLabel i = new JLabel(i1);
//        i.setBounds(0,0,1200,400);
        add(i);
        JLabel hotelName= new JLabel("Abhishri Group's Hotels");
        hotelName.setBounds(550,30,500,40);
        hotelName.setFont(new Font("serif",Font.PLAIN,36));
        hotelName.setForeground(Color.white);
        i.add(hotelName);
        NPage = new JButton("Next");
        NPage.setBounds(900,290,80,30);
        NPage.setFont(new Font("arial",Font.BOLD,16));
        NPage.setBackground(Color.LIGHT_GRAY);
        NPage.setForeground(Color.BLACK);
        NPage.addActionListener(this);
        i.add(NPage);
        CPage= new JButton("Exit");
        CPage.setBounds(90,290,60,30);
        CPage.setBackground(Color.red);
        CPage.setForeground(Color.PINK);
        CPage.addActionListener(this);
        i.add(CPage);

        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == CPage){
            System.exit(0);
        } else if (e.getSource()== NPage) {
            super.setVisible(false);
            new authenticator().setVisible(true);
        }
    }
}
