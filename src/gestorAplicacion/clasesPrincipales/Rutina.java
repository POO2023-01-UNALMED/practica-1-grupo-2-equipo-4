package gestorAplicacion.clasesPrincipales;

import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.clasesHerencia.Movimiento;

public class Rutina implements Serializable{
    private static final long serialVersionUID = 1L;
	String name;

    public Rutina(String name) {this.name = name;}

    private ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
    private TipoEjercicio tipoEjercicio;
    private final int NUMEJERCIOS = 7; // abierto a discusión

    public Rutina(ArrayList<Ejercicio> ejercicios, TipoEjercicio tipoEjercicio){
        this.ejercicios = ejercicios;
        this.tipoEjercicio = tipoEjercicio;
    }



    //Metodos get y set
    public void setEjercicios (ArrayList<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;}
    public void setTipoEjercicio (TipoEjercicio tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;}
    
    public ArrayList<Ejercicio> getEjercicios() {
        return ejercicios;}
    public TipoEjercicio getTipoEjercicio() {
        return tipoEjercicio;}
    
    
}
