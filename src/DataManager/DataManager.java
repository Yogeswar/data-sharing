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

    public void addDataListener(DataListener dl) {
        this.listener = dl;
    }

    public DataManager(DataListener dl, Node selfNode) {
        this.listener = dl;
        this.selfTimeStamp = selfNode;
        this.timeStamp.put(selfNode.getId(), selfNode);
        this.update();
    }

    public void update() {
        listener.requestDataUpdate();
    }

    public Object[] getDataUpdate() {
        Object[] obj = new Object[2];
        obj[0] = this.timeStamp;
        obj[1] = this.data;
        return obj;
    }

    public List<String> addDir(String pathName) {
        if (data.get(this.selfTimeStamp.getId()) != null) {
            data.get(this.selfTimeStamp.getId()).addDirectory(data.get(this.selfTimeStamp.getId()), pathName);
        } else {
            data.put(this.selfTimeStamp.getId(), new Directory(pathName));
            data.get(this.selfTimeStamp.getId()).createDirList();
        }
        data.get(this.selfTimeStamp.getId()).returnValues();
        return data.get(this.selfTimeStamp.getId()).finalDirectory;
    }

    public List<String> getAllDir() {
        List<String> allList = new ArrayList<String>();
        for (Map.Entry<String, Directory> entry : data.entrySet()) {
            String key = entry.getKey();
            Directory dir = entry.getValue();
            allList.addAll(dir.finalDirectory);
        }
        return allList;
    }

    public List<String> recieveUpdate(Map<String, Node> timeStamp, Map<String, Directory> recvData) {
        this.updateTimeStamp(timeStamp);
        List<String> allList = new ArrayList<String>();
        for (Map.Entry<String, Directory> entry : recvData.entrySet()) {
            String key = entry.getKey();
            Directory recvdir = entry.getValue();
            Directory dir = this.data.get(key);
            if (dir == null) {
                this.data.put(key, recvdir);
            } else {
                if (dir.getVersion() < recvdir.getVersion()) {
                    this.data.put(key, recvdir);
                }
            }

            allList.addAll(this.data.get(key).finalDirectory);
        }
        return allList;
    }

    public void requestLock(String pathName) {
        this.listener.requestLock(pathName);
        for (Map.Entry<String, Directory> entry : data.entrySet()) {
            String key = entry.getKey();
            Directory dir = entry.getValue();
            dir.readFile(dir, pathName);
        }
        this.ackToRecieve.put(pathName, this.timeStamp.size());
    }

    public boolean lockRequested(String pathName, String ip) {
        for (Map.Entry<String, Directory> entry : data.entrySet()) {
             String key = entry.getKey();
             Directory dir = entry.getValue();
             if (dir != null && dir.isFilePresent(pathName)) {
                 System.out.println(dir.isFileReadLocked.get(pathName));
                 if(dir.isFileReadLocked.get(pathName)!= null && dir.isFileReadLocked.get(pathName) == 1){
                     this.requestList.add(ip);
                     return false;
                 }
             }
         }
        return true;
    }

    public void updateTimeStamp(Map<String, Node> timeStamp) {
        this.selfTimeStamp.increment();
        this.timeStamp.get(this.selfTimeStamp.getId()).setLogicalTimestamp(this.selfTimeStamp.getLogicalTimestamp());

        for (Map.Entry<String, Node> entry : timeStamp.entrySet()) {
            String key = entry.getKey();
            Node node = entry.getValue();
            Node currentNode = this.timeStamp.get(key);
            if (currentNode == null) {
                this.timeStamp.put(key, node);
            } else {
                if (currentNode.isLatest(node.getLogicalTimestamp())) {
                    currentNode.setLogicalTimestamp(node.getLogicalTimestamp());
                }
            }
        }
    }

    public void lockAck(String ip, String request) {
        int temp = (this.ackToRecieve.get(request).intValue()) - 1;
        if (temp == 0) {
            for (Map.Entry<String, Directory> entry : data.entrySet()) {
                String key = entry.getKey();
                Directory dir = entry.getValue();
                if (dir.isFilePresent(request)) {
                    this.listener.locked(this.timeStamp.get(key).getIp(), request);
                }
            }

        } else {
            this.ackToRecieve.put(request, new Integer(temp));
        }
    }

    public List<String> getFiles(String pathName) {
        return data.get(this.selfTimeStamp.getId()).filesInDir(data.get(this.selfTimeStamp.getId()), pathName);
    }

    public List<String> getAllFiles(String pathName) {
        ArrayList<String> fileList = new ArrayList<String>();
        for (Map.Entry<String, Directory> entry : data.entrySet()) {
            String key = entry.getKey();
            Directory dir = entry.getValue();
            fileList = dir.filesInDir(dir, pathName);
            if (fileList.size() > 0) {
                return fileList;
            }
        }
        return fileList;
    }
}
