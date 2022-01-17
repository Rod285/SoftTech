package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import mx.uam.ayd.proyecto.datos.AdministradorRepository;
import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.datos.GrupoRepository;
import mx.uam.ayd.proyecto.datos.PedidoRepository;
import mx.uam.ayd.proyecto.datos.PedidoVehiculoRepository;
import mx.uam.ayd.proyecto.datos.UsuarioRepository;
import mx.uam.ayd.proyecto.datos.VehiculoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Administrador;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.negocio.modelo.Grupo;
import mx.uam.ayd.proyecto.negocio.modelo.Notificacion;
import mx.uam.ayd.proyecto.negocio.modelo.Pedido;
import mx.uam.ayd.proyecto.negocio.modelo.PedidoVehiculo;
import mx.uam.ayd.proyecto.negocio.modelo.Usuario;
import mx.uam.ayd.proyecto.negocio.modelo.Vehiculo;

/*
 * @author Omar Aldaco Montalvo
 */


@Slf4j
@Service

public class ServicioPedido {
	
	@Autowired 
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired 
	private AdministradorRepository administradorRepository;
	
	@Autowired 
	private VehiculoRepository vehiculoRepository;
	
	@Autowired 
	private PedidoVehiculoRepository pedidovehiculoRepository;
	
