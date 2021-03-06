package mx.uam.ayd.proyecto.presentacion.muestraPedidos;

/*
 * @Nombre: VistaPediso
 * @Descripción: Muestra toda la información relacionada a los pedidos
 * * @Autor: Aldaco Montalvo Omar
 * @Fecha de implementación: 30/01/2022
 */

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.generarContrapropuesta.ControlGenerarContrapropuesta;

import java.awt.ScrollPane;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JProgressBar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

@SuppressWarnings("serial")
@Component
public class VistaPedidos extends JPanel {
	
	//PRUEBA 
	
	@Autowired
	private ControlPedidos controlPedidos;

	private JTable tablaPedidos;

	/**
	 * Create the frame.
	 */
	public VistaPedidos() {
		
		Object[] columnas = {"ID", "Cliente", "Entrega", "Status"};
		Object[][] data = new Object [10][4];
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<4; j++) {
				data[i][j]="";
			}	
		}	
		
		DefaultTableModel model = new DefaultTableModel(data, columnas);
		
		tablaPedidos = new JTable(model) {
        	private static final long serialVersionUID = 1L;
        	public Class getColumnClass(int column) {
                switch (column) {
                    default:
                        return String.class;
                }
            }
        };
		
        tablaPedidos.setPreferredScrollableViewportSize(tablaPedidos.getPreferredSize());
        tablaPedidos.getColumnModel().getColumn(0).setPreferredWidth(35);
        tablaPedidos.getColumnModel().getColumn(1).setPreferredWidth(200);
        tablaPedidos.getColumnModel().getColumn(2).setPreferredWidth(50);
        tablaPedidos.getColumnModel().getColumn(3).setPreferredWidth(50);
        
		JScrollPane scrollPane = new JScrollPane(tablaPedidos);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
					.addGap(6))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
					.addGap(6))
		);
		setLayout(groupLayout);

	}// Fin del metodo 
	
	/*
	 * @Autor: Aldaco Montalvo Omar
	 * @Descripción: Método que hace visible la VistaPedidos
	 * @Fecha de implementación: 30/01/2022
	 * @Parametro de entrada: ControlPedidos control, List<String> informacion
	 * @Valor de retorno: void
	 */
	
	public VistaPedidos muestra(ControlPedidos control, List<String> informacion) {
		
		int columna = 0, fila = 0;
		System.out.println(informacion.size());
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<4; j++) {
				tablaPedidos.setValueAt("",i,j);
			}	
		}
		
		for(int i=0; i<informacion.size(); i++) {
			tablaPedidos.setValueAt(informacion.get(i), fila, columna);
			columna++;
			if(columna%4==0) {
				fila++;
				columna=0;
			}
		}	
		
		controlPedidos = control;
		//setVisible(true);
		return this;
	}
}
