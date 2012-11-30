//writes serialized contents to file "table"
package store;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class writetofile {

public void writef(Object str){

String filename = "table";

FileOutputStream fos = null;
     ObjectOutputStream out = null;
     try
     {
    	 File ftarget=new File(filename);
			ftarget.createNewFile();
			
       fos = new FileOutputStream(filename);
       out = new ObjectOutputStream(fos);
       //write serialized object to file
       out.writeObject(str);
       out.close();
       
       
     }
     catch(IOException ex)
     {
       ex.printStackTrace();
    }
	}
}
