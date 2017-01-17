package facturacion;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rainy
 */
public class GastosPersonalesRegistro extends javax.swing.JFrame {

    /**
     * Creates new form GastosPersonales
     */
    
    control_existencias control = new control_existencias();
    public GastosPersonalesRegistro() 
    {
        initComponents();
        bloquearCajas();
        btnIngresar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        lblTipoGasto = new javax.swing.JLabel();
        lblLimiteGasto = new javax.swing.JLabel();
        txtLimiteGasto = new javax.swing.JTextField();
        lblAcumulado = new javax.swing.JLabel();
        txtAcumulado = new javax.swing.JTextField();
        lblAnio = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        txtTipoGasto = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTipoGasto.setText("Tipo Gasto");

        lblLimiteGasto.setText("Límite gasto");

        lblAcumulado.setText("Acumulado a la fecha");

        lblAnio.setText("Año");

        txtAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnioActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnIngresar)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtTipoGasto, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtAnio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                        .addComponent(lblAnio, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtAcumulado, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblAcumulado, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtLimiteGasto, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblLimiteGasto, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblTipoGasto, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(341, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblTipoGasto)
                .addGap(18, 18, 18)
                .addComponent(txtTipoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblLimiteGasto)
                .addGap(18, 18, 18)
                .addComponent(txtLimiteGasto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAcumulado)
                .addGap(18, 18, 18)
                .addComponent(txtAcumulado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAnio)
                .addGap(18, 18, 18)
                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnIngresar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnioActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        desbloquearCajas();
        btnIngresar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        if((!txtTipoGasto.getText().isEmpty())&&(!txtLimiteGasto.getText().isEmpty())&&(!txtAcumulado.getText().isEmpty())&&(!txtAnio.getText().isEmpty()))
        {
            String tipo, limite, acumulado, anio;
            tipo = txtTipoGasto.getText();
            limite = txtLimiteGasto.getText();
            acumulado = txtAcumulado.getText();
            anio = txtAnio.getText();
            double diferencia = Double.parseDouble(limite) - Double.parseDouble(acumulado);
            String dif = Double.toString(diferencia);
            String datos[] = {tipo, limite, acumulado, dif, anio};
            boolean insertar = control.getSentencia().insertar(datos, "insert into gastos_personales(tipo_gasto, limite_gasto, acumulado_a_fecha, diferencia, Anio) values (?,?,?,?,?)");
            if(insertar)
            {
                JOptionPane.showMessageDialog(null, "Se ha insertado el gasto exitosamente", "Proceso exitoso", JOptionPane.INFORMATION_MESSAGE);
                limpiar();
                bloquearCajas();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No se ha podido ingresar el gasto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No ha ingresado todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiar();
        bloquearCajas();
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    
    public void limpiar()
    {
        txtTipoGasto.setText("");
        txtLimiteGasto.setText("");
        txtAcumulado.setText("");
        txtAnio.setText("");
    }
    
    public void bloquearCajas()
    {
        txtTipoGasto.setEnabled(false);
        txtLimiteGasto.setEnabled(false);
        txtAcumulado.setEnabled(false);
        txtAnio.setEnabled(false);
    }
    
    public void desbloquearCajas()
    {
        txtTipoGasto.setEnabled(true);
        txtLimiteGasto.setEnabled(true);
        txtAcumulado.setEnabled(true);
        txtAnio.setEnabled(true);
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
            java.util.logging.Logger.getLogger(GastosPersonalesRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GastosPersonalesRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GastosPersonalesRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GastosPersonalesRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GastosPersonalesRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel lblAcumulado;
    private javax.swing.JLabel lblAnio;
    private javax.swing.JLabel lblLimiteGasto;
    private javax.swing.JLabel lblTipoGasto;
    private javax.swing.JTextField txtAcumulado;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtLimiteGasto;
    private javax.swing.JTextField txtTipoGasto;
    // End of variables declaration//GEN-END:variables
}