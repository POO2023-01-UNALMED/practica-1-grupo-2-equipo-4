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
}
