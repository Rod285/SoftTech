package mx.uam.ayd.proyecto.presentacion.seleccionDeArticulos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador.ControlVistaAdministrador;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Image;


import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JTextArea;

/*
 * @author Fernanda Marcelin Leyva
 */

@SuppressWarnings("serial")
@Component
public class VistaSeleccionDeArticulos extends JFrame implements ActionListener {
	public static long idUsuario;
	
	private ControlSeleccionDeArticulos controlSeleccionDeArticulos;
	
	private JPanel contentPane;
	private JButton btnTuPerfil;
	private JButton btnNotificaciones;
	private JButton btnEspecificacionesMustang;
	private JLabel LabelTopOpciones; 
	private JButton btnAgregarAPedido;
	private JButton btnRealizarPedido;
	//PARA AGREGAR IMAGENES
	private ImageIcon icon1;
	private Image imagen;
	private ImageIcon imagen1;
	
	private JTextField textField;
	private JComboBox comboBox;
	
	String[] opciones = {"Opciones", "Catalogo", "Clasicos", "Deportivos", "Luxury", "Carga"};


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSeleccionDeArticulos frame = new VistaSeleccionDeArticulos();
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
	public VistaSeleccionDeArticulos() {
		setBackground(new Color(255, 255, 255));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1004, 597);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		String [] categorias = {"Clasicos","Deportivos","Luxury","Carga"};
		
		
		JLabel lblNewJgoodiesTitle = new JLabel("MVC");
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD, 50));
		
		JLabel lblNewJgoodiesLabel = new JLabel("Montalvo Picture Cars");
		lblNewJgoodiesLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		
		//PARA IMAGEN LOGO
		icon1 = new ImageIcon(getClass().getResource("logo.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(70,70,10)); //Tama o de imagen ancho, alto
        
		JLabel imagenLogo = new JLabel();
		imagenLogo.setIcon(imagen1);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel LabelSearch = new JLabel("Search:");
		LabelSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		btnRealizarPedido = new JButton("Realizar Pedido");
		btnRealizarPedido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnRealizarPedido.addActionListener(this);
		
		//PARA IMAGEN CALENDARIO
		icon1 = new ImageIcon(getClass().getResource("calendario.jpg"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(230,230,10)); //Tama o de imagen ancho, alto
        
		JLabel LabelCalendario = new JLabel();
		LabelCalendario.setIcon(imagen1);
		
		//PARA IMAGEN TOP 10
		icon1 = new ImageIcon(getClass().getResource("catalogoTop.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(560,230,10)); //Tama o de imagen ancho, alto
        
		LabelTopOpciones = new JLabel();
		LabelTopOpciones.setIcon(imagen1);
		
		btnAgregarAPedido = new JButton("Agregar a Pedido");
		btnAgregarAPedido.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAgregarAPedido.addActionListener(this);
		
		btnEspecificacionesMustang = new JButton("Especificaciones");
		btnEspecificacionesMustang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEspecificacionesMustang.addActionListener(this);
		
		JLabel lblNewLabel = new JLabel("");
		
		String frase = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. \n"
				+ "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, \n"
				+ "when an unknown printer took a galley of type and scrambled it to make a type specimen book. \n"
				+ "It has survived not only five centuries, but also the leap into electronic typesetting, \n"
				+ "remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
		
		JTextArea txtrloremIpsumIs = new JTextArea();
		txtrloremIpsumIs.setFont(new Font("Tahoma", Font.ITALIC, 16));
		txtrloremIpsumIs.setWrapStyleWord(true);
		txtrloremIpsumIs.setToolTipText("");
		txtrloremIpsumIs.setText("\"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard\r\ndummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a typespecimen\r\nbook. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.\"");
		

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(42)
									.addComponent(lblNewJgoodiesLabel, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(20)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(LabelCalendario, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(imagenLogo, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNewJgoodiesTitle, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)))))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(panel, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
										.addComponent(LabelSearch, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnRealizarPedido, Alignment.LEADING)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(73)
									.addComponent(LabelTopOpciones, GroupLayout.PREFERRED_SIZE, 567, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(438)
							.addComponent(btnAgregarAPedido)
							.addGap(18)
							.addComponent(btnEspecificacionesMustang))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtrloremIpsumIs, GroupLayout.PREFERRED_SIZE, 868, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(imagenLogo, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(10))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewJgoodiesTitle))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addComponent(lblNewJgoodiesLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(LabelSearch)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnRealizarPedido)))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(LabelTopOpciones, GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
						.addComponent(LabelCalendario, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnAgregarAPedido)
						.addComponent(btnEspecificacionesMustang))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(txtrloremIpsumIs, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
					.addGap(85))
		);
		
		btnTuPerfil = new JButton("Tu Perfil");
		btnTuPerfil.setBackground(new Color(176, 224, 230));
		btnTuPerfil.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTuPerfil.addActionListener(this);
		
		btnNotificaciones = new JButton("Notificaciones");
		btnNotificaciones.setBackground(new Color(176, 224, 230));
		btnNotificaciones.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNotificaciones.addActionListener(this);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 25));
		comboBox.setBackground(new Color(240, 248, 255));
		comboBox.setModel(new DefaultComboBoxModel(opciones));
		comboBox.addActionListener(this);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnTuPerfil, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(btnNotificaciones)
					.addGap(2)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(90))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(21, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTuPerfil)
						.addComponent(btnNotificaciones)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
					.addGap(19))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	/*private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}*/
	
	public void muestra(ControlSeleccionDeArticulos control) {
		this.controlSeleccionDeArticulos = control;
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnTuPerfil) {
			System.out.println("Botonactivo");
		}
		if((String)this.comboBox.getSelectedItem() == opciones[1]) {
			VistaCatalogo vistaCat = new VistaCatalogo();
		}
		if (e.getSource() == btnEspecificacionesMustang) {
			VistaEspecificaciones vistaEsp = new VistaEspecificaciones();
		}
		if(e.getSource() == btnRealizarPedido) {
			VistaCatalogo vistaCat = new VistaCatalogo();
		}
	
	}
}
