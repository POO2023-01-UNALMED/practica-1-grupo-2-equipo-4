package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import gestorAplicacion.clasesHerencia.*;


import java.io.Serializable;
import java.util.ArrayList;

public class Cliente extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;

	private double altura;
	private double peso;
	private String sexo;
	private int edad;
	private Entrenador entrenador;
	private PreferenciaAlimenticia preferenciaAlimenticia;
	private NivelCliente nivelCliente;

	
	private PlanAlimentacion planAlimentacion;
	private Plan planEjercicio;
	private ObjetivoCliente objetivoCliente
	
	public ArrayList<PlanAlimentacion> historicoPlanesAlimentacion = new ArrayList<>();
	public ArrayList<PlanEjercicio> historicoPlanesEjercicio = new ArrayList<>();
	
	public static ArrayList<Cliente> listaClientes = new ArrayList<>();
	
	public Cliente(String nombre, int identificacion,
			double altura, double peso, String sexo, int edad, Entrenador entrenador, PreferenciaAlimenticia preferenciaAlimenticia,
			NivelCliente nivelCliente, ObjetivoCliente objetivoCliente) {
		super(nombre, identificacion);
		
		this.setAltura(altura);
		this.setPeso(peso);
		this.setSexo(sexo);
		this.setEdad(edad);
		this.setEntrenador(entrenador);
		this.setPreferenciaAlimenticia(preferenciaAlimenticia);
		this.setNivelCliente(nivelCliente);
		this.setObjetivoCliente(objetivoCliente);
		
		listaClientes.add(this);
	}

	public Cliente (String nombre, int identificacion, Gimnasio gimnasio,
	double altura, double peso, String sexo, int edad, Entrenador entrenador, PreferenciaAlimenticia preferenciaAlimenticia,
	NivelCliente nivelCliente, ObjetivoCliente objetivoCliente){
		this(nombre, identificacion, altura, peso, sexo, edad, entrenador, preferenciaAlimenticia, nivelCliente, objetivoCliente);
		this.gimnasio = gimnasio;

		gimnasio.agregarCliente(this);
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
	
	public PlanAlimentacion asignarPlan(PlanAlimentacion planAlimentacion) {
		this.planAlimentacion = planAlimentacion;
		
		if (this.historicoPlanesAlimentacion.isEmpty()) {
			this.historicoPlanesAlimentacion.add(planAlimentacion);
		}
		
		else { // Muestra el plan anterior y se recomienda seguir con este plan e ir 
			// Cambiando gradualmente las comidas hasta seguir el nuevo plan
			this.historicoPlanesAlimentacion.add(planAlimentacion);
			
			PlanAlimentacion planAnterior = historicoPlanesAlimentacion.get(historicoPlanesAlimentacion.indexOf(planAlimentacion) - 1);
			return planAnterior;
		}
		return null;
	}
	
	
	public static void generarPlanAlimentacion() {}

	public String generarPlanEjercicio(){
		PlanEjercicio plan = new PlanEjercicio();	
		plan.setDificultad(getNivelCliente());
		setPlanEjercicio(plan.crearPLanSemanal(getObjetivoCliente()));
		return getPlanEjercicio().toString();
	}
}
