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
	
	private Iterable<Vehiculo>listaIterable;
	private ArrayList<Vehiculo>listaPrueba;
	private List<Vehiculo>listaTipo;
	private ArrayList<Vehiculo> listaResultados;
	private ArrayList<Vehiculo> listaPruebaModelo;
	private Vehiculo v1, v2, v3, v4, v5, v6, v7, v8;
	
	/*
	 * @Autor: Mejía Velázquez José Rodrigo
	 * @Descripción: Preparación para las pruebas
	 * @Fecha de implementación: 24/01/2022
	 * @Parametros de entrada: ninguno
	 * @Valor de retorno: void
	 */
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
	}
	
	@Test
	void testRecuperaVehiculosPorTipo() {
		
		when(vehiculoRepository.findAll()).thenReturn(listaIterable);
		
		/*
		 * ID: Prueba 1
		 * Objetivo: Probar que la recuperación de vehiculos por tipo funciona correctamente
		 * Precondiciones: Existen vehiculos registrados, pero se busca un tipo de vehiculo no definido.
		 * Valor esperado: Una lista vacía. 
		 */
		
		String tipo = "EsteTipoNoEstaDefinido";
		
		listaTipo = servicioVehiculo.recuperaVehiculosPorTipo(tipo);
		
		assertEquals(1, listaTipo.size());
		assertEquals(tipo, listaTipo.get(0).getTipo());
		
		/*
		 * ID: Prueba 2
		 * Objetivo: Probar que la recuperación de vehiculos por tipo funciona correctamente
		 * Precondiciones: Existen vehiculos registrados, se introduce null como tipo.
		 * Valor esperado: Una lista vacía. 
		 */
		
		tipo = null;
		
		listaTipo = servicioVehiculo.recuperaVehiculosPorTipo(tipo);
		
		assertEquals(1, listaTipo.size());
		assertEquals("nulo", listaTipo.get(0).getTipo());
		
		/*
		 * ID: Prueba 3
		 * Objetivo: Probar que la recuperación de vehiculos por tipo funciona correctamente
		 * Precondiciones: Existen vehiculos registrados, el tipo de busqueda es Clasico.
		 * Valor esperado: Una lista con dos elementos, ambos del tipo Clasico.
		 */
		
		tipo = "Clasico";
		
		listaTipo = servicioVehiculo.recuperaVehiculosPorTipo(tipo);
		
		assertEquals(2, listaTipo.size());
		assertEquals(tipo, listaTipo.get(0).getTipo(), "Tenía que ser Clásico");
		assertEquals(tipo, listaTipo.get(1).getTipo(), "Tenía que ser Clásico");
		
		/*
		 * ID: Prueba 4
		 * Objetivo: Probar que la recuperación de vehiculos por tipo funciona correctamente
		 * Precondiciones: Existen vehiculos registrados, el tipo de busqueda es Lujo.
		 * Valor esperado: Una lista con dos elementos, ambos del tipo Lujo.
		 */
		
		tipo = "Lujo";
				
		listaTipo = servicioVehiculo.recuperaVehiculosPorTipo(tipo);
				
		assertEquals(2, listaTipo.size());
		assertEquals(tipo, listaTipo.get(0).getTipo(), "Tenia que ser Lujo");
		assertEquals(tipo, listaTipo.get(1).getTipo(), "Tenia que ser Lujo");
		
		/*
		 * ID: Prueba 5
		 * Objetivo: Probar que la recuperación de vehiculos por tipo funciona correctamente
		 * Precondiciones: Existen vehiculos registrados, el tipo de busqueda es Carga.
		 * Valor esperado: Una lista con dos elementos, ambos del tipo Carga.
		 */
		
		tipo = "Carga";
					
		listaTipo = servicioVehiculo.recuperaVehiculosPorTipo(tipo);
						
		assertEquals(2, listaTipo.size());
		assertEquals(tipo, listaTipo.get(0).getTipo(), "Tenía que ser Carga");
		assertEquals(tipo, listaTipo.get(1).getTipo(), "Tenía que ser Carga");
		
		/*
		 * ID: Prueba 6
		 * Objetivo: Probar que la recuperación de vehiculos por tipo funciona correctamente
		 * Precondiciones: Existen vehiculos registrados, el tipo de busqueda es Deportivo.
		 * Valor esperado: Una lista con dos elementos, ambos del tipo Deportivo.
		 */
		
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
		
		/*
		 * ID: Prueba 1
		 * Objetivo: Probar que la busqueda de vehiculos por modelo funciona correctamente
		 * Precondiciones: No existen vehiculos registrados, el modelo de busqueda es NoDefinido.
		 * Valor esperado: null.
		 */
			
		listaResultados = servicioVehiculo.buscaVehiculosPorModelo(modelo);
		
		assertEquals(null, listaResultados, "Debe ser null");
		
		/*
		 * ID: Prueba 2
		 * Objetivo: Probar que la busqueda de vehiculos por modelo funciona correctamente
		 * Precondiciones: No existen vehiculos registrados, modelo es igual a null.
		 * Valor esperado: null.
		 */
		
		modelo = null;
				
		listaResultados = servicioVehiculo.buscaVehiculosPorModelo(modelo);
		
		assertEquals(null, listaResultados, "Debe ser null");
		
		/*
		 * ID: Prueba 3
		 * Objetivo: Probar que la busqueda de vehiculos por tipo funciona correctamente
		 * Precondiciones: Existen vehiculos registrados, el modelo de busqueda es Maverick.
		 * Valor esperado: Una lista con un elemento modelo Maverick.
		 */
		
		modelo = "Maverick";
		
		listaPruebaModelo.add(v5);
		
		when(vehiculoRepository.findByModeloIgnoreCaseContaining(modelo)).thenReturn(listaPruebaModelo);
				
		listaResultados = servicioVehiculo.buscaVehiculosPorModelo(modelo);
		
		assertEquals(modelo, listaResultados.get(0).getModelo(), "Debe ser Maverick");
		
		/*
		 * ID: Prueba 4
		 * Objetivo: Probar que la busqueda de vehiculos por tipo funciona correctamente
		 * Precondiciones: Existen vehiculos registrados, el modelo de busqueda es parcial Mav.
		 * Valor esperado: Una lista con un elemento modelo Maverick.
		 */
		
		modelo = "Mav";
		
		listaPruebaModelo = new ArrayList<>();
		listaPruebaModelo.add(v5);
		
		when(vehiculoRepository.findByModeloIgnoreCaseContaining(modelo)).thenReturn(listaPruebaModelo);
				
		listaResultados = servicioVehiculo.buscaVehiculosPorModelo(modelo);
		
		assertEquals(true, listaResultados.get(0).getModelo().contains(modelo), "Debe ser Maverick");
		
		/*
		 * ID: Prueba 5
		 * Objetivo: Probar que la busqueda de vehiculos por tipo funciona correctamente
		 * Precondiciones: Existen 2 vehiculos registrados cuyo modelo incluye Mustang, el modelo de busqueda es Mustang.
		 * Valor esperado: Una lista con 2 vehiculos de modelo Mustang.
		 */
		//caso 5: Se recupera más de un vehiculo con modelo parecido
		
		modelo = "Mustang";
		
		listaPruebaModelo = new ArrayList<>();
		listaPruebaModelo.add(v1);
		listaPruebaModelo.add(v8);
		
		when(vehiculoRepository.findByModeloIgnoreCaseContaining(modelo)).thenReturn(listaPruebaModelo);
				
		listaResultados = servicioVehiculo.buscaVehiculosPorModelo(modelo);
		
		assertEquals(true, listaResultados.get(0).getModelo().contains(modelo), "No contiene Mustang");
		assertEquals(true, listaResultados.get(1).getModelo().contains(modelo), "No contiene Mustang");
	}
}
