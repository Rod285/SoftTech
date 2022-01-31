package mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyVetoException;
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

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioPedido;
import mx.uam.ayd.proyecto.negocio.ServicioVehiculo;
import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;
import mx.uam.ayd.proyecto.presentacion.bandejaNotificaciones.ControlBandejaNotificaciones;
import mx.uam.ayd.proyecto.presentacion.muestraPedidos.ControlPedidos;
import mx.uam.ayd.proyecto.presentacion.muestraPedidos.VistaPedidos;

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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JDesktopPane;

/*
 * @Nombre: VistaAdministrador
 * @Descripción: Muestra la información que es útil para el administrador del sistema
 * * @Autor: Aldaco Montalvo Omar
 * @Fecha de implementación: 30/01/2022
 */

@SuppressWarnings("serial")
@Component
public class VistaAdministrador extends JFrame implements KeyListener{
	
	public static long idUsuario;
	static Desktop desk;
	private JPanel contentPane;
	@Autowired
	private ControlVistaAdministrador controlVistaAdministrador;
	@Autowired
	private ControlPedidos controlPedidos;

	
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
	
	JDesktopPane Desk;
	
	private boolean disponibilidad =false;//
	
	public List<Pedido> pedidos; 
	
	public VistaAdministrador() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		Desk = new JDesktopPane();
		Desk.setBackground(Color.WHITE);
		
