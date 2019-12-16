package Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipFiles {
    public static String findFilebyName(String dir) throws IOException {
        String contents = "0";
        ZipFile zipFile = new ZipFile(dir);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            contents = entry.getName();
            return contents;
        }
        return contents;
    }

    public static List<ZipEntry> findFilebyContents(String dir) throws IOException {
        ZipFile zipFile1 = new ZipFile(dir);
        List<ZipEntry> toR = zipFile1
                .stream()
                .filter(z -> {
                    String found = "";
                    try {
                        Scanner scan = new Scanner(zipFile1.getInputStream(z));
                        String s = scan.findWithinHorizon("Pat", 0);
                        if (s != null) found = s;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return !(found.equals(""));
                }).collect(Collectors.toList());
        return toR;

    }


    public static void main(String[] args) throws IOException {
        String directory = "C:/Users/jagie/OneDrive/Desktop/UTP_7_TEST.zip";
        findFilebyName(directory);
        String directory2 = "C:/Users/jagie/OneDrive/Desktop/UTP_ homework2.zip";
        findFilebyContents(directory2);

    }
}


