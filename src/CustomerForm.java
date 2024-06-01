import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CustomerForm extends JFrame implements ActionListener {
    JButton saveButton, clearButton, backButton, open;
    JComboBox Identification, s;
    JTextField  Name, phone, path, b , adharno;
    String type[]= {"Aadhar Card", "Driving Lience", "College ID Card", "Election Card"};
    String Availibility[]={"Available", "Unavailable"};
    conn m= new conn();
    String q="select * from rooms where Availability='Available'";
    ResultSet RS;
    JLabel dateTime;
    String RoomNumber[]=new String[20];
    {
    try {
        RS = m.s.executeQuery(q);
        int i = 0;
        while (RS.next()){
            String r =RS.getString("propertyNo");
            RoomNumber[i]=r;
            i++;
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }
    CustomerForm(){
        super.setTitle("Employee Details");
        super.setLocation(350,15);
        super.setSize(700,800);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLayout(null);
        JLabel ID = new JLabel("ID :");
        ID.setBounds(100,100,120,40);
        ID.setFont(new Font("railway",Font.PLAIN,20));
        ID.setForeground(Color.black);
        add(ID);
        Identification =new JComboBox(type);
        Identification.setBounds(250,100,300,40);
        add(Identification);
        JLabel phoneNumber = new JLabel("Phone Number :");
        phoneNumber.setBounds(100,160,80,40);
        phoneNumber.setFont(new Font("railway",Font.PLAIN,20));
        phoneNumber.setForeground(Color.black);
        add(phoneNumber);
        phone =new JTextField();
        phone.setBounds(250,160,300,40);
        add(phone);
        JLabel name= new JLabel("Name :");
        name.setBounds(100,220,100,40);
        name.setFont(new Font("railway",Font.PLAIN,20));
        name.setForeground(Color.black);
        add(name);
        Name =new JTextField();
        Name.setBounds(250,220,300,40);
        add(Name);
        JLabel Image = new JLabel("Document :");
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
        JLabel ID_NO= new JLabel("ID NO. :");
        ID_NO.setBounds(100,350,80,30);
        ID_NO.setFont(new Font("railway",Font.PLAIN,20));
        add(ID_NO);
        adharno =new JTextField();
        adharno.setBounds(250,350,300,30);
        add(adharno);
        JLabel roomno = new JLabel("Room No :");
        roomno.setBounds(100,400,80,40);
        roomno.setFont(new Font("railway",Font.PLAIN,20));
        roomno.setForeground(Color.black);
        add(roomno);
        s =new JComboBox(RoomNumber);
        s.setBounds(250,400,300,40);
        add(s);
        Date d= new Date();
        dateTime=new JLabel(String.valueOf(d));
        dateTime.setBounds(100,460,500,30);
        dateTime.setFont(new Font("railway",Font.PLAIN,12));
        add(dateTime);
        JLabel Deposite = new JLabel("Deposite :");
        Deposite.setBounds(100,520,80,40);
        Deposite.setFont(new Font("railway",Font.PLAIN,20));
        Deposite.setForeground(Color.black);
        add(Deposite);
        b =new JTextField();
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
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == open) {
            JFileChooser fc = new JFileChooser("F:\\PRAC\\java\\explore\\Hotel Management System\\src\\images");
            fc.showOpenDialog(null);
            path.setText(fc.getSelectedFile().getAbsolutePath());
        }
        String n = Name.getText();
        String img = path.getText();
        String id = (String) Identification.getSelectedItem();
        String p = phone.getText();
        String Roomn = (String) s.getSelectedItem();
        String D = b.getText();
        String A_no= adharno.getText();
        String DateTime= dateTime.getText();
        if (e.getSource() == backButton) {
            super.setVisible(false);
            new mainPage().setVisible(true);
        } else if (e.getSource() == clearButton) {
            path.setText("");
            phone.setText("");
            Name.setText("");
            Date d= new Date();
            b.setText("");
        } else if (e.getSource() == saveButton) {
            conn c = new conn();
            String q = "insert into customers values('" + id + "','" + n + "','" + p + "','" + Roomn + "','" + D + "','"+DateTime+"','"+img+"','"+A_no+"','"+""+"')";
            String query= "UPDATE rooms SET Availability = 'Unavailable' WHERE propertyNo = '"+Roomn+"';";
            try {
                c.s.executeUpdate(q);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            try {
                c.s.executeUpdate(query);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            new mainPage().setVisible(true);
            super.setVisible(false);
        }
    }
}
