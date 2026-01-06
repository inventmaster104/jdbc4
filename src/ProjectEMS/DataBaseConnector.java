package ProjectEMS;// write a mysql code to add applicants
//write code to prevent duplicate creation of tables rows or  columns
// must delete teh phone number from the database because its datatype is not stri

import java.sql.ResultSet;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
public class DataBaseConnector implements DatabasemethodsInterface {
    private String setNotice;
    private String notice;
    private ArrayList<Integer> dayPresent=new ArrayList<Integer>();
    private int taskComplete;
    private String[] taskCol=new String[0];
    String[] taskInfo=new String[0];
    private String date;
    private String title;
    private String description;
    private String task;
    private String chek="Not Special";
    private static int loginid;
    private double totalTime;
    private String time;
    private String startTime;
    private String endTime;
    static String name;
    private String [] AsetData=new String[0];
    private String tempAdmin="";
    private String[] ewordData=new String[0];
    private int maxData=0;
    private int maxApp=0;
private String totalA;
    int count=0;
    private String [] Etitles=new String[0];
    private String vacanyadd="";
    private String[] Atitles=new String[0];
    private String sqladmin="";
    private int minYear;
    private int Ayear=0;
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
    private String adminChecker="Not admin";
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
    private boolean admintrue=true;
    private String edited="";
    private String data_type="";

   // write a code to accept an update from teh user

   // ProjectEMS.EmployeeAdmin adminversion=new ProjectEMS.EmployeeAdmin();
    //ProjectEMS.EmployeeBasicDetails mp=adminversion.registerEmployee();
    Scanner scanner=new Scanner(System.in);
    PasswordHash hashpasdword=new PasswordHash();
EmployeeBasicDetails dt=new EmployeeBasicDetails();
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



    private String editData(String id, String datatype, String edited){
        this.edited=edited;
        this.data_type=datatype;
    try{int n=Integer.parseInt(edited);
    double d=Double.parseDouble(edited);
        String edit = "update employee_work_details set"+" "+data_type+"= "+edited+" where id="+id;
        return edit;
    }
    catch(IllegalArgumentException e){ String edit = "update employee_work_details set"+" "+data_type+"= '"+edited+"' where id="+id;
        return edit;}


    }
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
               if(admintrue==true){ if (chek.equals("special")){
                   sqladmin = "INSERT INTO special_table(`First_Name`, `Middle_Name`, `Last_Name`, `Day_of_Birth`,`Month_of_Birth`,`Year_of_Birth`, Phone_Number, " +
                           "Marital_Status, Employee_Type, Skills, Postal_Code,Country,City,Kebele, Gender,Qualifications,Email_Address,Password) VALUES("+"'"+mp.getFirst_name()+"', '"+mp.getMiddle_name()+"', '"+mp.getLast_name()+"', "+mp.getBirth_day()+", "+mp.getBirth_month()+", "+
                           mp.getBirth_year()+", '"+mp.getPhone_number()+"', '"+mp.getMarital_status()+"', '"+mp.getEmployee_type()+"', '"+mp.getSkills()+"', "+mp.getPostal_code()+",'"+mp.getCountry()+"', '"+mp.getCity()+"', '"+mp.getKebele()+"','"+mp.getGender()+"','"+mp.getQualification()+"','"+mp.getEmail_address()+"','"+  mp.getPassword()+"')";count=1;}
               else{sqladmin = "INSERT INTO employee_basic_details(`First_Name`, `Middle_Name`, `Last_Name`, `Day_of_Birth`,`Month_of_Birth`,`Year_of_Birth`, Phone_Number, " +
                       "Marital_Status, Employee_Type, Skills, Postal_Code,Country,City,Kebele, Gender,Qualifications,Email_Address,Password) VALUES("+"'"+mp.getFirst_name()+"', '"+mp.getMiddle_name()+"', '"+mp.getLast_name()+"', "+mp.getBirth_day()+", "+mp.getBirth_month()+", "+
                       mp.getBirth_year()+", '"+mp.getPhone_number()+"', '"+mp.getMarital_status()+"', '"+mp.getEmployee_type()+"', '"+mp.getSkills()+"', "+mp.getPostal_code()+",'"+mp.getCountry()+"', '"+mp.getCity()+"', '"+mp.getKebele()+"','"+mp.getGender()+"','"+mp.getQualification()+"','"+mp.getEmail_address()+"','"+  mp.getPassword()+"')";count=1;}}
                   // this code is for admin to accept employee, so change the lower case to upper case whn needed
               else  {sqladmin="INSERT INTO `applicant basic details`(`First Name`, `Middle Name`, `Last Name`, `Day of Birth`,`Month of Birth`,`Year of Birth`, Phone_Number, " +
                        "Marital_Status, Employee_Type, Skills, Postal_Code,Country,City,Kebele, Gender,Qualifications,Email,Password) VALUES("+"'"+mp.getFirst_name()+"', '"+mp.getMiddle_name()+"', '"+mp.getLast_name()+"', "+mp.getBirth_day()+", "+mp.getBirth_month()+", "+
                        mp.getBirth_year()+", '"+mp.getPhone_number()+"', '"+mp.getMarital_status()+"', '"+mp.getEmployee_type()+"', '"+mp.getSkills()+"', "+mp.getPostal_code()+",'"+mp.getCountry()+"', '"+mp.getCity()+"', '"+mp.getKebele()+"','"+mp.getGender()+"','"+mp.getQualification()+"','"+mp.getEmail_address()+"','"+  mp.getPassword()+"')";}

