package mx.uam.ayd.proyecto.presentacion.login;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.ProyectoApplication;
import mx.uam.ayd.proyecto.negocio.ServicioUsuario;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.presentacion.muestraVistaAdministrador.VistaAdministrador;
import mx.uam.ayd.proyecto.presentacion.principal.VentanaPrincipal;
import mx.uam.ayd.proyecto.presentacion.seleccionDeArticulos.VistaSeleccionDeArticulos;

/**
 * 
 * Módulo de control para login
 * 
 * @author BurbujasMaravillosas
 *
 */
@Component
public class ControlVistaLogin {
	
	@Autowired
	private ServicioUsuario servicioUsuario;
	
	Usuario ur;
	
	public long recuperaUsuarioYPasswordYTipo(String nombre, String password, String tipo, VistaLogin vl) {
		
		try {
			ur = servicioUsuario.RecuperaUsuarioYPasswordYTipo(nombre, password, tipo, vl);
			
		} catch(Exception ex) {//SI ENCUENTRA AL USUARIO MANDA MENSAJE DE ERROR 
			
			JOptionPane.showMessageDialog(null, "El usuario no existe");
		}
		
		VistaAdministrador.idUsuario=ur.getIdUsuario();
		
		//VistaSeleccionDeArticulos.idUsuario=ur.getIdUsuario();
		return ur.getIdUsuario();
	}
}
