package mx.uam.ayd.proyecto.presentacion.bandejaNotificaciones;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioAdministrador;
import mx.uam.ayd.proyecto.negocio.ServicioNotificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Administrador;
import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

/**
 * 
 * Módulo de control para la vista notificaciones del administrador
 * 
 * @author Jonathan Cruz Ramirez
 *
 */

@Component
public class ControlBandejaNotificaciones {
	
	@Autowired
	ServicioNotificacion servicioNotificacion;
	
	@Autowired
	private VistaBandejaNotificaciones vistaNotificaciones;
	
	@Autowired
	private ControlBandejaNotificaciones controlBandeja;
	
	//@Autowired
	//private VistaBandejaNotificaciones vn;
	
	/**
	 * Muestra ventana notificaciones
	 * 
	 */
	public void inicia(Administrador administrador) {
		Administrador adminlog = administrador;
		List <Notificacion> notificaciones = servicioNotificacion.recuperaNotificaciones(adminlog);
		List <String> descripciones = new ArrayList<>();
		for(Notificacion notificacion:notificaciones) {
			descripciones.add(notificacion.getDescripcion());
			descripciones.add(notificacion.getFecha());
			descripciones.add(notificacion.getHora());
		}
		
		descripciones.forEach(employee -> System.out.println(employee.toString()));
		vistaNotificaciones.muestra(this.controlBandeja,descripciones); 	
	}
	
/*	public List<Notificacion> muestraNotificaciones() {
		
		return servicioNotificacion.recuperaNotificaciones();
	}*/
}
