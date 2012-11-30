/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManager;

/**
 *
 * @author Yogi
 */
public class DataManager {
    
    MsgBuilder msgBuilder;
    MsgParser msgParser;
    DataListener listener;
    Data data;    
    
    
    public void addDataListener(DataListener dl){
        this.listener = dl;
    }
    
    public DataManager(MsgBuilder builder, MsgParser parser){
        this.msgBuilder = builder;
        this.msgParser = parser;
        this.update();
    }            
    
    public void update(){
        msgBuilder.requestDataUpdate();
    }
    
    public void recieveUpdate(Data data){
        if(data.version > this.data.version){
            this.data = data;
            dl.notifyDataUpdata();
        }
    }
    
    public void requestLock(){
        msgBuilder.requestDataLock(this.data.getRequestNumber(),  )
}
