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

@Entity
@Data
public class Administrador extends Usuario{
	
	@OneToMany(targetEntity = Pedido.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idPedidoA")
	private final List<Pedido> pedidos = new ArrayList<>();
	
	@OneToMany(targetEntity = Notificacion.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idNotificacionA")
	private final List<Notificacion> notificaciones = new ArrayList<>();
	
	public void AgregarPedido(Pedido pedido) {
		pedidos.add(pedido);
	}
}
