
package cclient;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import javax.swing.*;
import java.net.*;
import java.io.*;

public class Login extends FrameView {
Socket s1;
BufferedReader br;
PrintStream ps;

    public Login(SingleFrameApplication app) {
        super(app);
        try{
        String name=JOptionPane.showInputDialog("wats ur name?");
        s1=new Socket("localhost",1111);
        br=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        ps=new PrintStream(s1.getOutputStream());
        ps.println(name);
        }catch(UnknownHostException e){System.out.println(e);}
        catch(IOException e){System.out.println(e);}
        initComponents();

        ResourceMap resourceMap = getResourceMap();
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                } else if ("done".equals(propertyName)) {
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = CClientApp.getApplication().getMainFrame();
            aboutBox = new CClientAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        CClientApp.getApplication().show(aboutBox);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cclient.CClientApp.class).getContext().getResourceMap(Login.class);
        mainPanel.setBackground(resourceMap.getColor("mainPanel.background")); // NOI18N
        mainPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        mainPanel.setName("mainPanel"); // NOI18N
        mainPanel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                mainPanelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        mainPanel.setLayout(null);

        jLabel1.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        mainPanel.add(jLabel1);
        jLabel1.setBounds(80, 90, 63, 20);

        jTextField1.setBackground(resourceMap.getColor("jPasswordField1.background")); // NOI18N
        jTextField1.setText(resourceMap.getString("jTextField1.text")); // NOI18N
        jTextField1.setName("jTextField1"); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        mainPanel.add(jTextField1);
        jTextField1.setBounds(170, 90, 170, 20);

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        mainPanel.add(jLabel2);
        jLabel2.setBounds(80, 130, 59, 20);

        jButton1.setFont(resourceMap.getFont("jButton1.font")); // NOI18N
        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        mainPanel.add(jButton1);
        jButton1.setBounds(330, 180, 70, 23);

        jPasswordField1.setBackground(resourceMap.getColor("jPasswordField1.background")); // NOI18N
        jPasswordField1.setText(resourceMap.getString("jPasswordField1.text")); // NOI18N
        jPasswordField1.setName("jPasswordField1"); // NOI18N
        mainPanel.add(jPasswordField1);
        jPasswordField1.setBounds(170, 130, 170, 20);

        jLabel4.setFont(resourceMap.getFont("jLabel4.font")); // NOI18N
        jLabel4.setForeground(resourceMap.getColor("jLabel4.foreground")); // NOI18N
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        mainPanel.add(jLabel4);
        jLabel4.setBounds(70, 30, 320, 40);

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setForeground(resourceMap.getColor("jLabel3.foreground")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        mainPanel.add(jLabel3);
        jLabel3.setBounds(110, 180, 190, 15);

        setComponent(mainPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       System.out.println("connect");
        ps.println("Login");
        ps.println(jTextField1.getText());
        ps.println(jPasswordField1.getPassword());
        try{
            String role=br.readLine();
            String res=br.readLine();
            
        if(res.equals("Yes"))
        {
            getFrame().setVisible(false);
            String dp=br.readLine();
            Profile pr=new Profile(s1,dp,jTextField1.getText(),role);
            pr.setBounds(200,100,700,500);
            pr.setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this.getFrame(), "Invalid Username or Password");
            jTextField1.setText("");
            jPasswordField1.setText("");
        }
        }catch(IOException e){
        System.out.println(e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void mainPanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_mainPanelAncestorAdded
    }//GEN-LAST:event_mainPanelAncestorAdded

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

    private JDialog aboutBox;
}
