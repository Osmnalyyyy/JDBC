package jdbc_Calisma_Son;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Osmaninyeri", "postgres", "8520456");
        Statement st = con.createStatement();
        //1.Example: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.

        String sql1 = "CREATE TABLE workers\n" +
                "(\n" +
                "  id CHAR(2),\n" +
                "  name VARCHAR(20),\n" +
                "  title VARCHAR(60),\n" +
                "  manager_id CHAR(2)\n" +
                ")";
        st.execute(sql1);
        //2.Örnek: Table'a worker_address sütunu ekleyerek alter(değiştirme) yapın.
        String sql2 ="alter table workers " +
                "add column worker_address varchar(50)";
        st.execute(sql2);
        //3.Example: Drop workers table
        String sql3="drop table workers";
        st.execute(sql3);
        con.close();
        st.close();

    }

}
