package mx.uam.ayd.proyecto.presentacion.muestraAgenda;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDesktopPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.MiembroOperaciones;
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
	
	@Autowired
	private VistaAgenda vistaAgenda;
	
	@Autowired
	private ServicioContacto servicioContacto;
	
	/**
     * @author Jonathan Cruz
 	 * En este método se obtendrán los contactos
 	 * corresponientes a un miebro de operaciones
 	 * 
 	 * @param Objeto de tipo MiembroOperaciones
 	 * @return  
 	 */
	public void inicia(MiembroOperaciones operaciones) {
		
		List<Contacto> contactos = servicioContacto.recuperaContactos(operaciones);
		List <String> descripciones = new ArrayList<>();
		for(Contacto contacto:contactos){
			descripciones.add(Long.toString(contacto.getId()));
			descripciones.add(contacto.getNombreContacto());
			descripciones.add(contacto.getApellidoContacto());
			descripciones.add(contacto.getTelefono());
		}
		//descripciones.forEach(employee -> System.out.println(employee.toString()));
		vistaAgenda.muestra(this, descripciones);
	} //fin del método inicia
	

}
