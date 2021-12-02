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
	
	/**
	 * Muestra ventana notificaciones
	 * 
	 */
	public void inicia(JScrollPane spNotificaciones, JButton btnElimina) {
		
		spNotificaciones.setVisible(true);
		spNotificaciones.setEnabled(true);
		btnElimina.setVisible(true);
		btnElimina.setEnabled(true);
	}
	
	public List<Notificacion> muestraNotificaciones() {
		
		return servicioNotificacion.recuperaNotificaciones();
	}
}
