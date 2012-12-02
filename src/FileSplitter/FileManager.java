
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {

    final static int CHUNKSIZE = 1048576;
    String path;                                   //File Path
    
    int parts=getNumberOfParts();
    int[] available = new int[parts];

    FileSplitter fs = new FileSplitter();
    
    FileManager(String path){
        for(int i=0;i<getNumberOfParts();i++)
            available[i]=0;
    }

    public String getFileExtension() {

        Pattern p = Pattern.compile(".*?([^\\\\/]+)$");
        Matcher m = p.matcher(path);
        String filename = ((m.find()) ? m.group(1) : "");

        String[] tokens = filename.split("\\.");
        String[] a = new String[2];

        for (int i = 0; i < tokens.length; i++) {
            a[i] = tokens[i];
        }
        return a[1];
    }

    public String getFileName() {

        Pattern p = Pattern.compile(".*?([^\\\\/]+)$");
        Matcher m = p.matcher(path);
        String filename = ((m.find()) ? m.group(1) : "");

        String[] tokens = filename.split("\\.");
        String[] a = new String[2];

        for (int i = 0; i < tokens.length; i++) {
            a[i] = tokens[i];
        }
        return a[0];
    }
    

    public int getFileSize() {
        File file = new File(path);
        int FILE_SIZE = (int) file.length();
        System.out.println("Total File Size: " + FILE_SIZE);
        return FILE_SIZE;

    }

    public int getNumberOfParts() {
        int parts = (getFileSize() / CHUNKSIZE) + 1;
        System.out.println("Number of Parts : " + parts);
        return parts;
    }

    public boolean allPartsAvailable() {
        
        int count = 0;
        for (int i = 0; i < parts; i++) {
            if (available[i] == 1) {
                count++;
            }
        }
        if (count == parts) {
            return true;
        }
        return false;
    }
}
    
    

    