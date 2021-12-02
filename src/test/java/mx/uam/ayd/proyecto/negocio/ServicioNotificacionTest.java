package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;

class ServicioNotificacionTest {
	
	@Mock
	private ClienteRepository clienteRepository;

	//@Autowired
	
	@InjectMocks
	private ServicioNotificacion servicioNotificacion;

	@Test
	void testEnviaNotificacion() {
		
		//Caso 1: Corroborar que regresa true generada al pasar los datos correctos
		
		
		String descripcion = "Pedido aceptado";
		String fecha = "27/10/21";
		String nombre = "Omar";
		String tipo = "Administrador";
		
		Cliente cliente = new Cliente();
		cliente.setNombre(nombre);
		cliente.setTipo(tipo);
		clienteRepository.save(cliente);
		
		boolean resultado = servicioNotificacion.enviaNotificacion(descripcion, fecha, cliente);
		
		assertEquals(true, resultado);
		
		
		//Caso 2: Corroborar que regresa false generada al pasar los datos correctos
		
		
		descripcion = "Necesita modificaciones";
				
		resultado = servicioNotificacion.enviaNotificacion(descripcion, fecha, cliente);
				
		assertEquals(false, resultado);
		
		
		//Caso 3: Corroborar que regresa false generada al pasar los datos incorrectos
		
		String desc="Pedido aceptado";
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			servicioNotificacion.enviaNotificacion(desc, fecha, null);
		});
	
	}

}
