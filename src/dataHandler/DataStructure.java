package dataHandler;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
 * @author Paddy
 *
 */
public class DataStructure {

	/*
	 * Lit containing all describing words
	 */
	public static List<String> describingWords = new ArrayList<String>();
	
	/*
	 * Map contains the key as the pathname of the directory and value as the Directory Object with all child directories and files information.
	 */
	TreeMap<String, Directory> directoryContent = new TreeMap<String, Directory>();
	
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	
	
	List <TreeMap<String, Integer>> list = new ArrayList<TreeMap<String, Integer>>();
	
	
	/*DataStructure(){
		saveDirInfo("src\\files1\\data");
		System.out.println(directoryContent.get("src\\files1\\data").getSubDirectoriesPath());
		System.out.println(directoryContent.get("src\\files1\\data").getSubFilesPath());
		System.out.println(directoryContent.get("src\\files1\\data\\sonali").getSubDirectoriesPath());
	}*/
	
	/*
	 * This method will save details of the current directory in a Map with directory class Objects.
	 */
	/*public void saveDirInfo(String pathname){
		// To store all child directories of directory path given
		ArrayList<String> childDirectories = new ArrayList<String>();
		// Create a file object for your root directory
		File f1 = new File ( pathname ) ;
		// Get all the files and directory under your directory
		File[] strFilesDirs = f1.listFiles ( );
		//To save the current directory details
		Directory tempDir = new Directory();
		
		ArrayList<Directory> tempSubDirectories = new ArrayList<Directory>(); // temporary arraylist to save sub directories names
		ArrayList<String> tempSubFiles = new ArrayList<String>(); // temporary arraylist to save sub files names
		
		tempDir.setDirectoryPath(pathname);
		tempDir.setDateCreated(dateFormat.format(date));
		tempDir.setDirectoryName(pathname);
		
		for ( int i = 0 ; i < strFilesDirs.length ; i ++ ) {
			if ( strFilesDirs[i].isDirectory ( ) ) {
				System.out.println ( "Directory is: " + strFilesDirs[i] ) ;
				//tempDir.setSubDirectoryPath(strFilesDirs[i].toString());
				//tempDir.setDirectoryName(strFilesDirs[i].toString());
				tempSubDirectories.add(strFilesDirs[i].toString());
				
				childDirectories.add(strFilesDirs[i].toString());
			}
			else if ( strFilesDirs[i].isFile ( ) ){
				System.out.println ( "File is : " + strFilesDirs[i] ) ;
				//tempDir.setSubFilePath(strFilesDirs[i].toString());
				//tempDir.setSubFileName(strFilesDirs[i].toString());
				tempSubFiles.add(strFilesDirs[i].toString());
			}
		}
		
		tempDir.setSubDirectoriesPath(tempSubDirectories); // storing sub directories of the current directory
		tempDir.setSubFilesPath(tempSubFiles); // storing sub files of the current directory
		directoryContent.put(pathname, tempDir); // storing the current directory object in a tree map
		
		// Iterating for each child directory
		for (String temp : childDirectories){
			saveDirInfo(temp);
		}
		
	}*/
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//new DataStructure();
		
		Directory dirTemp = new Directory();
		Directory dir = new Directory("src\\files1\\data");
		dir.returnValues();
		
		/*dirTemp = dirTemp.deleteDirectory(dir,"src\\files1\\data\\sonali\\yogi");
		System.out.println("\nAfter deleting folder: ");
		dirTemp.returnValues();*/
		
		/*dirTemp = dirTemp.addDirectory(dir, "src\\files1\\data\\sonali\\yogi\\new");
		System.out.println("\nAfter adding folder: ");
		dirTemp.returnValues();
		
		dirTemp = dirTemp.addFile(dirTemp, "src\\files1\\data\\sonali\\yogi\\new\\n.txt");
		System.out.println("\nAfter adding file: ");
		dir.returnValues();
		
		dirTemp = dirTemp.addFile(dirTemp, "src\\files1\\data\\sonali\\yogi\\new\\n.word");
		System.out.println("\nAfter adding file: ");
		dir.returnValues();
		
		dirTemp = dirTemp.deleteDirectory(dirTemp,"src\\files1\\data\\sonali\\yogi\\new");
		System.out.println("\nAfter deleting folder: ");
		dirTemp.returnValues();
		
		dirTemp = dirTemp.addDirectory(dirTemp, "src\\files1\\data\\sonali\\yogi\\new");
		System.out.println("\nAfter adding folder: ");
		dirTemp.returnValues();*/
		
		
		dir.addDirectory(dir, "src\\files1\\data\\sonali\\yogi\\new");
		System.out.println("\nAfter adding folder: ");
		dir.returnValues();
		
		dir.addFile(dir, "src\\files1\\data\\sonali\\yogi\\new\\n.txt");
		System.out.println("\nAfter adding file: ");
		dir.returnValues();
		
		dir.addFile(dir, "src\\files1\\data\\sonali\\yogi\\new\\n.word");
		System.out.println("\nAfter adding file: ");
		dir.returnValues();
		
		dir.deleteDirectory(dir,"src\\files1\\data\\sonali\\yogi\\new");
		System.out.println("\nAfter deleting folder: ");
		dir.returnValues();
		
		dir.addDirectory(dir, "src\\files1\\data\\sonali\\yogi\\new");
		System.out.println("\nAfter adding folder: ");
		dir.returnValues();
		
		
		dir.readFile(dir, "src\\files1\\data\\sonali\\yogi\\y.txt");
		System.out.println("\nAfter reading folder: ");
		//dirTemp.returnValues();
		
