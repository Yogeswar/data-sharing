package dataHandler;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 */

/**
 * @author Paddy
 *
 */
public class Directory {
	
	
	
	/*
	 * Map contains the key as the pathname of the directory and value as the Directory Object with all child directories and files information.
	 */
	TreeMap<String, Directory> directoryContent = new TreeMap<String, Directory>();
	
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	
	List <TreeMap<String, Integer>> list = new ArrayList<TreeMap<String, Integer>>();
	
	

	private String directoryName;
	private String directoryOwner;
	private String directoryPath;
	
	private String subDirectoryPath;
	//private ArrayList<String> subDirectoriesPath;
	private ArrayList<Directory> subDirectoriesPath;
	private String subDirectoryName;
	private String subDirectoryOwner;
	
	private String subFileName;
	private String subFileOwner;
	private String subFilePath;
	private ArrayList<String> subFilesPath;
	
	private boolean isRead;
	private boolean isWrite;
	
	private String dateCreated;
	
	
	// Function to implement logic which will see the directory locks and
	// based on the locks should set locks in sub files and directories.
	
	// Function to add directory and remove directory, which in turn should remove all the sub directories and files.
	

	/*Directory (String pathname){
		saveDirInfo("src\\files1\\data");
		System.out.println(directoryContent.get("src\\files1\\data").getSubDirectoriesPath());
		System.out.println(directoryContent.get("src\\files1\\data").getSubFilesPath());
		System.out.println(directoryContent.get("src\\files1\\data\\sonali").getSubDirectoriesPath());
	}*/


	/*
	 * This method will save details of the current directory in a Map with directory class Objects.
	 */
	public Directory(String pathname){
		// To store all child directories of directory path given
		ArrayList<String> childDirectories = new ArrayList<String>();
		// Create a file object for your root directory
		File f1 = new File ( pathname ) ;
		// Get all the files and directory under your directory
		File[] strFilesDirs = f1.listFiles ( );
		//To save the current directory details
		//Directory tempDir = new Directory();
		
		ArrayList<Directory> tempSubDirectories = new ArrayList<Directory>(); // temporary arraylist to save sub directories names
		ArrayList<String> tempSubFiles = new ArrayList<String>(); // temporary arraylist to save sub files names
		
		this.setDirectoryPath(pathname);
		this.setDateCreated(dateFormat.format(date));
		this.setDirectoryName(pathname);
		
		for ( int i = 0 ; i < strFilesDirs.length ; i ++ ) {
			if ( strFilesDirs[i].isDirectory ( ) ) {
				System.out.println ( "Directory is: " + strFilesDirs[i] ) ;
				//tempDir.setSubDirectoryPath(strFilesDirs[i].toString());
				//tempDir.setDirectoryName(strFilesDirs[i].toString());
				tempSubDirectories.add(new Directory(strFilesDirs[i].toString()));
				
				childDirectories.add(strFilesDirs[i].toString());
			}
			else if ( strFilesDirs[i].isFile ( ) ){
				System.out.println ( "File is : " + strFilesDirs[i] ) ;
				//tempDir.setSubFilePath(strFilesDirs[i].toString());
				//tempDir.setSubFileName(strFilesDirs[i].toString());
				tempSubFiles.add(strFilesDirs[i].toString());
			}
		}
		
		this.setSubDirectoriesPath(tempSubDirectories); // storing sub directories of the current directory
		this.setSubFilesPath(tempSubFiles); // storing sub files of the current directory
		//directoryContent.put(pathname, this); // storing the current directory object in a tree map
		
		/*// Iterating for each child directory
		for (String temp : childDirectories){
			saveDirInfo(temp);
		}*/
		
	}
	
	
	public void returnValues(){
		
		System.out.println(this.directoryPath);
//		for(Map.Entry<String,Directory> entry : directoryContent.entrySet()) {
//			
//			  String key = entry.getKey();
//			  Directory dir = entry.getValue();
////			  System.out.println(dir.getDirectoryName());
//			  dir.returnValues();
//			
//		}
		
		Iterator<Directory> itr = this.subDirectoriesPath.iterator();
		while(itr.hasNext()){
			itr.next().returnValues();
		}

		Iterator<String> itr1 = this.subFilesPath.iterator();
		while(itr1.hasNext()){
			System.out.println(itr1.next());
		}
		
		
		
		/*for (TreeMap temp : directoryContent){
			//saveDirInfo(temp);
		}*/
	}
	
	
	/**
	 * @return the isRead
	 */
	public boolean isRead() {
		return isRead;
	}

