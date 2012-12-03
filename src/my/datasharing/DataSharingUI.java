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
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Sonu
 */
public class DataSharingUI extends javax.swing.JFrame implements DataListener, MsgAction{
    //Server Id
    static private String SERVER_IP = "192.168.0.22";

    /** Creates new form DataSharingUI */
    public DataSharingUI() {
        initComponents();
        String myId = JOptionPane.showInputDialog(new JEditorPane(), "Please Enter Your Id : ", "Group Size", JOptionPane.QUESTION_MESSAGE);
        if(myId == null) {
            myId = new Integer(new Random().nextInt()).toString();
        }
        try {
            this.selfNode = new Node(myId, InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        this.dataManager = new DataManager(this, selfNode);
        this.builder = new MessageBuilder();
        this.parser = new MessageParser();
        this.parser.addActionProvider(this);
        this.builder.registerServer(selfNode.getIp());
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        listOfFilesDownloadComboBox = new javax.swing.JComboBox();
        addDirectory = new javax.swing.JButton();
        removeDirectory = new javax.swing.JButton();
        addFile = new javax.swing.JButton();
        listOfDirectionDownloadComboBox = new javax.swing.JComboBox();
        download = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        removeFile = new javax.swing.JButton();
        addDirectoryComboBox = new javax.swing.JComboBox<File>();
        addFileComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pause = new javax.swing.JButton();
        resume = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addDirectory.setText("Add Directory");
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

        addFile.setText("Add File");
        addFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFileActionPerformed(evt);
            }
        });

        listOfDirectionDownloadComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listOfDirectionDownloadComboBoxActionPerformed(evt);
            }
        });

        download.setText("DOWNLOAD");

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
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(addFile)
                                .addGap(27, 27, 27)
                                .addComponent(addDirectory))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addDirectoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(addFileComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(listOfFilesDownloadComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(listOfDirectionDownloadComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(131, 131, 131)
                                .addComponent(download, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(153, 153, 153))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(removeFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeDirectory)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(addFile)
                    .addComponent(download)
                    .addComponent(addDirectory))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(removeFile)
                    .addComponent(removeDirectory))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pause.setText("Pause ");

        resume.setText("Resume");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("File Downloads");

        jLabel4.setText("File");

        jLabel5.setText("Capacity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(93, 93, 93)
                        .addComponent(jLabel5)
                        .addGap(73, 73, 73)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(pause)
                        .addGap(54, 54, 54)
                        .addComponent(resume, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(pause)
                        .addComponent(resume, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFileActionPerformed
        // TODO add your handling code here:   
    }//GEN-LAST:event_addFileActionPerformed

    private void removeDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeDirectoryActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_removeDirectoryActionPerformed

    private void removeFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeFileActionPerformed

    private void addDirectoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDirectoryActionPerformed
            // TODO add your handling code here:
         JFileChooser chooser = new JFileChooser();
//        if(chooserPath != null)
//        {
//            chooser.setCurrentDirectory(new File(chooserPath));
//        }
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);	
        chooser.setAcceptAllFileFilterUsed(false);
        int retcode = chooser.showOpenDialog(new JEditorPane());
        if (retcode == JFileChooser.APPROVE_OPTION) 
        {
            File selected = chooser.getSelectedFile();            
            dataManager.addDir(selected.getPath());
        }

    }//GEN-LAST:event_addDirectoryActionPerformed

    private void listOfDirectionDownloadComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listOfDirectionDownloadComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listOfDirectionDownloadComboBoxActionPerformed

    private void addDirectoryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDirectoryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addDirectoryComboBoxActionPerformed

    private void addFileComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFileComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addFileComboBoxActionPerformed

    public void requestDataUpdate(){
        
    }
    
    public void requestLock(String request){
        
    }
    
    public void returnLockRequest(String request){
        
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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDirectory;
    private javax.swing.JComboBox<File> addDirectoryComboBox;
    private javax.swing.JButton addFile;
    private javax.swing.JComboBox addFileComboBox;
    private javax.swing.JButton download;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
