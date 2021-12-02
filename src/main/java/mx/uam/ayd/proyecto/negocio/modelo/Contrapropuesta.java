package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Contrapropuesta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPedido;
	private String nombreCliente;
	private String fechaEntrega;
	private String estado;
}
