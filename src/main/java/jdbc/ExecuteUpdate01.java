package jdbc;

import java.sql.*;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "8520456");
        Statement st = con.createStatement();
        //1. Örnek: number_of_employees değeri ortalama çalışan sayısından az olan
        // number_of_employees değerlerini 17000 olarak UPDATE edin.
        String sql3 = "update companies\n" +
                "set number_of_employees=16000\n" +
                "where number_of_employees<(select avg(number_of_employees) from companies)";
        int updateSatirSayisi = st.executeUpdate(sql3);// update edilen satır sayırsını verir
        System.out.println("updateSatirSayisi = " + updateSatirSayisi);

        String sql2 = "select * from companies";
        ResultSet result1 = st.executeQuery(sql2);

        while (result1.next()){
            System.out.println(result1.getInt(1)+" "+result1.getString(2)+" "+result1.getInt(3));
        }

        con.close();
        st.close();
    }
}
