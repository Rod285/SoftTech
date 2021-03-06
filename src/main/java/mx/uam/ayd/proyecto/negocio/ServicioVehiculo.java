package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
	
	private List<Vehiculo> listaVehiculos = new ArrayList<>();
	
	public Optional<Vehiculo> RecuperaDisponibilidad(long idVehiculo) {
		
		/**
		 * Recupera vehiculo a partir del id
		 * 
		 * @return Optional<Vehiculo>
		 */
		
		Optional<Vehiculo> vehiculoRecuperado = vehiculoRepository.findById(idVehiculo);
		return vehiculoRecuperado;
	}
	

	/*
	 * Método que recupera la lista de todos los vehiculos y a partir de ésta recupera los vehiculos del tipo seleccionado,
	 * el método verifica si hay vehiculos en la lista y si no es así envía un vehiculoNulo para su despliegue en pantalla.
	 * @Parametro String tipo
	 * @Return List<Vehiculo> listaTipo
	 */
	public List<Vehiculo> recuperaVehiculosPorTipo(String tipo) {
		Iterable<Vehiculo> listaIterable = new ArrayList<>();
		List<Vehiculo> listaTipo = new ArrayList<>();
		if(tipo == null) {
			tipo = "nulo";
		}
		//Se lleva a cabo la recuperación de la lista de vehículos, solo si ésta no se ha recuperado antes
		if(listaVehiculos.size() == 0) {
			log.info("Recuperando todos los autos");
			listaIterable = vehiculoRepository.findAll();
			
			//Se trasladan los vehiculos de la lista Iterable a un ArrayList
			for(Vehiculo vehiculo : listaIterable) {
				listaVehiculos.add(vehiculo);
			}
		}
		
		//Agrega a los vehiculos del tipo solicitado a una lista de dicho tipo
		for(Vehiculo vehiculo : listaVehiculos) {
			if(vehiculo.getTipo().equals(tipo)) {
				listaTipo.add(vehiculo);
			}
		}
		
		//Si no existen vehiculos del tipo solicitado, crea el vehiculoNulo que será enviado para el despliegue en pantalla
		if(listaTipo.size() == 0) {
			log.info("no hay vehiculos del tipo: " + tipo);
			Vehiculo vehiculoNulo = new Vehiculo();
			vehiculoNulo.setModelo("Error vehiculos no encontrados");
			vehiculoNulo.setTipo(tipo);
			listaTipo.add(vehiculoNulo);
		}
		return listaTipo;
	}

	/*
	 * @Autor: Mejía Velázquez José Rodrigo
	 * @Descripción: Método que realiza el llamado del vehiculoRepository para que lleve a cabo la busqueda
	 * de los vehiculos con el modelo proporcionado por el usuario
	 * @Fecha de implementación: 20/01/2022
	 * @Parametro de entrada: String modeloVehiculo 
	 * @Valor de retorno: List<Vehiculo> resultadosBusqueda si encuentra vehiculos con el modelo dado,
	 * null si no encuentra ningún vehículo con dicho modelo
	 */
	public ArrayList<Vehiculo> buscaVehiculosPorModelo(String modeloVehiculo) {
		ArrayList<Vehiculo> resultadosBusqueda = new ArrayList<>();
		if(modeloVehiculo != null) {
			for(Vehiculo vehiculo : vehiculoRepository.findByModeloIgnoreCaseContaining(modeloVehiculo)) {
				resultadosBusqueda.add(vehiculo);
			}
			
			log.info("tamaño resultados " + resultadosBusqueda.size());
			
			boolean bandera = validaResultadosnoVacios(resultadosBusqueda);
			log.info("" + bandera);
			
			if(bandera == true) {
				return resultadosBusqueda;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}

	/*
	 * @Autor: Mejía Velázquez José Rodrigo
	 * @Descripción: Método que valida si se encontraron vehiculos con el modelo solicitado
	 * @Fecha de implementación: 20/01/2022
	 * @Parametro de entrada: List<Vehiculo> resultadosBusqueda 
	 * @Valor de retorno: Boolean, true si se encontraron vehiculos con el modelo requerido
	 * false si no encontró ningún vehiculo con el modelo solicitado.
	 */
	private boolean validaResultadosnoVacios(List<Vehiculo> resultadosBusqueda) {
		if(resultadosBusqueda.size() != 0) {
			return true;
		}
		return false;
	}

}
