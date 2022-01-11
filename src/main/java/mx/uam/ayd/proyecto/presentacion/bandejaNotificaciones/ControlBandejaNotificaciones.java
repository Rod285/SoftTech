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
	
	//@Autowired
	//private VistaBandejaNotificaciones vn;
	
	/**
	 * Muestra ventana notificaciones
	 * 
	 */
	public VistaBandejaNotificaciones inicia() {
		VistaBandejaNotificaciones vn = vistaNotificaciones.muestra(this);
		return vn;
	}
	
	public List<Notificacion> muestraNotificaciones() {
		
		return servicioNotificacion.recuperaNotificaciones();
	}
}
