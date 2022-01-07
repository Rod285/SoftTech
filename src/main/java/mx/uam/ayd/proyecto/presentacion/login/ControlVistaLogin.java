package mx.uam.ayd.proyecto.presentacion.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;

/**
 * 
 * Módulo de control para login
 * 
 * @author SoftTech
 *
 */
@Component
public class ControlVistaLogin {
	
	@Autowired
	private ServicioUsuario servicioUsuario;
	
	@Autowired
	private ControlPrincipal control;
	
	@Autowired
	private VistaLogin vl;
	
	Usuario ur;
	
	public void validaDatos(String nombre, String password, String tipo) {
		
		Boolean datosValidos = servicioUsuario.validaUsuario(nombre, password, tipo);
		String tipoRecuperado = tipo;
		
		if(datosValidos == true) {
			System.out.println(tipoRecuperado + " es el tipo de usuario que ingreso");
			 if(tipoRecuperado.equals("Administrador")) {
				 control.mostrarVistaAdmin();
				 vl.dispose();
			 }else {
				 if(tipoRecuperado.equals("Cliente")) {
	    			 control.mostrarVistaCliente();
	    			 vl.dispose();
	    		 }else {
	    			 if(tipoRecuperado.equals("Operaciones")) {
	    				 control.mostrarVistaMOp();
	        			 vl.dispose();
	    			 }
	    		 }
			 }	
		 } //Fin del if
	
	} //fin del metodo valida datos
}
