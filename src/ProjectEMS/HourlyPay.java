package ProjectEMS;

public class HourlyPay extends EmployeeSalaryData{
    private double wage;        // regular hourly wage
    private double hoursWorked;
    private EmployeeBasicDetails bd=new EmployeeBasicDetails();
    private DataBaseConnector conn=new DataBaseConnector();

    public HourlyPay(String name, double wage, double hoursWorked, String workFormat, String employeeType,String dept) {
        super(name, employeeType, dept,workFormat);
        this.wage = wage;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double getPay() {
        if (getEmployeeType().equals("Intern")) {
            return wage * hoursWorked;
        } else {
            // Full-time or part-time: overtime applies
            double overtime=conn.getOvertime();
            double regularHours = Math.min(hoursWorked, overtime);
            double overtimeHours = Math.max(hoursWorked - overtime, 0);
            return (regularHours * wage) + (overtimeHours * wage * 1.5);
        }
    }

    @Override
    public String printData() {
        return super.printData() +"\n Hourly Pay: " + getPay() + " ETB";
    }
}
