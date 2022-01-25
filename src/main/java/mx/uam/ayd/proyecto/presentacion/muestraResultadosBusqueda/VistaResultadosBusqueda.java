/*
 * @Autor: Mejía Velázquez José Rodrigo
 * @Nombre: VistaResultadosBusqueda
 * @Descripción: Esta clase lleva a cabo es la vista del sistema que muestra los resultados de buscar un vehiculo por su modelo.
 * @Fecha de implementación: 20/01/2022
 */
package mx.uam.ayd.proyecto.presentacion.muestraResultadosBusqueda;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;
import mx.uam.ayd.proyecto.presentacion.muestraVistaCatalogo.ControlVistaCatalogo;

@Slf4j
@Component
public class VistaResultadosBusqueda extends JFrame{
	
	private ControlVistaResultadosBusqueda control;
	private List<Vehiculo> resultadosBusqueda;
	private JTable tablaResultados;
	private ResultadosTableModel modelo;
	private static final String LOGO = "C:\\Users\\zerat\\Documents\\IngSoft\\AnalysisYDiseno-master\\src\\main\\java\\mx\\uam\\ayd\\proyecto\\presentacion\\muestraVistaIrAPedido\\logo.png";

	public VistaResultadosBusqueda() {
		setBounds(200, 5, 650, 725);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelSur = new JPanel();
		getContentPane().add(panelSur, BorderLayout.SOUTH);
		GridBagLayout gbl_panelSur = new GridBagLayout();
		gbl_panelSur.columnWidths = new int[] {90, 130, 210, 130, 0};
		gbl_panelSur.rowHeights = new int[] {30, 25, 30};
		gbl_panelSur.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelSur.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panelSur.setLayout(gbl_panelSur);
		
		JButton agregarAPedido = new JButton("Agregar a Pedido");
		agregarAPedido.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TableModel modeloTabla = tablaResultados.getModel();
				List<Boolean> seleccion = new ArrayList<>();
				for(int i = 0; i < modeloTabla.getRowCount() ;i++) {
					seleccion.add((Boolean) modeloTabla.getValueAt(i, 2));
					log.info("valor: " + seleccion.get(i));
				}
			}
		});
		agregarAPedido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		agregarAPedido.setSize(100, 25);
		GridBagConstraints gbc_agregarAPedido = new GridBagConstraints();
		gbc_agregarAPedido.fill = GridBagConstraints.BOTH;
		gbc_agregarAPedido.gridx = 1;
		gbc_agregarAPedido.gridy = 1;
		panelSur.add(agregarAPedido, gbc_agregarAPedido);
		
		JButton regresar = new JButton("Regresar");
		regresar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		regresar.setSize(100, 25);
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
		panelNorte.setBounds(0, 0, 650, 200);
		getContentPane().add(panelNorte, BorderLayout.NORTH);
		GridBagLayout gbl_panelNorte = new GridBagLayout();
		gbl_panelNorte.columnWidths = new int[] {88, 70, 60, 210, 30, 30};
		gbl_panelNorte.rowHeights = new int[] {14, 30};
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
		logo.setIcon(new ImageIcon(new ImageIcon(LOGO).getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH)));
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
		
		JLabel lblResultados = new JLabel("Resultados:");
		lblResultados.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblResultados = new GridBagConstraints();
		gbc_lblResultados.fill = GridBagConstraints.VERTICAL;
		gbc_lblResultados.insets = new Insets(0, 0, 5, 0);
		gbc_lblResultados.gridx = 3;
		gbc_lblResultados.gridy = 0;
		panelNorte.add(lblResultados, gbc_lblResultados);
		
		JLabel nombre = new JLabel("Montalvo Picture Cars");
		nombre.setFont(new Font("Tahoma", Font.PLAIN, 9));
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_nombre = new GridBagConstraints();
		gbc_nombre.anchor = GridBagConstraints.NORTHWEST;
		gbc_nombre.gridwidth = 2;
		gbc_nombre.insets = new Insets(0, 8, 5, 5);
		gbc_nombre.gridx = 0;
		gbc_nombre.gridy = 1;
		panelNorte.add(nombre, gbc_nombre);
		
		JPanel panelCentro = new JPanel();
		getContentPane().add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 5, 500, 473);
		tablaResultados = new JTable();
		tablaResultados.setCellSelectionEnabled(true);
		tablaResultados.setRowHeight(90);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
		tablaResultados.setDefaultRenderer(String.class, centerRenderer);
		tablaResultados.setDefaultRenderer(Integer.class, centerRenderer);
		scrollPane.setViewportView(tablaResultados);
		panelCentro.add(scrollPane);
	}
	
	/*
	 * @Autor: Mejía Velázquez José Rodrigo
	 * @Descripción: Método que invoca la inicialización de la vista de resultados de busqueda e inicializa sus
	 * componentes más importantes
	 * @Fecha de implementación: 20/01/2022
	 * @Parametro de entrada: ControlVistaResultadosBusqueda controlVistaResultadosBusqueda, List<Vehiculo> resultadosBusqueda 
	 * @Valor de retorno: void
	 */
	public void muestra(ControlVistaResultadosBusqueda controlVistaResultadosBusqueda, List<Vehiculo> resultadosBusqueda) {
		this.control = controlVistaResultadosBusqueda;
		this.resultadosBusqueda = resultadosBusqueda;
		
		modelo = new ResultadosTableModel(this.resultadosBusqueda);
		tablaResultados.setModel(modelo);
				
		setVisible(true);
	}

	/*
	 * @Autor: Mejía Velázquez José Rodrigo
	 * @Descripción: Clase privada en la cual se establece el módelo de la tabla dónde se muestran los resultados de la
	 * búsqueda solicitada por el cliente.
	 * @Fecha de implementación: 21/01/2022
	 * @Parametro de entrada: NA 
	 * @Valor de retorno: NA
	 */
private class ResultadosTableModel extends AbstractTableModel{
		
		private List<Vehiculo> resultadosBusqueda;
		private List<Boolean> seleccion = new ArrayList<>();

		public ResultadosTableModel(List<Vehiculo> resultadosBusqueda) {
			this.resultadosBusqueda = resultadosBusqueda;
		}
		
		@Override
		public int getRowCount() {
			return resultadosBusqueda.size();
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
				case 2 : title = "SELECCION";
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
				return Boolean.class;
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
			Vehiculo v = resultadosBusqueda.get(rowIndex);
			
			seleccion.add(false);
			Object value = null;
			
			switch(columnIndex) {
			case 0 : {value = new ImageIcon(new ImageIcon(v.getFoto()).getImage().getScaledInstance(180, 90, Image.SCALE_SMOOTH));
					  break;}
			case 1 : {value = v.getModelo();
					  break;}
			case 2 : {value = seleccion.get(rowIndex);
					  break;
					 }
			}
			
			return value;
		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			if(seleccion.get(rowIndex) == false) {
				seleccion.set(rowIndex, true);
				fireTableCellUpdated(rowIndex, 2);
			}else {
				seleccion.set(rowIndex, false);
				fireTableCellUpdated(rowIndex, 2);
			}
			
		}

		@Override
		public void addTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void removeTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub*/
			
		}
	}
}
