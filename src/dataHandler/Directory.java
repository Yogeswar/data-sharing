package dataHandler;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 
 */

/**
 * @author Pradeep Raghuwanshi
 *
 */
public class Directory {
	
	private static final ArrayList<String> finalDirectory = new ArrayList<String>();


	/*
	 * Map contains the key as the pathname of the directory and value as the Directory Object with all child directories and files information.
	 */
	TreeMap<String, Directory> directoryContent = new TreeMap<String, Directory>();
	
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	int version = 0;
	
	
	// To save the final Directory structure after add or removal
	
	
	// to check whether the file is readLocked or not by passing pathname of File. If value returned is 0, status of file is  unlocked , if 1 it is locked
	public TreeMap<String, Integer> isFileReadLocked = new TreeMap<String, Integer>();
	
	// to check whether the directory is readLocked or not by passing pathname of Directory. If value returned is 0, status of directory is unlocked , if 1 it is locked
	public TreeMap<String, Integer> isDirReadLocked = new TreeMap<String, Integer>();
	
	

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
	

	/*
	 * Default constructor
	 */
	public Directory(){
		
	}

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
		int size = 0;
		if(strFilesDirs != null)
			size = strFilesDirs.length;
		//To save the current directory details
		
		ArrayList<Directory> tempSubDirectories = new ArrayList<Directory>(); // temporary arraylist to save sub directories names
		ArrayList<String> tempSubFiles = new ArrayList<String>(); // temporary arraylist to save sub files names
		version++;
		this.setDirectoryPath(pathname);
		this.isDirReadLocked.put(pathname, 0); // adding directory with status as unlocked i.e value 0.
		this.setDateCreated(dateFormat.format(date));
		this.setDirectoryName(pathname);
		for ( int i = 0 ; i < size ; i ++ ) {
			if ( strFilesDirs[i].isDirectory ( ) ) {
				tempSubDirectories.add(new Directory(strFilesDirs[i].toString()));
				childDirectories.add(strFilesDirs[i].toString());
			}
			else if ( strFilesDirs[i].isFile ( ) ){
				this.isFileReadLocked.put(strFilesDirs[i].toString(), 0); // adding file with status as unlocked i.e value 0.
				this.setSubFileName(strFilesDirs[i].toString());
				tempSubFiles.add(strFilesDirs[i].toString());
			}
		}
		
		this.setSubDirectoriesPath(tempSubDirectories); // storing sub directories of the current directory
		this.setSubFilesPath(tempSubFiles); // storing sub files of the current directory
		
