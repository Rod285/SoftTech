package mx.uam.ayd.proyecto.negocio.modelo;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fechaInicio;
	private String fechaEntrega;
	private String estado;
	private ArrayList<Pedido> ordenPedido;
	
	//CADA PEDIDO ES ASIGNADO A UN ADMINISTRADOR PARA SER ATENDIDO
	@ManyToOne
	@JoinColumn(name = "idPedidoA")
	private Administrador administrador;
	
	//MULTIPLES PEDIDOS PUEDEN PERTENCER A UN MISMO CLIENTE 
	@ManyToOne
	@JoinColumn(name = "idPedidoC")
	private Cliente cliente;
	
	
	 //UN PEDIDO INCLUYE MULTIPLES vwhiculos POR MODIFICAR 
	@OneToMany(targetEntity = Vehiculo.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idVehiculo")
	private final List<Vehiculo> vehiculos = new ArrayList<>();
	
	@Builder.Default 
	@OneToMany(mappedBy = "pedido")
	    private List<PedidoVehiculo> pedido_vehiculos = new ArrayList<PedidoVehiculo>();
	
	public Boolean AgregarAPedidoExistente(PedidoVehiculo pedvehi) {
		//vehiculos.add(vehiculo);
		pedido_vehiculos.add(pedvehi);
		return (true);
	}
	

}
