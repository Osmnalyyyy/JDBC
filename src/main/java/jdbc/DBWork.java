package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBWork {
    // PostgreSql baglantisi methodu
    public Connection connect_to_db(String dbName, String user, String password) {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, user, password);
            if (con != null) {
                System.out.println("Baglanti saglandi");
            } else System.out.println("Baglanti saglamadi");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }


    // yeni tabel olusturma methodu

    public void createTable(Connection con, String tableName) {
        // Statement objesi oluştur.
        Statement statement;
        try {
            String query = "create table " + tableName + "(employee_id serial ,name varchar(20),email varchar(20),salary INTEGER,primary key(employee_id))";
            statement = con.createStatement();

            statement.executeUpdate(query);
            System.out.println("table created");
        } catch (Exception e) {
            System.out.println("table can't created or already exist ");
        }


    }


}
