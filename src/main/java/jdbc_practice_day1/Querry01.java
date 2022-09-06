package jdbc_practice_day1;

import java.sql.*;
import java.sql.DriverManager;

public class Querry01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1 driver yukle
        Class.forName("org.postgresql.Driver");
        //2. baglantı olustur
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "8520456");
        //3. Statement olustur
        Statement st = con.createStatement();


        // 4.ResultSet
        ResultSet veri = st.executeQuery("select * from ogrenciler");
        // 5. Sonuclari al
        while (veri.next()) {
            // 1 index kullanarak
            System.out.println(veri.getInt(1) + " " +
                    veri.getString(2) + " " +
                    veri.getString(3) + " " +
                    veri.getString(4));
            // 2 sutun adi kullanarak
            System.out.println("2. yol");
            System.out.println(veri.getInt("okul_no") + " " +
                    veri.getString("ogrenci_ismi") + " " +
                    veri.getString("sinif") + " " +
                    veri.getString("cinsiyet"));
            System.out.println("*********************************************");
            // 3. printf
            System.out.printf("%-6d %-15.15s %-8s %-8s\n", veri.getInt(1),
                    veri.getString(2),
                    veri.getString(3),
                    veri.getString(4));


        }
        // 6. close
        con.close();
        st.close();
        veri.close();
    }
}
