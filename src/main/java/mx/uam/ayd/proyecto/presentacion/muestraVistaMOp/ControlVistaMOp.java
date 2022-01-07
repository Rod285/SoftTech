package mx.uam.ayd.proyecto.presentacion.muestraVistaMOp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



/**
 * 
 * Módulo de control para la mostrar la vista del miembro de operaciones 
 * 
 * @author BurbujasMaravillosas
 *
 */

@Component
public class ControlVistaMOp {
	
	@Autowired
	private VistaMOp vistaOperaciones;
	
	/**
	 * Muestra ventana miembro operaciones
	 * 
	 */
	
	public void inicia() {
		vistaOperaciones.muestra(this);
		
	}

}
