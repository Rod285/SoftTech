package mx.uam.ayd.proyecto.presentacion.muestraAgenda;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
@Component
public class VistaAgenda extends JPanel{

	static final int COLUMNASC = 4;
	
	@Autowired
	private ControlVistaAgenda controlAgenda;
	
	private JTable tablaAgenda;
	
	private JButton btnAñadir;
	
	private List<String> descrip;
	
	/*
	 * Create the frame
	 */
	public VistaAgenda() {
	}
	
	public void muestra(ControlVistaAgenda controlAgenda, List<String> descripciones) {
		this.controlAgenda = controlAgenda;
		this.descrip = descripciones;
		
		Object[] titulos = {"ID","Nombre","Apellido", "Teléfono"};
        Object[][] datos = new Object[10][4];
        
        int numContactos = descrip.size()/COLUMNASC;
        
        for(int i=0; i<numContactos; i++) {
			for(int j=0; j<COLUMNASC; j++) {
				String dato = descripciones.get(j+(i*COLUMNASC));
				datos[i][j]= dato; // Almacenan las notificaciones 
			}	
		}
        
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);	
        tablaAgenda = new JTable(modelo){
		
        	//private static final long serialVersionUID = 1L;
        	
        	public Class getColumnClass(int column) {
        		switch (column) {
                	case 0:
                		return String.class;
                	case 1:
                		return String.class;
                	case 2:
                		return String.class;
                	case 3:
                		return String.class;
                	default:
                		return Boolean.class;
        		}
        	}
        };
		
        tablaAgenda.setPreferredScrollableViewportSize(tablaAgenda.getPreferredSize());
        tablaAgenda.getColumnModel().getColumn(0).setPreferredWidth(10);
        tablaAgenda.getColumnModel().getColumn(1).setPreferredWidth(70);
        tablaAgenda.getColumnModel().getColumn(2).setPreferredWidth(70);
        tablaAgenda.getColumnModel().getColumn(3).setPreferredWidth(70);
        
JScrollPane scrollPane = new JScrollPane(tablaAgenda);
        
        btnAñadir = new JButton("Añadir contacto");
        btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				System.out.println("Se presiono el boton añadir");
			}
		});
        btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
        
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        				.addComponent(btnAñadir, Alignment.TRAILING))
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnAñadir)
        			.addContainerGap(13, Short.MAX_VALUE))
        );
        
		setLayout(groupLayout);	
		
	}
}
