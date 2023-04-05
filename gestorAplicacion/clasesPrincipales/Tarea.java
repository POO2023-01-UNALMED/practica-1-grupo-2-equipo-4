package clasesPrincipales;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Tarea {
	String nombreTarea;
	String descripcionTarea;
	LocalDateTime fechaInicio;
	LocalDateTime fechaEntrega;
	LocalTime duracion;
	TipoEstado estado;
	TipoPrioridad prioridad;
	public static int numTareas; // se puede agregar: numTareasActivas y numTareasTerminadas
	public Tarea(String nombreTarea, String descripcionTarea, LocalDateTime fechaInicio, LocalDateTime fechaEntrega, LocalTime duracion,
			TipoEstado estado, TipoPrioridad prioridad) {
		this.nombreTarea = nombreTarea;
		this.descripcionTarea = descripcionTarea;
		this.fechaInicio = fechaInicio;
		this.fechaEntrega = fechaEntrega;
		this.duracion = duracion;
		this.estado = estado;
		this.prioridad = prioridad;
		numTareas++;
		
	}
	
}