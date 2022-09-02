package jdbc;

import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "8520456");
        Statement st = con.createStatement();

        //1. Örnek: Prepared statement kullanarak company adı IBM olan
        // number_of_employees değerini 9999 olarak güncelleyin.
        // 1 . adım prepared statement querry olustur
        String sql1 = "UPDATE companies SET number_of_employees=? WHERE company= ? ";
        // 2. adım PrepareStatement objesini oluştur
        PreparedStatement ps1 = con.prepareStatement(sql1);

        // 3. adım set...() methodları ile soru işaretleri için değer gir
        ps1.setInt(1, 9999);
        ps1.setString(2, "IBM");
        // 4. adım EXEcute query
        int updateRowSayisi = ps1.executeUpdate();
        System.out.println(updateRowSayisi + " satir guncellendi.");
        String sql2 = "select * from companies";
        ResultSet result1 = st.executeQuery(sql2);
        while (result1.next()) {
            System.out.println(result1.getInt(1) + " " + result1.getString(2) + " " + result1.getInt(3));
        }
        //   Google icin değişiklik
        ps1.setInt(1, 15000);
        ps1.setString(2, "GOOGLE");

        int updateRowSayisi1 = ps1.executeUpdate();
        System.out.println(updateRowSayisi1 + " satir guncellendi.");
        String sql3 = "select * from companies";
        ResultSet result2 = st.executeQuery(sql3);
        while (result2.next()) {
            System.out.println(result2.getInt(1) + " " + result2.getString(2) + " " + result2.getInt(3));
        }
        System.out.println();
        //    //2. Örnek: "SELECT * FROM <table name>" query'sini prepared statement ile kullanın.
        read_data(con,"companies" );

        con.close();
        st.close();
    }

    // bir tablonun istenilen datasını prepared satetement ile cagırmak icin kullanılan method
    public static void read_data(Connection con, String tableName) {
        try {
            String query = String.format("SELECT * FROM %s", tableName);// format() methodu dinamik String olusturmak icin kullanılır

            Statement statement = con.createStatement();
            // SQL query yi calistir
            ResultSet result = statement.executeQuery(query);// datayı cagırıp ResultSet konteynırına koyduk

            while (result.next()) {// tum datayı cagiralim
                System.out.println(result.getInt(1) + " " + result.getString(2) + " " + result.getInt(3));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
