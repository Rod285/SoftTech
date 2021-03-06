package mx.uam.ayd.proyecto.presentacion.muestraVistaIrAPedido;

/*
 * @Autor: Mejía Velázquez José Rodrigo
 * @Descripción: Clase que se encarga de la VistaIrAPedido, la clase cuenta con un constructor que hace posible la visualización
 * de la ventana, además de un método muestra por el cual se le inyecta la información necesaria para su funcionamiento,
 * así cono un modelo de tabla utilizado para la muestra de información que se encuentra como una clase interna.
 */

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Image;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

@Slf4j
@SuppressWarnings("serial")
@Component
public class VistaIrAPedido extends JFrame{
	
	private static final String LOGO = "C:\\Users\\zerat\\Documents\\IngSoft\\AnalysisYDiseno-master\\src\\main\\java\\mx\\uam\\ayd\\proyecto\\presentacion\\muestraVistaIrAPedido\\logo.png";
	
	private ControlVistaIrAPedido controlIrAPedido;
	
	private List<Vehiculo> listaPedido;
	private PedidoTableModel modelo;
	private JTable tablaPedido;
	/*
	 * @Autor: Mejía Velázquez José Rodrigo
	 * @Descripción: Constructor de la VistaIrAPedido
	 */
	public VistaIrAPedido() {
		getContentPane().setBackground(Color.WHITE);
		setBounds(200, 5, 650, 725);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(Color.WHITE);
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		GridBagLayout gbl_panelSur = new GridBagLayout();
		gbl_panelSur.columnWidths = new int[] {90, 130, 210, 130, 0};
		gbl_panelSur.rowHeights = new int[] {30, 25, 30};
		gbl_panelSur.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelSur.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelSur.setLayout(gbl_panelSur);
		
		JButton enviarPedido = new JButton("Enviar Pedido");
		enviarPedido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_enviarPedido = new GridBagConstraints();
		gbc_enviarPedido.fill = GridBagConstraints.BOTH;
		gbc_enviarPedido.insets = new Insets(0, 0, 0, 5);
		gbc_enviarPedido.gridx = 1;
		gbc_enviarPedido.gridy = 1;
		panelSur.add(enviarPedido, gbc_enviarPedido);
		
		JButton regresar = new JButton("Regresar");
		regresar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		regresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_regresar = new GridBagConstraints();
		gbc_regresar.fill = GridBagConstraints.BOTH;
		gbc_regresar.gridx = 3;
		gbc_regresar.gridy = 1;
		panelSur.add(regresar, gbc_regresar);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.WHITE);
		panelNorte.setBounds(0, 0, 650, 200);
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		GridBagLayout gbl_panelNorte = new GridBagLayout();
		gbl_panelNorte.columnWidths = new int[] {90, 70, 60, 210, 30, 30};
		gbl_panelNorte.rowHeights = new int[] {14, 30, 30};
		gbl_panelNorte.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelNorte.rowWeights = new double[]{0.0, 0.0};
		panelNorte.setLayout(gbl_panelNorte);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_logo = new GridBagConstraints();
		gbc_logo.fill = GridBagConstraints.BOTH;
		gbc_logo.insets = new Insets(0, 0, 5, 5);
		gbc_logo.gridx = 0;
		gbc_logo.gridy = 0;
		logo.setIcon(new ImageIcon(new ImageIcon(LOGO).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
		panelNorte.add(logo, gbc_logo);
		
		JLabel siglas = new JLabel("MVC");
		siglas.setFont(new Font("Tahoma", Font.BOLD, 20));
		siglas.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_siglas = new GridBagConstraints();
		gbc_siglas.fill = GridBagConstraints.BOTH;
		gbc_siglas.insets = new Insets(0, 0, 5, 5);
		gbc_siglas.gridx = 1;
		gbc_siglas.gridy = 0;
		panelNorte.add(siglas, gbc_siglas);
		
		JLabel noPedido = new JLabel("No. Pedido:");
		noPedido.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_noPedido = new GridBagConstraints();
		gbc_noPedido.fill = GridBagConstraints.VERTICAL;
		gbc_noPedido.insets = new Insets(0, 0, 5, 0);
		gbc_noPedido.gridx = 3;
		gbc_noPedido.gridy = 0;
		noPedido.setVisible(false);
		panelNorte.add(noPedido, gbc_noPedido);
		
		JLabel nombre = new JLabel("Montalvo Picture Cars");
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 9));
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.anchor = GridBagConstraints.WEST;
		gbc_nombre.gridwidth = 2;
		gbc_nombre.fill = GridBagConstraints.VERTICAL;
		gbc_nombre.insets = new Insets(0, 8, 5, 5);
		gbc_nombre.gridx = 0;
		gbc_nombre.gridy = 1;
		panelNorte.add(nombre, gbc_nombre);
		
