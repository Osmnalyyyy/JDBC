package jdbc_Calisma;

import java.sql.*;

public class Calisma3ExecuteQuerry {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "8520456");
        Statement st = con.createStatement();
        //1. Örnek: companies tablosundan en yüksek ikinci number_of_employees değeri
        // olan company ve number_of_employees değerlerini çağırın.
        String sql1 = "select company,number_of_employees\n" +
                "from companies\n" +
                "order by number_of_employees desc limit 1 offset 1";
        ResultSet result1 = st.executeQuery(sql1); // select yapıyorsak executeQuery diyoruz
        while (result1.next()) {
            System.out.println(result1.getString(1) + " " + result1.getInt(2));
        }
        String sql2 = "select company from companies where company_id=103";
        ResultSet result2 = st.executeQuery(sql2);
        while (result2.next()) {
            System.out.println(result2.getString(1));
        }
        String sql3 = "select sum(number_of_employees) from companies";
        ResultSet resul3 = st.executeQuery(sql3);
        while (resul3.next()) {
            System.out.println(resul3.getInt(1));
        }

        String sql4="select * from countries where country_name  ~* '(^[a-k](.*))'";
        ResultSet rseul4=st.executeQuery(sql4);
        while (rseul4.next()){
            System.out.printf("\n%-3s  %-10s  %-2d",rseul4.getString(1),rseul4.getString(2),rseul4.getInt(3));
        }

        con.close();
        st.close();

    }
}
