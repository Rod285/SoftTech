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
	//private long idContacto;
	private String nombre;
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "idContacto")
	private Cliente cliente;

}
