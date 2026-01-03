import ProjectEMS.EmployeeAdmin;

import java.util.Scanner;

public class AdminMain {
    static EmployeeAdmin admiN= new EmployeeAdmin();


    public static void main(String [] args){

        Scanner scanner=new Scanner(System.in);
    String adminChoice;
    //employee registration
        System.out.println("Select your choice: accept employee, ");// the choices are
        adminChoice=scanner.nextLine();
        if (adminChoice.equals("Open Registration")){
           AdminMain.admiN.Openregistration();
        }
        else if(adminChoice.equals("")){
        }
    }
}
