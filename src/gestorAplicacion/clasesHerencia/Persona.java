package gestorAplicacion.clasesHerencia;
import gestorAplicacion.clasesPrincipales.*;

public abstract class Persona {
	protected String nombre;
	protected Gimnasio gimnasio;
	protected int identificacion;
	
	public Persona(String nombre, Gimnasio gimnasio, int identificacion) {
		this.nombre = nombre;
		this.gimnasio = gimnasio;
		this.identificacion = identificacion;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getIdentificacion() {
		return this.identificacion;
	}
	
	public Gimnasio getGimnasio() {
		return this.gimnasio;
	}
	
	public Persona() {this(null, null, 0);}
	
	@Override
	public abstract String toString();
}
