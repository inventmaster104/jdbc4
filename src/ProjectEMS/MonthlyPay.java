package ProjectEMS;

public class MonthlyPay extends EmployeeSalaryData {
    private double salary; // monthly

    public MonthlyPay(String name, double salary, String employeeType,String dept, String wFormat) {
        super(name, employeeType, dept, wFormat);
        this.salary = salary;
    }

    @Override
    public double getPay() {
        return salary;
    }

    @Override
    public String printData() {
        return super.printData()+"\n Monthly Salary: " + getPay() + " ETB";}
}
