package mx.uam.ayd.proyecto.presentacion.bandejaNotificaciones;


import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;
import mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador.VistaAdministrador;
import mx.uam.ayd.proyecto.presentacion.principal.VentanaPrincipal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;

import javax.swing.JScrollPane;


@SuppressWarnings("serial")
@Component
public class VistaBandejaNotificaciones extends JFrame implements KeyListener{

	private JPanel contentPane;
	private ControlBandejaNotificaciones controlBandeja;
	List <Notificacion> notificaciones; // = new ArrayList<Notificacion>();
	
	List <String> noti = new ArrayList<String>();
	
	//Icon
	private ImageIcon icon1;
	private Image imagen;
	private ImageIcon imagen1;
	private JTextField textField;
	private JLabel lblBuscar;
	
	private JTable table;
	private JScrollPane scrollPane;
	
	private JButton btnProyect;
	private JButton btnNoti;
	private JButton btnNotiOperaciones;
	private JButton btnNotiCliente;
	private JButton btnTodas;
	private JButton btnElimina;
	private JButton btnRegresar;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaBandejaNotificaciones frame = new VistaBandejaNotificaciones();
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
	public VistaBandejaNotificaciones() { //Inicio del metodo
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//PARA IMAGEN LOGO
		icon1 = new ImageIcon(getClass().getResource("logo.png"));  	//Agrega la imagen existente en la clase
	    imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(45,45,10)); //Tama o de imagen ancho, alto
		
		JLabel imagenLogo = new JLabel();
		imagenLogo.setBounds(7, 11, 46, 49);
		imagenLogo.setIcon(imagen1);
		
		JLabel lblMvc = new JLabel("MVC");
		lblMvc.setBounds(56, 24, 52, 36);
		lblMvc.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Montalvo Picture Cars");
		lblNewLabel.setBounds(7, 66, 101, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		//PARA IMAGEN CALENDARIO
		icon1 = new ImageIcon(getClass().getResource("calendario.jpg"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(150,150,10)); //Tama o de imagen ancho, alto
				
		JLabel lblCalendario = new JLabel();
		lblCalendario.setBounds(7, 98, 150, 168);
		lblCalendario.setIcon(imagen1);
		
		btnProyect = new JButton("Proyectos");
		btnProyect.setBounds(126, 28, 100, 25);
		btnProyect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Se presiono el boton Proyectos");
			}
		});
		btnProyect.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProyect.setEnabled(false);
		
		JButton btnCatalogo = new JButton("Catálogo");
		btnCatalogo.setBounds(228, 28, 100, 25);
		btnCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Se presiono el boton Catalogos");
			}
		});
		btnCatalogo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCatalogo.setEnabled(false);
		
		muestraTodasLasNotificaciones(controlBandeja,notificaciones);	

		Object[] titulos = {"Todas las notificaciones", "☑️"};
        Object[][] datos = new Object[10][2];


		for(int i=0; i<noti.size(); i++) {
			String dato = noti.get(i);
			System.out.println(dato);
			for(int j=0; j<2; j++) { //tenia j<2
				datos[i][j]= dato; //Aqui se almacenan las notificaciones 
			}	
		}		
        		
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);

		
		table = new JTable(modelo){
		
		//private static final long serialVersionUID = 1L;
    	public Class getColumnClass(int column) {
            switch (column) {
                case 0:
                    return String.class;

                default:
                    return Boolean.class;
            }
        }
    };
    
    table.setPreferredScrollableViewportSize(table.getPreferredSize());
    table.getColumnModel().getColumn(0).setPreferredWidth(500);
    table.getColumnModel().getColumn(1).setPreferredWidth(23);
    
	scrollPane = new JScrollPane(table); //SCROLLPANE
	scrollPane.setBounds(167, 83, 428, 182);
	for(int j=0;j<10;j++) {
		table.setValueAt(false, j, 1);
	}
	
	icon1 = new ImageIcon(getClass().getResource("basura.png"));  	//Agrega la imagen existente en la clase
	imagen = icon1.getImage(); 										//
	imagen1 = new ImageIcon (imagen.getScaledInstance(25,20,10)); //Tama o de imagen ancho, alto
	
	btnElimina = new JButton();
	btnElimina.setBounds(537, 267, 25, 20);
	btnElimina.setIcon(imagen1);
	btnElimina.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int aux = 0;
			for(int i=0; i<10; i++) {
				

				boolean estado = (boolean) table.getValueAt(i, 1);
				
				//System.out.println(estado);
				
                
                	if(estado == true) {
                		aux=1;
    					//System.out.println(i+" Eliminado");
    				}
			}//Fin del for
           ArrayList <Integer> x = new ArrayList<Integer>();   
			
           if(aux==1) {
                for(int i =0;i<10;i++) {
                	if((boolean) table.getValueAt(i, 1)) {
                		x.add(i);
                	}
                }
                Object[] message = {"Se eliminaran las notificaciones seleccionadas \n¿Desea continuar?"};
    			Object[] options = {"Sí", "No"};
    			
    		    int n = JOptionPane.showOptionDialog(new JFrame(),
    		            message, "Confirmar",
    		            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
    		            options, options[0]);
    		    
    		    if(n == JOptionPane.OK_OPTION) {
    		    	
    		    	for(int k=0; k<x.size(); k++) {
    		    		table.setValueAt("", x.get(k), 0);  
    		    	}
    		    	
    		    			
    		    	JOptionPane.showMessageDialog(null, "Eliminadas");    	
    		    }
			}
                	//System.out.println(x);

			for(int k=0; k<10; k++) {
                	if(k == 9 && aux==0) {
                		JOptionPane.showMessageDialog(null, "No hay notificaciones seleccionadas");
			        }
			}  
			
			for(int j=0; j<10; j++) {
				table.setValueAt(false, j, 1);
			}

		}
	});
	
		
		btnNotiOperaciones = new JButton("Operaciones");
		btnNotiOperaciones.setEnabled(false);
		btnNotiOperaciones.setBounds(470, 60, 120, 23);
		btnNotiOperaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Se presiono el boton de las notificaciones generadas por el miembro de operaciones");
			}
		});
		btnNotiOperaciones.setEnabled(true);

		btnNotiCliente = new JButton("Cliente");
		btnNotiCliente.setEnabled(false);
		btnNotiCliente.setBounds(349, 60, 120, 23);
		btnNotiCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Se presiono el boton de las notificaciones generadas por el cliente");
			}
		});
		btnNotiCliente.setEnabled(true);
		
		
