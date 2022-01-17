package mx.uam.ayd.proyecto;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import lombok.Builder;
import mx.uam.ayd.proyecto.datos.AdministradorRepository;
import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.datos.GrupoRepository;
import mx.uam.ayd.proyecto.datos.NotificacionRepository;
import mx.uam.ayd.proyecto.datos.OperacionesRepository;
import mx.uam.ayd.proyecto.datos.PedidoRepository;
import mx.uam.ayd.proyecto.datos.PedidoVehiculoRepository;
import mx.uam.ayd.proyecto.datos.VehiculoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Administrador;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;
import mx.uam.ayd.proyecto.negocio.modelo.MiembroOperaciones;
import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;
import mx.uam.ayd.proyecto.negocio.modelo.PedidoVehiculo;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;
import mx.uam.ayd.proyecto.presentacion.login.VistaLogin;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;

/**
 * 
 * Clase principal que arranca la aplicación 
 * construida usando el principio de 
 * inversión de control
 * 
 * Ejemplo de cambio en Rama
 * 
 * @author BurbujasMaravillosas
 *
 */
@SpringBootApplication
public class ProyectoApplication {

	@Autowired
	ControlPrincipal controlPrincipal;
	
	@Autowired
	GrupoRepository grupoRepository;
	
	@Autowired
	AdministradorRepository administradorRepository;

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	OperacionesRepository operacionesRepository;
	
	@Autowired
	NotificacionRepository notificacionRepository;
	
	@Autowired
	VehiculoRepository vehiculoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	PedidoVehiculoRepository pedidoVehiculoRepository;
	
	/**
	 * 
	 * Método principal
	 * 
	 */
	public static void main(String[] args) {
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ProyectoApplication.class);

		builder.headless(false);

