package comm;
//Interpret the message types in data
import DataManager.Node;
import FileSplitter.FileHeader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.Key;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import utils.Convert;

public class MessageParser implements ServerListener {

    private byte[] data;
    private Map<String, Node> iptable;
    private MsgAction action;
    private Cserver server;
    private String recvIP;
    private Convert conv;
    //Constants used to indicate message types
    private static final byte CMD_IP_UPDATE = 1;	//Server Update of IP List
    private static final byte CMD_REQ_DATA_UPDATE = 2;	//Request for data update
    private static final byte CMD_REQ_LOCK = 3;	//Request for a lock to access data
    private static final byte CMD_REQ_FILE_DETAILS = 4;	//Request for file details
    private static final byte CMD_REQ_FILE_BLOCK = 5;	//request for File Block
    private static final byte CMD_DATA_UPDATE = 6;	//Data Update from peer
    private static final byte CMD_ACK_LOCK = 7;	//Acknowlegement to lock request
    private static final byte CMD_FILE_DETAILS = 8;	//file details
    private static final byte CMD_FILE_BLOCK = 9;	//file block
    private static final byte CMD_TEST = 10;	//Server Test Ping

    public MessageParser() {
        startServer();
    }

    public MessageParser(byte[] incoming) {
        startServer();	//Start Server execution
        this.data = incoming;
    }

    //Start server thread
    public void startServer() {
        System.out.println("Here Cserver is called with port 5001:- Message parser line 50");
        server = new Cserver(5000);
        server.registerListener(this);
        new Thread(server).start();
    }

    public void addActionProvider(MsgAction ac) {
        this.action = ac;
    }

    //Store data and IP address received at the server
    public void serverNotify(byte[] data, String ip) {
        this.data = data;
        this.recvIP = ip;
        this.parsedata();
    }

    //Parse received data based on message types
    public void parsedata() {
        byte msgType = this.data[0];	//Message type is stored in data[0]
        this.data = Arrays.copyOfRange(this.data, 1, this.data.length);
        switch (msgType) {
            case MessageParser.CMD_IP_UPDATE:
                this.parseIpUpdate();
                break;
            case MessageParser.CMD_REQ_DATA_UPDATE:    //Time Stamp & Data Update
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

    private void parseReqDataUpdate() {
        System.out.println("ReqDataUpdate");
        this.action.ReqDataUpdate(recvIP);
    }

    private void parseReqFileDetails() {
        System.out.println("ReqFileDetails");
        conv = new Convert();
        String pathName = (String) conv.toObject(this.data);
        this.action.ReqFileDetails(recvIP, pathName);
    }

    private void parseReqLock() {
        System.out.println("ReqLock");
        conv = new Convert();
        String pathName = (String) conv.toObject(this.data);
        this.action.ReqLock(recvIP, pathName);
    }

    private void parseReqFileBlock() {
        System.out.println("ReqFileBlock");

    }

    private void parseFileDetails() {
        System.out.println("FileDetails");
        conv = new Convert();
        FileHeader fh = (FileHeader) conv.toObject(this.data);
        this.action.FileDetails(recvIP, fh);
    }

    private void parseAckLock() {
        System.out.println("AckLock");
        conv = new Convert();
        String pathName = (String) conv.toObject(this.data);
        this.action.AckLock(recvIP, pathName);
    }

    private void parseDataUpdate() {
        System.out.println("DataUpdate");
        conv = new Convert();
        Object[] obj = (Object[]) conv.toObject(this.data);
        this.action.DataUpdate(recvIP, obj);
    }

    //Store recorded contents to a file
    private void parseFileBlock() {
        System.out.println("FileBlock");
        // TODO Auto-generated method stub
        String filename = recvIP + ".bin";
        File inFile = new File(filename);	//Create a file to save recorded data
        if (inFile.exists()) {
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

        this.action.FileBlock(this.recvIP, inFile);

    }

    //Parse the data that have to be updated in the IP table at the server
    @SuppressWarnings("unchecked")
    private void parseIpUpdate() {
        System.out.println("IpUpdate");
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(this.data, 0, this.data.length);
            ObjectInputStream ois = new ObjectInputStream(bis);
            List<Node> temp = (List<Node>) ois.readObject();
            iptable = new HashMap<String, Node>();
            Iterator<Node> iterator = temp.iterator();
            Node tempNode;
            while (iterator.hasNext()) {
                tempNode = iterator.next();
                iptable.put(tempNode.getId(), tempNode);
            }
            this.action.IpUpdate(iptable, this.recvIP);	//Update the client details at the IP table
        } catch (Exception e) {
            e.printStackTrace();
            //Exception code
        }
    }
}
