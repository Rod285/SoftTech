package mx.uam.ayd.proyecto.presentacion.muestraVistaCatalogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;
import mx.uam.ayd.proyecto.presentacion.seleccionDeArticulos.VistaSeleccionDeArticulos;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;

/*
 * @author Fernanda Marcelin Leyva
 * @Updated José Rodrigo Mejía Velázquez 7/12/2021
 */

@SuppressWarnings("serial")
@Component
public class VistaCatalogo extends JFrame {

	private ControlVistaCatalogo control;

	private JPanel contentPane;
	private JButton btnIrAPedido;
	// PARA AGREGAR IMAGENES
	private ImageIcon icon1;
	private Image imagen;
	private ImageIcon imagen1;

	private JTextField textFieldSearch;

	// ETIQUETAS EN DONDE SE ASIGNA UNA IMAGEN
	private JLabel lblMVC, lblMarca;
	private JLabel lblClasicos, lblLuxury, lblCarga, lblDeportivos;
	private JLabel imgClasico, imgLuxury, imgCarga, imgDeportivo;
	
	private JButton agregaClasico, especClasico, previoClasico, siguienteClasico;
	private JButton agregarLuxury, especLuxury, previoLuxury, siguienteLuxury;
	private JButton agregaCarga, especCarga, previoCarga, siguienteCarga;
	private JButton agregaDeportivo, especDeportivo, previoDeportivo, siguienteDeportivo;

	private List<Vehiculo> listaClasicos;
	private List<Vehiculo> listaLuxury;
	private List<Vehiculo> listaCarga;
	private List<Vehiculo> listaDeportivos;

	private int indiceClasico, indiceLuxury, indiceCarga, indiceDeportivo;
	private JTextField textClasico, textLuxury, textCarga, textDeportivo;
	private JPanel panelClasico, panelLuxury, panelCarga, panelDeportivo;
 