//		btnTodas = new JButton("Todas");
//		btnTodas.setEnabled(false);
//		btnTodas.setBounds(228, 60, 120, 23);
//		btnTodas.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Se presiono el boton de las notificaciones del administrador");
//			}
//		});
//		btnTodas.setEnabled(true);
		
		/***************BOTON NOTIFICACIONES**********************/
		
		icon1 = new ImageIcon(getClass().getResource("noti.jpg"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(36,30,10)); //Tama o de imagen ancho, alto
		
		btnNoti = new JButton();
		btnNoti.setBounds(354, 24, 36, 30);
		btnNoti.setIcon(imagen1);
		btnNoti.setIcon(imagen1);
		
		btnNoti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		
		
		//BOTON REGRESAR
		btnRegresar = new JButton("Regresar");
		btnRegresar.setBounds(506, 288, 89, 23);
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//btnCatalogo.setEnabled(true);
				//btnProyect.setEnabled(true);
				//contentPane.remove(scrollPane);
                dispose();
                //contentPane.remove(btnNotiCliente);
				//contentPane.remove(btnNotiOperaciones);
				//btnTodas.setEnabled(false); 
				//contentPane.remove(btnElimina);
				//repaint();
								
				//System.out.println("Se presiono el boton de regresar");
			}
		});
	
		icon1 = new ImageIcon(getClass().getResource("lupa.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(17,17,100)); //Tamaño de imagen ancho, alto
				
		lblBuscar = new JLabel(imagen1);
		lblBuscar.setBounds(554, 29, 25, 20);
		
		textField = new JTextField();
		textField.setBounds(416, 29, 134, 20);
		textField.setColumns(10);
		
		textField.addKeyListener(this);
		
		contentPane.setLayout(null);
		contentPane.add(imagenLogo);
		contentPane.add(lblMvc);
		contentPane.add(btnProyect);
		contentPane.add(btnCatalogo);
		contentPane.add(btnNoti);
		contentPane.add(textField);
		contentPane.add(lblBuscar);
		contentPane.add(lblNewLabel);
		contentPane.add(lblCalendario);
		contentPane.add(btnRegresar);
		contentPane.add(btnNotiOperaciones);
		contentPane.add(btnNotiCliente);
		contentPane.add(btnElimina);
		contentPane.add(scrollPane);
	//	contentPane.add(btnElimina);
			
	} //Fin del metodo VistaBandejaNotificaciones
	
	public void muestra(ControlBandejaNotificaciones controlBandeja) {
		System.out.println("id desde bandeja notificaciones: " + VistaAdministrador.idUsuario);
		this.controlBandeja = controlBandeja;
		setVisible(true);
	}//Para el inicio de la historia de usuario
	
	public void muestraTodasLasNotificaciones(ControlBandejaNotificaciones controlBandeja, List <Notificacion> notificaciones) {
		this.controlBandeja = controlBandeja;
		this.notificaciones = notificaciones;
		
		noti.add("Esto es una prueba para visualizar las notificaciones");
		noti.add("Esto es una prueba para visualizar las notificaciones 2");
		noti.add("Esto es una prueba para visualizar las notificaciones 3");
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override /*Metodo para buscar al dar ENTER*/
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) { 
			String id = textField.getText();
			System.out.println(id);	
			textField.setText("");
       	}         
 }	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
