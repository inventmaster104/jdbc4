package ProjectEMS;// for registration purpose, create a new table so that current employees and registering employees will not get mixed.
// make mysql give them temporary id and if the total number of employees reached, let it announce an error, which then triggers
// actions to be undertaken like saying the registration has ended.



import java.util.Scanner;
public class EmployeeAdmin {
    Scanner scanner=new Scanner(System.in);
    DataBaseConnector Admintype= new DataBaseConnector();
    EmployeeBasicDetails adminSetRetriever=new EmployeeBasicDetails();

    int base_salary;
    String registrationButton=null;
    public void setRegistrationData(){// to be accessed only by the admin
        Admintype.dtcConnectmethod(adminSetRetriever,"set adminsetdata");
    }
    // the below method is to see the admin set data for registration and other stuff
    public void seeAdminSetData(){
        Admintype.dtcConnectmethod(adminSetRetriever,"retrieve adminsetdata");
    }
public void Openregistration(){
    registrationButton="Open Registration";
}

     //   private ArrayList<ProjectEMS.EmployeeBasicDetails> employees = new ArrayList<>();
        private final int MAX_EMPLOYEES = 30;//  consider changing this from final status
        static int count=0;
//EMPLOYEE REGISTRATION

    public EmployeeBasicDetails  registerEmployee() {// check whether this class is the appropriate class for it

        if (count<MAX_EMPLOYEES){
            String first_name;
            System.out.print("Enter your first name: ");
            first_name=scanner.nextLine();
            String middle_name;
            System.out.print("Enter your middle name: ");
            middle_name=scanner.nextLine();
            String last_name;
            System.out.print("Enter your last name: ");
            last_name=scanner.nextLine();
            System.out.print("Enter you email address: ");
            String email_address=scanner.nextLine();
            while ( email_address.length()<11 ||  (!email_address.substring(email_address.length()-10).equals("@yahoo.com") && !email_address.substring(email_address.length()-10).equals("@gmail.com"))
            || email_address.contains(" ")){
                System.out.print("invalid email address! Enter a valid email address: ");
                email_address=scanner.nextLine();
            }
          System.out.print("Enter your birthday: ");
            String birth_date=null;
            boolean valid1=true;
            while (valid1){
                birth_date=scanner.nextLine();
                try{int age_date=Integer.parseInt(birth_date);
                    valid1=false;
                }
                catch (IllegalArgumentException e) {
                    System.out.print("invalid entry. Enter an appropriate entry: ");
                }
            }

            String birth_month=null;
            boolean valid2=true;
            while (valid2){
                birth_month=scanner.nextLine();
                try{
                    int age_month=Integer.parseInt(birth_month);
                    valid2=false;}
                catch (IllegalArgumentException e) {
                    System.out.print("invalid entry. Enter an appropriate entry: ");
                }
            }
            boolean valid3=true;
            String birth_year=null;
            while (valid3){
                birth_year=scanner.nextLine();
                try{
                    int age_year=Integer.parseInt(birth_year);
                    valid3=false;}
                catch (IllegalArgumentException e) {
                    System.out.print("invalid entry. Enter an appropriate entry: ");
                }
            }

            while(Integer.parseInt(birth_date)<1 || Integer.parseInt(birth_date)>30){
                System.out.print("Invalid date! Enter a valid entry");
                birth_date=scanner.nextLine();
            }

            while(Integer.parseInt(birth_month)<1 || Integer.parseInt(birth_month)>12){
                System.out.print("Invalid month! Enter a valid entry: ");
                birth_month=scanner.nextLine();
            }

            Admintype.dtcConnectmethod(adminSetRetriever,"retrieve adminsetdata");
            int max_age=adminSetRetriever.getMaximumAge();
            int min_age=adminSetRetriever.getMinimumAge();

            while(Integer.parseInt(birth_year)<min_age || Integer.parseInt(birth_year)>max_age){
                System.out.print("Invalid entry for year! Enter a valid entry: ");
                birth_year=scanner.nextLine();
            }
            System.out.print("Enter your phone number: ");
            String phone_number=scanner.nextLine();
            try{
                int phone_no=Integer.parseInt(phone_number);
            }
            catch(IllegalArgumentException e){
                System.out.print("Invalid entry! Enter an appropriate phone number");
            }
            System.out.print("marital status: ");
            String marital_status=scanner.nextLine();
            System.out.print("Enter your address: ");
            String address=scanner.nextLine();
            System.out.print("Job title: ");
            String employee_type=scanner.nextLine();
            System.out.print("Your skills: ");
            String skills=scanner.nextLine();
            System.out.print("Enter your postal code: ");
            int postal_code=scanner.nextInt();
            System.out.print("Gender: ");
            char gender=scanner.next().charAt(0);
            scanner.nextLine();
            System.out.print("What are you applying for?");// make a list of available vacant jobs.
            String department=scanner.nextLine();
            System.out.print("List your qualifications: ");
            String qualification=scanner.nextLine();
            System.out.print("set a password: ");
            String password=scanner.nextLine();
            System.out.print("Confirm password: ");
            String confirmpassword=scanner.nextLine();
            /*while (!password.equals(confirmpassword)){
                System.out.print("Password does not match! ");
                System.out.print("set a password: ");
                 password=scanner.nextLine();
                System.out.print("Confirm password: ");
                confirmpassword=scanner.nextLine();
            }*/
            PasswordHash hashp=new PasswordHash();
            String hashedpassword=hashp.encode(password);
            /*ProjectEMS.EmployeeBasicDetails adminVersion=new ProjectEMS.EmployeeBasicDetails( first_name, middle_name, last_name, Integer.parseInt(birth_date), Integer.parseInt(birth_month), Integer.parseInt(birth_year),
            phone_number, marital_status,address,employee_type, skills,postal_code, gender, qualification, email_address,hashedpassword);


            Admintype.dtcConnectmethod(adminVersion,"add employee");
            return adminVersion;*/
        }
        else {
            System.out.println("❌ Registration closed! Maximum " + MAX_EMPLOYEES + " employees allowed.");
            return null;

        }
       return null;// this is just for checking. the method is not supposed to return null
    }public static void acceptEmployee(){
/*salary set,
employee, id,start date, month,year
  */
    }
    public static void fireEmployee(){
        // here add the end date of the employee
    }

