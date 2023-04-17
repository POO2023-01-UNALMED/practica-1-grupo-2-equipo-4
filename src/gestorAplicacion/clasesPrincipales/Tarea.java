package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesHerencia.*;
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
	public void setEstado (TipoEstado estado) {
		this.estado = estado;}
	public void setFechaInicio (LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;}
	public void setNombreTarea (String nombreTarea) {
		this.nombreTarea = nombreTarea;}
	public void setFechaEntrega (LocalDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;}
	public void setDuracion (LocalTime duracion) {
		this.duracion = duracion;}
	public void setPrioridad (TipoPrioridad prioridad) {
		this.prioridad = prioridad;}
	public void setDescripcionTarea (String descripcionTarea) {
		this.descripcionTarea = descripcionTarea;}
	
	public TipoEstado getEstado() {
		return estado;}
	public LocalDateTime getFechaInicio() {
		return fechaInicio;}
	public String getNombreTarea() {
		return nombreTarea;}
	public LocalDateTime getFechaEntrega() {
		return fechaEntrega;}
	public LocalTime getDuracion() {
		return duracion;}
	public TipoPrioridad getPrioridad() {
		return prioridad;}
	public String getDescripcionTarea() {
		return descripcionTarea;}
	
	
}