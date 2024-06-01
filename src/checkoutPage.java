import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class checkoutPage extends JFrame implements ActionListener {
    JTextField romno, Id_no;
    JButton backButton, CheckoutButton;
    checkoutPage(){
        super.setLayout(null);
        super.setSize(500,500);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setLocation(300,300);
        JLabel Romno=new JLabel("Room NO. :");
        Romno.setBounds(50,50,100,30);
        Romno.setFont(new Font("railway",Font.PLAIN,16));
        add(Romno);
        romno =new JTextField();
        romno.setBounds(170,50,200,30);
        romno.setFont(new Font("railway",Font.PLAIN,16));
        add(romno);
        JLabel id_no=new JLabel("ID No. :");
        id_no.setBounds(50,100,100,30);
        id_no.setFont(new Font("railway",Font.PLAIN,16));
        add(id_no);
        Id_no =new JTextField();
        Id_no.setBounds(170,100,200,30);
        Id_no.setFont(new Font("railway",Font.PLAIN,16));
        add(Id_no);
        backButton= new JButton("Back");
        backButton.setBounds(150,200,100,30);
        backButton.setFont(new Font("railway",Font.PLAIN,16));
        backButton.addActionListener(this);
        add(backButton);
        CheckoutButton=new JButton("Checkout");
        CheckoutButton.setBounds(300,200,100,30);
        CheckoutButton.setFont(new Font("railway",Font.PLAIN,16));
        CheckoutButton.addActionListener(this);
        add(CheckoutButton);
        super.setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==backButton){
            super.setVisible(false);
        } else if (e.getSource()==CheckoutButton) {
            String RN=romno.getText();
            String ID= Id_no.getText();
            conn c=new conn();
            Date d= new Date();
            String q= "update customers set ChechoutTime='"+d+"' where aadharno='"+ID+"'";
            String Query= "update rooms set room_status='Unclean' where propertyNo="+RN+"";
            try {
                c.s.executeUpdate(Query);
                c.s.executeUpdate(q);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            super.setVisible(false);
        }
    }
}
