

package cclient;
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;


public class ChangePassword extends javax.swing.JDialog {
PrintStream ps;
BufferedReader br;
Socket s1;
String usr;
    public ChangePassword(java.awt.Frame parent,Socket s1,String usr) {
        super(parent,true);
        initComponents();
        this.s1=s1;
        this.usr=usr;
       try
       {
        ps=new PrintStream(s1.getOutputStream());
        br=new BufferedReader(new InputStreamReader(s1.getInputStream()));
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(this, e);
       }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cclient.CClientApp.class).getContext().getResourceMap(ChangePassword.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setBackground(resourceMap.getColor("Form.background")); // NOI18N
        setName("Form"); // NOI18N
        getContentPane().setLayout(null);

        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(80, 60, 110, 30);

        jLabel2.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(80, 110, 100, 30);

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 170, 120, 30);

        jPasswordField1.setBackground(resourceMap.getColor("jPasswordField1.background")); // NOI18N
        jPasswordField1.setText(resourceMap.getString("jPasswordField1.text")); // NOI18N
        jPasswordField1.setName("jPasswordField1"); // NOI18N
        jPanel1.add(jPasswordField1);
        jPasswordField1.setBounds(240, 120, 170, 20);

        jPasswordField2.setBackground(resourceMap.getColor("jPasswordField1.background")); // NOI18N
        jPasswordField2.setText(resourceMap.getString("jPasswordField2.text")); // NOI18N
        jPasswordField2.setName("jPasswordField2"); // NOI18N
        jPanel1.add(jPasswordField2);
        jPasswordField2.setBounds(240, 180, 170, 20);

        jPasswordField3.setBackground(resourceMap.getColor("jPasswordField1.background")); // NOI18N
        jPasswordField3.setText(resourceMap.getString("jPasswordField3.text")); // NOI18N
        jPasswordField3.setName("jPasswordField3"); // NOI18N
        jPasswordField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jPasswordField3);
        jPasswordField3.setBounds(240, 70, 170, 20);

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(120, 230, 73, 23);

        jLabel4.setFont(resourceMap.getFont("jLabel4.font")); // NOI18N
        jLabel4.setForeground(resourceMap.getColor("jLabel4.foreground")); // NOI18N
        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(150, 10, 170, 30);

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(290, 230, 73, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 480, 280);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try
{
ps.println("Change Password");
   
    char oldpswd[]=jPasswordField3.getPassword();
    char newpswd[]=jPasswordField1.getPassword();
    char cnfrmpswd[]=jPasswordField2.getPassword();
       ps.println(usr);
       ps.println(oldpswd);
       ps.println(newpswd);
       ps.println(cnfrmpswd);
       if(br.readLine().equals("True"))
       {
           JOptionPane.showMessageDialog(this, "Password Changed Successfully");
           dispose();
       }
           else
           {
           JOptionPane.showMessageDialog(this, "Try Again");
            jPasswordField1.setText("");
            jPasswordField2.setText("");
            jPasswordField3.setText("");
          }
}catch(Exception e)
{
    System.out.print(e);
}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    // End of variables declaration//GEN-END:variables

}
