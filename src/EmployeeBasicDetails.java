public class EmployeeBasicDetails {
    private String table_name;//investigata whether this variable should be written here
    private int id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private int birth_day;
    private int birth_month;
    private int birth_year;
    private int phone_number;
    private String marital_status;
    private String address;
    private int start_date;
    private int start_month;
    private int start_year;
    private int end_date;
    private int end_month;
    private int end_year;
    private String employee_type;
    private String skills;
    private int postal_code;
    private String department;
    private char gender;
    private String qualification;
    private int salary;

public EmployeeBasicDetails(){

}
public EmployeeBasicDetails(int id, String first_name, String middle_name, String last_name, int birth_day, int birth_month, int birth_year,
                          int phone_number, String marital_status, String address, String employee_type, String skills, int postal_code,
                            String department, char gender, String qualification){// this is called during registration
this.id=id;
this.first_name=first_name;
this.middle_name=middle_name;
this.last_name=last_name;
this.birth_day=birth_day;
this.birth_month=birth_month;
this.birth_year=birth_year;
this.phone_number=phone_number;
this.marital_status=marital_status;
this.address=address;
this.employee_type=employee_type;
this.skills=skills;
this.postal_code=postal_code;
this.department=department;
this.gender=gender;
this.qualification=qualification;
}
public EmployeeBasicDetails(int start_date,int start_month, int start_year, int salary){
    // this is called only if the employee has successfully been accepted
    this.start_date=start_date;
    this.start_month=start_month;
    this.start_year=start_year;

    this.salary=salary;
}
 public EmployeeBasicDetails(int end_date, int end_month, int end_year){
    // this is called when the employee wants to leave
     this.end_date=end_date;
     this.end_month=end_month;
     this.end_year=end_year;
 }
    public void setFirst_name(String first_name){
        this.first_name = first_name;}

    public String getFirst_name() {
        return first_name;
    }

    public void setid(int id) {
        this.id = id;}
        public int getid(){
            return id;
        }
        public void setTable_name(String table_name){
        this.table_name=table_name;
        }
        public String getTable_name(){
        return table_name;
        }
        public void setMiddle_name(String middle_name){
        this.middle_name=middle_name;
        }
        public String getMiddle_name(){
        return middle_name;
        }
        public void setLast_name(String last_name){
        this.last_name=last_name;
        }
        public String getLast_name(){
    return last_name;
        }

    public void setId(int id) {
        this.id = id;
    }

    public void setBirth_day(int birth_day) {
        this.birth_day = birth_day;
    }

    public void setBirth_month(int birth_month) {
        this.birth_month = birth_month;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public void setEmployee_type(String employee_type) {
        this.employee_type = employee_type;
    }

    public void setEnd_date(int end_date) {
        this.end_date = end_date;
    }

    public void setEnd_month(int end_month) {
        this.end_month = end_month;
    }

    public void setEnd_year(int end_year) {
        this.end_year = end_year;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public void setStart_date(int start_date) {
        this.start_date = start_date;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public void setStart_month(int start_month) {
        this.start_month = start_month;
    }

    public void setStart_year(int start_year) {
        this.start_year = start_year;
    }


    public int getBirth_day() {
    return birth_day;
        }// write  method that when called, sets the specified data
    public int getBirth_month(){
    return birth_month;
    }
    public int getBirth_year(){
    return birth_year;
    }

    public int getPhone_number() {
        return phone_number;
    }
    public String getMarital_status(){
    return marital_status;
    }
    public String getAddress(){
    return address;
    }
    public int getStart_date(){
    return start_date;
    }
    public int getStart_month(){
    return start_month;
    }
    public int getStart_year(){
    return start_year;
    }
    public String getEmployee_type(){
    return employee_type;

    }
    public String getSkills(){
        return skills;
    }
    public int getPostal_code(){
    return postal_code;
    }
    public String getDepartment(){
    return department;
    }
    public char getGender(){
    return gender;
    }
    public String getQualification(){
    return qualification;
    }
    public int getSalary(){
    return salary;
    }
    public EmployeeBasicDetails(int salary,  String employee_type, String department, int id, String skills) {
this.employee_type=employee_type;
this.department=department;
this.id=id;
this.skills=skills;
    }}
        // write the left setters and getters.


