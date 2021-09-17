import javax.sql.DataSource;
import java.sql.SQLException;

public class Db {
    DataSource ds = DbConnection.getMySQLDataSource();

    public Db(DataSource ds) {
        this.ds = ds;
    }

    public void save() throws SQLException {

    }

    public void loadById(int id) throws SQLException {

    }
}