    // Check for duplicate ID
       // for (ProjectEMS.EmployeeBasicDetails emp : employees) {
      //  if (emp.getId() == e.getId()) {
       //     System.out.println(" Employee ID already exists!");
      //      return;
     //   }
   // }

      //  employees.add(e);
       // System.out.println(" Employee added successfully!");
//}

//public void viewAllEmployees() {
   // if (employees.isEmpty()) {
     //   System.out.println("️ No employees found.");
       // return;
   // }
  //  System.out.println("\n--- Employee List ---");
   // for(ProjectEMS.EmployeeBasicDetails e : employees){
     //   e.display();
   // }
//}
// make the below code so that specific employe data can be updated
   // public void updateEmployee(int id, String newFirstName,String newMiddleName,String newLast_Name , String newDepartment, double newSalary) {
       // for (ProjectEMS.EmployeeBasicDetails e : employees) {
          //  if (e.getId() == id) {
              //  e.setFirst_name(newFirstName);
              //  e.setMiddle_name(newMiddleName);
              //  e.setLast_name(newLast_Name);
               // e.setDepartment(newDepartment);
              //  e.setSalary(newSalary);
               // System.out.println(" Employee updated successfully!");
              //  return;
           // }
       // }
      //  System.out.println("Employee not found!");
   // }

    //public void deleteEmployee(int id) {
       // for (ProjectEMS.EmployeeBasicDetails e : employees) {
          //  if (e.getId() == id) {
              //  employees.remove(e);
               // System.out.println("🗑 Employee deleted successfully!");
               // return;
           // }
       // }
       // System.out.println("❌ Employee not found!");

}

