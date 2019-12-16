package com;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class Person implements Comparable<Person> {

    private final String _firstName;
    private final String _surname;
    private final Date _birthdate;

    public Person(String firstName, String surname, Date birthdate) {
        _firstName = firstName;
        _surname = surname;
        _birthdate = birthdate;

    }

    public String get_firstName(){
        return _firstName;
    }
    public String get_surname(){
        return _surname;
    }
    public String get_birthdateAsString(){
        String dob;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        dob = format.format(_birthdate);
        return dob;
    }
    public Date get_birthdate(){
        return _birthdate;
    }

    public String get_SurnameFirstBirth(){
        return get_surname()  + get_firstName() + get_birthdateAsString();
    }

    @Override
    public int compareTo(Person otherPerson) {
        return Comparator.comparing(Person::get_birthdateAsString)
                .thenComparing(Person::get_firstName)
                .thenComparing(Person::get_surname)
                .compare(this, otherPerson);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(_firstName, person._firstName) &&
                Objects.equals(_surname, person._surname) &&
                Objects.equals(_birthdate, person._birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_firstName, _surname, _birthdate);
    }
}