package empleados;

public class Tecnico {
	
	private int categoria;
	private double sueldoBase;
	
	public Tecnico(String dni, String apellidos, double sueldoBase, int categoria) {
		dni= dni; 
		apellidos= apellidos;
		this.sueldoBase= sueldoBase;
		this.categoria= categoria;
	}
	
	public double getSueldo() {
		
		return sueldoBase + (categoria*100); 
	}
}
