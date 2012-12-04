/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSplitter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manas
 */


public class FileChunk {
    
        private FileHeader fh;
        private int chunkNumber;
        
        FileManager fm=new FileManager();
        FileSplitter fs=new FileSplitter();
    /**
     * @return the chunkNumber
     */
    public int getChunkNumber() {
        return chunkNumber;
    }

    /**
     * @param chunkNumber the chunkNumber to set
     */
    public void setChunkNumber(int chunkNumber) {
        this.chunkNumber = chunkNumber;
    }

    public File getPart ( String filename, int partno ) throws IOException{
        
         
	 String path =".\\temp\\";
         String fileToReturn=filename+partno+".bin";
             String completePath =path+fileToReturn;
         
         File f = new File(completePath);
         if(f.exists()){
             //boolean create =f.createNewFile();
             String name= f.getName();
             long length =f.length();
             //f.lastModified();
             return f;
         }
         else
             return null;
    }
    /*
    public FileChunk fileObj(String filename ,int partno){
        FileChunk fc=new FileChunk();   
        try {
            fc.getPart(filename, partno);
            
        } catch (IOException ex) {
            Logger.getLogger(FileChunk.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fc;
    }
    * */
}
