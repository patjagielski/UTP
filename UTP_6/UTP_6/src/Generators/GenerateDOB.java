package Generators;

import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import Person.Person;

public class GenerateDOB {
    private static final int sMAX = LocalDate.now().getYear()-5;
    private static final int tMIN = 1959;


    public static int createRandom(int start, int end){
        return (int) (start + Math.round(Math.random()*(end-start)));
    }

    public static LocalDate createTeacherDOB(){
        int day;
        int month = createRandom(1, 12);
        int year = createRandom(tMIN, sMAX);
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = createRandom(1, 30);
            return LocalDate.of(year, month, day);
        }else if(year%4==0 && month == 2){
            day = createRandom(1, 29);
            return LocalDate.of(year, month, day);
        }else if(year%4 != 0 && month ==2){
            day = createRandom(1, 28);
            return LocalDate.of(year, month,day);
        } else {
            day = createRandom(1, 31);
            return LocalDate.of(year, month, day);
        }
    }




}
