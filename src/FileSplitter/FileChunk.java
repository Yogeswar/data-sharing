/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSplitter;

/**
 *
 * @author manas
 */
public class FileChunk {
        private FileHeader fh;
        private int chunkNumber;
        private char[] chunksize =new char[512];

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

    /**
     * @return the chunksize
     */
    public char[] getChunksize() {
        return chunksize;
    }

    /**
     * @param chunksize the chunksize to set
     */
    public void setChunksize(char[] chunksize) {
        this.chunksize = chunksize;
    }
        
}
