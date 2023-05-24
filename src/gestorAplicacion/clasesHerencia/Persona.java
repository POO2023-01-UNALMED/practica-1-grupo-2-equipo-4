package gestorAplicacion.clasesHerencia;
import java.io.Serializable;

import gestorAplicacion.clasesPrincipales.*;

//Autores: Esteban Vásquez Pérez

//Finalidad de la clase: 
//La clase abstracta persona sirve como un modelo para heredar atributos a las clases
//Entrenador y Cliente. Es una clase sencilla que implementa atributos de nombre, identificación
//y Gimnasio en el que entrena.

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
	
	//Métodos Set y Get
	
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
