package mx.uam.ayd.proyecto.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.ContactoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Contacto;
import mx.uam.ayd.proyecto.negocio.modelo.MiembroOperaciones;

//@Slf4j
@Service
public class ServicioContacto {
	
	@Autowired
	private ContactoRepository contactoRepository;
	
	/**
	 * @author Jonathan Cruz
	 * Recupera todos los contactos de un miembro de operaciones
	 * @param Objeto tipo MiembroOperaciones 
	 * @return lista de contactos
	 *
	 */
	
	public List<Contacto> recuperaContactos(MiembroOperaciones MOperaciones){
		List <Contacto> employees = contactoRepository.findBymiembroOp(MOperaciones);
		return employees;
	}

}
