package empleados;

public class Tecnico {
	
	private int categoria;
	String dni;
	String apellidos;
	double sueldoBase;
	
	public Tecnico(String dni, String apellidos, double sueldoBase, int categoria) {
		this.dni= dni; 
		this.apellidos= apellidos;
		this.sueldoBase= sueldoBase;
		this.categoria= categoria;
	}
	
	public double getSueldo() {
		
		return sueldoBase + (categoria*100); 
	}
}
