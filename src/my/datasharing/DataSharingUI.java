/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DataSharingUI.java
 *
 * Created on Nov 20, 2012, 4:30:47 PM
 */
package my.datasharing;

import DataManager.*;
import FileSplitter.*;
import comm.*;
import dataHandler.Directory;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author Sonali/Yogeswar
 */
public class DataSharingUI extends javax.swing.JFrame implements DataListener, MsgAction {
    //Server Id

    static private String SERVER_IP = "192.168.0.22";

    /**
     * Creates new form DataSharingUI
     */
    public DataSharingUI() {
        initComponents();
        String myId = JOptionPane.showInputDialog(new JEditorPane(), "Please Enter Your Id : ", "Group Size", JOptionPane.QUESTION_MESSAGE);
        if (myId == null) {
            myId = new Integer(new Random().nextInt()).toString();
        }
        try {
            this.selfNode = new Node(myId, InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        this.timeStamp = new HashMap<String, Node>();
        this.dataManager = new DataManager(this, selfNode);
        this.builder = new MessageBuilder();
        this.parser = new MessageParser();
        this.parser.addActionProvider(this);
        this.builder.registerServer(selfNode, SERVER_IP);
        this.fileHeader = new FileHeader();
        this.fileManager = new FileManager();
        this.fileSplitter = new FileSplitter();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        listOfFilesDownloadComboBox = new javax.swing.JComboBox();
        addDirectory = new javax.swing.JButton();
        removeDirectory = new javax.swing.JButton();
        Refresh = new javax.swing.JButton();
        listOfDirectionDownloadComboBox = new javax.swing.JComboBox();
        download = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        removeFile = new javax.swing.JButton();
        addDirectoryComboBox = new javax.swing.JComboBox();
        addFileComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pause = new javax.swing.JButton();
        resume = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Users = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        addDirectory.setText("Add Directory ");
        addDirectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDirectoryActionPerformed(evt);
            }
        });

