package mx.uam.ayd.proyecto.presentacion.muestraVistaIrAPedido;

/*
 * @Mejía Velázquez José Rodrigo
 * @Descripción: Clase control de la VistaIrAPedido, se encarga de iniciar la historia de ususario y de proveer a la VistaIrAPedido
 * de la listaPedido para mostrar la informacion que contiene.
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;

@Component
@Controller
public class ControlVistaIrAPedido {

	@Autowired
	private VistaIrAPedido ventana;
	
	private List<Vehiculo> listaPedido;
	
	/*
	 * @Autor Mejía Velázquez José Rodrigo
	 * @Descripción: Método que inicia la historia de usuario Ir a Pedido
	 * @Parametros: Lista<Vehiculo>
	 */
	public void inicia(List<Vehiculo> listaPedido) {
		this.listaPedido = listaPedido;
		ventana.muestra(this, listaPedido);
	}

}
