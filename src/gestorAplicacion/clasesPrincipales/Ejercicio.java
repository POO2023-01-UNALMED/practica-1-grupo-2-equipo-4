package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesHerencia.*;
import gestorAplicacion.clasesEnum.*;
import java.io.Serializable;

public class Ejercicio extends Movimiento implements Serializable {
	private static final long serialVersionUID = 1L;
	private int repeticiones;
	private int series;
	
	public Ejercicio(String nombre, String descripcion, String musculoPrincipal, TipoEjercicio tipoEjercicio, Maquina maquina, int repeticiones, int series) {
		super(nombre, descripcion, musculoPrincipal, tipoEjercicio, maquina);
		this.setRepeticiones(repeticiones);
		this.setSeries(series);
	}

	public int getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}

	public int getSeries() {
		return series;
	}

	public void setSeries(int series) {
		this.series = series;
	}
	
	public static void generarEjercicio() {}
}
