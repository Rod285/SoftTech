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

import mx.uam.ayd.proyecto.datos.ContactoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Contacto;
import mx.uam.ayd.proyecto.negocio.modelo.MiembroOperaciones;

@ExtendWith(MockitoExtension.class)
class ServicioContactoTest {

	@Mock
	private ContactoRepository contactoRepository;
	
	@InjectMocks
	private ServicioContacto servicioContacto; //Objeto a probar
	
	private MiembroOperaciones miembroOp;
	
	@BeforeEach
	void setUp() {
		//Este método se ejecuta antes de que se ejecute cada método de prueba
		miembroOp = new MiembroOperaciones();
		}
	
	@Test
	void testRecuperaContactos() {
		//ID: prueba 1
		//Objetivo: verificar que los contactos se recuperan correctamente
		//Precondiciones: No existen contactos
		//Valores de entrada: Miembro de operaciones sin contactos registrados
		//Valor esperado: Lista vacia
		
		List <Contacto> contactos = servicioContacto.recuperaContactos(miembroOp);
		
		assertEquals(0, contactos.size(), "Se esperaba una lista vacia");	
		
		//ID: prueba 2
		//Objetivo: verificar que los contactos se recuperan correctamente
		//Precondiciones: Existen un contacto previamente registrado
		//Valores de entrada: Miembro de operaciones con un contacto registrado
		//Valor esperado: Lista no vacia, tiene un elemento
		
		Contacto contactoPrueba = new Contacto();
		contactoPrueba.setNombre("contactoPrueba");
		contactoPrueba.setApellido("Prueba");
		contactoPrueba.setMiembroOp(miembroOp);
		
		List<Contacto> cPrueba = new ArrayList<>();
		cPrueba.add(contactoPrueba);
		
		when(contactoRepository.findBymiembroOp(miembroOp)).thenReturn(cPrueba);
		
		contactos = servicioContacto.recuperaContactos(miembroOp);
		
		assertEquals(1, contactos.size(), "Se esperaba una lista con un elemento");
	}

	@Test
	void testAgregaContacto() {
		
		//ID: Prueba 1
		//Objetivo: verificar que el contacto se agrega correctamente
		//Precondiciones: No existe un contacto con el mismo número
		//Valores de entrada: nombre, apellido y telefono del contacto, y 
		// miembro de operaciones al que le pertenece elcontacto
		//Valor esperado: Contacto creado y agregado exitosamente
		
		String nombre = "Jona";
		String apellido = "Cruz";
		String telefono = "5631174989";
		
		Contacto contacto = servicioContacto.agregaContacto(nombre, apellido, telefono, miembroOp);
		
		//Afirma que un objeto no es nulo
		assertNotNull(contacto,"Contacto no debe ser nulo");
		//Corroborar que se agrega correctamente el numero de teléfono
		assertEquals(telefono, contacto.getTelefono(), "Se esperaba una que coincidieran los numeros de teléfono");
	
		
		//ID: Prueba 2
		//Objetivo: verificar que no se permite agregar dos contactos con el mismo numero de telefono
		//Precondiciones: Existe un contacto con el mismo número
		Contacto contactoPrueba = new Contacto();
		contactoPrueba.setTelefono(telefono);
		contactoPrueba.setMiembroOp(miembroOp);
		//Valores de entrada: nombre, apellido y telefono del contacto, y 
		// miembro de operaciones al que le pertenece elcontacto 
		
		when(contactoRepository.findByTelefono(telefono)).thenReturn(contactoPrueba);
		
		//Valor esperado: IllegalArgumentException
		assertThrows(IllegalArgumentException.class, () -> {
			servicioContacto.agregaContacto(nombre, apellido, telefono, miembroOp);
	  });
	}

}
