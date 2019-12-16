package com;

import com.Person;

import java.util.*;
import java.util.stream.Collectors;

public final class PersonDatabase {
    List<Person> input = new ArrayList<>();
    public PersonDatabase(List<Person> input){
        this.input = input;
        mapper = input.stream().collect(Collectors.groupingBy(Person::get_birthdate, Collectors.toList()));
    }
    Map<Date, List<Person>> mapper;



    public List<Person> sortedByFirstName() {
       return input.stream().sorted(new FirstNameComparator()).collect(Collectors.toList());

    }

    public List<Person> sortedBySurnameFirstNameAndBirthdate() {
        input.sort(new FirstNameComparator().thenComparing(Person::get_surname).thenComparing(new BirthdateComparator()));
        return input;
    }

    public List<Person> sortedByBirthdate() {
        input.sort(new BirthdateComparator());
        return input;
    }

    public List<Person> bornOnDay(Date date) {
        return mapper.get(date);
    }
}