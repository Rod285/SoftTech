package mx.uam.ayd.proyecto.presentacion.muestraVistaIrAPedido;


import java.util.List;



import javax.swing.JFrame;
import javax.swing.JPanel;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

@Slf4j
@SuppressWarnings("serial")
@Component
public class VistaIrAPedido extends JFrame{
	
	private static final String LOGO = "C:\\Users\\zerat\\Documents\\IngSoft\\AnalysisYDiseno-master\\src\\main\\java\\mx\\uam\\ayd\\proyecto\\presentacion\\muestraVistaIrAPedido\\logo.png";
	
	private ControlVistaIrAPedido controlIrAPedido;
	
	private List<Vehiculo> listaPedido;
	private PedidoTableModel modelo;
	private JTable tablaPedido;
	private JComboBox<Integer> cantidades;

	public VistaIrAPedido() {
		setBounds(200, 5, 650, 725);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 20));
		
		JButton enviarPedido = new JButton("Enviar Pedido");
		panelSur.add(enviarPedido);
		
		JButton regresar = new JButton("Regresar");
		panelSur.add(regresar);
		
		JPanel panelNorte = new JPanel();
		panelNorte.setBounds(0, 0, 650, 200);
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		GridBagLayout gbl_panelNorte = new GridBagLayout();
		gbl_panelNorte.columnWidths = new int[] {100, 110, 30, 0, 30, 30};
		gbl_panelNorte.rowHeights = new int[] {14, 30, 20};
		gbl_panelNorte.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelNorte.rowWeights = new double[]{0.0, 0.0, 0.0};
		panelNorte.setLayout(gbl_panelNorte);
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_logo = new GridBagConstraints();
		gbc_logo.fill = GridBagConstraints.BOTH;
		gbc_logo.insets = new Insets(0, 0, 5, 5);
		gbc_logo.gridx = 0;
		gbc_logo.gridy = 0;
		logo.setIcon(new ImageIcon(new ImageIcon(LOGO).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
		panelNorte.add(logo, gbc_logo);
		
		JLabel siglas = new JLabel("MVC");
		siglas.setFont(new Font("Tahoma", Font.BOLD, 40));
		siglas.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_siglas = new GridBagConstraints();
		gbc_siglas.fill = GridBagConstraints.BOTH;
		gbc_siglas.insets = new Insets(0, 0, 5, 5);
		gbc_siglas.gridx = 1;
		gbc_siglas.gridy = 0;
		panelNorte.add(siglas, gbc_siglas);
		
		JLabel noPedido = new JLabel("No. Pedido:");
		noPedido.setFont(new Font("Tahoma", Font.BOLD, 40));
		GridBagConstraints gbc_noPedido = new GridBagConstraints();
		gbc_noPedido.fill = GridBagConstraints.BOTH;
		gbc_noPedido.insets = new Insets(0, 0, 5, 0);
		gbc_noPedido.gridx = 3;
		gbc_noPedido.gridy = 0;
		noPedido.setVisible(false);
		panelNorte.add(noPedido, gbc_noPedido);
		
		JLabel nombre = new JLabel("Montalvo Picture Cars");
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.gridwidth = 2;
		gbc_nombre.fill = GridBagConstraints.BOTH;
		gbc_nombre.insets = new Insets(0, 0, 5, 5);
		gbc_nombre.gridx = 0;
		gbc_nombre.gridy = 1;
		panelNorte.add(nombre, gbc_nombre);
		
		JLabel cliente = new JLabel("Cliente:");
		cliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_cliente = new GridBagConstraints();
		gbc_cliente.insets = new Insets(0, 0, 5, 0);
		gbc_cliente.fill = GridBagConstraints.BOTH;
		gbc_cliente.gridx = 3;
		gbc_cliente.gridy = 1;
		panelNorte.add(cliente, gbc_cliente);
		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 5, 500, 473);
		tablaPedido = new JTable();
		tablaPedido.setCellSelectionEnabled(true);
		tablaPedido.setRowHeight(90);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		tablaPedido.setDefaultRenderer(String.class, centerRenderer);
		tablaPedido.setDefaultRenderer(Integer.class, centerRenderer);
		scrollPane.setViewportView(tablaPedido);
		panelCentro.add(scrollPane);
		
		
	}
	
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
				return Integer.class;
			}
			
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
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
			case 2 : {value = 1;
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
