import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Department extends JFrame implements ActionListener {
    JButton backButton;
    Department(){
        super.setLayout(null);
        String data[][]=new String[20][6];
        conn s= new conn();
        String q="select * from department";
        try {
            ResultSet RS= s.s.executeQuery(q);
//            sp.setModel(DbUtils.resultSetToTableModel(RS));
            int i=0;
            while (RS.next()){
                String D =RS.getString("dapartment");
                String B =RS.getString("budget");
                data [i][0]=D;
                data [i][1]=B;
                i++;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String column[]={"Departments","Budget"};
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
