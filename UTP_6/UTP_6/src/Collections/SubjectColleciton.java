package Collections;

import Groups.Subject;
import java.util.TreeSet;

public class SubjectColleciton {

    protected static TreeSet<Subject> subjectTreeSet = new TreeSet<>();
    public static TreeSet<Subject> getSubject() {
        return subjectTreeSet;
    }
}
