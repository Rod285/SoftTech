package mx.uam.ayd.proyecto.presentacion.notificarSolitudAceptada;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.negocio.ServicioNotificacion;
import mx.uam.ayd.proyecto.negocio.ServicioPedido;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.ServicioVehiculo;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;
import mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador.VistaAdministrador;

/*
 * @author Omar Aldaco Montalvo
 */


@Component
public class ControlnotificarSolicitudAceptada {
	
	@Autowired
	private VistanotificarSolicitudAceptada vistanotificarSolicitudAceptada;
	
	@Autowired
	ServicioVehiculo servicioVehiculo;
	
	@Autowired
	ServicioNotificacion servicioNotificacion;
	
	@Autowired
	ServicioUsuario servicioUsuario;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	/**
	 * Muestra ventana pedidos
	 * 
	 */
	
	public void inicia() {
		vistanotificarSolicitudAceptada.muestra(this);
	}
	
	public void recuperaDisponibilidad(long idVehiculo) {
		
		Optional<Vehiculo> vehiculoRecuperado=servicioVehiculo.RecuperaDisponibilidad(idVehiculo);;
		boolean disponibilidad=false;
		
		if(vehiculoRecuperado.isPresent()) {
			
		Vehiculo vehiculo = vehiculoRecuperado.get(); //:get permite acceder a todos los metodos del tipo
		disponibilidad = vehiculo.isDisponibilidad();
		
		}
	}
	
	/**
	 * Envia notificacion generada
	 * 
	 * @param 
	 * String descripcion, 
	 * String fecha, 
	 * String nombre, 
	 * String tipo
	 * 
	 */
	
	public void enviaNotificacion(String descripcion, String fecha, String nombre, String tipo) {
		
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		cliente.setTipo(tipo);
		clienteRepository.save(cliente);
		
		boolean notificacion = servicioNotificacion.enviaNotificacion(descripcion, fecha, cliente);
		
		if(notificacion) {
			vistanotificarSolicitudAceptada.muestraMensajeAceptacion();
		}
		
	}

	
	/**
	 * Recupera el cliente
	 * 
	 * @param 
	 * long idCliente
	 * 
	 * 
	 */
	
	
	public Usuario recuperaCliente(long idCliente) {
		return servicioUsuario.recuperaCliente(idCliente);
	}
	
	
	/*@Autowired
	private ServicioNotificacion servicioNotificacion;*/
	
	/*public Long enviarNotificacion(Long idPedido, String status, String fecha) {
		return servicioNotificacion.enviarNotificacion(idPedido, status, fecha);
	}*/
}
