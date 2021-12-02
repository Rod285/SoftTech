package mx.uam.ayd.proyecto.presentacion.seleccionDeArticulos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextPane;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class VistaEspecificaciones extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnIrPedido1;
	//PARA AGREGAR IMAGENES
	private ImageIcon icon1;
	private Image imagen;
	private ImageIcon imagen1;
	
	private JTextField textFieldSearch;
	private JTextPane txtDescripcion;
	private JButton btnIrPedido;
	
	private JLabel LabelImagenLogo;
	private JLabel LabelFotoTesla1;
	private JLabel LabelFotoTesla2;
	private JLabel LabelFotoTesla3;
	private JLabel LabelFotoTeslaPrincipal;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEspecificaciones frame = new VistaEspecificaciones();
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
	public VistaEspecificaciones() {
		setBackground(Color.WHITE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 983, 760);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		//PARA IMAGEN LOGO
		icon1 = new ImageIcon(getClass().getResource("logo.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(70,70,10)); //Tama o de imagen ancho, alto
		LabelImagenLogo = new JLabel();
		LabelImagenLogo.setIcon(imagen1);
		
		JLabel lblNewLabel = new JLabel("MVC");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		
		JLabel lblNewLabel_1 = new JLabel("Montalvo Picture Cars");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_2 = new JLabel("Tesla S");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 90));
		
		//PARA IMAGEN Tesla 1
		icon1 = new ImageIcon(getClass().getResource("fotoTesla1.png"));//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(91,83,10)); //Tamanio de imagen ancho, alto
		           
		LabelFotoTesla1 = new JLabel();
		LabelFotoTesla1.setIcon(imagen1);
		
		//PARA IMAGEN Tesla 2
		icon1 = new ImageIcon(getClass().getResource("fotoTesla2.png"));//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(91,83,10)); //Tamanio de imagen ancho, alto
		
		LabelFotoTesla2 = new JLabel();
		LabelFotoTesla2.setIcon(imagen1);
		
		//PARA IMAGEN Tesla 3
		icon1 = new ImageIcon(getClass().getResource("fotoTesla3.png"));//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(91,83,10)); //Tamanio de imagen ancho, alto
				
		LabelFotoTesla3 = new JLabel();
		LabelFotoTesla3.setIcon(imagen1);
		
		//PARA IMAGEN Tesla principal
		icon1 = new ImageIcon(getClass().getResource("fotoTeslaPrincipal.png"));//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(360,338,10)); //Tamanio de imagen ancho, alto
		
		LabelFotoTeslaPrincipal = new JLabel();
		LabelFotoTeslaPrincipal.setIcon(imagen1);
		
		btnIrPedido1 = new JButton("Ir a Pedido");
		btnIrPedido1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtDescripcion = new JTextPane();
		txtDescripcion.setFont(new Font("Tahoma", Font.ITALIC, 17));
		txtDescripcion.setText("El Model S es el mejor automóvil para conducir y el mejor automóvil para ser llevado. \r\nMáxima concentración en la conducción: sin palancas, ni cambios. Con una resolución de 2200 x 1300, colores ultra brillantes y reales y una capacidad de respuesta excepcional, la nueva pantalla central es la mejor opción para ver en cualquier lugar.\r\n Acondicionamiento limpio, potente e invisible para cabina. Con controles de temperatura de tres zonas, asientos delanteros ventilados y la filtración HEPA como equipo de serie.\r\nCarga multidispositivo Bluetooth, inalámbrica y con USB-C para cada pasajero, con suficiente potencia para cargar rápidamente tabletas y computadoras portátiles. \r\nHasta 10 teraflops de potencia de procesamiento permiten jugar a bordo del auto a la par de las consolas más nuevas disponibles en la actualidad.\r\nUn sistema de sonido con 22 bocinas y 960 watts con cancelación activa de ruido ofrece la mejor experiencia auditiva en casa o en la carretera.");
		
		JLabel lblNewLabel_7 = new JLabel("637 km");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_8 = new JLabel("2.1 s");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_9 = new JLabel("322 km/h");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_10 = new JLabel("1,020 hp");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		JLabel lblNewLabel_11 = new JLabel("Autonomía     0 a 100 km/h*");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_12 = new JLabel("Velocidad Máxima†     Potencia Máxima");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_13 = new JLabel("Plaid");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.ITALIC, 40));
		
		JButton btnAgregarAPedido = new JButton("Agregar a Pedido");
		btnAgregarAPedido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnRegresar = new JButton("Regresar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(LabelImagenLogo, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(99)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
							.addGap(226)
							.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(LabelFotoTesla1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(LabelFotoTesla2, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addComponent(LabelFotoTesla3, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
							.addGap(31)
							.addComponent(LabelFotoTeslaPrincipal, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(117)
									.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(143)
							.addComponent(btnAgregarAPedido)))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRegresar, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(41)
					.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(786)
					.addComponent(btnIrPedido1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(LabelImagenLogo, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(15)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
							.addGap(7)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(4)
											.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
									.addGap(46)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(17)
											.addComponent(LabelFotoTesla1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
											.addGap(26)
											.addComponent(LabelFotoTesla2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
											.addGap(22)
											.addComponent(LabelFotoTesla3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
										.addComponent(LabelFotoTeslaPrincipal, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE))
									.addGap(14)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(4)
											.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(4)
													.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
											.addGap(7)
											.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
									.addGap(11)
									.addComponent(btnAgregarAPedido, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(40)
									.addComponent(txtDescripcion, GroupLayout.PREFERRED_SIZE, 515, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnRegresar))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(554)
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(86)
							.addComponent(btnIrPedido1, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
					.addGap(18))
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*if (e.getSource() == btnRegresar) {
			
			dispose();
		}*/
	}
	
	
}
