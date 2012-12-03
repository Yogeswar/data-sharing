package comm;
//Interface to initialize methods executed at the client
import DataManager.Node;
import dataHandler.Directory;
import java.io.File;
import java.security.Key;
import java.util.List;
import java.util.Map;

import store.storage;

public interface MsgAction 
{
        public void IpUpdate(Map<String, Node> timestamp, String recvIp);
        public void ReqDataUpdate(String recvIp);
        public void ReqLock(String recvIp, String request);
        public void ReqFileDetails(String recvIp, String request);
        public void ReqFileBlock(String recvIp, String request, int blockId);
        public void DataUpdate(String recvIp, Map<String, Directory> data);
        public void AckLock(String recvIp, String request);
        public void FileDetails(String recvIp, String request);
        public void FileBlock(String recvIp, String request);	
}
