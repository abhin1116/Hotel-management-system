import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employees extends JFrame implements ActionListener {
    JButton backButton;
    Employees(){
        super.setLayout(null);
        String data[][]=new String[20][8];
        conn s= new conn();
        String q="select * from employee";
        try {
            ResultSet RS= s.s.executeQuery(q);
//            sp.setModel(DbUtils.resultSetToTableModel(RS));
            int i=0;
            while (RS.next()){
                String name =RS.getString("name");
                String designation=RS.getString("designation");
                String phone=RS.getString("phone");
                String gender=RS.getString("gender");
                String mail=RS.getString("mail");
                String salary=RS.getString("salary");
                String address=RS.getString("address");
                String aadhar=RS.getString("aadhar");
                data [i][0]=name;
                data [i][1]=designation;
                data [i][2]=phone;
                data [i][3]=gender;
                data [i][4]=mail;
                data [i][5]=salary;
                data [i][6]=address;
                data [i][7]=aadhar;
                i++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String column[]={"Name","Designation","Phone","Gender","Mail","Salary","address","aadhar"};
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
