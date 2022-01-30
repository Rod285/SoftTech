package mx.uam.ayd.proyecto.presentacion.seleccionDeArticulos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioVehiculo;
import mx.uam.ayd.proyecto.negocio.modelo.Administrador;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;
import mx.uam.ayd.proyecto.presentacion.muestraResultadosBusqueda.ControlVistaResultadosBusqueda;
import mx.uam.ayd.proyecto.presentacion.muestraVistaCatalogo.ControlVistaCatalogo;

/**
 * ControlSeleccionDeArticulos 
 * Módulo de control para la historia de usuario Selección de Artículos
 * 
 * @author Mejía Velázquez José Rodrigo
 * @Fecha de implementación: 21/01/2022
 *
 */
@Slf4j
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
	
	@Autowired
	private ServicioVehiculo servicioVehiculo;
	
	@Autowired
	private ControlVistaResultadosBusqueda controlBusqueda;

	private List<Vehiculo> resultadosBusqueda;

	private List<Vehiculo> listaPedido;
	
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

	/*
	 * @Autor: Mejía Velázquez José Rodrigo
	 * @Descripción: Método que llama al servicio vehiculo para que inicie la busqueda del modelo de vehículo
	 * que el usuario desea, al encontrar el vehiculo, inicia la vista de resultados, si no lo encuentra,
	 * le informa al usuario que no ha sido posible encontrar el vehículo que busca, que intente con otro modelo.
	 * @Fecha de implementación: 21/01/2022
	 * @Parametro de entrada: String modeloVehiculo
	 * @Valor de retorno: void
	 */
	public void iniciaBusqueda(String modeloVehiculo) {
		resultadosBusqueda = servicioVehiculo.buscaVehiculosPorModelo(modeloVehiculo);
		
		if(resultadosBusqueda == null) {
			vistaSeleccionDeArticulos.muestraDialogoVehiculoNoEncontrado();
		}else {
			for(Vehiculo vehiculo : resultadosBusqueda) {
				log.info("modelo: " + vehiculo.getModelo());
			}
			controlBusqueda.inicia(controlVistaCatalogo, resultadosBusqueda, listaPedido);
		}
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
