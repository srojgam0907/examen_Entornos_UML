package empleados;

import java.util.ArrayList;
import java.util.List;

public class Plantilla {

	private List<Empleado> empleados;
	
	public Plantilla() {
		this.empleados= new ArrayList<>();
	}
	
	public void agregarEmpleado(Empleado empleado) {
		empleados.add(empleado);
	}
	
	public List<Empleado> getEmpleadosPorNombre(String filtroNombre) {
		List<Empleado> empleadosFiltro= new ArrayList<>();
		String filtro= filtroNombre.trim().toLowerCase();
		
		
		if(filtroNombre == "") {
			empleadosFiltro.addAll(this.empleados); 
		
		} else {
			for(int i=0; i< empleados.size(); i++) {
				Empleado empleado= empleados.get(i);
				String nombreEmpleado= (empleado.getNombre() + "" + empleado.getApellidos()).toLowerCase();
				
				
				if(nombreEmpleado.contains(filtro)) {
					empleadosFiltro.add(empleado);
				}
			}
		}
		
		return empleadosFiltro;
	}
}
