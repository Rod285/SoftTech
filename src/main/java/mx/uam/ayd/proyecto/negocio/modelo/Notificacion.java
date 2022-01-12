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
public class Notificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fecha;
	private String descripcion;
	
	//MULTIPLES NOTIFICACIONES PUEDEN PERTENCER A UN MISMO CLIENTE 
	@ManyToOne
	@JoinColumn(name = "idNotificacionC")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "idNotificacionA") //root=1
	private Administrador administrador;
	
	@ManyToOne
	@JoinColumn(name = "idNotificacionO")
	private MiembroOperaciones miembroOp;
}
