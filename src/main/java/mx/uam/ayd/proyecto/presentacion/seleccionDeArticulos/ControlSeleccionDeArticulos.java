package mx.uam.ayd.proyecto.presentacion.seleccionDeArticulos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Administrador;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;
import mx.uam.ayd.proyecto.presentacion.muestraVistaCatalogo.ControlVistaCatalogo;

/**
 * 
 * Módulo de control para la historia de usuario Selección de Artículos
 * 
 * @author Fernanda Marcelin Leyva
 *
 */

@Component
public class ControlSeleccionDeArticulos {

	/*@Autowired
	private ServicioPedido servicioPedido;
	
	@Autowired
	private ServicioPedidoVehiculo servicioPedidoVehiculo;
	
	@Autowired
	private VistaSeleccionDeArticulos ventana;
	*/
	
	@Autowired
	private ControlVistaCatalogo controlVistaCatalogo;
	
	@Autowired
	private VistaSeleccionDeArticulos vistaSeleccionDeArticulos;//PREGUNTA, esta es una ventana de la misma vista porque forma parte de la misma HU2 pero se geenra a través de un botoncito "Ir a Pedido", cómo la creo en la vista y cómo hago referencia a ella aquí?
	
	/**
	 * Muestra ventana cliente
	 * 
	 */
	
	public void inicia() {
		
		
		vistaSeleccionDeArticulos.muestra(this); //Debo agregar método muestra en la vista
	}

	public void iniciaVistaCatalogo() {
		controlVistaCatalogo.inicia();
	}
	
	/**
	 * Cuando el usuario desea agregar un producto al pedido y entonces se deben recuperar sus pedidos vigentes para asignar el articulo
	 * 
	 
	
	public List <Pedido> recuperaPedidos(String modelo, long idCliente) {
		
		List<Pedido> pedidos = servicioPedido.recuperaPedidos(modelo,idCliente);
		if (pedidos.isEmpty()) {
			ventana.muestraDialogoConMensaje("Aún no se cuenta con pedidos vigentes");//Debo agregar método muestraDialogo en la vista
		}
		ventana.muestraComboBoxPedidos("Pedidos vigentes: "+pedidos);//Agregar combobox que se despliega en la vista
		return pedidos;
	}
	
	/**
	 * Si el cliente al seleccionar el primer modelo decidió crear un nuevo pedido 
	 * 
	 
	
	public Long nuevoPedido(String modelo, Cliente cliente) {
		
		ventana.muestraDilogoConMensaje("Nuevo Pedido: "+servicioPedido.nuevoPedido(modelo, cliente));
		return servicioPedido.nuevoPedido(modelo, cliente);
		
	}
	
	/**
	 * Si al presentar la combo box con pedidos existentes del usuario se selecciona cualquiera de ellos
	 * 
	 
	public String agregarAPedidoExistente(String modelo, Pedido pedido) {
		return servicioPedido.agregarAPedidoExistente(modelo, pedido);
	}
	
	public void irAPedido() {
		ventanaPedido.muestraVentanaPedido(this);//aquí aún no sabemos cómo ligar una nueva ventana peroi que forma parte de la misma vista
	}
	
	public Boolean incrementaCantidad(int n, long idPedido, String modelo ) {
		 
		return servicioPedidoVehiculo.incrementarCantidad(n, idPedido, modelo);
	 
	}*/
	
}
