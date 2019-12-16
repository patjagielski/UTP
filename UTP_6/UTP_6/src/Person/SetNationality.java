package Person;


import java.util.*;

public class SetNationality {

    public static Map<Enum<Nationality>, Locale> mapOfNationalities = setNationalities();
    public static Map<Enum<Nationality>, Locale> setNationalities() {
        Map<Enum<Nationality>, Locale> mapOfNationalities = new HashMap<>();

        mapOfNationalities.put(Nationality.POLISH, new Locale("PL", "PL"));

        mapOfNationalities.put(Nationality.HUNGARIAN, new Locale("HU", "HU"));

        mapOfNationalities.put(Nationality.RUSSIAN, new Locale("RU", "RU"));

        mapOfNationalities.put(Nationality.GREEK, new Locale("EL", "EL"));

        mapOfNationalities.put(Nationality.JAPANESE, Locale.JAPANESE);

        mapOfNationalities.put(Nationality.FRENCH, Locale.FRENCH);

        mapOfNationalities.put(Nationality.SPANISH, new Locale("ES", "ES"));

        mapOfNationalities.put(Nationality.BRITISH, Locale.UK);

        mapOfNationalities.put(Nationality.CHINESE, Locale.CHINESE);

        mapOfNationalities.put(Nationality.INDIAN, new Locale("HI", "IN"));

        return mapOfNationalities;
    }
}
