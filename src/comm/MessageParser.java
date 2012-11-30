package comm;
//Interpret the message types in data
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.Key;
import java.util.Arrays;
import java.util.List;

import store.*;
import utils.Convert;

public class MessageParser implements ServerListener
{
	
	private byte[] data;
	private List<storage> iptable; 
	private MsgAction action;
	private Cserver server;
	private String recvIP;
	private Convert conv;
	
	//Constants used to indicate message types
	private static final byte CMD_IP_UPDATE       	= 1;	//Server Update of IP List
	private static final byte CMD_REQ_DATA_UPDATE   = 2;	//Request for data update
	private static final byte CMD_REQ_LOCK          = 3;	//Request for a lock to access data
	private static final byte CMD_REQ_FILE_DETAILS  = 4;	//Request for file details
	private static final byte CMD_REQ_FILE_BLOCK	= 5;	//request for File Block
	private static final byte CMD_DATA_UPDATE      	= 6;	//Data Update from peer
	private static final byte CMD_ACK_LOCK	      	= 7;	//Acknowlegement to lock request
	private static final byte CMD_FILE_DETAILS    	= 8;	//file details
	private static final byte CMD_FILE_BLOCK        = 9;	//file block
        private static final byte CMD_TEST       	= 10;	//Server Test Ping

	
	public MessageParser()
	{
		startServer();
	}
	
	public MessageParser(byte[] incoming)
	{
		startServer();	//Start Server execution
		this.data = incoming;
	}
	
	//Start server thread
	public void startServer()
	{		
		server = new Cserver(5000);
		server.registerListener(this);
		new Thread(server).start();
	}
	
	public void addActionProvider(MsgAction ac)
	{
		this.action = ac;
	}
	
	//Store data and IP address received at the server
	public void serverNotify(byte[] data, String ip)
	{
		this.data = data;
		this.recvIP = ip;
		this.parsedata();
	}
	
	//Parse received data based on message types
	public void parsedata()
	{
		byte msgType = this.data[0];	//Message type is stored in data[0]
		this.data = Arrays.copyOfRange(this.data, 1, this.data.length);
		switch(msgType)
		{
			case MessageParser.CMD_IP_UPDATE:
				this.parseIpUpdate();
				break;
			case MessageParser.CMD_REQ_DATA_UPDATE:
				this.parseReqDataUpdate();
				break;
			case MessageParser.CMD_REQ_LOCK:
				this.parseReqLock();
				break;
			case MessageParser.CMD_REQ_FILE_DETAILS:
				this.parseReqFileDetails();
				break;
			case MessageParser.CMD_REQ_FILE_BLOCK:
				this.parseReqFileBlock();
				break;
			case MessageParser.CMD_DATA_UPDATE:
				this.parseDataUpdate();
				break;
			case MessageParser.CMD_ACK_LOCK:
				this.parseAckLock();
				break;
			case MessageParser.CMD_FILE_DETAILS:
				this.parseFileDetails();
				break;
			case MessageParser.CMD_FILE_BLOCK:
				this.parseFileBlock();
				break;
			default:
				break;
				
		}
	}
        
        private void parseReqDataUpdate(){
            
        }
        
        private void parseReqFileDetails(){
            
        }
        
        private void parseReqLock(){
            
        }
        
        private void parseReqFileBlock(){
            
        }
        
        private void parseFileDetails(){
            
        }
        
        private void parseAckLock(){
            
        }
        
        private void parseDataUpdate(){
            
        }
	

	//Store recorded contents to a file
	private void parseFileBlock() 
	{
		// TODO Auto-generated method stub
		String filename = recvIP + ".au";
		File inFile = new File(filename);	//Create a file to save recorded data
		if(inFile.exists())
		{
			inFile.delete();
			inFile = new File(filename);
		}
		
		
		try {
			inFile.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        try {
        	FileOutputStream fos = new FileOutputStream(inFile);
            fos.write(this.data);	//Write recorded data using FileOutputStream
        	fos.flush();
        	fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		this.action.recieveFile(inFile, this.recvIP);
		
	}

	//Parse the data that have to be updated in the IP table at the server
	@SuppressWarnings("unchecked")
	private void parseIpUpdate()
	{
		try 
		{
		    ByteArrayInputStream bis = new ByteArrayInputStream(this.data,0,this.data.length);
		    ObjectInputStream ois = new ObjectInputStream (bis);
		    iptable = (List<storage>) ois.readObject();	//Read the object into iptable
		    this.action.updateClientTable(iptable, this.recvIP);	//Update the client details at the IP table
		} 
		catch(Exception e)
		{
			//Exception code
		}
	}		
}