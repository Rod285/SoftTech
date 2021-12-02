package mx.uam.ayd.proyecto.negocio.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoVehiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    Vehiculo vehiculo;

    @Builder.Default 
    private int cantidad=1;
	
	public Boolean incrementaCantidad(int num) {
		this.cantidad = num;
		return true;
	}

}
