/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManager;

import dataHandler.*;
import java.util.*;

/**
 *
 * @author Yogi
 */
public class DataManager {
    
    Directory directory;
    DataListener listener; 
    Map<String, Node> timeStamp = new HashMap<String, Node>();
    Node selfTimeStamp;
    Queue<String> requestList = new LinkedList<String>();
    Map<String, Directory> data = new HashMap<String, Directory>();
    Map<String, Integer> ackToRecieve = new HashMap<String, Integer>();
        
    public void addDataListener(DataListener dl){
        this.listener = dl;
    }
    
    public DataManager(DataListener dl, Node selfNode){
        this.listener = dl;
        this.selfTimeStamp = selfNode;
        this.timeStamp.put(selfNode.getId(), selfNode);        
        this.update();
    }            
    
    public void update(){
        listener.requestDataUpdate();
    }
    
    public Object getDataUpdate(){
        Object[] obj = new Object[2]; 
        obj[0] = this.timeStamp;
        obj[1] = this.directory;
        return obj;
    }
    
    public List<String> addDir(String pathName){
        if(data.get(this.selfTimeStamp.getIp()) != null){           
            data.get(this.selfTimeStamp.getId()).addDirectory(data.get(this.selfTimeStamp.getId()), pathName);        
        } else {
            data.put(this.selfTimeStamp.getId(), new Directory(pathName));
        }
        data.get(this.selfTimeStamp.getId()).returnValues();
        return data.get(this.selfTimeStamp.getId()).finalDirectory;        
    }
    
    
    public List<String> recieveUpdate(Map<String, Node> timeStamp, Map<String, Directory> recvData){
        this.updateTimeStamp(timeStamp);
        List<String> allList = new ArrayList<String>();
        for (Map.Entry<String,Directory> entry : recvData.entrySet()) {
            String key = entry.getKey();
            Directory recvdir = entry.getValue();
            Directory dir = this.data.get(key);
            if(dir.getVersion() < recvdir.getVersion()){
                this.data.put(key, recvdir);
            }
            allList.addAll(this.data.get(key).finalDirectory);            
        }
        return allList;
    }
    
    public void requestLock(String pathName){
        this.listener.requestLock(pathName);
        this.directory.readFile(this.directory, pathName);
        this.ackToRecieve.put(pathName, this.timeStamp.size());
    }
    
    public boolean lockRequested(String pathName, String ip){
        if(this.directory.isFileReadLocked.get(pathName) == 1){
            this.requestList.add(ip);
            return false;
        }
        return true;                
    }
    
    public void updateTimeStamp(Map<String, Node> timeStamp){
        this.selfTimeStamp.increment();
        this.timeStamp.get(this.selfTimeStamp.getId()).setLogicalTimestamp(this.selfTimeStamp.getLogicalTimestamp());
        
        for (Map.Entry<String,Node> entry : timeStamp.entrySet()) {
            String key = entry.getKey();
            Node node = entry.getValue();
            Node currentNode = this.timeStamp.get(key);
            if(currentNode.isLatest(node.getLogicalTimestamp())){
                currentNode.setLogicalTimestamp(node.getLogicalTimestamp());
            }            
        }
   }
    
   public void lockAck(String ip, String request){
       int temp = (this.ackToRecieve.get(request).intValue())-1;              
       if(temp == 0){
           this.listener.locked(request);
       } else {
           this.ackToRecieve.put(request, new Integer(temp));
       }
   }
    
    
    
    
}