                //"(Deptid int not NULL, Department varchar(40), primary key(Deptid))";*/
                PasswordHash hashobject = new PasswordHash();
                // String retrieve="select * from"+mp.getTable_name();
                String retriever = "select * from employee_basic_details";
                ResultSet resultSet = statement.executeQuery(retriever);
                final var metaData = resultSet.getMetaData();
                resultSet = statement.executeQuery(retriever);

                statement.executeUpdate(sqladmin);


                if(count==1){result = "added successfully";}else{result="registered successfully";}

            }
            else if(value.equals("setNotice")){
                String sql="ALTER TABLE admin_set_data set Notice="+setNotice;
            }
            else if(value.equals("add new title")){
                String sql="INSERT INTO admin_set_data (AllTitles) VALUES('"+title+"')";
                statement.executeUpdate(sql);
                result="Added successfully";
            }
            else if(value.equals("add task")){
                String sql="INSERT INTO tasks( employee_Id, Title, Description,Due_Date,Status) VALUES("+id+",'"+title+"','"+
                        description+"','"+java.sql.Date.valueOf(date)+"',"+"'Pending')";
                statement.executeUpdate(sql);
                result="set Successfully";
            }
            else if(value.equals("setTotalTime")){
                System.out.println("set calculate time check");
                String tot="update attendance_details set Total_Time="+totalTime+" where End_Time='"+endTime+"'";
                statement.executeUpdate(tot);
            }
            else if(value.equals("calculate time")){

                if (!(adminChecker.equals("Admin"))){//i changed the statement from id checker to string checker
                    id=String.valueOf(loginid);
                }
                String calc="select * from attendance_details where Id='"+id+"'";
                ResultSet resultSet=statement.executeQuery(calc);
                while(resultSet.next()){
                    String stime=resultSet.getString("Start_Time");
                    String etime=resultSet.getString("End_Time");
                    int Y1=Integer.parseInt(stime.substring(0,4));
                    int M1=Integer.parseInt(stime.substring(5,7));
                    int D1=Integer.parseInt(stime.substring(8,10)) ;
                    double h1=Double.parseDouble(stime.substring(11,13));
                    double m1=Double.parseDouble(stime.substring(14,16))/60.0;
                    double s1=Double.parseDouble(stime.substring(17))/3600.0;

                    int Y2=Integer.parseInt(etime.substring(0,4));
                    int M2=Integer.parseInt(etime.substring(5,7));
                    int D2=Integer.parseInt(etime.substring(8,10)) ;
                    double h2=Double.parseDouble(etime.substring(11,13));
                    double m2=Double.parseDouble(etime.substring(14,16))/60.0;
                    double s2=Double.parseDouble(etime.substring(17))/3600.0;
                    if(Y1==Y2 && D1==D2 && M1==M2){
                        totalTime+=(h2-h1)+(m2-m1)+(s2-s1);
                        if(!(dayPresent.contains(D1))){
                            dayPresent.add(D1);
                        }

                        System.out.println("calculate time check");
                    }

                }
                dtcConnectmethod(new EmployeeBasicDetails(),"setTotalTime");

            }
            else if(value.equals("addWorkDetails")){
                System.out.println(id);
                String sql="INSERT INTO employee_work_details(id) VALUES("+Integer.parseInt(id)+")";
                statement.executeUpdate(sql);
            }
            else if(value.equals("getEid")){
                String sql="select Id from employee_basic_details where Email_Address='"+mp.getEmail_address()+"'";
                ResultSet resultSet=statement.executeQuery(sql);
                while(resultSet.next()){
                    id=String.valueOf(resultSet.getInt("Id"));
                }
            }else if(value.equals("getStartTime")){
                String sql="select Start_Time from attendance_details";
                ResultSet resultSet=statement.executeQuery(sql);
                while(resultSet.next()){
                    startTime=resultSet.getString("Start_Time");
                }
            }
            else if(value.equals("setTime")){
                System.out.println(startTime);
                if(time.equals("Start")){String etimesql="INSERT INTO attendance_details(Id,Start_Time) VALUES("+loginid+",'"+startTime+"')";
                statement.executeUpdate(etimesql);
                }

                if(time.equals("End")){
                    System.out.println("the end time is: "+endTime);
                    System.out.println("The start time is: "+startTime);
                    dtcConnectmethod(new EmployeeBasicDetails(),"getStartTime");
                    String stimesql="update attendance_details set End_Time='"+endTime+"' where Start_Time='"+startTime+"'";
                    statement.executeUpdate(stimesql);
                }


            }
            else if(value.equals("setWorkDetails")){
                String data_type="";
                String edited="";
                String edits="update employee_work_details set "+data_type+"='"+edited+"' where id="+id;
                String edit = "update employee_work_details set"+" "+data_type+"= "+edited+" where id="+id;
                double i1=mp.getSalary();int i2=mp.getStart_date(); int i3=mp.getStart_month(); int i4=mp.getStart_year(); int i5=mp.getEnd_date();
                int i6= mp.getEnd_month(); int i7=mp.getEnd_year(); String dpt=mp.getDepartment();
              /*  String set="INSERT INTO employee_work_details(id,Salary,Start_Date, Start_Month,Start_Year, End_Date,End_Month,End_Year,Department) " +
                        "VALUES("+Integer.parseInt(id)+","+mp.getSalary()+","+mp.getStart_date()+","+mp.getStart_month()+","+mp.getStart_year()+","+mp.getEnd_date()+","+
                        mp.getEnd_month() +","+mp.getEnd_year()+",'"+mp.getDepartment()+"'"+")";*/
               if(i1!=0){
                   edited=String.valueOf(i1);
                   data_type="Salary";
                   statement.executeUpdate(editData(id,data_type,edited));
               }
                if(i2!=0){
                    edited=String.valueOf(i2);
                    data_type="Start_Date";
                    statement.executeUpdate(editData(id,data_type,edited));
                }
                if(i3!=0){
                    edited=String.valueOf(i3);
                    data_type="Start_Month";
                    statement.executeUpdate(editData(id,data_type,edited));
                }
                if(i4!=0){
                    edited=String.valueOf(i4);
                    data_type="Start_Year";
                    statement.executeUpdate(editData(id,data_type,edited));
                }
                if(i5!=0){
                    edited=String.valueOf(i5);
                    data_type="End_Date";
                    statement.executeUpdate(editData(id,data_type,edited));
                }
                if(i6!=0){
                    edited=String.valueOf(i6);
                    data_type="End_Month";
                    statement.executeUpdate(editData(id,data_type,edited));
                }
                if(i7!=0){
                    edited=String.valueOf(i7);
                    data_type="End_Year";
                    statement.executeUpdate(editData(id,data_type,edited));
                }
                if(dpt.length()!=0){
                    edited=dpt;
                    data_type="Department";
                    statement.executeUpdate(editData(id,data_type,edited));
                }

                result="set successfully";
            }
            else if(value.equals("getsetMaxApplications")){
                maxData=0;
                String sql="select MaxApplications from admin_set_data where Id=1";
                ResultSet resultSet= statement.executeQuery(sql);
                while (resultSet.next()){
                    maxData=resultSet.getInt("MaxApplications");
                }

            }
            else if(value.equals("setMaxApplications")){

                String sql="update admin_set_data set MaxApplications="+maxApp+" where Id=1";
               statement.executeUpdate(sql);
               result="successfully set";

            }
            else if (value.equals("getMaxApplications")){
                String sql="select count(Email) from `applicant basic details`";
                ResultSet resultSet=statement.executeQuery(sql);
                while(resultSet.next()){totalA=resultSet.getString("count(Email)");}

            }
            else if(value.equals("setAdminTitles")){
                String sql="insert into admin_set_data(Vacancies) VALUES(+'"+vacanyadd+"')";
                statement.executeUpdate(sql);
                result="successfully added";

            }
            else if(value.equals("get all E titles")){
                Atitles=new String[0];
               ids=new String[0];
                String sql="select * from admin_set_data";
                ResultSet resultSet=statement.executeQuery(sql);
                while(resultSet.next()){
                    if((resultSet.getString("AllTitles")==null)){
                        continue;
                    }
                    else{
                        String id[]=new String[ids.length+1];
                        String[] temp=new String[Atitles.length+1];
                        for(int i=0;i<Atitles.length;i++){
                            temp[i]=Atitles[i];
                        }
                        temp[Atitles.length]=resultSet.getString("AllTitles");
                        Atitles=temp;
                        for(int j=0;j<ids.length;j++){
                            id[j]=ids[j];
                        }
                        id[ids.length]=String.valueOf(resultSet.getInt("Id"));
                        ids=id;}}}
            else if(value.equals("getAdminTitles")){
                ids=new String[0];
                Etitles=new String[0];
                String sql="select * from admin_set_data";
                ResultSet resultSet=statement.executeQuery(sql);
                while(resultSet.next()){
                    if((resultSet.getString("Vacancies")==null)){
                        continue;
                    }
                    else{
                        String[] temp1=new String[ids.length+1];
                        String[] temp=new String[Etitles.length+1];
                        for(int i=0;i<Etitles.length;i++){
                            temp[i]=Etitles[i];
                            temp1[i]=ids[i];
                        }
                        temp1[ids.length]=String.valueOf(resultSet.getInt("Id"));
                        temp[Etitles.length]=resultSet.getString("Vacancies");
                        ids=temp1;
                        Etitles=temp;

                    }
                }

            }else if(value.equals("get maxYear")){
                Ayear=0;
                String sql="select Max_Applicant_Year from admin_set_data where Id=1";
                ResultSet resultSet=statement.executeQuery(sql);
                while(resultSet.next()){
                    Ayear=resultSet.getInt("Max_Applicant_Year");
                }
            }
            else if (value.equals(registrationst)) {

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

            } else if (value.equals("Check Registration")) {
                String check = "select RegistrationStatus from admin_set_data where Id=1";
                ResultSet resultSet = statement.executeQuery(check);
                while (resultSet.next()) {
                    result = resultSet.getString("RegistrationStatus");
                }
            }
             else if (value.equals("edit your data")) {// worked
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

            }

                    else if (value.equals("delete applicant/employee data")) {// checked. it deletes the data for a single employee. identfy th =e dah trh empoyee can edit
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
                            String[] temptable = new String[tableNames.length+1];
                            //tableNames = newtable;
                            for (int m=0;m<tableNames.length;m++){
                                temptable[m]=tableNames[m];
                            }
                            temptable[tableNames.length]=metaData.getColumnName(i);
                            tableNames=temptable;
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
            }
            // retrieving section
            else if(value.equals("getNotice")){
                String sql="select Notice from admin_set_data";
                ResultSet resultSet=statement.executeQuery(sql);
                while(resultSet.next()){
                    if ((resultSet.getString("Notice"))!=null){
                        notice=resultSet.getString("Notice");
                    }
                }
            }
            else if(value.equals("retrieve workDetails")){
                ewordData=new String[0];
                ecolumnNames=new String[0];
                String sql="select * from employee_work_details where id="+id;
                ResultSet resultSet=statement.executeQuery(sql);
                final var metaData=resultSet.getMetaData();
                while(resultSet.next()){
                    for(int i=1;i<metaData.getColumnCount();i++){
                        if (metaData.getColumnName(i).equals("CV")){
                            continue;
                        }
                        else{String col=metaData.getColumnName(i);
                            Object data=resultSet.getObject(i);
                            String dta=""+data;
                            String[] temp=new String[ecolumnNames.length+1];
                            for(int j=0;j<ecolumnNames.length;j++){
                            temp[j]=ecolumnNames[j];
                            }
                            temp[ecolumnNames.length]=col;
                            ecolumnNames=temp;
                            String[] temp2=new String[ewordData.length+1];
                            for (int k=0;k<ewordData.length;k++){
                                temp2[k]=ewordData[k];
                            }
                            temp2[ewordData.length]=dta;
                            ewordData=temp2;
                        }


                    }

                }
            }
            else if (value.equals("applcnto data")) {
                applicantdt=new String[0];
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
                                String temp[] =new String[applicantdt.length+1];
                                for (int j=0;j<applicantdt.length;j++){
                                    temp[j]=applicantdt[j];
                                   }
                                temp[applicantdt.length]=String.valueOf(resultSet.getObject(i));
                                applicantdt=temp;
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

            }
            else if (value.equals("adminSetDt")){
                AsetData=new String[0];
                String sql="select * from Admin_Set_Data";
                ResultSet resultSet=statement.executeQuery(sql);
                final var metaData=resultSet.getMetaData();
                while(resultSet.next()){

                     if (tempAdmin.equals("getDepartment")&& resultSet.getString("Department")!=null){
                         String temp[]= new String[AsetData.length+1];
                         for (int j=0;j<AsetData.length;j++){
                           temp[j]=AsetData[j];
                         }
                         temp[AsetData.length]=resultSet.getString("Department");
                         AsetData=temp;}


                }
            }else if (value.equals("retrieve employee data for deleting")) {
                Names=new String[0];
                employeeEml=new String[0];
                String retrieve = "select * from employee_basic_details";
                ResultSet resultSet = statement.executeQuery(retrieve);
                final var metaData = resultSet.getMetaData();
                while (resultSet.next()) {
                    //to retrieve the name and id of all employees
                    String name =( (String)(resultSet.getObject("First_Name"))) + " " + resultSet.getString("Middle_Name") + " " + resultSet.getString("Last_Name");
                    String eml = resultSet.getString("Email_Address");
                    String[] n = new String[Names.length + 1];// to initiallize the arrays name and email
                    for (int i = 0; i < Names.length; i++) {
                        n[i] = Names[i];
                    }
                    n[Names.length] = name;
                    Names = n;
                    String[] e = new String[employeeEml.length + 1];
                    for (int i = 0; i < employeeEml.length; i++) {
                        e[i] = employeeEml[i];
                    }
                    e[employeeEml.length] = eml;
                    employeeEml = e;
                }
            }
            else if(value.equals("getTasks")){
                taskCol=new String[0];        taskInfo=new String[0];       taskComplete=0;
                String sql="select * from tasks where employee_id="+loginid;
                ResultSet resultSet=statement.executeQuery(sql);
                final var metaData=resultSet.getMetaData();
                for (int m=1;m<=metaData.getColumnCount();m++){
                    String temp2[]=new String[taskCol.length+1];
                    for (int k=0;k<taskCol.length;k++){
                        temp2[k]=taskCol[k];}
                    temp2[taskCol.length]=metaData.getColumnName(m);
                    taskCol=temp2;}

                while (resultSet.next()){
for (int j=1;j<=metaData.getColumnCount();j++){
    String temp[]=new String[taskInfo.length+1];
    for(int i=0;i<taskInfo.length;i++){
        temp[i]=taskInfo[i];
    }
     temp[taskInfo.length]=String.valueOf(resultSet.getObject(j));
        taskInfo=temp;
}
                    if(resultSet.getString("Status").equals("Complete"))
                    {taskComplete+=1;}




                }
            }
            else if (value.equals("retrieve applicant")) {
                Names=new String[0];
                Emails=new String[0];
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
                            name=resultSet.getString("First_Name");



                            if (hashobject.decode(passdtb).equals(mp.getPassword())) {
                                loginvalue = "Access Granted";
                                loginid = resultSet.getInt("Id");
                                adminChecker=resultSet.getString("Employee_Type");


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
            else if(value.equals("retrieve work details")){
                ecolumnNames=new String[0];
                ewordData=new String[0];
                boolean check=true;
                String sql="select * from employee_work_details";
                ResultSet resultSet=statement.executeQuery(sql);
                final var metaData=resultSet.getMetaData();
                while(resultSet.next()){

                    for(int i=2;i<metaData.getColumnCount();i++){
                        if (resultSet.getObject(i)==null){


                            String[] temp=new String[ewordData.length+1];
                            for (int k=0;k<ewordData.length;k++){
                                temp[k]=ewordData[k];
                            }
                            temp[ewordData.length]="None";
                            ewordData=temp;

                        }
                        else{
                            String[] temp=new String[ewordData.length+1];
                            for (int k=0;k<ewordData.length;k++){
                               temp[k]=ewordData[k];
                            }
                            temp[ewordData.length]=String.valueOf(resultSet.getObject(i));
                            ewordData=temp;

                        }
if (check==true){String coln=metaData.getColumnName(i);

    String[] c=new String[ecolumnNames.length+1];

    for (int a=0;a<ecolumnNames.length;a++){
        c[a]=ecolumnNames[a];
    }
    if(coln.equals("CV") || coln.equals("Id")){
        continue;
    }
    else{c[ecolumnNames.length]=coln;
        ecolumnNames=c;
    }}








                    }check=false;
                }
            }
            //the below else if is to retrieve data of registered employee, but it is not complete yet.
            else if (value.equals("retrieve applicant data")) {
                Emails=new String[0];
                Names=new String[0];
                String[] t=new String[0];
                Emails=t;
                String retrieve = "select * from `applicant basic details`";
                ResultSet resultSet = statement.executeQuery(retrieve);
                while (resultSet.next()) {

                        String pass = resultSet.getString("Email");
                    System.out.println("hi");

                        String fname=resultSet.getString("First Name");
                        String middlename=resultSet.getString("Middle Name");
                        String lastname=resultSet.getString("Last Name");
                    String[] tempe=new String[Emails.length+1];
                    String[] namee=new String[Names.length+1];
                    for (int i=0;i<Emails.length;i++){
                        tempe[i]=Emails[i];

                        namee[i]=Names[i];
                    }

                    tempe[Emails.length]=pass;
                    namee[Names.length]=fname+" "+middlename+" "+lastname;
                    Names=namee;
                    Emails=tempe;

                }

            } else if (value.equals("getDepartment")){
                Atitles=new String[0];
                String sql="select AllTitles from admin_set_data";
                ResultSet resultSet=statement.executeQuery(sql);
                while(resultSet.next()){
                    if((resultSet.getString("AllTitles"))!=null){
                        String[] temp=new String[Atitles.length+1];
                        for (int i=0;i< Atitles.length;i++){
                            temp[i]=Atitles[i];
                        }
                        temp[Atitles.length]=resultSet.getString("AllTitles");
                        Atitles=temp;
                    }
                }
            }
            else if (value.equals("delete job title")) {
                String sql="update admin_set_data set AllTitles=null where Id="+id;
                statement.executeUpdate(sql);

            } else if (value.equals("delete vacancy")){
                String sql="update admin_set_data set Vacancies=null where Id="+id;
                statement.executeUpdate(sql);
                result="deleted successfully";

            }
            else if (value.equals("retriev employee datal")) {
                employeeEml=new String[0];
                ecolumnNames=new String[0];
                ids=new String[0];
                empdatas=new String[0];
                viewEmployeeName=clearData();
                String retrieve = "select * from employee_basic_details";
                ResultSet resultSet = statement.executeQuery(retrieve);
                final var metaData=resultSet.getMetaData();
                System.out.println("gurwa");
                System.out.println(temp_in);
                switch (temp_in) {
                    case "View id, name and email":
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
if(resultSet.getString("Employee_Type").equals("Admin")){
    continue;
}
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
    public int getAdminsetMaxYear(){
    return Ayear;
    }
    public int getMinYear(){
    return minYear;
    }
    public void setAdmintrue(boolean admintrue){
    this.admintrue=admintrue;
    }
    public String[] getAtitles(){

    return Atitles;
    }
    public void setVacanyadd(String add){
    vacanyadd=add;
    }
    public String[] getEtitles(){

    return  Etitles;
    }
    public void setMaxApp(int maxApp){
    this.maxApp=maxApp;}
    public String gettotalA(){

    return  totalA;
    }
    public String[] getAsetData(){
    return AsetData;
    }
    public void setTempAdmin(String t){
    tempAdmin=t;
    }
    public int getMaxData(){
    return maxData;
    }
    public String [] getEwordData(){
    return ewordData;
    }
public String getloginName(){
    return name;
}
public String getEndTime(){
    return endTime;
}
public void setStartTime(String time){
    startTime=time;
}
public void setEndTime(String time){
    endTime=time;
}
public void setTime(String time){
    this.time=time;
}
public void setChek(String c){
    chek=c;
}
public void setTitle(String t){
    title=t;
}
public void setDescription(String d){
    description=d;
}
public void setDate(String date){
    this.date=date;
}
public void setTask(String task){
    this.task=task;
}
public String[] getTaskInfo(){
    return taskInfo;
}
public String[] getTaskCol(){
    return taskCol;
}
public int getdaysPresent(){return dayPresent.size();}
    public String getNotice(){
    return notice;
    }
    public void setNotice(String notice) {
        this.setNotice = notice;
    }
public int getTaskComplete(){return taskComplete;}
public String getStartTime() {
    return startTime;
}}



