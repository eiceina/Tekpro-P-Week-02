// Department.java

package id.ac.polban.employee.model;

public class Department {
    private String name;

    // konstruktor
    public Department (String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
}
