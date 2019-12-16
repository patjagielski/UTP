package Test;
import com.InputParser;
import com.Person;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.portable.InputStream;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.FileHandler;

import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {
    File file = new File("C:/Users/jagie/Desktop/TestUTP.txt");
    List<Person> temp;
    @Test
    void parse() throws IOException, ParseException {
        temp = InputParser.parse(file);
        //System.out.println(temp.size());

        assertEquals("Patrik ", temp.get(0).get_firstName());
        assertEquals("Jagielski ", temp.get(0).get_surname());
        assertEquals("1999-12-14", temp.get(0).get_birthdateAsString());
        File f = new File("C:/Users/jagie/Desktop/Tutp.txt");
        List<Person> nullTemp = InputParser.parse(f);
        assertNull(null, (Supplier<String>) nullTemp);

    }


}