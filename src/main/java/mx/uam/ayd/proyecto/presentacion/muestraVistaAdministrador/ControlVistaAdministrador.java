package mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioAdministrador;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Administrador;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.presentacion.bandejaNotificaciones.ControlBandejaNotificaciones;
import mx.uam.ayd.proyecto.presentacion.bandejaNotificaciones.VistaBandejaNotificaciones;
import mx.uam.ayd.proyecto.presentacion.generarContrapropuesta.ControlGenerarContrapropuesta;
import mx.uam.ayd.proyecto.presentacion.login.ControlVistaLogin;
import mx.uam.ayd.proyecto.presentacion.muestraPedidos.ControlPedidos;
import mx.uam.ayd.proyecto.presentacion.muestraPedidos.VistaPedidos;
import mx.uam.ayd.proyecto.presentacion.muestraVistaCatalogo.ControlVistaCatalogo;
import mx.uam.ayd.proyecto.presentacion.notificarSolitudAceptada.ControlnotificarSolicitudAceptada;
import mx.uam.ayd.proyecto.presentacion.notificarSolitudAceptada.VistanotificarSolicitudAceptada;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;
import mx.uam.ayd.proyecto.presentacion.principal.VentanaPrincipal;

/**
 * 
 * Módulo de control para la mostrar la vista de Administrador
 * 
 * @author BurbujasMaravillosas/Softech
 *
 */

@Component
public class ControlVistaAdministrador {
	
	Administrador admin = null;
	
	@Autowired
	private VistaAdministrador vistaAdministrador;
	
	@Autowired
	private ControlnotificarSolicitudAceptada controlnotificarSolicitudAceptada;
	
	@Autowired
	private ControlGenerarContrapropuesta controlGenerarContrapropuesta;
	
	@Autowired
	private ControlVistaCatalogo controlVistaCatalogo; 
	
	@Autowired
	private ControlBandejaNotificaciones controlBN;
	
	@Autowired
	private ControlPedidos controlPedidos;
	
	@Autowired
	private ServicioAdministrador servicioAd;
	
	@Autowired
	private VistaPedidos vp;
	
	@Autowired
	private VistaBandejaNotificaciones vn;
		
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
     * @author Jonathan Cruz
 	 * recupera el administrador que ingreso en ese momento al sistema
 	 * 
 	 * @param nombre
 	 * @return administrador logueado 
 	 */
	
	public void adminLog(String nombre) {
		admin = servicioAd.recuperaAdministrador(nombre);
		//System.out.println("El usuario es: " + admin.getNombre() +" su tipo es: "+ admin.getTipo()+ " Y su id es: " + admin.getIdUsuario());	
	}
	
	/**
	 * Muestra ventana notificaciones
	 * 
	 */
	
	public VistaBandejaNotificaciones muestraVistaNotificaciones() {
		controlBN.inicia(admin);
		return vn;
	}
	
	public VistaPedidos muestraVistaPedidos() {
		vp = controlPedidos.inicia();
		return vp;
	}

}
