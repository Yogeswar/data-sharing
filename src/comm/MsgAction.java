package comm;
//Interface to initialize methods executed at the client
import java.io.File;
import java.security.Key;
import java.util.List;

import store.storage;

public interface MsgAction 
{
	
	public void joinAccepted(String ip);	//Accept the join request from client
	public void joinRejected(String ip);	//Reject the join request from client
	public void startRecord(String ip);		//Start recording process 
	public void stopRecord(String ip);		//Stop recording
	public void recieveFile(File f, String ip);	//Process file that has been received
	public void recieveKey(Key k, String ip);	//Process the key that has been received
	public void requestJoin(String recvPin, String ip);	//Request the server for joining the group
	public void updateClientTable(List<storage> st, String ip);	//Update client details in the IP table
	public void testMix(Key k, String ip);
	
}
