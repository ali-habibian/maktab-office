import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public static DataSource getMySQLDataSource(){
        MysqlDataSource mysqlDS = new MysqlDataSource();
        mysqlDS.setURL(DbConfig.URL);
        mysqlDS.setUser(DbConfig.USERNAME);
        mysqlDS.setPassword(DbConfig.PASSWORD);
        return mysqlDS;
    }
}
