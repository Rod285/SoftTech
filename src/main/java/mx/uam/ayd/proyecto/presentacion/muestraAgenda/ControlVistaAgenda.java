package mx.uam.ayd.proyecto.presentacion.muestraAgenda;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.MiembroOperaciones;
import mx.uam.ayd.proyecto.presentacion.añadirContacto.ControlAñadirContacto;
import mx.uam.ayd.proyecto.negocio.ServicioContacto;
import mx.uam.ayd.proyecto.negocio.modelo.Contacto;
/**
 * ControlVistaAgenda 
 * Módulo de control para la vista agenda del miembro de operaciones
 * 
 * @author Jonathan Cruz 
 * @fechaImplementación  20 de enero de 2022 
 */
@Component
public class ControlVistaAgenda {
	
	MiembroOperaciones oper = null;
	
	@Autowired
	private VistaAgenda vistaAgenda;
	
	@Autowired
	private ServicioContacto servicioContacto;
	
	@Autowired
	private ControlAñadirContacto controlAñadirContacto;
	
	/**
     * @author Jonathan Cruz
     * Método que da inicio a la HU-12,
 	 * en este método se obtendrán los contactos
 	 * corresponientes a un miebro de operaciones
 	 * para mostrarlos en la vista correspondiente
 	 * 
 	 * 
 	 * @param MiembroOperaciones operaciones
 	 * @return 
 	 * @fechaImplementacion 20 de enero de 2022 
 	 */
	public void inicia(MiembroOperaciones operaciones) {
		this.oper = operaciones;
		//En ésta lista se alamacenan los contactos recuperados
		List<Contacto> contactos = servicioContacto.recuperaContactos(operaciones); 
		List <String> descripciones = new ArrayList<>();
		for(Contacto contacto:contactos){
			descripciones.add(Long.toString(contacto.getId()));
			descripciones.add(contacto.getNombre());
			descripciones.add(contacto.getApellido());
			descripciones.add(contacto.getTelefono());
		}
		//Muestra la vistaAgenda con los contactos recuperados
		vistaAgenda.muestra(this, descripciones);
	} //fin del método inicia

	/**
     * @author Jonathan Cruz
 	 * Método que arranca la segunda parte
 	 * (paso 3) de la historia de usuario 12 
 	 * 
 	 * @param 
 	 * @return  
 	 * @fechaImplementación 21 de enero de 2022
 	 */
	public void agregarContacto() {
		controlAñadirContacto.inicia(oper);
	}
	
	/**
     * @author Jonathan Cruz
 	 * Método que termina la vista agenda
 	 * 
 	 * @param 
 	 * @return  
 	 * @fechaImplementación 21 de enero de 2022
 	 */
	public void termina() {
		vistaAgenda.setVisible(false);		
	}
	

}
