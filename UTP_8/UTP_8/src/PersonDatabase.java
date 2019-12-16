
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public final class PersonDatabase {
    List<Person> p;
   public PersonDatabase(List<Person> p){
        this.p = p;
    }


    // assignment 8 - factory method based on deserialization
    public static PersonDatabase deserialize(DataInputStream input) throws Assignment08Exception, IOException {
       Person p;
       ArrayList<Person> arrayList = new ArrayList<>();
       //PersonDatabase personDatabase = new PersonDatabase(arrayList);

       while (input.available()< 0){

           p = Person.deserialize(input);
           arrayList.add(p);
           System.out.println("Deserialization complete");
       }
       return new PersonDatabase(arrayList);

    }

    // assignment 8
    public void serialize(DataOutputStream output) throws Assignment08Exception {
        for (Person person: p) {
            person.serialize(output);
        }
      }


    // assignment 4
    public List<Person> sortedByFirstName() {
        return null;
    }

    // assignment 4
    public List<Person> sortedBySurnameFirstNameAndBirthdate() {
        return null;
    }

    // assignment 4
    public List<Person> sortedByBirthdate() {
        return null;
    }

    // assignment 4
    public List<Person> bornOnDay(Date date) {
        return null;
    }
}