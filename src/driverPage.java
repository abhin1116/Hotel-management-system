import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class driverPage extends JFrame implements ActionListener {
    JTextField name, Phone, age, address, aadhar;
    JButton clearButton,saveButton,backButton;
    JRadioButton male , female, other;
    ButtonGroup genderGrp;
    JComboBox  carType;
    String Models[]= {"Auto(3 seater)", "SUV (7 seater)", "Sedan(4 seater)", "Traveler(12 seater)", "Bus(25 seater)", "Car(4seater)", "Truck","Mini truck" , "Camper van(8 seater)"};
    driverPage(){
        super.setTitle("Employee Details");
        super.setLocation(350,15);
        super.setSize(700,800);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLayout(null);
        JLabel User = new JLabel("Name :");
        User.setBounds(100,100,80,40);
        User.setFont(new Font("railway",Font.PLAIN,20));
        User.setForeground(Color.black);
        add(User);
        name =new JTextField();
        name.setBounds(250,100,300,40);
        add(name);
        JLabel Designation = new JLabel("Car Type:");
        Designation.setBounds(100,160,120,40);
        Designation.setFont(new Font("railway",Font.PLAIN,20));
        Designation.setForeground(Color.black);
        add(Designation);
        carType =new JComboBox(Models);
        carType.setBounds(250,160,300,40);
        add(carType);
        JLabel phone_no = new JLabel("Phone no. :");
        phone_no.setBounds(100,220,100,40);
        phone_no.setFont(new Font("railway",Font.PLAIN,20));
        phone_no.setForeground(Color.black);
        add(phone_no);
        Phone =new JTextField();
        Phone.setBounds(250,220,300,40);
        add(Phone);
        JLabel Gender = new JLabel("Gender :");
        Gender.setBounds(100,280,80,40);
        Gender.setFont(new Font("railway",Font.PLAIN,20));
        Gender.setForeground(Color.black);
        add(Gender);
        male = new JRadioButton("Male :");
        male.setBounds(250,280,100,30);
        male.setFont(new Font("railway",Font.PLAIN,16));
        male.setForeground(Color.black);
        add(male);
        female = new JRadioButton("Female :");
        female.setBounds(360,280,100,30);
        female.setFont(new Font("railway",Font.PLAIN,16));
        female.setForeground(Color.black);
        add(female);
        other = new JRadioButton("Other :");
        other.setBounds(470,280,100,30);
        other.setFont(new Font("railway",Font.PLAIN,16));
        other.setForeground(Color.black);
        add(other);
        genderGrp= new ButtonGroup();
        genderGrp.add(male);
        genderGrp.add(female);
        genderGrp.add(other);
//        gender =new JTextField();
//        gender.setBounds(250,280,300,40);
//        add(gender);
        JLabel age1 = new JLabel("Age :");
        age1.setBounds(100,400,80,40);
        age1.setFont(new Font("railway",Font.PLAIN,20));
        age1.setForeground(Color.black);
        add(age1);
        age =new JTextField();
        age.setBounds(250,400,100,40);
        add(age);
        JLabel addr = new JLabel("Address :");
        addr.setBounds(100,460,80,40);
        addr.setFont(new Font("railway",Font.PLAIN,20));
        addr.setForeground(Color.black);
        add(addr);
        address =new JTextField();
        address.setBounds(250,460,300,40);
        add(address);
        JLabel aadhar_no = new JLabel("Aadhar No :");
        aadhar_no.setBounds(100,520,100,40);
        aadhar_no.setFont(new Font("railway",Font.PLAIN,20));
        aadhar_no.setForeground(Color.black);
        add(aadhar_no);
        aadhar =new JTextField();
        aadhar.setBounds(250,520,300,40);
        add(aadhar);
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
        String n= name.getText();
        String D= (String)carType.getSelectedItem();
        String phno= Phone.getText();
        String g = null;
        if(male.isSelected()){
            g= "Male";
        } else if (female.isSelected()) {
            g= "Female";
        } else if (other.isSelected()) {
            g = "Other";
        }
        String a= age.getText();
        String addres=address.getText();
        String a_no= aadhar.getText();
        if(e.getSource()==backButton){
            super.setVisible(false);
        } else if (e.getSource()==clearButton) {
            name.setText("");
            Phone.setText("");
            age.setText("");
            address.setText("");
            aadhar.setText("");
        } else if (e.getSource()==saveButton) {
            conn c=new conn();
            String q = "insert into drivers values('"+n+"','"+D+"','"+phno+"','"+g+"','"+a+"','"+addres+"','"+a_no+"')";
            try {
                c.s.executeUpdate(q);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            super.setVisible(false);
        }

    }
}
