package clasesPrincipales;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Calendario {
	Tarea[] eventos;
	LocalDateTime[] objetivos;
	public Calendario (Tarea[] eventos,LocalDateTime[] objetivos) {
		this.eventos = eventos;
		this.objetivos = objetivos;
	}
	public void setObjetivos (LocalDateTime[] objetivos) {
		this.objetivos = objetivos;}
	public void setEventos (Tarea[] eventos) {
		this.eventos = eventos;}

	public LocalDateTime[] getObjetivos() {
		return objetivos;}
	public Tarea[] getEventos() {
		return eventos;}
}
