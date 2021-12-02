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
public class MiembroOperaciones extends Usuario{
	
	/*@OneToMany(targetEntity = Contacto.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idContacto")
	private final List<Contacto> contactos = new ArrayList<>();*/
	
	@OneToMany(targetEntity = Notificacion.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idNotificacionO")
	private List<Notificacion> notificaciones = new ArrayList<>();
	
	private ArrayList<String> autosSolicitados;
	
}
