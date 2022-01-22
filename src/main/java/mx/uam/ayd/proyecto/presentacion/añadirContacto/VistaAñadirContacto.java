package mx.uam.ayd.proyecto.presentacion.añadirContacto;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.MiembroOperaciones;

import javax.swing.JTextField;
import javax.swing.JButton;

@SuppressWarnings("serial")
@Component
public class VistaAñadirContacto extends JFrame {

	private ControlAñadirContacto controlAñadirContacto;
	
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	private JButton btnGuardarContacto;
	private JButton btnCancelar;
	private JLabel lblAnadirContacto;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblTelefono;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAñadirContacto frame = new VistaAñadirContacto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public VistaAñadirContacto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblAnadirContacto = new JLabel("Añadir Contacto");
		lblAnadirContacto.setBounds(68, 5, 271, 36);
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(17, 61, 55, 15);
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(17, 107, 57, 15);
		lblTelefono = new JLabel("Teléfono");
		lblTelefono.setBounds(17, 152, 62, 15);
		
		lblAnadirContacto.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(84, 59, 285, 19);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(86, 105, 283, 19);
		txtApellido.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(86, 150, 283, 19);
		txtTelefono.setColumns(10);
		
		btnGuardarContacto = new JButton("Guardar contacto");
		btnGuardarContacto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtTelefono.getText().equals("")) {
					muestraDialogoConMensaje("Los campos no deben estar vacios");
				} else {
					controlAñadirContacto.agregaContacto(txtNombre.getText(), txtApellido.getText(), txtTelefono.getText());
				}
			}
		});
		btnGuardarContacto.setBounds(123, 186, 145, 25);
		btnGuardarContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlAñadirContacto.termina();
			}
		});
		btnCancelar.setBounds(280, 186, 89, 25);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		contentPane.setLayout(null);
		contentPane.add(lblAnadirContacto);
		contentPane.add(lblTelefono);
		contentPane.add(btnGuardarContacto);
		contentPane.add(lblNombre);
		contentPane.add(txtNombre);
		contentPane.add(lblApellido);
		contentPane.add(txtTelefono);
		contentPane.add(txtApellido);
		contentPane.add(btnCancelar);
		
		
	}

	/**
     * @author Jonathan Cruz
 	 * Método que muestra la vista añadir contacto
	 * @param operaciones 
 	 * 
 	 * @param ControlAñadirContacto
 	 * @return  
 	 * @fechaImplementación 21 de enero de 2022
 	 */
	public void muestra(ControlAñadirContacto controlAñadirContacto) {
		this.controlAñadirContacto = controlAñadirContacto;
		txtNombre.setText("");
		txtApellido.setText("");
		txtTelefono.setText("");
		setVisible(true);	
	}
	
	/**
     * @author Jonathan Cruz
 	 * Método que muestra una ventana emergente con un mensaje
 	 * 
 	 * @param ControlAñadirContacto
 	 * @return  
 	 * @fechaImplementación 21 de enero de 2022
 	 */
	public void muestraDialogoConMensaje(String mensaje ) {
		JOptionPane.showMessageDialog(this , mensaje);
	}
}
