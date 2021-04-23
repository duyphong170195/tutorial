package dao;

import javax.inject.Inject;
import javax.inject.Named;

@Named("daoUtils")
public class DAOUtils {

    @Inject
    private ConnectDatabase conn;
    public void query() {
        conn.connect();
        System.out.println("query database...");
    }
}
