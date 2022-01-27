package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
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
	 * @return lista de contactos, que puede estar vacia si no hay contactos 
	 * @fechaImplementacion 20 de enero de 2022
	 */
	public List<Contacto> recuperaContactos(MiembroOperaciones MOperaciones){
		
		//En ésta lista se alamacenan los contactos recuperados
		  List <Contacto> contactos = new ArrayList<>();
		  for(Contacto contacto:contactoRepository.findBymiembroOp(MOperaciones)) {
			  contactos.add(contacto);
		  }
		
		return contactos;
	}

	/**
     * @author Jonathan Cruz
 	 * Método que permite agregar un contacto 
 	 * 
 	 * @param Strin nombre, nombre del contacto
 	 * @param String apellido, apellido del contacto 
 	 * @param Strig telefono, numero de telédfono del contactro
 	 * @param MiembroOperaciones oper, miembro de operaciones al que le pertenece elcontacto
 	 * @return El contacto que se agregó 
 	 * @throws IllegalArgumentException si el número de telefono ya se encuentra registrado
 	 * @fechaImplementación 21 de enero de 2022
 	 */
	public Contacto agregaContacto(String nombre, String apellido, String tel, MiembroOperaciones oper) {
		//Regla de negocio: No se permite agregar dos contactos con el mismo numero de telefono
				
		Contacto contacto = contactoRepository.findByTelefono(tel);
		
		if(contacto != null) {
			System.out.println("Existe un contacto con ese numero de teléfono");
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
