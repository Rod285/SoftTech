package mx.uam.ayd.proyecto.presentacion.muestraVistaCatalogo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.negocio.ServicioPedido;
import mx.uam.ayd.proyecto.negocio.ServicioVehiculo;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;

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
	
	@Autowired
	private VistaCatalogo vistaCatalogo;
	
	@Autowired
	private ServicioVehiculo servicioVehiculo;
	
	@Autowired
	private ServicioPedido servicioPedido;
	
	private List<Vehiculo> listaClasicos = new ArrayList<>();
	private List<Vehiculo> listaLuxury = new ArrayList<>();
	private List<Vehiculo> listaCarga = new ArrayList<>();
	private List<Vehiculo> listaDeportivos = new ArrayList<>();
	
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

	public void agregarAPedido(List<Vehiculo> listaVehiculos, int indiceVehiculo) {
		List<Vehiculo> listaPedido = new ArrayList<>();
		listaPedido = servicioPedido.agregarAPedido(listaVehiculos, indiceVehiculo);
		if(listaPedido == null) {
			vistaCatalogo.dialogoVehiculoEnListaDePedido();
		}else {
			vistaCatalogo.actualizaBotonIrAPedido(listaPedido);
		}
	}
}
