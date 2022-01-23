package mx.uam.ayd.proyecto.presentacion.muestraVistaMOp;

import javax.swing.JDesktopPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioMiembroOperaciones;
import mx.uam.ayd.proyecto.negocio.modelo.MiembroOperaciones;
import mx.uam.ayd.proyecto.presentacion.muestraAgenda.ControlVistaAgenda;
import mx.uam.ayd.proyecto.presentacion.muestraAgenda.VistaAgenda;
import mx.uam.ayd.proyecto.presentacion.muestraAgenda.VistaAgenda;


/**
 * ControlVistaMOp
 * Módulo de control para la mostrar la vistaMOp
 * 
 * @author Jonathan Cruz
 * @fechaImplementación  20 de enero de 2022
 */

@Component
public class ControlVistaMOp {
	
	MiembroOperaciones oper = null;
	
	@Autowired
	private VistaMOp vistaOperaciones;
	
	@Autowired
	private ServicioMiembroOperaciones servicioMOp;
	
    @Autowired
    private VistaAgenda vistaAgenda;
    
    @Autowired
    private ControlVistaAgenda controlAgenda;
	
	/**
     * @author Jonathan Cruz
 	 * Muestra vista miembro operaciones
 	 * 
 	 * @param 
 	 * @return  
 	 */
	public void inicia() {
		vistaOperaciones.muestra(this);	
	}
	
	/**
     * @author Jonathan Cruz
 	 * recupera al miembro de operaciones que ingreso en ese momento al sistema
 	 * 
 	 * @param nombre
 	 * @return miembro de operaciones logueado 
 	 */
	
	public void operLog(String nombre) {
		oper = servicioMOp.recuperaOperador(nombre);
		//System.out.println("El operador es: " + oper.getNombre() +" su tipo es: "+ oper.getTipo()+ " Y su id es: " + oper.getIdUsuario());	
	}
	
	/**
     * @author Jonathan Cruz
 	 * Da inicio a la HU-12 
 	 * 
 	 * @param 
 	 * @return 
 	 */
	public void muestraVistaAgenda() {
	   controlAgenda.inicia(oper);	
	}

}