	 /*
	  * Create the frame.
	 */
	public VistaCatalogo() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 5, 940, 725);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblCatalogo = new JLabel("Catálogo");
		lblCatalogo.setBounds(282, 15, 355, 85);
		lblCatalogo.setFont(new Font("Tahoma", Font.BOLD, 70));

		textFieldSearch = new JTextField();
		textFieldSearch.setBounds(721, 50, 164, 33);
		textFieldSearch.setColumns(10);

		JLabel lblSearch = new JLabel("Buscar:");
		lblSearch.setBounds(812, 20, 70, 20);
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnIrAPedido = new JButton("Ir a pedido");
		btnIrAPedido.setEnabled(false);
		btnIrAPedido.setBounds(705, 90, 180, 33);
		btnIrAPedido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnIrAPedido.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				control.iniciaIrAPedido();
			}
		});
		btnIrAPedido.setVisible(true);

		// PARA IMAGEN LOGO
		icon1 = new ImageIcon(getClass().getResource("logo.png")); // Agrega la imagen existente en la clase
		imagen = icon1.getImage(); //
		imagen1 = new ImageIcon(imagen.getScaledInstance(70, 70, 10)); // Tama o de imagen ancho, alto
		JLabel lblLogo = new JLabel();
		lblLogo.setBounds(35, 15, 75, 75);
		lblLogo.setIcon(imagen1);

		lblMVC = new JLabel("MVC");
		lblMVC.setBounds(120, 20, 115, 61);
		lblMVC.setFont(new Font("Tahoma", Font.BOLD, 50));

		lblMarca = new JLabel("Montalvo Picture Cars");
		lblMarca.setBounds(35, 90, 213, 25);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblClasicos = new JLabel("Clásicos");
		lblClasicos.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasicos.setBounds(170, 140, 120, 25);
		lblClasicos.setFont(new Font("Tahoma", Font.PLAIN, 25));

		lblLuxury = new JLabel("Luxury");
		lblLuxury.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuxury.setBounds(630, 140, 120, 25);
		lblLuxury.setFont(new Font("Tahoma", Font.PLAIN, 25));

		lblCarga = new JLabel("Carga");
		lblCarga.setHorizontalAlignment(SwingConstants.CENTER);
		lblCarga.setBounds(170, 420, 120, 25);
		lblCarga.setFont(new Font("Tahoma", Font.PLAIN, 25));

		lblDeportivos = new JLabel("Deportivos");
		lblDeportivos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeportivos.setBounds(620, 420, 140, 25);
		lblDeportivos.setFont(new Font("Tahoma", Font.PLAIN, 25));

		// PARA IMAGEN CATALOGO CLASICOS
		imgClasico = new JLabel("", JLabel.CENTER);
		imgClasico.setBounds(70, 190, 320, 180);

		// PARA IMAGEN CATALOGO LUXURY
		imgLuxury = new JLabel("", JLabel.CENTER);
		imgLuxury.setBounds(530, 190, 320, 180);

		// PARA IMAGEN CATALOGO CARGA
		imgCarga = new JLabel("", JLabel.CENTER);
		imgCarga.setBounds(70, 470, 320, 180);

		// PARA IMAGEN CATALOGO DEPORTIVOS
		imgDeportivo = new JLabel("", JLabel.CENTER);
		imgDeportivo.setBounds(530, 470, 320, 180);
		
		contentPane.setLayout(null);
		contentPane.add(lblLogo);
		contentPane.add(lblMVC);
		contentPane.add(lblMarca);
		contentPane.add(lblCatalogo);
		contentPane.add(lblSearch);
		contentPane.add(textFieldSearch);
		contentPane.add(btnIrAPedido);
		contentPane.add(lblClasicos);
		contentPane.add(lblLuxury);
		contentPane.add(lblCarga);
		contentPane.add(lblDeportivos);

		panelClasico = new JPanel();
		panelClasico.setBounds(0, 370, 460, 35);

		panelLuxury = new JPanel();
		panelLuxury.setBounds(461, 370, 460, 35);

		panelCarga = new JPanel();
		panelCarga.setBounds(0, 650, 460, 35);
		
		panelDeportivo = new JPanel();
		panelDeportivo.setBounds(461, 650, 460, 35);

		getContentPane().add(panelClasico);
		getContentPane().add(imgClasico);
		panelClasico.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		getContentPane().add(panelLuxury);
		getContentPane().add(imgLuxury);
		panelLuxury.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		getContentPane().add(panelCarga);
		getContentPane().add(imgCarga);
		panelCarga.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		getContentPane().add(panelDeportivo);
		getContentPane().add(imgDeportivo);
		panelDeportivo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		textClasico = new JTextField();
		textClasico.setHorizontalAlignment(SwingConstants.CENTER);
		textClasico.setFont(new Font("Verdana", Font.BOLD, 12));
		textClasico.setEditable(false);
		textClasico.setBounds(70, 170, 320, 20);
		getContentPane().add(textClasico);
		textClasico.setColumns(10);

		textLuxury = new JTextField();
		textLuxury.setEditable(false);
		textLuxury.setHorizontalAlignment(SwingConstants.CENTER);
		textLuxury.setFont(new Font("Verdana", Font.BOLD, 12));
		textLuxury.setBounds(530, 170, 320, 20);
		getContentPane().add(textLuxury);
		textLuxury.setColumns(10);

		textDeportivo = new JTextField();
		textDeportivo.setHorizontalAlignment(SwingConstants.CENTER);
		textDeportivo.setEditable(false);
		textDeportivo.setFont(new Font("Verdana", Font.BOLD, 12));
		textDeportivo.setBounds(530, 450, 320, 20);
		getContentPane().add(textDeportivo);
		textDeportivo.setColumns(10);

		textCarga = new JTextField();
		textCarga.setFont(new Font("Verdana", Font.BOLD, 12));
		textCarga.setHorizontalAlignment(SwingConstants.CENTER);
		textCarga.setEditable(false);
		textCarga.setBounds(70, 450, 320, 20);
		getContentPane().add(textCarga);
		textCarga.setColumns(10);
		
		previoCarga = new JButton("<<");
		previoCarga.setBounds(19, 470, 50, 180);
		contentPane.add(previoCarga);
		
		siguienteCarga = new JButton(">>");
		siguienteCarga.setBounds(391, 470, 50, 180);
		contentPane.add(siguienteCarga);
		
		previoDeportivo = new JButton("<<");
		previoDeportivo.setBounds(479, 470, 50, 180);
		contentPane.add(previoDeportivo);
		
		siguienteDeportivo = new JButton(">>");
		siguienteDeportivo.setBounds(851, 470, 50, 180);
		contentPane.add(siguienteDeportivo);
		
		siguienteLuxury = new JButton(">>");
		siguienteLuxury.setBounds(851, 189, 50, 180);
		contentPane.add(siguienteLuxury);
		
		previoLuxury = new JButton("<<");
		previoLuxury.setBounds(479, 190, 50, 180);
		contentPane.add(previoLuxury);
		
		siguienteClasico = new JButton(">>");
		siguienteClasico.setBounds(391, 190, 50, 180);
		contentPane.add(siguienteClasico);
		
		previoClasico = new JButton("<<");
		previoClasico.setBounds(19, 190, 50, 180);
		contentPane.add(previoClasico);
		
		/*
		 * Botón para desplazar hacia el vehiculo anterior dentro de la categoría Clásicos
		 */
		previoClasico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				indiceClasico = vehiculoAnterior(listaClasicos, indiceClasico, imgClasico, textClasico);
			}
		});
		
		/*
		 * Botón para desplazar hacia el vehiculo siguiente dentro de la categoría Clásicos
		 */
		siguienteClasico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				indiceClasico = vehiculoSiguiente(listaClasicos, indiceClasico, imgClasico, textClasico);
			}
		});
		
		/*
		 * Botón para agregar el vehículo mostrado actualmente de la categoría Clásicos a la lista de Pedidos
		 */
		agregaClasico = new JButton("Agregar a Pedido");
		agregaClasico.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				control.agregarAPedido(listaClasicos, indiceClasico);
			}
		});

		especClasico = new JButton("Especificaciones");
		
		/*
		 * Botón para desplazar hacia el vehiculo anterior dentro de la categoría Luxury
		 */
		previoLuxury.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				indiceLuxury = vehiculoAnterior(listaLuxury, indiceLuxury, imgLuxury, textLuxury);
			}
		});
		
		/*
		 * Botón para desplazar hacia el vehiculo siguiente dentro de la categoría Luxury
		 */
		siguienteLuxury.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				indiceLuxury = vehiculoSiguiente(listaLuxury, indiceLuxury, imgLuxury, textLuxury);
			}
		});
		
		/*
		 * Botón para agregar el vehículo mostrado actualmente de la categoría Luxury a la lista de Pedidos
		 */
		agregarLuxury = new JButton("Agregar a Pedido");
		agregarLuxury.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				control.agregarAPedido(listaLuxury, indiceLuxury);
			}
		});

		especLuxury = new JButton("Especificaciones");
				
		
		
		/*
		 * Botón para desplazar hacia el vehiculo anterior dentro de la categoría Carga
		 */
		previoCarga.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				indiceCarga = vehiculoAnterior(listaCarga, indiceCarga, imgCarga, textCarga);
			}
		});
		
		/*
		 * Botón para desplazar hacia el vehiculo siguiente dentro de la categoría Carga
		 */
		siguienteCarga.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				indiceCarga = vehiculoSiguiente(listaCarga, indiceCarga, imgCarga, textCarga);
			}
		});
		
		/*
		 * Botón para agregar el vehículo mostrado actualmente de la categoría Carga a la lista de Pedidos
		 */
		agregaCarga = new JButton("Agregar a Pedido");
		agregaCarga.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				control.agregarAPedido(listaCarga, indiceCarga);
			}
		});

		especCarga = new JButton("Especificaciones");
		
		/*
		 * Botón para desplazar hacia el vehiculo anterior dentro de la categoría Deportivos
		 */
		previoDeportivo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				indiceDeportivo = vehiculoAnterior(listaDeportivos, indiceDeportivo, imgDeportivo, textDeportivo);
			}
		});
		
		/*
		 * Botón para desplazar hacia el vehiculo siguiente dentro de la categoría Deportivos
		 */
		siguienteDeportivo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				indiceDeportivo = vehiculoSiguiente(listaDeportivos, indiceDeportivo, imgDeportivo, textDeportivo);
			}
		});
		
		/*
		 * Botón para agregar el vehículo mostrado actualmente de la categoría Deportivos a la lista de Pedidos
		 */
		agregaDeportivo = new JButton("Agregar a Pedido");
		agregaDeportivo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				control.agregarAPedido(listaDeportivos, indiceDeportivo);
			}
		});

		especDeportivo = new JButton("Especificaciones");
		
		panelClasico.add(agregaClasico);
		panelClasico.add(especClasico);
		panelLuxury.add(agregarLuxury);
		panelLuxury.add(especLuxury);
		panelCarga.add(agregaCarga);
		panelCarga.add(especCarga);
		panelDeportivo.add(agregaDeportivo);
		panelDeportivo.add(especDeportivo);
	}

	public void muestra(ControlVistaCatalogo control, List<Vehiculo> listaClasicos, List<Vehiculo> listaLuxury, List<Vehiculo> listaCarga,
			List<Vehiculo> listaDeportivos) {
		this.control = control;
		this.listaClasicos = listaClasicos;
		this.listaLuxury = listaLuxury;
		this.listaCarga = listaCarga;
		this.listaDeportivos = listaDeportivos;

		imgClasico.setIcon(new ImageIcon(listaClasicos.get(0).getFoto()));
		imgLuxury.setIcon(new ImageIcon(listaLuxury.get(0).getFoto()));
		imgCarga.setIcon(new ImageIcon(listaCarga.get(0).getFoto()));
		imgDeportivo.setIcon(new ImageIcon(listaDeportivos.get(0).getFoto()));

		textClasico.setText(listaClasicos.get(0).getModelo());
		textLuxury.setText(listaLuxury.get(0).getModelo());
		textCarga.setText(listaCarga.get(0).getModelo());
		textDeportivo.setText(listaDeportivos.get(0).getModelo());
		
		//Muestra ID Usuario
		System.out.println("id de cliente conectado: " + VistaSeleccionDeArticulos.idUsuario);

		setVisible(true);
	}
	
	/*
	 * Método que desplaza al vehículo anterior el slide de vehiculos
	 */
	public int vehiculoAnterior(List<Vehiculo> lista, int indice, JLabel imagen, JTextField texto) {
		if (indice == 0) {
			indice = lista.size() - 1;
			imagen.setIcon(new ImageIcon(lista.get(indice).getFoto()));
			texto.setText(lista.get(indice).getModelo());
		} else {
			indice = indice - 1;
			imagen.setIcon(new ImageIcon(lista.get(indice).getFoto()));
			texto.setText(lista.get(indice).getModelo());
		}
		return indice;
	}
	
	/*
	 * Método que desplaza al vehículo siguiente el slide de vehiculos
	 */
	public int vehiculoSiguiente(List<Vehiculo> lista, int indice, JLabel imagen, JTextField texto) {
		if (indice == lista.size() - 1) {
			indice = 0;
			imagen.setIcon(new ImageIcon(lista.get(indice).getFoto()));
			texto.setText(lista.get(indice).getModelo());
		} else {
			indice = indice + 1;
			imagen.setIcon(new ImageIcon(lista.get(indice).getFoto()));
			texto.setText(lista.get(indice).getModelo());
		}
		return indice;
	}
	
	/*
	 * Método que muestra un diálogo de vehículo repetido
	 */
	public void dialogoVehiculoEnListaDePedido() {
		JOptionPane.showMessageDialog(null, "El vehículo se escuentra en su lista de pedidos,"
				+ " presiones el botón \"ir a Pedidos\" para elegir la cantidad deseada");
	}

	public void actualizaBotonIrAPedido(List<Vehiculo> listaPedido) {
		btnIrAPedido.setEnabled(true);
		btnIrAPedido.setText("Ir a Pedido (" + listaPedido.size() + ")");	
	}

}