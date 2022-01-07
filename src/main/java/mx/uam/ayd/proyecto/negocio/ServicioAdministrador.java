package mx.uam.ayd.proyecto.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.AdministradorRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Administrador;

@Slf4j
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
			throw new IllegalArgumentException("No se encontró el administrador");
		}else {
			return administrador; //regresa el administrador si fue encontrado
		}
	}//Fin del metodo recuperaAdmistrador

}