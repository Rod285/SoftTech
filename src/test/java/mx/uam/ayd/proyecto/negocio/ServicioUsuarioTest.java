package mx.uam.ayd.proyecto.negocio;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.uam.ayd.proyecto.datos.GrupoRepository;
import mx.uam.ayd.proyecto.datos.UsuarioRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Administrador;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;

@ExtendWith(MockitoExtension.class)
class ServicioUsuarioTest {
	
	@Mock
	private UsuarioRepository usuarioRepository;

	@InjectMocks
	private ServicioUsuario servicioUsuario;
		
	@Test
	void testValidaUsuario() {
				
		//Caso 1:  el usuario es inexistente y no permite el login")
        Boolean resultado =	servicioUsuario.validaUsuario("hola","pass","Cliente");
		
		assertEquals(false,resultado);		
		
		
		//Caso 2: el usuario es existente y permite el login
	 
		Administrador adminPrueba = new Administrador();
		adminPrueba.setNombre("adprueba");
		adminPrueba.setContrasenia("passprueba");
		adminPrueba.setTipo("Administrador");
		usuarioRepository.save(adminPrueba);
		
		when(usuarioRepository.findByNombreAndTipo(adminPrueba.getNombre(), adminPrueba.getTipo())).thenReturn(adminPrueba);

	    resultado =	servicioUsuario.validaUsuario("adprueba","passprueba","Administrador");
		
		assertEquals(true,resultado);
		
	}

	

}
