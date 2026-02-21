// Employee.java

package id.ac.polban.employee.model;

public class Employee {
    private int id;
    private String name;
    private Department department;
    private EmploymentType type;
    private double salary;
    private static int count;

    // konstruktor
    public Employee (int id, String name, Department department, EmploymentType type, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.type = type;
        this.salary = salary;
        count();
    }

    public static void count() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmploymentType getType() {
        return type;
    }

   public void  setType(EmploymentType type) {
        this.type = type;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void tampilEmployee() {
        System.out.println("Id        : " + getId());
        System.out.println("Name      : " + getName());
        System.out.println("Department: " + department.getName());
        System.out.println("Type      : " + type.getType());
        System.out.println("Salary    : " + getSalary());
        System.out.println("--------------------------------------");
    }

    public static void tampilCountEmployee() {
        System.out.println("---------- Employee Total: " + Employee.getCount() + " ---------");
    }
}
