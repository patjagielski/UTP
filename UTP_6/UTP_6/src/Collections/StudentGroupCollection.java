package Collections;

import Groups.StudentGroup;
import java.util.TreeSet;

public class StudentGroupCollection {
    static TreeSet<StudentGroup> studentGroupTreeSet = new TreeSet<>();
    public static   TreeSet<StudentGroup> getStudentGroupCollect() {
        return studentGroupTreeSet;
    }
}
