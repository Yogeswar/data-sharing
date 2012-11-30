//main class that calls objects
package store;
import java.io.*;
public class storemain {
	private static String ip;
	private static String mode;
	private static String role;
	private static String group;
public static void main(String[] args){
	try{
	storage st= new storage();
	BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
	ip = br4.readLine();
	st.setip(ip);
	String id=st.getid(ip);
	
	st.setrole(role);
	st.setgroup(group);
	new writetofile();
	new readfromfile();
	}
	catch(Exception e){
		System.out.println("Storage error:" + e);
	}
}
}
