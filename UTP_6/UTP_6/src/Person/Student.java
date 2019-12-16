package Person;

import Collections.StudentCollection;
import Generators.GeneratePesel;
import Person.Person;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Student extends Person {
    private static int id = 0;
    private String _studentID;
    protected static StudentCollection studentCollection = new StudentCollection();


    public Student() throws IOException {
        super();
        this._studentID = "s" + String.valueOf(id++);
        studentCollection.getStudentCollect().add(this);

    }
    public static List<Student> generateStudent(){
        List<Student> studentList = new ArrayList<Student>(studentCollection.getStudentCollect());
        //System.out.println(StudentCollection.getStudentCollect().size());
        Collections.shuffle(studentList);
        return new ArrayList<Student>(studentList.subList(0,10));
    }
    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + _studentID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return _studentID == student._studentID ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), _studentID);
    }

    @Override
    public int compareTo(Person person) {
        return super.compareTo(person);
    }
}
