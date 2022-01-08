package mx.uam.ayd.proyecto.presentacion.muestraVistaIrAPedido;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
public class VistaIrAPedido extends JFrame{

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
	
	//button
	private JButton btnEnviarPedido;
	private JButton btnRegresar;
	private JLabel lblAuto1;
	private JLabel lblAuto2;
	private JLabel lblAuto3;
	
	private ControlVistaIrAPedido controlIrAPedido;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public VistaIrAPedido() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		icon1 = new ImageIcon(getClass().getResource("logo.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(70,70,100)); //Tama�o de imagen ancho, alto
		      
		lblLogo = new JLabel();
		lblLogo.setBounds(15, 11, 76, 62);
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(imagen1);
				
		lblNombre = new JLabel("MVC");
		lblNombre.setBounds(89, 11, 116, 55);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			
		lblNombre2 = new JLabel("Montalvo Picture Cars");
		lblNombre2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNombre2.setBounds(15, 77, 192, 27);
				
		//Aqui se debe instanciar para obtener ID y Nombre
			
		lblNoPedido = new JLabel("Pedido No. " );//+ getId
		lblNoPedido.setBounds(222, 15, 428, 58);
		lblNoPedido.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblNoPedido.setHorizontalAlignment(SwingConstants.LEFT);
				
		lblCliente = new JLabel("Cliente: ");//+ .getCliente
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblCliente.setBounds(281, 73, 319, 39);
				
		btnEnviarPedido = new JButton("Enviar Pedido");
		btnEnviarPedido.setBounds(213, 603, 164, 39);
		btnEnviarPedido.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		btnEnviarPedido.addActionListener(this);
				
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(627, 611, 91, 27);
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 15));
//		btnRegresar.addActionListener(this);
				
				
		//Icono contrapropuesta
		icon1 = new ImageIcon(getClass().getResource("adobe.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
	    imagen1 = new ImageIcon (imagen.getScaledInstance(35,35,100));
				
		//Icono auto1
		icon1 = new ImageIcon(getClass().getResource("audi.jpeg"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
	    imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100)); //Tama�o de imagen ancho, alto
				
		lblAuto1 = new JLabel();
		lblAuto1.setBounds(183, 143, 204, 104);
		lblAuto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAuto1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		lblAuto1.setIcon(imagen1);

		//Icono auto2
		icon1 = new ImageIcon(getClass().getResource("mustang.jpeg"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100)); //Tama�o de imagen ancho, alto
				
		lblAuto2 = new JLabel();
		lblAuto2.setBounds(187, 294, 204, 104);
		lblAuto2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		lblAuto2.setIcon(imagen1);

		//Icono auto3
		icon1 = new ImageIcon(getClass().getResource("camaro.jpeg"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(200,100,100)); //Tama�o de imagen ancho, alto
				
		lblAuto3 = new JLabel();
		lblAuto3.setBounds(187, 457, 204, 104);
		lblAuto3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		lblAuto3.setIcon(imagen1);
				
		JLabel lblAuto1Desc = new JLabel("Audi A1");
		lblAuto1Desc.setBounds(419, 178, 69, 26);
		lblAuto1Desc.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
				
		JLabel lblMustang = new JLabel("Mustang");
		lblMustang.setBounds(414, 331, 103, 25);
		lblMustang.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
				
		JLabel lblCamaro = new JLabel("Camaro");
		lblCamaro.setBounds(421, 485, 78, 25);
		lblCamaro.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.setLayout(null);
		contentPane.add(btnEnviarPedido);
		contentPane.add(btnRegresar);
		contentPane.add(lblNombre2);
		contentPane.add(lblLogo);
		contentPane.add(lblNombre);
		contentPane.add(lblCliente);
		contentPane.add(lblNoPedido);
		contentPane.add(lblAuto1);
		contentPane.add(lblAuto2);
		contentPane.add(lblAuto3);
		contentPane.add(lblAuto1Desc);
		contentPane.add(lblCamaro);
		contentPane.add(lblMustang);
	
		textField = new JTextField();
		textField.setBounds(546, 185, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(546, 337, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
			
		textField_2 = new JTextField();
		textField_2.setBounds(546, 491, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
				
		JLabel lblNewLabel = new JLabel("No. de elementos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(529, 123, 121, 14);
		contentPane.add(lblNewLabel);
	}
	
	public void muestra(ControlVistaIrAPedido controlVistaIrAPedido) {
		setVisible(true);
	}

}
