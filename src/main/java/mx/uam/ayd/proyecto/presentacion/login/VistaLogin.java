package mx.uam.ayd.proyecto.presentacion.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.ProyectoApplication;
import mx.uam.ayd.proyecto.presentacion.agregarUsuario.ControlAgregarUsuario;
import mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador.VistaAdministrador;
import mx.uam.ayd.proyecto.presentacion.notificarSolitudAceptada.ControlnotificarSolicitudAceptada;
import mx.uam.ayd.proyecto.presentacion.notificarSolitudAceptada.VistanotificarSolicitudAceptada;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

/*
 * @author BurbujasMaravillosas
 */


@SuppressWarnings("serial")
@Component
public class VistaLogin extends JFrame implements ActionListener {
	static final String ADMIN = "Administrador";
	static final String CLIENTE = "Cliente";
	static final String OPER = "Operaciones";
	
	public static long idUsuario;
	
	String tipo = "";
	@Autowired
	private ControlVistaLogin verificausuario;
	
	@Autowired
	private ControlPrincipal controlPincipal;
	
	private JPanel contentPane;
	
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	private JComboBox <String> cbTipoUsuario;
	
	private JButton btnLogin;
	
	private ImageIcon icon1;
	private Image imagen;
	private ImageIcon imagen1;
	
	private String[] tipoUsuario = {"Administrador", "Cliente", "Operaciones"};
	
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaLogin frame = new VistaLogin();
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
	public VistaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 148, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		icon1 = new ImageIcon(getClass().getResource("logo.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(70,70,100)); //Tamaño de imagen ancho, alto
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setBounds(37, 6, 75, 60);
		lblLogo.setIcon(imagen1);
		contentPane.add(lblLogo);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(6, 78, 130, 16);
		contentPane.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(6, 104, 130, 26);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setBounds(6, 142, 130, 16);
		contentPane.add(lblPassword);
		
		cbTipoUsuario = new JComboBox<String>();
		cbTipoUsuario.setModel(new DefaultComboBoxModel(tipoUsuario));
		cbTipoUsuario.setBounds(6, 208, 130, 27);
		contentPane.add(cbTipoUsuario);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(6, 247, 130, 29);
		btnLogin.addActionListener(this);
		contentPane.add(btnLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(6, 170, 130, 26);
		contentPane.add(txtPassword);
	}
	
	public void muestra(ControlPrincipal control) {
		
		controlPincipal = control;
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnLogin) {            
			 
		 	 String user = txtUsuario.getText();
		 	 String pass = txtPassword.getText();
		 	 
		 	 if(user.equals("") || pass.equals("")) {  //Valida si los campos usuario y contraseña son vacios
	            	JOptionPane.showMessageDialog(null, "Ingrese usuario y contraseña");
	            	txtUsuario.requestFocus(); //puntero del mouse va al txtField
	         }else {
	           	if(user != null && pass != null) {
	           		
	           		if(cbTipoUsuario.getSelectedItem() == tipoUsuario[0]) {
	           			tipo=ADMIN;       			
	           			verificausuario.validaDatos(user, pass, tipo);
	           			
	           		}else{
	           			if(cbTipoUsuario.getSelectedItem() == tipoUsuario[1]) {
		           			tipo=CLIENTE;
		           			verificausuario.validaDatos(user, pass, tipo);
	           			}else {
	           			   if(cbTipoUsuario.getSelectedItem() == tipoUsuario[2]) {
	           				   tipo=OPER;
	           				   verificausuario.validaDatos(user, pass, tipo);
	           				 
	           			   }
	           				
	           				
	           			}
	           		}
	           		
	           		txtUsuario.setText("");
	           		txtPassword.setText("");
	           		
	           	}         
	         }
		}	
	} //Fin del escuchador
}

