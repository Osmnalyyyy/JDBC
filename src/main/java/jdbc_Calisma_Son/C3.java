package jdbc_Calisma_Son;

import java.sql.*;

public class C3 {
    public static void main(String[] args) throws SQLException {
        Statement st;
        try {
            Class.forName("org.postgresql.Driver");
            Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro","postgres","8520456");
             st=con.createStatement();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //1. Örnek: companies tablosundan en yüksek
        // ikinci number_of_employees değeri
        // olan company ve number_of_employees değerlerini çağırın.
        String sql1="select company,number_of_employees from companies order by number_of_employees desc limit 1 offset 1";
        ResultSet result1= st.executeQuery(sql1);
        while (result1.next()){
            System.out.println(result1.getString(1)+" "+result1.getInt(2));
        }
    }
}
