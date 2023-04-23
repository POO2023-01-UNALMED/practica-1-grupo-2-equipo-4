package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesHerencia.Persona;
import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;

public class Entrenador extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	private String formacion;
	private Cliente cliente;
	private NivelCliente nivelEntrenador;
	private HashMap<String, String> disponibilidad;
	
	public static ArrayList<Entrenador> listaEntrenadores;
	
	public Entrenador(String nombre, Gimnasio gimnasio, int identificacion, 
						String formacion, Cliente cliente, NivelCliente nivelEntrenador, 
						HashMap<String, String> disponibilidad) {
		super(nombre, gimnasio, identificacion);
		this.setFormacion(formacion);
		this.setCliente(cliente);
		this.setNivelEntrenador(nivelEntrenador);
		this.setDisponibilidad(disponibilidad);
		
		listaEntrenadores.add(this);
	}
	
	public Entrenador() {this(null, null, 0, null, null, null, null);}
	
	
	public String getFormacion() {
		return formacion;
	}

	public void setFormacion(String formacion) {
		this.formacion = formacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public NivelCliente getNivelEntrenador() {
		return nivelEntrenador;
	}

	public void setNivelEntrenador(NivelCliente nivelEntrenador) {
		this.nivelEntrenador = nivelEntrenador;
	}

	public HashMap<String, String> getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(HashMap<String, String> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String toString() {return "Nombre: " + this.getNombre()
			+ "Gimnasio: " + this.gimnasio.toString()
			+ "Nivel: " + this.getNivelEntrenador()
			+ "Cliente: " + this.getCliente().getNombre()
			+ "Disponibilidad: " + this.getDisponibilidad();}
	
	public static void entrenadoresDisponibles() {};
}
