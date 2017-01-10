package facturacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import facturacion.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.synth.SynthStyleFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Interfaz_tipoFacturaAIngresar extends Interfaz_Login  {

	private JPanel contentPane;
	String cedula=userloged.getUsuario();
	String nombre=obtenerNombre(cedula);
	public Interfaz_tipoFacturaAIngresar() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIngresoFacturaManual = new JButton("Ingreso Factura Manual");
		btnIngresoFacturaManual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Registrar_factura().setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnIngresoFacturaManual.setBounds(32, 114, 187, 25);
		contentPane.add(btnIngresoFacturaManual);
		
		JButton btnIngresoFacturaElectronica = new JButton("Ingreso Factura Electronica");
		btnIngresoFacturaElectronica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new seleccion().setVisible(true);
			}
		});
		btnIngresoFacturaElectronica.setBounds(231, 114, 187, 25);
		contentPane.add(btnIngresoFacturaElectronica);
		
		JLabel lblUsuario = new JLabel("");
		lblUsuario.setFont(new Font("DejaVu Serif", Font.BOLD, 16));
		lblUsuario.setBounds(112, 52, 222, 25);
		contentPane.add(lblUsuario);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setBounds(172, 22, 102, 15);
		contentPane.add(lblBienvenido);
		lblUsuario.setText(nombre);
		
		JButton btnRegistroDeProveedores = new JButton(" Registro de proveedores");
		btnRegistroDeProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Interfaz_Registro_Proveedor form= new Interfaz_Registro_Proveedor();
				form.setVisible(true);
			}
		});
		btnRegistroDeProveedores.setBounds(32, 174, 187, 25);
		contentPane.add(btnRegistroDeProveedores);
		
		JButton btnGastosPersonales = new JButton("Gastos personales");
		btnGastosPersonales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GastosPersonales().setVisible(true);
			}
		});
		btnGastosPersonales.setBounds(231, 174, 187, 25);
		contentPane.add(btnGastosPersonales);

	}
	private String obtenerNombre(String cedula2) {

	    String resultado="";
	    
	    String SSQL="SELECT Nombres,Apellidos FROM cliente WHERE documento='"+cedula2+"';";
	    System.out.println(SSQL);
	    Connection conect = null;
	    

	    try {
	    	conect=DriverManager.getConnection("jdbc:mysql://localhost/facturacioninterfaces","root","");
	        if (conect!=null){
	           System.out.println("Conexión para nombre completa");
	        }
	        Statement st = conect.createStatement();
	        ResultSet rs = st.executeQuery(SSQL);
	        
	        if(rs.next()){

	            resultado+=rs.getString("Nombres"+" ");
	            resultado+=rs.getString("Apellidos");
	            System.out.println(resultado);
	        }

	    } catch (SQLException ex) {

	        JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);

	    }finally{


	        try {

	            conect.close();
	            System.out.println("conexion de nombre cerrada");

	        } catch (SQLException ex) {

	            JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

	        }

	    }
	return resultado;

	}
}

