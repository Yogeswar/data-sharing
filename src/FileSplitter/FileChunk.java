/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSplitter;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author manas
 */
public class FileChunk {
        private FileHeader fh;
        private int chunkNumber;
        

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

    public ArrayList<String> getPart ( String path, int CHUNK_SIZE ){
        
        
    }
        
}
