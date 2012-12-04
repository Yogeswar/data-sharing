package FileSplitter;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.CRC32;
import javax.swing.*;


public class FileSplitter {


 public ArrayList<String> readAndFragment ( String path, int CHUNK_SIZE ) throws IOException

 {
  
  FileManager fm =new FileManager(path); 
  //log ("File Is Reading "+ SourceFileName );
  File willBeRead = new File ( path );
  int FILE_SIZE = (int) willBeRead.length();
  ArrayList<String> nameList = new ArrayList<String> ();
  //String path="C://Users/manas/Downloads/Programming interviews exposed.pdf";
  int NUMBER_OF_CHUNKS = 1;
  byte[] temporary = null;
  
  try {
   InputStream inStream = null;
   int totalBytesRead = 0;
   
   try {
    inStream = new BufferedInputStream ( new FileInputStream( willBeRead ));
    
    while ( totalBytesRead < FILE_SIZE )
    {
     String PART_NAME;
      PART_NAME = fm.getFileName(path)+NUMBER_OF_CHUNKS+".bin";
     int bytesRemaining = FILE_SIZE-totalBytesRead;
     if ( bytesRemaining < CHUNK_SIZE ) // Remaining Data Part is Smaller Than CHUNK_SIZE
                // CHUNK_SIZE is assigned to remain volume
     {
      CHUNK_SIZE = bytesRemaining;
     }
     temporary = new byte[CHUNK_SIZE]; //Temporary Byte Array
     int bytesRead = inStream.read(temporary, 0, CHUNK_SIZE);
     
     if ( bytesRead > 0) // If bytes read is not empty
     {
      totalBytesRead += bytesRead;
      NUMBER_OF_CHUNKS++;
     }

      write(temporary,".\\temp\\"+PART_NAME);
      //write(temporary, "D://"+PART_NAME);
     //nameList.add("D://"+PART_NAME);
     System.out.println("Total Bytes Read: "+totalBytesRead + PART_NAME);
    }
    
   }
   finally {
    inStream.close();
   }
  }
  catch (FileNotFoundException ex)
  {
   ex.printStackTrace();
  }
  catch (IOException ex)
  {
   ex.printStackTrace();
  }
  return nameList;
 }
 
 void write(byte[] DataByteArray, String DestinationFileName){
     try {
       OutputStream output = null;
       try {
         output = new BufferedOutputStream(new FileOutputStream(DestinationFileName));
         output.write( DataByteArray );
         System.out.println("Writing Process Was Performed");
       }
       finally {
         output.close();
       }
     }
     catch(FileNotFoundException ex){
      ex.printStackTrace();
     }
     catch(IOException ex){
      ex.printStackTrace();
     }
 }
 
 public void mergeParts ( ArrayList<String> nameList, String DESTINATION_PATH )

 {	
  File[] file = new File[nameList.size()];
  byte AllFilesContent[] = null;
  
  int TOTAL_SIZE = 0;
  int FILE_NUMBER = nameList.size();
  int FILE_LENGTH = 0;
  int CURRENT_LENGTH=0;
  
  for ( int i=0; i<FILE_NUMBER; i++)
  {
	//System.out.println(DESTINATION_PATH + nameList.get(i));  
   file[i] = new File (nameList.get(i));
   TOTAL_SIZE+=file[i].length();
  }
  
  try {
   AllFilesContent= new byte[TOTAL_SIZE]; // Length of All Files, Total Size
   InputStream inStream = null;
   
   for ( int j=0; j<FILE_NUMBER; j++)
   {
    inStream = new BufferedInputStream ( new FileInputStream( file[j] ));
    FILE_LENGTH = (int) file[j].length();
    inStream.read(AllFilesContent, CURRENT_LENGTH, FILE_LENGTH);
    CURRENT_LENGTH+=FILE_LENGTH;
    inStream.close();
   }
   
  }
  catch (FileNotFoundException e)
  {
   System.out.println("File not found " + e);
  }
  catch (IOException ioe)
  {
    System.out.println("Exception while reading the file " + ioe);
  }
  finally 
  {
   write (AllFilesContent,DESTINATION_PATH);
  }
  
  System.out.println("Merge was executed successfully.!");
  
 }

}