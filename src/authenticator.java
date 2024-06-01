import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class authenticator extends JFrame implements ActionListener {
    JButton NPage;
    JTextField UName;
    JPasswordField UPass;
    authenticator(){
        super.setTitle("Verify Yourself");
        super.setSize(500,500);
        super.setLocation(500,300);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel User = new JLabel("Name");
        User.setBounds(100,100,80,40);
        User.setFont(new Font("railway",Font.PLAIN,20));
        User.setForeground(Color.black);
        add(User);
        UName =new JTextField();
        UName.setBounds(250,100,100,40);
        add(UName);
        UPass =new JPasswordField();
        UPass.setBounds(250,160,100,40);
        add(UPass);
        JLabel Pass = new JLabel("Password");
        Pass.setBounds(100,160,120,40);
        Pass.setFont(new Font("railway",Font.PLAIN,20));
        Pass.setForeground(Color.black);
        add(Pass);
        NPage= new JButton("Next");
        NPage.setBounds(200,280,100,30);
        NPage.setFont(new Font("arial",Font.BOLD,16));
        NPage.setBackground(Color.LIGHT_GRAY);
        NPage.setForeground(Color.BLACK);
        NPage.addActionListener(this);
        add(NPage);

        super.setLayout(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()== NPage){
            String n= UName.getText();
            String p= UPass.getText();
            conn c = new conn();
            String q = "select * from auth where name= '"+n+"' and pass= '"+p+"'; ";

            try {
                ResultSet RS= c.s.executeQuery(q);
                if(RS.next()){
                    super.setVisible(false);
                    new dashboard().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Invail Details");
                    UName.setText("");
                    UPass.setText("");
                }
            }catch (Exception ex){
                System.out.println(ex);
            }
            super.setVisible(false);
//            new homescreen().setVisible(true);
        }
    }
}
