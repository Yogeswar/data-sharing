/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FileSplitter;

import java.io.Serializable;

/**
 *
 * @author manas
 */
public class FileHeader implements Serializable {
    private String fileName ;
    private String fileExtension;
    private int fileSize;
    private int numberofChunks;
    //private int chunkNumber;
    
    
    public FileHeader fileValues (String filePathName){
    	FileHeader fileHeader = new FileHeader();
    	FileManager fileManager =new FileManager();
    	
    	fileHeader.setFileExtension(fileManager.getFileExtension(filePathName));
    	fileHeader.setFileName(fileManager.getFileName(filePathName));
    	fileHeader.setFileSize(fileManager.getFileSize(filePathName));
    	fileHeader.setNumberofChunks(fileManager.getNumberOfParts(filePathName));
    	return fileHeader;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the fileExtension
     */
    public String getFileExtension() {
        return fileExtension;
    }

    /**
     * @param fileExtension the fileExtension to set
     */
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    /**
     * @return the fileSize
     */
    public int getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize the fileSize to set
     */
    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * @return the numberofChunks
     */
    public int getNumberofChunks() {
        return numberofChunks;
    }

    /**
     * @param numberofChunks the numberofChunks to set
     */
    public void setNumberofChunks(int numberofChunks) {
        this.numberofChunks = numberofChunks;
    }
    
}
