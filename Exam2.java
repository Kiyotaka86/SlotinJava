/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2;

import java.io.*;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author kioooo
 */
public class Exam2 extends javax.swing.JFrame {

    /**
     * Creates new form Exam2
     */
    public Exam2() {
        initComponents();
        c = (Canvas)jPanel1;
        
        
        if(credits>=5000)
            jButton1.setEnabled(false);
        else
            jButton1.setEnabled(true);
        
        jButton2.setEnabled(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new Box();
        jPanel2 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        jPanel1 = new Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Slots! Slots! Slots!");

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jButton1.setText("Load Credits");
        jButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jButton1ItemStateChanged(evt);
            }
        });
        jButton1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jButton1ComponentHidden(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jLabel1.setText(getCredits());
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setMaximumSize(new java.awt.Dimension(140, 14));
        jLabel1.setMinimumSize(new java.awt.Dimension(140, 14));
        jPanel3.add(jLabel1);

        jButton2.setText("Save Credits");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "250", "1000", "2500" }));
        jComboBox1.setSelectedIndex(1);
        jComboBox1.setMaximumSize(new java.awt.Dimension(150, 30));
        jPanel3.add(jComboBox1);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        jSlider1.setMaximum(1000);
        jSlider1.setOrientation(javax.swing.JSlider.VERTICAL);
        jSlider1.setToolTipText("");
        jSlider1.setValue(1000);
        jSlider1.setMaximumSize(new java.awt.Dimension(24, 327));
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider1MouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.EAST);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         int cretemp;
        try{
            File file = new File("credits.dat");
            FileReader fin = new FileReader(file);
            BufferedReader br = new BufferedReader(fin);
            if((cretemp = Integer.valueOf(br.readLine()))<5000)
                credits = 5000;
            else
                credits = cretemp;
        }catch (FileNotFoundException ex) {
           credits=5000;
        } catch (IOException ex) {
            System.out.println("the credits file is invalid format");
        }
        BufferedWriter write = null;
        try{
            File file = new File("credits.dat");
            FileWriter fin =new FileWriter(file);
            write = new BufferedWriter(fin);
            write.write(String.valueOf(0));
            write.close();
        }catch(IOException e){}
        
        jLabel1.setText(getCredits());
        jButton2.setEnabled(true);

        if(credits>=5000)
            jButton1.setEnabled(false);
        else
            jButton1.setEnabled(true);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jButton1ComponentHidden
      
    }//GEN-LAST:event_jButton1ComponentHidden

    private void jButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jButton1ItemStateChanged
      
    }//GEN-LAST:event_jButton1ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       BufferedWriter write = null;
        try{
            File file = new File("credits.dat");
            FileWriter fin =new FileWriter(file);
            write = new BufferedWriter(fin);
            write.write(String.valueOf(credits));
            write.close();
        }catch(IOException e){}
        
        credits = 0;
        jLabel1.setText(getCredits());
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
       

    }//GEN-LAST:event_jSlider1StateChanged

    private void jSlider1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseReleased
                jSlider1.getValue();
        
        if(jSlider1.getValue()==0){ 
           int wager = jComboBox1.getSelectedIndex();
            if(credits >0){
            if(wager == 0){
                if(credits>=250){
                    credits-=250;
                    c.genRams();
                    if(c.getRams()[0]==c.getRams()[1]&& c.getRams()[0]!=c.getRams()[2])
                        credits+=250*1.5;
                    else if(c.getRams()[0]==c.getRams()[1]&&c.getRams()[0]==c.getRams()[2])
                        credits+=250*6;
                }
                else{
                    credits =0;
                        c.genRams();
                    if(c.getRams()[0]==c.getRams()[1]&& c.getRams()[0]!=c.getRams()[2])
                        credits+=250*1.5;
                    else if(c.getRams()[0]==c.getRams()[1]&&c.getRams()[0]==c.getRams()[2])
                        credits+=250*6;
                }                
            }            
            else if (wager == 1){
                if(credits>=1000){
                    credits -=1000;
                    c.genRams();
                    if(c.getRams()[0]==c.getRams()[1]&& c.getRams()[0]!=c.getRams()[2])
                        credits+=1000*1.5;
                    else if(c.getRams()[0]==c.getRams()[1]&&c.getRams()[0]==c.getRams()[2])
                        credits+=1000*6;                    
                    
                }
                else{
                    credits =0;
                                    c.genRams();
                    if(c.getRams()[0]==c.getRams()[1]&& c.getRams()[0]!=c.getRams()[2])
                        credits+=1000*1.5;
                    else if(c.getRams()[0]==c.getRams()[1]&&c.getRams()[0]==c.getRams()[2])
                        credits+=1000*6;
                }
                    
            }    
            
            else{
                if(credits>=2500){
                    credits -=2500;
                    c.genRams();
                    if(c.getRams()[0]==c.getRams()[1]&& c.getRams()[0]!=c.getRams()[2])
                        credits+=2500*1.5;
                    else if(c.getRams()[0]==c.getRams()[1]&&c.getRams()[0]==c.getRams()[2])
                        credits+=2500*6;                
                }
                else{
                    credits =0;
            
                    c.genRams();
                    if(c.getRams()[0]==c.getRams()[1]&& c.getRams()[0]!=c.getRams()[2])
                        credits+=2500*1.5;
                    else if(c.getRams()[0]==c.getRams()[1]&&c.getRams()[0]==c.getRams()[2])
                    credits+=2500*6;
                }
            
            }
        

            
         jLabel1.setText(this.getCredits());
        }
        jSlider1.setValue(1000); }
    }//GEN-LAST:event_jSlider1MouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Exam2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exam2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exam2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exam2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exam2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSlider jSlider1;
    // End of variables declaration//GEN-END:variables
  int credits = 0;
  Canvas c;
  public String getCredits(){
      return String.valueOf(credits);
  }

}
