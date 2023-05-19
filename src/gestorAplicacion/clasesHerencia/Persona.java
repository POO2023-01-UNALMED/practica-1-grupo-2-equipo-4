package gestorAplicacion.clasesHerencia;
import java.io.Serializable;

import gestorAplicacion.clasesPrincipales.*;
import java.io.Serializable;


public abstract class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
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
		return identificacion;
	}
	
	public Gimnasio getGimnasio() {
		return gimnasio;
	}
	
	public Persona() {this(null, null, 0);}
	
	@Override
	public abstract String toString();
}
