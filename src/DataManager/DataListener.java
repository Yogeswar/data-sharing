/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataManager;

/**
 *
 * @author Yogi
 */
public interface DataListener {
    public void requestDataUpdate();
    public void requestLock(String request);
    public void returnLockRequest(String request,String ip);
    public void locked(String ip, String request);
    
}
