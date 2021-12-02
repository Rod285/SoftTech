package mx.uam.ayd.proyecto.negocio.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehiculo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String modelo;
	private int precio;
	private int anio;
	private String tipo;
	private String descripcion;
	private boolean disponibilidad;
	
	/*
	@ManyToOne
	@JoinColumn(name = "idVehiculo")
	private Pedido pedido;
	*/
	@OneToMany(mappedBy = "vehiculo")
    Set<PedidoVehiculo> pedido_vehiculos;
}
