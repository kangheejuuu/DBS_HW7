import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class select2 {
    public static void main(String args[]) 
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:4567/madang",
                    "heejukang", "rkdgmlwn");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Imported_Book");

            while (rs.next()) 
                System.out.println(rs.getString(1) + " " + rs.getString(2) +
                        " " + rs.getString(3));  
            con.close();
        } catch (Exception e) {System.out.println(e);}
    }
}
