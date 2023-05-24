package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import gestorAplicacion.clasesHerencia.Persona;
import gestorAplicacion.clasesHerencia.Plan;

import java.io.Serializable;
import java.util.ArrayList;

public class Entrenador extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	private int edad;
	private String formacion;
	private Cliente cliente;
	private NivelCliente nivelEntrenador;
	private String disponibilidad; // MAÑANA/TARDE/NO DISPONIBLE
	private ArrayList<Integer> calificaciones = new ArrayList<>();
	public double calificacionPromedio; 
	private PlanAlimentacion planAlimentacionRecomendado;
	private PlanEjercicio planEjercicioRecomendado;
	
	public static ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();
	
	public Entrenador(String nombre, Gimnasio gimnasio, int identificacion, int edad,
			String formacion, Cliente cliente, NivelCliente nivelEntrenador, String disponibilidad) {
		super(nombre, gimnasio, identificacion);

		this.setEdad(edad);
		this.setFormacion(formacion);
		this.setCliente(cliente);
		this.setNivelEntrenador(nivelEntrenador);
		this.setDisponibilidad(disponibilidad);
		
		this.calificaciones = this.generarListaCalificaciones();
		
		this.gimnasio.agregarEntrenador(this);
		listaEntrenadores.add(this);
	}
	
	public Entrenador() {
		this(null, null, 0, 0, null, null, null, null);
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

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
	
	public ArrayList<Integer> getCalificaciones() {
		return this.calificaciones;
	}

	public void setCalificaciones(ArrayList<Integer> calificaciones) {
	    this.calificaciones = calificaciones;
	}
	
	public PlanAlimentacion getPlanAlimentacionRecomendado() {
		return planAlimentacionRecomendado;
	}
	
	public void setPlanAlimentacionRecomendado (PlanAlimentacion planAlimentacionRecomendado) {
		this.planAlimentacionRecomendado = planAlimentacionRecomendado;
	}
	
	public PlanEjercicio getPlanEjercicioRecomendado() {
		return planEjercicioRecomendado;
	}
	
	public void setPlanEjercicioRecomendado (PlanEjercicio planEjercicioRecomendado) {
		this.planEjercicioRecomendado = planEjercicioRecomendado;
	}
	

	@Override
	public String toString() {return "Nombre: " + this.getNombre()
			+ "\nGimnasio: " + this.gimnasio.toString()
			+ "\nNivel: " + this.getNivelEntrenador()
			+ "\nCliente: " + this.getCliente().getNombre()
			+ "\nDisponibilidad: " + this.getDisponibilidad() + "\n";
	}
	
	public String descripcionHojaVida() {return this.getNombre() 
			+ "\nCalificacion Promedio: " + this.calificacionPromedio
			+ "\nEdad: " + this.getEdad()
			+ "\nFormacion: " + this.getFormacion()
			+ "\nNivel: " + this.getNivelEntrenador()
			+ "\nGimnasio: " + this.gimnasio.toString()
			+ "\nDisponibilidad: " + this.getDisponibilidad()
			+ "\n";
	}	

	public Entrenador entrenadoresDisponibles(String horarioAsistencia, String intensidad) {
		Entrenador entrenadorDisponible = null;
		
		if (this.nivelEntrenador.name().equals(intensidad)) { // Filtro por intensidad y Nivel.
			if (this.disponibilidad.equals(horarioAsistencia)) {
				entrenadorDisponible = this;
			}
		}
		return entrenadorDisponible;
	}
	
	public ArrayList<Integer> generarListaCalificaciones(){
		int limite = (int) (Math.random()*10);
		ArrayList<Integer> calificaciones= new ArrayList<Integer>();
		for (int i=10; i<10 + limite; i++) {
			int calificacion = (int) (Math.random()*5);
			calificaciones.add(calificacion);
		}
		return calificaciones;
	}
	
	public double calcularCalificacionPromedio(ArrayList<Integer> calificaciones) { // Calcula el promedio tomando las calificaciones (se califica de 1 a 5 solo con valores enteros)
		int suma = 0;
		for (Integer calificacion: calificaciones) {
			suma += calificacion;
		}

		double promedio = (double) suma / calificaciones.size();
		return calificacionPromedio = Math.round(promedio * 10.0) / 10.0;
	}

	public Entrenador filtroEntrenadores(Cliente cliente) {
		Entrenador entrenadorFiltrado = null;

		if (this.getNivelEntrenador().equals(cliente.getNivelCliente())) {
			if (Math.abs(this.getEdad() - cliente.getEdad()) <= 10) {
				if (cliente.getObjetivoCliente().name().equals("AUMENTAR") && this.getFormacion().toUpperCase().equals("MUSCULACION")) { 
					this.calcularCalificacionPromedio(this.getCalificaciones());	
					entrenadorFiltrado = this;
				}	
				if (cliente.getObjetivoCliente().name().equals("DEFINIR") && this.getFormacion().toUpperCase().equals("MUSCULACION")) {
					this.calcularCalificacionPromedio(this.getCalificaciones());	
					entrenadorFiltrado = this;
				}
				if (cliente.getObjetivoCliente().name().equals("BAJARPESO") && this.getFormacion().toUpperCase().equals("CARDIO")) {
					this.calcularCalificacionPromedio(this.getCalificaciones());	
					entrenadorFiltrado = this;
				}
				if (cliente.getObjetivoCliente().name().equals("MANTENER") && this.getFormacion().toUpperCase().equals("GIMNASIA")) {
					this.calcularCalificacionPromedio(this.getCalificaciones());	
					entrenadorFiltrado = this;
				}	
				if (cliente.getObjetivoCliente().name().equals("ACONDICIONAR") && this.getFormacion().toUpperCase().equals("CROSSFIT")) {
					this.calcularCalificacionPromedio(this.getCalificaciones());	
					entrenadorFiltrado = this;
				}	
			}							
		}
		return entrenadorFiltrado;
	}	
}