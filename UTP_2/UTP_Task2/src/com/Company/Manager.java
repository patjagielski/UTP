package com.Company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Manager extends Worker{
        private ArrayList<Employee> immediateSubordinates;
        public Manager(String name, String surname, LocalDate empDate, BigDecimal sal,BigDecimal bonus, Manager manager) {
                super(surname, name, empDate, sal, bonus, manager);
        }

        public ArrayList<Employee>getImmediateSubordinates(){
                return immediateSubordinates;
        }


        public ArrayList<Employee>getAllSubordinates(){
                ArrayList<Employee> allSubordinates = new ArrayList<>(immediateSubordinates);
                immediateSubordinates.stream()
                        .forEach(employee -> {
                                if(employee instanceof Manager){
                                        Manager manager = (Manager) employee;
                                     allSubordinates.addAll(manager.getAllSubordinates());
                                }
                        });
                return allSubordinates;
        }



}
