package ProjectEMS;

public interface DatabasemethodsInterface {
    EmployeeBasicDetails det=new EmployeeBasicDetails();
    DataBaseConnector con=new DataBaseConnector();
    default String[] getEColumnName(){
       con.dtcConnectmethod(det,"EmployeeColumnName");

       String[] columns=con.getEcolumnNames();
        System.out.println(columns[2]);
       return columns;
    }
    default String[] clearData(){
        return new String[0];
    }
}
