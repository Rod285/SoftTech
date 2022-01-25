package mx.uam.ayd.proyecto.presentacion.muestraVistaCatalogo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioPedido;
import mx.uam.ayd.proyecto.negocio.ServicioVehiculo;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;
import mx.uam.ayd.proyecto.presentacion.muestraResultadosBusqueda.ControlVistaResultadosBusqueda;
import mx.uam.ayd.proyecto.presentacion.muestraVistaIrAPedido.ControlVistaIrAPedido;

/**
 * 
 * Módulo de control para la mostrar la vista catálogo
 * 
 * @author BurbujasMaravillosas
 *
 */

@Slf4j
@Component
public class ControlVistaCatalogo {
	
	static final String CLASICO = "Clasico";
	static final String LUXURY = "Lujo";
	static final String CARGA = "Carga";
	static final String DEPORTIVO = "Deportivo";
	private List<Vehiculo> resultadosBusqueda;
	
	@Autowired
	private VistaCatalogo vistaCatalogo;
	
	@Autowired
	private ServicioVehiculo servicioVehiculo;
	
	@Autowired
	private ServicioPedido servicioPedido;
	
	@Autowired
	private ControlVistaIrAPedido controlIrAPedido;
	
	@Autowired
	private ControlVistaResultadosBusqueda controlBusqueda;

	private List<Vehiculo> listaClasicos = new ArrayList<>();
	private List<Vehiculo> listaLuxury = new ArrayList<>();
	private List<Vehiculo> listaCarga = new ArrayList<>();
	private List<Vehiculo> listaDeportivos = new ArrayList<>();

	private List<Vehiculo> listaPedido;
	
	/**
	 * Muestra ventana catalogo
	 * 
	 */
	
	public void inicia() {
		log.info("iniciando VistaCatalogo");
		recuperaVehiculos();
		vistaCatalogo.muestra(this, listaClasicos, listaLuxury, listaCarga, listaDeportivos);
	}
	
	/*
	 * Método que recupera la lista de autos perteneciente a cada categoría
	 */
	public void recuperaVehiculos() {
		
		listaClasicos = servicioVehiculo.recuperaVehiculosPorTipo(CLASICO);
		listaLuxury = servicioVehiculo.recuperaVehiculosPorTipo(LUXURY);
		listaCarga = servicioVehiculo.recuperaVehiculosPorTipo(CARGA);
		listaDeportivos = servicioVehiculo.recuperaVehiculosPorTipo(DEPORTIVO);
	}

	/*
	 * @Autor: Mejía Velázquez José Rodrigo
	 * @Descripción: Método que llama al métod que actualiza el botón "Ir a Pedido", si el vehiculo no se encontraba en
	 * la listaPedido y si un vehículo ya se encuentra en la lista, llama al método que se lo notifica al usuario.
	 * @Parametros: List<Vehiculo>, int
	 */
	public void agregarAPedido(List<Vehiculo> listaVehiculos, int indiceVehiculo) {
		
		listaPedido = servicioPedido.agregarAPedido(listaVehiculos, indiceVehiculo);
		if(listaPedido == null) {
			vistaCatalogo.dialogoVehiculoEnListaDePedido();
		}else {
			vistaCatalogo.actualizaBotonIrAPedido(listaPedido);
		}
	}

	/*
	 *@Autor: Mejía Velázquez José Rodrigo
	 *@Descripción: Método que llama al control de la historia de usuario ir a Pedido y le indica que inicie la historia de usuario
    */
	public void iniciarIrAPedido() {
		controlIrAPedido.inicia(listaPedido);		
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
			vistaCatalogo.muestraDialogoVehiculoNoEncontrado();
		}else {
			for(Vehiculo vehiculo : resultadosBusqueda) {
				log.info("modelo: " + vehiculo.getModelo());
			}
			controlBusqueda.inicia(resultadosBusqueda);
		}
	}
}
