// EmployeeMain.java

import id.ac.polban.employee.model.Department;
import id.ac.polban.employee.model.Employee;
import id.ac.polban.employee.model.EmploymentType;
import id.ac.polban.employee.service.EmployeeService;

public class EmployeeMain {
    public static void main(String[] args) {
        Department department1 = new Department("IT");
        Department department2 = new Department("Finance");
        Department department3 = new Department("Marketing");

        EmploymentType type1 = new EmploymentType("Freelance");
        EmploymentType type2 = new EmploymentType("Full-Time");
        EmploymentType type3 = new EmploymentType("Part-Time");

        // menggunakan konstruktor langsung karena objek dari Employee adalah individu
        Employee employee1 = new Employee(1235, "Kusmini Indah", department1, type3, 2000000);
        Employee employee2 = new Employee(1234, "Ridwan Saguna", department3, type1, 1500000);
        Employee employee3 = new Employee(9876, "Ilham Septya", department2, type2, 4000000);

        Employee.tampilCountEmployee();
        System.out.println("========== Employee Details ==========");
        employee1.tampilEmployee();
        employee2.tampilEmployee();
        employee3.tampilEmployee();

        EmployeeService service = new EmployeeService();
        service.addEmployee(employee1);
        service.addEmployee(employee2);
        service.addEmployee(employee3);

        service.raiseSalary(9876, 30);
        service.raiseSalary(1234, 25);

        System.out.println("======== After raising Salary ========");
        System.out.println("30% for Ilham Septya");
        employee3.tampilEmployee();
        System.out.println("25% for Ridwan Saguna");
        employee2.tampilEmployee();
    }
}
