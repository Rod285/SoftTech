package mx.uam.ayd.proyecto.datos;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;

public interface VehiculoRepository extends CrudRepository <Vehiculo, Long> {
	
	/*
	 * Recupera los vehículos por modelo
	 */
	
	public Optional<Vehiculo> findByModelo(String modelo);
}
