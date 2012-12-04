/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSplitter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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

    public String getPart ( String filename, int partno ){
         
	 String path =".\\temp\\";
         String fileToReturn=filename+partno+".bin";
         String completePath =path+fileToReturn;
         
         File f = new File(completePath);
         if(f.exists()){
             return completePath;
         }
         else
             return null;
         
    }
        
}
