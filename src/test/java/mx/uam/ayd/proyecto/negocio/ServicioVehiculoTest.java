package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.uam.ayd.proyecto.datos.VehiculoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;

@ExtendWith(MockitoExtension.class)
class ServicioVehiculoTest {

	@Mock
	private VehiculoRepository vehiculoRepository;
	
	@InjectMocks
	private ServicioVehiculo servicioVehiculo;
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testRecuperaVehiculosPorTipo() {
		
		Iterable<Vehiculo>listaIterable = new ArrayList<>();
		ArrayList<Vehiculo>listaPrueba = new ArrayList<>();
		List<Vehiculo>listaTipo = new ArrayList<>();
		String tipo = "Deportivos";
		
		Vehiculo v1 = new Vehiculo();
		v1.setTipo("Clasico");
		
		Vehiculo v2 = new Vehiculo();
		v2.setTipo("Lujo");
		
		Vehiculo v3 = new Vehiculo();
		v3.setTipo("Carga");
		
		Vehiculo v4 = new Vehiculo();
		v4.setTipo("Deportivo");
		
		Vehiculo v5 = new Vehiculo();
		v5.setTipo("Clasico");
		
		Vehiculo v6 = new Vehiculo();
		v6.setTipo("Lujo");
		
		Vehiculo v7 = new Vehiculo();
		v7.setTipo("Carga");
		
		Vehiculo v8 = new Vehiculo();
		v8.setTipo("Deportivo");
		
		listaPrueba.add(v1);
		listaPrueba.add(v2);
		listaPrueba.add(v3);
		listaPrueba.add(v4);
		listaPrueba.add(v5);
		listaPrueba.add(v6);
		listaPrueba.add(v7);
		listaPrueba.add(v8);
		
		listaIterable = listaPrueba;
		
		when(vehiculoRepository.findAll()).thenReturn(listaIterable);

		//Caso 1: Recupera una lista vacía
		
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
		assertEquals(tipo, listaTipo.get(0).getTipo(), listaTipo.get(1).getTipo());
		
		//Caso 4: Recupera una lista de tipo Lujo
		
		tipo = "Lujo";
				
		listaTipo = servicioVehiculo.recuperaVehiculosPorTipo(tipo);
				
		assertEquals(2, listaTipo.size());
		assertEquals(tipo, listaTipo.get(0).getTipo(), listaTipo.get(1).getTipo());
		
		//Caso 5: Recupera una lista de tipo Carga
		
		tipo = "Carga";
					
		listaTipo = servicioVehiculo.recuperaVehiculosPorTipo(tipo);
						
		assertEquals(2, listaTipo.size());
		assertEquals(tipo, listaTipo.get(0).getTipo(), listaTipo.get(1).getTipo());
		
		//Caso 6: Recupera una lista de tipo Deportivo
		
		tipo = "Deportivo";
							
		listaTipo = servicioVehiculo.recuperaVehiculosPorTipo(tipo);
								
		assertEquals(2, listaTipo.size());
		assertEquals(tipo, listaTipo.get(0).getTipo(), listaTipo.get(1).getTipo());
	}

}
