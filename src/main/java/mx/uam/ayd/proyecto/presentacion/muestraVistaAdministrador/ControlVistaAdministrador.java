package mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.bandejaNotificaciones.ControlBandejaNotificaciones;
import mx.uam.ayd.proyecto.presentacion.generarContrapropuesta.ControlGenerarContrapropuesta;
import mx.uam.ayd.proyecto.presentacion.login.ControlVistaLogin;
import mx.uam.ayd.proyecto.presentacion.muestraVistaCatalogo.ControlVistaCatalogo;
import mx.uam.ayd.proyecto.presentacion.notificarSolitudAceptada.ControlnotificarSolicitudAceptada;
import mx.uam.ayd.proyecto.presentacion.notificarSolitudAceptada.VistanotificarSolicitudAceptada;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;
import mx.uam.ayd.proyecto.presentacion.principal.VentanaPrincipal;

/**
 * 
 * Módulo de control para la mostrar la vista de Administrador
 * 
 * @author BurbujasMaravillosas
 *
 */

@Component
public class ControlVistaAdministrador {
	
	@Autowired
	private VistaAdministrador vistaAdministrador;
	
	@Autowired
	private ControlnotificarSolicitudAceptada controlnotificarSolicitudAceptada;
	
	@Autowired
	private ControlGenerarContrapropuesta controlGenerarContrapropuesta;
	
	@Autowired
	private ControlVistaCatalogo controlVistaCatalogo; 
	
	@Autowired
	private ControlBandejaNotificaciones controlBandejaNotificaciones;
		
	/**
	 * Muestra ventana Administrador
	 * 
	 */
	
	public void inicia() {
		vistaAdministrador.muestra(this);
		
	}
	
	
	/**
	 * Muestra vista proyectos
	 * 
	 */
	
	public void muestraVistaSolicitudAceptada() {
		controlnotificarSolicitudAceptada.inicia();
	}
	
	/**
	 * Muestra vista contrapropuesta
	 * 
	 */
	
	public void muestraVistaGenerarContrapropuesta() {
		controlGenerarContrapropuesta.inicia();
	}
	
	/**
	 * Muestra vista catalogo
	 * 
	 */
	
	public void muestraVistaCatalogo() {
		controlVistaCatalogo.inicia();
	}
	
	/**
	 * Muestra ventana notificaciones
	 * 
	 */
	
	public void muestraVistaNotificaciones(JScrollPane spNotificaciones, JButton btnElimina) {
		controlBandejaNotificaciones.inicia(spNotificaciones, btnElimina);
	}

}
