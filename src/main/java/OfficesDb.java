import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OfficesDb extends Db {
    private String save_query = "INSERT INTO sql_hr.offices (office_id, address, city, state) VALUES(?, ?, ?, ?)";

    private String load_query = "SELECT * FROM sql_hr.offices WHERE office_id = ?";

//    private int id;
//    private String address;
//    private String city;
//    private String state;

    Office office;

    public OfficesDb(DataSource ds) {
        super(ds);
    }

//    public OfficesDb(DataSource ds, int id, String address, String city, String state) {
//        super(ds);
//        this.id = id;
//        this.address = address;
//        this.city = city;
//        this.state = state;
//    }


    public OfficesDb(DataSource ds, Office office) {
        super(ds);
        this.office = office;
    }

    @Override
    public void save() throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(save_query);
        ps.setInt(1, office.getId());
        ps.setString(2, office.getAddress());
        ps.setString(3, office.getCity());
        ps.setString(4, office.getState());

        ps.executeUpdate();
    }

    @Override
    public void loadById(int id) throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(load_query);
        ps.setInt(1, id);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int office_id = resultSet.getInt("office_id");
            String address = resultSet.getString("address");
            String city = resultSet.getString("city");
            String state = resultSet.getString("state");

            System.out.println("id: " + id + ", address: " + address + ", city: " + city + ", state: " + state);
        }

        connection.close();
        ps.close();
        resultSet.close();
    }
}
