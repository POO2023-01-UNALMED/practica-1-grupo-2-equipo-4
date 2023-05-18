package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import gestorAplicacion.clasesHerencia.Persona;
import java.io.Serializable;
import java.util.ArrayList;

public class Entrenador extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	private String formacion;
	private Cliente cliente;
	private NivelCliente nivelEntrenador;
	private String disponibilidad; // MAÑANA/TARDE/NO DISPONIBLE
	
	public static ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();
	
	public Entrenador(String nombre, Gimnasio gimnasio, int identificacion, 
						String formacion, Cliente cliente, NivelCliente nivelEntrenador, 
						String disponibilidad) {
		super(nombre, gimnasio, identificacion);
		
		this.setFormacion(formacion);
		this.setCliente(cliente);
		this.setNivelEntrenador(nivelEntrenador);
		this.setDisponibilidad(disponibilidad);
		
		this.gimnasio.agregarEntrenador(this);
		listaEntrenadores.add(this);
	}
	
<<<<<<< Updated upstream
	public Entrenador() {this(null, null, 0, null, null, null, null);}
	
	
=======
>>>>>>> Stashed changes
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

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String toString() {return "Nombre: " + this.getNombre()
			+ "Gimnasio: " + this.gimnasio.toString()
			+ "Nivel: " + this.getNivelEntrenador()
			+ "Cliente: " + this.getCliente().getNombre()
			+ "Disponibilidad: " + this.getDisponibilidad();}
	
	public Entrenador entrenadoresDisponibles(String horarioAsistencia, String intensidad) {
		Entrenador entrenadorDisponible = null;
		
		if (this.nivelEntrenador.name().equals(intensidad)) { // Filtro por intensidad y Nivel.
			if (this.disponibilidad.equals(horarioAsistencia)) {
				entrenadorDisponible = this;
			}
		}
		return entrenadorDisponible;
	}
}
