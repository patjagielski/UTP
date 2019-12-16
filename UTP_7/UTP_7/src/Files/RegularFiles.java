package Files;

import java.io.*;
import java.util.Scanner;

public class RegularFiles {
    public static String findFilebyName(String filep) {
        File f = null;
        File filedir = new File(filep);
        File[] file = filedir.listFiles((filedir1, name) -> name.startsWith("Hu") && name.endsWith(".txt"));
        for (File file1 : file) {
            if (file1.isFile()) {
                f = file1;
                return f.getName();
            }
        }
        return f.getName();
    }

    public static String findFilebyContents(String filep) throws FileNotFoundException {
        File answer = null;
        File filedir = new File(filep);
        File[] dir = filedir.listFiles((filedir1, name2) -> name2.endsWith(".txt"));
        for (File f : dir) {
            String l = "";
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                l = scanner.nextLine();
                if (l.contains("Pat")) {
                    answer = f;
                    return answer.getName();

                }
            }
        }
        return answer.getName();
    }


    public static void main(String[] args) throws FileNotFoundException {
        String filep = "C:/Users/jagie/Desktop/";

        findFilebyName(filep);
        findFilebyContents(filep);

    }

}

