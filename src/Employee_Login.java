
import javax.xml.crypto.Data;
import java.util.Scanner;
public class Employee_Login {

    Scanner scanner =new Scanner(System.in);
    DataBaseConnector employee_manipulated=new DataBaseConnector();
    // logging in
    private String login(){
        System.out.print("Enter your email");
        String email=scanner.nextLine();
        System.out.print("Enter your password");
        String password=scanner.nextLine();
        // write code to retrieve data from database and check whether the password inserted and the email match
    employee_manipulated.dtcConnectmethod("retrieve employee data");
    return email;}// this line is incorrect it is just to avoid the error. must be rewritten

public void access_data(String employee_input){

EmployeeBasicDetails empmanager =new EmployeeBasicDetails();
if (employee_input.equals("edit my name")){
    int count1=0;
    int count=0;
    int count2=2;
   int count3=3;
    System.out.print("Enter your first name: ");
    String newname=scanner.nextLine();
    if ((newname.trim()).length()!=0){
empmanager.setFirst_name(newname);
    count1=1;
        count+=1;
   }
    System.out.print("Enter your middle name: ");
    newname=scanner.nextLine();
    if ((newname.trim()).length()!=0){
        empmanager.setMiddle_name(newname);
        count+=1;
        count2=2;
    }
    System.out.print("Enter your last name: ");
    newname=scanner.nextLine();
    if ((newname.trim()).length()!=0){
empmanager.setLast_name(newname);
        count3=3;
        count+=1;
    }
    System.out.println("do you want to save changes?YES/NO ");
    String savechange=scanner.nextLine();
    if (savechange.equals("YES")){// this is a button
for (int i=1;i<count;i++){
    if (i==count1){
        employee_manipulated.dtcConnectmethod(empmanager.getFirst_name());}
    if (i==count2){
        employee_manipulated.dtcConnectmethod(empmanager.getMiddle_name());
    }
    if (i==count3){
    employee_manipulated.dtcConnectmethod(empmanager.getLast_name());}
    System.out.println("Saved successfully");

}
    }
// after the above code has been executed, let the gui show to the employee whether to save his/her data
}

}
    public void save(){

        DataBaseConnector employee_updated= new DataBaseConnector();

    }}