import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class MyJdbc {
    public static void main(String[]args) throws ClassNotFoundException,SQLException{
        String url="jdbc:mysql://localhost:3306/jdbcTOP";
        String username="root";
        String password="KawqbBON89!!GA.HELLO";
            Connection connection=DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();

        Class.forName("com.mysql.cj.jdbc.Driver");


        ResultSet resultSet=statement.executeQuery("select * from Employee");
        while (resultSet.next()){
            System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
        }
        // the following code is to create table in the database;
       // String sql="create table EmplBasicDetails(Deptid int not NULL, Department varchar(40), primary key(Deptid))";
       // statement.executeUpdate(sql);
        String add="insert into employeebasicdetails(First_name)";
        System.out.println("operation successful");// if i run this program twice after i
        // have already created the  table, it will resul in error.
        // the following code is to delete a table in the database;
       // String sqldrop="drop table employee";// note that the drop keyword is written in small letters.
      //  statement.executeUpdate(sqldrop);
      //  System.out.println("operation successful");
        connection.close();


        //    System.out.println(e);
    }}