	List<Vehiculo> listaPedido = new ArrayList<>();
	
		
	/** CONTRATO
	 * ***Recupera Pedidos***
	 * Recupera los pedidos correspondientes al cliente
	 * ENTRADA: atributos tipo string "modelo" y long "idCliente"
	 * @return Una lista con los pedidos asociados a ese cliente que se enceuntran como parametro del cliente en un arreglo (o lista vacía). 
	 * @return NULL si el cliente no fue encontrado en el repositorio
	 
	public List <Pedido> recuperaPedidos(String modelo, Long idCliente){
		
		Optional<Cliente> clienteX = clienteRepository.findById(idCliente);
		if (clienteX.isPresent()) {
			return clienteX.get().mostrarPedidos();
		}
		
		return null;
	}
	
	/** CONTRATO
	 * ***Nuevo Pedido***
	 * Crear un nuevo pedido asignandolo a los usuarios tipo "Cliente" y "Administrador"
	 * ENTRADA: atributos tipo string "modelo" y long "idCliente"
	 * @return Atributo "idPedido" del nuevo objeto tipo Pedido creado
	 * @return NULL si el cliente no fue encontrado en el repositorio
	 
	
	public Long nuevoPedido(String modelo, Long idCliente) {
	
		Optional<Cliente> optCliente = clienteRepository.findById(idCliente);
		Optional<Vehiculo> optVehiculo = vehiculoRepository.findByModelo(modelo);
		if (optCliente.isPresent() && optVehiculo.isPresent()) {
			
			//CREO EL PEDIDO Y LE ASIGNO SU CREADOR (CLIENTE)
			Cliente cliente1 = optCliente.get();
			Vehiculo vehiculoX =optVehiculo.get();
			Pedido pedido = new Pedido();
			pedido.setCliente(cliente1);
		
			//GUARDO EL NUEVO PEDIDO EN EL RESPOSITORIO Y OBTENGO SU ID
			Pedido pedidoGuardado=pedidoRepository.save(pedido);
			Long idPedido = pedidoGuardado.getId();
			
			//AGREGO A LA LISTA DE PEDIDOS DEL CLEINTE EL NUEVO PEDIDO
			cliente1.AgregarPedido(pedidoGuardado);
			clienteRepository.save(cliente1);
			
			//RECUPERO A TODOS LOS ADMINISTRADORES Y AL PRIMERO DE ELLOS POR EL MOMENTO SERA EL UNICO QUE ATIENDA LOS PEDIDOS, DESPUES ES POSIBLE GENERAR UN RANDOM PARA QUE CUANDO HAYA MÁS DE UN ADMINISTRADOR SEA ALEATORIA LA ASIGNACION
			ArrayList<Administrador> administradores = (ArrayList<Administrador>) administradorRepository.findAll();//AQUI NECESITO RECUPERAR A UN ADMIN, EL QUE SEA PARA ASIGNARLE EL PEDIDO GUARDADO
			Administrador admin = administradores.get(0);
			admin.AgregarPedido(pedidoGuardado);
			administradorRepository.save(admin);
			
			//LE ASIGNO AL PEDIDO EL ADMINISTRADOR QUE LO ATENDERÁ
			pedidoGuardado.setAdministrador(admin);
			
			//LE ASIGNO AL PEDIDO SU RELACION PEDIDO-VEHICULO, PRIMERO CREO DESDE CERO UNA INSTANCIA TIPO PEDIDO_VEHICULO
			PedidoVehiculo pedidovehi = new PedidoVehiculo();
			//ahora ligo esta nueva instancia con el pedido creado y con el vehiculo seleccionado por el cliente y hago la persistencia en el repositorio
			pedidovehi.setPedido(pedidoGuardado);
			pedidovehi.setVehiculo(vehiculoX);
			PedidoVehiculo pedidovehiX=pedidovehiculoRepository.save(pedidovehi);
			
			//AHORA LIGO AL PEDIDO Y AL VEHICULO SELECCIONADO CON LA NUEVA ENTIDAD PEDIDOVEHICULO
			pedidoGuardado.getPedido_vehiculos().add(pedidovehiX);
			vehiculoX.getPedido_vehiculos().add(pedidovehiX);
			
			vehiculoRepository.save(vehiculoX);
			pedidoRepository.save(pedidoGuardado);
		
			return idPedido;//debo generar un pedido y regresar su id para su manejo
		}
		return null;
	}
	
	/**CONTRATO
	 * ***Agregar a Pedido Existente***
	 * Recuperar y actualizar el pedido indicado 
	 * ENTRADA: atributos tipo string "modelo" y Pedido "pedido"
	 * @return Cadena que confirma o niega que el artículo fue agregado con éxito
	 
	public boolean agregarAPedidoExistente(String modelo, Pedido pedido) {
		
		//RECUPERO EL PEDIDO Y EL VEHICULO QUE AGREGARÉ AL MISMO POR EL MODELO
		Optional<Pedido> optPedido = pedidoRepository.findById(pedido.getId());
		Optional<Vehiculo> optVehiculo = vehiculoRepository.findByModelo(modelo);
		
		//SI EL RETRIEVE FUE EXITOSO ASIGNO EL VEHICULO AL PEDIDO Y GUARDO CAMBIOS
		if (optPedido.isPresent() && optVehiculo.isPresent()){
			
			Pedido pedidoX = optPedido.get();
			Vehiculo vehiculoX = optVehiculo.get();
			
			//DEBO CREAR UNA NUEVA INSTANCIA DE PEDIDOVEHICULO, RELACIONARLO CON EL PEDIDO, EL MODELO DEL QUE SE TRATA Y GUARDARLO
			PedidoVehiculo pedidovehi = new PedidoVehiculo();
			pedidovehi.setPedido(pedidoX);
			pedidovehi.setVehiculo(vehiculoX);
			PedidoVehiculo pedidovehiX=pedidovehiculoRepository.save(pedidovehi);
			
			//AHORA LIGO AL PEDIDO Y AL VEHICULO SELECCIONADO CON LA NUEVA ENTIDAD PEDIDOVEHICULO MANDANDO A LLAMAR AL MÉTODO DEL PEDIDO QUE LO HACE
			Boolean resp = pedidoX.AgregarAPedidoExistente(pedidovehiX);
			
			vehiculoRepository.save(vehiculoX);
			pedidoRepository.save(pedidoX);
			
			return resp;
		}
		return false;
	}*/
	
	public Optional<Pedido> recuperaPedido(long id){
		/**
		 * Recupera pedido a partir del id
		 * 
		 * @return Optional<Pedido>
		 */
		
		Optional<Pedido> pedidoRecuperado = pedidoRepository.findById(id);
		return pedidoRecuperado;
	}


	/*
	 * Autor: Mejía Velázquez José Rodrigo
	 * Descripción: Método que agrega a la lista de Pedidos los vehículos seleccionados por el usuario, el método regresa
	 * la listaPedido, si el vehículo ya se encuentra en la listaPedido, regresa un nulo.
	 * 
	 * @Parameter List<Vehiculo>, int indiceVehiculo
	 * @return List<Vehiculo>
	 * @null si el vehiculo ya está en la lista
	 */
	public List<Vehiculo> agregarAPedido(List<Vehiculo> listaVehiculos, int indiceVehiculo) {
		if (listaPedido.contains(listaVehiculos.get(indiceVehiculo))) {
			return null;
		} else {
			listaPedido.add(listaVehiculos.get(indiceVehiculo));
			return listaPedido;
		}
	} 
}
