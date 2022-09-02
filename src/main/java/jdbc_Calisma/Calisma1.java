package jdbc_Calisma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Calisma1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "8520456");
        Statement st = con.createStatement();
        String sql = "drop table takimalar";
        st.executeQuery(sql);
        String sql1 = "create table takimalar(takim_name varchar(20),puan int,takim_renk varchar(20))";
     //   st.executeQuery(sql1);
        String sql2 = "alter table takimalar add sehir varchar(15)";
      //  st.executeQuery(sql2);

        con.close();
        st.close();
    }
}
