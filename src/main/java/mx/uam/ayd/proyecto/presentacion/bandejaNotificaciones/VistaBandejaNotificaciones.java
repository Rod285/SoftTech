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

	@Autowired
	private ControlBandejaNotificaciones controlBandeja;
	
	private JTable tablaNotificaciones;
	
	//Icon
		private ImageIcon icon1;
		private Image imagen;
		private ImageIcon imagen1;
		
	/**
	 * Create the frame.
	 */
	public VistaBandejaNotificaciones() { //Inicio del metodo

        //List <String> notificaciones = new ArrayList<String>();
		
		Object[] titulos = {"Bandeja notificaciones", "☑️"};
        Object[][] datos = new Object[8][2];

		/*for(int i=0; i<notificaciones.size(); i++) {
			String dato = notificaciones.get(i);
			System.out.println(dato);
			for(int j=0; j<2; j++) {
				datos[i][j]= dato; // Almacenan las notificaciones 
			}	
		}*/		
        		
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);	
        tablaNotificaciones = new JTable(modelo){
		
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
    
        tablaNotificaciones.setPreferredScrollableViewportSize(tablaNotificaciones.getPreferredSize());
        tablaNotificaciones.getColumnModel().getColumn(0).setPreferredWidth(350);
        tablaNotificaciones.getColumnModel().getColumn(1).setPreferredWidth(10);
    
        JScrollPane scrollPane = new JScrollPane(tablaNotificaciones);
        
        /*Boton elimina*/
        JButton btnElimina = new JButton();
        icon1 = new ImageIcon(getClass().getResource("basura.png"));  	//Agrega la imagen existente en la clase
		imagen = icon1.getImage(); 										//
		imagen1 = new ImageIcon (imagen.getScaledInstance(32,32,10)); //Tama o de imagen ancho, alto
		
		//btnElimina.setBounds(562, 293, 40, 35);
		btnElimina.setIcon(imagen1);
		//btnElimina.setVisible(false);
		//btnElimina.setEnabled(false);
		btnElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aux = 0;
				for(int i=0; i<8; i++) {
					
					boolean estado = (boolean) tablaNotificaciones.getValueAt(i, 1);
	                	if(estado == true) { //Conprueba si hubo una notificacion seleccionada
	                		aux=1;
	    				}
				}
				
				ArrayList <Integer> x = new ArrayList<Integer>();   
				if(aux==1) { //Si aux=1, hubo una notificacion selecionada
	                for(int i =0;i<8;i++) {
	                	if((boolean) tablaNotificaciones.getValueAt(i, 1)) {
	                		x.add(i); //Se guardan en ArrayList x los renglones de las notificaciones seleccionadas.
	                	    //System.out.println(x.get(i));
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
	    		    		tablaNotificaciones.setValueAt("", x.get(k), 0);  
	    		    	}
	    		    			
	    		    	JOptionPane.showMessageDialog(null, "Eliminadas");    	
	    		    }
				}

				for(int k=0; k<8; k++) { // Verifica si hay notificaciones seleccionadas
	                	if(k == 7 && aux==0) {
	                		JOptionPane.showMessageDialog(null, "No hay notificaciones seleccionadas");
				        }
				}  
				
				for(int j=0; j<8; j++) { //Quita todas las checkbox seleccionadas
					tablaNotificaciones.setValueAt(false, j, 1);
				}

			}
		});
        
        
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        				.addComponent(btnElimina, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnElimina)
        			.addGap(24))
        );
		setLayout(groupLayout);

        for(int j=0;j<8;j++) {
        	tablaNotificaciones.setValueAt(false, j, 1); //Establece el valor de la celda .
        }
        //add(spNotificaciones);	
        	
	} //Fin del metodo VistaBandejaNotificaciones
	
	public VistaBandejaNotificaciones muestra(ControlBandejaNotificaciones control) {
		controlBandeja = control;
		return this;
	}
}
