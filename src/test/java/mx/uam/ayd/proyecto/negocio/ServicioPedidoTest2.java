package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.uam.ayd.proyecto.negocio.modelo.Pedido;
import mx.uam.ayd.proyecto.datos.PedidoRepository;

@ExtendWith(MockitoExtension.class)
class ServicioPedidoTest2 {

	@Mock
	private PedidoRepository pedidoRepository;
	
	@InjectMocks
	private ServicioPedido servicioPedido;
	
	@Test
	void testRecuperaPedidos() {
		
		/*
		 * ID: prueba 1
		 * Objetivo: Probar que la recuperación de pedidos funciona correctamente.
		 * Precondiciones: No existen pedidos registrados 
		 * Valor esperado: Lista vacía
		 */
		
		List<Pedido> pedidosRecuperados = servicioPedido.recuperaPedidos();
		
		assertEquals(0, pedidosRecuperados.size(), "Se esperaba una lista vacía");
		
		/*
		 * ID: prueba 2
		 * Objetivo: Probar que la recuperación de pedidos funciona correctamente.
		 * Precondiciones: Existe al menos un pedido registrado
		 * Valor esperado: Lista con elementos
		 */
		
		List<Pedido> pedidos = new ArrayList<Pedido>();
		pedidos.add(new Pedido(1L));
		
		when(pedidoRepository.findAll()).thenReturn(pedidos);
		
		pedidosRecuperados = servicioPedido.recuperaPedidos();
		
		assertEquals(1, pedidosRecuperados.size(), "Se esperaba una lista con elementos");
	}

}
