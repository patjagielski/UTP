package Test;

import com.InputParser;
import com.Person;
import com.PersonDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PersonDatabaseTest {
    private static List<Person> tempFirstName = new ArrayList<>();
    private static List<Person> tempPersonInfo = new ArrayList<>();
    private static List<Person> tempBirthdate = new ArrayList<>();
    String[] personFirstName = {"Patrik ", "Pmtrik "};
    String[] personInfo = {"Jagielski Pmtrik 1998-12-14", "Jagielski Patrik 1999-12-14"};
    String[] personBirthdate = {"1998-12-14", "1999-12-14"};
    @BeforeEach
    void beforeEach() throws IOException, ParseException {
        File file = new File("C:/Users/jagie/Desktop/TestUTP.txt");
        List<Person> personList = InputParser.parse(file);
        PersonDatabase personDatabase = new PersonDatabase(personList);
        tempFirstName = personDatabase.sortedByFirstName();
        tempPersonInfo = personDatabase.sortedBySurnameFirstNameAndBirthdate();
        tempBirthdate = personDatabase.sortedByBirthdate();

    }

    @Test
    void sortedByFirstName(){
        assertArrayEquals(personFirstName, tempFirstName.stream().map(Person::get_firstName).toArray());
    }

    @Test
    void sortedBySurnameFirstNameAndBirthdate(){
        assertArrayEquals(personInfo,
                tempPersonInfo.stream()
                .map(Person::get_SurnameFirstBirth)
                .toArray());
    }
    @Test
    void sortedByBirthdate(){
        assertArrayEquals(personBirthdate,
                tempBirthdate.stream()
                .map(Person::get_birthdateAsString)
                .toArray());

    }

    @Test
    void bornOnDay(){
        assertArrayEquals(personBirthdate, tempBirthdate.stream().map(Person::get_birthdateAsString).toArray());


    }

}