		//Logo
		icon1 = new ImageIcon(getClass().getResource("logo.png"));  	//Agrega la imagen existente en la clase
	    imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(45,45,10)); //Tama o de imagen ancho, alto
		
		JLabel imagenLogo = new JLabel();
		imagenLogo.setIcon(imagen1);
		
		JLabel lblMvc = new JLabel("MPC");
		lblMvc.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Montalvo Picture Cars");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
    
		/*btnProyect = new JButton("Proyectos");
		
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
		btnProyect.setFont(new Font("Tahoma", Font.PLAIN, 12));*/
		btnCatalogo = new JButton("Catálogo");
		btnCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVistaAdministrador.muestraVistaCatalogo();
				System.out.println("Se presiono el boton Catalogos");
			}
		});
		btnCatalogo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		icon1 = new ImageIcon(getClass().getResource("notification.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(25,25,10)); //Tama o de imagen ancho, alto
		
		btnNoti = new JButton();
		/*Escuchador boton notificaciones*/
		btnNoti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Se presiono el btn Noti");
				String titulo = "Notificaciones";
				Desk.removeAll();
				desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaNotificaciones());
				Desk.add(desk);	
				try {
					desk.setMaximum(true);
				} catch (PropertyVetoException pve) {
					pve.printStackTrace();
				}
				
			}		
		});
		btnNoti.setIcon(imagen1);
			
		icon1 = new ImageIcon(getClass().getResource("lupa.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(17,17,100)); //Tamaño de imagen ancho, alto
				
		lblBuscar = new JLabel(imagen1);
		
		textField = new JTextField();	
		textField.setColumns(10);
		
		textField.addKeyListener(this);
		
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
		btn1.setEnabled(false);
		panelDiasMes.add(btn1);
		
		JButton btn2 = new JButton();
		btn2.setEnabled(false);
		panelDiasMes.add(btn2);
		
		JButton btn3 = new JButton();
		btn3.setEnabled(false);
		panelDiasMes.add(btn3);
		
		JButton btn4 = new JButton();
		btn4.setEnabled(false);
		panelDiasMes.add(btn4);
		
		JButton btn5 = new JButton();
		btn5.setEnabled(false);
		panelDiasMes.add(btn5);
		
		JButton btn6 = new JButton();
		btn6.setEnabled(false);
		panelDiasMes.add(btn6);
		
		JButton btn7 = new JButton();
		btn7.setEnabled(false);
		panelDiasMes.add(btn7);
		
		JButton btn8 = new JButton();
		btn8.setEnabled(false);
		panelDiasMes.add(btn8);
		
		JButton btn9 = new JButton();
		btn9.setEnabled(false);
		panelDiasMes.add(btn9);
		
		JButton btn10 = new JButton();
		btn10.setEnabled(false);
		panelDiasMes.add(btn10);
		
		JButton btn11 = new JButton();
		btn11.setEnabled(false);
		panelDiasMes.add(btn11);
		
		JButton btn12 = new JButton();
		btn12.setEnabled(false);
		panelDiasMes.add(btn12);
		
		JButton btn13 = new JButton();
		btn13.setEnabled(false);
		panelDiasMes.add(btn13);
		
		JButton btn14 = new JButton();
		btn14.setEnabled(false);
		panelDiasMes.add(btn14);
		
		JButton btn15 = new JButton();
		btn15.setEnabled(false);
		panelDiasMes.add(btn15);
		
		JButton btn16= new JButton();
		btn16.setEnabled(false);
		panelDiasMes.add(btn16);
		
		JButton btn17 = new JButton();
		btn17.setEnabled(false);
		panelDiasMes.add(btn17);
		
		JButton btn18 = new JButton();
		btn18.setEnabled(false);
		panelDiasMes.add(btn18);
		
		JButton btn19 = new JButton();
		btn19.setEnabled(false);
		panelDiasMes.add(btn19);
		
		JButton btn20 = new JButton();
		btn20.setEnabled(false);
		panelDiasMes.add(btn20);
		
		JButton btn21 = new JButton();
		btn21.setEnabled(false);
		panelDiasMes.add(btn21);
		
		JButton btn22 = new JButton();
		btn22.setEnabled(false);
		panelDiasMes.add(btn22);
		
		JButton btn23 = new JButton();
		btn23.setEnabled(false);
		panelDiasMes.add(btn23);
		
		JButton btn24 = new JButton();
		btn24.setEnabled(false);
		panelDiasMes.add(btn24);
		
		JButton btn25 = new JButton();
		btn25.setEnabled(false);
		panelDiasMes.add(btn25);
		
		JButton btn26 = new JButton();
		btn26.setEnabled(false);
		panelDiasMes.add(btn26);
		
		JButton btn27 = new JButton();
		btn27.setEnabled(false);
		panelDiasMes.add(btn27);
		
		JButton btn28 = new JButton();
		btn28.setEnabled(false);
		panelDiasMes.add(btn28);
		
		JButton btn29 = new JButton();
		btn29.setEnabled(false);
		panelDiasMes.add(btn29);
		
		JButton btn30 = new JButton();
		btn30.setEnabled(false);
		panelDiasMes.add(btn30);
		
		JButton btn31 = new JButton();
		btn31.setEnabled(false);
		panelDiasMes.add(btn31);
		
		JButton btn32 = new JButton();
		btn32.setEnabled(false);
		panelDiasMes.add(btn32);
		
		JButton btn33 = new JButton();
		btn33.setEnabled(false);
		panelDiasMes.add(btn33);
		
		JButton btn34 = new JButton();
		btn34.setEnabled(false);
		panelDiasMes.add(btn34);
		
		JButton btn35 = new JButton();
		btn35.setEnabled(false);
		panelDiasMes.add(btn35);
		
		JButton btn36 = new JButton();
		btn36.setEnabled(false);
		panelDiasMes.add(btn36);
		
		JButton btn37 = new JButton();
		btn37.setEnabled(false);
		panelDiasMes.add(btn37);
		
		JButton btn38 = new JButton();
		btn38.setEnabled(false);
		panelDiasMes.add(btn38);
		
		JButton btn39 = new JButton();
		btn39.setEnabled(false);
		panelDiasMes.add(btn39);
		
		JButton btn40 = new JButton();
		btn40.setEnabled(false);
		panelDiasMes.add(btn40);
		
		JButton btn41 = new JButton();
		btn41.setEnabled(false);
		panelDiasMes.add(btn41);
		
		JButton btn42 = new JButton();
		btn42.setEnabled(false);
		panelDiasMes.add(btn42);
		
		LocalDate fechaActual = LocalDate.now();
		int ultimoDia;
		
		try {
			LocalDate.of(fechaActual.getYear(), fechaActual.getMonth(), 31);
			ultimoDia=31;
			System.out.println("Ultimo dia del mes: " + ultimoDia +  "/" + fechaActual.getYear() + "/" +fechaActual.getMonth());
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
				((JButton)componentes[i]).setEnabled(true);
				dia = dia+1;
			}
		}
		
		((JButton)componentes[fechaActual.getDayOfMonth()+diaUno-1]).setForeground(Color.GREEN);
		
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fecha = btn1.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
					
				}
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn2.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
					
					
				}
			}
		});
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn3.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
					
				}
			}
		});

		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn4.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
					
				}
			}
		});
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn5.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
					
				}
			}
		});
		
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn6.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn7.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}

			}
		});
		
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn8.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
					
				}
			}
		});
		
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn9.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn10.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
					
				}
			}
		});
		
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn11.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn12.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn13.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fecha = btn14.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = 	btn15.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn16.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn17.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn18.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn19.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn20.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn21.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn22.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn23.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn24.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn25.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn26.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn27.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn28.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn29.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn30.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn31.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn32.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn33.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn34.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
					
				}
			}
		});
		
		btn35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn35.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {

					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn36.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn37.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn38.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn39.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn40.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn41.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btn42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String fecha = btn42.getText() + "/" + fechaActual.getMonthValue() + "/" + fechaActual.getYear();
				
				System.out.println(fecha);
				
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidosPorFecha(fecha);
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
				}
			}
		});
		
		btnProyect = new JButton("Proyectos");
		/*Escuchador boton proyectos*/
		btnProyect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				String titulo = "Pedidos";
				
				pedidos = controlPedidos.recuperaPedidos();
				
				if(!pedidos.isEmpty()) {
					
					Desk.removeAll();
					repaint();
					desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
					Desk.add(desk);	
					
					try {
						desk.setMaximum(true);
					} catch (PropertyVetoException pve) {
						pve.printStackTrace();
					}
					
					for(Pedido pedidoAux:pedidos) {
						
						String dia = "" + pedidoAux.getFechaEntrega().charAt(0);
						String aux = "" + pedidoAux.getFechaEntrega().charAt(1);
						
						if(!aux.equals("/")) {
							dia = dia + aux;
						}
						
						LocalDate fechaActual = LocalDate.now();
						
						int intDia = Integer.parseInt(dia);
						
						java.awt.Component[] componentes = panelDiasMes.getComponents();
						
						if(intDia-fechaActual.getDayOfMonth()<3) {
							
							((JButton)componentes[intDia+diaUno-1]).setForeground(Color.RED);
						}else {
							
							if(intDia-fechaActual.getDayOfMonth()>3 && intDia-fechaActual.getDayOfMonth()<5) {
								
								((JButton)componentes[intDia+diaUno-1]).setForeground(Color.YELLOW);
							}else {
								
								if(intDia-fechaActual.getDayOfMonth()>5) {
									
									((JButton)componentes[intDia+diaUno-1]).setForeground(Color.GREEN);
								}
							}
						}
						
					}
					
				}else {
					
					Desk.removeAll();
					repaint();
					muestraMensaje();
					
				}
				
				/*controlPedidos.damePedido(1);
				//System.out.println(p);
				if(disponibilidad) {
					controlVistaAdministrador.muestraVistaSolicitudAceptada();
					disponibilidad = false;
				}else {
					controlVistaAdministrador.muestraVistaGenerarContrapropuesta();
					disponibilidad = true;
				}*/
			}
		});
		btnProyect.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblMes = new JLabel();
		lblMes.setBounds(6, 6, 162, 16);
		panel.add(lblMes);
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setText(fechaActual.getMonth().toString());
		
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
			//System.out.println("Ultimo dia del mes: " + ultimoDia);
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
				((JButton)componentes[i]).setEnabled(true);
				dia = dia+1;
			}
		}
		
		((JButton)componentes[fechaActual.getDayOfMonth()+diaUno-1]).setForeground(Color.GREEN);
		lblMes.setText(fechaActual.getMonth().toString());
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(2)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(imagenLogo, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(3)
									.addComponent(lblMvc, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnProyect, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(btnCatalogo, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addComponent(btnNoti, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(lblBuscar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(43)
									.addComponent(Desk, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)))))
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
							.addGap(87)
							.addComponent(Desk, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(imagenLogo, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addComponent(lblMvc, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addComponent(btnProyect, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(17)
							.addComponent(btnCatalogo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addComponent(btnNoti, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblBuscar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addGap(6)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Desk, GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
						//.addComponent(Desk, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	} //Fin de VistaAdministrador()  
	
	/*
	 * @Autor: Aldaco Montalvo Omar
	 * @Descripción: Método que hace visible la vistaAdministrador
	 * @Fecha de implementación: 30/01/2022
	 * @Parametro de entrada: ControlVistaAdministrador control
	 * @Valor de retorno: void
	 */
	
	public void muestra(ControlVistaAdministrador control) {
		controlVistaAdministrador = control;
		setVisible(true);
	}
	
	/*
	 * @Autor: Aldaco Montalvo Omar
	 * @Descripción: Método que muestra mensaje de aviso
	 * @Fecha de implementación: 30/01/2022
	 * @Valor de retorno: void
	 */
	
	public void muestraMensaje(){
		
		JOptionPane.showMessageDialog(null, "No hay pedidos para este día");
		
	}
	
	/*
	 * @Autor: Aldaco Montalvo Omar
	 * @Descripción: Método que muestra mensaje de aviso
	 * @Fecha de implementación: 30/01/2022
	 * @Valor de retorno: void
	 */
	
	public void muestraMensajeCliente(){
		
		JOptionPane.showMessageDialog(null, "No hay pedidos para este cliente");
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override /*Metodo para buscar al dar ENTER*/
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) { 
			
			String titulo = "Pedidos";
			
			String cliente = textField.getText();
			pedidos = controlPedidos.recuperaPedidosPorCliente(cliente);
			textField.setText("");
			
			if(!pedidos.isEmpty()) {
				
				Desk.removeAll();
				repaint();
				desk = new Desktop(titulo, controlVistaAdministrador.muestraVistaPedidos(pedidos));
				Desk.add(desk);	
				
				try {
					desk.setMaximum(true);
				} catch (PropertyVetoException pve) {
					pve.printStackTrace();
				}
				
			}else {
				
				Desk.removeAll();
				repaint();
				muestraMensajeCliente();
			}
       	}         
 }	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
