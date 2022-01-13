package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;

@ExtendWith(MockitoExtension.class)
class ServicioPedidoTest {
	
	@InjectMocks
	private ServicioPedido servicioPedido;

	@Test
	void testAgregarAPedido() {
		
		List<Vehiculo> listaPrueba = new ArrayList<>();
		List<Vehiculo> listaPedidoPrueba = new ArrayList<>();
		
		Vehiculo v1 = new Vehiculo();
		v1.setTipo("Clasico");
		
		Vehiculo v2 = new Vehiculo();
		v2.setTipo("Lujo");
		
		//Caso 1: Agregar vehiculos distintos a la lista
		
		listaPrueba.add(v1);
		listaPrueba.add(v2);
				
		int indiceLista = 0;
		
		listaPedidoPrueba = servicioPedido.agregarAPedido(listaPrueba, indiceLista);
		
		indiceLista = 1;
		
		listaPedidoPrueba = servicioPedido.agregarAPedido(listaPrueba, indiceLista);
		
		assertEquals(2, listaPedidoPrueba.size());
		
		//Caso 2: Intentar agregar un vehiculo repetido a la lista
		
		indiceLista = 0;
		
		listaPedidoPrueba = servicioPedido.agregarAPedido(listaPrueba, indiceLista);
		
		assertEquals(null, listaPedidoPrueba);
		
	}

}
