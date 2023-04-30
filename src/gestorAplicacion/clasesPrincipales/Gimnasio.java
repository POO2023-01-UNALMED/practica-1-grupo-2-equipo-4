package gestorAplicacion.clasesPrincipales;

import java.io.Serializable;

public class Gimnasio implements Serializable {
	private static final long serialVersionUID = 1L; 
	private String nombre;
	private String ciudad;
	private String sede;
	private HashMap<String, String> horario = new HashMap<String, String>();
	private Maquina[] listaMaquinas;
	private Entrenador[] listaEntrenadores;
	private Cliente[] listaClientes;
	private ArrayList<Gimnasio> listaGimnasios = new ArrayList<Gimnasio>();
	
	public static sedesDisponibles {
		
	}
	
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

	public void setHorario(HashMap<String, String> horario) {
	    this.horario = horario;
	  }
	
	public String getHorario() {
	    return this.horario;
	  }  

	public void setListaMaquinas(Maquina[] listaMaquinas) {
	    this.listaMaquinas = listaMaquinas;
	  }
	
	public String getListaMaquinas() {
	    return this.listaMaquinas;
	  }  

	public void setListaEntrenadores(Entrenador[] listaEntrenadores) {
	    this.listaEntrenadores = listaEntrenadores;
	  }
	
	public String getListaEntrenadores() {
	    return this.listaEntrenadores;
	  }	

	public void setListaClientes(Cliente[] listaClientes) {
	    this.listaClientes = listaClientes;
	  }
	
	public String getListaClientes() {
	    return this.listaClientes;
	  }	  

	public void setListaGimnasios(ArrayList<Gimnasio> listaGimnasios) {
	    this.listaGimnasios = listaGimnasios;
	  }
	
	public String getListaGimnasios() {
	    return this.listaGimnasios;
	  }	    
}
