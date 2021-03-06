package mx.uam.ayd.proyecto.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Contacto;
import mx.uam.ayd.proyecto.negocio.modelo.MiembroOperaciones;

public interface ContactoRepository extends CrudRepository <Contacto, Long>{

	/*
	 * @author Jonathan Cruz
	 * Recupera los contactos a partir del operador recibido
	 * @param Objeto de tipo MiembroOperaciones
	 * @return contactos corresponientes al operador
	 * @fechaImplementacion 20 de enero de 2022
	 */
	public List <Contacto> findBymiembroOp(MiembroOperaciones operaciones);
	
	public Contacto findByTelefono(String telefono);
	
}
