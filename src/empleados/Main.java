package empleados;

public class Main {

	public static void main(String[] args) {
		Plantilla plantilla= new Plantilla();
		Consola consola= new Consola();
		GestorEmpleados gestor= new GestorEmpleados(plantilla, consola);
		
		gestor.ejecutar();

	}

}
