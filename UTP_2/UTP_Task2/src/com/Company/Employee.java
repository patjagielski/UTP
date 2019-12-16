package com.Company;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee extends Person{

    private BigDecimal _sal;
    private Manager _manager;



    public Employee(String name, String surname, LocalDate dateOfBirth, BigDecimal sal, Manager manager){
        super(surname, name, dateOfBirth);
        _sal = sal;
        _manager = manager;
    }


    public Employee(){}
    public BigDecimal get_sal(){
        return _sal;
    }
    public BigDecimal set_sal(BigDecimal b){
        this._sal=b;
        return b;
    }

    public Manager get_manager() {
        return _manager;
    }



    // (assignment 03)
    // methods:
    // * salary is greater than given amount of money
    public Boolean salGreater(BigDecimal x){
        return (this._sal.compareTo(x)>0);
    }

    // * salary is less than given amount of money
    public Boolean salLess(BigDecimal x){
       return (this._sal.compareTo(x)<0);
    }

    // * compare salary with other employee salary
    public Employee compareSal(Employee x, Employee y){
        BigDecimal sal1 = x.get_sal();
        BigDecimal sal2 = y.get_sal();
        if (sal1.compareTo(sal2)>0){
            return x;
        }else
            return y;
    }

}
