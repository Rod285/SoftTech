package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.datos.NotificacionRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Administrador;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@Slf4j
@Service


public class ServicioNotificacion {
	
	@Autowired 
	private NotificacionRepository notificacionRepository;
	
		
	/**
	 * 
	 * Guarda las notificaciones generadas
	 * 
	 * @return boolean
	 * 
	 * @param String descripcion, String fecha, String nombre, String tipo
	 */
	
	public boolean enviaNotificacion(String descripcion, String fecha, Cliente cliente) {
			
			Notificacion notificacion = new Notificacion();
			notificacion.setFecha(fecha);
			notificacion.setDescripcion(descripcion);
			notificacion.setCliente(cliente);
			notificacion = notificacionRepository.save(notificacion);
			
			if(notificacion!=null)
				return true;
						
			return false;
			
	}
	/**
	 * 
	 * Recupera todos las notificaciones del administrador
	 *  
	 * @return notificaciones
	 *
	 */
	public List<Notificacion> recuperaNotificaciones(Administrador administrador){
		//System.out.println("Metodo en servicio notifiaciones");
		List <Notificacion> employees = notificacionRepository.findByadministrador(administrador);
		//employees.forEach(employee -> System.out.println(employee.toString()));
		return employees;
	}

}
