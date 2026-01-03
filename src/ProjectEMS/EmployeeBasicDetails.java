package ProjectEMS;// write a method that lets the employee enter his bank accoutn if he gets accepted.
// this class has the potential to be an abstract class

public class EmployeeBasicDetails {
    private String table_name;//investigata whether this variable should be written here
    private int id;
    private String first_name;
    private String middle_name;
    private String last_name;
    private int birth_day;
    private int birth_month;
    private int birth_year;
    private String phone_number;
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
    private String gender;
    private String qualification;
    private double salary;
    private int bank_account;
    private String email_address="";
    private String password;
    private int MaximumAge;
    private int MinimumAge;
    private String country;
    private String city;
    private String kebele;


    String name=first_name+middle_name+last_name;

public EmployeeBasicDetails(){

}
//the below constructor is for login purpose
public EmployeeBasicDetails(String password, String email_address){
    this.password=password;
    this.email_address=email_address;

}

public EmployeeBasicDetails( String first_name, String middle_name, String last_name, int birth_day, int birth_month, int birth_year,
                          String phone_number, String marital_status, String Country,String City,String Kebele, String employee_type, String skills, int postal_code,
                             String gender, String qualification, String email_address,String password){// this is called during registration
//this.id;
this.first_name=first_name;
this.middle_name=middle_name;
this.country=Country;
this.city=City;
this.kebele=Kebele;
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
//this.department=department; to be set by teh admin
this.gender=gender;
this.qualification=qualification;
this.password=password;
this.email_address=email_address;
}
    public EmployeeBasicDetails(int salary,  String employee_type, String department, int id, String skills) {
        this.employee_type=employee_type;
        this.department=department;
        this.id=id;
        this.skills=skills;

    }
public EmployeeBasicDetails(int start_date,int start_month, int start_year, double salary){
    // this is called only if the employee has successfully been accepted
    this.start_date=start_date;
    this.start_month=start_month;
    this.start_year=start_year;
    this.salary=salary;
}
public EmployeeBasicDetails(int MaximumAge, int MinimumAge){
    this.MaximumAge=MaximumAge;
this.MinimumAge=MinimumAge;}
 public EmployeeBasicDetails(int end_date, int end_month, int end_year){
    // this is called when the employee wants to leave
     this.end_date=end_date;
     this.end_month=end_month;
     this.end_year=end_year;
 }
 public int getMaximumAge(){
    return MaximumAge;
 }
 public int getMinimumAge(){
    return MinimumAge;
 }
 public void setMaximumAge(int agemax){
    MaximumAge=agemax;
 }
 public void setMinimumAge(int agemin){
    MinimumAge=agemin;
 }
    public void setFirst_name(String first_name){
        this.first_name = first_name;}

    public String getFirst_name() {
        return first_name;
    }

    public void setid(int id) {
        this.id = id;}
        public int getId(){
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
        public void setPassword(String password){
    this.password=password;
        }
        public int getEnd_date(){return end_date;}
    public int getEnd_month(){
    return end_month;
    }
    public int getEnd_year(){
    return end_year;
    }


    public String getPassword() {
        return password;
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

    public void setPhone_number(String phone_number) {
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

    public void setGender(String gender) {
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

    public void setSalary(double salary) {
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
    public void setEmail_address(String email_address){
    this.email_address=email_address;
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

    public String getPhone_number() {
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
    public String getEmail_address(){
    return email_address;
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
    public String getGender(){
    return gender;
    }
    public String getCountry(){
    return country;
    }
    public String getCity(){
    return city;}
    public String getKebele(){
    return kebele;
    }
    public String getQualification(){
    return qualification;
    }
    public double getSalary(){
    return salary;
    }
    public EmployeeBasicDetails(int start_date,int start_month, int start_year, int end_date, int end_month,int end_year, double salary,String department){
    this.start_date=start_date;
    this.start_month= start_month;
    this.start_year=start_year;
    this.end_date= end_date;
    this.end_month= end_month;
    this.end_year= end_year;
    this.salary=salary;
    this.department=department;
    }

    public void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Department: " + department + " | Salary: " + salary);
    }
    //public static void main(String [] args){
    //Scanner scanner=new Scanner(System.in);
   // ProjectEMS.EmployeeBasicDetails registration=new ProjectEMS.EmployeeBasicDetails();
       // System.out.print("Enter your first name: ");
//registration.first_name=scanner.nextLine();
        //System.out.print("Enter your middle name: ");
        //registration.middle_name=scanner.nextLine();
      //  System.out.print("Enter your last name: ");
//registration.last_name=scanner.nextLine();
       // System.out.print("Enter your birth date: ");
      //  registration.birth_day=scanner.nextInt();
     //   registration.birth_month=scanner.nextInt();
     //   registration.birth_year=scanner.nextInt();
      //  System.out.print("Enter your phone number: ");
     //   registration.phone_number=scanner.nextLine();

   // }
    }
        // write the left setters and getters.


