package comm;
//Build the message that has to be sent through the socket

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import DataManager.Node;
import FileSplitter.FileHeader;
import utils.*;

public class MessageBuilder 
{
	private byte[] data;
	private Convert conv;
	
	//Constants used to indicate message types
        private static final byte CMD_REQ_IP_UPDATE	= 1;	//update the server's IP table
	private static final byte CMD_REQ_DATA_UPDATE   = 2;	//Request a data update from peers
	private static final byte CMD_REQ_LOCK          = 3;	//Request a lock to access data
	private static final byte CMD_REQ_FILE_DETAILS  = 4;	//Request file details
	private static final byte CMD_REQ_FILE_BLOCK	= 5;	//request File Block
	private static final byte CMD_DATA_UPDATE      	= 6;	//request Data Update from peers
	private static final byte CMD_ACK_LOCK	      	= 7;	//send Acknowlege to lock request
	private static final byte CMD_FILE_DETAILS    	= 8;	//send file details
	private static final byte CMD_FILE_BLOCK        = 9;	//send file block
	private static final byte CMD_DISCONNECT  	= 10;	//Disconnect from server
	private static final byte CMD_REGISTER          = 11;	//Register to server
	private static final byte CMD_AM_HERE     	= 12;	//Respond to server ping
	
	//Send the message using the client socket
	public void sendMessage(String ip)
	{
		new MyClient(this.data, ip, 5000);
	}
	
	public MessageBuilder()
	{
		conv = new Convert();	//Initialize object for Convert class
	}

	//Register the client details at the Server
	public void registerServer(Node node, String ip)
	{
		byte[] mainData = conv.toByteArray(node);
		data = new byte[mainData.length + 1];
		data[0] = CMD_REGISTER;			//Append message type to the data
		System.arraycopy(mainData, 0, data, 1, mainData.length);	//Copy contents of mainData array to data array
		new MyClient(this.data, ip, 5001);	//Send data through the client
	}
	
        public void reqStatusUpdate(String ip){
            data = new byte[1];
            data[0] = MessageBuilder.CMD_REQ_IP_UPDATE;	//Append message type to the data 
            
            new MyClient(this.data, ip, 5001);	//Send message using client
        }
        
        public void reqDataUpdate(String ip){
            data = new byte[1];
            data[0] = MessageBuilder.CMD_REQ_DATA_UPDATE;	//Append message type to the data 
            new MyClient(this.data, ip, 5001);	//Send message using client
        }
        
        public void reqLock(String ip, String request){
            byte[] mainData = conv.toByteArray(request);
            data = new byte[mainData.length + 1];
            data[0] = MessageBuilder.CMD_REQ_LOCK;	//Append message type to the data 
            System.arraycopy(mainData, 0, data, 1, mainData.length);	//Copy contents of mainData array to data array
            new MyClient(this.data, ip, 5001);	//Send data through the client
        }
        
        public void reqFile(String ip, String pathName){
            byte[] mainData = conv.toByteArray(pathName);
            data = new byte[mainData.length + 1];
            data[0] = MessageBuilder.CMD_REQ_FILE_DETAILS;	//Append message type to the data 
            System.arraycopy(mainData, 0, data, 1, mainData.length);	//Copy contents of mainData array to data array
            new MyClient(this.data, ip, 5001);	//Send data through the client
        }
        
        public void reqBlock(String ip, int blockId){
            
            data = new byte[1];
            data[0] = MessageBuilder.CMD_REQ_FILE_BLOCK;	//Append message type to the data 
            new MyClient(this.data, ip, 5001);	//Send message using client
        }
        
        public void ackLock(String ip, String request){
            byte[] mainData = conv.toByteArray(request);
            data = new byte[mainData.length + 1];
            data[0] = MessageBuilder.CMD_ACK_LOCK;	//Append message type to the data 
            System.arraycopy(mainData, 0, data, 1, mainData.length);	//Copy contents of mainData array to data array
            new MyClient(this.data, ip, 5001);	//Send data through the client                      
        }
        
        public void dataUpdate(String ip, Object obj){
            byte[] mainData = conv.toByteArray(obj);
            data = new byte[mainData.length + 1];
            data[0] = MessageBuilder.CMD_DATA_UPDATE;	//Append message type to the data 
            System.arraycopy(mainData, 0, data, 1, mainData.length);	//Copy contents of mainData array to data array
            new MyClient(this.data, ip, 5001);	//Send data through the client                                              
        }
        
        public void fileDetails(String ip, FileHeader fh){
            byte[] mainData = conv.toByteArray(fh);
            data = new byte[mainData.length + 1];
            data[0] = MessageBuilder.CMD_FILE_DETAILS;	//Append message type to the data 
            System.arraycopy(mainData, 0, data, 1, mainData.length);	//Copy contents of mainData array to data array
            new MyClient(this.data, ip, 5001);	//Send data through the client                                              
        }
        
        public void fileBlock(String ip, Object file){
		FileInputStream fis;
		try {
			fis = new FileInputStream((File) file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        byte[] buf = new byte[1024];
	        for (int readNum; (readNum = fis.read(buf)) != -1;) {
                    bos.write(buf, 0, readNum); 
	        }
	        byte[] mainData = bos.toByteArray();
	        data = new byte[mainData.length + 1];
			data[0] = MessageBuilder.CMD_FILE_BLOCK;	//Append message type to data
			System.arraycopy(mainData, 0, data, 1, mainData.length);
			this.sendMessage(ip);	//Send message using client
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();                        
                }            
        }
        
        public void amHere(String ip){
                data = new byte[1];
		data[0] = MessageBuilder.CMD_AM_HERE;	//Append message type to the data 
		new MyClient(this.data, ip, 5001);	//Send message using client
        }
        
        
	//Disconnect client from server
	public void disconnect(String ip)
	{
		data = new byte[1];
		data[0] = MessageBuilder.CMD_DISCONNECT;	//Append message type to the data 
		new MyClient(this.data, ip, 5001);	//Send message using client
	}
	
}
	
