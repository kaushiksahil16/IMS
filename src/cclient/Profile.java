package cclient;
import java.net.*;
import javax.swing.tree.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;


public class Profile extends javax.swing.JFrame {
Socket s1;
BufferedReader br;
PrintStream ps;
String dp;
JTree jTree1;
JPopupMenu jpm;
JMenuItem jmi1,jmi2,jmi3;
String usr;
String role;
public void count()
{
    try
    {
    int x=0;
ps.println("Unread Messages");
ps.println(usr);
x=Integer.parseInt(br.readLine());
jLabel2.setText(" "+x+" Unread Messages ");
    }catch(Exception e){JOptionPane.showMessageDialog(this, e);}
    }

public Profile(final Socket s1,String dp,final String usr,String role) {
        this.dp=dp;
        this.s1=s1;
        this.usr=usr;
        this.role=role;
        try{
            
        br=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        ps=new PrintStream(s1.getOutputStream());
        initComponents();
        ps.println("Unread Messages");
        ps.println(usr);
        String num=br.readLine();
        jLabel2.setText(" "+num+" Unread Messages ");
        ps.println("Show Online");
        String name=br.readLine();
        String oname[]=name.split("\\,");
        DefaultMutableTreeNode n=new DefaultMutableTreeNode("Departments");
        jTree1=new JTree(n);
        JScrollPane jsp=new JScrollPane(jTree1);
        add(jsp,BorderLayout.CENTER);
        StringTokenizer st=new StringTokenizer(dp,"|",false);
        DefaultMutableTreeNode n1=null;
        while(st.hasMoreTokens()){
            String dpt=st.nextToken();
            n1=new DefaultMutableTreeNode(dpt);
            n.add(n1);

            String emp=st.nextToken();
            StringTokenizer stt=new StringTokenizer(emp,",",false);
            while(stt.hasMoreTokens()){
                String e="";
                e=e+stt.nextToken();
                for(int i=0;i<oname.length;i++)
                {
                if(e.equals(oname[i]))
                {
                e=e+"*";
                }
                }
            DefaultMutableTreeNode n2=new DefaultMutableTreeNode(e);
            n1.add(n2);
            }
        }
        jpm=new JPopupMenu();
        jmi1=new JMenuItem("View Profile");
        jmi2=new JMenuItem("Send Message");
        jmi3=new JMenuItem("Send File");
        jpm.add(jmi1);
        jpm.add(jmi2);
        jpm.add(jmi3);
        jTree1.setComponentPopupMenu(jpm);
        final JFrame f1=this;
        final String us=usr;
        jmi2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
               String s=jTree1.getSelectionPath().toString();
                    int ind=s.lastIndexOf(",");
                    s=s.substring(ind+1,s.length()-1);
                    ind=s.lastIndexOf("(");
                    s=s.substring(0,ind);
                    s=s.trim();
                    MessageBox m1=new MessageBox(f1,s,us,s1);
                    m1.setBounds(200,100,588, 483);
                    m1.setVisible(true);

            }

        });
        jmi1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                try
                {
                    ps.println("User Profile");
                    String s=jTree1.getSelectionPath().toString();
                    int ind=s.lastIndexOf(",");
                    s=s.substring(ind+1,s.length()-1);
                    StringTokenizer st1=new StringTokenizer(s,"(",false);
                    String ename=st1.nextToken();
                    ps.println(ename);
                String udetail=br.readLine();
              UserProfile up=new UserProfile(f1,s1,udetail);
              up.setBounds(200,100,492, 355);
              up.setVisible(true);
                }
                catch(Exception e){
                        System.out.println(e);
            }
            }
        });
        jmi3.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    String s=jTree1.getSelectionPath().toString();
                    int ind=s.lastIndexOf(",");
                    s=s.substring(ind+1,s.length()-1);
                    ind=s.lastIndexOf("(");
                    s=s.substring(0,ind);
                    s=s.trim();
                    SendFile sf=new SendFile(f1, s1,s,usr);
                    sf.setBounds(200,100,432, 310);
                    sf.setVisible(true);
                    
                }
            });


        
    }catch(Exception e){System.out.println(e);}
        jTree1.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent me)
            {
             TreePath tp=jTree1.getPathForLocation(me.getX(),me.getY());
             if(tp!=null)
             {
                if(me.getButton()==MouseEvent.BUTTON3)
        jpm.show(jTree1,me.getX(),me.getY());
             }
            }

        });
          if(role.equals("a"))
          {
              jButton4.setVisible(true);
          }
          else
          {
              jButton4.setVisible(false);
          }

       }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(cclient.CClientApp.class).getContext().getResourceMap(Profile.class);
        setTitle(resourceMap.getString("Form.title")); // NOI18N
        setName("Form"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jButton1.setText(resourceMap.getString("jButton1.text")); // NOI18N
        jButton1.setName("jButton1"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(resourceMap.getColor("jLabel2.background")); // NOI18N
        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jButton1)))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setBackground(resourceMap.getColor("jPanel2.background")); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N

        jButton2.setText(resourceMap.getString("jButton2.text")); // NOI18N
        jButton2.setName("jButton2"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBackground(resourceMap.getColor("jPanel3.background")); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText(resourceMap.getString("jButton6.text")); // NOI18N
        jButton6.setName("jButton6"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton5.setText(resourceMap.getString("jButton5.text")); // NOI18N
        jButton5.setName("jButton5"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton7.setText(resourceMap.getString("jButton7.text")); // NOI18N
        jButton7.setName("jButton7"); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addGap(33, 33, 33))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(26, 26, 26)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jButton7))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
        ps.println("My Messages");
        ps.println(usr);
        String umsg;
        umsg=br.readLine();
        if(umsg.length()>0){
        ReceivedMsg r1=new ReceivedMsg(this, s1,umsg,usr,dp,role);
        r1.setBounds(200,100,700,500);
        r1.setVisible(true);
        }
        else
            JOptionPane.showMessageDialog(this,"No messages for this user");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
ps.println("Logged Out");
ps.println(usr);
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
MessageBox m1=new MessageBox(this, "...", usr, s1);
m1.setBounds(200,100,588, 483);
m1.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
try
{
        jButton1.doClick();
        count();

}catch(Exception e){
JOptionPane.showMessageDialog(this, e);
}
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
Register r=new Register(s1);
r.setBounds(200,100,444, 547);
r.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
ChangePassword cp =new ChangePassword(this, s1, usr);
cp.setBounds(200,100,482, 277);
cp.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
try
{
ps.println("conversation");
String users=br.readLine();
TrackConversation tr=new TrackConversation(this, s1,users,usr,role);
tr.setBounds(200, 100,646, 554 );
tr.setVisible(true);
}
catch(Exception e)
{
    System.out.println(e);
}
    }//GEN-LAST:event_jButton6ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
ps.println("Logged Out");
ps.println(usr);
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
dispose();
Profile p=new Profile(s1, dp, usr, role);
p.setBounds(200,100,700,500);
p.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}