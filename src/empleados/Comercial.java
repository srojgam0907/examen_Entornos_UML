package empleados;

public class Comercial {

	private double ventas;
	private double sueldoBase;
	
	public Comercial(String nombre, String apellidos, double sueldoBase, double ventas) {
		nombre= nombre;
		apellidos= apellidos;
		this.sueldoBase= sueldoBase;
		this.ventas= ventas;
	}
	
	public void setVentas(double ventas) {
		this.ventas= ventas;
	}
	
	public double getSueldo() {
		
		return sueldoBase + (ventas * 0.10); 
	}
}
