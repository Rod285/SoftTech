package mx.uam.ayd.proyecto.presentacion.muestraVistaMOp;

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
import mx.uam.ayd.proyecto.negocio.ServicioVehiculo;
import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;
import mx.uam.ayd.proyecto.presentacion.bandejaNotificaciones.ControlBandejaNotificaciones;
import mx.uam.ayd.proyecto.presentacion.muestraPedidos.ControlPedidos;
import mx.uam.ayd.proyecto.presentacion.muestraPedidos.VistaPedidos;
import mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador.Desktop;

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
 * VistaMOP
 * Es la vista correspondiente al miembro de operaciones
 * @author Jonathan Cruz
 * @fechaImplementación  20 de enero de 2022 
 */

@SuppressWarnings("serial")
@Component
public class VistaMOp extends JFrame implements KeyListener{
	
	
	static Desktop desk;
	private JPanel contentPane;
	
	private ControlVistaMOp controlVistaOperaciones;
	
	//Icon
	private ImageIcon icon1;
	private Image imagen;
	private ImageIcon imagen1;
	private JTextField textField;
	private JLabel lblBuscar;
	private JButton btnAgenda;
	private JButton btnProyect;
	private JButton btnNoti;
	
	//JDesktopPane Desk;
	
	private boolean disponibilidad =false;//
	
	public VistaMOp() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		/*
		Desk = new JDesktopPane();
		Desk.setBounds(269, 106, 476, 242);
		Desk.setBackground(Color.WHITE);*/
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
		/*Escuchador boton proyectos*/
		btnProyect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnProyect.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnAgenda = new JButton("Agenda");
		btnAgenda.setBounds(228, 28, 100, 25);
		btnAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVistaOperaciones.muestraVistaAgenda();
			}
		});
		btnAgenda.setFont(new Font("Tahoma", Font.PLAIN, 12));

		icon1 = new ImageIcon(getClass().getResource("notification.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(25,25,10)); //Tama o de imagen ancho, alto
		
		btnNoti = new JButton();
		btnNoti.setBounds(340, 24, 50, 30);
		/*Escuchador boton notificaciones*/
		btnNoti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Se presiono el btn Noti");
			}		
		});
		btnNoti.setIcon(imagen1);
			
		icon1 = new ImageIcon(getClass().getResource("lupa.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
        imagen1 = new ImageIcon (imagen.getScaledInstance(17,17,100)); //Tamaño de imagen ancho, alto
				
		lblBuscar = new JLabel(imagen1);
		lblBuscar.setBounds(554, 29, 25, 20);
		
		textField = new JTextField();
		textField.setBounds(416, 29, 134, 20);
		textField.setColumns(10);
		
		textField.addKeyListener(this);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(7, 106, 175, 221);
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
		contentPane.setLayout(null);
		lblMes.setText(fechaActual.getMonth().toString());
		contentPane.add(panel);
		contentPane.add(imagenLogo);
		contentPane.add(lblMvc);
		contentPane.add(btnProyect);
		contentPane.add(btnAgenda);
		contentPane.add(btnNoti);
		contentPane.add(textField);
		contentPane.add(lblBuscar);
		contentPane.add(lblNewLabel);
		//contentPane.add(Desk);
	} //Fin de VistaAdministrador()  
	
	/*
	 * @author Jonathan Cruz
	 * Método que muestra la venta correspondiete al miembro de operaciones
	 * @param ControlVistaMOp control
	 * @fechaImplementación  20 de enero de 2022 
	 */
	public void muestra(ControlVistaMOp control) {
		controlVistaOperaciones = control;
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
