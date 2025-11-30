public class WorkDetails extends EmployeeBasicDetails {
    int attendance;
    String employee_type;
    int work_hour;
    String department;
    int salary;
    int reports_submitted;


    // write a code tat allows the user to write the skills he needs and how much salary he wats to pay for the skills
    public WorkDetails(  int reports_submitted, int salary, String employee_type, String department, int id, String skills, int work_hour,int attendance){
        super( salary, employee_type, department, id, skills);
        this.attendance=attendance;
        this.work_hour=work_hour;
        this.reports_submitted=reports_submitted;

    }
    EmployeeAdmin epm=new EmployeeAdmin();

    public int salaryCalculator() {
        int temp_holder=0;
        if (employee_type.equals("Full_Time")) {
temp_holder= epm.base_salary*60;
        }
        else if(employee_type.equals("part-time")) {
      temp_holder= epm.base_salary * work_hour;
        }return temp_holder;}}
