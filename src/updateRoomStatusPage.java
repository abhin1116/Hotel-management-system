import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class updateRoomStatusPage extends JFrame implements ActionListener {
    JButton update;
    JTextField romnoinput;
    updateRoomStatusPage(){
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setLayout(null);
        super.setSize(1000,900);
        super.setLocation(450,200);
        conn c = new conn();
        String q = "select * from rooms where room_status='Unclean' and Availability='Unavailable'";
        String data[][]=new String[20][5];
        try {
            ResultSet Rs=c.s.executeQuery(q);
            int i=0;
            while(Rs.next()){
                String room_no= Rs.getString("propertyNo");
                String room_type= Rs.getString("room_type");
                String status =Rs.getString("room_status");
                String Availability = Rs.getString("Availability");
                data [i][0]=room_no;
                data [i][1]=room_type;
                data [i][2]=status;
                data [i][3]=Availability;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String column[]={"Room No.","Room Type","Status","Availability"};
        JTable jt=new JTable(data,column);
        jt.setBounds(300,200,900,600);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(50,0,900,300);
        add(sp);
        JLabel romno=new JLabel("Room No. :");
        romno.setBounds(300,350,100,30);
        romno.setFont(new Font("railway",Font.PLAIN,16));
        add(romno);
        romnoinput= new JTextField();
        romnoinput.setBounds(450,350,200,30);
        romnoinput.setFont(new Font("railway",Font.PLAIN,14));
        add(romnoinput);
        update=new JButton("Status Update");
        update.setBounds(400,400,200,30);
        update.setFont(new Font("railway",Font.PLAIN,14));
        update.addActionListener(this);
        add(update);
        super.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==update){
            String RN= romnoinput.getText();
            conn c=new conn();
            String Q= "update rooms set room_status='Clean', Availability='Available' where propertyNo="+RN+"";
            try {
                c.s.executeUpdate(Q);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);

            }
            super.setVisible(false);
            new updateRoomStatusPage().setVisible(true);
        }
    }
}
