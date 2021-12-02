package mx.uam.ayd.proyecto.presentacion.muestraPedidos;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VistaPedidos extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPedidos frame = new VistaPedidos();
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
	public VistaPedidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		List <String> pedidos = new ArrayList<String>();
		Object[] titulos = {"Proyecto"};
        Object[][] datos = new Object[10][1];

		for(int i=0; i<pedidos.size(); i++) {
			String dato = pedidos.get(i);
			System.out.println(dato);
			for(int j=0; j<2; j++) {
				datos[i][j]= dato; 
			}	
		}		
        		
        DefaultTableModel modelo = new DefaultTableModel(datos, titulos);
		
        JTable table = new JTable(modelo){
		
        	private static final long serialVersionUID = 1L;
        	public Class getColumnClass(int column) {
        		switch (column) {
                	default:
                		return String.class;
        		}
        	}
        };
    
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
    
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(6, 6, 438, 223);
		contentPane.add(scrollPane);
	}

}
