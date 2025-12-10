// write a mysql code to add applicants
//write code to prevent duplicate creation of tables rows or  columns
// must delete teh phone number from the database because its datatype is not stri
import py4j.GatewayServer;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.ResultSet;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
public class DataBaseConnector {
    private String loginvalue;
    private String loginpassw="";
    private String loginEmail="";
    private String query;
   // write a code to accept an update from teh user

   // EmployeeAdmin adminversion=new EmployeeAdmin();
    //EmployeeBasicDetails mp=adminversion.registerEmployee();
    Scanner scanner=new Scanner(System.in);
    PasswordHash hashpasdword=new PasswordHash();

public void setloginpassw(String pasw){
    loginpassw=pasw;
    }
public String getLoginpassw(){
    return loginpassw;
}
public void setLoginEmail(String loginEmail){
    this.loginEmail=loginEmail;
}
public String getLoginEmail(){
    return loginEmail;
}
// write a code to create a table
    public void dtcConnectmethod(EmployeeBasicDetails mp, String value){

        String url="jdbc:mysql://localhost:3306/jdbcTOP";
         String username="root";
         String password="KawqbBON89!!GA.HELLO";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();


            // ResultSet resultSet=statement.executeQuery();

            //Resultset resultSet = statement.executeQuery("select * from employebasicdetails");
// i need to pdata the below mysql program so that the salary, department and the things only the employee can adda nd the things only the admin can add
            if (value.equals("add employee")) {// checked and worked. it adds a new employee
                //here another method should be inserted to specify which data should be inserted.
                // duplicate id checker
                String sqlAdmin = "INSERT INTO employee_basic_details(id, First_Name, Middle_Name,Last_Name,Day_of_Birth," +
                        "Month_of_Birth,Year_of_Birth,Phone_Number,Marital_Status,Address,Start_Date_Day,Start_Date_Month," +
                        "Start_Date_Year,Employee_Type, Skills,Postal_Code,Department,Gender,Qualifications,Salary,Password,Email_Address) " +
                        "VALUES(02375, 'amanuel', 'shuge','grandf',12,9,1974,0963677822,'Male'," +
                        "'Addis_Ababa_4k',2,3,2024,'Fulltime','repairing computers',1234,'Electrical engineering','M','Highschool graduate', 1300,'"+hashpasdword.encode("12345f")+"', 'naruto@gmail.com')";
                        String sqladmin = "INSERT INTO employee_basic_details(id, First_Name, Middle_Name,Last_Name,Day_of_Birth," +
                        "Month_of_Birth,Year_of_Birth,Phone_Number,Marital_Status,Address,Start_Date_Day,Start_Date_Month," +
                        "Start_Date_Year,Employee_Type, Skills,Postal_Code,Department,Gender,Qualifications,Salary, Password) " +
                        "VALUES(" + mp.getId() + "," + mp.getFirst_name() + "," + mp.getMiddle_name() + "," + mp.getLast_name() + "," + mp.getBirth_day() + "," + mp.getBirth_month() + ","
                        + mp.getBirth_year() + "," + mp.getPhone_number() + "," + mp.getMarital_status() + "," + mp.getAddress() + "," + mp.getStart_date() + "," + mp.getStart_month() + "," +
                        mp.getStart_year() + "," + mp.getEmployee_type() + "," + mp.getSkills() + "," + mp.getPostal_code() + "," + mp.getDepartment() + "," + mp.getGender() + "," +
                        mp.getQualification() + "," + mp.getSalary() + ")";// this code is for admin to accept employee, so change the lower case to upper case whn needed
                String sqlRegistration="INSERT INTO `applicant basic details`(`temporary Id`,`First Name`, `Middle Name`, `Last Name`, Email, `Phone Number`,Country, " +
                        "`Day of Birth`, `Month of Birth`, `Year of Birth`, `Marital Status`, Gender,Password,Certificates,`Total Applicants`) VALUES("+"23"+", '"+mp.getFirst_name()+"', '"+mp.getMiddle_name()+"', '"+mp.getLast_name()+"', '"+mp.getEmail_address()+"', '"+mp.getPhone_number()+"', '"+
                        mp.getAddress()+"', "+mp.getBirth_day()+", "+mp.getBirth_month()+", "+mp.getBirth_year()+", '"+mp.getMarital_status()+"', '"+mp.getGender()+"','"+hashpasdword.encode(mp.getPassword())+"', '"+mp.getQualification()+"', "+ "1"+")";//WRITE A CODE OF automatic id provider
                //"(Deptid int not NULL, Department varchar(40), primary key(Deptid))";
                PasswordHash hashobject=new PasswordHash();
                // String retrieve="select * from"+mp.getTable_name();
                String retriever = "select * from employee_basic_details";
                ResultSet resultSet = statement.executeQuery(retriever);
                final var metaData = resultSet.getMetaData();
                resultSet = statement.executeQuery(retriever);
                //the below code  is checked for functioning.
                if(mp.getPassword().length() != 0) {// this code may result in an error when the password is inserted and data retrieving is called, so add another parramter if needed
                   // String adminEmail="naruto@gmail.com";
                    String adminPassw = "";
                    while (resultSet.next()) {

                        if (mp.getEmail_address().equals(resultSet.getString("Email_Address"))) {
                            int checkidentity=resultSet.getInt("Id");
                            if (checkidentity==3421){
                                adminPassw= resultSet.getString("Password");
                                System.out.println(hashpasdword.decode(adminPassw));
                            }

                        }
                    }
               // statement.executeUpdate(sqlAdmin);
                if (mp.getPassword().equals(adminPassw)){// admin id
                    statement.executeUpdate(sqlAdmin);
                }
                else{
                    statement.executeUpdate(sqlRegistration);

                }
            }}
            else if (value.equals("delete table")) {// make this accessible only to the admin
                String sqldrop = "drop table " + "worktime"; //+"table_name" emplbasicDetails"; concatenate the table name
                statement.executeUpdate(sqldrop);
            } else if (value.equals("edit your data")) {// worked
                // add a code to check whether it is an admin or employee and base the edit button on the decision
                System.out.print("what do you want to edit? ");// list of choices
                String data_type=scanner.nextLine();
                String[] forbiddenDataTypes={"Department","Employee_Type","salary","Start_Date_Day","Start_Date_Month","Start_Date_Year","End_Date_Day","End_Date_Month","End_Date_Year","Id"};
                for (int i=0;i<forbiddenDataTypes.length;i++){
                if(data_type.equals(forbiddenDataTypes[i])){
                    System.out.println("Sorry, you can't change these data");
                }
                else{
                    System.out.print("Type the edited version: ");
                    String edited=scanner.nextLine();
                    String edit = "update employee_basic_details set "+data_type+"='"+edited+"' where id=2375";
                    //String edit = "update employee_basic_details set"+" "+data_type+"= '"+edited+"' where id=2345";
                    statement.executeUpdate(edit);
                }}

            } else if (value.equals("update employee")) {

            }
             else if (value.equals("delete employee data")) {// checked. it deletes the data for a single employee. identfy th =e dah trh empoyee can edit
                String delete_emp_data = "delete from employee_basic_details where id=2010";
                statement.executeUpdate(delete_emp_data);
            } else if (value.equals("add column data")) {
                System.out.println("Choose the table: ");
                System.out.println("enter the column name: ");
                String columnName=scanner.nextLine();
                System.out.println("enter its type: ");
                String datatype=scanner.nextLine();
                System.out.println("enter its length: ");
                String dataLength=scanner.nextLine();
                String add_column = "ALTER TABLE employee_basic_details ADD "+columnName+" "+datatype+"("+dataLength+")";
                statement.executeUpdate(add_column);
            } else if (value.equals("create table")) {//the names must not have white space

                System.out.print("Enter a  name for the table: ");
                String tablename = scanner.nextLine();
                System.out.print("Enter the number of columns you wish to add into your table: ");
                int columns = Integer.parseInt(scanner.nextLine());
                mp.setTable_name(tablename);
                String column_name;
                String column_type;
                int size;
                String create_table = "";
                for (int i = 0; i < columns; i++) {
                    int count = i + 1;
                    System.out.print("Enter the name of the " + count + " column you wish to add: ");
                    column_name = scanner.nextLine();

                    System.out.print("Enter the datatype for the column: ");
                    column_type = scanner.nextLine();

                    System.out.print("Enter its size(maximum characters you wish it to contain): ");
                    size = Integer.parseInt(scanner.nextLine());
                    String comma_deleter;
                    if (i == columns - 1) {
                        comma_deleter = "";
                    } else {
                        comma_deleter = ",";
                    }
                    create_table = create_table + column_name + " " + column_type + " " + "(" + size + ")" + comma_deleter;// this needs to be fixed
                }
                String sqlt = "CREATE TABLE " + mp.getTable_name() + "(" + create_table + ")";
                System.out.print(sqlt);
                statement.executeUpdate(sqlt);}
             else if(value.equals("set adminsetdata")){
                System.out.print("set the maximum year: ");
                String ageMa=scanner.nextLine();
                System.out.print("Set the minimum year: ");
                String ageMi=scanner.nextLine();
                System.out.print("Set the age limit: ");
                String agelimit=scanner.nextLine();
                try {int agermax=Integer.parseInt(ageMa);
                    int agermin=Integer.parseInt(ageMi);}
                catch(IllegalArgumentException e){
                    System.out.println("Invalid entry! ");
                }
                 String sqlset="INSERT INTO Admin_Set_Data(Max_Applicant_No,Min_Applicant_No,Age_Limit) VALUES("+Integer.parseInt(ageMa)+","
                         +Integer.parseInt(ageMi)+", "+ Integer.parseInt(agelimit)+")";
                statement.executeUpdate(sqlset);
            }
             else if (value.equals("retrieve adminsetdata")){
                 String getdata="select * from Admin_Set_Data";
                 ResultSet resultSet=statement.executeQuery(getdata);
                 while (resultSet.next()){
                 mp.setMinimumAge(resultSet.getInt("Min_Applicant_Year"));
                 mp.setMaximumAge(resultSet.getInt("Max_Applicant_Year"));}

             }
             else if (value.equals("retrieve data for login")) {
PasswordHash hashobject=new PasswordHash();
                // String retrieve="select * from"+mp.getTable_name();
                String retrieve = "select * from employee_basic_details";
                ResultSet resultSet = statement.executeQuery(retrieve);
                final var metaData = resultSet.getMetaData();
                resultSet = statement.executeQuery(retrieve);
                //the below code  is checked for functioning.
                if(mp.getPassword().length() != 0) {// this code may result in an error when the password is inserted and data retrieving is called, so add another parramter if needed
                    String passdtb = "";
                    while (resultSet.next()) {

                        if (mp.getEmail_address().equals(resultSet.getString("Email_Address"))) {
                            passdtb = resultSet.getString("Password");
                        }
                    }


                    if (hashobject.decode(passdtb).equals(mp.getPassword())) {
                        loginvalue="Access Granted";
                    } else if (passdtb.length() == 0) {
                        loginvalue="you are not an employee of this company yet! ";
                    } else {
                        loginvalue="Access Denied";
                    }
                }
                //the below else if is to retrieve data of registered employee, but it is not complete yet.
                else if (value.equals("retrieve applicant data")){
                    while(resultSet.next()){
                        if(resultSet.getString("'First Name'").equals("John")){
                            String pass=resultSet.getString("Password");
                    }}

                }
                else if(value.equals("retrieve employee data")) {
                    System.out.print("Type the id or type NEXT to continue");

                    String temp_in = scanner.nextLine();
                    if (temp_in.equals("NEXT")) {
                        System.out.print("Do you want to access the name and id of all your employees?(YES/NO): ");
                        String intake = scanner.nextLine();

                        switch (intake) {
                            case "YES":
                                while (resultSet.next()) {
                                    //to retrieve the name and id of all employees
                                    System.out.println(resultSet.getInt("Id") + " " + resultSet.getString("First_Name") + " " + resultSet.getString("Middle_Name") + " " + resultSet.getString("Last_Name"));
                                }
                                break;

                            case "NO":
                                System.out.print("Do you want to access all the basic data about your employees?(YES/NO): ");
                                intake = scanner.nextLine();
                                if (intake.equals("YES")) {

                                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                                        if (metaData.getColumnName(i).equals("Password")) {
                                            continue;
                                        }
                                        System.out.print(resultSet.getMetaData().getColumnName(i) + "   ");
                                    }
                                    System.out.println();
                                    while (resultSet.next()) {
                                        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                                            if (metaData.getColumnName(i).equals("Password")) {
                                                continue;
                                            }
                                            System.out.print(resultSet.getObject(i) + "\t");
                                        }

                                        System.out.println();
                                    }
                                }
                                break;
                        }
                    } else {
                        while (resultSet.next()) {
                            int req_id = Integer.parseInt(temp_in);

                            if (req_id == resultSet.getInt("id")) {
                                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                                    if (metaData.getColumnName(i).equals("Password")) {
                                        continue;
                                    }
                                    System.out.println(metaData.getColumnName(i) + "   " + resultSet.getObject(i) + "\t");
                                }
                            }
                        }
                    }
                }
  /*  switch (temp_in){
        case "id":
            while (resultSet.next()){
int req_id=resultSet.getInt("id");
if (req_id==temp_in){
    for ()
}
            }
    }*/

          /*  while (resultSet.next()) {
                //to retrieve the name and id of all employees
                System.out.println(resultSet.getInt("Id") + " " +
                        resultSet.getString(2) + " " + resultSet.getString(3) + " "
                        + resultSet.getString(4)+" "+resultSet.getInt("Day_of_Birth")+" "+resultSet.getInt("Month_of_Birth")
                        +" "+resultSet.getInt("Year_of_Birth")+" "+resultSet.getInt("Phone_Number")+" "+resultSet.getString("Marital_Status")+" "+
                        resultSet.getString("Address")+" "+resultSet.getInt("Start_Date_Day")+" "+resultSet.getInt("Start_Date_Month")
                        +" "+resultSet.getInt("Start_Date_Year")+" "+resultSet.getInt("End_Date"));
            }*/


                resultSet.close();
            }
    statement.close();}

        catch (SQLException e) {
            throw new RuntimeException(e);
        }}
public String getLoginvalue(){
return loginvalue;}
}



