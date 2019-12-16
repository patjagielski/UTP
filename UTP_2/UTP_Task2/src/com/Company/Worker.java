package com.Company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Worker extends Employee {

    private LocalDate _empDate;
    private BigDecimal _bonus;

        public Worker(String name, String surname, LocalDate empDate, BigDecimal sal,BigDecimal bonus, Manager manager){
            super(surname, name, empDate, sal, manager);
           if(bonus == null){
               this._bonus=BigDecimal.ZERO;
           }
          else{
              this._bonus=bonus;
           }
          this._empDate = empDate;
        }
        public LocalDate get_empDate(){

            return _empDate;
        }

         public BigDecimal get_bonus() {
        return _bonus;
    }

         public BigDecimal get_salWithBonus(){
            return get_sal().add(_bonus);
        }

        public int Seniority(){
            return Period.between(LocalDate.now(), this.get_empDate()).getYears();
        }
    // (assignment 03)
    // attributes:
    // * has bonus
    //
    // methods:
    // * seniority is longer than given number of years (seniority - sta¿)
    public Boolean seniorityIsLongerThanGivenYears(int years) {
        return Seniority()>years;
    }

    // * seniority is longer than given number of months
    public Boolean seniorityIsLongerThanGivenMonths( int months){
            return (Seniority()/12)>months;
    }

    public Boolean seniorityIsLessThanGivenYears(int years){
           return Seniority()<years;
    }

    // * has bonus greater than given amount of money
    public Boolean bonusGreaterThanGivenMoney(Worker worker, BigDecimal money) {
            return (worker.get_bonus().compareTo(money)>0);

        }




}
