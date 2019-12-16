package com.Company;

import java.lang.annotation.ElementType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public abstract class Person  {
    private LocalDate _dateOfBirth;
    private String _surname;
    private String _name;

    public Person(){}
    public Person(String surname, String name, LocalDate dateOfBirth){
        _name = name;
        _surname = surname;
        _dateOfBirth = dateOfBirth;

    }
    public String get_surname(){
        return _surname;
    }

    public String get_name() {
        return _name;
    }

    public Integer getAge(){
       LocalDate currentDate = LocalDate.now();
       return Period.between(_dateOfBirth, currentDate).getYears();
    }
    // (assignment 03)
    // methods:
    // * is older than other person
    public Boolean isOlder(Employee emp1){
        return this.getAge()>emp1.getAge();
    }
    // * is younger than other person
    public Boolean isYounger(Employee emp1){
        return this.getAge()<emp1.getAge();
    }

    // * compare age with other person's age
    public int compareAges(Person pers1){
        return pers1.getAge().compareTo(this.getAge());
    }


}
