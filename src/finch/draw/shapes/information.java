/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finch.draw.shapes;

import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author space
 */
public class information extends javax.swing.JFrame {

    /**
     * Creates new form information
     */
    
    private String largestShape, allInputs, mostDrawnShape;
    
    
    public information(){
        
    }
    public information(String newlargestShape, String newallInputs, String newmostDrawnShape) {
        initComponents();
        largestShape = newlargestShape;
        allInputs = newallInputs;
        mostDrawnShape = newmostDrawnShape;
        outputList();
        showLargestShape();
        showMostDrawShape();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        largestShapeLabel = new javax.swing.JLabel();
        mostDrawnShapeLabel = new javax.swing.JLabel();
        outPutLogLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputLogList = new javax.swing.JList<>();
        quitButton = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Information Window");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        largestShapeLabel.setText("Largest Shape:");

        mostDrawnShapeLabel.setText("Most Drawn Shape:");

        outPutLogLabel.setText("Output Log:");

        outputLogList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(outputLogList);

        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mostDrawnShapeLabel)
                            .addComponent(largestShapeLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(outPutLogLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(quitButton)))
                .addContainerGap(521, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(largestShapeLabel)
                .addGap(18, 18, 18)
                .addComponent(mostDrawnShapeLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outPutLogLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(quitButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        // TODO add your handling code here:
        try{
        shutDownApplication();
        }catch(IOException ex){
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_quitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new information().setVisible(true);
            }
        });
    }
    public void outputList(){
        String[] data = allInputs.split("\\r?\\n");
        
        DefaultListModel listModel = new DefaultListModel();
        for(int i = 0; i < data.length; i++){
            listModel.addElement(data[i]);
        }
        outputLogList.setModel(listModel);
    }
    
    public void showMostDrawShape(){
        mostDrawnShapeLabel.setText(mostDrawnShapeLabel.getText() + mostDrawnShape);
    }
    
    public void showLargestShape(){
        largestShapeLabel.setText(largestShapeLabel.getText() + largestShape);
    }
    
    public void shutDownApplication() throws IOException{
        int yorn = JOptionPane.showConfirmDialog(this,"Do you want to save this data for later?", "Yes or No", JOptionPane.YES_NO_OPTION);
            if(yorn == JOptionPane.YES_OPTION){
                Random rand = new Random();
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("\\savedLog" + rand.nextInt(99)+".txt")));
                out.println(allInputs);
                out.flush();
                out.close();
            }
        new PrintWriter(new BufferedWriter(new FileWriter("\\shapeLog.txt", false)));
        this.dispose();
        System.exit(0);
    }
     @Override
    public void processWindowEvent(WindowEvent e) {
        try{
            if (e.getID() == WindowEvent.WINDOW_CLOSING) {
                new PrintWriter(new BufferedWriter(new FileWriter("\\shapeLog.txt", false)));
                this.dispose();
                System.exit(0);
            }   
        }catch(IOException ex){
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel largestShapeLabel;
    private javax.swing.JLabel mostDrawnShapeLabel;
    private javax.swing.JLabel outPutLogLabel;
    private javax.swing.JList<String> outputLogList;
    private javax.swing.JButton quitButton;
    // End of variables declaration//GEN-END:variables
}
