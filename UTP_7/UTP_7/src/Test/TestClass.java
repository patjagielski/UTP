package Test;

import Files.JarArchives;
import Files.RegularFiles;
import Files.ZipFiles;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipFile;

import static org.junit.jupiter.api.Assertions.*;

class TestClass {

    @Test
    public void testRegularFiles() throws FileNotFoundException {
        File file = new File("C:/Users/jagie/Desktop/Hungarian_Names.txt");
        Assert.assertEquals( file.getName(), RegularFiles.findFilebyName("C:/Users/jagie/Desktop/"));
        Assert.assertEquals(file.getName(),RegularFiles.findFilebyContents("C:/Users/jagie/Desktop/"));
    }
    @Test
    public void testZipFiles() throws IOException {
        String directory = "C:/Users/jagie/OneDrive/Desktop/UTP_7_TEST.zip";
        String directory2 = "C:/Users/jagie/OneDrive/Desktop/UTP_ homework2.zip";
        Assert.assertEquals(directory.contains("UTP"), ZipFiles.findFilebyName(directory).contains("UTP"));
        Assert.assertEquals(!(directory2.isEmpty()), !(ZipFiles.findFilebyContents(directory2).isEmpty()));
    }
    @Test
    public void testJarFiles() throws IOException {
        File filedir = new File("C:/Users/jagie/OneDrive/Desktop/");
        Assert.assertFalse(String.valueOf(false), JarArchives.findFilebyName(filedir).isEmpty());
        String dir = "C:/Users/jagie/OneDrive/Desktop/UTP_TESTING/test.jar";
        Assert.assertEquals(true, !(JarArchives.findFilebyContents(dir).isEmpty()));

    }





}