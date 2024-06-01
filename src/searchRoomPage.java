import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class searchRoomPage extends JFrame implements ActionListener {
    JComboBox BedType;
    JCheckBox Available;
    JTable jt;
    JButton backButton, submitButton;
    String bedType[] = {"NA", "Queen size", "King size", "Single bed", "2 Single bed"};
    String column[] = {"Room No", "Room Type", "Price", "Room Status", "Availability", "Bed Type"};
    String data[][] = new String[20][6];

    searchRoomPage() {
        super.setLayout(null);
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setSize(900, 800);
        super.setLocation(300, 200);
        JLabel heading = new JLabel("Search for the room");
        heading.setBounds(400, 15, 350, 40);
        heading.setFont(new Font("serif", Font.BOLD, 32));
        add(heading);
        JLabel bedT = new JLabel("Bed Type");
        bedT.setBounds(150, 70, 80, 30);
        bedT.setFont(new Font("railway", Font.PLAIN, 16));
        add(bedT);
        BedType = new JComboBox(bedType);
        BedType.setBounds(250, 70, 200, 30);
        BedType.setFont(new Font("railway", Font.PLAIN, 16));
        add(BedType);
        Available = new JCheckBox("Show Available Rooms Only");
        Available.setBounds(600, 70, 150, 30);
        Available.setFont(new Font("railway", Font.PLAIN, 16));
        add(Available);

        conn c = new conn();
        String Q = "select * from rooms";
        ResultSet RS = null;
        try {
            RS = c.s.executeQuery(Q);
            int i = 0;
            while (RS.next()) {
                String roomno = RS.getString("propertyNo");
                String room_type = RS.getString("room_type");
                String Price = RS.getString("price");
                String room_status = RS.getString("room_status");
                String Availability = RS.getString("Availability");
                String bedType = RS.getString("bed_type");
                data[i][0] = roomno;
                data[i][1] = room_type;
                data[i][2] = Price;
                data[i][3] = room_status;
                data[i][4] = Availability;
                data[i][5] = bedType;
                i++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        jt = new JTable();
        DefaultTableModel model = new DefaultTableModel(data, column);
        jt.setModel(model);
        jt.setBounds(50, 150, 800, 500);
        JScrollPane sp = new JScrollPane(jt);
        sp.setBounds(50, 150, 800, 500);
        add(sp);
        submitButton = new JButton("Submit");
        submitButton.setBounds(250, 700, 100, 40);
        submitButton.setBackground(Color.LIGHT_GRAY);
        submitButton.setForeground(Color.black);
        submitButton.addActionListener(this);
        add(submitButton);
        backButton = new JButton("Back");
        backButton.setBounds(600, 700, 100, 40);
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.black);
        backButton.addActionListener(this);
        add(backButton);

        super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            super.setVisible(false);
        } else if (e.getSource() == submitButton) {
            // Assuming 'table' is your JTable instance
            DefaultTableModel dm= (DefaultTableModel) jt.getModel();
            int m=dm.getRowCount();
            int n=dm.getColumnCount();
            for(int i=0;m>i;i++){
                for(int j=0;n>j;j++){
                    dm.setValueAt("",i,j);
                }
            }
            String BT = (String) BedType.getSelectedItem();
            ResultSet RS;
            conn c = new conn();
            String q1 = "select * from rooms where bed_type='" + BT + "'";
            String q2 = "select * from rooms where Availability='Available' and bed_type='" + BT + "'";
            if (Available.isSelected()) {
                try {
                    RS = c.s.executeQuery(q2);
                    int i = 0;
                    while (RS.next()) {
                        String roomno = RS.getString("propertyNo");
                        String room_type = RS.getString("room_type");
                        String Price = RS.getString("price");
                        String room_status = RS.getString("room_status");
                        String Availability = RS.getString("Availability");
                        String bedType = RS.getString("bed_type");
                        jt.getModel().setValueAt(roomno, i, 0);
//                        System.out.println(data[i][0] = roomno);
                        jt.getModel().setValueAt(room_type, i, 1);
//                        System.out.println(data[i][1] = room_type);
                        jt.getModel().setValueAt(Price, i, 2);
//                        System.out.println(data[i][2] = Price);
                        jt.getModel().setValueAt(room_status, i, 3);
//                        System.out.println(data[i][3] = room_status);
                        jt.getModel().setValueAt(Availability, i, 4);
//                        System.out.println(data[i][4] = Availability);
                        jt.getModel().setValueAt(bedType, i, 5);
//                        System.out.println(data[i][5] = bedType);
                        i++;
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                try {
                    RS = c.s.executeQuery(q1);
                    int i = 0;
                    while (RS.next()) {
                        String roomno = RS.getString("propertyNo");
                        String room_type = RS.getString("room_type");
                        String Price = RS.getString("price");
                        String room_status = RS.getString("room_status");
                        String Availability = RS.getString("Availability");
                        String bedType = RS.getString("bed_type");
                        jt.getModel().setValueAt(roomno, i, 0);
//                        System.out.println(data[i][0] = roomno);
                        jt.getModel().setValueAt(room_type, i, 1);
//                        System.out.println(data[i][1] = room_type);
                        jt.getModel().setValueAt(Price, i, 2);
//                        System.out.println(data[i][2] = Price);
                        jt.getModel().setValueAt(room_status, i, 3);
//                        System.out.println(data[i][3] = room_status);
                        jt.getModel().setValueAt(Availability, i, 4);
//                        System.out.println(data[i][4] = Availability);
                        jt.getModel().setValueAt(bedType, i, 5);
//                        System.out.println(data[i][5] = bedType);
                        i++;
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

}

