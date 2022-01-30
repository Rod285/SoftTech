package mx.uam.ayd.proyecto.presentacion.muestraPedidos;
/*
 * @author Omar Aldaco Montalvo
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioPedido;
import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;

@Component
public class ControlPedidos {
	
	@Autowired
	private ServicioPedido servicioPedido;
	
	@Autowired
	private VistaPedidos vistaPedidos;
	
	@Autowired
	private VistaPedidos vp;
	
	public Pedido damePedido(long id) {
		
		Pedido p = null;
		
		Optional<Pedido> pedidoRecuperado = servicioPedido.recuperaPedido(id);
		if(pedidoRecuperado.isPresent()) {
			p = pedidoRecuperado.get();
			return p;
		}
		return p;
	}
	
	public VistaPedidos inicia(List <Pedido> pedidos)  {
		
		List <String> informacion = new ArrayList<>();
		for(Pedido pedido:pedidos) {
			informacion.add(String.valueOf(pedido.getId()));
			informacion.add(pedido.getCliente().getNombre());
			informacion.add(pedido.getFechaEntrega());
			informacion.add(pedido.getEstado());
		}
		vp =  vistaPedidos.muestra(this, informacion);
		
		return vp;
	}
	
	public List<Pedido> recuperaPedidos() {
		
		return servicioPedido.recuperaPedidos();
	}
	
	public List<Pedido> recuperaPedidosPorFecha(String fecha) {
		
		return servicioPedido.recuperaPedidoPorFecha(fecha);
		
	}

}
