import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class insert {
    public static void main(String args[]) 
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.56.101:4567/madang",
                    "heejukang", "rkdgmlwn");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Book");

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) +
                        " " + rs.getString(3));  
        }
         // INSERT 문을 사용하여 새로운 도서 삽입
            String insertQuery = "INSERT INTO Book VALUES (23, '데이터베이스시스템', '한빛미디어', 70000)";
            stmt.executeUpdate(insertQuery);

            // 다시 데이터 출력
            rs = stmt.executeQuery("SELECT * FROM Book");
            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) +
                        " " + rs.getString(3));
            }
            con.close();
        } catch (Exception e) {System.out.println(e);}
    }
}

