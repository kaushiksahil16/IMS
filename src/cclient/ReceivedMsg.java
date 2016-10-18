package cclient;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class ReceivedMsg extends javax.swing.JDialog {
Socket s1;
JScrollPane jScrollPane1;
PrintStream ps;
JTable jt1;
BufferedReader br;
String usr;
String role;
String dp;
    public ReceivedMsg(java.awt.Frame parent,final Socket s1,String msg,final String usr,final String role,final String dp) {
        super(parent, true);
        this.usr=usr;
        this.dp=dp;
        this.role=role;
        initComponents();
        try
        {
        this.s1=s1;
        ps=new PrintStream(s1.getOutputStream());
        br=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        
        String row[]=msg.split("\\^");
        String col[]={"Message#","Date","From","Subject","Message"};
        Object [][]o=new Object[row.length][5];
        for(int i=0;i<row.length;i++){
        String data[]=row[i].split("\\|");
        o[i][0]=data[0];
        o[i][1]=data[1];
        o[i][2]=data[2];
        if(data[2].endsWith("...")){
        o[i][3]="BroadCast Message----"+data[3];
        o[i][2]=data[2].substring(0,data[2].length()-3);
        }
        else
        o[i][3]=data[3];
        o[i][4]=data[4];
        }
        final TextArea ta1=new TextArea("", 10, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);
        jt1=new JTable(o,col);

        jt1.addMouseListener(new MouseAdapter() {
        @Override
            public void mouseClicked(MouseEvent e){
        int x=jt1.getSelectedRow();
        String val=jt1.getValueAt(x, 4).toString();
        ta1.setText(val);
        String sub=jt1.getValueAt(x, 3).toString();
        if(sub.equals("File Received"))
        {
            DownloadFile df=new DownloadFile(new Profile(s1,dp,usr,role), s1, "Server",val);
            df.setBounds(200, 100, 400, 111);
            df.setVisible(true);
            
        }
        ps.println("msg read");
        ps.println(jt1.getValueAt(x,0).toString());
        }
        });
        jScrollPane1=new JScrollPane(jt1);
        jScrollPane1.setVisible(true);
        add(jScrollPane1,BorderLayout.CENTER);
        ta1.setEditable(false);
        add(ta1,BorderLayout.SOUTH);
        }catch(Exception e)
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cclient.CClientApp.class).getContext().getResourceMap(ReceivedMsg.class);
        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try
{
        int x=jt1.getSelectedRow();
        String val=jt1.getValueAt(x, 0).toString();
        ps.println("Delete");
        ps.println(val);
        String dmsg=br.readLine();
        if(dmsg.equals("Deleted"))
        {
            
        
            DefaultTableModel tm=(DefaultTableModel)jt1.getModel();
            tm.removeRow(x);
            jt1.setModel(tm);
           
        }
}catch(Exception e){System.out.println(e);}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
int x=jt1.getSelectedRow();
        String val=jt1.getValueAt(x, 2).toString();
        MessageBox mb=new MessageBox(new Profile(s1,dp,usr,role), val, usr, s1);
        mb.setBounds(200,100,588, 483);
        mb.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
