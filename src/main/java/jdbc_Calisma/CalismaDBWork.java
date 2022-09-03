package jdbc_Calisma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CalismaDBWork {
    public Connection connetc_to_db(String dbName, String user, String password) {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName + user + password);
            if (con != null) {
                System.out.println("baglanti saglandi");
            } else System.out.println("baglanti saglanamadi");
        } catch (Exception e) {
            System.out.println(e + " hatasi var kardes");
        }

        return con;
    }

    // yeni table olusturma methodu
    public void createTableMethod(Connection con, String tableName) {

        Statement st;

        try {
            String sql = "create table " + tableName + " employee_id serial,name varchar(20),salary int,age int primary key(employee_id)";
            st = con.createStatement();
            st.executeQuery(sql);
            System.out.println("table created");

        } catch (Exception e) {
            System.out.println("table already exist or table can't created");
        }

    }


}
