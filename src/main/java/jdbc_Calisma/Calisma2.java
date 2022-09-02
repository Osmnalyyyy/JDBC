package jdbc_Calisma;

import java.sql.*;

public class Calisma2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "8520456");
        Statement st=con.createStatement();

      //  String sql1="create table schools(school_name varchar(50),student_count int,city varchar(20),tel_number int)";
      //  st.execute(sql1);
        ResultSet resultSet1=st.getResultSet();
        while(resultSet1.next()){
            System.out.println(resultSet1.getString("school_name"));
        }
        String sql2="select * from scools";
        st.execute(sql2);




    }
}
