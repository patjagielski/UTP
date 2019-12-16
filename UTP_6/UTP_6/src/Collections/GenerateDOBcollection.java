package Collections;

import Generators.GenerateDOB;

import java.util.Set;
import java.util.TreeSet;

public class GenerateDOBcollection {
    protected static TreeSet<GenerateDOB> generateDOBTreeSet = new TreeSet<>();

    public static TreeSet<GenerateDOB> generateDOBTreeSet() {
        return generateDOBTreeSet;
    }
}
