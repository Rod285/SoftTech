package mx.uam.ayd.proyecto.presentacion.seleccionDeArticulos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class VistaCatalogo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnIrAPedido;
	//PARA AGREGAR IMAGENES
	private ImageIcon icon1;
	private Image imagen;
	private ImageIcon imagen1;
	
	private JTextField textFieldSearch;
	
	//ETIQUETAS EN DONDE SE ASIGNA UNA IMAGEN
	private JLabel LabelMVC;
	private JLabel LabelMarca;
	private JLabel LabelClasicos;
	private JLabel LabelLuxury;
	private JLabel LabelCarga;
	private JLabel LabelDeportivos;
	private JLabel LabelImagenClasico;
	private JLabel LabelImagenLuxury;
	private JLabel LabelImagenCarga;
	private JLabel LabelImagenDeportivo;
	
	private JButton btnAgregarAPedidoClasicos;
	private JButton btnEspecificacionesClasicos;
	private JButton btnAgregarAPedidoCarga;
	private JButton btnEspecificacionesCarga;
	private JButton btnAgregarAPedidoLuxury;
	private JButton btnEspecificacionesLuxury;
	private JButton btnAgregarAPedidoDeportivos;
	private JButton btnEspecificacionesDeportivos;
	
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCatalogo frame = new VistaCatalogo();
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
	public VistaCatalogo() {
		
		//COLOR DE LA VENTANA
		setBackground(new Color(255, 255, 255));
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 852);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel Label = new JLabel("Catálogo");
		Label.setFont(new Font("Tahoma", Font.BOLD, 70));
		
		textFieldSearch = new JTextField();
		textFieldSearch.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Search :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		btnIrAPedido = new JButton("Ir a pedido");
		btnIrAPedido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIrAPedido.addActionListener(this);
		
		//PARA IMAGEN LOGO
		icon1 = new ImageIcon(getClass().getResource("logo.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(70,70,10)); //Tama o de imagen ancho, alto
		JLabel LabelLogo = new JLabel();
		LabelLogo.setIcon(imagen1);
		
		LabelMVC = new JLabel("MVC");
		LabelMVC.setFont(new Font("Tahoma", Font.BOLD, 50));
		
		LabelMarca = new JLabel("Montalvo Picture Cars");
		LabelMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		LabelClasicos = new JLabel("Clásicos");
		LabelClasicos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		LabelLuxury = new JLabel("Luxury");
		LabelLuxury.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		LabelCarga = new JLabel("Carga");
		LabelCarga.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		LabelDeportivos = new JLabel("Deportivos");
		LabelDeportivos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		//PARA IMAGEN CATALOGO CLASICOS
		icon1 = new ImageIcon(getClass().getResource("catalogoClasicos.png"));//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(333,167,10)); //Tamanio de imagen ancho, alto
        
        LabelImagenClasico = new JLabel();
        LabelImagenClasico.setIcon(imagen1);
		
		//PARA IMAGEN CATALOGO LUXURY
        icon1 = new ImageIcon(getClass().getResource("catalogoLuxury.png"));//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(333,167,10)); //Tamanio de imagen ancho, alto
        
		LabelImagenLuxury = new JLabel();
		LabelImagenLuxury.setIcon(imagen1);
		
		//PARA IMAGEN CATALOGO CARGA
		icon1 = new ImageIcon(getClass().getResource("catalogoCarga.png"));//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(333,167,10)); //Tamanio de imagen ancho, alto
        
		LabelImagenCarga = new JLabel();
		LabelImagenCarga.setIcon(imagen1);
		
		//PARA IMAGEN CATALOGO DEPORTIVOS
		icon1 = new ImageIcon(getClass().getResource("catalogoDeportivospng.png"));//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(333,167,10)); //Tamanio de imagen ancho, alto
        
		LabelImagenDeportivo = new JLabel();
		LabelImagenDeportivo.setIcon(imagen1);
		
		btnAgregarAPedidoClasicos = new JButton("Agregar a Pedido");
		btnAgregarAPedidoClasicos.addActionListener(this);
		
		btnEspecificacionesClasicos = new JButton("Especificaciones");
		btnEspecificacionesClasicos.addActionListener(this);
		
		btnAgregarAPedidoCarga = new JButton("Agregar a Pedido");
		btnAgregarAPedidoCarga.addActionListener(this);
		
		btnEspecificacionesCarga = new JButton("Especificaciones");
		btnEspecificacionesCarga.addActionListener(this);
		
		btnAgregarAPedidoLuxury = new JButton("Agregar a Pedido");
		btnAgregarAPedidoLuxury.addActionListener(this);
		
		btnEspecificacionesLuxury = new JButton("Especificaciones");
		btnEspecificacionesLuxury.addActionListener(this);
		
		btnAgregarAPedidoDeportivos = new JButton("Agregar a Pedido");
		btnAgregarAPedidoDeportivos.addActionListener(this);
		
		btnEspecificacionesDeportivos = new JButton("Especificaciones");
		btnEspecificacionesDeportivos.addActionListener(this);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(LabelLogo, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(LabelMVC, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addComponent(LabelMarca, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(Label, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE)
					.addGap(84)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(103)
							.addComponent(lblNewLabel_1))
						.addComponent(textFieldSearch, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(35)
							.addComponent(btnIrAPedido))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(191)
					.addComponent(LabelClasicos, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
					.addGap(317)
					.addComponent(LabelLuxury, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(115)
					.addComponent(btnAgregarAPedidoClasicos)
					.addGap(16)
					.addComponent(btnEspecificacionesClasicos, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(149)
					.addComponent(btnAgregarAPedidoLuxury, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(btnEspecificacionesLuxury))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(199)
					.addComponent(LabelCarga, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addGap(318)
					.addComponent(LabelDeportivos, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(113)
					.addComponent(btnAgregarAPedidoCarga)
					.addGap(18)
					.addComponent(btnEspecificacionesCarga, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addGap(149)
					.addComponent(btnAgregarAPedidoDeportivos, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(btnEspecificacionesDeportivos))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(LabelImagenClasico, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(LabelImagenCarga, GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addComponent(LabelImagenDeportivo, GroupLayout.PREFERRED_SIZE, 355, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGap(75)
							.addComponent(LabelImagenLuxury, GroupLayout.PREFERRED_SIZE, 342, GroupLayout.PREFERRED_SIZE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(LabelLogo, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addComponent(LabelMVC))
							.addGap(11)
							.addComponent(LabelMarca))
						.addComponent(Label)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(34)
							.addComponent(lblNewLabel_1)
							.addGap(9)
							.addComponent(textFieldSearch, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(btnIrAPedido)))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(LabelClasicos, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelLuxury, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addComponent(LabelImagenLuxury, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addComponent(LabelImagenClasico, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAgregarAPedidoClasicos)
						.addComponent(btnEspecificacionesClasicos)
						.addComponent(btnAgregarAPedidoLuxury)
						.addComponent(btnEspecificacionesLuxury))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(LabelCarga, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelDeportivos, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(LabelImagenCarga, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addComponent(LabelImagenDeportivo, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAgregarAPedidoCarga)
						.addComponent(btnEspecificacionesCarga)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(btnAgregarAPedidoDeportivos, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnEspecificacionesDeportivos)))
		);
		contentPane.setLayout(gl_contentPane);
		
		
		//Muestra ID Usuario
		System.out.println("id de cliente conectado: " + VistaSeleccionDeArticulos.idUsuario);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnIrAPedido) {
			
			VistaIrAPedido vistaIrPedido = new VistaIrAPedido();
			/*Object[] message = {"Se notificará al cliente que su pedido fue aceptado sin cambios \n¿Desea continuar?"};
			Object[] options = {"Sí", "No"};
			
		    int n = JOptionPane.showOptionDialog(new JFrame(),
		            message, "Confirmar",
		            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
		            options, options[0]);*/ //CODIGO NECESARIO PERO SOLO A LA HORA DE PICAR BOTON "ENVIAR PEDIDO"

		}
	}
}
