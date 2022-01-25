package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.VehiculoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;
import mx.uam.ayd.proyecto.presentacion.muestraResultadosBusqueda.ControlVistaResultadosBusqueda;

@Slf4j
@ExtendWith(MockitoExtension.class)
class ServicioVehiculoTest {

	@Mock
	private VehiculoRepository vehiculoRepository;
	
	@InjectMocks
	private ServicioVehiculo servicioVehiculo;
	
	private Iterable<Vehiculo>listaIterable;
	private ArrayList<Vehiculo>listaPrueba;
	private List<Vehiculo>listaTipo;
	private ArrayList<Vehiculo> listaResultados;
	private ArrayList<Vehiculo> listaPruebaModelo;
	private Vehiculo v1, v2, v3, v4, v5, v6, v7, v8;
	
	@BeforeEach
	void preparaTest() {
		listaIterable = new ArrayList<>();
		listaPrueba = new ArrayList<>();
		listaTipo = new ArrayList<>();
		listaResultados = new ArrayList<>();
		listaPruebaModelo = new ArrayList<>();
				
		v1 = new Vehiculo();
		v1.setTipo("Clasico");
		v1.setModelo("Mustang");
		
		v2 = new Vehiculo();
		v2.setTipo("Lujo");
		v2.setModelo("BMW");
		
		v3 = new Vehiculo();
		v3.setTipo("Carga");
		v3.setModelo("Volteo");
		
		v4 = new Vehiculo();
		v4.setTipo("Deportivo");
		v4.setModelo("Camaro");
		
		v5 = new Vehiculo();
		v5.setTipo("Clasico");
		v5.setModelo("Maverick");
		
		v6 = new Vehiculo();
		v6.setTipo("Lujo");
		v6.setModelo("Audi");
		
		v7 = new Vehiculo();
		v7.setTipo("Carga");
		v7.setModelo("Trailer");
		
		v8 = new Vehiculo();
		v8.setTipo("Deportivo");
		v8.setModelo("Mustang GT500");
		
		listaPrueba.add(v1);
		listaPrueba.add(v2);
		listaPrueba.add(v3);
		listaPrueba.add(v4);
		listaPrueba.add(v5);
		listaPrueba.add(v6);
		listaPrueba.add(v7);
		listaPrueba.add(v8);
		
		listaIterable = listaPrueba;
		
		listaPruebaModelo.add(v5);
	}
	
	@Test
	void testRecuperaVehiculosPorTipo() {
		
		when(vehiculoRepository.findAll()).thenReturn(listaIterable);

		//Caso 1: Recupera una lista vacía
		
		String tipo = "EsteTipoNoEstaDefinido";
		
		listaTipo = servicioVehiculo.recuperaVehiculosPorTipo(tipo);
		
		assertEquals(1, listaTipo.size());
		assertEquals(tipo, listaTipo.get(0).getTipo());
		
		//Caso 2: Recupera una lista cuando se le da como parametro null
		
		tipo = null;
		
		listaTipo = servicioVehiculo.recuperaVehiculosPorTipo(tipo);
		
		assertEquals(1, listaTipo.size());
		assertEquals("nulo", listaTipo.get(0).getTipo());
		
		//Caso 3: Recupera una lista de tipo Clasico
		
		tipo = "Clasico";
		
		listaTipo = servicioVehiculo.recuperaVehiculosPorTipo(tipo);
		
		assertEquals(2, listaTipo.size());
		assertEquals(tipo, listaTipo.get(0).getTipo(), "Tenía que ser Clásico");
		assertEquals(tipo, listaTipo.get(1).getTipo(), "Tenía que ser Clásico");
		
		//Caso 4: Recupera una lista de tipo Lujo
		
		tipo = "Lujo";
				
		listaTipo = servicioVehiculo.recuperaVehiculosPorTipo(tipo);
				
		assertEquals(2, listaTipo.size());
		assertEquals(tipo, listaTipo.get(0).getTipo(), "Tenia que ser Lujo");
		assertEquals(tipo, listaTipo.get(1).getTipo(), "Tenia que ser Lujo");
		
		//Caso 5: Recupera una lista de tipo Carga
		
		tipo = "Carga";
					
		listaTipo = servicioVehiculo.recuperaVehiculosPorTipo(tipo);
						
		assertEquals(2, listaTipo.size());
		assertEquals(tipo, listaTipo.get(0).getTipo(), "Tenía que ser Carga");
		assertEquals(tipo, listaTipo.get(1).getTipo(), "Tenía que ser Carga");
		
		//Caso 6: Recupera una lista de tipo Deportivo
		
		tipo = "Deportivo";
							
		listaTipo = servicioVehiculo.recuperaVehiculosPorTipo(tipo);
								
		assertEquals(2, listaTipo.size());
		assertEquals(tipo, listaTipo.get(0).getTipo(), "Tenía que ser Deportivo");
		assertEquals(tipo, listaTipo.get(1).getTipo(), "Tenía que ser Deportivo");
	}

	@Test
	void testBuscaVehiculosPorModelo() {
		String modelo = "NoDefinido";
		ArrayList<Vehiculo> listaVacia = new ArrayList<>();
		
		when(vehiculoRepository.findByModeloIgnoreCaseContaining(modelo)).thenReturn(listaVacia);
		
		//Caso 1: Recupera lista de resultados vacía
			
		listaResultados = servicioVehiculo.buscaVehiculosPorModelo(modelo);
		
		assertEquals(null, listaResultados, "Debe ser null");
		
		//Caso 2: Se le da un parametro nulo
		
		modelo = null;
				
		listaResultados = servicioVehiculo.buscaVehiculosPorModelo(modelo);
		
		assertEquals(null, listaResultados, "Debe ser null");
		
		//Caso 3: Se recupera un vehiculo por su modelo exacto
		
		modelo = "Maverick";
		
		when(vehiculoRepository.findByModeloIgnoreCaseContaining(modelo)).thenReturn(listaPruebaModelo);
				
		listaResultados = servicioVehiculo.buscaVehiculosPorModelo(modelo);
		
		assertEquals(modelo, listaResultados.get(0).getModelo(), "Debe ser Maverick");
		
	}
}
