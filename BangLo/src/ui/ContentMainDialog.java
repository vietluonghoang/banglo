/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entities.Customer;
import entities.So;
import entities.SoOfDay;
import entities.Table;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import utilities.Level;
import utilities.ReadingFromWeb;

/**
 *
 * @author Ad
 */
public class ContentMainDialog extends javax.swing.JDialog {

    /**
     * Creates new form ContentMainDialog
     */
    public ContentMainDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        prepareComponents();
        showKetqua();
        this.setVisible(true);
    }

    private void prepareComponents() {
        DefaultComboBoxModel ketquaModel = (DefaultComboBoxModel) cbbKetqua.getModel();
        ketquaModel.addElement("Xổ Số Miền Bắc");
        cbbKetqua.setModel(ketquaModel);
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
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        cbbNgay.setSelectedItem(day);
        cbbThang.setSelectedItem(month + 1);
        cbbNam.setSelectedItem(year);

        khach = new ArrayList<Customer>();
        tables = new ArrayList<Table>();
        initData();
    }

    private void initData(){
        for(int i=0;i<10;i++){
            Customer c=new Customer("khach "+i, "abc"+i, i);
            khach.add(c);
        }
        Table tb=new Table("11-11-2013");
        for(int i=0;i<10;i++){
            So s=new So(""+(i+10), i+20, khach.get(i), "11-11-2013");
            tb.addSo(s);
        }
        tables.add(tb);
    }
    private void showKetqua() {
        String ketqua = cbbKetqua.getSelectedItem().toString();
        String ngay = cbbNgay.getSelectedItem().toString();
        String thang = cbbThang.getSelectedItem().toString();
        String nam = cbbNam.getSelectedItem().toString();
        String date = ngay + "-" + thang + "-" + nam;
        ReadingFromWeb rfw = new ReadingFromWeb(date);
        result = rfw.getLevelsOfDay();
        DefaultTableModel dtm = (DefaultTableModel) tblKetqua.getModel();
        dtm.getDataVector().removeAllElements();
        if (result != null) {
            for (Level level : result) {
                dtm.addRow(new String[]{level.getLevel(), level.getResult()});
            }
        } else {
            dtm.addRow(new String[]{"", "Không có kết quả!"});
        }
        tblKetqua.setModel(dtm);
    }

    public boolean newCustomer(String name, String contact) {        
        if (khach == null) {
            khach = new ArrayList<>();
        }
        int id = 0;        
        for (Customer cus : khach) {
            if (cus.getId() > id) {
                id = cus.getId();
            }
        }
        if (!isNameExisted(name)) {
            khach.add(new Customer(name, contact, id + 1));
            return true;
        }
        return false;
    }

    public ArrayList<Customer> getAllCustomer() {
        return khach;
    }

    private Customer findCustomerByID(int id) {
        for (Customer customer : khach) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public void editCustomer(int id) {
        Customer cus = findCustomerByID(id);
        EditCustomer ec = new EditCustomer(this, true, cus);
    }

    public boolean isNameExisted(String name) {        
        for (Customer cust : khach) {
            if (cust.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean createTable(String date){        
        for (Table table : tables) {
            if(table.getDate().equals(date)){
                return false;
            }
        }
        Table tbl=new Table(date);
        tables.add(tbl);
        return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainPanel = new javax.swing.JPanel();
        cbbThang = new javax.swing.JComboBox();
        lblNgay = new javax.swing.JLabel();
        cbbKetqua = new javax.swing.JComboBox();
        lblKetqua = new javax.swing.JLabel();
        lblThang = new javax.swing.JLabel();
        cbbNgay = new javax.swing.JComboBox();
        btnXemKetqua = new javax.swing.JButton();
        lblNam = new javax.swing.JLabel();
        cbbNam = new javax.swing.JComboBox();
        spKetqua = new javax.swing.JScrollPane();
        tblKetqua = new javax.swing.JTable();
        mnbMain = new javax.swing.JMenuBar();
        mnKhack = new javax.swing.JMenu();
        mniThemkhack = new javax.swing.JMenuItem();
        mniXemtatcakhach = new javax.swing.JMenuItem();
        mnThaotac = new javax.swing.JMenu();
        mniTaobang = new javax.swing.JMenuItem();
        mniSuabang = new javax.swing.JMenuItem();
        mniThemso = new javax.swing.JMenuItem();
        mniXemtatcabang = new javax.swing.JMenuItem();
        mnThongke = new javax.swing.JMenu();
        mniThongketheokhach = new javax.swing.JMenuItem();
        mniThongketheobang = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblNgay.setText("Ngày:");

        cbbKetqua.setActionCommand("");
        cbbKetqua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKetquaActionPerformed(evt);
            }
        });

        lblKetqua.setText("Kết quả:");

        lblThang.setText("Tháng:");

        btnXemKetqua.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXemKetqua.setText("Xem");
        btnXemKetqua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemKetquaActionPerformed(evt);
            }
        });

        lblNam.setText("Năm:");

        tblKetqua.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", ""
            }
        ));
        spKetqua.setViewportView(tblKetqua);

        javax.swing.GroupLayout pnlMainPanelLayout = new javax.swing.GroupLayout(pnlMainPanel);
        pnlMainPanel.setLayout(pnlMainPanelLayout);
        pnlMainPanelLayout.setHorizontalGroup(
            pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainPanelLayout.createSequentialGroup()
                        .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMainPanelLayout.createSequentialGroup()
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
                                .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlMainPanelLayout.createSequentialGroup()
                                .addComponent(lblKetqua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbKetqua, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34)
                        .addComponent(btnXemKetqua)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spKetqua, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlMainPanelLayout.setVerticalGroup(
            pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMainPanelLayout.createSequentialGroup()
                        .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKetqua)
                            .addComponent(cbbKetqua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNgay)
                            .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThang)
                            .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNam)
                            .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlMainPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btnXemKetqua)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spKetqua, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        mnKhack.setText("Khách");

        mniThemkhack.setText("Thêm khách");
        mniThemkhack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniThemkhackActionPerformed(evt);
            }
        });
        mnKhack.add(mniThemkhack);

        mniXemtatcakhach.setText("Xem tất cả");
        mniXemtatcakhach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniXemtatcakhachActionPerformed(evt);
            }
        });
        mnKhack.add(mniXemtatcakhach);

        mnbMain.add(mnKhack);

        mnThaotac.setText("Bảng");

        mniTaobang.setText("Tạo bảng");
        mniTaobang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniTaobangActionPerformed(evt);
            }
        });
        mnThaotac.add(mniTaobang);

        mniSuabang.setText("Sửa bảng");
        mnThaotac.add(mniSuabang);

        mniThemso.setText("Thêm số");
        mnThaotac.add(mniThemso);

        mniXemtatcabang.setText("Xem tất cả");
        mniXemtatcabang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniXemtatcabangActionPerformed(evt);
            }
        });
        mnThaotac.add(mniXemtatcabang);

        mnbMain.add(mnThaotac);

        mnThongke.setText("Thống kê");

        mniThongketheokhach.setText("Theo khách");
        mnThongke.add(mniThongketheokhach);

        mniThongketheobang.setText("Theo bảng");
        mnThongke.add(mniThongketheobang);

        mnbMain.add(mnThongke);

        setJMenuBar(mnbMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbKetquaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKetquaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbKetquaActionPerformed

    private void btnXemKetquaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemKetquaActionPerformed
        // TODO add your handling code here:
        showKetqua();
    }//GEN-LAST:event_btnXemKetquaActionPerformed

    private void mniThemkhackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniThemkhackActionPerformed
        // TODO add your handling code here:
        NewCustomer nc = new NewCustomer(this, true);
    }//GEN-LAST:event_mniThemkhackActionPerformed

    private void mniXemtatcakhachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniXemtatcakhachActionPerformed
        // TODO add your handling code here:
        ViewAllCustomer vac = new ViewAllCustomer(this, true);
    }//GEN-LAST:event_mniXemtatcakhachActionPerformed

    private void mniTaobangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniTaobangActionPerformed
        // TODO add your handling code here:
        NewTable nt=new NewTable(this, true, tables);
    }//GEN-LAST:event_mniTaobangActionPerformed

    private void mniXemtatcabangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniXemtatcabangActionPerformed
        // TODO add your handling code here:
        ViewTables vt=new ViewTables(this, true,tables,khach);
    }//GEN-LAST:event_mniXemtatcabangActionPerformed

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
//            java.util.logging.Logger.getLogger(ContentMainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ContentMainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ContentMainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ContentMainDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                ContentMainDialog dialog = new ContentMainDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnXemKetqua;
    private javax.swing.JComboBox cbbKetqua;
    private javax.swing.JComboBox cbbNam;
    private javax.swing.JComboBox cbbNgay;
    private javax.swing.JComboBox cbbThang;
    private javax.swing.JLabel lblKetqua;
    private javax.swing.JLabel lblNam;
    private javax.swing.JLabel lblNgay;
    private javax.swing.JLabel lblThang;
    private javax.swing.JMenu mnKhack;
    private javax.swing.JMenu mnThaotac;
    private javax.swing.JMenu mnThongke;
    private javax.swing.JMenuBar mnbMain;
    private javax.swing.JMenuItem mniSuabang;
    private javax.swing.JMenuItem mniTaobang;
    private javax.swing.JMenuItem mniThemkhack;
    private javax.swing.JMenuItem mniThemso;
    private javax.swing.JMenuItem mniThongketheobang;
    private javax.swing.JMenuItem mniThongketheokhach;
    private javax.swing.JMenuItem mniXemtatcabang;
    private javax.swing.JMenuItem mniXemtatcakhach;
    private javax.swing.JPanel pnlMainPanel;
    private javax.swing.JScrollPane spKetqua;
    private javax.swing.JTable tblKetqua;
    // End of variables declaration//GEN-END:variables
    private String[] loOfDay;
    private ArrayList<Level> result;
    private ArrayList<Customer> khach;
    private ArrayList<Table> tables;
}
