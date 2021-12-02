package mx.uam.ayd.proyecto.negocio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.VehiculoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;

/*
 * @author Omar Aldaco Montalvo
 */


@Slf4j
@Service
public class ServicioVehiculo {
	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	
	public Optional<Vehiculo> RecuperaDisponibilidad(long idVehiculo) {
		
		/**
		 * Recupera vehiculo a partir del id
		 * 
		 * @return Optional<Vehiculo>
		 */
		
		Optional<Vehiculo> vehiculoRecuperado = vehiculoRepository.findById(idVehiculo);
		return vehiculoRecuperado;
	}

}
