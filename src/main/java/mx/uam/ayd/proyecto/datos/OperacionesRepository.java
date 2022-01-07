package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.MiembroOperaciones;

public interface OperacionesRepository extends CrudRepository<MiembroOperaciones, Long> {

}
