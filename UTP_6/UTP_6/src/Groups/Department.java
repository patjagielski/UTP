package Groups;

import Collections.DepartmentCollection;
import Person.Teacher;

import java.util.*;

public class Department implements Comparable<Department> {

    protected String _deptName;
    List<Teacher> _listOfTeachers;
    static TreeSet<Department> listofDeps = DepartmentCollection.getDepartment();
    static int x = 0;

    public Department() {
        this._listOfTeachers = Teacher.teacherGenerate();
        this._deptName = "Dept: " + String.valueOf(x++);
        listofDeps.add(this);

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(_deptName, that._deptName) &&
                Objects.equals(_listOfTeachers, that._listOfTeachers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_deptName, _listOfTeachers);
    }


    @Override
    public String toString() {
        return super.toString();
    }


    @Override
    public int compareTo(Department o) {
        return this._deptName.compareTo(o._deptName);
    }
}
