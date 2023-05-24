package gestorAplicacion.clasesHerencia;
import gestorAplicacion.clasesPrincipales.*;
import gestorAplicacion.clasesEnum.*;
import java.io.Serializable;
import java.util.ArrayList;

//Autores: Juan Manuel Rodríguez Sánchez, Jacobo Ochoa Ramirez.

//Finalidad de la clase: 
//La clase Movimiento sirve para representar una acción física que se hace al entrenar.
//La clase Movimiento además sirve para ser Padre de la Clase ejercicio.
//Un ejercicio es un tipo de Movimiento, pero la diferencia es que el ejercicio tiene unas
//repeticiones y unas series.

//Estructuras de datos:
//Utilizamos un ArrayList para guardar cada uno de los movimientos

//Componentes:
//Atributos básicos que describen el movimiento. 
//Un atributo de completado si el movimiento ya se hizo.
//Una máquina que DEBE SER ASIGNADA en el momento de crear un movimiento.

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

        // Arroja excepción si no se asigna una máquina dentro del constructor.
        this.maquina.setMovimientoRealizado(this);

		if (ejercicio == true){
			// Siempre se agrega a la lista de movimientos
			listaMovimientos.add(this);
		}	
    }
	
	public Movimiento(String nombre, TipoEjercicio tipoEjercicio, Maquina maquina, NivelCliente dificultad) {
		// Caso de sobrecarga si solo se da nombre, tipoEjercicio, maquina y dificultad.
		
		this(nombre, null, null, tipoEjercicio, maquina, dificultad,true);
    }
	
	public Movimiento(String nombre, String descripcion, String musculoPrincipal, TipoEjercicio tipoEjercicio, Maquina maquina, NivelCliente dificultad) {
		// Caso de sobrecarga
		
		this(nombre, descripcion, musculoPrincipal, tipoEjercicio, maquina, dificultad,true);
    }

	public Movimiento(String nombre, String descripcion, String musculoPrincipal, TipoEjercicio tipoEjercicio, Maquina maquina) {
		// Caso de sobrecarga
		
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
		// Se encarga de recibir un tipoEjercicio que ingresa el cliente
		// Por ejemplo TipoEjercicio.CALENTAMIENTO.
		// Luego filtra todos los movimientos dentro de mi lista que tienen este tipo
			
		ArrayList<Movimiento> movimientosFiltrados = new ArrayList<Movimiento>();
		
		for (Movimiento movimiento : listaMovimientos){
			if (movimiento.getTipoEjercicio() == tipoEjercicio) {
				movimientosFiltrados.add(movimiento);
			}
		}
		return movimientosFiltrados;
	}

	public static ArrayList<Movimiento> filtrarMovimientosPorDificultad(ArrayList<Movimiento> movimientosPorTipo, NivelCliente dificultad){
		// Se encarga de recibir una lista de movimientos
		// Sobre esta lista hace un filtro de dificultad y retorna 
		// únicamente los movimientos de esta lista que tienen la dificultad deseada.
		
		ArrayList<Movimiento> movimientosFiltrados = new ArrayList<Movimiento>();
	
		for (Movimiento movimiento : movimientosPorTipo){
			
			if (movimiento.getDificultad() == dificultad) {
				movimientosFiltrados.add(movimiento);
			}
		}
		return movimientosFiltrados;
	}
	
	//Métodos Set y Get
	
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
