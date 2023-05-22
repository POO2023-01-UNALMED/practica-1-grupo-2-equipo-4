package gestorAplicacion.clasesHerencia;
import gestorAplicacion.clasesPrincipales.*;
import gestorAplicacion.clasesEnum.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Movimiento implements Serializable {
	private static final long serialVersionUID = 1L; 

	protected String nombre;
	protected String descripcion;
	protected String musculoPrincipal;
	protected TipoEjercicio tipoEjercicio;
	protected Maquina maquina;
	protected NivelCliente dificultad;
	protected boolean completado;
	public static ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>(); 
	
	public Movimiento(String nombre, String descripcion, String musculoPrincipal, TipoEjercicio tipoEjercicio, Maquina maquina, NivelCliente dificultad, boolean ejercicio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.musculoPrincipal = musculoPrincipal;
        this.tipoEjercicio = tipoEjercicio;
        this.completado = false;
        this.maquina = maquina;
        this.dificultad = dificultad;

        this.maquina.setMovimientoRealizado(this);

		if (ejercicio == true){
			listaMovimientos.add(this);
		}	
    }

	public Movimiento(String nombre, String descripcion, String musculoPrincipal, TipoEjercicio tipoEjercicio, Maquina maquina, NivelCliente dificultad) {
        this(nombre, descripcion, musculoPrincipal, tipoEjercicio, maquina, dificultad,true);
        
        this.maquina.setMovimientoRealizado(this);
    }

	public Movimiento(String nombre, String descripcion, String musculoPrincipal, TipoEjercicio tipoEjercicio, Maquina maquina) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.musculoPrincipal = musculoPrincipal;
        this.tipoEjercicio = tipoEjercicio;
        this.completado = false;
        this.maquina = maquina;
        
        this.maquina.setMovimientoRealizado(this);

		listaMovimientos.add(this);
    }
	
	
	public static ArrayList<Movimiento> filtrarMovimientosPorTipo(TipoEjercicio tipoEjercicio) {
		
		ArrayList<Movimiento> movimientosFiltrados = new ArrayList<Movimiento>();
		
		for (Movimiento movimiento : listaMovimientos){
			if (movimiento.getTipoEjercicio() == tipoEjercicio) {
				movimientosFiltrados.add(movimiento);
			}
		}
		return movimientosFiltrados;
	}

	public static ArrayList<Movimiento> filtrarMovimientosPorDificultad(ArrayList<Movimiento> movimientosPorTipo, NivelCliente dificultad){
		ArrayList<Movimiento> movimientosFiltrados = new ArrayList<Movimiento>();
	
		for (Movimiento movimiento : movimientosPorTipo){
			
			if (movimiento.getDificultad() == dificultad) {
				movimientosFiltrados.add(movimiento);
			}
		}
		return movimientosFiltrados;
	}
	
	public void setNombre(String nombre) {
	    this.nombre = nombre;
	}
	public String getNombre() {
	    return nombre;
	}

	public void setDificultad (NivelCliente dificultad) {
		this.dificultad = dificultad;
	}
	public NivelCliente getDificultad() {
		return dificultad;
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

	public void setListaMovimientos(ArrayList<Movimiento> listaMovimientos){
		Movimiento.listaMovimientos = listaMovimientos;
	}
	public ArrayList<Movimiento> getListaMovimientos(){
		return Movimiento.listaMovimientos;
	}
}
