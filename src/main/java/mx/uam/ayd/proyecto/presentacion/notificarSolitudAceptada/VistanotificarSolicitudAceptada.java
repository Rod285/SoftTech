package mx.uam.ayd.proyecto.presentacion.notificarSolitudAceptada;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.presentacion.generarContrapropuesta.VistaGenerarContrapropuesta;
import mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador.ControlVistaAdministrador;
import mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador.VistaAdministrador;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;

/*
 * @author Omar Aldaco Montalvo
 */

@SuppressWarnings("serial")
@Component
public class VistanotificarSolicitudAceptada extends JFrame implements ActionListener {

	@Autowired
	private ControlnotificarSolicitudAceptada controlSolicitudAceptada;
		
	private JPanel contentPane;
	
	//icon
	private ImageIcon icon1;
	private Image imagen;
	private ImageIcon imagen1;
	
	//label
	private JLabel lblLogo;
	private JLabel lblNombre;
	private JLabel lblNombre2;
	private JLabel lblNoPedido;
	private JLabel lblCliente;
	
	public JLabel lblContrapropuesta;
	
	public JLabel lblAuto1;
	public JLabel lblAuto2;
	public JLabel lblAuto3;

	public JLabel lblAuto1Desc;
	public JLabel lblAuto2Desc;
	public JLabel lblAuto3Desc;
	
	public JLabel lblNoDisponible1;
	public JLabel lblNoDisponible2;
	public JLabel lblNoDisponible3;
	
	//button
	public JButton btnEditarPedido;
	public JButton btnConfirmar;
	
