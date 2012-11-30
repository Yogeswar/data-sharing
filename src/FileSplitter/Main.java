import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	final static int CHUNKSIZE=100000;
	
	public static void main(String args[]){
		
		FileSplitter fs=new FileSplitter();
		FileManager fm = new FileManager();
		String path="C://Users/manas/Downloads/Programming interviews exposed.pdf";
		
		   // If File Name is Crack.pdf , It will Return Crack
		String name=fm.getFileName(path);                        
		
		// If File Name is Crack.pdf , It will Return pdf
		String extension=fm.getFileExtension(path);
		
		try {
			
			fs.readAndFragment(path,CHUNKSIZE);    // Size Chunks in Bytes
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int numparts=FileManager.getNumberOfParts(path);
		ArrayList<String> filename = new ArrayList<String>();
		for (int i=1;i<=numparts;i++){
                        filename.add("D://"+FileManager.getFileName(path)+i+".bin");
			//filename.add("D://data"+i+".bin");
			//filename.add("D://+""+ name+ ""+"+i+".bin");
			//filename.add("D://data"+i+"."+extension);
		}
		String fileename=FileManager.getFileName(path);
                String ext=FileManager.getFileExtension(path);
		//fs.mergeParts(filename, "D://book.pdf");
		fs.mergeParts(filename, "D://"+fileename+"."+ext);
		String fileext=fm.getFileExtension(path);
		System.out.println("File Extension : "+ fileext);
		
		String fname= fm.getFileName(path);
		System.out.println("File Name :" + fname);
		fm.getNumberOfParts(path);
	}
		

}
