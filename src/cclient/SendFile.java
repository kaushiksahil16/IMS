package cclient;
import java.net.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;


public class SendFile extends javax.swing.JDialog {
Socket s1;
PrintStream ps;
BufferedReader br;
String fname="";
String fpath="";
String sname="";
String usr;
    
    public SendFile(java.awt.Frame parent,Socket s1,String sname,String usr) {
        super(parent, true);
        initComponents();
        this.s1=s1;
        this.sname=sname;
        this.usr=usr;
        try
        {
        br=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        ps=new PrintStream(s1.getOutputStream());
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cclient.CClientApp.class).getContext().getResourceMap(SendFile.class);
        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(null);

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(140, 50, 91, 23);

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(90, 230, 80, 23);

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(250, 230, 80, 23);

        jLabel2.setFont(resourceMap.getFont("jLabel2.font")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 120, 100, 15);

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(110, 120, 280, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try
{
        JFileChooser jfc=new JFileChooser();
       FileNameExtensionFilter filter = new FileNameExtensionFilter("Doc Files", "doc");
       jfc.setFileFilter(filter);
       int returnVal = jfc.showOpenDialog(null);
       if(returnVal == JFileChooser.APPROVE_OPTION) {
       fname=fname+jfc.getSelectedFile().getName();
       fpath=fpath+jfc.getSelectedFile().getPath();
       jLabel3.setText(fpath);
       }
}catch(Exception e){System.out.println(e);}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try
{
       ps.println("send file");
       ps.println(fname);  //File Name
       ps.println(sname); //Receiver
       ps.println(usr);   //Sender
       InputStream is=new FileInputStream(fpath);
       BufferedReader b=new BufferedReader(new InputStreamReader(is));
       OutputStream os=s1.getOutputStream();
       String s;
       while((s=b.readLine())!=null){
           ps.println(s);
        //   System.out.print(s);
       }
       ps.println("bye");
       os.flush();
       if(br.readLine().equals("File Delivered"))
           JOptionPane.showMessageDialog(this, "File Delivered");
       else
           JOptionPane.showMessageDialog(null, "Try Again");
}catch(Exception e){System.out.println(e);}
dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
