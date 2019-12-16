package com;

import com.Person;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputParser {

    // 1. Use regular expresssions (Pattern) for validating input data
    //    U¿yæ regularnych wyra¿eñ (Pattern) do walidacji danych wejœciowych
    //
    // 2. Convert input string representing date using SimpleDateFormat "yyyy-MM-dd"
    //    Konwersjê wejœciowego ci¹gu znaków reprezentuj¹cego datê nale¿y oprzeæ np. DateFormat
    //    SimpleDateFormat format "yyyy-MM-dd"


    public static List<Person> parse(File file) throws IOException, ParseException {
        List<Person> peopleInfo = new ArrayList<>();
        if(!file.exists()){
            return null;
        }else {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {

                Pattern regex = Pattern.compile("(^[A-Z][a-z]*\\s)([A-Z]\\w*\\s)(\\d{4}-\\d{2}-\\d{2})"); //9999-99-99
                Matcher matcher = regex.matcher(scan.nextLine());
                if (matcher.find()) {
                    System.out.println(scan.nextLine());
                    String name = matcher.group(1);
                    String surname = matcher.group(2);
                    Date test = new SimpleDateFormat("yyyy-MM-dd").parse(matcher.group(3));
                    Person temp = new Person(name, surname, test);
                    peopleInfo.add(temp);
                }

                }
            }
        return peopleInfo;
    }


}