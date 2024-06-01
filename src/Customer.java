import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer extends JFrame implements ActionListener {
    JButton backButton;
    Customer(){
        super.setLayout(null);
        String data[][]=new String[20][8];
        conn s= new conn();
        String q="select * from customers";
        try {
            ResultSet RS= s.s.executeQuery(q);
//            sp.setModel(DbUtils.resultSetToTableModel(RS));
            int i=0;
            while (RS.next()){
                String IDtype =RS.getString("ID type");
                String name=RS.getString("name");
                String phone=RS.getString("phone_no");
                String roomNo=RS.getString("Room_no");
                String deposite_amt=RS.getString("Deposite_AMT");
                String date_time=RS.getString("Date_Time");
                String chechoutTime=RS.getString("ChechoutTime");
                String aadhar=RS.getString("aadharno");
                data [i][0]=IDtype;
                data [i][1]=name;
                data [i][2]=phone;
                data [i][3]=roomNo;
                data [i][4]=deposite_amt;
                data [i][5]=date_time;
                data [i][6]=chechoutTime;
                data [i][7]=aadhar;
                i++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String column[]={"ID Type","Name","Phone","Room No","Deposite","Checkin Time","CheckOut Time","Aadhar No"};
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
