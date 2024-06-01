import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class jobPage extends JFrame implements ActionListener {
    JTextField name, Phone, email, Salary, address, aadhar;
    JButton clearButton,saveButton,backButton;
    JRadioButton male , female, other;
    ButtonGroup genderGrp;
    JComboBox  jobTitle;
    String profile[]= {"House Keeper", "Manager", "Receptionist", "Chief", "Waiter", "Helper", "Watchman"};
    jobPage(){
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
        JLabel Designation = new JLabel("Designation :");
        Designation.setBounds(100,160,120,40);
        Designation.setFont(new Font("railway",Font.PLAIN,20));
        Designation.setForeground(Color.black);
        add(Designation);
        jobTitle =new JComboBox(profile);
        jobTitle.setBounds(250,160,300,40);
        add(jobTitle);
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
        JLabel mail = new JLabel("E-Mail :");
        mail.setBounds(100,340,80,40);
        mail.setFont(new Font("railway",Font.PLAIN,20));
        mail.setForeground(Color.black);
        add(mail);
        email =new JTextField();
        email.setBounds(250,340,300,40);
        add(email);
        JLabel Salary1 = new JLabel("Salary :");
        Salary1.setBounds(100,400,80,40);
        Salary1.setFont(new Font("railway",Font.PLAIN,20));
        Salary1.setForeground(Color.black);
        add(Salary1);
        Salary =new JTextField();
        Salary.setBounds(250,400,100,40);
        add(Salary);
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
        String D= (String)jobTitle.getSelectedItem();
        String phno= Phone.getText();
        String g = null;
        if(male.isSelected()){
            g= "Male";
        } else if (female.isSelected()) {
            g= "Female";
        } else if (other.isSelected()) {
            g = "Other";
        }
        String m= email.getText();
        String a= Salary.getText();
        String addres=address.getText();
        String a_no= aadhar.getText();
        if(e.getSource()==backButton){
            super.setVisible(false);
        } else if (e.getSource()==clearButton) {
            name.setText("");
            Phone.setText("");
            email.setText("");
            Salary.setText("");
            address.setText("");
            aadhar.setText("");
        } else if (e.getSource()==saveButton) {
            conn c=new conn();
            String q = "insert into employee values('"+n+"','"+D+"','"+phno+"','"+g+"','"+m+"','"+a+"','"+addres+"','"+a_no+"')";
            try {
                c.s.executeUpdate(q);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            super.setVisible(false);
        }


    }
}
