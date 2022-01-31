package mx.uam.ayd.proyecto.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.MiembroOperacionesRepository;
import mx.uam.ayd.proyecto.negocio.modelo.MiembroOperaciones;

@Service
public class ServicioMiembroOperaciones {
	
	@Autowired
	private MiembroOperacionesRepository miembroOpRepository;
	
	/*
	 * Recupera un miembro de operaciones por su nombre
	 * 
	 * @return dato de tipo MiembroOperaciones
	 * 
	 * @param dato de tipo String
	 */
	 
	public MiembroOperaciones recuperaOperador(String nombre) {
		 		
		MiembroOperaciones oper = miembroOpRepository.findByNombre(nombre);  //findByNombre(nomre)
		if(oper == null) {
			System.out.println("No se encontró al miembro de operaciones");
		}
		return oper;
		
	}//Fin del metodo recuperaAdmistrador

}
