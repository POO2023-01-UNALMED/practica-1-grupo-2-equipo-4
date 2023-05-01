package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.Serializable;

public class Gimnasio implements Serializable {
	private static final long serialVersionUID = 1L; 
	private String nombre;
	private String ciudad;
	private String sede;
	
	private HashMap<DiaSemana, String> horario = new HashMap<DiaSemana, String>(); // String es horaInicio-horaFin en formato Militar.
	private ArrayList<Maquina> listaMaquinas;
	private ArrayList<Entrenador> listaEntrenadores;
	private ArrayList<Cliente> listaClientes;
	private ArrayList<Gimnasio> listaGimnasios = new ArrayList<Gimnasio>();
	
	public void setNombre(String nombre) {
	    this.nombre = nombre;
	  }

	public String getNombre() {
	    return this.nombre;
	  }
	
	public void setCiudad(String ciudad) {
	    this.ciudad = ciudad;
	  }
	
	public String getCiudad() {
	    return this.ciudad;
	  }
	
	public void setSede(String sede) {
	    this.sede = sede;
	  }
	
	public String getSede() {
	    return this.sede;
	  }

	public void setHorario(HashMap<DiaSemana, String> horario) {
	    this.horario = horario;
	  }
	
	public HashMap<DiaSemana, String> getHorario() {
	    return this.horario;
	  }  

	public void setListaMaquinas(ArrayList<Maquina> listaMaquinas) {
	    this.listaMaquinas = listaMaquinas;
	  }
	
	public ArrayList<Maquina> getListaMaquinas() {
	    return this.listaMaquinas;
	  }  

	public void setListaEntrenadores(ArrayList<Entrenador> listaEntrenadores) {
	    this.listaEntrenadores = listaEntrenadores;
	  }
	
	public ArrayList<Entrenador> getListaEntrenadores() {
	    return this.listaEntrenadores;
	  }	

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
	    this.listaClientes = listaClientes;
	  }
	
	public ArrayList<Cliente> getListaClientes() {
	    return this.listaClientes;
	  }	  

	public void setListaGimnasios(ArrayList<Gimnasio> listaGimnasios) {
	    this.listaGimnasios = listaGimnasios;
	  }
	
	public ArrayList<Gimnasio> getListaGimnasios() {
	    return this.listaGimnasios;
	  }	    
	
	public String toString() {
		return this.nombre + this.ciudad + " sede " + this.sede;
	}
	
	public static void sedesDisponibles() {
		
	}
}
