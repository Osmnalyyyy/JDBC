package jdbc_practice;

import java.sql.*;

public class Query05 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Techpro", "postgres", "8520456");
        Statement st = con.createStatement();
        // PreparedStatement ps = con.prepareStatement("insert into ogrenciler values(?,?,?,?)");

        //SORU: Öğrenciler tablosuna yen bir kayıt ekleyin (300, 'Sena Can', 12, 'K')
        //  ps.setInt(1,300);
        //  ps.setString(2,"Sena Can");
        //  ps.setString(3,"12");
        //  ps.setString(4,"K");
        //  ps.executeUpdate();
  //     int s1 = st.executeUpdate("insert into ogrenciler values(500, 'Sena Can', 12, 'K')");
  //     System.out.println(s1 + " adet satir database'e eklendi");

        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
        // (400, 'Sena Can', 12, 'K'), (401, 'Sena Can', 12, 'K'), (402, 'Sena Can', 12, 'K')

        // 1. yol
      /*  String[] veri = {"insert into ogrenciler values(400, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(401, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(402, 'Sena Can', 12, 'K')"};

        int count=0;
        for (String each:veri){
           count=count+ st.executeUpdate(each);

        }
        System.out.println(count+" Satir eklendi");

       */

        // 2. yol
        String[] veri1 = {"insert into ogrenciler values(404, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(405, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values(406, 'Sena Can', 12, 'K')"};

        for (String w : veri1) {
            st.addBatch(w);// yukarıdaki dataların hepsini birlestiriyor
        }
        st.executeBatch(); // dataları tek seferde gönderiyor
        System.out.println("datalar eklendi");
    }
}
