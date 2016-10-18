package cclient;
import java.io.*;
import java.net.*;
import javax.swing.*;
import javax.swing.table.*;

public class TrackConversation extends javax.swing.JDialog {

 PrintStream ps;
 BufferedReader br;
 Socket s1;
 String usr;
 String role;
    public TrackConversation(java.awt.Frame parent,Socket s1,String users,String usr,String role) {
        super(parent, true);
        initComponents();
        this.s1=s1;
        this.usr=usr;
        this.role=role;

        try
        {
        ps=new PrintStream(s1.getOutputStream());
        br=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        String usrs[]=users.split("\\|");
        if(role.equals("a"))
        {
        for(int i=0;i<usrs.length;i++)
        {
            jComboBox1.addItem(usrs[i]);
            jComboBox2.addItem(usrs[i]);
        }
        }
        else
        {
            jComboBox1.addItem(usr);
            for(int i=0;i<usrs.length;i++)
        {
            jComboBox2.addItem(usrs[i]);
        }
        }
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this, e);
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Form"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cclient.CClientApp.class).getContext().getResourceMap(TrackConversation.class);
        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(null);

        jComboBox1.setBackground(resourceMap.getColor("jComboBox1.background")); // NOI18N
        jComboBox1.setName("jComboBox1"); // NOI18N
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(40, 90, 170, 20);

        jComboBox2.setBackground(resourceMap.getColor("jComboBox2.background")); // NOI18N
        jComboBox2.setName("jComboBox2"); // NOI18N
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(250, 90, 160, 20);

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(440, 90, 70, 23);

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(537, 90, 70, 23);

        jLabel1.setFont(resourceMap.getFont("jLabel1.font")); // NOI18N
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 30, 530, 20);

        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTable1.setBackground(resourceMap.getColor("jTable1.background")); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "To", "From", "Subject", "Message"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setName("jTable1"); // NOI18N
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setName("jTextArea1"); // NOI18N
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 158, 630, 360);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
try
{
}catch(Exception e){
    JOptionPane.showMessageDialog(this, e);
}

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try
{
   
    ps.println("SHOW");
    ps.println(jComboBox1.getSelectedItem());
    ps.println(jComboBox2.getSelectedItem());
    String trackmsg=br.readLine();
    DefaultTableModel tm = (DefaultTableModel) this.jTable1.getModel();
        for (int i = tm.getRowCount() - 1; i >= 0; i--) {
            tm.removeRow(i);
        }
     if(trackmsg.length()>0)
     {
    String row[]=trackmsg.split("\\^");
    for(int i=0;i<row.length;i++){
         String data[]=row[i].split("\\|");
           tm.addRow(data);
    }

    }
    else
    {
         jTextArea1.setText("");
        JOptionPane.showMessageDialog(this, "No Conversation");
       
    }
    }
catch(Exception e)
{
    System.out.println(e);
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
int x=jTable1.getSelectedRow();
        String val=jTable1.getValueAt(x, 4).toString();
        jTextArea1.setText(val);
        jTextArea1.setEditable(false);
    }//GEN-LAST:event_jTable1MouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
