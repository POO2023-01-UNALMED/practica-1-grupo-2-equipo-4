package gestorAplicacion.clasesPrincipales;
import java.util.ArrayList;
import java.io.Serializable;
import gestorAplicacion.clasesEnum.*;

public class Gimnasio implements Serializable {
	private static final long serialVersionUID = 1L; 
	private String nombre;
	private String ciudad;
	private String sede;
	private boolean abierto; // Si el gimnasio está abierto o cerrado Hoy.
	
	private ArrayList<Maquina> listaMaquinas = new ArrayList<>();
	private ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();
	private ArrayList<Cliente> listaClientes = new ArrayList<>();
	
	public static ArrayList<Gimnasio> listaGimnasios = new ArrayList<Gimnasio>();
	
	public Gimnasio(String nombre, String ciudad, String sede, boolean abierto) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.sede = sede;
		this.setAbierto(abierto);
		
		listaGimnasios.add(this);
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
 
	public boolean isAbierto() {
		return abierto;
	}

	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
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
	
	public void agregarEntrenador(Entrenador e) {listaEntrenadores.add(e);}
	
	public void agregarMaquina(Maquina m) {listaMaquinas.add(m);}
	
	public void agregarCliente(Cliente c) {listaClientes.add(c);}
	
	public boolean tieneEntrenadoresPrincipiante() {
		boolean b = false;
		
		for (Entrenador e : this.listaEntrenadores) {
			if (e.getNivelEntrenador() == NivelCliente.PRINCIPIANTE) {
				b = true;
				break;
			}
		}
		return b;
	}
	
	public boolean tieneEntrenadoresIntermedio() {
		boolean b = false;
		
		for (Entrenador e : this.listaEntrenadores) {
			if (e.getNivelEntrenador() == NivelCliente.INTERMEDIO) {
				b = true;
				break;
			}
		}
		return b;
	}
	
	public boolean tieneEntrenadoresAvanzado() {
		boolean b = false;
		
		for (Entrenador e : this.listaEntrenadores) {
			if (e.getNivelEntrenador() == NivelCliente.AVANZADO) {
				b = true;
				break;
			}
		}
		return b;
	}
	
	public String toString() {
		return this.nombre + " " + this.ciudad + " sede " + this.sede;
	}
	
	public ArrayList<Gimnasio> sedesDisponibles(ArrayList<Maquina> maquinas) {
		ArrayList<Gimnasio> sedesDisponibles = new ArrayList<>();
		
		for (Gimnasio g : listaGimnasios) {
			if (g.abierto) {
				if (g.listaMaquinas.containsAll(maquinas)) {
					sedesDisponibles.add(g);
				}
			}
		}
		return sedesDisponibles;
	}
}
