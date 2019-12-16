import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;


class PersonTest {
    Person p = new Person("Patrik", "Jagielski", new Date(1999, 1, 1));
    @Test
    public void serializeTest() throws IOException, Assignment08Exception {


        ArrayList<Person> g= new ArrayList<>();
        g.add(p);
        PersonDatabase personDatabase = new PersonDatabase(g);
        personDatabase.serialize(new DataOutputStream(new FileOutputStream("test.txt")));

    }

    @Test
    public void deserializeTest() throws IOException, Assignment08Exception {
        PersonDatabase personDatabase = null;
        personDatabase.deserialize(new DataInputStream(new FileInputStream("test.txt")));
    }
    @Test
    public void Test() throws IOException, Assignment08Exception {
        Person object;
        p.serialize(new DataOutputStream(new FileOutputStream("test.txt")));
        object = p.deserialize(new DataInputStream(new FileInputStream("test.txt")));
        Assert.assertEquals(p.getFirstName(), object.getFirstName());
    }


}