import javax.xml.crypto.Data;
import java.util.Scanner;
public class Employee_Login{


    static String emal;
    String loginerror;
//DataBaseConnector mp= new DataBaseConnector();
    Scanner scanner =new Scanner(System.in);
    DataBaseConnector employee_manipulated=new DataBaseConnector();
    EmployeeBasicDetails empmanager =new EmployeeBasicDetails();

    // logging in
    public String error(){
        return loginerror;
    }
    public String login(String email,String password){

       // System.out.print("Enter your email: ");
       //email.scanner.nextLine();
        if ( email.length()<11 ||  (!email.substring(email.length()-10).equals("@yahoo.com") && !email.substring(email.length()-10).equals("@gmail.com"))
                || email.contains(" ")){


            loginerror="invalid email address! Enter a valid email address ";
          return loginerror;

        }
        else{
            employee_manipulated.dtcConnectmethod(new EmployeeBasicDetails(password,email), "retrieve data for login");
            return employee_manipulated.getLoginvalue();
        }

           // employee_manipulated.setLoginEmail(email);
       //  password=scanner.nextLine();
        //employee_manipulated.setloginpassw(password);

        // write code to retrieve data from database and check whether the password inserted and the email match

    }// this method should be of return type to allow the user to access his account.

public void access_data() {
    employee_manipulated.dtcConnectmethod(empmanager, "edit your data");


/*if (employee_input.equals("edit my name")){

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
        employee_manipulated.dtcConnectmethod(empmanager,empmanager.getFirst_name());}// this has a serious error. it does not edit the name. i also need to login before this action can be done
    if (i==count2){
        employee_manipulated.dtcConnectmethod(empmanager,empmanager.getMiddle_name());
    }
    if (i==count3){
    employee_manipulated.dtcConnectmethod(empmanager,empmanager.getLast_name());}
    System.out.println("Saved successfully");

}
    }
// after the above code has been executed, let the gui show to the employee whether to save his/her data
}
public void save(){

        DataBaseConnector employee_updated= new DataBaseConnector();

    }
}*/
}}