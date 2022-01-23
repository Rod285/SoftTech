package mx.uam.ayd.proyecto.presentacion.añadirContacto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioContacto;
import mx.uam.ayd.proyecto.negocio.modelo.MiembroOperaciones;

/**
 * ControlAñadirContacto
 * Módulo de control para la mostrar la vista añadir contacto 
 * 
 * @author Jonathan Cruz
 * @fechaImplementación  21 de enero de 2022
 */

@Component
public class ControlAñadirContacto {

	MiembroOperaciones oper = null;
	
	@Autowired
	private VistaAñadirContacto vistaAñadirContacto;
	
	@Autowired
	private ServicioContacto servicioContacto;
	
	/**
     * @author Jonathan Cruz
 	 * Método que inicia la segunda parte
 	 * (paso 3) de la historia de usuario 12 
 	 * 
 	 * @param MjembroOperaciones operaciones
 	 * @return  
 	 * @fechaImplementación 21 de enero de 2022
 	 */
	public void inicia(MiembroOperaciones operaciones) {
		this.oper = operaciones;
		vistaAñadirContacto.muestra(this);
	}

	/**
     * @author Jonathan Cruz
 	 * Método que termina la segunda parte
 	 * (paso 3) de la historia de usuario 12 
 	 * 
 	 * @param 
 	 * @return  
 	 * @fechaImplementación 21 de enero de 2022
 	 */
	public void termina() {
		vistaAñadirContacto.setVisible(false);	
	}

	/**
     * @author Jonathan Cruz
 	 * Método para gregar contacto 
 	 * 
 	 * @param Strin nombre, String apellido, Strig telefono
 	 * @return  
 	 * @fechaImplementación 21 de enero de 2022
 	 */
	public void agregaContacto(String nombre, String apellido, String tel) {
		
		try {
			servicioContacto.agregaContacto(nombre, apellido, tel, oper);
			vistaAñadirContacto.muestraDialogoConMensaje("Contacto agregado exitosamente");
			
		} catch(Exception ex) {
			vistaAñadirContacto.muestraDialogoConMensaje("Error al agregar contacto: "+ ex.getMessage());
		}
		
		termina();	
	}
	
}
