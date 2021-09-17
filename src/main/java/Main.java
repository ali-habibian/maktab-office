import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    static DataSource ds = DbConnection.getMySQLDataSource();

    public static void main(String[] args) throws SQLException {
        while (true) {
            System.out.println("             ------------------Menu-------------------");
            System.out.println("             1. save Employee                        |");
            System.out.println("             2. save Offices                         |");
            System.out.println("             3. load by id Employee                  |");
            System.out.println("             4. load by id Offices                   |");
            System.out.println("             5. Exit                                 |");
            System.out.println("             Which option do you choose? :            ");

            int result = input.nextInt();
            if (result == 1) {
                saveEmployee();
            } else if (result == 2) {
                saveOffice();
            } else if (result == 3) {
                loadEmployeeById();
            } else if (result == 4) {
                loadOfficeById();
            } else if (result == 5) {
                break;
            }
        }
    }

    private static void loadOfficeById() throws SQLException {
        System.out.println("Enter office id: ");
        int officeID = input.nextInt();

        OfficesDb officesDb = new OfficesDb(ds);
        officesDb.loadById(officeID);
    }

    private static void loadEmployeeById() throws SQLException {
        System.out.println("Enter employee id: ");
        int employeeID = input.nextInt();

        EmployeeDb employeeDb = new EmployeeDb(ds);
        employeeDb.loadById(employeeID);
    }

    private static void saveOffice() throws SQLException {
        System.out.println("Enter office id: ");
        int officeID = input.nextInt();

        System.out.println("Enter address: ");
        String address = input.next();

        System.out.println("Enter city: ");
        String city = input.next();

        System.out.println("Enter state: ");
        String state = input.next();

        Office office = new Office(officeID, address, city, state);
        OfficesDb officesDb = new OfficesDb(ds, office);

        officesDb.save();
    }

    private static void saveEmployee() throws SQLException {
        System.out.println("Enter employee id: ");
        int empID = input.nextInt();

        System.out.println("Enter first name: ");
        String firstName = input.next();

        System.out.println("Enter last name: ");
        String lastName = input.next();

        System.out.println("Enter job title: ");
        String jobTitle = input.next();

        System.out.println("Enter salary: ");
        int salary = input.nextInt();

        System.out.println("Enter report to: ");
        int reportTo = input.nextInt();

        System.out.println("Enter office id: ");
        int officeID = input.nextInt();

        Employee employee = new Employee(empID, firstName, lastName, jobTitle, salary, reportTo, officeID);
        EmployeeDb employeeDb = new EmployeeDb(ds, employee);
        employeeDb.save();
    }
}
