package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesHerencia.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Proyecto {
	String nombreProyecto;
	LocalDateTime fechaInicio;
	LocalDateTime fechaEntrega;
	LocalTime duracion;
	Tarea[] listaTareas;
	TipoEstado estado;
	TipoPrioridad prioridad;
	Equipo equipo;
	
	public void setEstado (TipoEstado estado) {
		this.estado = estado;}
	public void setFechaInicio (LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;}
	public void setListaTareas (Tarea[] listaTareas) {
		this.listaTareas = listaTareas;}
	public void setEquipo (Equipo equipo) {
		this.equipo = equipo;}
	public void setFechaEntrega (LocalDateTime fechaEntrega) {
		this.fechaEntrega = fechaEntrega;}
	public void setNombreProyecto (String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;}
	public void setDuracion (LocalTime duracion) {
		this.duracion = duracion;}
	public void setPrioridad (TipoPrioridad prioridad) {
		this.prioridad = prioridad;}

	public TipoEstado getEstado() {
		return estado;}
	public LocalDateTime getFechaInicio() {
		return fechaInicio;}
	public Tarea[] getListaTareas() {
		return listaTareas;}
	public Equipo getEquipo() {
		return equipo;}
	public LocalDateTime getFechaEntrega() {
		return fechaEntrega;}
	public String getNombreProyecto() {
		return nombreProyecto;}
	public LocalTime getDuracion() {
		return duracion;}
	public TipoPrioridad getPrioridad() {
		return prioridad;}
	
}
