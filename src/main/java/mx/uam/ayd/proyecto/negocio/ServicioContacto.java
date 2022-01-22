package mx.uam.ayd.proyecto.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.ContactoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Contacto;
import mx.uam.ayd.proyecto.negocio.modelo.MiembroOperaciones;

@Slf4j
@Service
public class ServicioContacto {
	
	@Autowired
	private ContactoRepository contactoRepository;
	
	/**
	 * @author Jonathan Cruz
	 * Recupera todos los contactos de un miembro de operaciones
	 * @param Objeto tipo MiembroOperaciones 
	 * @return lista de contactos
	 * @fechaImplementacion 20 de enero de 2022
	 */
	
	public List<Contacto> recuperaContactos(MiembroOperaciones MOperaciones){
		List <Contacto> employees = contactoRepository.findBymiembroOp(MOperaciones);
		return employees;
	}

	/**
     * @author Jonathan Cruz
 	 * Método que permite agregar un contacto 
	 * @param oper 
 	 * 
 	 * @param Strin nombre, String apellido, Strig telefono
 	 * @return  Contacto
 	 * @fechaImplementación 21 de enero de 2022
 	 */
	public Contacto agregaContacto(String nombre, String apellido, String tel, MiembroOperaciones oper) {
		// Regla de negocio: No se permite agregar dos contactos con el mismo numero de telefono
		
		Contacto contacto = contactoRepository.findByTelefono(tel);
		
		if(contacto != null) {
			throw new IllegalArgumentException("Existe un contacto con ese numero de teléfono");
		}
		
		log.info("Agregando contacto nombre: " + nombre + " apellido:" + apellido + " telefono:" + tel);
		
		contacto = new Contacto();
		contacto.setNombre(nombre);
		contacto.setApellido(apellido);
		contacto.setTelefono(tel);
		contacto.setMiembroOp(oper);
		contactoRepository.save(contacto);
		
		return contacto;	
	}

}
