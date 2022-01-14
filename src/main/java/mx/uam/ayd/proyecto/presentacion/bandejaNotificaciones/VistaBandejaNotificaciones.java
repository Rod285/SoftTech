package mx.uam.ayd.proyecto.presentacion.bandejaNotificaciones;


import java.awt.EventQueue; 
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;


@SuppressWarnings("serial")
@Component
public class VistaBandejaNotificaciones extends JPanel{

	static final int CNoti = 3;
	@Autowired
	private ControlBandejaNotificaciones controlBandeja;
	
	private JTable tablaNotificaciones;
	
	private List<String> descrip;
	
	/**
	 * Create the frame.
	 */
	public VistaBandejaNotificaciones() { 
		
	} 
	
	public void muestra(ControlBandejaNotificaciones control, List<String> descripciones) {
		controlBandeja = control;
		this.descrip = descripciones;
		//System.out.println("Entro al metodo muestra de la vista bandeja");
		//descrip.forEach(employee -> System.out.println(employee.toString()));	
		Object[] titulos = {"Descripcion","Fecha","Hora", "☑️"};
        Object[][] datos = new Object[10][4];

        int filas = descrip.size()/CNoti;
        
		for(int i=0; i<filas; i++) {
			for(int j=0; j<CNoti; j++) {
				String dato = descripciones.get(j+(i*CNoti));
				datos[i][j]= dato; // Almacenan las notificaciones 
			}	
		}
        		
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);	
        tablaNotificaciones = new JTable(modelo){
		
        	//private static final long serialVersionUID = 1L;
        	
        	public Class getColumnClass(int column) {
        		switch (column) {
                	case 0:
                		return String.class;
                	case 1:
                		return String.class;
                	case 2:
                		return String.class;
                	default:
                		return Boolean.class;
        		}
        	}
        };
    
        tablaNotificaciones.setPreferredScrollableViewportSize(tablaNotificaciones.getPreferredSize());
        tablaNotificaciones.getColumnModel().getColumn(0).setPreferredWidth(250);
        tablaNotificaciones.getColumnModel().getColumn(1).setPreferredWidth(70);
        tablaNotificaciones.getColumnModel().getColumn(2).setPreferredWidth(70);
        tablaNotificaciones.getColumnModel().getColumn(3).setPreferredWidth(15);
    
        JScrollPane scrollPane = new JScrollPane(tablaNotificaciones);
        
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
        			.addGap(48))
        );
		setLayout(groupLayout);	
	} //Fin del metodo muestra
		
}
