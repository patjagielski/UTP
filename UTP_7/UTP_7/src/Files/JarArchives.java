package Files;

import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class JarArchives {

    public static String findFilebyName(File dir) {
        String a = "";
        File[] files = dir.listFiles((filedir1, name) -> name.startsWith("UTP") && name.endsWith(".java"));
        for (File f : files) {
            if (f.isFile()) {
                a = f.getName();
                return a;
            }
        }
        return a;
    }

    public static List<ZipEntry> findFilebyContents(String dir) throws IOException {
        ZipFile zipFile = new ZipFile(dir);
        List<ZipEntry> zipEntries = zipFile
                .stream()
                .parallel()
                .filter(zip -> {
                    String l = "";
                    try {
                        Scanner scanner = new Scanner(zipFile.getInputStream(zip));
                        String s = scanner.findWithinHorizon("Pat", 0);
                        if (s != null) l = s;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return !(l.equals(""));
                }).collect(Collectors.toList());
        return zipEntries;
    }


    public static void main(String[] args) throws IOException {

        File filedir = new File("C:/Users/jagie/OneDrive/Desktop/");
        findFilebyName(filedir);
        String dir = "C:/Users/jagie/OneDrive/Desktop/UTP_TESTING/test.jar";
        findFilebyContents(dir);
    }
}
