package facturacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interfaz_Login extends JFrame {

	private JPanel contentPane;
	private JTextField cedulatxt;
	private JPasswordField contrasenatxt;
	public static UsuarioLogeado userloged;
	public Interfaz_Login() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		JLabel lblCdula = new JLabel("Cédula:");
		lblCdula.setBounds(74, 62, 53, 15);
		contentPane.add(lblCdula);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(74, 89, 74, 15);
		contentPane.add(lblContrasea);
		
		cedulatxt = new JTextField();
		cedulatxt.setBounds(145, 60, 114, 19);
		contentPane.add(cedulatxt);
		cedulatxt.setColumns(10);
		
		contrasenatxt = new JPasswordField();
		contrasenatxt.setBounds(145, 87, 114, 19);
		contentPane.add(contrasenatxt);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 char clave[]=contrasenatxt.getPassword();
				 String clavedef=new String(clave);
				 ValidarLogin validador= new ValidarLogin();
				 if (validador.validar_ingreso(cedulatxt.getText(),clavedef)==1){

					 JOptionPane.showMessageDialog(null, "Bienvenido\n"+ "Has ingresado satisfactoriamente a"
					 		+ "l sistema",  null,JOptionPane.INFORMATION_MESSAGE);
                                      setVisible(false);
				      userloged = new UsuarioLogeado();
				      userloged.setPass(clavedef);
				      userloged.setUsuario(cedulatxt.getText());
				      new Interfaz_tipoFacturaAIngresar().setVisible(true);
				     
				      

				      }else {
	                    JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
	                    + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
	                    JOptionPane.ERROR_MESSAGE);
			}
			}
		});
		btnIngresar.setBounds(157, 131, 100, 25);
		contentPane.add(btnIngresar);
		
	}
}
