/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entities.Table;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Ad
 */
public class NewTable extends javax.swing.JDialog {

    /**
     * Creates new form NewTable
     */
    public NewTable(ContentMainDialog parent, boolean modal, ArrayList<Table> tables) {
        super(parent, modal);
        this.parent = parent;
        this.tables = tables;
        initComponents();
        prepareComponents();
        this.lblError.setText("");
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNgay = new javax.swing.JLabel();
        cbbNgay = new javax.swing.JComboBox();
        lblThang = new javax.swing.JLabel();
        cbbThang = new javax.swing.JComboBox();
        lblNam = new javax.swing.JLabel();
        cbbNam = new javax.swing.JComboBox();
        btnTaobang = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblNgay.setText("Ngày:");

        cbbNgay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNgayItemStateChanged(evt);
            }
        });
        cbbNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNgayActionPerformed(evt);
            }
        });

        lblThang.setText("Tháng:");

        cbbThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbThangItemStateChanged(evt);
            }
        });
        cbbThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbThangActionPerformed(evt);
            }
        });

        lblNam.setText("Năm:");

        cbbNam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNamItemStateChanged(evt);
            }
        });
        cbbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNamActionPerformed(evt);
            }
        });

        btnTaobang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnTaobang.setText("Tạo bảng");
        btnTaobang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaobangActionPerformed(evt);
            }
        });

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHeader.setText("Tạo Bảng Mới");

        lblError.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(172, Short.MAX_VALUE)
                .addComponent(lblNgay)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblThang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTaobang)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblHeader))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblError)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeader)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTaobang)
                    .addComponent(lblNgay)
                    .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThang)
                    .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNam)
                    .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblError)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prepareComponents() {
        DefaultComboBoxModel ngayModel = (DefaultComboBoxModel) cbbNgay.getModel();
        for (int i = 1; i < 32; i++) {
            ngayModel.addElement(i);
        }
        cbbNgay.setModel(ngayModel);
        DefaultComboBoxModel thangModel = (DefaultComboBoxModel) cbbThang.getModel();
        for (int i = 1; i < 13; i++) {
            thangModel.addElement(i);
        }
        cbbThang.setModel(thangModel);
        DefaultComboBoxModel namModel = (DefaultComboBoxModel) cbbNam.getModel();
        for (int i = 2010; i < 2015; i++) {
            namModel.addElement(i);
        }
        cbbNam.setModel(namModel);

        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_MONTH, -1);
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        cbbNgay.setSelectedItem(day);
        cbbThang.setSelectedItem(month + 1);
        cbbNam.setSelectedItem(year);

    }

    private boolean isToday() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        String today = day +"-"+ (month+1) +"-"+ year;
        if (cbbNam.getItemCount()>0 && cbbNgay.getItemCount()>0&& cbbThang.getItemCount()>0) {
            String ngay = cbbNgay.getSelectedItem().toString();
            String thang = cbbThang.getSelectedItem().toString();
            String nam = cbbNam.getSelectedItem().toString();
            String date = ngay + "-" + thang + "-" + nam;

            if (today.equals(date)) {
                return true;
            }
        }
        return false;
    }

    private void btnTaobangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaobangActionPerformed
        // TODO add your handling code here:
        String ngay = cbbNgay.getSelectedItem().toString();
        String thang = cbbThang.getSelectedItem().toString();
        String nam = cbbNam.getSelectedItem().toString();
        String date = ngay + "-" + thang + "-" + nam;

        if (parent.createTable(date)) {
            this.dispose();
        } else {
            lblError.setText("Bảng đã tồn tại");
        }
    }//GEN-LAST:event_btnTaobangActionPerformed

    private void cbbNgayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNgayItemStateChanged
        // TODO add your handling code here:
//        if (!isToday()) {
//            lblError.setText("Bạn đang thêm bảng vào ngày không phải hôm nay! Bạn có chắc vẫn muốn thêm bảng?");
//        }
    }//GEN-LAST:event_cbbNgayItemStateChanged

    private void cbbThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbThangItemStateChanged
        // TODO add your handling code here:
//        if (!isToday()) {
//            lblError.setText("Bạn đang thêm bảng vào ngày không phải hôm nay! Bạn có chắc vẫn muốn thêm bảng?");
//        }
    }//GEN-LAST:event_cbbThangItemStateChanged

    private void cbbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNamActionPerformed
        // TODO add your handling code here:
        if (!isToday()) {
            lblError.setText("Bạn đang thêm bảng vào ngày không phải hôm nay! Bạn có chắc vẫn muốn thêm bảng?");
        } else {
            lblError.setText("");
        }
    }//GEN-LAST:event_cbbNamActionPerformed

    private void cbbNamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNamItemStateChanged
        // TODO add your handling code here:
//        if (!isToday()) {
//            lblError.setText("Bạn đang thêm bảng vào ngày không phải hôm nay! Bạn có chắc vẫn muốn thêm bảng?");
//        }
    }//GEN-LAST:event_cbbNamItemStateChanged

    private void cbbNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNgayActionPerformed
        // TODO add your handling code here:
        if (!isToday()) {
            lblError.setText("Bạn đang thêm bảng vào ngày không phải hôm nay! Bạn có chắc vẫn muốn thêm bảng?");
        } else {
            lblError.setText("");
        }
    }//GEN-LAST:event_cbbNgayActionPerformed

    private void cbbThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbThangActionPerformed
        // TODO add your handling code here:
        if (!isToday()) {
            lblError.setText("Bạn đang thêm bảng vào ngày không phải hôm nay! Bạn có chắc vẫn muốn thêm bảng?");
        } else {
            lblError.setText("");
        }
    }//GEN-LAST:event_cbbThangActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(NewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(NewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(NewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(NewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                NewTable dialog = new NewTable(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaobang;
    private javax.swing.JComboBox cbbNam;
    private javax.swing.JComboBox cbbNgay;
    private javax.swing.JComboBox cbbThang;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblNam;
    private javax.swing.JLabel lblNgay;
    private javax.swing.JLabel lblThang;
    // End of variables declaration//GEN-END:variables
    private ContentMainDialog parent;
    private ArrayList<Table> tables;
}