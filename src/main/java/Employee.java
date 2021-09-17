public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private int salary;
    private int reportTo;
    private int officeID;

    public Employee(int id, String firstName, String lastName, String jobTitle, int salary, int reportTo, int officeID) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.reportTo = reportTo;
        this.officeID = officeID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getReportTo() {
        return reportTo;
    }

    public void setReportTo(int reportTo) {
        this.reportTo = reportTo;
    }

    public int getOfficeID() {
        return officeID;
    }

    public void setOfficeID(int officeID) {
        this.officeID = officeID;
    }
}
