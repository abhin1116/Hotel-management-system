import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pickupService extends JFrame implements ActionListener {
    JButton backButton;
    pickupService(){
        super.setLayout(null);
        String data[][]=new String[20][7];
        conn s= new conn();
        String q="select * from drivers";
        try {
            ResultSet RS= s.s.executeQuery(q);
//            sp.setModel(DbUtils.resultSetToTableModel(RS));
            int i=0;
            while (RS.next()){
                String name =RS.getString("name");
                String carType=RS.getString("car type");
                String phone=RS.getString("phone");
                String gender=RS.getString("gender");
                String age=RS.getString("age");
                String address=RS.getString("address");
                String AdharNO= RS.getString("aadhar number");
                data [i][0]=name;
                data [i][1]=carType;
                data [i][2]=phone;
                data [i][3]=gender;
                data [i][4]=age;
                data [i][5]=address;
                data [i][6]=AdharNO;
                i++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String column[]={"Name","Car Type","Phone","Gender","Age","Address","Aadhar No."};
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