		builder.run(args);
	}

	/**
	 * Metodo que arranca la aplicacion
	 * inicializa la bd y arranca el controlador
	 * otro comentario
	 */
	@PostConstruct
	public void inicia() {
		
		inicializaBD();
		
		controlPrincipal.inicia();
	}
	
	
	/**
	 * 
	 * Inicializa la BD con datos
	 * 
	 * 
	 */
	public void inicializaBD() {
		
		// Vamos a crear los dos grupos de usuarios
		
		/*
		 * Inicializacion de grupoAdmin
		 */
		
		Grupo grupoAdmin = new Grupo();
		grupoAdmin.setNombre("Administradores");
		grupoRepository.save(grupoAdmin);
		
		/*
		 * Inicializacion de grupoOperaciones
		 */
		
		Grupo grupoOps = new Grupo();
		grupoOps.setNombre("Operadores");
		grupoRepository.save(grupoOps);
		
		/*
		 * Inicializacion de grupoCliente
		 */
		
		Grupo grupoCli = new Grupo();
		grupoCli.setNombre("Cliente");
		grupoRepository.save(grupoCli);
		
		/*
		 * Declaracion de administradores root, root2 para poder iniciar sesión en el sistema.
		*/ 
		
		Administrador root = new Administrador();
		root.setNombre("root");
		root.setContrasenia("root");
		root.setApellido("root");
		root.setCorreo("root");
		root.setEdad("100");
		root.setTelefono("55");
		root.setTipo("Administrador");
		administradorRepository.save(root);
		
		Administrador root2 = new Administrador();
		root2.setNombre("root2");
		root2.setContrasenia("root2");
		root2.setApellido("root2");
		root2.setCorreo("root2");
		root2.setEdad("23");
		root2.setTelefono("5545");
		root2.setTipo("Administrador");
		administradorRepository.save(root2);
		
		
		/*
		 * Declaracion de cliente de prueba.
		 */
		
		Cliente cliente = new Cliente();
		cliente.setNombre("prueba");
		cliente.setContrasenia("prueba");
		cliente.setTipo("Cliente");
		clienteRepository.save(cliente);
		
		/*
		 * Declaracion de miembro de operaciones de prueba.
		 */
		
		MiembroOperaciones oper = new MiembroOperaciones();
		oper.setNombre("operaciones");
		oper.setContrasenia("operaciones");
		oper.setTipo("Operaciones");
		operacionesRepository.save(oper);
		
		/*
		 * Declaracion de notificaciones de prueba.
		 */
		
		Notificacion notificacion1 = new Notificacion();
		notificacion1.setDescripcion("Ha recibido una contrapropuesta");
		notificacion1.setFecha("18/10/21");
		notificacion1.setCliente(cliente);
		notificacionRepository.save(notificacion1);
		
		Notificacion notificacion2 = new Notificacion();
		notificacion2.setDescripcion("Nuevo pedido generado");
		notificacion2.setFecha("12/01/22");
		notificacion2.setHora("10:30 am");
		notificacion2.setAdministrador(root);
		notificacionRepository.save(notificacion2);
		
		Notificacion notificacion3 = new Notificacion();
		notificacion3.setDescripcion("El cliente ha aceptado la contrapropuesta");
		notificacion3.setFecha("13/01/22");
		notificacion3.setHora("3:40 pm");
		notificacion3.setAdministrador(root);
		notificacionRepository.save(notificacion3);
		
		/*
		 * Declaracion de vehículos para pedido de prueba.
		*/ 
		
		
		//1
		Vehiculo vehiculoPrueba1 = new Vehiculo();
		vehiculoPrueba1.setModelo("Audi");
		vehiculoPrueba1.setPrecio(3500);
		vehiculoPrueba1.setAnio(2020);
		vehiculoPrueba1.setTipo("Deportivo");
		vehiculoPrueba1.setDescripcion("A1");
		vehiculoPrueba1.setDisponibilidad(true);
		vehiculoPrueba1.setFoto("c:\\Users\\zerat\\Documents\\IngSoft\\AnalysisYDiseno-master\\src\\main\\java\\mx\\uam\\ayd\\proyecto\\presentacion\\muestraVistaCatalogo\\audi_320x180.jpeg");
		vehiculoRepository.save(vehiculoPrueba1);
		
		//2
		Vehiculo vehiculoPrueba2 = new Vehiculo();
		vehiculoPrueba2.setModelo("Mustang");
		vehiculoPrueba2.setPrecio(4500);
		vehiculoPrueba2.setAnio(1967);
		vehiculoPrueba2.setTipo("Clasico");
		vehiculoPrueba2.setDescripcion("Eleanor");
		vehiculoPrueba2.setDisponibilidad(true);
		vehiculoPrueba2.setFoto("C:\\Users\\zerat\\Documents\\IngSoft\\AnalysisYDiseno-master\\src\\main\\java\\mx\\uam\\ayd\\proyecto\\presentacion\\muestraVistaCatalogo\\mustang_320x180.jpeg");
		vehiculoRepository.save(vehiculoPrueba2);
		
		//3
		Vehiculo vehiculoPrueba3 = new Vehiculo();
		vehiculoPrueba3.setModelo("Camaro");
		vehiculoPrueba3.setPrecio(5000);
		vehiculoPrueba3.setAnio(2021);
		vehiculoPrueba3.setTipo("Deportivo");
		vehiculoPrueba3.setDescripcion("");
		vehiculoPrueba3.setDisponibilidad(true);
		vehiculoPrueba3.setFoto("C:\\Users\\zerat\\Documents\\IngSoft\\AnalysisYDiseno-master\\src\\main\\java\\mx\\uam\\ayd\\proyecto\\presentacion\\muestraVistaCatalogo\\camaro_320x180.jpeg");
		vehiculoRepository.save(vehiculoPrueba3);
		
		//4
		Vehiculo vehiculoPrueba4 = new Vehiculo();
		vehiculoPrueba4.setModelo("Mazda3");
		vehiculoPrueba4.setPrecio(3500);
		vehiculoPrueba4.setAnio(2020);
		vehiculoPrueba4.setTipo("Deportivo");
		vehiculoPrueba4.setDescripcion("");
		vehiculoPrueba4.setDisponibilidad(true);
		vehiculoPrueba4.setFoto("c:/Users/zerat/Documents/IngSoft/AnalysisYDiseno-master/src/main/java/mx/uam/ayd/proyecto/presentacion/muestraVistaCatalogo/mazda3_320x180.jpeg");
		vehiculoRepository.save(vehiculoPrueba4);
		
		//5
		Vehiculo vehiculoPrueba5 = new Vehiculo();
		vehiculoPrueba5.setModelo("Mercedes Benz");
		vehiculoPrueba5.setPrecio(5000);
		vehiculoPrueba5.setAnio(2020);
		vehiculoPrueba5.setTipo("Lujo");
		vehiculoPrueba5.setDescripcion("");
		vehiculoPrueba5.setDisponibilidad(true);
		vehiculoPrueba5.setFoto("c:/Users/zerat/Documents/IngSoft/AnalysisYDiseno-master/src/main/java/mx/uam/ayd/proyecto/presentacion/muestraVistaCatalogo/mercedes_320x180.jpeg");
		vehiculoRepository.save(vehiculoPrueba5);
		
		//6
		Vehiculo vehiculoPrueba6 = new Vehiculo();
		vehiculoPrueba6.setModelo("BMW");
		vehiculoPrueba6.setPrecio(3000);
		vehiculoPrueba6.setAnio(2018);
		vehiculoPrueba6.setTipo("Lujo");
		vehiculoPrueba6.setDescripcion("");
		vehiculoPrueba6.setDisponibilidad(true);
		vehiculoPrueba6.setFoto("c:/Users/zerat/Documents/IngSoft/AnalysisYDiseno-master/src/main/java/mx/uam/ayd/proyecto/presentacion/muestraVistaCatalogo/BMW_320x180.jpeg");
		vehiculoRepository.save(vehiculoPrueba6);
		
		//7
		Vehiculo vehiculoPrueba7 = new Vehiculo();
		vehiculoPrueba7.setModelo("Internacional");
		vehiculoPrueba7.setPrecio(5000);
		vehiculoPrueba7.setAnio(2018);
		vehiculoPrueba7.setTipo("Carga");
		vehiculoPrueba7.setDescripcion("");
		vehiculoPrueba7.setDisponibilidad(true);
		vehiculoPrueba7.setFoto("C:\\Users\\zerat\\Documents\\IngSoft\\AnalysisYDiseno-master\\src\\main\\java\\mx\\uam\\ayd\\proyecto\\presentacion\\muestraVistaCatalogo\\VolteoInternacional_320x180.jpg");
		vehiculoRepository.save(vehiculoPrueba7);
			
		//8
		Vehiculo vehiculoPrueba8 = new Vehiculo();
		vehiculoPrueba8.setModelo("Freightliner");
		vehiculoPrueba8.setPrecio(7000);
		vehiculoPrueba8.setAnio(2018);
		vehiculoPrueba8.setTipo("Carga");
		vehiculoPrueba8.setDescripcion("");
		vehiculoPrueba8.setDisponibilidad(true);
		vehiculoPrueba8.setFoto("c:/Users/zerat/Documents/IngSoft/AnalysisYDiseno-master/src/main/java/mx/uam/ayd/proyecto/presentacion/muestraVistaCatalogo/TrailerFreightliner_320x180.jpg");
		vehiculoRepository.save(vehiculoPrueba8);
				
		//9
		Vehiculo vehiculoPrueba9 = new Vehiculo();
		vehiculoPrueba9.setModelo("Maverick");
		vehiculoPrueba9.setPrecio(3500);
		vehiculoPrueba9.setAnio(1977);
		vehiculoPrueba9.setTipo("Clasico");
		vehiculoPrueba9.setDescripcion("");
		vehiculoPrueba9.setDisponibilidad(true);
		vehiculoPrueba9.setFoto("c:/Users/zerat/Documents/IngSoft/AnalysisYDiseno-master/src/main/java/mx/uam/ayd/proyecto/presentacion/muestraVistaCatalogo/Maverick_320x180.jpg");
		vehiculoRepository.save(vehiculoPrueba9);
		
		/*
		 * Declaracion de pedioVehículo para pedido de prueba.
		 */
		Pedido pedidoPrueba = new Pedido();
		pedidoPrueba.setFechaInicio("18/01/2022");
		pedidoPrueba.setFechaEntrega("20/01/2022");
		pedidoPrueba.setEstado("Por aceptar");
		pedidoPrueba.setAdministrador(root);
		pedidoPrueba.setCliente(cliente);
		pedidoRepository.save(pedidoPrueba);
		
		PedidoVehiculo pedidoVehiculo1 = new PedidoVehiculo();
		PedidoVehiculo pedidoVehiculo2 = new PedidoVehiculo();
		PedidoVehiculo pedidoVehiculo3 = new PedidoVehiculo();
		
		
		pedidoVehiculo1.setPedido(pedidoPrueba);
		pedidoVehiculo1.setVehiculo(vehiculoPrueba1);
		pedidoVehiculoRepository.save(pedidoVehiculo1);
		
		pedidoVehiculo2.setPedido(pedidoPrueba);
		pedidoVehiculo2.setVehiculo(vehiculoPrueba2);
		pedidoVehiculoRepository.save(pedidoVehiculo2);
		
		pedidoVehiculo3.setPedido(pedidoPrueba);
		pedidoVehiculo3.setVehiculo(vehiculoPrueba3);
		pedidoVehiculoRepository.save(pedidoVehiculo3);
	
		
		ArrayList<PedidoVehiculo> arregloPedidoVehiculo = new ArrayList<>();
		arregloPedidoVehiculo.add(pedidoVehiculo1);
		arregloPedidoVehiculo.add(pedidoVehiculo2);
		arregloPedidoVehiculo.add(pedidoVehiculo3);
		System.out.println(arregloPedidoVehiculo);
		/*
		 * Declaracion de pedido de prueba.
		 */
		
		pedidoPrueba.setPedido_vehiculos(arregloPedidoVehiculo);
		pedidoRepository.save(pedidoPrueba);
				
	}
}
