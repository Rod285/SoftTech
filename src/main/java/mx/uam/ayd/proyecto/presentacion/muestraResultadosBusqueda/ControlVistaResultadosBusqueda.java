/*
 * ControlVistaResultadosBusqueda
 * @Descripción: Esta clase lleva a cabo el control de flujo del sistema de la vista VistaResultadosBusqueda
 * @Autor: Mejía Velázquez José Rodrigo
 * Fecha de implementación: 20/01/2022
 */
package mx.uam.ayd.proyecto.presentacion.muestraResultadosBusqueda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioPedido;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;
import mx.uam.ayd.proyecto.presentacion.muestraVistaCatalogo.ControlVistaCatalogo;
import mx.uam.ayd.proyecto.presentacion.seleccionDeArticulos.ControlSeleccionDeArticulos;

@Slf4j
@Component
@Controller
public class ControlVistaResultadosBusqueda {
	
	@Autowired
	private VistaResultadosBusqueda ventana;
	
	@Autowired
	private ServicioPedido servicioPedido;

	private List<Vehiculo> resultadosBusqueda;

	private List<Vehiculo> listaPedido;

	private ControlVistaCatalogo controlVistaCatalogo;

	/*
	 * @Autor: Mejía Velázquez José Rodrigo
	 * @Descripción: Método que inicia la vista de resultados de busqueda
	 * @Fecha de implementación: 20/01/2022
	 * @Parametro de entrada: List<Vehiculo> resultadosBusqueda 
	 * @Valor de retorno: void
	 */
	public void inicia(ControlVistaCatalogo controlVistaCatalogo, List<Vehiculo> resultadosBusqueda, List<Vehiculo> listaPedido) {
		this.controlVistaCatalogo = controlVistaCatalogo;
		this.resultadosBusqueda = resultadosBusqueda;
		this.listaPedido = listaPedido;
		
		log.info("Iniciando Vista Resultados de Busqueda");
		for(Vehiculo vehiculo: this.resultadosBusqueda) {
			log.info("modelo: " + vehiculo.getModelo());
		}
		
		ventana.muestra(this, this.resultadosBusqueda);	
	}
}