		System.out.println(dir.isDirReadLocked.get("src\\files1\\data"));
		System.out.println(dir.isDirReadLocked.get("src\\files1\\data\\sonali"));
		System.out.println(dir.isDirReadLocked.get("src\\files1\\data\\sonali\\yogi"));
		System.out.println(dir.isFileReadLocked.get("src\\files1\\data\\sonali\\yogi\\y.txt"));
		
		
		System.out.println(dir.isDirReadLocked.get("src\\files1\\data\\manas"));
		System.out.println(dir.isFileReadLocked.get("src\\files1\\data\\manas\\pradeep"));
		System.out.println("Final Version value is:- "+dir.getVersion());
		

		
		
		/*if("src\\files1\\data\\sonali\\yogi\\new\\n.txt".indexOf("src\\files1\\data") > -1)
			System.out.println("Contains sub string"+"src\\files1\\data\\sonali\\yogi\\new\\n.txt".indexOf("src\\files1\\data"));
		else
			System.out.println("Does not contains sub string"+"src\\files1\\data\\sonali\\yogi\\new\\n.txt".indexOf("src\\files1\\data"));
		
		if("src\\files1\\data\\sonali\\yogi\\new\\n.txt".indexOf("src\\files1\\data\\manas\\pradeep\\p.txt") > -1)
			System.out.println("Contains sub string");
		else
			System.out.println("Does not contains sub string"+"src\\files1\\data\\sonali\\yogi\\new\\n.txt".indexOf("src\\files1\\data\\manas\\pradeep\\p.txt"));*/
		
		/*dirTemp = dirTemp.deleteFile(dirTemp, "src\\files1\\data\\manas\\pradeep\\p.txt");
		System.out.println("\nAfter deleting file: ");
		dir.returnValues();
		
		dirTemp = dirTemp.addFile(dirTemp, "src\\files1\\data\\manas\\pradeep\\p.txt");
		System.out.println("\nAfter adding file: ");
		dir.returnValues();*/
		
		/*new Directory("src\\files1\\data\\manas\\pradeep\\p.txt",dir);
		System.out.println("\nAfter deleting file: ");
		dir.returnValues();*/
		
		
		//StopWords stopWords = new StopWords();
		//stopWords.addStopWord();
		
		//returnDir("src/files1/data");
		
		// Create a file object for your root directory
		//File f1 = new File ( "src/files1/data" ) ;
		
		// Get all the files and directory under your diretcory
		//File[] strFilesDirs = f1.listFiles ( );
		
		/*for ( int i = 0 ; i < strFilesDirs.length ; i ++ ) {
			if ( strFilesDirs[i].isDirectory ( ) ) {
				System.out.println ( "Directory is: " + strFilesDirs[i] ) ;
				File f2 = new File ( strFilesDirs[i].toString() ) ;
				File[] strFilesDir = f2.listFiles ( );
			    for ( int j = 0 ; j < strFilesDir.length ; j ++ ) {
			    	System.out.println ( "Directory is: " + strFilesDir[j] ) ;
			    }
			}
			else if ( strFilesDirs[i].isFile ( ) ) {
					System.out.println ( "File is : " + strFilesDirs[i] ) ;
					File file = strFilesDirs[i];
				    FileInputStream fis = null;
				    BufferedInputStream bis = null;
				    DataInputStream dis = null;

				    try {
				      fis = new FileInputStream(file);

				      // Here BufferedInputStream is added for fast reading.
				      bis = new BufferedInputStream(fis);
				      dis = new DataInputStream(bis);
				     // BufferedReader d = new BufferedReader(new InputStreamReader(fis));

				      // dis.available() returns 0 if the file does not have more lines.
				      while (dis.available() != 0) {

				      
				       *  this statement reads the line from the file
				       *  Tokenize it to find all different words and check whether they are in stop words list or not
				       
				    	String read = dis.readLine(); 
				    	StringTokenizer strngToken = new StringTokenizer(read);
				    	String wordRead;
				    	while(read != null){
				    		while(strngToken.hasMoreTokens()){
					    		wordRead = strngToken.nextToken().toLowerCase();
					    		//System.out.println(wordRead);
						        
					    	}
					    	read = dis.readLine();
				    	}
				    	
				      }

				      // dispose all the resources after using them.
				      fis.close();
				      bis.close();
				      dis.close();
				      //System.out.println ( "File: " + strFilesDirs[i] + " (" + strFilesDirs[i].length ( ) + ")" ) ;

				    } catch (FileNotFoundException e) {
				      e.printStackTrace();
				    } catch (IOException e) {
				      e.printStackTrace();
				    }
				  }
				}*/
		/*Iterator<String> itr = stemWords.iterator();
		while(itr.hasNext()){
			System.out.println("Stem Word is:-"+itr.next());
		}*/
		//FindStemWords findStmWrd = new FindStemWords();
		
		//Method which will add describing words 
		//findStmWrd.addStemWords();
		
		//Method to find document frequency of each key term
		//findStmWrd.documentWordFreqCalculation();
		
		//Method to find tfIdf of key terms
		//findStmWrd.findTfIdf();
		
		//System.out.println("Size of map is:--"+findStmWrd.finalWordFreqInDoc);
		
		//findStmWrd.cosineSimilarity(findStmWrd.listOfStemWordsTfIdf);
		
		//Method to find initial k centroids and assign documents to it
		//findStmWrd.kMeansCalculation();
		
		//System.out.println("Sizze of list of tfIdf is:--"+findStmWrd.listOfStemWordsTfIdf.size());
		
		//System.out.println("Value of Final word count Map is:-"+findStmWrd.finalWordFreqInDoc);
		//System.out.println("Freq of words :-----"+findStmWrd.descWordFreqInDoc);
		//System.out.println("Size of list of StemWordMap is:-"+findStmWrd.listOfStemWordsMap.get(0));
	}

}

// 
