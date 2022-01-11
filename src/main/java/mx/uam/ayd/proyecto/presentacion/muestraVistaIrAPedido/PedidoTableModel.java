package mx.uam.ayd.proyecto.presentacion.muestraVistaIrAPedido;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.Image;

import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;

public class PedidoTableModel implements TableModel{
	
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
			return JComboBox.class;
		}
		
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Vehiculo v = listaPedido.get(rowIndex);
		//JComboBox<Integer> jCombo = new JComboBox<Integer>();
		
		Object value = null;
		
		switch(columnIndex) {
		case 0 : {value = new ImageIcon(new ImageIcon(v.getFoto()).getImage().getScaledInstance(180, 90, Image.SCALE_SMOOTH));
				  break;}
		case 1 : {value = v.getModelo();
				  break;}
		case 2 : {value = null;
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
