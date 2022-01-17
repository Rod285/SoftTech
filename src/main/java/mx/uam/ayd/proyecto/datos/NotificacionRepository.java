package mx.uam.ayd.proyecto.datos;

import java.util.List; 

/*
 * Repositorio para notificaciones
 */

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Administrador;
import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

public interface NotificacionRepository extends CrudRepository<Notificacion, Long> {
	
	/*
	 * Encuentra notificaciones a partir del administrador
	 */
	public List <Notificacion> findByadministrador(Administrador administrador);
	
}
