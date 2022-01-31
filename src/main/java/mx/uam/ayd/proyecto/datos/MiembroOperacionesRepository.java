package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Administrador;
import mx.uam.ayd.proyecto.negocio.modelo.MiembroOperaciones;

public interface MiembroOperacionesRepository extends CrudRepository <MiembroOperaciones, Long>{
	
	/**
     * @author Jonathan Cruz
 	 * recupera al un miembro de operaciones por su nombre 
 	 * 
 	 * @param nombre
 	 * @return miembro de operaciones 
 	 */
	
	public MiembroOperaciones findByNombre(String nombre);

}
