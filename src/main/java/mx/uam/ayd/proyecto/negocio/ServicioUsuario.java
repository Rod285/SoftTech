package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.GrupoRepository;
import mx.uam.ayd.proyecto.datos.UsuarioRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.presentacion.login.VistaLogin;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;

/*
 * @author Omar Aldaco Montalvo
 */


@Slf4j
@Service
public class ServicioUsuario {
	
	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	@Autowired
	private ControlPrincipal control;
	
	/**
	 * 
	 * Permite agregar un usuario
	 * 
	 * @param nombre
	 * @param apellido
	 * @param telefono
	 * @param correo
	 * @param contrasenia
	 * @param grupo
	 * @return
	 */
	//METODO QUE AGREGA USUARIO

	
public Usuario agregaUsuario(String nombre, String apellido, String edad, String telefono, String correo, String contrasenia, String nombreGrupo) {
		
		//BUSCA AL USUARIO QUE SE QUIERE AGREGAR EN LA BASE DE DATOS
		Usuario usuario = usuarioRepository.findByNombreAndApellido(nombre, apellido);
		
		//SI EXISTE MANDA MENSAJE QUE YA EXISTE
		if(usuario != null) {
			throw new IllegalArgumentException("Ese usuario ya existe");
		}//FIN DEL IF
		
		//BUSCA AL GRUPO EN EL REPOSITORY
		Grupo grupo = grupoRepository.findByNombre(nombreGrupo);
		
		//SI NO EXISTE MANDA MENSAJE QUE NO SE ENCONTRO
		if(grupo == null) {
			throw new IllegalArgumentException("No se encontró el grupo");
		}//FIN DEL IF
		
		//SI EL USUARIO NO EXISTE Y EL GRUPO EXISTE COMIENZA AGREGAR LOS DATOS QUE ESCRIBIO DEL USUARIO
		log.info("Agregando usuario nombre: "+nombre+" apellido:"+apellido);
		
		usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEdad(edad);
		usuario.setTelefono(telefono);
		usuario.setCorreo(correo);
		usuario.setContrasenia(contrasenia);
			
		//GUARDA AL USUARIO EN LA BASE DE DATOS
		usuarioRepository.save(usuario);
		
		//AGREGA AL USUARIO AL GRUPO
		grupo.addUsuario(usuario);
		
		//GRUARDA EL GRUPO EN LA BASE DE DATOS
		grupoRepository.save(grupo);
		
		return usuario;//REGRESA AL USUARIO
		
	}

	/**
	 * Recupera todos los usuarios existentes
	 * 
	 * @return Una lista con los usuarios (o lista vacía)
	 */
	
	//METODO QUE REGRESA A LOS USUARIOS EXISTENTES
	public List <Usuario> recuperaUsuarios() {

		System.out.println("usuarioRepository = "+usuarioRepository);
		
		List <Usuario> usuarios = new ArrayList<>();
		
		for(Usuario usuario:usuarioRepository.findAll()) {
			usuarios.add(usuario);
		}
				
		return usuarios;
	}//FIN DEL METODO QUE REGRESA LOS USUARIOS EXISTENTES
	
	//METODO QUE VERIFICA SI EL NOMBRE Y APELLIDO YA EXISTEN EN LA BASE DE DATOS
     public Usuario Recupera(String nombre, String apellido) {
		
		// Regla de negocio: No se permite agregar dos usuarios con el mismo nombre y apellido
		
		Usuario usuariorecu = usuarioRepository.findByNombreAndApellido(nombre, apellido);//REVISA EN EL REPOSITORIO SI YA EXISTE EL USUARIO 
		
		//SI USUARIO ES NULL PERMITE CONTINUAR CON EL REGISTRO 
		if(usuariorecu==null) {
			System.out.println("null");
			//throw new IllegalArgumentException("ok");
		}//FIN DEL IF
		
		//SI EL USUARIO ES DIFERENTE DE NULL Y YA EXISTE EN EL REPOSITORIO MANDA MENSAJE QUE YA EXISTE 
		if(usuariorecu != null) {
			System.out.println("Usuario ya existe");
			throw new IllegalArgumentException("Ese usuario ya existe");
		}//FIN DEL IF 

		return usuariorecu;//REGRESA AL USUARIO

	}//FIN DEL METODO DE VERIFICACION 
     
     /**
      * @author Jonathan Cruz
  	 * recupera el usuario que ingreso en ese momento al sistema
  	 * 
  	 * @param nombre,  tipo
  	 * @return usuario logueado 
  	 */
     
     public Usuario recuperaUsuario(String nombre, String tipo) {
    	 
    	 Usuario usuario = usuarioRepository.findByNombreAndTipo(nombre, tipo);
    	 return usuario;
     }
     
     /**
      * @author Jonathan Cruz
  	 * Valida la existencia de un usuario en el sistema
  	 * 
  	 * @param nombre, contraseña y tipo
  	 * @return true si el usuario existe , false si no
  	 */
      
      public Boolean validaUsuario(String nombre, String password, String tipo) {
     	 
     	 Boolean usuario = null;
     	 String pass = password;
     	 
     	 Usuario usuarioRecuperado = usuarioRepository.findByNombreAndTipo(nombre, tipo);//REVISA EN EL REPOSITORIO SI YA EXISTE EL USUARIO 

     	 if(usuarioRecuperado != null) {
     		 
     		 usuario = true;
     		 if((pass.equals(usuarioRecuperado.getContrasenia())) != true) {  
     		     usuario = false;
         		 JOptionPane.showMessageDialog(null, "La contraseña es incorrecta");
     		 }
     		 
     	 }else {
     		 usuario = false;
     		 JOptionPane.showMessageDialog(null, "El usuario no existe");
     	 }
     	 
     	 //System.out.println("Se regreso al control un: " + usuario);
     	 return usuario;
     	 
      }//fin del metodo
     
   //METODO QUE VERIFICA SI EL CORREO Y CONTRASEÑA YA EXISTEN EN LA BASE DE DATOS
     public Usuario recuperaCorreo(String correo) {
		
		// Regla de negocio: No se permite agregar dos usuarios con el mismo nombre y apellido
		
		Usuario correoverifi = usuarioRepository.findByCorreo(correo);//REVISA EN EL REPOSITORIO SI YA EXISTE EL CORREO 
		
		//SI CORREO ES NULL PERMITE CONTINUAR CON EL REGISTRO 
		if(correoverifi==null) {
			System.out.println("null");
			//throw new IllegalArgumentException("ok");
		}//FIN DEL IF
		
		//SI EL USUARIO ES DIFERENTE DE NULL Y YA EXISTE EN EL REPOSITORIO MANDA MENSAJE QUE YA EXISTE 
		if(correoverifi != null) {
			throw new IllegalArgumentException("El correo ya existe");
		}//FIN DEL IF 

		return correoverifi;//REGRESA AL USUARIO

	}//FIN DEL METODO DE VERIFICACION 
     
     public Usuario recuperaCliente(long idCliente) {
    	 
    	Optional<Usuario> clienteRecuperado = usuarioRepository.findById(idCliente);
    	Usuario cliente = null;
    	
    	if(clienteRecuperado.isPresent()) {
    		cliente = clienteRecuperado.get();
    	}
    	return cliente;
     }
}
