package facturacion;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Interfaz_Presentacion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz_Presentacion frame = new Interfaz_Presentacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interfaz_Presentacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Dialog", Font.BOLD, 39));
		lblBienvenido.setBounds(123, 39, 229, 87);
		contentPane.add(lblBienvenido);
		
		JButton btnUsuarioRegistrado = new JButton("Usuario Registrado");
		btnUsuarioRegistrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Interfaz_Login frame = new Interfaz_Login();
				frame.setVisible(true);
			}
		});
		btnUsuarioRegistrado.setBounds(67, 188, 137, 25);
		contentPane.add(btnUsuarioRegistrado);
		
		JButton btnNuevoUsuario = new JButton("Nuevo Usuario");
		btnNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			new Interfaz_Clientes1().setVisible(true);	
			}
		});
		btnNuevoUsuario.setBounds(250, 188, 137, 25);
		contentPane.add(btnNuevoUsuario);
	}
}
