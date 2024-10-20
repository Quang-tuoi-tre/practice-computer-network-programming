/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.io.File;
import java.io.IOException;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class ListFile extends javax.swing.JFrame {

    /**
     * Creates new form ListFile
     */
    public ListFile() {
        initComponents();
                this.setLocationRelativeTo(null);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fcPath = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        txtDuongDan = new javax.swing.JTextField();
        btnLietKe = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        LDanhSach = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        txtLocBo = new javax.swing.JTextField();
        btnDuongDan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Nhập đường dẫn");

        btnLietKe.setText("Liệt kê danh sách file");
        btnLietKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLietKeActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(LDanhSach);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Lọc bỏ các file không chứa ký tự");

        btnDuongDan.setText("Chọn Đường Dẫn");
        btnDuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDuongDanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLocBo, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLietKe)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDuongDan, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnDuongDan)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDuongDan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocBo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDuongDan))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLietKe)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(193, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLietKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLietKeActionPerformed
          File dir = new File(txtDuongDan.getText());
    File dsFile[] = dir.listFiles();
    
    if (dsFile == null) {
        JOptionPane.showMessageDialog(null, "Sai đường dẫn!");
    } else {
        try {
            DefaultListModel<String> dm = new DefaultListModel<>();
            String filter = txtLocBo.getText().toLowerCase(); // Get filter text and convert to lower case

            for (File file : dsFile) {
                String filename = file.getName();
                // Check if the filename contains the filter text
                if (filter.isEmpty() ||!filename.toLowerCase().contains(filter)) {
                    dm.addElement(filename);
                }
//                }else{
//                    String filenames = dsFile[i].getName();
//                    dm.addElement(filenames);
//
//                }
            }
            LDanhSach.setModel(dm);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    // TODO add your handling code here:
    }//GEN-LAST:event_btnLietKeActionPerformed

    private void btnDuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDuongDanActionPerformed
        this.fcPath.setVisible(true);
        fcPath.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        if(this.fcPath.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            try{
                txtDuongDan.setText(fcPath.getSelectedFile().getCanonicalPath());
            
        }catch(IOException e){
                JOptionPane.showMessageDialog(this,e);
                }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDuongDanActionPerformed
    
    public int layQuyenCuaNguoiDung(String userName) {
    // Trả về quyền của người dùng dựa trên userName
    // Ví dụ đơn giản, bạn có thể lấy từ database hoặc danh sách nào đó
    if (userName.equals("admin")) {
        return 2; // quyền full
    } else if (userName.equals("reader")) {
        return 0; // chỉ đọc
    } else if (userName.equals("writer")) {
        return 1; // chỉ ghi
    } else {
        return 3; // không có quyền
    }
}
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
            java.util.logging.Logger.getLogger(ListFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListFile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList LDanhSach;
    private javax.swing.JButton btnDuongDan;
    private javax.swing.JButton btnLietKe;
    private javax.swing.JFileChooser fcPath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtDuongDan;
    private javax.swing.JTextField txtLocBo;
    // End of variables declaration//GEN-END:variables
}
