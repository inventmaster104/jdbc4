import java.util.ArrayList;
public class EmployeeManager {
    int base_salary;
        private ArrayList<EmployeeBasicDetails> employees = new ArrayList<>();
        private final int MAX_EMPLOYEES = 30;

        public void addEmployee(EmployeeBasicDetails e) {
            if (employees.size() >= MAX_EMPLOYEES) {
                System.out.println("❌ Limit reached! Maximum " + MAX_EMPLOYEES + " employees allowed.");
                return;
            }
    // Check for duplicate ID
        for (EmployeeBasicDetails emp : employees) {
        if (emp.getId() == e.getId()) {
            System.out.println("❌ Employee ID already exists!");
            return;
        }
    }

        employees.add(e);
        System.out.println("✅ Employee added successfully!");
}

public void viewAllEmployees() {
    if (employees.isEmpty()) {
        System.out.println("⚠️ No employees found.");
        return;
    }
    System.out.println("\n--- Employee List ---");
    for(EmployeeBasicDetails e : employees){
        e.display();
    }
}
// make the below code so that specific employe data can be updated
    public void updateEmployee(int id, String newFirstName,String newMiddleName,String newLast_Name , String newDepartment, double newSalary) {
        for (EmployeeBasicDetails e : employees) {
            if (e.getId() == id) {
                e.setFirst_name(newFirstName);
                e.setMiddle_name(newMiddleName);
                e.setLast_name(newLast_Name);
                e.setDepartment(newDepartment);
                e.setSalary(newSalary);
                System.out.println("✅ Employee updated successfully!");
                return;
            }
        }
        System.out.println("❌ Employee not found!");
    }

    public void deleteEmployee(int id) {
        for (EmployeeBasicDetails e : employees) {
            if (e.getId() == id) {
                employees.remove(e);
                System.out.println("🗑 Employee deleted successfully!");
                return;
            }
        }
        System.out.println("❌ Employee not found!");
    }
}

