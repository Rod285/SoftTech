package mx.uam.ayd.proyecto.datos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Pedido;

public interface PedidoRepository extends CrudRepository <Pedido, Long>{
	
	public List <Pedido> findAll();
	
	public Optional<Pedido> findById(long id);
	
}
