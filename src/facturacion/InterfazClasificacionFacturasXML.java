/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facturacion;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Rainy
 */
public class InterfazClasificacionFacturasXML extends javax.swing.JFrame {

    /**
     * Creates new form InterfazClasificacionFacturasXML
     */
    
    control_existencias controlExistencias = new control_existencias();
    private java.sql.Connection connection = null;
    private java.sql.ResultSet res;
    private String usuario = "1718927716";
    private java.util.ArrayList<String> arreglodetalles = new ArrayList<>();
    public InterfazClasificacionFacturasXML() {
        initComponents();
        cmbDetallesFactura.setEnabled(false);
        cmbTipoGasto.setEnabled(false);
        btnIngresarGastos.setEnabled(false);
        cmbDetallesFactura.removeAllItems();
        cmbTipoGasto.removeAllItems();
        try {
                    connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/pruebafacturas", "root", "");

                } catch (SQLException e) {
                    System.out.println("Connection Failed! Check output console");
                    e.printStackTrace();
                    return;
                }

                if (connection != null) {
                    System.out.println("You made it, take control your database now!");
                } else {
                    System.out.println("Failed to make connection!");
                }////conexi�n
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpTipoFactura = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        rbtGastosNegocio = new javax.swing.JRadioButton();
        rbtGastosPersonales = new javax.swing.JRadioButton();
        btnIngresarGastos = new javax.swing.JButton();
        btnNuevaFactura = new javax.swing.JButton();
        lblDetallesFactura = new javax.swing.JLabel();
        lblTipoGasto = new javax.swing.JLabel();
        cmbDetallesFactura = new javax.swing.JComboBox();
        cmbTipoGasto = new javax.swing.JComboBox();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        grpTipoFactura.add(rbtGastosNegocio);
        rbtGastosNegocio.setText("Gastos de Negocio");

        grpTipoFactura.add(rbtGastosPersonales);
        rbtGastosPersonales.setText("Gastos Personales");

        btnIngresarGastos.setText("Ingresar Gastos");
        btnIngresarGastos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarGastosActionPerformed(evt);
            }
        });

        btnNuevaFactura.setText("Nueva Factura");
        btnNuevaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaFacturaActionPerformed(evt);
            }
        });

        lblDetallesFactura.setText("Detalles de Factura");

        lblTipoGasto.setText("Tipo de Gasto");

        cmbDetallesFactura.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbTipoGasto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSalir.setText("Salir");
        btnSalir.setToolTipText("");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtGastosNegocio)
                    .addComponent(btnNuevaFactura)
                    .addComponent(lblDetallesFactura)
                    .addComponent(cmbDetallesFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIngresarGastos)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalir))
                    .addComponent(rbtGastosPersonales)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbTipoGasto, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTipoGasto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtGastosNegocio)
                    .addComponent(rbtGastosPersonales))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDetallesFactura)
                    .addComponent(lblTipoGasto))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbDetallesFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresarGastos)
                    .addComponent(btnNuevaFactura)
                    .addComponent(btnSalir))
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaFacturaActionPerformed
        // TODO add your handling code here:
        if(grpTipoFactura.getSelection().isSelected())
        {
            Date d= new Date();
            Calendar c = new GregorianCalendar();
            c.setTime(d);
            try {
                String formapago = "1";
                res = connection.createStatement().executeQuery("select secuencial from infoTributaria where id=(select max(id) from infoTributaria)");
                String codigoFactura = res.getString("secuencial");
                res = connection.createStatement().executeQuery("select totalSinImpuestos from infoTributaria where id = (select max(id) from infoTributaria)");
                String totalFactura = res.getString("totalSinImpuestos");
                res = connection.createStatement().executeQuery("select totalDescuento from infoTributaria where id = (select max(id) from infoTributaria)");
                String IVA = res.getString("totalDescuento");
                String dia = Integer.toString(c.get(Calendar.DATE));
                String mes = Integer.toString(c.get(Calendar.MONTH));
                String anio = Integer.toString(c.get(Calendar.YEAR));
                String fecha = dia+"/"+mes+"/"+anio;
                String datos[] ={codigoFactura,usuario,"Desconocido", fecha, formapago, totalFactura, IVA};
                controlExistencias.getSentencia().insertar(datos, "insert into factura (Nmn_factura,cod_cliente, Nombre_empleado, Fecha_facturacion, cod_formapago, total_factura, IVA) values (?,?,?,?,?,?,?)");
            } catch (SQLException ex) {
                Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(rbtGastosNegocio.isSelected())
            {
                cmbDetallesFactura.setEnabled(true);
                cmbTipoGasto.setEnabled(true);
                Object[] tipo_doc = controlExistencias.combox("tipo_gasto_negocio","descripcion_tipo_gasto_negocio");
                for(int i=0;i<tipo_doc.length;i++)
                    cmbTipoGasto.addItem(tipo_doc[i]);
                
                cmbTipoGasto.setSelectedIndex(-1);
                try {
                    res = connection.createStatement().executeQuery("select descripcion from detalle");
                    while(res.next())
                    {
                        cmbDetallesFactura.addItem(res.getString("descripcion"));
                        //arreglodetalles.add(res.getString("descripcion"));
                    }
                    cmbDetallesFactura.setSelectedIndex(-1);
                } catch (SQLException ex) {
                    Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            }
            else if(rbtGastosPersonales.isSelected())
            {
               cmbDetallesFactura.setEnabled(true);
               cmbTipoGasto.setEnabled(true);
               cmbTipoGasto.addItem("Alimentación");
               cmbTipoGasto.addItem("Vestimenta");
               cmbTipoGasto.addItem("Salud");
               cmbTipoGasto.addItem("Educación");
               cmbTipoGasto.addItem("Vivienda");
               cmbTipoGasto.addItem("Otros");
               cmbTipoGasto.setSelectedIndex(-1);
               
               try {
                    res = connection.createStatement().executeQuery("select descripcion from detalle");
                    while(res.next())
                    {
                        cmbDetallesFactura.addItem(res.getString("descripcion"));
                        arreglodetalles.add(res.getString("descripcion"));
                    }
                    cmbDetallesFactura.setSelectedIndex(-1);
                } catch (SQLException ex) {
                    Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
            else
            {
                JOptionPane.showMessageDialog(null, "No ha seleccionado el tipo de factura","Error", JOptionPane.ERROR_MESSAGE);
                
            }
        }
    }//GEN-LAST:event_btnNuevaFacturaActionPerformed
    
    public void limpiarBaseTransitoria() {
        try {
            String vaciarTablaInfoFactura = "Delete from infoFactura";
            String vaciarTablaInfoTributaria = "Delete from infoTributaria";
            String vaciarTablaInfoAdicional = "Delete from infoAdicional";
            String vaciarDetalle = "Delete from detalle";
            String vaciarImpuesto = "Delete from impuesto";
            
            connection.createStatement().execute(vaciarDetalle);
            connection.createStatement().execute(vaciarImpuesto);
            connection.createStatement().execute(vaciarTablaInfoAdicional);
            connection.createStatement().execute(vaciarTablaInfoFactura);
            connection.createStatement().execute(vaciarTablaInfoTributaria);
        } catch (SQLException ex) {
            Logger.getLogger(seleccion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void btnIngresarGastosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarGastosActionPerformed
        // TODO add your handling code here:
        if((cmbDetallesFactura.getSelectedIndex()==-1)||(cmbTipoGasto.getSelectedIndex()==-1))
        {
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningún elemento");
        }
        else
        {
            
        }
    }//GEN-LAST:event_btnIngresarGastosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
        limpiarBaseTransitoria();
    }//GEN-LAST:event_btnSalirActionPerformed

    public void limpiarCajas()
    {
        grpTipoFactura.clearSelection();
        cmbDetallesFactura.setSelectedIndex(-1);
        cmbTipoGasto.setSelectedIndex(-1);
        
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
            java.util.logging.Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazClasificacionFacturasXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazClasificacionFacturasXML().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresarGastos;
    private javax.swing.JButton btnNuevaFactura;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox cmbDetallesFactura;
    private javax.swing.JComboBox cmbTipoGasto;
    private javax.swing.ButtonGroup grpTipoFactura;
    private javax.swing.JLabel lblDetallesFactura;
    private javax.swing.JLabel lblTipoGasto;
    private javax.swing.JRadioButton rbtGastosNegocio;
    private javax.swing.JRadioButton rbtGastosPersonales;
    // End of variables declaration//GEN-END:variables
}
