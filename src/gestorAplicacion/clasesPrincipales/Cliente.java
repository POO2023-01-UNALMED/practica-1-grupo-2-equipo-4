package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import gestorAplicacion.clasesHerencia.Persona;
import gestorAplicacion.clasesHerencia.Plan;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Autores: Esteban Vásquez Pérez.

//Finalidad de la clase: 
//La clase cliente representa una de las Personas que está asistiendo a nuestros Gimnasios
//El cliente es el usuario principal de la aplicación. 
//Tiene acceso a todas las funcionalidades a través de su número de identificación.

//Estructuras de datos:
//Utilizamos un ArrayList para guardar cada uno de los clientes

//Componentes:
//Atributos heredados de Persona: nombre, gimnasio, identificación.
//Atributos que describen el físico del cliente
//Un objeto de entrenador

//Una serie de descripciones del cliente que incluyen
//preferencia alimenticia (por ejemplo si es vegano)
//nivel cliente que puede ser (PRINCIPIANTE, INTERMEDIO, AVANZADO)
//Un objetivo particular del cliente (por ejemplo bajar de peso)
//un PlanAlimentacion que el cliente sigue en este momento.
//un Plan que va a representar el PlanEjercicio
//un Historial de planes que contiene
//historial de gimnasios visitados
//historial de planes de ejercicio y alimentación
//un historial que tiene los gimnasios que ha visitado y la cantidad de veces que ha ido.

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
	private PlanAlimentacion planAlimentacion;
	private Plan planEjercicio;
	private Historial historialPlanes;
	
	public static ArrayList<Cliente> listaClientes = new ArrayList<>();
	
	//Constructor 
	
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
		this.setPlanAlimentacion(planAlimentacion);
		this.setPlanEjercicio(planEjercicio);
		
		// Genera excepción de puntero nulo si no se usa el constructor ingresando un gimnasio.
		this.gimnasio.agregarCliente(this);
		listaClientes.add(this);
	}
	
	//Constructor por defecto
	
	public Cliente() {
		this(null, null, 0, 0, 0, null, 0, null, null, null, null);
	}
	
	//Métodos Set y Get
	
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
	
	public void setPlanAlimentacion (PlanAlimentacion planAlimentacion) {
		this.planAlimentacion = planAlimentacion;
	}
	
	public PlanAlimentacion getPlanAlimentacion() {
		return planAlimentacion;
	}
	
	public void setPlanEjercicio (Plan planEjercicio) {
		this.planEjercicio = planEjercicio;
	}
	
	public Plan getPlanEjercicio() {
		return planEjercicio;
	}
	
	public Historial getHistorialPlanes() {
		return historialPlanes;
	}

	public void setHistorialPlanes(Historial historialPlanes) {
		this.historialPlanes = historialPlanes;
	}
	
	// toString para mostrar información relevante sobre el cliente

	@Override
	public String toString() {return "Nombre: " 
	+ this.getNombre()
	+ "Gimnasio: " 
	+ this.gimnasio.toString()
	+ "Nivel: " 
	+ this.getNivelCliente()
	+ "Entrenador: " 
	+ this.getEntrenador().getNombre()
	+ "Plan Alimentacion: " 
	+ this.planAlimentacion.getNombrePlan();
	}
	
	public void asignarEntrenador(Entrenador entrenador) {
		// Tercer Método dentro de la primera funcionalidad. 
		// Es análogo al ejemplo del video en donde se asigna una silla a un Pasajero.
		// Se hace el cambio por referencia de la disponiblidad de un entrenador.
				
		this.entrenador = entrenador;
		entrenador.setCliente(this);
		
		this.entrenador.setDisponibilidad("NO DISPONIBLE");
		// Si se vuelve a llamar la funcionalidad, el mismo entrenador ya no estará disponible

	}
	
	public void asignarPlanAlimentacion(PlanAlimentacion planAlimentacion) {
		// Tercer método dentro de la segunda funcionalidad.
		// Sirve para que los planes de alimentación se vayan añadiendo 
		// a medida el cliente va cambiando de plan de alimentación
				
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
	
	public void asignarPlanEjercicio(PlanEjercicio planEjercicio) {
		
		this.planEjercicio = planEjercicio;
		
		if (this.historialPlanes == null) { 
			// Si no había tenido un historial se lo creo y agrego el nuevo plan de ejercicio.
			Historial historialParaPlanesEjercicio = new Historial(this);
			this.setHistorialPlanes(historialParaPlanesEjercicio); 
			this.historialPlanes.agregarPlanEjercicio(planEjercicio);
		}
		
		else {
			this.historialPlanes.agregarPlanEjercicio(planEjercicio);
		}
	}
	
	public String generarPlanEjercicio(){
		//Se crea un Plan de Ejercicio usando el método crearPlanSemanal
		
		PlanEjercicio plan = new PlanEjercicio();	
		plan.setDificultad(getNivelCliente());
		setPlanEjercicio(plan.crearPlanSemanal(getObjetivoCliente()));
		return getPlanEjercicio().toString();
	}
}
