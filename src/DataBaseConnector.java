


import java.sql.ResultSet;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;
public class DataBaseConnector {
   // write a code to accept an update from teh user
    EmployeeBasicDetails mp=new EmployeeBasicDetails();
    Scanner scanner=new Scanner(System.in);


// write a code to create a table
    public void dtcConnectmethod(String value){
        String url="jdbc:mysql://localhost:3306/jdbcTOP";
         String username="root";
         String password="KawqbBON89!!GA.HELLO";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

           // ResultSet resultSet=statement.executeQuery();

           //Resultset resultSet = statement.executeQuery("select * from employebasicdetails");

if (value.equals("add employee")){// checked and worked. it adds a new employee
    //here another method should be inserted to specify which data should be inserted.
                   String sql="INSERT INTO employee_basic_details(id, First_Name, Middle_Name,Last_Name,Day_of_Birth," +
                           "Month_of_Birth,Year_of_Birth,Phone_Number,Marital_Status,Address,Start_Date_Day,Start_Date_Month," +
                           "Start_Date_Year,Employee_Type, Skills,Postal_Code,Department,Gender,Qualifications,Salary) " +
                           "VALUES(02345, 'robsan', 'Ayele','grandf',12,9,1974,0963677822,'Male'," +
                           "'Addis_Ababa_4k',2,3,2024,'Fulltime','repairing computers',1234,'Electrical engineering','M','Highschool graduate', 1300)";
       String sqlinsert="INSERT INTO employee_basic_details(id, First_Name, Middle_Name,Last_Name,Day_of_Birth," +
               "Month_of_Birth,Year_of_Birth,Phone_Number,Marital_Status,Address,Start_Date_Day,Start_Date_Month," +
               "Start_Date_Year,Employee_Type, Skills,Postal_Code,Department,Gender,Qualifications,Salary) " +
               "VALUES("+mp.getid()+","+mp.getFirst_name()+","+mp.getMiddle_name()+","+mp.getLast_name()+","+mp.getBirth_day()+","+mp.getBirth_month()+","
    +mp.getBirth_year()+","+mp.getPhone_number()+","+mp.getMarital_status()+","+mp.getAddress()+","+mp.getStart_date()+","+mp.getStart_month()+","+
    mp.getStart_year()+","+mp.getEmployee_type()+","+mp.getSkills()+","+mp.getPostal_code()+","+mp.getDepartment()+","+mp.getGender()+","+
    mp.getQualification()+","+mp.getSalary()+")";
                           //"(Deptid int not NULL, Department varchar(40), primary key(Deptid))";
             statement.executeUpdate(sql);}
    else if(value.equals("delete table")){// make this accessible only to the admin
                   String sqldrop="drop table "+"worktime"; //+"table_name" emplbasicDetails"; concatenate the table name
                   statement.executeUpdate(sqldrop);}

    else if(value.equals("edit your data")){// worked
        String edit="update employee_basic_details set Last_Name= 'Dejene' where id=2345";
statement.executeUpdate(edit);
    }
    else if(value.equals("delete employee data")){// checked. it deletes the data for a single employee. identfy th =e dah trh empoyee can edit
        String delete_emp_data="delete from employee_basic_details where id=2010";
        statement.executeUpdate(delete_emp_data);
}
    else if (value.equals("create table")){//the names must not have white space

    System.out.print("Enter a  name for the table: ");
    String tablename=scanner.nextLine();
    System.out.print("Enter the number of columns you wish to add into your table: ");
    int columns=Integer.parseInt(scanner.nextLine());
    mp.setTable_name(tablename);
    String column_name;
    String column_type;
    int size;
    String create_table="";
    for (int i=0;i<columns;i++){
int count=i+1;
        System.out.print("Enter the name of the "+count+" column you wish to add: ");
        column_name=scanner.nextLine();

        System.out.print("Enter the datatype for the column: ");
        column_type=scanner.nextLine();

        System.out.print("Enter its size(maximum characters you wish it to contain): ");
        size=Integer.parseInt(scanner.nextLine());
String comma_deleter;
if(i==columns-1){
    comma_deleter="";
}
else{
    comma_deleter=",";
}
        create_table=create_table +column_name+" "+column_type+" "+"("+size +")"+comma_deleter;// this needs to be fixed
}
    String sqlt="CREATE TABLE "+ mp.getTable_name()+"("+create_table+")";
    System.out.print(sqlt);
     statement.executeUpdate(sqlt);

       }else if(value.equals("retrieve employee data")){
       // String retrieve="select * from"+mp.getTable_name();
    String retrieve="select * from employee_basic_details";
    ResultSet resultSet = statement.executeQuery(retrieve);
    final var metaData=resultSet.getMetaData();
    System.out.print("Type the id or type NEXT to continue");

    String temp_in=scanner.nextLine();
    if (temp_in.equals("NEXT")){
        System.out.print("Do you want to access the name and id of all your employees?(YES/NO): ");
        String intake=scanner.nextLine();

        switch(intake){
            case "YES":
            while (resultSet.next()) {
                //to retrieve the name and id of all employees
                System.out.println(resultSet.getInt("Id") + " " + resultSet.getString("First_Name") + " " + resultSet.getString("Middle_Name") + " " + resultSet.getString("Last_Name"));
            }break;

            case "NO":
            System.out.print("Do you want to access all the basic data about your employees?(YES/NO): ");
            intake = scanner.nextLine();
            if (intake.equals("YES")) {

                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    System.out.print(resultSet.getMetaData().getColumnName(i) + "   ");
                }
                System.out.println();
                while (resultSet.next()) {
                    for (int i = 1; i <= metaData.getColumnCount(); i++) {
                        System.out.print(resultSet.getObject(i) + "\t");
                    }

                    System.out.println();
                }}break;}}
else{
    while(resultSet.next()){
        int req_id=Integer.parseInt(temp_in);

            if(req_id==resultSet.getInt("id")){
                for(int i=1;i<=metaData.getColumnCount();i++){
           System.out.println(metaData.getColumnName(i)+"   "+resultSet.getObject(i)+"\t"); }}}}
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


    resultSet.close();}
    statement.close();}

        catch (SQLException e) {
            throw new RuntimeException(e);
        }}}



