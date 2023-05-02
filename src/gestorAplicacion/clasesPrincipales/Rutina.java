package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
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

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
    
    public int retNumEje() {return this.NUMEJERCIOS;}
    
    
}
