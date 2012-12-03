package dataHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;

/**
 * 
 */

/**
 * @author Pradeep Raghuwanshi
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
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//new DataStructure();
		
		//Directory dirTemp = new Directory();
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
		System.out.println("Size of directory list:"+ dir.getFinaldirectory());
		ArrayList<String> filesList = dir.filesInDir(dir, "src\\files1\\data\\manas\\pradeep");
		//filesList = dir.filesInDir(dir, "src\\files1\\data\\manas\\pradeep");
		System.out.println(filesList.size());
		

		
		
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
		
		
	}

}