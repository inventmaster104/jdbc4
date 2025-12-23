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
public class DataBaseConnector implements  DatabasemethodsInterface{
    private String [] empdatas=new String[0];
    private String id;// to allow the admin to set an employee id to search spceific employee
    private String registrationst;
    private String employeeEmail; // to set the email of an accepted employee
    private String[] applicantdt=new String[18];
    private String takenemail;
    private String[] Emails=new String[0];
    private String[] employeeEml=new String[0];
    private String[] ids=new String[0];
    private String[] viewEmployeeName=new String[0];
    private static String result="unsuccessful, please try again";
    private String colDatatype;
    private String ColumnLength;
    private String adminChecker;
    private String loginvalue;
    private String loginpassw="";
    private String loginEmail="";
    private String chooseTable;
    private String query;
    private String newCol;
    private String[] Names=new String[0];
    private String[] ecolumnNames=new String[0];
    private String[] emals;
    private String[] tableNames=new String[0];
    private String [][][] idemailname=new String[0][0][0];
    private String registrationCheck;
    private String temp_in="";// to take input from the admin about his employee view choice

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
                        "'Addis_Ababa_4k',2,3,2024,'Fulltime','repairing computers',1234,'Electrical engineering','M','Highschool graduate', 1300,'" + hashpasdword.encode("12345f") + "', 'naruto@gmail.com')";
                String sqladmin = "INSERT INTO employee_basic_details(First_Name, Middle_Name,Last_Name,Day_of_Birth," +
                        "Month_of_Birth,Year_of_Birth,Phone_Number,Marital_Status,Address,Start_Date_Day,Start_Date_Month," +
                        "Start_Date_Year,Employee_Type, Skills,Postal_Code,Department,Gender,Qualifications, Email_Address, Password) " +
                        "VALUES('" + mp.getFirst_name() + "','" + mp.getMiddle_name() + "','" + mp.getLast_name() + "'," + mp.getBirth_day() + "," + mp.getBirth_month() + ","
                        + mp.getBirth_year() + "," + mp.getPhone_number() + ",'" + mp.getMarital_status() + "','" + mp.getAddress() + "'," + mp.getStart_date() + "," + mp.getStart_month() + "," +
                        mp.getStart_year() + ",'" + mp.getEmployee_type() + "','" + mp.getSkills() + "'," + mp.getPostal_code() + ",'" + mp.getDepartment() + "','" + mp.getGender() + "','" +
                        mp.getQualification() + "','" + mp.getEmail_address() + "','" + mp.getPassword() + "')";// this code is for admin to accept employee, so change the lower case to upper case whn needed
              /*  String sqlRegistration="INSERT INTO `applicant basic details`(`Id`,`First Name`, `Middle Name`, `Last Name`, Email, `Phone_Number`,Address, " +
                        "`Day of Birth`, `Month of Birth`, `Year of Birth`, `Marital Status`, Gender,Password,Certificates,`Total Applicants`) VALUES("+"23"+", '"+mp.getFirst_name()+"', '"+mp.getMiddle_name()+"', '"+mp.getLast_name()+"', '"+mp.getEmail_address()+"', '"+mp.getPhone_number()+"', '"+
                        mp.getAddress()+"', "+mp.getBirth_day()+", "+mp.getBirth_month()+", "+mp.getBirth_year()+", '"+mp.getMarital_status()+"', '"+mp.getGender()+"','"+mp.getPassword()+"', '"+mp.getQualification()+"', "+ "1"+")";//WRITE A CODE OF automatic id provider
                //"(Deptid int not NULL, Department varchar(40), primary key(Deptid))";*/
                PasswordHash hashobject = new PasswordHash();
                // String retrieve="select * from"+mp.getTable_name();
                String retriever = "select * from employee_basic_details";
                ResultSet resultSet = statement.executeQuery(retriever);
                final var metaData = resultSet.getMetaData();
                resultSet = statement.executeQuery(retriever);
                statement.executeUpdate(sqladmin);
                result = "added successfully";
                //the below code  is checked for functioning.
              /*  if(mp.getPassword().length() != 0) {// this code may result in an error when the password is inserted and data retrieving is called, so add another parramter if needed
                   // String adminEmail="naruto@gmail.com";
                    String adminPassw = "";
                    while (resultSet.next()) {

                        if (applicantdt[17].equals(resultSet.getString("Email_Address"))|| mp.getEmail_address().equals(resultSet.getString("Email_Address"))) {
                            int checkidentity=resultSet.getInt("Id");
                            if (checkidentity==3421){
                                String Admminpas= resultSet.getString("Password");
                               adminPassw=hashpasdword.decode(Admminpas);
                            }

                        }
                    }
               // statement.executeUpdate(sqlAdmin);
                if (mp.getPassword().equals(adminPassw)){// admin id
                    statement.executeUpdate(sqlAdmin);
                }
                else{
                    System.out.println("error");
                   // statement.executeUpdate(sqlRegistration);

                }
            }*/
            } else if (value.equals(registrationst)) {

                String sql = "select RegistrationStatus from admin_set_data where Id=1";
                String s1 = "";
                String close = "update admin_set_data set RegistrationStatus= 'Close' where Id=1";
                String open = "update admin_set_data set RegistrationStatus= 'Open' where Id=1";
                ResultSet resultSet = statement.executeQuery(sql);
                final var metaData = resultSet.getMetaData();
                if (registrationst.equals("Close")) {

                    while (resultSet.next()) {
                        s1 = resultSet.getString("RegistrationStatus");
                    }
                    //System.out.println(s1==null);
                    // System.out.println(s1.equals(registrationst));
                    if (s1 != null && s1.equals(registrationst)) {
                        result = "It is already closed";
                    } else {
                        statement.executeUpdate(close);
                        result = "registration closed";
                    }


                } else if (registrationst.equals("Open")) {
                    while (resultSet.next()) {
                        s1 = resultSet.getString("RegistrationStatus");
                    }
                    if (s1 != null && s1.equals(registrationst)) {
                        result = "It is already open";
                    } else {
                        statement.executeUpdate(open);
                        result = "Registration Opened";
                    }

                }
               /* while(resultSet.next()){
                    for (int i=1;i<metaData.getColumnCount();i++){
                        if(metaData.getColumnName(i).equals("RegistrationStatus")){
                            if(resultSet.getString(i)!=null){
                            registrationCheck=resultSet.getString(i);}
                        }
                    }
                }*/

            } else if (value.equals("Check Registration")) {
                String check = "select RegistrationStatus from admin_set_data where Id=1";
                ResultSet resultSet = statement.executeQuery(check);
                while (resultSet.next()) {
                    result = resultSet.getString("RegistrationStatus");
                }
            } else if (value.equals("delete table")) {// make this accessible only to the admin
                String sqldrop = "drop table " + "worktime"; //+"table_name" emplbasicDetails"; concatenate the table name
                statement.executeUpdate(sqldrop);
            } else if (value.equals("edit your data")) {// worked
                // add a code to check whether it is an admin or employee and base the edit button on the decision
                System.out.print("what do you want to edit? ");// list of choices
                String data_type = scanner.nextLine();
                String[] forbiddenDataTypes = {"Department", "Employee_Type", "salary", "Start_Date_Day", "Start_Date_Month", "Start_Date_Year", "End_Date_Day", "End_Date_Month", "End_Date_Year", "Id"};
                for (int i = 0; i < forbiddenDataTypes.length; i++) {
                    if (data_type.equals(forbiddenDataTypes[i])) {
                        System.out.println("Sorry, you can't change these data");
                    } else {
                        System.out.print("Type the edited version: ");
                        String edited = scanner.nextLine();
                        String edit = "update employee_basic_details set " + data_type + "='" + edited + "' where id=2375";
                        //String edit = "update employee_basic_details set"+" "+data_type+"= '"+edited+"' where id=2345";
                        statement.executeUpdate(edit);
                    }
                }

            } else if (value.equals("update employee")) {

            } else if (value.equals("delete employee data")) {// checked. it deletes the data for a single employee. identfy th =e dah trh empoyee can edit
                if (takenemail != null) {
                    if (takenemail.length() != 0) {
                        String delete_emp_data = "delete from `applicant basic details` where Email='" + takenemail + "'";
                        statement.executeUpdate(delete_emp_data);
                    }
                } else if (employeeEmail.length() != 0) {
                    String delete_emp_data = "delete from employee_basic_details where Email_Address='" + employeeEmail + "'";
                    statement.executeUpdate(delete_emp_data);
                    result = "Employee deleted successfully";
                } else {
                    result = "Employee doesn't exist";

                }
            } else if (value.equals("retrieve table name")) {
                String retrieve = "select * from admin_set_data";
                ResultSet resultSet = statement.executeQuery(retrieve);
                final var metaData = resultSet.getMetaData();

                int count = 1;
                while (resultSet.next()) {

                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        if (metaData.getColumnName(i).equals("TableName")) {
                            String[] newtable = new String[count];
                            String[] temptable = tableNames;
                            tableNames = newtable;
                            for (int j = 0; j < tableNames.length; j++) {
                                if (j == (tableNames.length - 1)) {
                                    tableNames[j] = resultSet.getString("TableName") + "   ";
                                    System.out.println(tableNames[j]);
                                } else {
                                    tableNames[j] = temptable[j];
                                }

                            }
                            count += 1;
                        }
                    }
                }
                System.out.println(tableNames.length);
                for (int i = 0; i < tableNames.length; i++) {
                    System.out.println(tableNames[i]);
                }
            } else if (value.equals("add column")) {


                //newCol="enter the column name: ";
                String tablechosen = "select * from " + chooseTable;
                System.out.println("enter its length: ");
                System.out.println(chooseTable);
                System.out.println(colDatatype);
                System.out.println(newCol);
                System.out.println(ColumnLength);
                // String dataLength=scanner.nextLine();
                String add_column = "ALTER TABLE " + chooseTable + " " + "ADD COLUMN " + newCol + " " + colDatatype + "(" + ColumnLength + ")";
                statement.executeUpdate(add_column);
                result = "Successfully added";
            } else if (value.equals("create table")) {//the names must not have white space
// the table name cannot be duplicated
                System.out.print("Enter a  name for the table: ");
                String tablename = scanner.nextLine();
                System.out.print("Enter the number of columns you wish to add into your table: ");
                statement.executeUpdate("INSERT INTO admin_set_data(TableName) VALUES('" + tablename + "')");
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
                statement.executeUpdate(sqlt);
            } else if (value.equals("set adminsetdata")) {
                System.out.print("set the maximum year: ");
                String ageMa = scanner.nextLine();
                System.out.print("Set the minimum year: ");
                String ageMi = scanner.nextLine();
                System.out.print("Set the age limit: ");
                String agelimit = scanner.nextLine();
                try {
                    int agermax = Integer.parseInt(ageMa);
                    int agermin = Integer.parseInt(ageMi);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid entry! ");
                }
                String sqlset = "INSERT INTO Admin_Set_Data(Max_Applicant_No,Min_Applicant_No,Age_Limit) VALUES(" + Integer.parseInt(ageMa) + ","
                        + Integer.parseInt(ageMi) + ", " + Integer.parseInt(agelimit) + ")";
                statement.executeUpdate(sqlset);
            } else if (value.equals("applcnto data")) {
                System.out.println("hello");
                String retrieve = "select * from `applicant basic details`";
                ResultSet resultSet = statement.executeQuery(retrieve);
                final var metaData = resultSet.getMetaData();
                resultSet = statement.executeQuery(retrieve);
                String email = takenemail;
                while (resultSet.next()) {
                    System.out.println(email.equals(resultSet.getString("Email")));
                    System.out.println(email);
                    System.out.println(resultSet.getString("Email"));

                    if (email.equals(resultSet.getString("Email"))) {
                        System.out.println("reached");
                        for (int i = 1; i <= metaData.getColumnCount(); i++) {
                            // if (metaData.getColumnName(i).equals("Password")) {
                            //   continue;
                            // }
                            // System.out.println((String)(resultSet.getObject(i)));
                            if (metaData.getColumnName(i).equals("Id")) {
                                continue;
                            } else {
                                applicantdt[i] = String.valueOf(resultSet.getObject(i));
                            }

                        }
                    }
                }
            } else if (value.equals("retrieve adminsetdata")) {
                String getdata = "select * from Admin_Set_Data";
                ResultSet resultSet = statement.executeQuery(getdata);
                while (resultSet.next()) {
                    mp.setMinimumAge(resultSet.getInt("Min_Applicant_Year"));
                    mp.setMaximumAge(resultSet.getInt("Max_Applicant_Year"));
                }

            } else if (value.equals("retrieve employee data for deleting")) {
                String retrieve = "select * from employee_basic_details";
                ResultSet resultSet = statement.executeQuery(retrieve);
                final var metaData = resultSet.getMetaData();
                while (resultSet.next()) {
                    //to retrieve the name and id of all employees
                    String name = resultSet.getString("First_Name") + " " + resultSet.getString("Middle_Name") + " " + resultSet.getString("Last_Name");
                    String eml = resultSet.getString("Email_Address");
                    String[] n = new String[Names.length + 1];// to initiallize the arrays name and email
                    for (int i = 0; i < Names.length; i++) {
                        n[i] = Names[i];
                    }
                    n[Names.length] = name;
                    Names = n;
                    String[] e = new String[Emails.length + 1];
                    for (int i = 0; i < Emails.length; i++) {
                        e[i] = Emails[i];
                    }
                    e[Emails.length] = eml;
                    Emails = e;
                }
            } else if (value.equals("retrieve applicant")) {
                String retrieve = "select * from `applicant basic details`";
                ResultSet resultSet = statement.executeQuery(retrieve);
                final var metaData = resultSet.getMetaData();
                // resultSet = statement.executeQuery(retrieve);

                while (resultSet.next()) {
                    //to retrieve the name and id of all employees
                    String name = resultSet.getString("First Name") + " " + resultSet.getString("Middle Name") + " " + resultSet.getString("Last Name");
                    String eml = resultSet.getString("Email");
                    String[] n = new String[Names.length + 1];
                    for (int i = 0; i < Names.length; i++) {
                        n[i] = Names[i];
                    }
                    n[Names.length] = name;
                    Names = n;
                    String[] e = new String[Emails.length + 1];
                    for (int i = 0; i < Emails.length; i++) {
                        e[i] = Emails[i];
                    }
                    e[Emails.length] = eml;
                    Emails = e;
                }
            } else if (value.equals("retrieve data for login")) {
                PasswordHash hashobject = new PasswordHash();
                // String retrieve="select * from"+mp.getTable_name();
                String retrieve = "select * from employee_basic_details";
                ResultSet resultSet = statement.executeQuery(retrieve);
                final var metaData = resultSet.getMetaData();
                resultSet = statement.executeQuery(retrieve);
                //the below code  is checked for functioning.
                if (mp.getPassword().length() != 0) {// this code may result in an error when the password is inserted and data retrieving is called, so add another parramter if needed
                    String passdtb = "";
                    while (resultSet.next()) {

                        if (mp.getEmail_address().equals(resultSet.getString("Email_Address"))) {
                            passdtb = resultSet.getString("Password");


                            if (hashobject.decode(passdtb).equals(mp.getPassword())) {
                                loginvalue = "Access Granted";
                                int checkidentity = resultSet.getInt("Id");
                                if (checkidentity == 3421) {
                                    adminChecker = "RealAdmin";
                                    //System.out.println(hashpasdword.decode(adminPassw));
                                }
                            }

                        }
                    }


                    if (passdtb.length() == 0) {
                        loginvalue = "you are not an employee of this company yet! ";
                    } else if (!(passdtb.length() == 0) && !(hashobject.decode(passdtb).equals(mp.getPassword()))) {
                        loginvalue = "Access Denied";
                    }
                }
            }
            //the below else if is to retrieve data of registered employee, but it is not complete yet.
            else if (value.equals("retrieve applicant data")) {
              /*  ecolumnNames=clearData();
                ids=clearData();
                empdatas=clearData();
                viewEmployeeName=clearData();*/

                String retrieve = "select * from employee_basic_details";
                ResultSet resultSet = statement.executeQuery(retrieve);
                while (resultSet.next()) {
                    if (resultSet.getString("Email").equals("")) {
                        String pass = resultSet.getString("Password");
                    }
                }

            } else if (value.equals("retriev employee datal")) {
                ecolumnNames=clearData();
                ids=clearData();
                empdatas=clearData();
                viewEmployeeName=clearData();
                String retrieve = "select * from employee_basic_details";
                ResultSet resultSet = statement.executeQuery(retrieve);
                final var metaData=resultSet.getMetaData();
                //  result="Type the id or type NEXT to continue";

                //String temp_in = scanner.nextLine();

                //  System.out.print("Do you want to access the name and id of all your employees?(YES/NO): ");
                // String intake = scanner.nextLine();
                System.out.println("gurwa");
                System.out.println(temp_in);
                switch (temp_in) {
                    case "View id, name and email":
                        //String retrieve="select * from employee_basic_details";
                        // ResultSet resultSet=statement.executeQuery(retrieve);
                        //  final var metaData=resultSet.getMetaData();
                        while (resultSet.next()) {
                            System.out.println("hi");
                            //to retrieve the name and id of all employees
                            String name = resultSet.getString("First_Name") + " " + resultSet.getString("Middle_Name") + " " + resultSet.getString("Last_Name");
                            String eml = resultSet.getString("Email_Address");
                            String id = String.valueOf(resultSet.getInt("Id"));
                            String[] n = new String[viewEmployeeName.length + 1];// to initiallize the arrays name and email
                            for (int i = 0; i < viewEmployeeName.length; i++) {
                                n[i] = viewEmployeeName[i];
                            }
                            n[viewEmployeeName.length] = name;
                            viewEmployeeName = n;
                            String[] e = new String[employeeEml.length + 1];
                            for (int i = 0; i < employeeEml.length; i++) {
                                e[i] = employeeEml[i];
                            }
                            e[employeeEml.length] = eml;
                            employeeEml = e;
                            String[] i = new String[ids.length + 1];
                            for (int f = 0; f < ids.length; f++) {
                                i[f] = ids[f];
                            }
                            i[ids.length] = id;
                            ids = i;

                        }
                        break;
                    case "View Specific Employee":

                        while (resultSet.next()) {
                            int req_id = Integer.parseInt(id);

                            if (req_id == resultSet.getInt("id")) {
                                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                                    if (metaData.getColumnName(i).equals("Password")) {
                                        continue;
                                    }
                                    String[] col=new String[ecolumnNames.length+1];
                                    for(int m=0;m<ecolumnNames.length;m++){
                                        col[m]=ecolumnNames[m];
                                    }
                                    col[ecolumnNames.length]=metaData.getColumnName(i);
                                    ecolumnNames=col;
                                    String[] nms=new String[empdatas.length+1];
                                    for(int n=0;n<empdatas.length;n++){
                                        nms[n]=empdatas[n];
                                    }
                                    nms[empdatas.length]=String.valueOf(resultSet.getObject(i)) ;
                                    empdatas=nms;
                                    //System.out.println(metaData.getColumnName(i) + "   " + resultSet.getObject(i) + "\t");
                                }
                            }
                        }

                 /*   case "NO":// not to be implemented due to large number of data
                        String intake;
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
                        }*/
                        break;
                }
                resultSet.close();
            }
            //   else if(value.equals("EmployeeColumnName")){
            //     final var metaData=
            //  }





    statement.close();}

        catch (SQLException e) {
            throw new RuntimeException(e);
        }}
    public String[] getChoosetable(){
    return tableNames;
    }
    public String getNewCol(){
    return newCol;
    }
