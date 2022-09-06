package jdbc_practice_day1;

import java.sql.*;

public class Querry02 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "8520456");
        Statement st = con.createStatement();

        // Soru: ogrenciler tablosundaki erkek ogrencileri listeleyiniz
        ResultSet result = st.executeQuery("select * from ogrenciler where cinsiyet='E'");
        while (result.next()) {
            System.out.println(result.getInt(1) + " " +
                    result.getString(2) + " " +
                    result.getString(3) + " " +
                    result.getString(4));
        }
        con.close();
        st.close();
        result.close();

    }
}
