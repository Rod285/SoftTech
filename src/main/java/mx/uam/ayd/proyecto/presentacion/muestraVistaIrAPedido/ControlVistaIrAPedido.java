package mx.uam.ayd.proyecto.presentacion.muestraVistaIrAPedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;

@Component
@Controller
public class ControlVistaIrAPedido {

	@Autowired
	private VistaIrAPedido ventana;
	
	private List<Vehiculo> listaPedido;
	
	public void inicia(List<Vehiculo> listaPedido) {
		this.listaPedido = listaPedido;
		ventana.muestra(this);
	}

}
