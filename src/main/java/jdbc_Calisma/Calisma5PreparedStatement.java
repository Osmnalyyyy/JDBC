package jdbc_Calisma;

import java.sql.*;

public class Calisma5PreparedStatement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "8520456");
        Statement st = con.createStatement();
        //1. Örnek: Prepared statement kullanarak company adı IBM olan
        // number_of_employees değerini 9999 olarak güncelleyin.
        String sql1 = "update companies set number_of_employees=? where company=?";
        PreparedStatement prs1 = con.prepareStatement(sql1);
        prs1.setInt(1, 9999);
        prs1.setString(2, "IBM");
        int updateRowNumber = prs1.executeUpdate();
        System.out.println(updateRowNumber + " satir guncellendi");

        String sql2 = "select * from companies";
        ResultSet result2 = st.executeQuery(sql2);
        while (result2.next()) {
            System.out.println(result2.getInt(1) + " " + result2.getString(2) + " " + result2.getInt(3));
        }

        String sql3 = "update companies set company='FACEBOOK' where company='IBM'";
        int updateRowNumber1 = st.executeUpdate(sql3);

        String sql4 = "select * from companies";
        ResultSet result4 = st.executeQuery(sql4);
        while (result4.next()) {
            System.out.println(result4.getInt(1) + " " + result4.getString(2) + " " + result4.getInt(3));
        }
        //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.
        String sql5 = "select * from ?";
        PreparedStatement prs2 = con.prepareStatement(sql5);
        prs2.setString(1, "companies");

        //     ResultSet result5=st.executeQuery(sql5);
        //    while (result5.next()){
        //        System.out.println(result5.getInt(1)+" "+result5.getString(2)+" "+result5.getInt(3));
        //    }

        String sql6 = "update countries set region_id= ? where country_name= ?";
        PreparedStatement prs3 = con.prepareStatement(sql6);
        prs3.setInt(1, 8);
        prs3.setString(2, "Canada");
        int updateSatir = prs3.executeUpdate();
        System.out.println(updateSatir + " row update");

        String sql7 = "select * from countries";
        ResultSet result7 = st.executeQuery(sql7);
        while (result7.next()){
            System.out.println(result7.getString(1)+" "+result7.getString(2)+" "+result7.getInt(3));
        }

        prs3.setInt(1,15);
        prs3.setString(2,"Zambia");
        int updateStair2=prs3.executeUpdate();

        String sql8 = "select * from countries";
        ResultSet result8 = st.executeQuery(sql8);
        while (result8.next()){
            System.out.println(result8.getString(1)+" "+result8.getString(2)+" "+result8.getInt(3));
        }




    }
}
