package com.Company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Trainee extends Employee {
    protected LocalDate practiceStart;


    public Trainee(String name, String surname, LocalDate dateOfBirth, BigDecimal sal, Manager manager, LocalDate practiceStart){
        super(surname, name, dateOfBirth, sal,  manager );
        this.practiceStart = practiceStart;
    }

    public LocalDate getPracticeStart() {
        return practiceStart;
    }

    public Integer getPracticeLength() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(practiceStart, currentDate).getDays();
    }

    // (assignment 03)
    // * practice length is shorter than given number of days
    public Boolean isShorter(int numOfDays, Trainee trainee) {
        return this.getPracticeLength()<numOfDays;
    }
    // * practice length is longer than given number of days
        public Boolean isLonger(int numOfDays) {
            return this.getPracticeLength() > numOfDays;
        }
}
