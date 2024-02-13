package project;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class stmt {

    static Connection con = null;
    static Statement stmt = null;
    static String url = "jdbc:mysql://localhost:3306/madang?serverTimezone=Asia/Seoul";
    static String user = "root";
    static String passwd = "1234";
    static String tableName = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, passwd);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Connection 초기화 실패: " + e.toString());
            e.printStackTrace();
        }
    }

    static void execute(String query) {
        try {
            stmt.execute(query);
        } catch (Exception e) {
            System.out.println("쿼리 실행 실패: " + e.toString());
            e.printStackTrace();
        }
    }
}
