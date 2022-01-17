package mx.uam.ayd.proyecto.negocio.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
//@Data
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Usuario{
	@OneToMany(targetEntity = Pedido.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idPedidoC")
	private final List<Pedido> pedidos = new ArrayList<>();
	
	
	@OneToMany(targetEntity = Notificacion.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idNotificacionC")
	private final List<Notificacion> notificaciones = new ArrayList<>();
	
	/*public List<Pedido> mostrarPedidos(){
		return pedidos;
	}
	
	public void AgregarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}*/
}

