import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDb extends Db {
    private String save_query = "INSERT INTO sql_hr.employees (employee_id, first_name, last_name, job_title, salary, reports_to, office_id) " +
            "VALUES(?, ?, ?, ?, ?, ?, ?)";

    private String load_query = "SELECT * FROM sql_hr.employees where employee_id = ?";

//    private int id;
//    private String firstName;
//    private String lastName;
//    private String jobTitle;
//    private int salary;
//    private int reportTo;
//    private int officeID;

    private Employee employee;

    public EmployeeDb(DataSource ds) {
        super(ds);
    }

    public EmployeeDb(DataSource ds, Employee employee) {
        super(ds);
        this.employee = employee;
    }

    //    public EmployeeDb(DataSource ds, int id, String firstName, String lastName, String jobTitle, int salary, int reportTo, int officeID) {
//        super(ds);
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.jobTitle = jobTitle;
//        this.salary = salary;
//        this.reportTo = reportTo;
//        this.officeID = officeID;
//    }

    @Override
    public void save() throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(save_query);
        ps.setInt(1, employee.getId());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getLastName());
        ps.setString(4, employee.getJobTitle());
        ps.setInt(5, employee.getSalary());
        ps.setInt(6, employee.getReportTo());
        ps.setInt(7, employee.getOfficeID());

        ps.executeUpdate();
    }

    @Override
    public void loadById(int id) throws SQLException {
        Connection connection = ds.getConnection();
        PreparedStatement ps = connection.prepareStatement(load_query);
        ps.setInt(1, id);

        ResultSet resultSet = ps.executeQuery();

        while (resultSet.next()) {
            int emp_id = resultSet.getInt("employee_id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String jobTitle = resultSet.getString("job_title");
            int salary = resultSet.getInt("salary");
            int reportTo = resultSet.getInt("reports_to");
            int officeID = resultSet.getInt("office_id");

            System.out.println("id: " + id + ", name: " + firstName + " " + lastName + ", job title: " + jobTitle
                    + ", salary: " + salary + ", report to: " + reportTo + ", office id: " + officeID);
        }

        connection.close();
        ps.close();
        resultSet.close();
    }
}
