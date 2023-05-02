package gestorAplicacion.clasesHerencia;
import gestorAplicacion.clasesPrincipales.*;
import gestorAplicacion.clasesEnum.*;
import java.io.Serializable;

public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L; 
	protected String nombre;
	protected String descripcion;
	protected String musculoPrincipal;
	protected TipoEjercicio tipoEjercicio;
	protected Maquina maquina;
	protected boolean completado;
	
	public Movimiento(String nombre, String descripcion, String musculoPrincipal, TipoEjercicio tipoEjercicio, Maquina maquina) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.musculoPrincipal = musculoPrincipal;
        this.tipoEjercicio = tipoEjercicio;
        this.completado = false;
        this.maquina = maquina;
        
        this.maquina.setMovimientoRealizado(this);
    }
	
	public static void filtrarMovimientosPorTipo() {

	}
	
	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}
	public String getNombre() {
	    return nombre;
	}

	public void setDescripcion(String descripcion) {
	    this.descripcion = descripcion;
	}
	public String getDescripcion() {
	    return descripcion;
	}

	public void setMusculoPrincipal(String musculoPrincipal) {
	    this.musculoPrincipal = musculoPrincipal;
	}
	public String getMusculoPrincipal() {
	    return musculoPrincipal;
	}

	public void setMaquina(Maquina maquina) {
	    this.maquina = maquina;
	}
	public Maquina getMaquina() {
	    return maquina;
	}
	
	public TipoEjercicio getTipoEjercicio() {return this.tipoEjercicio;}
	
	public void setCompletado(boolean completado) {
	    this.completado = completado;
	}

	public boolean isCompletado() {
	    return completado;
	}
}