        removeDirectory.setText("Remove Directory");
        removeDirectory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDirectoryActionPerformed(evt);
            }
        });

        Refresh.setText("Refresh");
        Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshActionPerformed(evt);
            }
        });

        listOfDirectionDownloadComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listOfDirectionDownloadComboBoxActionPerformed(evt);
            }
        });

        download.setText("Download");
        download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadActionPerformed(evt);
            }
        });

        jLabel1.setText("All Files");

        jLabel2.setText("All Directory");

        removeFile.setText("Remove File");
        removeFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeFileActionPerformed(evt);
            }
        });

        addDirectoryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDirectoryComboBoxActionPerformed(evt);
            }
        });

        addFileComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFileComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("My Directories");

        jLabel7.setText("My Files");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Refresh)
                                .addGap(27, 27, 27)
                                .addComponent(addDirectory))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addDirectoryComboBox, 0, 204, Short.MAX_VALUE)
                                    .addComponent(addFileComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(download, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(listOfDirectionDownloadComboBox, 0, 245, Short.MAX_VALUE)
                                .addComponent(listOfFilesDownloadComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(removeFile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeDirectory)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listOfDirectionDownloadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addDirectoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listOfFilesDownloadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(addFileComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Refresh)
                    .addComponent(download)
                    .addComponent(addDirectory))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeFile)
                    .addComponent(removeDirectory))
                .addGap(31, 31, 31)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pause.setText("Pause ");

        resume.setText("Resume");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("File Downloads");

        jLabel4.setText("File");

        jLabel5.setText("Capacity");

        jLabel8.setFont(new java.awt.Font("Castellar", 1, 24)); // NOI18N
        jLabel8.setText("FILE   SHARING");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Perpetua Titling MT", 1, 11)); // NOI18N
        jLabel10.setText("cREATED BY:    yOGESHWAR vijaykumar,  manas bapna, pradeep raghuwanshi, sonali rathod");

        Users.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(jLabel8)
                                .addGap(99, 99, 99)
                                .addComponent(Users, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(72, 72, 72)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(pause)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resume, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Users, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pause)
                                .addComponent(resume))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)))
                        .addGap(57, 57, 57)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Function process 'Add File' button click
    private void RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshActionPerformed
        // TODO add your handling code here:   
        this.refreshData();
    }//GEN-LAST:event_RefreshActionPerformed

    //Function process 'Remove Directory' button click
    private void removeDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDirectoryActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_removeDirectoryActionPerformed

    //Function process 'Remove File' button click
    private void removeFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeFileActionPerformed

    //Function process 'Add Directory' button click
    private void addDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDirectoryActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        int retcode = chooser.showOpenDialog(new JEditorPane());
        if (retcode == JFileChooser.APPROVE_OPTION) {
            File selected = chooser.getSelectedFile();
            this.setAddDirectoryComboBox(dataManager.addDir(selected.getPath()));
            this.setListOfDirectionDownloadComboBox(dataManager.getAllDir());
            for (Map.Entry<String, Node> entry : this.timeStamp.entrySet()) {
                String key = entry.getKey();
                Node node = entry.getValue();
                this.builder.dataUpdate(node.getIp(), this.dataManager.getDataUpdate());
            }

        }
    }//GEN-LAST:event_addDirectoryActionPerformed

    //Function process Selection of Directory in Common Space Directory Dropdown
    private void listOfDirectionDownloadComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listOfDirectionDownloadComboBoxActionPerformed
        // TODO add your handling code here:
        String selectedDir = (String) this.listOfDirectionDownloadComboBox.getSelectedItem();
        this.setListOfFilesDownloadComboBox(this.dataManager.getAllFiles(selectedDir));
    }//GEN-LAST:event_listOfDirectionDownloadComboBoxActionPerformed

    //Function process Selection of Directory in User Directory Dropdown
    private void addDirectoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDirectoryComboBoxActionPerformed
        // TODO add your handling code here:
        String selectedDir = (String) this.addDirectoryComboBox.getSelectedItem();
        this.setAddFileComboBox(this.dataManager.getFiles(selectedDir));
    }//GEN-LAST:event_addDirectoryComboBoxActionPerformed

    //Function process Selection of Directory in User Add File Dropdown
    private void addFileComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFileComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addFileComboBoxActionPerformed

    //Function process Download button click
    private void downloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadActionPerformed
        // TODO add your handling code here:
        String selectedFile = (String) this.listOfFilesDownloadComboBox.getSelectedItem();
        this.dataManager.requestLock(selectedFile);
    }//GEN-LAST:event_downloadActionPerformed

    ////Function process close button click
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.builder.disconnect(SERVER_IP);
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void UsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsersActionPerformed
    
    //data Manager function 
    // These functions are called from the data Manager
    
    //Recieve Update. This notifies the UI that an Update has been recieved.
    public void revieveUpdate(Map<String, Node> timeStamp, Map<String, Directory> recvData) {
        this.timeStamp = timeStamp;
        this.setListOfDirectionDownloadComboBox(this.dataManager.recieveUpdate(timeStamp, recvData));
    }

    //Request Data Update. The data manager notifies UI on the need to signal for a data update
    public void requestDataUpdate() {
        for (Map.Entry<String, Node> entry : this.timeStamp.entrySet()) {
            String key = entry.getKey();
            Node node = entry.getValue();
            this.builder.reqDataUpdate(node.getIp());
        }
    }

    //Request Lock. The data Manager notifies UI to send LOck request messages
    public void requestLock(String request) {
        for (Map.Entry<String, Node> entry : this.timeStamp.entrySet()) {
            String key = entry.getKey();
            Node node = entry.getValue();
            if (node.getIp() != this.selfNode.getIp()) {
                this.builder.reqLock(node.getIp(), request);
            }
        }
    }

    //Data Manager notifies UI that a lock has been acquired and file transfers can begin
    public void locked(String ip, String request) {
        //Start Downloading
        
        this.builder.reqFile(ip, request);
    }

    // The Data Parser calls these functions to notifies 
    public void IpUpdate(Map<String, Node> timestamp, String recvIp) {
        this.timeStamp = timestamp;
        this.refreshData();
        List<String> users = new ArrayList<String>();
        for (Map.Entry<String, Node> entry : this.timeStamp.entrySet()) {
            String key = entry.getKey();
            Node node = entry.getValue();
            users.add(node.getId());
        }
        this.setUsers(users);
    }

    public void ReqDataUpdate(String recvIp) {
        this.builder.dataUpdate(recvIp, this.dataManager.getDataUpdate());
    }

    public void ReqLock(String recvIp, String request) {
        if (this.dataManager.lockRequested(request, recvIp)) {
            this.builder.ackLock(recvIp, request);
        }
    }

    public void ReqFileDetails(String recvIp, String request) {
        this.builder.fileDetails(recvIp, this.fileHeader.fileValues(request));
    }

    public void ReqFileBlock(String recvIp, String request, int blockId) {
    }

    public void DataUpdate(String recvIp, Object[] obj) {
        this.setListOfDirectionDownloadComboBox(this.dataManager.recieveUpdate((Map<String, Node>) obj[0], (Map<String, Directory>) obj[1]));
    }

    public void AckLock(String recvIp, String request) {
        this.dataManager.lockAck(recvIp, request);
    }

    public void FileDetails(String recvIp, FileHeader fh) {
        System.out.println(fh);
    }

    public void FileBlock(String recvIp, File fb) {
    }

    public void returnLockRequest(String request, String ip) {
        this.builder.ackLock(ip, request);
    }
    
    public void refreshData(){
         for (Map.Entry<String, Node> entry : this.timeStamp.entrySet()) {
            String key = entry.getKey();
            Node node = entry.getValue();
            this.builder.reqDataUpdate(node.getIp());
        }
    }

    public Node getSelfNode() {
        return selfNode;
    }

    public void setSelfNode(Node selfNode) {
        this.selfNode = selfNode;
    }

    public JComboBox getAddDirectoryComboBox() {
        return addDirectoryComboBox;
    }

    public void setAddDirectoryComboBox(List<String> dir) {
        System.out.println(dir.size());
        String dirArray[] = dir.toArray(new String[dir.size()]);
        ComboBoxModel<String> AddDir = new DefaultComboBoxModel<String>(dirArray);
        this.addDirectoryComboBox.setModel(AddDir);
    }

    public JComboBox getAddFileComboBox() {
        return addFileComboBox;
    }

    public void setAddFileComboBox(List<String> dir) {
        System.out.println(dir.size());
        String dirArray[] = dir.toArray(new String[dir.size()]);
        ComboBoxModel<String> AddDir = new DefaultComboBoxModel<String>(dirArray);
        this.addFileComboBox.setModel(AddDir);
    }

    public JProgressBar getjProgressBar1() {
        return jProgressBar1;
    }

    public void setjProgressBar1(JProgressBar jProgressBar1) {
        this.jProgressBar1 = jProgressBar1;
    }

    public JComboBox getListOfDirectionDownloadComboBox() {
        return listOfDirectionDownloadComboBox;
    }

    public void setListOfDirectionDownloadComboBox(List<String> dir) {
        System.out.println(dir.size());
        String dirArray[] = dir.toArray(new String[dir.size()]);
        ComboBoxModel<String> AddDir = new DefaultComboBoxModel<String>(dirArray);
        this.listOfDirectionDownloadComboBox.setModel(AddDir);
    }

    public JComboBox getListOfFilesDownloadComboBox() {
        return listOfFilesDownloadComboBox;
    }

    public void setListOfFilesDownloadComboBox(List<String> dir) {
        System.out.println(dir.size());
        String dirArray[] = dir.toArray(new String[dir.size()]);
        ComboBoxModel<String> AddDir = new DefaultComboBoxModel<String>(dirArray);
        this.listOfFilesDownloadComboBox.setModel(AddDir);
    }

    public JComboBox getUsers() {
        return Users;
    }

    public void setUsers(List<String> dir) {
        System.out.println(dir.size());
        String dirArray[] = dir.toArray(new String[dir.size()]);
        ComboBoxModel<String> AddDir = new DefaultComboBoxModel<String>(dirArray);
        this.Users.setModel(AddDir);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataSharingUI().setVisible(true);
            }
        });
    }
    private DataManager dataManager;
    private MessageBuilder builder;
    private MessageParser parser;
    private Node selfNode;
    private Map<String, Node> timeStamp;
    private FileHeader fileHeader;
    private FileSplitter fileSplitter;
    private FileManager fileManager;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Refresh;
    private javax.swing.JComboBox Users;
    private javax.swing.JButton addDirectory;
    private javax.swing.JComboBox addDirectoryComboBox;
    private javax.swing.JComboBox addFileComboBox;
    private javax.swing.JButton download;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox listOfDirectionDownloadComboBox;
    private javax.swing.JComboBox listOfFilesDownloadComboBox;
    private javax.swing.JButton pause;
    private javax.swing.JButton removeDirectory;
    private javax.swing.JButton removeFile;
    private javax.swing.JButton resume;
    // End of variables declaration//GEN-END:variables
}
