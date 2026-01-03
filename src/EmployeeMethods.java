import ProjectEMS.EmployeeBasicDetails;

public interface EmployeeMethods {
     EmployeeBasicDetails eType=new EmployeeBasicDetails();// in case i need it.
    default void evaluatePerformance(){

    };//
    default void assignRole(){

    };
    default void calculateSalary(){};
    default void requestLeave(){};
    default void approveLeave(){};
     String rejectLeave();
     void attendaceIn();
     double attendanceOut();
    public String promote();// i think this should be used somewhere else
    public void terminateEmployment();
    public void getTrainingHistory();
    public void trackDisciplinaryAction();
public void getAttendanceReport();
}
