package mx.uam.ayd.proyecto.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.AdministradorRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Administrador;

//@Slf4j
@Service
public class ServicioAdministrador {
	
	@Autowired 
	private AdministradorRepository administradorRepository;
	
	/*
	 * Recupera un administrador por su nombre
	 * 
	 * @return Dato de tipo Administrador
	 * 
	 * @param Dato de tipo String
	 */
	 
	public Administrador recuperaAdministrador(String nombre) {
		 		
		Administrador administrador = administradorRepository.findByNombre(nombre);  //findByNombre(nomre)
		if(administrador == null) {
			System.out.println("No se encontró el administrador");
		}
		return administrador;
		
	}//Fin del metodo recuperaAdmistrador

}
