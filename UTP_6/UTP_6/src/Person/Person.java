package Person;

import Generators.GenerateDOB;
import Generators.GeneratePesel;
import Collections.PersonCollection;

import java.io.*;
import java.text.Collator;
import java.time.LocalDate;
import java.util.*;

public abstract class Person implements Comparable<Person>, Comparator<Person> {
    private String _pesel;
    private String _firstName;
    private String _surname;
    private LocalDate _DOB;
    private Locale _nationality;
    protected Random random = new Random();
    static Collator def = Collator.getInstance(SetNationality.mapOfNationalities.get(Nationality.POLISH));
    Collator collator;
    Locale someLocale;
    Collator someCollator;


    public Person(String Pesel, String firstName, String surname, LocalDate DOB, Locale nationality) {
        this._pesel = Pesel;
        this._firstName = firstName;
        this._surname = surname;
        this._DOB = GenerateDOB.createTeacherDOB();
        this._nationality = nationality;
        // System.out.println(surname);

    }

    public Person() throws IOException {
        this._firstName = get_firstName();
        this._surname = get_surname();
        this._DOB = GenerateDOB.createTeacherDOB();
        this._nationality = SetNationality.mapOfNationalities.get(getNationality());
        this._pesel = GeneratePesel.create_Pesel(this);
        PersonCollection.getPersonSet().add(this);
        this.collator = Collator.getInstance(this._nationality);
    }

    public static Collator getDef() {
        return def;
    }

    public String get_pesel() throws IOException {
        return this._pesel;
    }

    public Boolean checkMale() throws IOException {
        if (get_firstName().endsWith("a")) {
            return false;
        }
        return true;
    }

    public String get_firstName() throws IOException {

        Nationality nationality = getNationality();
        File file = null;
        switch (nationality) {
            case GREEK:
                file = new File("C:/Users/jagie/Desktop/Greek_Names.txt");
                break;
            case FRENCH:
                file = new File("C:/Users/jagie/Desktop/French_Names.txt");
                break;
            case INDIAN:
                file = new File("C:/Users/jagie/Desktop/Indian_Names.txt");
                break;
            case POLISH:
                file = new File("C:/Users/jagie/Desktop/Polish_Names.txt");
                break;
            case BRITISH:
                file = new File("C:/Users/jagie/Desktop/British_Names.txt");
                break;
            case CHINESE:
                file = new File("C:/Users/jagie/Desktop/Chinese_Names.txt");
                break;
            case RUSSIAN:
                file = new File("C:/Users/jagie/Desktop/Russian_Names.txt");
                break;
            case SPANISH:
                file = new File("C:/Users/jagie/Desktop/Spanish_Names.txt");
                break;
            case JAPANESE:
                file = new File("C:/Users/jagie/Desktop/Japanese_Names.txt");
                break;
            case HUNGARIAN:
                file = new File("C:/Users/jagie/Desktop/Hungarian_Names.txt");
                break;
        }
        String line = "";
        Scanner scanner = new Scanner(file);
        int count = new Random().nextInt(5);
        int c2 = 0;
        while ((line = scanner.next()) != null) {
            if (c2++ == count) {
                return line.split(" ")[0];
            }
            //System.out.println(line);

        }
        return "";
    }

    public Nationality getNationality() {
        return Nationality.values()[random.nextInt(Nationality.values().length)];
    }

    public String get_surname() throws FileNotFoundException {
        Nationality nationality = getNationality();
        File file = null;
        switch (nationality) {
            case GREEK:
                file = new File("C:/Users/jagie/Desktop/Greek_Names.txt");
                break;
            case FRENCH:
                file = new File("C:/Users/jagie/Desktop/French_Names.txt");
                break;
            case INDIAN:
                file = new File("C:/Users/jagie/Desktop/Indian_Names.txt");
                break;
            case POLISH:
                file = new File("C:/Users/jagie/Desktop/Polish_Names.txt");
                break;
            case BRITISH:
                file = new File("C:/Users/jagie/Desktop/British_Names.txt");
                break;
            case CHINESE:
                file = new File("C:/Users/jagie/Desktop/Chinese_Names.txt");
                break;
            case RUSSIAN:
                file = new File("C:/Users/jagie/Desktop/Russian_Names.txt");
                break;
            case SPANISH:
                file = new File("C:/Users/jagie/Desktop/Spanish_Names.txt");
                break;
            case JAPANESE:
                file = new File("C:/Users/jagie/Desktop/Japanese_Names.txt");
                break;
            case HUNGARIAN:
                file = new File("C:/Users/jagie/Desktop/Hungarian_Names.txt");
                break;
        }
        String s1 = "";
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            s1 = scanner.next();
            //sp = s1.split(" ");

            return s1;
        }
        return s1;
    }

    public LocalDate get_DOB() {
        return _DOB;
    }

    ;

    public int get_Age() {
        int age = get_DOB().getYear() - LocalDate.now().getYear();
        return age;
    }


    @Override
    public int compareTo(Person person) {
        int x = def.compare(this._surname, person._surname);
        if (x == 0) {
            return this.get_DOB().compareTo(person._DOB);
        } else
            return x;
    }

    @Override
    public int compare(Person o1, Person o2) {
        o1.getNationality();
        o2.getNationality();
        someCollator = Collator.getInstance(someLocale);
        return someCollator.compare(o1._surname, o2._surname);
    }

    @Override
    public String toString() {
        return "Person{" +
                "_pesel='" + _pesel + '\'' +
                ", _firstName='" + _firstName + '\'' +
                ", _surname='" + _surname + '\'' +
                ", _DOB=" + _DOB +
                ", _nationality=" + _nationality +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(_pesel, person._pesel) &&
                Objects.equals(_firstName, person._firstName) &&
                Objects.equals(_surname, person._surname) &&
                Objects.equals(_DOB, person._DOB) &&
                _nationality == person._nationality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_pesel, _firstName, _surname, _DOB, _nationality);
    }


}

