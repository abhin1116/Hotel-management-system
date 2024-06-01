import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;
    public conn(){
        try {
//            class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///hotel_management_system","root","admin");
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);

        }
    }
}
