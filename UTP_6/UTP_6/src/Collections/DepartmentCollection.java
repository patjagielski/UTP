package Collections;

import Groups.Department;

import java.util.TreeSet;

public class DepartmentCollection  {
    public static TreeSet<Department> departmentSet = new TreeSet<>();
    public static TreeSet<Department> getDepartment() {
        return departmentSet;
    }

}
