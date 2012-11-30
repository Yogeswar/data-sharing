import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileManager {
	
	final static int CHUNKSIZE=100000;
	
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
		File file = new File ( path );
		  int FILE_SIZE = (int) file.length();
		  System.out.println("Total File Size: "+FILE_SIZE);
		  return FILE_SIZE;
		  
	}
	
	public static int getNumberOfParts(String path){
            int parts= (getFileSize(path)/CHUNKSIZE) + 1;
            System.out.println("Number of Parts : "+ parts);
            return parts;
	}
        
        public boolean isAvailable(int[50]){
           String[] array= new String[50];
           
           return true;
            
        }
        
}
