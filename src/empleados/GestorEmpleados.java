package empleados;

import java.util.List;

public class GestorEmpleados {

	private Plantilla plantilla;
	private IEntradaSalida consola;
	
	public GestorEmpleados(Plantilla plantilla, IEntradaSalida consola) {
		this.plantilla= new Plantilla();
		this.consola= new Consola();
	}
	
	public void ejecutar() {
		boolean salir= false;
		
		do {
			consola.mostrarMenu();
			
			
			
		} while(!salir);
	}
	
	private void contratarEmpleado() {
		
	}
	
	private void listarTodos() {
		
	}
	
	private void listarPorFiltro() {
		List<Empleado> empleados;
		
		empleados= plantilla.getEmpleadosPorNombre(consola.leerTexto("Introduce el filtro para iniciar la busqueda"));
		
		for(int i=0; i<empleados.size(); i++) {
			consola.imprimir(i+1 + " - " + empleados.get(i).getNombre() + " " + empleados.get(i).getApellidos() + ": " + empleados.get(i).getSueldoBase() + " €");
			
		}
	}
	
	private void listarEmpleados(List<Empleado> empleados) {
		
	}
	
	private void ordenarPorNombre(List<Empleado> empleados) {
		
	}
}
