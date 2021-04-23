package dao;

public class ConnectMySQL implements ConnectDatabase {
    @Override
    public void connect() {
        System.out.println("Connect MySQL database");
    }
}
