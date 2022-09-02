package jdbc;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // DBWork objesini oluştur
        DBWork dbWork = new DBWork();
        // connection fonksiyonunu cagirdik
        Connection con = dbWork.connect_to_db("Techpro", "postgres", "8520456");

        // yeni table olusturma methodunu cagirdik.
        dbWork.createTable(con,"employees");
    }
}
