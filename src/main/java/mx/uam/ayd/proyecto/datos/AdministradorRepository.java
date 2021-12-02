package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Administrador;

public interface AdministradorRepository extends CrudRepository <Administrador, Long> {
	
	/*
	 * Recupera un administrador por su nombre
	 */
	
	public Administrador findByNombre(String nombre);
}
