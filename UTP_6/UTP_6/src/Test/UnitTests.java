package Test;

import Collections.DepartmentCollection;
import Collections.StudentGroupCollection;
import Generators.GenerateDOB;
import Generators.GeneratePesel;
import Groups.Department;
import Groups.StudentGroup;
import Groups.Subject;
import Person.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.Collator;
import java.util.Locale;
import java.util.TreeSet;

import static javax.swing.UIManager.get;
import static org.junit.jupiter.api.Assertions.*;

public class UnitTests {


    @Before
    public static void Generate() throws IOException {
        System.out.println("Generate");
        for (int i = 0; i < 100; i++) {
            new Student();
        }
        for (int i = 0; i < 12; i++) {
            new StudentGroup();
        }
        for (int i = 0; i < 10; i++) {
            new Teacher();
        }
        for (int i = 0; i < 3; i++) {
            new Department();
        }
        for (int i = 0; i < 10; i++) {
            new Subject();
        }
    }

    @Test
    public void checkEmpty() throws IOException {
        Generate();
        Assert.assertFalse(StudentGroupCollection.getStudentGroupCollect().isEmpty());

        Assert.assertFalse(DepartmentCollection.getDepartment().isEmpty());
    }

    @Test
    public void checkCollation() throws IOException {
        Generate();
        Assert.assertEquals(Collator.getInstance(SetNationality.mapOfNationalities.get(Nationality.POLISH)), Person.getDef());
    }


    @Test
    public void checkPesel() throws IOException {
        Generate();
        Student student = new Student();
        Assert.assertEquals(student.get_pesel().length(), 11);
    }
}

