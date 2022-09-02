package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. adım
        Class.forName("org.postgresql.Driver");
        // 2.adım Database baglan
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "8520456");
        // 3. adım Statement oluştur
        Statement st = con.createStatement();
        // 4. adım Query çalıştır
        //1.Example: "workers" adında bir table oluşturup "worker_id,worker_name, worker_salary" sütunlarını ekleyin.
        String sql1 = "CREATE TABLE workers(worker_id VARCHAR(50),worker_name VARCHAR(50),worker_salary INT) ";
        boolean result = st.execute(sql1);
        //      System.out.println(result);// false return yapar çünkü data çağrılmadı
        //2.Örnek: Table'a worker_address sütunu ekleyerek alter(değiştirme) yapın.
        String sql2 = "ALTER TABLE workers ADD worker_address VARCHAR(80)";
        st.execute(sql2);
        //3.Example: Drop workers table
        String sql3 = "DROP TABLE workers";
       st.execute(sql3);
        // 5. adım bağlantı ve statementi kapat
        con.close();
        st.close();


    }
}
