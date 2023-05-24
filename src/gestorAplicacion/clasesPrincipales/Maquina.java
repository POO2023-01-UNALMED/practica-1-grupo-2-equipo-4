package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesHerencia.*;
import java.io.Serializable;

//Autores: Juan Manuel Rodríguez Sánchez.

//Finalidad de la clase: 
//La clase Comida sirve para almacenar listas de alimentos que componen
//una de las tres comidas diarias.

//Estructuras de datos:
//Utilizamos un ArrayList para guardar la lista de alimentos

//Componentes:

//Unos atributos de nombre, TipoComida, PreferenciaAlimenticia y ObjetivoCliente
//que describen el tipo de la comida

//Unos atributos de Macronutrientes que se calculan con un método que mostraremos más adelante
//Una lista estática de todas las comidas que se van creando

public class Maquina implements Serializable {
	private static final long serialVersionUID = 1L; 
	private String nombre;
	private Gimnasio gimnasio;
	private Movimiento movimientoRealizado;
	
	//Constructor 
	
	public Maquina(String nombre, Gimnasio gimnasio) {
		this.nombre = nombre;
        this.gimnasio = gimnasio;
        
        this.gimnasio.agregarMaquina(this);
    }
	
	//Métodos Set y Get
	
	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}

	public String getNombre() {
	    return nombre;
	}

	public void setGimnasio(Gimnasio gimnasio) {
	    this.gimnasio = gimnasio;
	}

	public Gimnasio getGimnasio() {
	    return gimnasio;
	}

	public void setMovimientoRealizado(Movimiento movimientoRealizado) {
	    this.movimientoRealizado = movimientoRealizado;
	}

	public Movimiento getMovimientoRealizado() {
	    return movimientoRealizado;
	}
}
