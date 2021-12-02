package mx.uam.ayd.proyecto.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.PedidoVehiculo;

public interface PedidoVehiculoRepository extends CrudRepository<PedidoVehiculo, Long>{
	
	/*
	 * Recupera  todps los PedidosVehiculos
	 */
	
	public List <PedidoVehiculo> findAll();
	public List <PedidoVehiculo> findById(int idPedido);
}
