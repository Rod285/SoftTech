package mx.uam.ayd.proyecto.presentacion.muestraPedidos;

/*
 * @Nombre: ControlPedidos
 * @Descripción: Contiene los métodos que utiliza la VistaPedidos y realiza la comunicación con el ServicioPedidos
 * * @Autor: Aldaco Montalvo Omar
 * @Fecha de implementación: 30/01/2022
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
	
	/*
	 * @Autor: Aldaco Montalvo Omar
	 * @Descripción: Método que inicia la vista pedidos con la información solicitada por el administrador
	 * @Fecha de implementación: 30/01/2022
	 * @Parametro de entrada: List <Pedido> pedidos
	 * @Valor de retorno: VistaPedidos
	 */
	
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
	
	/*
	 * @Autor: Aldaco Montalvo Omar
	 * @Descripción: Método que recupera todos los pedidos
	 * @Fecha de implementación: 30/01/2022
	 * @Parametro de entrada: 
	 * @Valor de retorno: List <Pedido> pedidos
	 */
	
	public List<Pedido> recuperaPedidos() {
		
		return servicioPedido.recuperaPedidos();
	}
	
	/*
	 * @Autor: Aldaco Montalvo Omar
	 * @Descripción: Método que recupera los pedidos por fecha
	 * @Fecha de implementación: 30/01/2022
	 * @Parametro de entrada: 
	 * @Valor de retorno: List <Pedido> pedidos
	 */
	
	public List<Pedido> recuperaPedidosPorFecha(String fecha) {
		
		return servicioPedido.recuperaPedidoPorFecha(fecha);
		
	}
	
	/*
	 * @Autor: Aldaco Montalvo Omar
	 * @Descripción: Método que recupera los pedidos por cliente
	 * @Fecha de implementación: 30/01/2022
	 * @Parametro de entrada: 
	 * @Valor de retorno: List <Pedido> pedidos
	 */
	
	public List<Pedido> recuperaPedidosPorCliente(String cliente) {
		
		return servicioPedido.recuperaPedidoPorCliente(cliente);
		
	}

}
