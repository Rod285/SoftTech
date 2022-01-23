package mx.uam.ayd.proyecto.presentacion.muestraAgenda;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;

/*
 * VistaAgenda
 * Es la vista correspondiente a la agenda del miembro de operaciones
 * @author Jonathan Cruz
 * @fechaImplementación  20 de enero de 2022 
 */

@SuppressWarnings("serial")
@Component
public class VistaAgenda extends JFrame {
	
	static final int COLUMNASC = 4;
	
	@Autowired
	private ControlVistaAgenda controlVistaAgenda;

	private JPanel contentPane;
	private JTable tablaAgenda;
	private JButton btnAñadir;
	
	private List<String> descrip;
	private JButton btnRegresar;
	

	public VistaAgenda() {
		
	}

	public void muestra(ControlVistaAgenda controlVistaAgenda, List<String> descripciones) {
		this.controlVistaAgenda = controlVistaAgenda;
		this.descrip = descripciones;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAgenda = new JLabel("Agenda");
		lblAgenda.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		Object[] titulos = {"ID","Nombre","Apellido", "Teléfono"};
        Object[][] datos = new Object[15][4];
        
        int numContactos = descrip.size()/COLUMNASC;
        
        for(int i=0; i<numContactos; i++) {
			for(int j=0; j<COLUMNASC; j++) {
				String dato = descripciones.get(j+(i*COLUMNASC));
				datos[i][j]= dato; // Almacenan las notificaciones 
			}	
		}
        
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);
        tablaAgenda = new JTable(modelo){

			private static final long serialVersionUID = 1L;

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
				controlVistaAgenda.termina();
				controlVistaAgenda.agregarContacto();			
			}
		});
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVistaAgenda.termina();			
			}
		});
		btnRegresar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(150)
							.addComponent(lblAgenda))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnAñadir)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnRegresar))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(20)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAgenda)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegresar)
						.addComponent(btnAñadir))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		setVisible(true);
		
	}
}
