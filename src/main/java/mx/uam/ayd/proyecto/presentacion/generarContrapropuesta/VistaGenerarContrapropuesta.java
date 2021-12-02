package mx.uam.ayd.proyecto.presentacion.generarContrapropuesta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador.VistaAdministrador;
import mx.uam.ayd.proyecto.presentacion.notificarSolitudAceptada.ControlnotificarSolicitudAceptada;
import mx.uam.ayd.proyecto.presentacion.notificarSolitudAceptada.VistanotificarSolicitudAceptada;

@SuppressWarnings("serial")
@Component
public class VistaGenerarContrapropuesta extends JFrame implements ActionListener {
	
	@Autowired
	private ControlGenerarContrapropuesta controlGenerarContrapropuesta;
	
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
	public JButton btnContrapropuesta;
	public JButton btnEnviar;
	
	//comboBox
	public JComboBox cbOpcines1;
	public JComboBox cbOpcines2;
	public JComboBox cbOpcines3;
	
	String[] opVehiculo;
	
	private boolean disp1 = false;
	private boolean disp2 = true;
	private boolean disp3 = false;

	public VistaGenerarContrapropuesta() {
		
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
		
		btnContrapropuesta = new JButton("Generar contrapropuesta");
		btnContrapropuesta.setBounds(89, 466, 208, 29);
		btnContrapropuesta.addActionListener(this);
		
		btnEnviar = new JButton("Enviar contrapropuesta");
		btnEnviar.setEnabled(false);
		btnEnviar.setBounds(309, 466, 208, 29);
		btnEnviar.addActionListener(this);
				
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
		contentPane.add(btnContrapropuesta);
		contentPane.add(btnEnviar);
		
		opVehiculo = new String[4];
		opVehiculo[0] = "Elegir opción";
		opVehiculo[1] = "Mazda 3";
		opVehiculo[2] = "BMW";
		opVehiculo[3] = "Mercedes Benz"; //getNombreAutos();
		
		
		//Icono no disponible
		icon1 = new ImageIcon(getClass().getResource("X.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(50,50,100)); //Tama�o de imagen ancho, alto
		
		if(!disp1) {
			lblNoDisponible1.setIcon(imagen1);
			this.lblNoDisponible1.setEnabled(true);
			this.cbOpcines1.setEnabled(true);
			this.cbOpcines1.setVisible(true);
			this.cbOpcines1.setModel(new DefaultComboBoxModel(opVehiculo));
			//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Catalogo", "Clasicos", "Deportivos", "Luxury", "Carga"}));
		}
		
		if(!disp2) {
			lblNoDisponible2.setIcon(imagen1);
			this.lblNoDisponible2.setEnabled(true);
			this.cbOpcines2.setEnabled(true);
			this.cbOpcines2.setVisible(true);
			this.cbOpcines2.setModel(new DefaultComboBoxModel(opVehiculo));
		}
		
		if(!disp3) {
			lblNoDisponible3.setIcon(imagen1);
			this.lblNoDisponible3.setEnabled(true);
			this.cbOpcines3.setEnabled(true);
			this.cbOpcines3.setVisible(true);
			this.cbOpcines3.setModel(new DefaultComboBoxModel(opVehiculo));
		}
	}
	
	
	/*
	 *Metodo que muestra la ventana
	 *
	 *@param ControlGenerarContrapropuesta control
	 */

	
	public void muestra(ControlGenerarContrapropuesta control) {
		controlGenerarContrapropuesta = control;
		setVisible(true);
	}
	
	/*
	 *Metodo que muestra mensaje de modificacion del pedido
	 *
	 *
	 */
	public void muestraMensajeModificacion(){
		JOptionPane.showMessageDialog(null, "Notificación enviada al cliente");
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnContrapropuesta) {
			
			icon1 = new ImageIcon(getClass().getResource("check.png"));  	//Agrega la imagen existente en la clase
			imagen = icon1.getImage(); 										//
			imagen1 = new ImageIcon (imagen.getScaledInstance(50,50,100));
		
			Object[] message = {"El book será modificado\n¿Desea continuar?"};
			Object[] options = {"Sí", "No"};
		
			int n = JOptionPane.showOptionDialog(new JFrame(),
	            message, "Confirmar",
	            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
	            options, options[0]);
		
	    
			if(n == JOptionPane.OK_OPTION) {
				
				
				if(this.lblNoDisponible1.isEnabled()) {
					
					lblNoDisponible1.setIcon(imagen1);
				}
				
				if(this.lblNoDisponible2.isEnabled()) {
					
					lblNoDisponible2.setIcon(imagen1);
				}
				
				if(this.lblNoDisponible3.isEnabled()) {
					
					lblNoDisponible3.setIcon(imagen1);
				}
				
				btnEnviar.setEnabled(true);
				btnContrapropuesta.setEnabled(false);
			}
		}

		if(e.getSource() == btnEnviar) {
					

			Object[] message = {"El book de contrapropuesta se enviará al cliete\n¿Desea continuar?"};
			Object[] options = {"Sí", "No"};
			int n = JOptionPane.showOptionDialog(new JFrame(),
			    message, "Confirmar",
	            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
	            options, options[0]);
					
				if(n == JOptionPane.OK_OPTION) {
						
					String descripcion = "Necesita modificaciones";
			    	String fecha = "" + LocalDate.now();
			    	String nombre= "Omar";
			    	String tipo="Cliente";
				    	
			    	controlGenerarContrapropuesta.enviaNotificacion(descripcion, fecha, nombre, tipo);
						
					try {
							   
				   		Thread.sleep(1500);
					}
					catch (Exception exc) {
				   		System.out.println(exc);
					}
					dispose();
				}
			}
		
		//ComboBox 1
		if((String)this.cbOpcines1.getSelectedItem() == opVehiculo[1]) {
			
			icon1 = new ImageIcon(getClass().getResource("mazda3.jpeg"));
			imagen = icon1.getImage();
			imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100));
			
			this.lblAuto1.removeAll();
			this.lblAuto1.setIcon(imagen1);
			
			this.lblAuto1Desc.setText((String)this.cbOpcines1.getSelectedItem());
		}else{
		
			if((String)this.cbOpcines1.getSelectedItem() == opVehiculo[2]) {
			
				icon1 = new ImageIcon(getClass().getResource("BMW.jpeg"));
				imagen = icon1.getImage();
				imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100));
			
