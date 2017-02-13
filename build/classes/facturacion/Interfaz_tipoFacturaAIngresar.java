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
	boolean Admin=isAdmin(cedula);
	public Interfaz_tipoFacturaAIngresar() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
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
		lblBienvenido.setBounds(172, 22, 200, 15);
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
		
		JButton btnGastosPersonales = new JButton("Registrar gasto personal");
		btnGastosPersonales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new GastosPersonalesRegistro().setVisible(true);
			}
		});
		btnGastosPersonales.setBounds(231, 174, 187, 25);
		contentPane.add(btnGastosPersonales);
		
		JButton btnRegistrarNuevoGasto = new JButton("Registrar gasto personal");
		btnRegistrarNuevoGasto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            new TipoGastoNegocio().setVisible(true);
			}
		});
		btnRegistrarNuevoGasto.setBounds(125, 233, 209, 25);
		contentPane.add(btnRegistrarNuevoGasto);
                
                JButton btnReportes = new JButton("Generar Reportes");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            new InterfazReportes().setVisible(true);
			}
		});
		btnReportes.setBounds(125, 280, 209, 25);
		contentPane.add(btnReportes);
		if(Admin){
			btnGastosPersonales.setVisible(true);
			btnRegistrarNuevoGasto.setVisible(true);
			lblBienvenido.setText("Bienvenido Administrador");
		}else{
			btnGastosPersonales.setVisible(false);
			btnRegistrarNuevoGasto.setVisible(false);
		}

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

	            resultado+=rs.getString("Nombres");
	            resultado+=" ";
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
	private boolean isAdmin(String cedula2) {

	    String resultado="";
	    
	    String SSQL="SELECT Administrador FROM cliente WHERE documento='"+cedula2+"';";
	    System.out.println(SSQL);
	    Connection conect = null;
	    

	    try {
	    	conect=DriverManager.getConnection("jdbc:mysql://localhost/facturacioninterfaces","root","");
	        if (conect!=null){
	           System.out.println("Conexión para isadmin completa");
	        }
	        Statement st = conect.createStatement();
	        ResultSet rs = st.executeQuery(SSQL);
	        
	        if(rs.next()){

	            resultado = rs.getString("Administrador");
		            
	            System.out.println(resultado);
	        }

	    } catch (SQLException ex) {

	        JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);

	    }finally{


	        try {

	            conect.close();
	            System.out.println("conexion de isadmin cerrada");

	        } catch (SQLException ex) {

	            JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

	        }

	    }
	    if(resultado.equals("0")){
        	return false;
        }else{
        	return true;
        	}
	}
}

