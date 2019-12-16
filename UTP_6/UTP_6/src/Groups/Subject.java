package Groups;

import Person.Student;
import Person.Teacher;

import java.util.*;

public class Subject {
    protected Subjects subjectName;
    protected Department supDepartment;
    protected Teacher teacher;
    protected TreeSet<StudentGroup> studentGroup;
    protected Student somestudent;
    protected Random rand = new Random();


    public Subject() {
        this.subjectName = Subjects.values()[rand.nextInt(Subjects.values().length)];
        this.supDepartment = createOne();
        this.teacher = Teacher.genOneTeacher();
        this.studentGroup = StudentGroup.studentGroups;

    }

    public Department createOne() {
        Set<Department> dep = Department.listofDeps;
        List<Department> depts = new ArrayList<>(dep);
        Collections.shuffle(depts);
        return depts.get(0);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectName == subject.subjectName &&
                Objects.equals(supDepartment, subject.supDepartment) &&
                Objects.equals(teacher, subject.teacher) &&
                Objects.equals(studentGroup, subject.studentGroup) &&
                Objects.equals(somestudent, subject.somestudent) &&
                Objects.equals(rand, subject.rand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectName, supDepartment, teacher, studentGroup, somestudent, rand);
    }
}