				this.lblAuto1.removeAll();
				this.lblAuto1.setIcon(imagen1);
			
				this.lblAuto1Desc.setText((String)this.cbOpcines1.getSelectedItem());
			}else {
		
				if((String)this.cbOpcines1.getSelectedItem() == opVehiculo[3]) {
			
					icon1 = new ImageIcon(getClass().getResource("mercedes.jpeg"));
					imagen = icon1.getImage();
					imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100));
			
					this.lblAuto1.removeAll();
					this.lblAuto1.setIcon(imagen1);
			
					this.lblAuto1Desc.setText((String)this.cbOpcines1.getSelectedItem());
				}
			}
		}
		
		
		//ComboBox 2
		if((String)this.cbOpcines2.getSelectedItem() == opVehiculo[1]) {
					
			icon1 = new ImageIcon(getClass().getResource("mazda3.jpeg"));
			imagen = icon1.getImage();
			imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100));
			
			this.lblAuto2.removeAll();
			this.lblAuto2.setIcon(imagen1);
			this.lblAuto2Desc.setText((String)this.cbOpcines2.getSelectedItem());
		}else {
		
			if((String)this.cbOpcines2.getSelectedItem() == opVehiculo[2]) {
			
				icon1 = new ImageIcon(getClass().getResource("BMW.jpeg"));
				imagen = icon1.getImage();
				imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100));
			
				this.lblAuto2.removeAll();
				this.lblAuto2.setIcon(imagen1);
				this.lblAuto2Desc.setText((String)this.cbOpcines2.getSelectedItem());
			}else {
		
				if((String)this.cbOpcines2.getSelectedItem() == opVehiculo[3]) {
			
					icon1 = new ImageIcon(getClass().getResource("mercedes.jpeg"));
					imagen = icon1.getImage();
					imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100));
			
					this.lblAuto2.removeAll();
					this.lblAuto2.setIcon(imagen1);
					this.lblAuto2Desc.setText((String)this.cbOpcines2.getSelectedItem());
				
				}
			}
		}
		
		
		//ComboBox 3
		if((String)this.cbOpcines3.getSelectedItem() == opVehiculo[1]) {
			
			icon1 = new ImageIcon(getClass().getResource("mazda3.jpeg"));
			imagen = icon1.getImage();
			imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100));
			
			this.lblAuto3.removeAll();
			this.lblAuto3.setIcon(imagen1);
			this.lblAuto3Desc.setText((String)this.cbOpcines3.getSelectedItem());
		}else {
		
			if((String)this.cbOpcines3.getSelectedItem() == opVehiculo[2]) {
			
				icon1 = new ImageIcon(getClass().getResource("BMW.jpeg"));
				imagen = icon1.getImage();
				imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100));
			
				this.lblAuto3.removeAll();
				this.lblAuto3.setIcon(imagen1);
				this.lblAuto3Desc.setText((String)this.cbOpcines3.getSelectedItem());
			}else {
		
				if((String)this.cbOpcines3.getSelectedItem() == opVehiculo[3]) {
			
					icon1 = new ImageIcon(getClass().getResource("mercedes.jpeg"));
					imagen = icon1.getImage();
					imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100));
			
					this.lblAuto3.removeAll();
					this.lblAuto3.setIcon(imagen1);
					this.lblAuto3Desc.setText((String)this.cbOpcines3.getSelectedItem());
				}
			}
		}
	}
}
