package mx.uam.ayd.proyecto.negocio.modelo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
public class Contacto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String apellido;
	private String telefono;
	
	//Multiples contactos pueden pertenecer a un mismo miembro de operaciones
	@ManyToOne
	@JoinColumn(name = "idContacto")
	private MiembroOperaciones miembroOp;

}
