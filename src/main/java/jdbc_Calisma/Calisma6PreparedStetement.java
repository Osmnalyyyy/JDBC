package jdbc_Calisma;

import java.sql.*;

public class Calisma6PreparedStetement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro","postgres","8520456");
        Statement st=con.createStatement();


        String sql1="update countries set region_id=? where country_name=?";
        PreparedStatement prs1=con.prepareStatement(sql1);
        prs1.setInt(1,16);
        prs1.setString(2,"Japan");
        int updateSayisi=prs1.executeUpdate();
        System.out.println(updateSayisi+" row update");

        String sql2="select * from countries";
        ResultSet res2=st.executeQuery(sql2);
        while (res2.next()){
            System.out.println(res2.getString(1)+" "+res2.getString(2)+" "+res2.getInt(3));
        }

        prs1.setInt(1,10);
        prs1.setString(2,"Italy");
        prs1.executeUpdate();

        String sql3="select * from countries";
        ResultSet res3=st.executeQuery(sql2);
        while (res3.next()){
            System.out.println(res3.getString(1)+" "+res3.getString(2)+" "+res3.getInt(3));
        }

        prs1.setInt(1,20);
        prs1.setString(2,"Mexico");
        prs1.executeUpdate();

        String sql4="select * from countries";
        ResultSet res4=st.executeQuery(sql4);
        while (res4.next()){
            System.out.println(res4.getString(1)+" "+res4.getString(2)+" "+res4.getInt(3));
        }

        prs1.setInt(1,35);
        prs1.setString(2,"India");
        prs1.executeUpdate();

        String sql5="select * from countries";
        ResultSet res5=st.executeQuery(sql5);
        while (res5.next()){
            System.out.println(res5.getString(1)+res5.getString(2)+res5.getInt(3));
        }


    }
}
