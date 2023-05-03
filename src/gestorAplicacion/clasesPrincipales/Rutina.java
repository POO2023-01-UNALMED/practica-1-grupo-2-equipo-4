package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import gestorAplicacion.clasesHerencia.Movimiento;
import java.util.Random;

import java.io.Serializable;
import java.util.ArrayList;

public class Rutina implements Serializable{
    private static final long serialVersionUID = 1L;
	private String nombre;

    public Rutina(String nombre) {this.setNombre(nombre);}

    private ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
    private TipoEjercicio tipoEjercicio;
    private final int NUMEJERCIOS = 7; // abierto a discusión

    public Rutina(String nombre, ArrayList<Ejercicio> ejercicios, TipoEjercicio tipoEjercicio){
        this.nombre = nombre;
    	this.ejercicios = ejercicios;
        this.tipoEjercicio = tipoEjercicio;
    }
    public Rutina(ArrayList<Ejercicio> ejercicios, TipoEjercicio tipoEjercicio){
    	this.ejercicios = ejercicios;
        this.tipoEjercicio = tipoEjercicio;
    }

    
    public static Rutina generarRutina(TipoEjercicio tipoEjercicio, ObjetivoCliente objetivo, NivelCliente dificultad){
        ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
        ArrayList<Movimiento> movimientosDisponibles = Movimiento.filtrarMovimientosPorDificultad(Movimiento.filtrarMovimientosPorTipo(tipoEjercicio), dificultad);
        Random random = new Random();

        ArrayList<Movimiento> movCalentamiento = Movimiento.filtrarMovimientosPorTipo(TipoEjercicio.CALENTAMIENTO);
        ArrayList<Movimiento> movEstiramiento = Movimiento.filtrarMovimientosPorTipo(TipoEjercicio.ESTIRAMIENTO);

        ejercicios.add(Ejercicio.generarEjercicio(movCalentamiento.get(random.nextInt(movCalentamiento.size())), objetivo ));
        
        for (int i = 0; i < movimientosDisponibles.size(); i++){
            if (i>5){
                break;
            }else {
                ejercicios.add(Ejercicio.generarEjercicio(movimientosDisponibles.get(i), objetivo));
            }
        }
        ejercicios.add(Ejercicio.generarEjercicio(movEstiramiento.get(random.nextInt(movEstiramiento.size())), objetivo ));
        
        return new Rutina(ejercicios, tipoEjercicio);
    }
	

	//Metodos get y set
    public void setEjercicios (ArrayList<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;}
    public void setTipoEjercicio (TipoEjercicio tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;}
    public void setNombre(String nombre) {
		this.nombre = nombre;}
    
    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;}
    public TipoEjercicio getTipoEjercicio() {
        return tipoEjercicio;}
    public String getNombre() {
		return nombre;}
    
    public int retNumEje() {return this.NUMEJERCIOS;}
    
    
}
