import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	final static int CHUNKSIZE=100000;
	
	public static void main(String args[]){
		String path="C://Users/manas/Downloads/Programming interviews exposed.pdf";
		FileSplitter fs=new FileSplitter();
		FileManager fm = new FileManager(path);
		
		
		   // If File Name is Crack.pdf , It will Return Crack
		String name=fm.getFileName();                        
		
		// If File Name is Crack.pdf , It will Return pdf
		String extension=fm.getFileExtension();
		
		try {
			
			fs.readAndFragment(path,CHUNKSIZE);    // Size Chunks in Bytes
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int numparts=fm.getNumberOfParts();
		ArrayList<String> filename = new ArrayList<String>();
		for (int i=1;i<=numparts;i++){
                        filename.add("D://"+fm.getFileName()+i+".bin");
			//filename.add("D://data"+i+".bin");
			//filename.add("D://+""+ name+ ""+"+i+".bin");
			//filename.add("D://data"+i+"."+extension);
		}
		String fileename=fm.getFileName();
                String ext=fm.getFileExtension();
		//fs.mergeParts(filename, "D://book.pdf");
		fs.mergeParts(filename, "D://"+fileename+"."+ext);
		String fileext=fm.getFileExtension();
		System.out.println("File Extension : "+ fileext);
		
		String fname= fm.getFileName();
		System.out.println("File Name :" + fname);
		fm.getNumberOfParts();
	}
		

}
