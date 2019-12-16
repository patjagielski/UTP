import java.io.*;
import java.time.LocalDate;
import java.util.Date;

public class Person implements Comparable<Person> {

    private final String _firstName;
    private final String _surname;
    private final Date _birthdate;

    public Person(String firstName, String surname, Date birthdate) {
        _firstName = firstName;
        _surname = surname;
        _birthdate = birthdate;
    }

    // assignment 8
    public void serialize(DataOutputStream output) throws Assignment08Exception {
        // serialize birth date with getTime() method
        // encapsulate IOException in Assignment08Exception
        Person object = new Person("Patrik", "Jagielski", getBirthDate());

        try {
            output.writeUTF(object._firstName);
            output.writeUTF(object._surname);
            output.writeLong(_birthdate.getTime());

            output.close();

            System.out.println("Object serialized successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person deserialize(DataInputStream input) throws Assignment08Exception {
        String a;
        String b;
        Long date;
        Person reObject = null;
        try {
            a = input.readUTF();
            b = input.readUTF();
            date = input.readLong();
            Date someDate = new Date(date);
            reObject = new Person(a, b, someDate);

            input.close();
            System.out.println("Object has been deserizlized!");
            System.out.println(reObject);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reObject;
    }

    @Override
    public int compareTo(Person o) {
        // TODO Auto-generated method stub
        return 0;
    }

    public String getFirstName() {
        return _firstName;
    }

    public String getSurname() {
        return _surname;
    }

    public Date getBirthDate() {
        return _birthdate;
    }

}