	/**
	 * @param isRead the isRead to set
	 */
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	/**
	 * @return the isWrite
	 */
	public boolean isWrite() {
		return isWrite;
	}

	/**
	 * @param isWrite the isWrite to set
	 */
	public void setWrite(boolean isWrite) {
		this.isWrite = isWrite;
	}

	/**
	 * @return the subFilesPath
	 */
	public ArrayList<String> getSubFilesPath() {
		return subFilesPath;
	}

	/**
	 * @param subFilesPath the subFilesPath to set
	 */
	public void setSubFilesPath(ArrayList<String> subFilesPath) {
		this.subFilesPath = subFilesPath;
	}

	/**
	 * @return the subDirectoriesPath
	 *//*
	public ArrayList<String> getSubDirectoriesPath() {
		return subDirectoriesPath;
	}*/
	
	/**
	 * @return the subDirectoriesPath
	 */
	public ArrayList<Directory> getSubDirectoriesPath() {
		return subDirectoriesPath;
	}

	/**
	 * @param subDirectoriesPath the subDirectoriesPath to set
	 */
	/*public void setSubDirectoriesPath(ArrayList<String> subDirectoriesPath) {
		this.subDirectoriesPath = subDirectoriesPath;
	}*/
	
	public void setSubDirectoriesPath(ArrayList<Directory> subDirectoriesPath) {
		this.subDirectoriesPath = subDirectoriesPath;
	}

	/**
	 * @return the subDirectoryPath
	 */
	public String getSubDirectoryPath() {
		return subDirectoryPath;
	}

	/**
	 * @param subDirectoryPath the subDirectoryPath to set
	 */
	public void setSubDirectoryPath(String subDirectoryPath) {
		this.subDirectoryPath = subDirectoryPath;
	}

	/**
	 * @return the subDirectoryName
	 */
	public String getSubDirectoryName() {
		return subDirectoryName;
	}

	/**
	 * @param subDirectoryName the subDirectoryName to set
	 */
	public void setSubDirectoryName(String subDirectoryName) {
		this.subDirectoryName = subDirectoryName;
	}

	/**
	 * @return the subDirectoryOwner
	 */
	public String getSubDirectoryOwner() {
		return subDirectoryOwner;
	}

	/**
	 * @param subDirectoryOwner the subDirectoryOwner to set
	 */
	public void setSubDirectoryOwner(String subDirectoryOwner) {
		this.subDirectoryOwner = subDirectoryOwner;
	}

	/**
	 * @return the subFileName
	 */
	public String getSubFileName() {
		return subFileName;
	}

	/**
	 * @param subFileName the subFileName to set
	 */
	public void setSubFileName(String subFileName) {
		this.subFileName = subFileName;
	}

	/**
	 * @return the subFileOwner
	 */
	public String getSubFileOwner() {
		return subFileOwner;
	}

	/**
	 * @param subFileOwner the subFileOwner to set
	 */
	public void setSubFileOwner(String subFileOwner) {
		this.subFileOwner = subFileOwner;
	}

	/**
	 * @return the subFilePath
	 */
	public String getSubFilePath() {
		return subFilePath;
	}

	/**
	 * @param subFilePath the subFilePath to set
	 */
	public void setSubFilePath(String subFilePath) {
		this.subFilePath = subFilePath;
	}

	/**
	 * @return the directoryPath
	 */
	public String getDirectoryPath() {
		return directoryPath;
	}

	/**
	 * @param directoryPath the directoryPath to set
	 */
	public void setDirectoryPath(String directoryPath) {
		this.directoryPath = directoryPath;
	}

	/**
	 * @return the directoryName
	 */
	public String getDirectoryName() {
		return directoryName;
	}

	/**
	 * @param directoryName the directoryName to set
	 */
	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}

	/**
	 * @return the directoryOwner
	 */
	public String getDirectoryOwner() {
		return directoryOwner;
	}

	/**
	 * @param directoryOwner the directoryOwner to set
	 */
	public void setDirectoryOwner(String directoryOwner) {
		this.directoryOwner = directoryOwner;
	}

	/**
	 * @return the dateCreated
	 */
	public String getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param string the dateCreated to set
	 */
	public void setDateCreated(String string) {
		this.dateCreated = string;
	}

}
