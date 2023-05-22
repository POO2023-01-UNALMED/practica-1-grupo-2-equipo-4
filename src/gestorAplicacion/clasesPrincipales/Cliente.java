package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import gestorAplicacion.clasesHerencia.Persona;
import gestorAplicacion.clasesHerencia.Plan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	private double altura;
	private double peso;
	private String sexo;
	private int edad;
	private Entrenador entrenador;
	private PreferenciaAlimenticia preferenciaAlimenticia;
	private NivelCliente nivelCliente;
	private ObjetivoCliente objetivoCliente;
	public PlanAlimentacion planAlimentacion;
	public Plan planEjercicio;
	private Historial historialPlanes;
	
	public static ArrayList<Cliente> listaClientes = new ArrayList<>();
	
	public Cliente(String nombre, Gimnasio gimnasio, int identificacion,
			double altura, double peso, String sexo, int edad, Entrenador entrenador, PreferenciaAlimenticia preferenciaAlimenticia,
			NivelCliente nivelCliente, ObjetivoCliente objetivoCliente) {
		super(nombre, gimnasio, identificacion);
		
		this.setAltura(altura);
		this.setPeso(peso);
		this.setSexo(sexo);
		this.setEdad(edad);
		this.setEntrenador(entrenador);
		this.setPreferenciaAlimenticia(preferenciaAlimenticia);
		this.setNivelCliente(nivelCliente);
		this.setObjetivoCliente(objetivoCliente);
		
		this.gimnasio.agregarCliente(this);
		listaClientes.add(this);
	}
	

	public void setPlanEjercicio (Plan planEjercicio) {
		this.planEjercicio = planEjercicio;
	}
	
	public Plan getPlanEjercicio() {
		return planEjercicio;
	}
	
	
	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public PreferenciaAlimenticia getPreferenciaAlimenticia() {
		return preferenciaAlimenticia;
	}

	public void setPreferenciaAlimenticia(PreferenciaAlimenticia preferenciaAlimenticia) {
		this.preferenciaAlimenticia = preferenciaAlimenticia;
	}

	public NivelCliente getNivelCliente() {
		return nivelCliente;
	}

	public void setNivelCliente(NivelCliente nivelCliente) {
		this.nivelCliente = nivelCliente;
	}

	public ObjetivoCliente getObjetivoCliente() {
		return objetivoCliente;
	}

	public void setObjetivoCliente(ObjetivoCliente objetivoCliente) {
		this.objetivoCliente = objetivoCliente;
	}
	
	public Historial getHistorialPlanes() {
		return historialPlanes;
	}

	public void setHistorialPlanes(Historial historialPlanes) {
		this.historialPlanes = historialPlanes;
	}

	public String toString() {return "Nombre: " + this.getNombre()
	+ "Gimnasio: " + this.gimnasio.toString()
	+ "Nivel: " + this.getNivelCliente()
	+ "Entrenador: " + this.getEntrenador().getNombre()
	+ "Plan Alimentacion: " + this.planAlimentacion.getNombrePlan();
	}
	
	public void asignarEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
		entrenador.setCliente(this);
		
		this.entrenador.setDisponibilidad("NO DISPONIBLE");
	}
	
	public void asignarPlan(PlanAlimentacion planAlimentacion) {
		this.planAlimentacion = planAlimentacion;
		
		if (this.historialPlanes == null) { 
			// Si no había tenido un historial se lo creo y agrego el nuevo plan de alimentación.
			Historial historialParaPlanesAlimentacion = new Historial(this);
			this.setHistorialPlanes(historialParaPlanesAlimentacion); 
			this.historialPlanes.agregarPlanAlimentacion(planAlimentacion);
		}
		
		else {
			this.historialPlanes.agregarPlanAlimentacion(planAlimentacion);
		}
	}
	
	
	public static void generarPlanAlimentacion() {}

	public String generarPlanEjercicio(){
		PlanEjercicio plan = new PlanEjercicio();	
		plan.setDificultad(getNivelCliente());
		setPlanEjercicio(plan.crearPLanSemanal(getObjetivoCliente()));
		return getPlanEjercicio().toString();
	}
}
