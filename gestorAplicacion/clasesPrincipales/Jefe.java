package clasesPrincipales;

import java.util.ArrayList;

public class Jefe extends Empleado {
	private ArrayList<Proyecto> proyectosAsignados = new ArrayList<Proyecto>();
	
	public Jefe(String username, String nombre, 
			String correo, String contrasena, Calendario calendario, Equipo equipo, 
			ArrayList<Tarea> listaDeTareas, ArrayList<Proyecto> proyectosAsignados) {
		super(username, nombre, correo, contrasena, calendario, null, equipo, listaDeTareas);
		this.setProyectosAsignados(proyectosAsignados);
	}
	
	public Jefe() {this("", "", "", "", null, null, null, null);}

	public ArrayList<Proyecto> getProyectosAsignados() {
		return proyectosAsignados;
	}

	public void setProyectosAsignados(ArrayList<Proyecto> proyectosAsignados) {
		this.proyectosAsignados = proyectosAsignados;
	}
	
	public void asignarEquipos(Proyecto proyecto, Equipo equipo) {
		//proyecto.equipo = equipo;
	}
	
	public void asignarProyectos(Proyecto proyecto, Equipo equipo) {
		//equipo.proyecto = proyecto;
	}
	
	public void asignarTareas(ArrayList<Tarea> listaTareas, Proyecto proyecto) {
		//proyecto.listaTareas = listaTareas;
	}
	
	public void revisarEstadoTareas() {
		for (Tarea t: listaDeTareas) {
			//System.out.println("La tarea " + t.nombreTarea + "está " + t.estado);
		}
	}	
}
