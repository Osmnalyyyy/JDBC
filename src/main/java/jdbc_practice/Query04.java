package jdbc_practice;

import java.sql.*;

public class Query04 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "8520456");
        //Statement st = con.createStatement();
        PreparedStatement ps = con.prepareStatement("insert into ogrenciler values(?,?,?,?)");
        ps.setInt(1, 200);
        ps.setString(2, "Osman ali");
        ps.setString(3, "12");
        ps.setString(4, "E");

        ps.executeUpdate();

        System.out.println("veri girisi yapildi.");

        con.close();
        ps.close();

    }
}
