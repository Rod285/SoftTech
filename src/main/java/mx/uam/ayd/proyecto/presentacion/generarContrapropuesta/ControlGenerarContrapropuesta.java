package mx.uam.ayd.proyecto.presentacion.generarContrapropuesta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.negocio.ServicioNotificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;

/*
 * @author Omar Aldaco Montalvo
 */

@Component
public class ControlGenerarContrapropuesta {
	
	@Autowired
	private VistaGenerarContrapropuesta vistGenerarContrapropuesta;
	
	@Autowired
	ServicioNotificacion servicioNotificacion;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void inicia() {
		vistGenerarContrapropuesta.muestra(this);
	}
	
	public void enviaNotificacion(String descripcion, String fecha, String nombre, String tipo) {
		
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		cliente.setTipo(tipo);
		clienteRepository.save(cliente);
		
		boolean notificacion = servicioNotificacion.enviaNotificacion(descripcion, fecha, cliente);
		
		if(notificacion) {
			vistGenerarContrapropuesta.muestraMensajeModificacion();
		}
		
	}

}