		if(pathname.indexOf(".") == -1 && !getFinaldirectory().contains(pathname))
			getFinaldirectory().add(pathname);
		
		
	}
	
	
	public void returnValues(){
		
		System.out.println("Directory path is:-"+this.getDirectoryPath());

		// subDirectoriesPath
		Iterator<Directory> itr = this.subDirectoriesPath.iterator();
		while(itr.hasNext()){
			Directory tempDir = itr.next();
			tempDir.returnValues();
		}

		Iterator<String> itr1 = this.subFilesPath.iterator();
		
		while(itr1.hasNext()){
			System.out.println("Files:"+itr1.next());
		}
		
	}
	
	/*
	 * Method to delete directory from the actual directory structure
	 */
	public Directory deleteDirectory(Directory dir, String dirPathname){
		Iterator<Directory> itr = dir.subDirectoriesPath.iterator();
		while(itr.hasNext()){
			Directory tempDir = itr.next();
			if(dirPathname.equals(tempDir.getDirectoryPath())){
				version++;
				itr.remove();
				return dir; // if found in sub directory of Directory passed (i.e dir here) than remove sub directory from current directory and pass dir.
			}else{
				deleteDirectory(tempDir, dirPathname); // else pass the sub directory and check in sub directory for dir pathname.
			}
		}
		return dir;
	}
	
	// first search for the parent directory of the directory that needs to be added
	// when parent pathname is equal to the tempDir.getDirectoryPath() enter the if loop
	// in the while keep a integer count to keep track of the index of subDirectoriesPath arrayList
	// from the directory remove the parent directory dir.subDirectoriesPath.remove(index)
	// than add the child into parent directory by tempDir.add(new Directory(dirPathname)
	// than add tempDir to the same index in dir i.e dir.subDirectoriesPath.add(index, tempDir)
	
	/*
	 * Method to add directory to the actual directory structure
	 */
	public Directory addDirectory(Directory dir, String dirPathname){
		List<String> directoryList = new ArrayList<String>();
		Iterator<String> wordsIterator ;
		StringTokenizer st = new StringTokenizer(dirPathname, "\\");
		while (st.hasMoreTokens()){
			String tempWord = st.nextToken().toString();
			directoryList.add(tempWord);
		}
		wordsIterator = directoryList.iterator();
		String parentDir = "";
		int tempCount = 0;
		while(wordsIterator.hasNext()){
			String tempDir = wordsIterator.next();
			if(!directoryList.get(directoryList.size()-1).equals(tempDir)){
				if(tempCount == directoryList.size()-2)
					parentDir = parentDir + tempDir;
				else
					parentDir = parentDir + tempDir +"\\";
			}
			tempCount++;
		}
		
		
		Iterator<Directory> itr = dir.subDirectoriesPath.iterator();
		int count = -1;
		while(itr.hasNext()){
			count++;
			Directory tempDir = itr.next();
			System.out.println("Directory path-----------------"+tempDir.getDirectoryPath());
			System.out.println("parent directory is:"+parentDir);
			if(parentDir.trim().equals(tempDir.getDirectoryPath())){ // the directory under which the directory needs to be added (parent directory)
				version++;
				dir.subDirectoriesPath.remove(count); // remove the parent directory from the original structure
				tempDir.subDirectoriesPath.add(new Directory(dirPathname)); // add the new child directory inside the temporary parent directory
				dir.subDirectoriesPath.add(count, tempDir); // add the temporary parent directory in the original structure
				return dir; // if found in sub directory of Directory passed (i.e dir here) than remove sub directory from current directory and pass dir.
			}else{
				addDirectory(tempDir, dirPathname); // else pass the sub directory and check in sub directory for dir pathname.
			}
		}
		return dir;
	}
	
	
	
	
	
	/*
	 * Method to delete file from the actual directory structure
	 */
	public Directory deleteFile(Directory dir, String filePathname){
		Iterator<Directory> itr = dir.subDirectoriesPath.iterator();
		System.out.println("File path:- "+filePathname);
		
		while(itr.hasNext()){ // for each directory
			Directory tempDir = itr.next();
			Iterator<String> fileItr = tempDir.getSubFilesPath().iterator(); // to iterate all files in the current directory
			
			while(fileItr.hasNext()){ // for each file in given directory
				String tempFileName = fileItr.next().trim();
				System.out.println("tempFileName -----"+tempFileName);
				if(filePathname.trim().equals(tempFileName)){ // if file is found in sub directory of Directory passed 
					version++;
					System.out.println("Inside file searching file:- "+filePathname);
					fileItr.remove();	
					return dir; // if file is found in sub directory of Directory passed (i.e dir here) than remove file from current directory and pass dir.
				}
			}
			deleteFile(tempDir, filePathname);  // if not found pass the sub directory and check in sub directory for file pathname.
		}
		return dir;
	}
	
	
	
	// first search for the parent directory of the directory that needs to be added
	// when parent pathname is equal to the tempDir.getDirectoryPath() enter the if loop
	// in the while keep a integer count to keep track of the index of subDirectoriesPath arrayList
	// from the directory remove the parent directory dir.subDirectoriesPath.remove(index)
	// than add the child into parent directory by tempDir.add(new Directory(dirPathname)
	// than add tempDir to the same index in dir i.e dir.subDirectoriesPath.add(index, tempDir)
	
	/*
	 * Method to add directory to the actual directory structure
	 */
	public Directory addFile(Directory dir, String filePathname){
		List<String> directoryList = new ArrayList<String>();
		Iterator<String> wordsIterator ;
		StringTokenizer st = new StringTokenizer(filePathname, "\\");
		while (st.hasMoreTokens()){
			String tempWord = st.nextToken().toString();
			directoryList.add(tempWord);
		}
		wordsIterator = directoryList.iterator();
		String parentDir = "";
		int tempCount = 0;
		while(wordsIterator.hasNext()){
			String tempDir = wordsIterator.next();
			if(!directoryList.get(directoryList.size()-1).equals(tempDir)){
				if(tempCount == directoryList.size()-2)
					parentDir = parentDir + tempDir;
				else
					parentDir = parentDir + tempDir +"\\";
			}
			tempCount++;
		}
		
		
		Iterator<Directory> itr = dir.subDirectoriesPath.iterator();
		int count = -1;
		while(itr.hasNext()){
			count++;
			Directory tempDir = itr.next();
			
			System.out.println("Directory path-----------------"+tempDir.getDirectoryPath());
			System.out.println("parent directory is:"+parentDir);
			if(parentDir.trim().equals(tempDir.getDirectoryPath())){ // the directory under which the directory needs to be added (parent directory)
				version++;
				dir.subDirectoriesPath.remove(count); // remove the parent directory from the original structure
				tempDir.subFilesPath.add(filePathname); // add the new child file inside the temporary parent directory
				dir.subDirectoriesPath.add(count, tempDir); // add the temporary parent directory in the original structure
				return dir; // if found in sub directory of Directory passed (i.e dir here) than remove sub directory from current directory and pass dir.
			}else{
				addDirectory(tempDir, filePathname); // else pass the sub directory and check in sub directory for dir pathname.
			}
		}
		return dir;
	}
	
	
	
	
	
	/*
	 * Method to set read lock to the file pathname passed and all its parent directories.
	 */
	public Directory readFile(Directory dir, String filePathname){
		if(filePathname.indexOf(dir.getDirectoryPath()) > -1) {// if the filePathname contains the directory path (i.e it is part of parent hierarchy )
			System.out.println("Directory pathname:------------------- "+dir.getDirectoryPath());
			isDirReadLocked.put(dir.getDirectoryPath(),1); // read lock the parent Directory
		}
		
		Iterator<Directory> itr = dir.subDirectoriesPath.iterator();
		
		while(itr.hasNext()){ // for each directory
			Directory tempDir = itr.next();
			Iterator<String> fileItr = tempDir.getSubFilesPath().iterator(); // to iterate all files in the current directory
			
			while(fileItr.hasNext()){ // for each file in given directory
				String tempFileName = fileItr.next().trim();
				if(filePathname.trim().equals(tempFileName)){
					System.out.println("Directory pathname:----------------------- "+tempDir.getDirectoryPath());
					System.out.println("File pathname:---------------------------- "+tempFileName);
					isDirReadLocked.put(tempDir.getDirectoryPath(),1); // read lock the immediate parent directory of the file searched
					isFileReadLocked.put(tempFileName, 1); // read lock the file searched
					version++;
					System.out.println("Inside file searching file:- "+filePathname);
					return dir; // if file is found in sub directory of Directory passed (i.e dir here) than remove file from current directory and pass dir.
				}
			}
			readFile(tempDir, filePathname);  // if not found pass the sub directory and check in sub directory for file pathname.
		}
		return dir;
	}
	
	
	/*
	 * Takes Top level Directory object and directory path as a parameter and returns list of files existing in the parent directory
	 */
	
	public ArrayList<String> filesInDir(Directory dir, String dirPathname){
		ArrayList<String> filesList = new ArrayList<String>();
		Iterator<Directory> itr = dir.subDirectoriesPath.iterator();
		while(itr.hasNext()){
			Directory tempDir = itr.next();
			
			if(dirPathname.equals(tempDir.getDirectoryPath())){ // when the parent directory is found
				Iterator<String> fileItr = tempDir.getSubFilesPath().iterator(); // to iterate all files in the current directory
				while(fileItr.hasNext()){ // for each file in given directory
					String tempFileName = fileItr.next().trim();
					filesList.add(tempFileName);
				}
				return filesList;
			}else{
				// add the files to the filesList
				filesList.addAll(filesInDir(tempDir, dirPathname)); // else pass the sub directory and check in sub directory for dir pathname.
			}
		}
		return filesList;
	}
	
	
	
	/*
	 * Method to set read lock to the directory pathname passed and all its parent directories.
	 
	public Directory readDirectory(Directory dir, String dirPathname){
		if(dirPathname.indexOf(dir.getDirectoryPath()) > -1) // if the filePathname contains the directory path (i.e it is part of parent hierarchy )
			dir.isDirReadLocked.put(dir.getDirectoryPath(),1); // read lock the parent Directory
		
		
		Iterator<Directory> itr = dir.subDirectoriesPath.iterator();
		while(itr.hasNext()){
			Directory tempDir = itr.next();
			//System.out.println("Directory path----------------- "+tempDir.getDirectoryPath());
			if(dirPathname.equals(tempDir.getDirectoryPath())){
				//System.out.println("Inside Dir");
				itr.remove();
				return dir; // if found in sub directory of Directory passed (i.e dir here) than remove sub directory from current directory and pass dir.
			}else{
				deleteDirectory(tempDir, dirPathname); // else pass the sub directory and check in sub directory for dir pathname.
			}
		}
		return dir;
	}*/
	
	
	
	
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
	 */
	public ArrayList<Directory> getSubDirectoriesPath() {
		return subDirectoriesPath;
	}

	/**
	 * @param subDirectoriesPath the subDirectoriesPath to set
	 */
	
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

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * @return the final directory
	 */
	public static ArrayList<String> getFinaldirectory() {
		return finalDirectory;
	}
}