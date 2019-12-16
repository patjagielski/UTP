package Generators;

import Person.Person;

import java.io.IOException;
import java.time.LocalDate;

public class GeneratePesel {
     /*YYMMDDZZZXQ
        ZZZ a random set of numbers
        X codes the sex of a person
        Q random number
        birthdates between 1900-1999 no changes
        between 2000-2099 month field is increased by 20
        between 2100 - 2199 month field is increased by 40
        between 2200 - 2299 month + 60
        between 1800 - 1899 month + 80
     */


    public static StringBuilder firstPartPesel(Person person) {
        StringBuilder firstPart = new StringBuilder();
        if (person.get_DOB().compareTo(LocalDate.of(2000, 01, 01)) > 0) {
            String YY = String.valueOf(String.format("%02d", person.get_DOB().getYear() % 100));
            String MM = String.valueOf(String.format("%02d", person.get_DOB().getMonthValue() + 20));
            String DD = String.valueOf(String.format("%02d", person.get_DOB().getDayOfMonth()));
            firstPart.append(YY).append(MM).append(DD);
            return firstPart;
        } else if (person.get_DOB().compareTo(LocalDate.of(2100, 01, 01)) > 0 || person.get_DOB().compareTo(LocalDate.of(2199, 01, 01)) > 0) {
            String YY = String.valueOf(String.format("%02d", person.get_DOB().getYear() % 100));
            String MM = String.valueOf(String.format("%02d", person.get_DOB().getMonthValue() + 40));
            String DD = String.valueOf(String.format("%02d", person.get_DOB().getDayOfMonth()));
            firstPart.append(YY).append(MM).append(DD);
            return firstPart;
        } else if (person.get_DOB().compareTo(LocalDate.of(2200, 01, 01)) > 0 || person.get_DOB().compareTo(LocalDate.of(2299, 01, 01)) > 0) {
            String YY = String.valueOf(String.format("%02d", person.get_DOB().getYear() % 100));
            String MM = String.valueOf(String.format("%02d", person.get_DOB().getMonthValue() + 60));
            String DD = String.valueOf(String.format("%02d", person.get_DOB().getDayOfMonth()));
            firstPart.append(YY).append(MM).append(DD);
            return firstPart;
        } else if (person.get_DOB().compareTo(LocalDate.of(1800, 01, 01)) < 0 || person.get_DOB().compareTo(LocalDate.of(1899, 01, 01)) < 0) {
            String YY = String.valueOf(String.format("%02d", person.get_DOB().getYear() % 100));
            String MM = String.valueOf(String.format("%02d", person.get_DOB().getMonthValue() + 80));
            String DD = String.valueOf(String.format("%02d", person.get_DOB().getDayOfMonth()));
            firstPart.append(YY).append(MM).append(DD);
            return firstPart;
        } else {
            String YY = String.valueOf(String.format("%02d", person.get_DOB().getYear() % 100));
            String MM = String.valueOf(String.format("%02d", person.get_DOB().getMonthValue()));
            String DD = String.valueOf(String.format("%02d", person.get_DOB().getDayOfMonth()));
            firstPart.append(YY).append(MM).append(DD);
            return firstPart;
        }
    }

    public static StringBuilder secondPartPesel() {
        int fourthPartPesel = (int) (Math.random() * 1000);
        StringBuilder pesel = new StringBuilder();
        pesel.append(String.format("%03d", fourthPartPesel));
        return pesel;
    }

    public static StringBuilder thirdPartPesel(Person person) throws IOException {
        StringBuilder pesel = new StringBuilder();
        if (person.checkMale()) {
            pesel.append("1");
            return pesel;
        } else {
            pesel.append("0");
            return pesel;
        }

    }

    public static String fourthPartPesel(Person person) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int tot = 0;
        int finalPartPesel = 0;
        stringBuilder.append(firstPartPesel(person)).append(secondPartPesel()).append(thirdPartPesel(person));


        for (int i = 0; i < stringBuilder.length(); i++) {
            if (i == 0 || i == 4 || i == 8) {
                tot = stringBuilder.charAt(i);
                finalPartPesel += tot;
            } else if (i == 1 || i == 5 || i == 9) {
                tot = stringBuilder.charAt(i);
                tot = tot * 3;
                finalPartPesel += tot;
            } else if (i == 2 || i == 6) {
                tot = stringBuilder.charAt(i);
                tot = tot * 7;
                finalPartPesel += tot;
            } else if (i == 3 || i == 7) {
                tot = stringBuilder.charAt(i);
                tot = tot * 9;
                finalPartPesel += tot;
            }
        }

        int sumno = finalPartPesel % 10;
        if (sumno == 0) {
            stringBuilder.append(sumno);
        } else {
            stringBuilder.append(10 - sumno);
        }


        return String.valueOf(stringBuilder);
    }

    public static String create_Pesel(Person person) throws IOException {
        return fourthPartPesel(person);

    }
}