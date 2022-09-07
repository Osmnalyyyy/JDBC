package jdbc_practice;

import java.sql.*;

public class Querry03 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "8520456");
        // Statement st = con.createStatement();
        PreparedStatement ps = con.prepareStatement("select * from ogrenciler ogrenciler");
        //PreparedStatement--->>>>> statemente gore daha dinamiktir ve hafızada daha az yer kaplar , daha güvenli
        ResultSet rs = ps.executeQuery();

        ResultSetMetaData rsmd = rs.getMetaData();// DB e fazla yuk binmez farklı veriler de alınabilir
        System.out.println("Sutun sayisi" + rsmd.getColumnCount());
        System.out.println("1. sutunun ismi : " + rsmd.getColumnName(1));
        System.out.println("2. sutunun ismi : " + rsmd.getColumnName(2));
        System.out.println("3. sutunun ismi : " + rsmd.getColumnName(3));
        System.out.println("4. sutunun ismi : " + rsmd.getColumnName(4));
        System.out.println("1. sutunun data tipi : " + rsmd.getColumnTypeName(1));
        System.out.println("2. sutunun data tipi : " + rsmd.getColumnTypeName(2));
        System.out.println("3. sutunun data tipi : " + rsmd.getColumnTypeName(3));
        System.out.println("4. sutunun data tipi : " + rsmd.getColumnTypeName(4));

        System.out.println("Tablo ismi : "+rsmd.getTableName(4));


        con.close();
        ps.close();


    }
}