		JLabel cliente = new JLabel("Cliente:");
		cliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_cliente = new GridBagConstraints();
		gbc_cliente.insets = new Insets(0, 18, 5, 0);
		gbc_cliente.fill = GridBagConstraints.BOTH;
		gbc_cliente.gridx = 3;
		gbc_cliente.gridy = 1;
		cliente.setVisible(false);
		panelNorte.add(cliente, gbc_cliente);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setBackground(Color.WHITE);
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 5, 500, 473);
		scrollPane.setBackground(Color.WHITE);
		tablaPedido = new JTable();
		tablaPedido.setBackground(Color.WHITE);
		tablaPedido.setCellSelectionEnabled(true);
		tablaPedido.setRowHeight(90);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		tablaPedido.setDefaultRenderer(String.class, centerRenderer);
		tablaPedido.setDefaultRenderer(Integer.class, centerRenderer);
		scrollPane.setViewportView(tablaPedido);
		panelCentro.add(scrollPane);
	}
	
	/*
	 * @Autor: Mejía Velázquez José Rodrigo
	 * @Descripción: Método que muestra la ventana de la historia de usuario Ir a Pedido, se muestran los vehiculos que
	 * se encuentran dentro de la lista de Pedido en una tabla, mostrando su fot, modelo y número de elementos, que por
	 * default es 1
	 * @Parametros: ControlVistaIrAPedido, List<Vehiculo> 
	 */
	public void muestra(ControlVistaIrAPedido controlVistaIrAPedido, List<Vehiculo> listaPedido) {
		this.controlIrAPedido = controlVistaIrAPedido;
		this.listaPedido = listaPedido;
		
		for(Vehiculo v : this.listaPedido) {
			log.info("Vehículo: " + v.getModelo());
		}
		
		modelo = new PedidoTableModel(this.listaPedido);
		tablaPedido.setModel(modelo);
		
		
		setVisible(true);
	}
	
	/*
	 * @Autor: Mejía Velázquez José Rodrigo
	 * @Descripción: Clase que configura el modelo de tabla que se utiliza en la VistaIrAPedido
	 */
	private class PedidoTableModel implements TableModel{
		
		private List<Vehiculo> listaPedido;

		public PedidoTableModel(List<Vehiculo> listaPedido) {
			this.listaPedido = listaPedido;
		}
		
		@Override
		public int getRowCount() {
			return listaPedido.size();
		}

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public String getColumnName(int columnIndex) {
			String title = null;
			
			switch(columnIndex) {
				case 0 : title = "FOTO";
						break;
				case 1 : title = "MODELO";
						break;
				case 2 : title = "CANTIDAD";
						break;		
			}
			return title;
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			if(columnIndex == 0) {
				return ImageIcon.class;
			}else if(columnIndex == 1){
				return String.class;
			}else {
				return Integer.class; //Debe modificarse para la siguiente historia de usuario
			}
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			if(columnIndex == 2) {
				return true;
			}else {
				return false;
			}	
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Vehiculo v = listaPedido.get(rowIndex);
			
			Object value = null;
			
			switch(columnIndex) {
			case 0 : {value = new ImageIcon(new ImageIcon(v.getFoto()).getImage().getScaledInstance(180, 90, Image.SCALE_SMOOTH));
					  break;}
			case 1 : {value = v.getModelo();
					  break;}
			case 2 : {value = 1; //Debe modificarse para la siguiente historia de usuario
					  break;}
			}
			
			return value;
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void addTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
