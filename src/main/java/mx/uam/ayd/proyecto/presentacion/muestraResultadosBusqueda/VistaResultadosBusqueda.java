/*
 * VistaResultadosBusqueda
 * Esta clase lleva a cabo es la vista del sistema que muestra los resultados de buscar un vehiculo por su modelo.
 * Fecha de implementación: 20/01/2022
 */
package mx.uam.ayd.proyecto.presentacion.muestraResultadosBusqueda;

import java.util.List;

import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;

@Component
public class VistaResultadosBusqueda extends JFrame{
	
	private ControlVistaResultadosBusqueda control;
	private List<Vehiculo> resultadosBusqueda;

	public VistaResultadosBusqueda() {
		setBounds(200,5,600,725);
	}
	public void muestra(ControlVistaResultadosBusqueda controlVistaResultadosBusqueda, List<Vehiculo> resultadosBusqueda) {
		this.control = controlVistaResultadosBusqueda;
		this.resultadosBusqueda = resultadosBusqueda;
		
		setVisible(true);
	}

	
}
