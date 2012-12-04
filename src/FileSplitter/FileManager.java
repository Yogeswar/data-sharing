package FileSplitter;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {

    final static int CHUNKSIZE = 1048576;
                                   
    Main obj=new Main();
    //int parts=getNumberOfParts(obj.path);
    //int[] available = new int[parts];

    FileSplitter fs = new FileSplitter();
    
    FileManager(String path){
      /*  
        for(int i=0;i<getNumberOfParts(path);i++)
            available[i]=0;
             */
    }
    

    public static String getFileExtension(String path) {
		
	      Pattern p = Pattern.compile(".*?([^\\\\/]+)$");  
	      Matcher m = p.matcher(path);  
	      String filename=((m.find()) ? m.group(1) : "");
	      
	      String[] tokens = filename.split("\\.");
	      String[] a = new String[2];
	      
	      for(int i=0;i<tokens.length;i++){
	    	  a[i]=tokens[i];
	      }
		return a[1];
	}

	public static String getFileName(String path){
		
		  Pattern p = Pattern.compile(".*?([^\\\\/]+)$");  
	      Matcher m = p.matcher(path);  
	      String filename=((m.find()) ? m.group(1) : "");
	      
	      String[] tokens = filename.split("\\.");
	      String[] a = new String[2];
	      
	      for(int i=0;i<tokens.length;i++){
	    	  a[i]=tokens[i];
	      }
	      return a[0];
	}
	
	public static int getFileSize(String path){
                System.out.println("Path of file is:."+path);
		File file = new File ( path );
                int FILE_SIZE = (int) file.length();
                System.out.println("Total File Size: "+FILE_SIZE);
		return FILE_SIZE;
    	  
	}
	
	public static int getNumberOfParts(String path){
            System.out.println("path of the file in getNumberOfParts:"+path);
            int parts= (getFileSize(path)/CHUNKSIZE) + 1;
            System.out.println("Number of Parts : "+ parts);
            return parts;
	}
/*
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
     */
}
    
    

    