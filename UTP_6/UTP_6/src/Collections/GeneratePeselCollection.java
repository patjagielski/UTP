package Collections;

import Generators.GeneratePesel;

import java.util.Set;
import java.util.TreeSet;

public class GeneratePeselCollection {
    protected static TreeSet<GeneratePesel> generatePeselTreeSet = new TreeSet<>();

    public static TreeSet<GeneratePesel> getPesel() {
        return generatePeselTreeSet;
    }
}
