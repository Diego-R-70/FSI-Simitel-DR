
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Diego
 */
public class FMedicamentos extends javax.swing.JFrame {

    Conexion2 cnx = new Conexion2();
    String todo = "SELECT * FROM medicamentos ORDER BY nombreme";

    public FMedicamentos() {
        initComponents();
        setLocationRelativeTo(this);

        if (cnx.conectar("127.0.0.1", "simitel", "root", "") == 1) {
            cnx.entablar(todo, TConsultas);
        } else {
            JOptionPane.showMessageDialog(this, "Sin conexión a la base de datos");
            System.exit(0);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        BRegistrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        BActualizar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        BBorrar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        TValor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TConsultas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Medicamentos");

        jToolBar1.setBackground(new java.awt.Color(0, 51, 102));
        jToolBar1.setRollover(true);

        BRegistrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BRegistrar.setText("REGISTRAR");
        BRegistrar.setFocusable(false);
        BRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BRegistrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(BRegistrar);
        jToolBar1.add(jSeparator1);

        BActualizar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BActualizar.setText("ACTUALIZAR");
        BActualizar.setFocusable(false);
        BActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BActualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(BActualizar);
        jToolBar1.add(jSeparator2);

        BBorrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BBorrar.setText("BORRAR");
        BBorrar.setFocusable(false);
        BBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BBorrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(BBorrar);

        jSeparator3.setMaximumSize(new java.awt.Dimension(20, 32767));
        jToolBar1.add(jSeparator3);

        TValor.setMaximumSize(new java.awt.Dimension(200, 40));
        TValor.setMinimumSize(new java.awt.Dimension(200, 40));
        TValor.setPreferredSize(new java.awt.Dimension(200, 40));
        TValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TValorKeyPressed(evt);
            }
        });
        jToolBar1.add(TValor);

        TConsultas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(TConsultas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TValorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TValorKeyPressed
        char tecla = evt.getKeyChar();

        if (tecla == '\n') {
            String call = "{call filtar_medicamento(?)}";

            try {
                CallableStatement cs = cnx.con.prepareCall(call);
                cs.setString(1, TValor.getText());
                cs.execute();
            } catch (SQLException ex) {
                System.out.println("Error al llamar al procemimiento");
            }
        }
    }//GEN-LAST:event_TValorKeyPressed

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
            java.util.logging.Logger.getLogger(FMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FMedicamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FMedicamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BActualizar;
    private javax.swing.JButton BBorrar;
    private javax.swing.JButton BRegistrar;
    private javax.swing.JTable TConsultas;
    private javax.swing.JTextField TValor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
