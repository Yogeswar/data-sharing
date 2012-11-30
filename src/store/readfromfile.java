//reads data from the file table
package store;

import java.io.ObjectInputStream;
import java.util.Scanner;

import java.io.FileInputStream;

import java.io.IOException;
public class readfromfile {

public void readfile(Object str1){
	String filename = "table"; 
		
	   FileInputStream fis = null;
	   ObjectInputStream in = null;
	   try
	   {
	     fis = new FileInputStream(filename);
	     in = new ObjectInputStream(fis);
	     str1 = (storage)in.readObject();
	     
	     in.close();
	     System.out.println(str1);
	   }
	   catch(IOException ex)
	   {
	     ex.printStackTrace();
	   }
	   catch(ClassNotFoundException ex)
	   {
	     ex.printStackTrace();
	   }
	   
	}
}
