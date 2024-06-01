import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
//import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener {
    JButton backButton;
    Rooms(){
        super.setLayout(null);
        String data[][]=new String[20][6];
        conn s= new conn();
        String q="select * from rooms";
        try {
            ResultSet RS= s.s.executeQuery(q);
//            sp.setModel(DbUtils.resultSetToTableModel(RS));
            int i=0;
            while (RS.next()){
                String roomno =RS.getString("propertyNo");
                String room_type=RS.getString("room_type");
                String Price=RS.getString("price");
                String room_status=RS.getString("room_status");
                String Availability=RS.getString("Availability");
                String bedType=RS.getString("bed_type");
                data [i][0]=roomno;
                data [i][1]=room_type;
                data [i][2]=Price;
                data [i][3]=room_status;
                data [i][4]=Availability;
                data [i][5]=bedType;
                i++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String column[]={"Room No","Room Type","Price","Room Status","Availability","Bed Type"};
        JTable jt=new JTable(data,column);
        jt.setBounds(300,200,1000,6000);
        JScrollPane sp=new JScrollPane(jt);
        sp.setBounds(0,0,1000,600);
        add(sp);
        super.setSize(1000,900);
        super.setVisible(true);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        backButton= new JButton("Back");
        backButton.setBounds(450,700,100,40);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.black);
        backButton.addActionListener(this);
        add(backButton);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==backButton){
            super.setVisible(false);
        }

    }
}
