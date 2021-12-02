package mx.uam.ayd.proyecto.presentacion.agregarUsuario;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioGrupo;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;

/**
 * 
 * Módulo de control para la historia de usuario AgregarUsuario
 * 
 * @author humbertocervantes
 *
 */
@Component
public class ControlAgregarUsuario {
	
	@Autowired
	private ServicioUsuario servicioUsuario;
	
	@Autowired
	private ServicioGrupo servicioGrupo;
	
	@Autowired
	private VentanaAgregarUsuario ventana;
	
	/**
	 * Inicia la historia de usuario
	 * 
	 */
	public void inicia() {
		
		List <Grupo> grupos = servicioGrupo.recuperaGrupos();
		
		ventana.muestra(this, grupos);
		
	}

	//METODO QUE AGREGA USUARIO 
		public void agregaUsuario(String nombre, String apellido, String edad, String telefono, String correo, String contrasenia, String grupo) {

			try {//PASA LOS PARAMETROS Y MANDA MENSAJE QUE SE AGREGO CORRECTAMENTE
				servicioUsuario.agregaUsuario(nombre, apellido, edad, telefono, correo, contrasenia, grupo);
				ventana.muestraDialogoConMensaje("Usuario agregado exitosamente");
			} catch(Exception ex) {//MANDA MENSAJE DE ERROR
				ventana.muestraDialogoConMensaje("Error al agregar usuario: "+ex.getMessage());
			}
			
			termina();//TERMINA EL PROCESO DE REGISTRO DESPUES DE SER AGREGADO O MOSTRAR QUE NO SE PUDO AGREGAR
			
		}//FIN DEL METODO AGREGAR USUARIO
		
		//METODO QUE VERIFICA SI EL USUARIO EXISTE
		public void Recupera(String nombre, String apellido) {
			try {
				servicioUsuario.Recupera(nombre, apellido);//SE LE PASA LOS PARAMETROS QUE VA A REVISAR
				//ventana.muestraDialogoConMensaje("Bien");
			} catch(Exception ex) {//SI ENCUENTRA AL USUARIO MANDA MENSAJE DE ERROR 
				ventana.muestraDialogoConMensaje("Error al agregar usuario: "+ex.getMessage());
				termina();//TERMINA EL PROCESO
			}
		}//FIN DEL METODO VERIFICA
		
		//METODO QUE VERIFICA SI EL USUARIO EXISTE
		public void recuperaCorreo(String correo) {
			try {
				servicioUsuario.recuperaCorreo(correo);//SE LE PASA LOS PARAMETROS QUE VA A REVISAR
				//ventana.muestraDialogoConMensaje("Bien");
			} catch(Exception ex) {//SI ENCUENTRA EL CORREO MANDA MENSAJE DE ERROR 
				ventana.muestraDialogoConMensaje("Error al agregar correo: "+ex.getMessage());
				termina();//TERMINA EL PROCESO
			}
		}//FIN DEL METODO VERIFICA
		
		/**
		 * Termina la historia de usuario
		 * 
		 */
		//METODO TERMINA
		public void termina() {
			ventana.setVisible(false);	//DEJA DE MOSTRAR LA VENTANA	
		}//FIN DEL METODO TERMINA

}
