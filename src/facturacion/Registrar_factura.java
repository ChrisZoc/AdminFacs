package facturacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class Registrar_factura extends JFrame {

	private JPanel contentPane;
	Sentencias_sql sensql = new Sentencias_sql();
	private JTextField txtRuc;
	private JTextField txtValor;
	private JTextField ivatxt;
	private JTextField txtTotal;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrar_factura frame = new Registrar_factura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Registrar_factura() throws ParseException {
		control_existencias controlExistencias = new control_existencias();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboProove = new JComboBox();
		comboProove.setSelectedIndex(-1);
		comboProove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int j=comboProove.getSelectedIndex();
				if(j>0){

					String proveedor = (String) comboProove.getSelectedItem();		
					System.out.println(proveedor);
					cargarDatosProveedor(j);
				}else{
				}
			}

			private void cargarDatosProveedor(int j) {
				control_proveedor con = new control_proveedor("No_documento","Tipo de documento","Nombre","Apellido","Nombre_comercial","Direccion","Ciudad","telefono");       
		        String[] columnas = {"Documento","Tipo de documento","Nombre","Apellido","Nombre_comercial","Direccion","Ciudad","Telefono"};
		        String[][] documentos = (String[][]) con.consulta_proveedor();
		        txtRuc.setText(documentos[j-1][0]);
		        
			}
		});
		comboProove.setBounds(107, 38, 177, 24);
		contentPane.add(comboProove);
		Object[] prov = controlExistencias.combox("proveedor","Nombre_comercial");
        comboProove.removeAllItems();
        comboProove.addItem("Seleccione un proveedor");
        for(int i=0;i<prov.length;i++){
        comboProove.addItem(prov[i]);
    }
        
		JLabel lblProveedores = new JLabel("Proveedores");
		lblProveedores.setBounds(26, 43, 87, 15);
		contentPane.add(lblProveedores);
		
		txtRuc = new JTextField();
		txtRuc.setEditable(false);
		txtRuc.setEnabled(false);
		txtRuc.setBounds(347, 38, 114, 22);
		contentPane.add(txtRuc);
		txtRuc.setColumns(10);
		
		JLabel lblRuc = new JLabel("RUC");
		lblRuc.setBounds(297, 43, 53, 15);
		contentPane.add(lblRuc);

	    MaskFormatter mascara = new MaskFormatter("##-##-#########");
		JFormattedTextField txtnumFac = new JFormattedTextField(mascara);
		txtnumFac.setBounds(107, 74, 177, 24);
		contentPane.add(txtnumFac);
		
		JLabel lblNFactura = new JLabel("N° factura");
		lblNFactura.setBounds(26, 78, 76, 15);
		contentPane.add(lblNFactura);
		
		JDateChooser fechaFactura = new JDateChooser();
		Calendar today = Calendar.getInstance();
		fechaFactura.setDate(today.getTime());
		fechaFactura.setBounds(347, 72, 114, 26);
		contentPane.add(fechaFactura);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(297, 78, 53, 15);
		contentPane.add(lblFecha);
		
		JComboBox combGasto = new JComboBox();
        Object[] tipo = controlExistencias.combox("tipo_articulo","descripcion_articulo");
        combGasto.removeAllItems();
        combGasto.addItem("Seleccione un tipo");
        for(int i=0;i<tipo.length;i++){
        combGasto.addItem(tipo[i]);
    }
        combGasto.setBounds(119, 155, 137, 24);
		contentPane.add(combGasto);
		
		JTextArea Areatxt = new JTextArea();
		Areatxt.setBounds(97, 191, 237, 77);
		contentPane.add(Areatxt);
		
		txtValor = new JTextField();
		txtValor.setBounds(324, 158, 76, 19);
		contentPane.add(txtValor);
		txtValor.setColumns(10);
		int contador=0;
		ArrayList<String> valor=new ArrayList<>();
		ArrayList<String> TipoGasto=new ArrayList<>();
		JButton btnGuardar = new JButton("Guardar gasto y continuar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboProove.getSelectedIndex()==0||txtnumFac.getText().replace("-","").trim().equals("")||combGasto.getSelectedIndex()==0||txtValor.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios revise y vuelva a ingresar");
				}else{
				comboProove.setEnabled(false);
				txtnumFac.setEnabled(false);
				fechaFactura.setEnabled(false);
				valor.add(txtValor.getText());
				TipoGasto.add((String) combGasto.getSelectedItem());
				Areatxt.append((String) combGasto.getSelectedItem()+", "+txtValor.getText()+"\n");
				}
				
				
				
			}
		});
		btnGuardar.setBounds(347, 208, 189, 25);
		contentPane.add(btnGuardar);
		
		
		
		ivatxt = new JTextField();
		ivatxt.setBounds(171, 275, 114, 19);
		contentPane.add(ivatxt);
		ivatxt.setColumns(10);
		
		JLabel txtIva = new JLabel("IVA");
		txtIva.setBounds(100, 277, 53, 15);
		contentPane.add(txtIva);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(170, 310, 114, 19);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(100, 312, 53, 15);
		contentPane.add(lblTotal);
		
		JButton btnNewButton = new JButton("Finalizar Registro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				combGasto.setEnabled(false);
				txtValor.setEnabled(false);
				Areatxt.setEnabled(false);
				btnGuardar.setEnabled(false);
				ivatxt.setEnabled(false);
				int total=0;
				for (int i = 0; i < valor.size(); i++) {
					total += Integer.parseInt(valor.get(i));
				}
				double totalFinal=((double) total)*((double) Integer.parseInt((ivatxt.getText()))/100);
				System.out.println(totalFinal);
				txtTotal.setText(String.valueOf(totalFinal));
				guardarEnBase();

			}

			private void guardarEnBase() {
JOptionPane.showMessageDialog(null, "El registro se realizo con éxito");
			}
		});
		btnNewButton.setBounds(236, 365, 153, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblTipoDeGasto = new JLabel("Tipo de Gasto");
		lblTipoDeGasto.setBounds(142, 128, 114, 15);
		contentPane.add(lblTipoDeGasto);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(347, 128, 53, 15);
		contentPane.add(lblValor);
		
	}
}
