package clasesPrincipales;

import java.util.ArrayList;

import clasesHerencia.Usuario;

public class Empleado extends Usuario {
	private ArrayList<Jefe> jefes = new ArrayList<Jefe>();
	protected Equipo equipo;
	protected ArrayList<Tarea> listaDeTareas = new ArrayList<Tarea>();
	
	public Empleado(String username, String nombre, 
			String correo, String contrasena, Calendario calendario, 
			ArrayList<Jefe> jefes, Equipo equipo, ArrayList<Tarea> listaDeTareas) {
		super(username, nombre, correo, contrasena, calendario);
		this.setJefes(jefes);
		this.equipo = equipo;
		this.listaDeTareas = listaDeTareas;
	}
	
	public Empleado() {this("", "", "", "", null, null, null, null);}
	
	public ArrayList<Jefe> getJefes() {
		return jefes;
	}
	public void setJefes(ArrayList<Jefe> jefes) {
		this.jefes = jefes;
	}
	
	public void actualizarEstadoTarea(Tarea tarea, String estado) {
		//tarea.estado = estado;
	}
	
	public double calcularEficiencia() {
		double eficiencia = 0;
		int totalTareasCompletadas = 0;
		
		for (Tarea t : listaDeTareas) {
			double e = (t.tiempoEstimadoTarea / t.tiempoRealTarea) * t.dificultadTarea;
			eficiencia += e;
			
			if (t.estado == "completado") {totalTareasCompletadas ++;}
			
		}
		
		eficiencia = eficiencia / totalTareasCompletadas;
		return eficiencia;
	}
}

