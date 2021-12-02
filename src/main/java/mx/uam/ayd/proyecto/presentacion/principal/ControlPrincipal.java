package mx.uam.ayd.proyecto.presentacion.principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.agregarUsuario.ControlAgregarUsuario;
import mx.uam.ayd.proyecto.presentacion.listarUsuarios.ControlListarUsuarios;
import mx.uam.ayd.proyecto.presentacion.login.VistaLogin;
import mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador.ControlVistaAdministrador;
import mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador.VistaAdministrador;
import mx.uam.ayd.proyecto.presentacion.notificarSolitudAceptada.ControlnotificarSolicitudAceptada;
import mx.uam.ayd.proyecto.presentacion.notificarSolitudAceptada.VistanotificarSolicitudAceptada;
import mx.uam.ayd.proyecto.presentacion.seleccionDeArticulos.ControlSeleccionDeArticulos;

/**
 * Esta clase lleva el flujo de control de la ventana principal
 * 
 * @author BurbujasMaravillosas
 *
 */
@Component
public class ControlPrincipal {
	
	@Autowired
	private ControlVistaAdministrador controlVistaAdministrador;

	@Autowired
	private ControlAgregarUsuario controlAgregarUsuario;
	
	@Autowired
	private ControlListarUsuarios controlListarUsuarios;

	@Autowired
	private VistaLogin ventana;
	
	@Autowired
	private ControlSeleccionDeArticulos controlSeleccionDeArticulos;
	
	@Autowired
	ControlnotificarSolicitudAceptada controlSolicitudAceptada;
	/*controlSolicitudAceptada.recuperaDisponibilidad();
	VistanotificarSolicitudAceptada.a1Disp = VistaAdministrador.disponibilidad.get(0);*/
	
	/**
	 * Inicia el flujo de control de la ventana principal
	 * 
	 */
	public void inicia() {
		ventana.muestra(this);
	}

	/**
	 * Método que arranca la historia de usuario "agregar usuario"
	 * 
	 */
	public void agregarUsuario() {
		
		controlAgregarUsuario.inicia();
		
	}
	
	/**
	 * Método que arranca la historia de usuario "listar usuarios"
	 * 
	 */
	public void listarUsuarios() {
		controlListarUsuarios.inicia();
	}
	
	/*
	 * Metodo que arranca la vista de administrador
	 */
	
	public void mostrarVistaAdmin() {
		controlVistaAdministrador.inicia();
	}
	
	/*
	 * Metodo que arranca la vista de cliente
	 */
	
	public void mostrarVistaCliente() {
		controlSeleccionDeArticulos.inicia();
	}
	
}
