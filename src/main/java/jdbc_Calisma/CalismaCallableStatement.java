package jdbc_Calisma;

import java.sql.*;

public class CalismaCallableStatement {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "8520456");
        Statement st = con.createStatement();
        //1. Örnek: İki parametre ile çalışıp bu parametreleri toplayarak return yapan bir fonksiyon oluşturun.

        String sql = "create or replace function carpma(x numeric,y numeric)\n" +
                "returns numeric\n" +
                "language plpgsql\n" +
                "as\n" +
                "$$\n" +
                "begin \n" +
                "return x*y;\n" +
                "end\n" +
                "$$";
        st.execute(sql);
        CallableStatement cs1 = con.prepareCall("{? = call carpma(?,?)}");

        cs1.registerOutParameter(1,Types.NUMERIC);
        cs1.setInt(2,15);
        cs1.setInt(3,25);

        cs1.execute();

        System.out.println(cs1.getBigDecimal(1));

        //2. Örnek: Koninin hacmini hesaplayan bir function yazın.

        String sql1 = "create or replace function küpHacmi(r numeric)\n" +
                "returns numeric\n" +
                "language plpgsql\n" +
                "as\n" +
                "$$\n" +
                "begin \n" +
                "return 4*3.14*r*r*r/3;\n" +
                "end\n" +
                "$$";
        st.execute(sql1);
        CallableStatement cs2 = con.prepareCall("{? = call küpHacmi(?)}");

        cs2.registerOutParameter(1,Types.NUMERIC);
        cs2.setInt(2,4);

        cs2.execute();

        System.out.println(cs2.getBigDecimal(1));
    }
}
