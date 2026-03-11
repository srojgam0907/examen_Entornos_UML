package empleados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		int opcion;
		
		do {
			consola.mostrarMenu();
			opcion= consola.leerEntero("Elige una opcion: ");
			
			switch(opcion) {
			case 1 -> contratarEmpleado();
			case 2 -> listarTodos();
			case 3 -> listarPorFiltro();
			case 4 -> {
				consola.imprimir("Saliendo...");
				salir= true;
			}
			default -> consola.imprimir("ERROR: introduzca una de las opciones");
			}
			consola.pausa();
			consola.imprimirLinea("");
			
		} while(!salir);
	}
	
	private void contratarEmpleado() {
		int categoria= 0;
		String dni;
		String nombre;
		String apellidos;
		double sueldoBase;
		
		do { 
			categoria= consola.leerEntero("¿Que tipo de empleado es?" + "\n" + "1 - Técnico" + "\n" + "2 - Comercial");
			
			if(categoria != 1 && categoria != 2) {
				consola.imprimir("ERROR: introduce un numero correspondiente a una categoria");
			
			} else {
				dni= consola.leerTexto("Introduce el dni: ");
				nombre= consola.leerTexto("Introduce el nombre: ");
				apellidos= consola.leerTexto("Introduce los apellidos: ");
				sueldoBase= consola.leerImporte("Introduce el sueldo base: ");
				
				if(categoria == 1) {
					Empleado tecnico= new Tecnico(dni, nombre, apellidos, sueldoBase, categoria);
					plantilla.agregarEmpleado(tecnico); 
					
				} else {
					Empleado comercial= new Comercial(dni, nombre, apellidos, sueldoBase);
					plantilla.agregarEmpleado(comercial);  
				}
			}
			
		} while(categoria != 1 && categoria != 2);

	}
	
	private void listarTodos() {
		List<Empleado> empleados= new ArrayList<>();
		
		empleados.addAll(plantilla.getEmpleadosPorNombre(""));
		
		listarEmpleados(empleados); 
	}
	
	private void listarPorFiltro() {
		List<Empleado> empleados= new ArrayList<>();
		
		empleados= plantilla.getEmpleadosPorNombre(consola.leerTexto("Introduce el filtro para iniciar la busqueda"));
		
		listarEmpleados(empleados); 
	}
	
	private void listarEmpleados(List<Empleado> empleados) {
		empleados= ordenarPorNombre(empleados);
		
		for(int i=0; i<empleados.size(); i++) {
			consola.imprimir(i+1 + " - " + empleados.get(i).getNombre() + " " + empleados.get(i).getApellidos() + ": " + empleados.get(i).getSueldoBase() + " €");
		}
	}
	
	private List<Empleado> ordenarPorNombre(List<Empleado> empleados) {
		Collections.sort(empleados, Comparator.comparing(Empleado::getNombre));
		return empleados; 
	}
}