	//comboBox
	public JComboBox cbOpcines1;
	public JComboBox cbOpcines2;
	public JComboBox cbOpcines3;
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VistanotificarSolicitudAceptada();
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
	public VistanotificarSolicitudAceptada() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 611, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		icon1 = new ImageIcon(getClass().getResource("logo.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(70,70,100)); //Tamaño de imagen ancho, alto
      
		lblLogo = new JLabel();
		lblLogo.setBounds(11, 11, 76, 62);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(imagen1);
		
		lblNombre = new JLabel("MVC");
		lblNombre.setBounds(93, 39, 76, 27);
		lblNombre.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNombre2 = new JLabel("Montalvo Picture Cars");
		lblNombre2.setBounds(17, 87, 137, 16);
		
		lblNoPedido = new JLabel("Pedido No. ");
		lblNoPedido.setBounds(175, 11, 208, 36);
		lblNoPedido.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNoPedido.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblCliente = new JLabel("Cliente: ");
		lblCliente.setBounds(175, 65, 208, 16);
		
		btnEditarPedido = new JButton("Editar pedido");
		btnEditarPedido.setBounds(89, 451, 127, 29);
		btnEditarPedido.setEnabled(false);
		btnEditarPedido.addActionListener(this);
		
		btnConfirmar = new JButton("Confirmar y enviar a operaciones");
		btnConfirmar.setBounds(222, 451, 251, 29);
		btnConfirmar.addActionListener(this);
		
		
		//Icono contrapropuesta
		icon1 = new ImageIcon(getClass().getResource("adobe.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(35,35,100)); //Tama�o de imagen ancho, alto
		
		lblContrapropuesta = new JLabel();
		lblContrapropuesta.setBounds(485, 445, 35, 35);
		lblContrapropuesta.setIcon(imagen1);
		
		//Icono auto1
		icon1 = new ImageIcon(getClass().getResource("audi.jpeg"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100)); //Tama�o de imagen ancho, alto
		
		lblAuto1 = new JLabel();
		lblAuto1.setBounds(93, 121, 204, 104);
		lblAuto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuto1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		lblAuto1.setIcon(imagen1);

		//Icono auto2
		icon1 = new ImageIcon(getClass().getResource("mustang.jpeg"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100)); //Tama�o de imagen ancho, alto
		
		lblAuto2 = new JLabel();
		lblAuto2.setBounds(93, 231, 204, 104);
		lblAuto2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		lblAuto2.setIcon(imagen1);

		//Icono auto3
		icon1 = new ImageIcon(getClass().getResource("camaro.jpeg"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100)); //Tama�o de imagen ancho, alto
		
		lblAuto3 = new JLabel();
		lblAuto3.setBounds(93, 341, 204, 104);
		lblAuto3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		lblAuto3.setIcon(imagen1);
		
		lblAuto1Desc = new JLabel("Audi A1");
		lblAuto1Desc.setBounds(309, 150, 164, 25);
		lblAuto1Desc.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		lblAuto2Desc = new JLabel("Mustang");
		lblAuto2Desc.setBounds(309, 253, 164, 25);
		lblAuto2Desc.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		lblAuto3Desc = new JLabel("Camaro");
		lblAuto3Desc.setBounds(309, 364, 164, 25);
		lblAuto3Desc.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		//Icono auto3
		icon1 = new ImageIcon(getClass().getResource("X.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(50,50,100)); //Tama�o de imagen ancho, alto
		
		lblNoDisponible1 = new JLabel();
		lblNoDisponible1.setBounds(489, 150, 50, 50);
		lblNoDisponible1.setEnabled(false);
		
		lblNoDisponible2 = new JLabel();
		lblNoDisponible2.setBounds(489, 253, 50, 50);
		lblNoDisponible2.setEnabled(false);
		
		lblNoDisponible3 = new JLabel();
		lblNoDisponible3.setBounds(489, 364, 50, 50);
		lblNoDisponible3.setEnabled(false);
		
		cbOpcines1 = new JComboBox();
		cbOpcines1.setBounds(309, 186, 127, 27);
		cbOpcines1.setEnabled(false);
		cbOpcines1.setVisible(false);
		cbOpcines1.addActionListener(this);

		cbOpcines2 = new JComboBox();
		cbOpcines2.setBounds(309, 290, 127, 27);
		cbOpcines2.setEnabled(false);
		cbOpcines2.setVisible(false);
		cbOpcines2.addActionListener(this);
		
		cbOpcines3 = new JComboBox();
		cbOpcines3.setBounds(309, 399, 127, 27);
		cbOpcines3.setEnabled(false);
		cbOpcines3.setVisible(false);
		cbOpcines3.addActionListener(this);
		contentPane.setLayout(null);
		contentPane.add(lblLogo);
		contentPane.add(lblNombre);
		contentPane.add(lblNoPedido);
		contentPane.add(lblCliente);
		contentPane.add(lblNombre2);
		contentPane.add(lblAuto1);
		contentPane.add(lblAuto1Desc);
		contentPane.add(cbOpcines1);
		contentPane.add(lblNoDisponible1);
		contentPane.add(lblAuto2);
		contentPane.add(lblAuto2Desc);
		contentPane.add(cbOpcines2);
		contentPane.add(lblNoDisponible2);
		contentPane.add(lblAuto3);
		contentPane.add(lblAuto3Desc);
		contentPane.add(cbOpcines3);
		contentPane.add(lblNoDisponible3);
		contentPane.add(btnEditarPedido);
		contentPane.add(btnConfirmar);
		contentPane.add(lblContrapropuesta);
		
	}
	
	/*
	 *Metodo que muestra la ventana
	 *
	 *@param ControlnotificarSolicitudAceptada control
	 */

	
	public void muestra(ControlnotificarSolicitudAceptada control) {
		controlSolicitudAceptada = control;
		setVisible(true);
	}
	
	/*
	 *Metodo que muestra mensaje de aceptacion del pedido
	 *
	 *
	 */
	
	public void muestraMensajeAceptacion(){
		
		JOptionPane.showMessageDialog(null, "El pedido ha sido aceptado\nNotificación enviada al cliente");
		
	}
	
	
	/*
	 *Metodo que llama a los botones
	 *
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnConfirmar) {
			
			Object[] message = {"Se notificará al cliente que su pedido fue aceptado sin cambios \n¿Desea continuar?"};
			Object[] options = {"Sí", "No"};
			
		    int n = JOptionPane.showOptionDialog(new JFrame(),
		            message, "Confirmar",
		            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
		            options, options[0]);
			
		    
		    if(n == JOptionPane.OK_OPTION) {
		    	
				String descripcion = "Pedido aceptado";
		    	String fecha = "" + LocalDate.now();
		    	String nombre= "Aldaco";
		    	String tipo="Cliente";
		    	
		    	controlSolicitudAceptada.enviaNotificacion(descripcion, fecha, nombre, tipo);
		    	
		    	try {
					   
			   		Thread.sleep(1500);
				}
				catch (Exception exc) {
			   		System.out.println(exc);
				}
		    	dispose();
		    }
		}
		
	}
}
