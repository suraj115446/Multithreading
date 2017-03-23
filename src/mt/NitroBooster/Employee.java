package mt.NitroBooster;

import mt.Colors;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Created by srawa5 on 3/17/2017.
 */
public class Employee implements Serializable, Comparable<Employee>, Comparator<Employee>  {

    private int empId;
    private String empName;
    private String designation;

    public Employee(int empId, String empName, String designation) {
        this.empId = empId;
        this.empName = empName;
        this.designation = designation;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getEmpName().compareTo(o2.getEmpName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId &&
                Objects.equals(empName, employee.empName) &&
                Objects.equals(designation, employee.designation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, empName, designation);
    }

    @Override
    public int compareTo(Employee o) {
        return this.getEmpName().compareTo(o.getEmpName());
    }
}
