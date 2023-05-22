package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesHerencia.*;
import java.io.Serializable;

public class Maquina implements Serializable {
	private static final long serialVersionUID = 1L; 
	private String nombre;
	private Gimnasio gimnasio;
	private Movimiento movimientoRealizado;
	
	public Maquina(String nombre, Gimnasio gimnasio) {
		this.nombre = nombre;
        this.gimnasio = gimnasio;
        
        this.gimnasio.agregarMaquina(this);
    }
	
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
