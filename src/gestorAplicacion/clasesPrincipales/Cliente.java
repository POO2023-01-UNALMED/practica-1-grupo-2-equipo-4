package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesHerencia.Persona;
import java.io.Serializable;
import java.util.ArrayList;


public class Cliente extends Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	private double altura;
	private double peso;
	private String sexo;
	private int edad;
	private Entrenador entrenador;
	private Dieta preferenciaAlimenticia;
	private NivelCliente nivelCliente;
	private ObjetivoCliente objetivoCliente;
	public PlanAlimentacion planAlimentacion;
	public PlanEjercicio planEjercicio;
	
	public static ArrayList<Cliente> listaClientes;
	
	public Cliente(String nombre, Gimnasio gimnasio, int identificacion,
			double altura, double peso, String sexo, int edad, Entrenador entrenador, Dieta preferenciaAlimenticia,
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
		
		listaClientes.add(this);
	}
	
	public Cliente() {this(null, null, 0, 0, 0, null, 0, null, null, null, null);}

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

	public Dieta getPreferenciaAlimenticia() {
		return preferenciaAlimenticia;
	}

	public void setPreferenciaAlimenticia(Dieta preferenciaAlimenticia) {
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
	+ "Plan Alimentacion: " + this.planAlimentacion
	+ "Plan Ejercicio: " + this.planEjercicio;}
	
	public static void asignarCliente() {}
	
	public static void generarPlanAlimentacion() {}
}
