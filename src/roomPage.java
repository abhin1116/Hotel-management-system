import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class roomPage extends JFrame implements ActionListener {
    JTextField Rs, path, romno;
    JButton clearButton,saveButton,backButton,open;
    JComboBox  roomType, s, aval, b;
    String type[]= {"2BHK", "5BHK", "Single room", "VIP room", "VIP bungalow", "Program Hall"};
    String Availibility[]={"Available", "Unavailable"};
    String Status[]={"Clean","Unclean"};
    String bedType[] = {"NA","Queen size","King size","Single bed", "2 Single bed"};
//    String price;
    String filename;
    roomPage(){
        super.setTitle("Employee Details");
        super.setLocation(350,15);
        super.setSize(700,800);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLayout(null);
        JLabel roomno = new JLabel("Room No :");
        roomno.setBounds(100,100,80,40);
        roomno.setFont(new Font("railway",Font.PLAIN,20));
        roomno.setForeground(Color.black);
        add(roomno);
        romno =new JTextField();
        romno.setBounds(250,100,300,40);
        add(romno);
        JLabel Designation = new JLabel("Room Type:");
        Designation.setBounds(100,160,120,40);
        Designation.setFont(new Font("railway",Font.PLAIN,20));
        Designation.setForeground(Color.black);
        add(Designation);
        roomType =new JComboBox(type);
        roomType.setBounds(250,160,300,40);
        add(roomType);
        JLabel Price = new JLabel("Price :");
        Price.setBounds(100,220,100,40);
        Price.setFont(new Font("railway",Font.PLAIN,20));
        Price.setForeground(Color.black);
        add(Price);
        Rs =new JTextField();
        Rs.setBounds(250,220,300,40);
        add(Rs);
        JLabel Image = new JLabel("Image :");
        Image.setBounds(100,300,100,40);
        Image.setFont(new Font("railway",Font.PLAIN,20));
        Image.setForeground(Color.black);
        add(Image);
        path = new JTextField();
        path.setBounds(250,310,200,30);
        path.setFont(new Font("italic",Font.PLAIN,12));
        path.setBackground(Color.lightGray);
        path.setForeground(Color.black);
        add(path);
        open= new JButton("Open");
        open.setBounds(460,300,90,40);
        open.setBackground(Color.DARK_GRAY);
        open.setForeground(Color.WHITE);
        open.addActionListener(this);
        add(open);
//        Rs =new JTextField();
//        Rs.setBounds(250,220,300,40);
//        add(Rs);
//        gender =new JTextField();
//        gender.setBounds(250,280,300,40);
//        add(gender);
        JLabel status = new JLabel("Status :");
        status.setBounds(100,400,80,40);
        status.setFont(new Font("railway",Font.PLAIN,20));
        status.setForeground(Color.black);
        add(status);
        s =new JComboBox(Status);
        s.setBounds(250,400,300,40);
        add(s);
        JLabel availbality = new JLabel("Availbility :");
        availbality.setBounds(100,460,80,40);
        availbality.setFont(new Font("railway",Font.PLAIN,20));
        availbality.setForeground(Color.black);
        add(availbality);
        aval =new JComboBox(Availibility);
        aval.setBounds(250,460,300,40);
        add(aval);
        JLabel bedT = new JLabel("Bed Type :");
        bedT.setBounds(100,520,80,40);
        bedT.setFont(new Font("railway",Font.PLAIN,20));
        bedT.setForeground(Color.black);
        add(bedT);
        b =new JComboBox(bedType);
        b.setBounds(250,520,300,40);
        add(b);
        saveButton= new JButton("Save");
        saveButton.setBounds(300,600,80,30);
        saveButton.setFont(new Font("arial",Font.BOLD,16));
        saveButton.setBackground(Color.LIGHT_GRAY);
        saveButton.setForeground(Color.BLACK);
        saveButton.addActionListener(this);
        add(saveButton);
        clearButton= new JButton("Clear");
        clearButton.setBounds(100,600,80,30);
        clearButton.setFont(new Font("arial",Font.BOLD,16));
        clearButton.setBackground(Color.LIGHT_GRAY);
        clearButton.setForeground(Color.BLACK);
        clearButton.addActionListener(this);
        add(clearButton);
        backButton= new JButton("Back");
        backButton.setBounds(500,600,80,30);
        backButton.setFont(new Font("arial",Font.BOLD,16));
        backButton.setBackground(Color.LIGHT_GRAY);
        backButton.setForeground(Color.BLACK);
        backButton.addActionListener(this);
        add(backButton);
        super.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == open) {
            JFileChooser fc = new JFileChooser("F:\\PRAC\\java\\explore\\Hotel Management System\\src\\images\\2bhk.jpg");
            fc.showOpenDialog(null);
            path.setText(fc.getSelectedFile().getAbsolutePath());
        }
        String r = romno.getText();
        String img = path.getText();
        String room = (String) roomType.getSelectedItem();
        String p = Rs.getText();
        String satutsType = (String) s.getSelectedItem();
        String AvalibilityType = (String) aval.getSelectedItem();
        String BedType = (String) b.getSelectedItem();
        if (e.getSource() == backButton) {
            super.setVisible(false);
        } else if (e.getSource() == clearButton) {
            path.setText("");
            Rs.setText("");
        } else if (e.getSource() == saveButton) {
            conn c = new conn();
            String q = "insert into rooms values('" + img + "','" + room + "','" + p + "','" + satutsType + "','" + AvalibilityType + "','" + BedType + "','"+r+"')";
            try {
                c.s.executeUpdate(q);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            super.setVisible(false);
        }
    }
}
