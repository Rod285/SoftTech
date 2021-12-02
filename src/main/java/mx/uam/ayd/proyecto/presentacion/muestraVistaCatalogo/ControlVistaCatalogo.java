package mx.uam.ayd.proyecto.presentacion.muestraVistaCatalogo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 * Módulo de control para la mostrar la vista catálogo
 * 
 * @author BurbujasMaravillosas
 *
 */

@Component
public class ControlVistaCatalogo {
	
	@Autowired
	private VistaCatalogo vistaCatalogo;
	
	/**
	 * Muestra ventana catalogo
	 * 
	 */
	
	public void inicia() {
		vistaCatalogo.muestra(this);
	}

}
