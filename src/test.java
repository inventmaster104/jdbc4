import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
import java.util.Scanner;
public class test {
    public static void main(String[] args) throws SQLException{
        DataBaseConnector db=new DataBaseConnector();
       // EmployeeBasicDetails basic_detail=new EmployeeBasicDetails();
        Scanner input=new Scanner(System.in);
        /*type retrieve data in order to access the basic details of employees. then it will
        ask you whether you want to access the data of all the employees or a single employee.
        then it will retrieve the data for you from the database.
         */
        System.out.print("Hello, choose what you want to do from the following\n");
        System.out.println("retrieve employee data");
        System.out.println("add employee");
        System.out.println("delete table");
        System.out.println("create table");
        System.out.println("delete employee data");
        System.out.println("edit your data");
        String manipulate_data=input.nextLine();
        db.dtcConnectmethod(manipulate_data);
        // write  a code to launch registration fo ra single department. set limits of applications and and time range
        // fornth =e attendance. give permission for teh employee ot live the work place.
        //the code must differentiate between the password of the admin and the employees
        //
        System.out.print("operation successful");
        // write code for taking inputs here


    }
}
