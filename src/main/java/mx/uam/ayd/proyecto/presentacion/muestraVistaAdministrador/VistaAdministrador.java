package mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;
import mx.uam.ayd.proyecto.presentacion.bandejaNotificaciones.ControlBandejaNotificaciones;
import mx.uam.ayd.proyecto.presentacion.muestraPedidos.ControlPedidos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Color;

/*
 * @author Omar Aldaco Montalvo
 */

@SuppressWarnings("serial")
@Component
public class VistaAdministrador extends JFrame implements KeyListener{
	
	public static long idUsuario;
	private JPanel contentPane;
	@Autowired
	private ControlVistaAdministrador controlVistaAdministrador;
	@Autowired
	private ControlPedidos controlPedidos;
	@Autowired
	private ControlBandejaNotificaciones controlBandejaNotificaciones;
	
	List<Notificacion> notificacionesRecuperadas;
	//Icon
	private ImageIcon icon1;
	private Image imagen;
	private ImageIcon imagen1;
	private JTextField textField;
	private JLabel lblBuscar;
	private JButton btnCatalogo;
		
	private JButton btnProyect;
	private JButton btnNoti;
	
	private boolean disponibilidad =false;//
	
	public VistaAdministrador() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Logo
		icon1 = new ImageIcon(getClass().getResource("logo.png"));  	//Agrega la imagen existente en la clase
	    imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(45,45,10)); //Tama o de imagen ancho, alto
		
		JLabel imagenLogo = new JLabel();
		imagenLogo.setBounds(7, 11, 46, 49);
		imagenLogo.setIcon(imagen1);
		
		JLabel lblMvc = new JLabel("MPC");
		lblMvc.setBounds(56, 24, 52, 36);
		lblMvc.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Montalvo Picture Cars");
		lblNewLabel.setBounds(7, 66, 101, 14);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		btnProyect = new JButton("Proyectos");
		btnProyect.setBounds(126, 28, 100, 25);
		btnProyect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedido p = controlPedidos.damePedido(1);
				//System.out.println(p);
				if(disponibilidad) {
					controlVistaAdministrador.muestraVistaSolicitudAceptada();
					disponibilidad = false;
				}else {
					controlVistaAdministrador.muestraVistaGenerarContrapropuesta();
					disponibilidad = true;
				}
			}
		});
		btnProyect.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 btnCatalogo = new JButton("Catálogo");
		btnCatalogo.setBounds(228, 28, 100, 25);
		btnCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVistaAdministrador.muestraVistaCatalogo();
				System.out.println("Se presiono el boton Catalogos");
			}
		});
		btnCatalogo.setFont(new Font("Tahoma", Font.PLAIN, 14));

			
		/*
		 * Notificaciones
		 */
		
		List <String> notificaciones = new ArrayList<String>();
		
		Object[] titulos = {"Notificaciones", "☑️"};
        Object[][] datos = new Object[10][2];

		for(int i=0; i<notificaciones.size(); i++) {
			String dato = notificaciones.get(i);
			System.out.println(dato);
			for(int j=0; j<2; j++) {
				datos[i][j]= dato; // Almacenan las notificaciones 
			}	
		}		
        		
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);
		
        JTable table = new JTable(modelo){
		
        	private static final long serialVersionUID = 1L;
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
        table.getColumnModel().getColumn(1).setPreferredWidth(30);
    
        JScrollPane spNotificaciones = new JScrollPane(table);
        spNotificaciones.setEnabled(false);
        spNotificaciones.setVisible(false);
        spNotificaciones.setBounds(193, 106, 424, 175);
	
        for(int j=0;j<10;j++) {
        	table.setValueAt(false, j, 1);
        }
        contentPane.add(spNotificaciones);	
        
        icon1 = new ImageIcon(getClass().getResource("basura.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(30,30,10)); //Tama o de imagen ancho, alto
		
		JButton btnElimina = new JButton();
		btnElimina.setBounds(562, 293, 40, 35);
		btnElimina.setIcon(imagen1);
		btnElimina.setVisible(false);
		btnElimina.setEnabled(false);
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aux = 0;
				for(int i=0; i<10; i++) {
					
					boolean estado = (boolean) table.getValueAt(i, 1);
	                	if(estado == true) { //Conprueba si hubo una notificacion seleccionada
	                		aux=1;
	    				}
				}
				
				ArrayList <Integer> x = new ArrayList<Integer>();   
				if(aux==1) { //Si aux=1, hubo una notificacion selecionada
	                for(int i =0;i<10;i++) {
	                	if((boolean) table.getValueAt(i, 1)) {
	                		x.add(i); //Se guardan en ArrayList x los renglones de las notificaciones seleccionadas.
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

				for(int k=0; k<10; k++) { // Verifica si hay notificaciones seleccionadas
	                	if(k == 9 && aux==0) {
	                		JOptionPane.showMessageDialog(null, "No hay notificaciones seleccionadas");
				        }
				}  
				
				for(int j=0; j<10; j++) { //Quita todas las checkbox seleccionadas
					table.setValueAt(false, j, 1);
				}

			}
		});
		contentPane.add(btnElimina);
		
		icon1 = new ImageIcon(getClass().getResource("notification.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(25,25,10)); //Tama o de imagen ancho, alto
		
		btnNoti = new JButton();
		btnNoti.setBounds(340, 24, 50, 30);
		btnNoti.setIcon(imagen1);
		
		btnNoti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controlBandejaNotificaciones.muestraNotificaciones();
				controlVistaAdministrador.muestraVistaNotificaciones(spNotificaciones, btnElimina);
				System.out.println("Se presiono el boton notificaciones");
			}
		});//Fin del escuchador del boton Noti
			
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(7, 106, 174, 221);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panelDiasMes = new JPanel();
		panelDiasMes.setBounds(6, 47, 162, 168);
		panel.add(panelDiasMes);
		panelDiasMes.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton btn1 = new JButton();
		panelDiasMes.add(btn1);
		
		JButton btn2 = new JButton();
		panelDiasMes.add(btn2);
		
		JButton btn3 = new JButton();
		panelDiasMes.add(btn3);
		
		JButton btn4 = new JButton();
		panelDiasMes.add(btn4);
		
		JButton btn5 = new JButton();
		panelDiasMes.add(btn5);
		
		JButton btn6 = new JButton();
		panelDiasMes.add(btn6);
		
		JButton btn7 = new JButton();
		panelDiasMes.add(btn7);
		
		JButton btn8 = new JButton();
		panelDiasMes.add(btn8);
		
		JButton btn9 = new JButton();
		panelDiasMes.add(btn9);
		
		JButton btn10 = new JButton();
		panelDiasMes.add(btn10);
		
		JButton btn11 = new JButton();
		panelDiasMes.add(btn11);
		
		JButton btn12 = new JButton();
		panelDiasMes.add(btn12);
		
		JButton btn13 = new JButton();
		panelDiasMes.add(btn13);
		
		JButton btn14 = new JButton();
		panelDiasMes.add(btn14);
		
		JButton btn15 = new JButton();
		panelDiasMes.add(btn15);
		
		JButton btn16 = new JButton();
		panelDiasMes.add(btn16);
		
		JButton btn17 = new JButton();
		panelDiasMes.add(btn17);
		
		JButton btn18 = new JButton();
		panelDiasMes.add(btn18);
		
		JButton btn19 = new JButton();
		panelDiasMes.add(btn19);
		
		JButton btn20 = new JButton();
		panelDiasMes.add(btn20);
		
		JButton btn21 = new JButton();
		panelDiasMes.add(btn21);
		
		JButton btn22 = new JButton();
		panelDiasMes.add(btn22);
		
		JButton btn23 = new JButton();
		panelDiasMes.add(btn23);
		
		JButton btn24 = new JButton();
		panelDiasMes.add(btn24);
		
		JButton btn25 = new JButton();
		panelDiasMes.add(btn25);
		
		JButton btn26 = new JButton();
		panelDiasMes.add(btn26);
		
		JButton btn27 = new JButton();
		panelDiasMes.add(btn27);
		
		JButton btn28 = new JButton();
		panelDiasMes.add(btn28);
		
		JButton btn329 = new JButton();
		panelDiasMes.add(btn329);
		
		JButton btn30 = new JButton();
		panelDiasMes.add(btn30);
		
		JButton btn31 = new JButton();
		panelDiasMes.add(btn31);
		
		JButton btn32 = new JButton();
		panelDiasMes.add(btn32);
		
		JButton btn33 = new JButton();
		panelDiasMes.add(btn33);
		
		JButton btn34 = new JButton();
		panelDiasMes.add(btn34);
		
		JButton btn35 = new JButton();
		panelDiasMes.add(btn35);
		
		JButton btn36 = new JButton();
		panelDiasMes.add(btn36);
		
		JButton btn37 = new JButton();
		panelDiasMes.add(btn37);
		
		JButton btn38 = new JButton();
		panelDiasMes.add(btn38);
		
		JButton btn39 = new JButton();
		panelDiasMes.add(btn39);
		
		JButton btn40 = new JButton();
		panelDiasMes.add(btn40);
		
		JButton btn41 = new JButton();
		panelDiasMes.add(btn41);
		
		JButton btn42 = new JButton();
		panelDiasMes.add(btn42);
		
		JLabel lblMes = new JLabel();
		lblMes.setBounds(6, 6, 162, 16);
		panel.add(lblMes);
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelDiasSemana = new JPanel();
		panelDiasSemana.setBounds(6, 21, 162, 21);
		panel.add(panelDiasSemana);
		FlowLayout fl_panelDiasSemana = new FlowLayout(FlowLayout.LEFT, 5, 5);
		panelDiasSemana.setLayout(fl_panelDiasSemana);
		
		JLabel lblD = new JLabel("Dom");
		lblD.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		panelDiasSemana.add(lblD);
		
		JLabel lblL = new JLabel("Lun");
		lblL.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		panelDiasSemana.add(lblL);
		
		JLabel lblM = new JLabel("Mar");
		lblM.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		panelDiasSemana.add(lblM);
		
		JLabel lblMi = new JLabel("Mier");
		lblMi.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		panelDiasSemana.add(lblMi);
		
		JLabel lblJ = new JLabel("Jue");
		lblJ.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		panelDiasSemana.add(lblJ);
		
		JLabel lblV = new JLabel("Vie");
		lblV.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		panelDiasSemana.add(lblV);
		
		JLabel lblS = new JLabel("Sab");
		lblS.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		panelDiasSemana.add(lblS);
		
		
		
		LocalDate fechaActual = LocalDate.now();
		int ultimoDia;
		
		try {
			LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), 31);
			ultimoDia=31;
			System.out.println("Ultimo dia del mes: " + ultimoDia);
		}catch(DateTimeException e){
			try {
				LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), 30);
				ultimoDia=30;
				System.out.println("Ultimo dia del mes: " + ultimoDia);
			}catch(DateTimeException e1){
				ultimoDia=28;
				System.out.println("Ultimo dia del mes: " + ultimoDia);
			}
		}
		
		Date fechaAux = new Date();
		int mes = fechaAux.getMonth();
		int anio = fechaAux.getYear();
		
		Date fechaInicioMes = new Date(anio, mes, 1);
		int diaUno = fechaInicioMes.getDay();
		
		java.awt.Component[] componentes = panelDiasMes.getComponents();
		
		int dia = 1;
		int fin=diaUno+ultimoDia;
		
		for(int i=diaUno; i<fin; i++){
			
			if(componentes[i] instanceof JButton) {
				
				String sDia = String.valueOf(dia);
				((JButton)componentes[i]).setText(sDia);
				dia = dia+1;
			}
		}
		
		((JButton)componentes[fechaActual.getDayOfMonth()+diaUno-1]).setForeground(Color.GREEN);
		lblMes.setText(fechaActual.getMonth().toString());				
	} 
	
	public void muestra(ControlVistaAdministrador control) {
		controlVistaAdministrador = control;
		setVisible(true);
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
