package ProjectEMS;

public abstract class EmployeeSalaryData {
    private String name;
    private String workFormat;
    private String employeeType;
    private String department;

    public EmployeeSalaryData(String name, String etype, String department,String wFormat) {
        this.name = name;
        this.employeeType = etype;
        this.department = department;
        this.workFormat=wFormat;
    }

    public String getFullName() {
        return name;
    }

    public String getEType() {
        return employeeType;
    }

    public String getEDepartment() {
        return department;
    }
    public String getEmployeeType(){return employeeType;}
    public String getworkFormat(){
        return workFormat;
    }

    public abstract double getPay();

    public String printData() {
        return "Welcome Back "+ getFullName()+ "!\n Department: " + department + "\n " + employeeType+"\n"+workFormat;
    }
}
