package jdbc_Calisma;

import java.sql.*;

public class Calisma4Update {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "8520456");
        Statement st = con.createStatement();
        String sql1 = "update companies\n" +
                "set number_of_employees=18000\n" +
                "where number_of_employees<(select avg(number_of_employees) from companies)";
        int updateSatirSayisi1 = st.executeUpdate(sql1);
        System.out.println("updateSatirSayisi1 = " + updateSatirSayisi1);

        String sql2 = "select * from companies";
        ResultSet result1 = st.executeQuery(sql2);
        while (result1.next()) {
            System.out.println(result1.getInt(1) + " " + result1.getString(2) + " " + result1.getInt(3));
        }
        String sql3 = "update companies set company='YOUTUBE' where company_id=101 ";
        int updateStairSayisi1 = st.executeUpdate(sql3);

        ResultSet result3 = st.executeQuery(sql3);
        while (result3.next()) {
            System.out.println(result3.getInt(1) + " " + result3.getString(2) + " " + result3.getInt(3));
        }

        String sql4 = "select * from companies order by company_id";
        ResultSet result4 = st.executeQuery(sql4);
        while (result4.next()) {
            System.out.println(result4.getInt(1) + " " + result4.getString(2) + " " + result4.getInt(3));
        }
        con.close();
        st.close();
    }
}
