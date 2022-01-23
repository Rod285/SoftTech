package mx.uam.ayd.proyecto.negocio;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.ContactoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Contacto;
import mx.uam.ayd.proyecto.negocio.modelo.MiembroOperaciones;


@Service
public class ServicioContacto {
	
	@Autowired
	private ContactoRepository contactoRepository;
	
	/**
	 * @author Jonathan Cruz
	 * Recupera todos los contactos de un miembro de operaciones
	 * @param MiembroOperaciones MOperaciones 
	 * @return lista de contactos
	 * @fechaImplementacion 20 de enero de 2022
	 */
	public List<Contacto> recuperaContactos(MiembroOperaciones MOperaciones){
		//En ésta lista se alamacenan los contactos recuperados
		List <Contacto> contactos = contactoRepository.findBymiembroOp(MOperaciones);
		return contactos;
	}

	/**
     * @author Jonathan Cruz
 	 * Método que permite agregar un contacto 
 	 * 
 	 * @param Strin nombre, String apellido, Strig telefono, MiembroOperaciones oper
 	 * @return  Contacto
 	 * @fechaImplementación 21 de enero de 2022
 	 */
	public Contacto agregaContacto(String nombre, String apellido, String tel, MiembroOperaciones oper) {
		//Regla de negocio: No se permite agregar dos contactos con el mismo numero de telefono
				
		Contacto contacto = contactoRepository.findByTelefono(tel);
		
		if(contacto != null) {
			throw new IllegalArgumentException("Existe un contacto con ese numero de teléfono");
		}
		
		contacto = new Contacto();
		contacto.setNombre(nombre);
		contacto.setApellido(apellido);
		contacto.setTelefono(tel);
		contacto.setMiembroOp(oper);
		contactoRepository.save(contacto);
		
		return contacto;	
	}
	
}