public String getLoginvalue(){
return loginvalue;}
    public String getAdminChecker(){
return adminChecker;}
    public void setTableNames(String name){
    chooseTable=name;
    }
    public void setNewCol(String c){
    newCol=c;
    }
    public void setColumnLength(String length){
    ColumnLength=length;
    }
    public void setColDatatype(String colDatatype){
    this.colDatatype=colDatatype;
    }
    public String getResult(){
    return result;
    }
    public void setChooseTable(String chooseTable){
    this.chooseTable=chooseTable;
    }
    public String[] getViewEmployeeName(){
    return viewEmployeeName;
    }
    public String[] getApplicantName(){
    return Names;
    }
    public String[] getApplicantEmail(){
    return  Emails;
    }
    public void setTakenemail(String email){
    takenemail=email;
    }
    public String[] getApplicantdt(){
    return applicantdt;
    }
    public void setEmployeeEmail(String Em){
    employeeEmail=Em;
    }
    public String getRegistrationStatus(){
    return registrationCheck;
    }
    public void setRegistrationstOpen(){
    registrationst="Open";
    }
    public void setRegistrationstClose(){
    registrationst="Close";
    }
    public String[] getIds(){
    return ids;}
    public String getRegistrationst(){
    return registrationst;
    }
    public void setTemp_in(String ino){
    temp_in=ino;
    }
    public String[] getEmployeeEml(){
    return  employeeEml;
    }
    public String[] getEcolumnNames(){
    return ecolumnNames;
    }
    public void setId(String id){
    this.id=id;
    }
    public String [] getEmpdatas(){
    return empdatas;
    }
}



