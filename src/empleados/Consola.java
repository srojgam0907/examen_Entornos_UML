package empleados;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola implements IEntradaSalida{

	private Scanner sc;
	
	public Consola() {
		this.sc= new Scanner(System.in);
	}
	
	@Override
	public void imprimir(String texto) {
		System.out.println(texto);
		
	}

	@Override
	public void imprimirLinea(String texto) {
		System.out.print(texto); 
		
	}

	@Override
	public String leerTexto(String mensaje) {
		imprimir(mensaje);
		return sc.nextLine(); 
	}

	@Override
	public int leerEntero(String mensaje) {
		boolean error= false;
		int numInt= 0; 
		do {
	    	try {
	    		imprimir(mensaje);
	    		numInt= sc.nextInt(); 
	    		error= false;
	    		
	    	} catch (InputMismatchException e){
	    		System.out.printf("ERROR. Rango válido: %d a %d. Intentalo otra vez", Integer.MIN_VALUE, Integer.MAX_VALUE);
	    		error= true;
	    	} finally {
	    		sc.nextLine(); 
	    	}
	    		
    	} while(error);
    	
    	return numInt;
	}

	@Override
	public double leerImporte(String mensaje) {
		boolean error= false; 
		double importe= 0.0;
		String texto;
		
		do {
			imprimir(mensaje);
			texto= sc.nextLine(); 
			
			texto = texto.replace(',', '.'); 
			
			 try {
	                importe = Double.parseDouble(texto);
	                error = false;
	            } catch (NumberFormatException e) {
	                System.out.println("Error: formato de importe no válido. Inténtelo de nuevo.");
	                error= true; 
	            }
			
		} while(error);

		return importe; 
	}

	@Override
	public void mostrarMenu() {
		System.out.printf("1- Contratar Empleado\n2- Listar todos los empleados\n3- Listar empleados con filtro\n4- Salir\n");
	}

	@Override
	public void limpiarPantalla() {
		for(int i=0; i<50; i++) {
			System.out.println();
		}
	}

	@Override
	public void pausa() {
		imprimir("Pulse una tecla para continuar...");
		sc.nextLine();
	}

	
}
