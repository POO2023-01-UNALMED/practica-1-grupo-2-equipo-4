package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesHerencia.*;
import gestorAplicacion.clasesEnum.*;
//import java.io.Serializable;

import java.util.Random;


public class Ejercicio extends Movimiento /*implements Serializable*/ {
	private static final long serialVersionUID = 1L;
	private int repeticiones;
	private int series;
	
	public Ejercicio(String nombre, String descripcion, String musculoPrincipal, TipoEjercicio tipoEjercicio, Maquina maquina, int repeticiones, int series, boolean ejercicio) {
		super(nombre, descripcion, musculoPrincipal, tipoEjercicio, maquina, null,  ejercicio);
		this.setRepeticiones(repeticiones);
		this.setSeries(series);
	}
	public Ejercicio(String nombre, String descripcion, String musculoPrincipal, TipoEjercicio tipoEjercicio, Maquina maquina, int repeticiones, int series, NivelCliente dificultad) {
		super(nombre, descripcion, musculoPrincipal, tipoEjercicio, maquina, dificultad);
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
	
	public static Ejercicio generarEjercicio(Movimiento movimiento, ObjetivoCliente objetivo) {
		int repeticiones = 0;
		int series = 0;
		Random random = new Random();

		if (movimiento.getTipoEjercicio() == TipoEjercicio.CALENTAMIENTO){
			repeticiones = 10 +random.nextInt(5);
			series = 1;
			movimiento.setDescripcion(movimiento.getDescripcion() + "	|Recuerda que los calentamientos están expresados en minutos");
		}else {
			switch(objetivo){
				case AUMENTAR:
					repeticiones = 8 + random.nextInt(4);
					series = 1 + random.nextInt(2);
					break;
				case DEFINIR:
					repeticiones = 14 + random.nextInt(3);
					series = 3 + random.nextInt(2);
					break;
				case BAJARPESO:
					repeticiones = 9 + random.nextInt(5);
					series = 2 + random.nextInt(2);
					break;
				case MANTENER:
					repeticiones = 11 + random.nextInt(2);
					series = 2 + random.nextInt(2);
					break;
				case ACONDICIONAR:
					repeticiones = 7 + random.nextInt(3);
					series = 4 + random.nextInt(2);
					break;
				
			}
		}
		return new Ejercicio(movimiento.getNombre(), movimiento.getDescripcion(), movimiento.getMusculoPrincipal(), movimiento.getTipoEjercicio(), movimiento.getMaquina(), repeticiones, series, false);
	}
}
