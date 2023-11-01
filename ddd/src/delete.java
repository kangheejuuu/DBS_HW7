import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class delete {
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
         // DELETE 문을 사용하여 도서 삭제
            String deleteQuery = "DELETE FROM Book WHERE bookid=23";
            stmt.executeUpdate(deleteQuery);

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

