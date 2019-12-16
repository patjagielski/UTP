package Groups;

import Collections.StudentGroupCollection;
import Person.Student;


import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class StudentGroup implements Comparable<StudentGroup> {
    private static int _id = 0;
    private String _groupNumber;
    protected List<Student> studentseperate;
    static TreeSet<StudentGroup> studentGroups = StudentGroupCollection.getStudentGroupCollect();
    protected StudentGroup student;

    public StudentGroup() {

        this.studentseperate = Student.generateStudent();
        this._groupNumber = "Group: " + String.valueOf(_id++);
        studentGroups.add(this);

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGroup that = (StudentGroup) o;
        return _id == that._id &&
                _groupNumber == that._groupNumber &&
                Objects.equals(studentseperate, that.studentseperate) &&
                Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, _groupNumber, studentseperate, student);
    }

    @Override
    public int compareTo(StudentGroup o) {
        return this._groupNumber.compareTo(o._groupNumber);
    }
}
