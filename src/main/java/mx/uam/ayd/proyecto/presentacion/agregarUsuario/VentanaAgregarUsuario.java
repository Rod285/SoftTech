package mx.uam.ayd.proyecto.presentacion.agregarUsuario;


import javax.swing.JFrame;
import javax.swing.JPanel;
/*import javax.swing.border.EmptyBorder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
//import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;

/*
 * @author Jonathan Eslava
 */


@SuppressWarnings("serial")
@Component
public class VentanaAgregarUsuario extends JFrame {

	private JPanel contentPane, contentSig, content3, content4;
	private ControlAgregarUsuario control;
	@Autowired
	private ControlAgregarUsuario verificausuario;
	@Autowired
	private ControlAgregarUsuario verificacorreo;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEdad;
	private JTextField textFieldTelefono;
	private JTextField textFieldContrasenia;
	private JTextField textFieldCorreo;
	private JTextField textFieldConfiCorreo;
	private JTextField textFieldConfiContrasenia;
	private JTextField textFieldCodigo;
	private JComboBox <String> comboBoxGrupo;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarUsuario frame = new VentanaAgregarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaAgregarUsuario() {
		
		//CREA LA VENTANA
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,600);
		setTitle("Registra Usuario");
		setLayout(null);
		setLocationRelativeTo(null);
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//CREACION DEL PANEL 1 
		contentPane = new JPanel();
		contentPane.setBounds(5, 80, 450, 500);//setBounds(100, 100, 292, 266);
		//contentPane.setBorder(new EmptyBorder(5, 112, 350, 350));//ORIGINALMENTE SOLO ERA 5
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		add(contentPane);
		contentPane.setVisible(true);
		
		//CREACION DEL PANEL 2
		contentSig = new JPanel();
		contentSig.setBounds(5, 80, 450, 500);//setBounds(100, 100, 292, 266);
		//contentSig.setBorder(new EmptyBorder(5, 5, 5, 5));//ORIGINALMENTE SOLO ERA 5
		//setContentPane(contentSig);
		contentSig.setLayout(null);
		add(contentSig);
		contentSig.setVisible(false);
		
		//CREACION DEL PANEL 3
		content3 = new JPanel();
		content3.setBounds(5, 80, 450, 500);//setBounds(100, 100, 292, 266);
		//contentSig.setBorder(new EmptyBorder(5, 5, 5, 5));//ORIGINALMENTE SOLO ERA 5
		//setContentPane(contentSig);
		content3.setLayout(null);
		add(content3);
		content3.setVisible(false);
		
		//CREACION DEL PANEL 4
		content4 = new JPanel();
		content4.setBounds(5, 80, 450, 500);//setBounds(100, 100, 292, 266);
		//contentSig.setBorder(new EmptyBorder(5, 5, 5, 5));//ORIGINALMENTE SOLO ERA 5
		//setContentPane(contentSig);
		content4.setLayout(null);
		add(content4);
		content4.setVisible(false);
		
		//CREACION DEL TITULO
		JLabel lblTite = new JLabel("Montalvo Picture Cars");
		lblTite.setBounds(180, 28, 180, 16);
		add(lblTite);//contentPane.add(lblTite);
		
		JLabel lblMeseg = new JLabel("MVL");
		lblMeseg.setBounds(225, 10, 180, 16);
		add(lblMeseg);//contentPane.add(lblMese);
		
		JLabel lblMese = new JLabel("Registro");
		lblMese.setBounds(210, 45, 180, 16);
		add(lblMese);//contentPane.add(lblMese);
		
		JLabel lblSub = new JLabel("¡Facil y Sencillo!");
		lblSub.setBounds(195, 65, 180, 16);
		add(lblSub);//contentPane.add(lblSub);
		
