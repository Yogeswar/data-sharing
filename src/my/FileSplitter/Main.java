import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public static void main(String args[]){
		
		FileSplitter fs=new FileSplitter();
		/*
		try {
			fs.readAndFragment("C://Users/manas/Downloads/crack.pdf", 15000);    // Size Chunks in Bytes
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		ArrayList<String> filename = new ArrayList<String>();
		for (int i=1;i<35;i++){
			filename.add("D://data"+i+".bin");
		}
		
		fs.mergeParts(filename, "D://Data.pdf");
		
	}
}