		//ETIQUETAS 
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 110, 80, 16);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(240, 110, 80, 16);
		contentPane.add(lblApellido);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setBounds(28, 190, 110, 16);
		contentPane.add(lblEdad);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(240, 190, 80, 16);
		contentPane.add(lblTelefono);
		
		//CUADRO DE TEXTO 
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(92, 109, 130, 26);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(320, 109, 130, 26);
		contentPane.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldEdad = new JTextField();
		textFieldEdad.setBounds(92, 190, 130, 26);
		contentPane.add(textFieldEdad);
		textFieldEdad.setColumns(10);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(320, 190, 130, 26);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);
		
		//LLAMA AL METODO 
		siguiente();
		PanelVeri();
		PanelFinal();
		String codi="1910";
		
		//BOTON AGREGA
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(330, 340, 117, 29);//original btnAgregar.setBounds(28, 189, 117, 29);
		content4.add(btnAgregar);//contentPane.add(btnAgregar);
		
		//BOTON CANCELAR
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.termina();
			}
		});
		btnCancelar.setBounds(28, 340, 117, 29); //original btnCancelar.setBounds(157, 189, 117, 29);
		contentPane.add(btnCancelar);//contentPane.add(btnCancelar);

		//BOTON SIGUIENTE EN EL PANEL NOMBRE APELLIDO
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(330, 340, 117, 29);
		contentPane.add(btnSiguiente);//contentPane.add(btnSiguiente);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSiguiente) {
					//VERIFICA QUE LOS CAMPOS NO ESTEN VACIOS Y SI ES ASI NO DEJA AVANZAR
					if(textFieldNombre.getText().equals("") || textFieldApellido.getText().equals("")||textFieldTelefono.getText().equals("")||textFieldEdad.getText().equals("")) {
					muestraDialogoConMensaje("Ningun campo debe estar vacio");
				}else {//MUESTRA EL SIGUIENTE PANEL
					verificausuario.Recupera(textFieldNombre.getText(), textFieldApellido.getText());
					contentPane.setVisible(false);
					contentSig.setVisible(true);
				}//FIN DEL ELSE
				}//FIN DEL IF BOTON SIGUIENTE
			}//FIN DEL METODO
		});//TERMINA ACTIONLISTENER

		//BOTON SIGUIENTE 2 EN EL PANEL DE CORREOS
		JButton btnSiguiente2 = new JButton("Siguiente");
		btnSiguiente2.setBounds(330, 340, 117, 29);
		contentSig.add(btnSiguiente2);//contentPane.add(btnSiguiente);
		btnSiguiente2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSiguiente2) {
					//VERIFICA QUE LOS CAMPOS NO ESTEN VACIOS Y SI ES ASI NO DEJA AVANZAR
					if(textFieldCorreo.getText().equals("") || textFieldContrasenia.getText().equals("")||textFieldConfiCorreo.getText().equals("")||textFieldConfiContrasenia.getText().equals("")) {
					muestraDialogoConMensaje("Ningun campo debe estar vacio");
					}else {
					//VERIFICA QUE LOS CAMPOS DE CONTRASEÑA Y DE CORREO COINCIDAN
					if(textFieldCorreo.getText().equals(textFieldConfiCorreo.getText()) && textFieldContrasenia.getText().equals(textFieldConfiContrasenia.getText())) {
					verificacorreo.recuperaCorreo(textFieldCorreo.getText());
					contentPane.setVisible(false);
				    contentSig.setVisible(false);
				    content3.setVisible(true);
				    muestraDialogoConMensaje("Su codigo de verificcion es 1910");
				    
				    /*Properties propiedad= new Properties();
					propiedad.setProperty("mail.smtp.host","smtp.gmail.com");
					propiedad.setProperty("mail smtp starttls enable","true");
					propiedad.setProperty("mail.smtp.port","587");
					propiedad.setProperty("mail smtp auth","true");
					
					Session sesion = Session.getDefaultInstance(propiedad);
					
					String correoEnvia="picturecars7@gmail.com";
					String contraseniaEnvia="Burbujas2021";
					String correo=textFieldCorreo.getText();
					String asunto="Codigo de Verificacion";
					String mensaje="191021";
					
					MimeMessage mail=new MimeMessage(sesion);
					
					try {
						mail.setFrom(new InternetAddress(correoEnvia));
						mail.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
						mail.setSubject(asunto);
						mail.setText(mensaje);
						Transport transporte = sesion.getTransport("smtp");
						transporte.connect(correoEnvia,contraseniaEnvia);
						transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
						transporte.close();
						JOptionPane.showMessageDialog(null,"Se esta enviando un correo de verificacion");
					} catch (AddressException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (MessagingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
				        }else {
				        	muestraDialogoConMensaje("Los campos no coinciden por favor rectifique si escribio bien su contraseña o su correo");
				        	}//FIN DEL ELSE DE CUADROS DE TEXTO NO COINCIDEN
					}//FIN DEL ESE DE NINGUN CAMPO VACIO
				}//FIN DEL IF BOTON SIGUIENTE
			}//FIN DEL METODO ACTION PERFORMED
		});//FIN DEL ACTION LISTENER
		
		//BOTON SIGUIENTE 3 CODIGO DE VERIFICACION
		JButton btnSiguiente3 = new JButton("Siguiente");
		btnSiguiente3.setBounds(330, 340, 117, 29);
		content3.add(btnSiguiente3);//contentPane.add(btnSiguiente);
		btnSiguiente3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnSiguiente3) {
					//VERIFICA QUE LOS CAMPOS NO ESTEN VACIOS Y SI ES ASI NO DEJA AVANZAR
					if(textFieldCodigo.getText().equals("")) {
					muestraDialogoConMensaje("Escriba el codigo por favor");
				}else {//MUESTRA EL SIGUIENTE PANEL
					if(textFieldCodigo.getText().equals(codi)) {
						contentPane.setVisible(false);
					    contentSig.setVisible(false);
					    content3.setVisible(false);
					    content4.setVisible(true);
					    }else {
					    	muestraDialogoConMensaje("Codigo incorrecto escribalo de nuevo");
					    	contentPane.setVisible(false);
						    contentSig.setVisible(false);
						    content3.setVisible(true);
						    content4.setVisible(false);
					    }
				}//FIN DEL ELSE
				}//FIN DEL IF BOTON SIGUIENTE
			}//FIN DEL METODO ACTION PERFORMED
		});//FIN DEL ACTION LISTENER	
				
		//BOTON ATRAS CUANDO ESTA EN EL PANEL CORREO
		JButton btnAtras = new JButton("Atras");
		btnAtras.setBounds(28, 340, 117, 29);
		contentSig.add(btnAtras);//contentPane.add(btnAtras);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MUESTRA EL PANEL ANTERIOR
				if(e.getSource()==btnAtras) {
					contentSig.setVisible(false);
					contentPane.setVisible(true);
				}//FIN DEL IF
			}//FIN DEL METODO ACTION PERFORMED
		});//FIN DEL ACTION LISTENER
		
		//BOTON ATRAS 2 EN EL PANEL CODIGO DE VERIFICACION
	    JButton btnAtras2 = new JButton("Atras");
		btnAtras2.setBounds(28, 340, 117, 29);
		content3.add(btnAtras2);//contentPane.add(btnAtras);
		btnAtras2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MUESTRA EL PANEL ANTERIOR
				if(e.getSource()==btnAtras2) {
					contentPane.setVisible(false);
					content3.setVisible(false);
					contentSig.setVisible(true);
				}//FIN DEL IF
			}//FIN DEL METODO ACTION PERFORMED
		});//FIN DEL ACTION LISTENER
		
		//BOTON ATRAS 3 CUANDO ESTA SELECCIONANDO SU PERFIL
		JButton btnAtras3 = new JButton("Atras");
		btnAtras3.setBounds(28, 340, 117, 29);
		content4.add(btnAtras3);//contentPane.add(btnAtras);
		btnAtras3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAtras3) {
					//MUESTRA EL PANEL ANTERIOR
					contentPane.setVisible(false);
					content4.setVisible(false);
					contentSig.setVisible(false);
					content3.setVisible(true);
					
				}//FIN DEL IF
			}//FIN DEL METODO ACTION PERFORMED
		});//FIN DEL ACTION LISTENER
		
		//BOTON ACEPTAR
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(270, 200, 117, 29);
		content3.add(btnAceptar);//contentPane.add(btnAtras);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAceptar) {
					//VERIFICA QUE LOS CAMPOS NO ESTEN VACIOS Y SI ES ASI NO DEJA AVANZAR
					if(textFieldCodigo.getText().equals("")) {
					muestraDialogoConMensaje("Escriba el codigo por favor");
				}else {//MUESTRA EL SIGUIENTE PANEL
					if(textFieldCodigo.getText().equals(codi)) {
					contentPane.setVisible(false);
				    contentSig.setVisible(false);
				    content3.setVisible(true);
				    content4.setVisible(false);
				    }else {
				    	muestraDialogoConMensaje("Codigo incorrecto escribalo de nuevo recuerde que son cuatro numeros");
				    	contentPane.setVisible(false);
					    contentSig.setVisible(false);
					    content3.setVisible(true);
					    content4.setVisible(false);
				    }
				}//FIN DEL ELSE
				}//FIN DEL IF BOTON SIGUIENTE
			}//FIN DEL METODO ACTION PERFORMED
		});	//FIN DEL METODO ACTION LISTENER
		
		//BOTON ENVIAR CODIGO DE NUEVO
		JButton btnEnviacode = new JButton("Enviar codigo de nuevo");
		btnEnviacode.setBounds(38, 200, 200, 29);
		content3.add(btnEnviacode);//contentPane.add(btnAtras);
		btnEnviacode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnEnviacode) {
					muestraDialogoConMensaje("Su codigo de verificcion es 1910");
					content3.setVisible(true);
				}//FIN DEL IF
			}//FIN DEL METODO ACTION PERDORMED
		});//FIN DEL METODO ACTION LISTENER
		
		//LISTA DE GRUPO
        JLabel lblGrupo = new JLabel("Perfil");
		lblGrupo.setBounds(100, 140, 61, 16);//originales lblGrupo.setBounds(28, 127, 61, 16);
		content4.add(lblGrupo);//contentPane.add(lblGrupo);
		comboBoxGrupo = new JComboBox<>();
		comboBoxGrupo.setBounds(165, 140, 200, 16);//originales comboBoxGrupo.setBounds(92, 123, 130, 27);
		content4.add(comboBoxGrupo);//contentPane.add(comboBoxGrupo);
		
		// Listeners
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldNombre.getText().equals("") || textFieldApellido.getText().equals("")) {
					muestraDialogoConMensaje("El nombre y el apellido no deben estar vacios");
				} else {
					control.agregaUsuario(textFieldNombre.getText(), textFieldApellido.getText(), textFieldEdad.getText(), textFieldTelefono.getText(), textFieldCorreo.getText(), textFieldContrasenia.getText(), (String) comboBoxGrupo.getSelectedItem());
					contentPane.setVisible(true);
				    contentSig.setVisible(false);
				    content3.setVisible(false);
				    content4.setVisible(false);
				    limpia();
				}
			}
		});
	
	}
	
	//METODO QUE INICIALIZA EL CONTENIDO DEL PANEL 2 CORREOS
	private void siguiente() {

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(28, 100, 80, 16);
		contentSig.add(lblCorreo);
		
		JLabel lblContrasenia = new JLabel("Contraseña:");
		lblContrasenia.setBounds(240, 100, 80, 16);
		contentSig.add(lblContrasenia);
		
		JLabel lblConfiCorreo = new JLabel("Confirma Correo:");
		lblConfiCorreo.setBounds(28, 170, 110, 16);
		contentSig.add(lblConfiCorreo);
		
		JLabel lblConfiContrasenia = new JLabel("Confirma Contraseña:");
		lblConfiContrasenia.setBounds(240, 170, 130, 16);
		contentSig.add(lblConfiContrasenia);
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(92, 109, 130, 26);
		contentSig.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		textFieldContrasenia = new JTextField();
		textFieldContrasenia.setBounds(320, 109, 130, 26);
		contentSig.add(textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		textFieldConfiCorreo = new JTextField();
		textFieldConfiCorreo.setBounds(92, 190, 130, 26);
		contentSig.add(textFieldConfiCorreo);
		textFieldConfiCorreo.setColumns(10);
		
		textFieldConfiContrasenia = new JTextField();
		textFieldConfiContrasenia.setBounds(320, 190, 130, 26);
		contentSig.add(textFieldConfiContrasenia);
		textFieldConfiContrasenia.setColumns(10);
		
	}//FIN DEL METODO PANEL 2 CORREOS
	
	//METODO QUE INICIALIZA LOS COMPONENTES DEL PANEL 3 CODIGO
	private void PanelVeri() {
		JLabel lblCodigo = new JLabel("Escriba el codigo de Verificacion:");
		lblCodigo.setBounds(145, 100, 200, 16);
		content3.add(lblCodigo);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(165, 140, 130, 26);
		content3.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
	}//FIN DEL METOOD PANEL 3 CODIGO
	
	//METODO QUE INICIALIZA LOS COMPONENTES DEL PANEL 4 PERFIL
	private void PanelFinal() {
		JLabel lblPerfiles = new JLabel("Seleccione su perfil:");
		lblPerfiles.setBounds(165, 100, 200, 16);
		content4.add(lblPerfiles);
	}//FIN DEL METODO PANEL 4 PERFIL
	
	//METODO QUE LIMPIA LAS CASILLAS
	public void limpia() {
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldEdad.setText("");
		textFieldTelefono.setText("");
		textFieldCorreo.setText("");
		textFieldContrasenia.setText("");
		textFieldConfiCorreo.setText("");
		textFieldConfiContrasenia.setText("");
		textFieldCodigo.setText("");
	}//FIN DEL METODO QUE LIMPIA LAS CASILLAS
	
	public void muestra(ControlAgregarUsuario control, List <Grupo> grupos) {
		
		this.control = control;
		
		textFieldNombre.setText("");

		textFieldApellido.setText("");
		
		textFieldEdad.setText("");
		
		textFieldTelefono.setText("");
		
		textFieldCorreo.setText("");

		DefaultComboBoxModel <String> comboBoxModel = new DefaultComboBoxModel <>();
		
		
		for(Grupo grupo:grupos) {
			comboBoxModel.addElement(grupo.getNombre());
		}
		
		comboBoxGrupo.setModel(comboBoxModel);
		
		setVisible(true);

	}
	
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
}
