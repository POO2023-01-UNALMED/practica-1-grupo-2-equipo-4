package gestorAplicacion.clasesPrincipales;
import java.util.ArrayList;
import java.io.Serializable;
import gestorAplicacion.clasesEnum.*;

//Autores: Jacobo Ochoa Ramírez.

//Finalidad de la clase: 
//Esta clase sirve como una base de datos. 
//Se pueden hacer búsquedas complejas sobre los atributos de un gimnasio.

//Estructuras de datos:
//Tiene ArrayList para maquinas, entrenadores, clientes y un arraylist estático para los gimnasios. 

//Componentes:
//Cada gimnasio tiene un nombre, una ciudad y una sede.
//Contiene listas de máquinas, entrenadores y clientes del gimnasio.

public class Gimnasio implements Serializable {
	private static final long serialVersionUID = 1L; 
	private String nombre;
	private String ciudad;
	private String sede; // Por ejemplo Poblado, Robledo, etc...
	private boolean abierto; // Si el gimnasio está abierto o cerrado hoy.
	
	private ArrayList<Maquina> listaMaquinas = new ArrayList<>();
	private ArrayList<Entrenador> listaEntrenadores = new ArrayList<>();
	private ArrayList<Cliente> listaClientes = new ArrayList<>();
	
	public static ArrayList<Gimnasio> listaGimnasios = new ArrayList<>();
	
	//Constructor 
	
	public Gimnasio(String nombre, String ciudad, String sede, boolean abierto) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.sede = sede;
		this.setAbierto(abierto);
	}
	
	//Métodos para agregar entrenadores, máquinas, y clientes al gimnasio
	
	public void agregarEntrenador(Entrenador e) {
		listaEntrenadores.add(e);
	}
	
	public void agregarMaquina(Maquina m) {
		listaMaquinas.add(m);
	}
	
	public void agregarCliente(Cliente c) {
		listaClientes.add(c);
	}
	
	//Métodos Set y Get
	
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
	
	public void setListaGimnasios(ArrayList<Gimnasio> listaGimnasios) {
		Gimnasio.listaGimnasios = listaGimnasios;
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
	
	
	// Métodos para revisar si hay entrenandores de cierto nivel en el gimnasio
	
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
	
	// toString sencillo que imprime el nombre ciudad y sede del gimnasio.
	
	@Override
	public String toString() {
		return this.nombre 
				+ " " 
				+ this.ciudad 
				+ " sede " 
				+ this.sede;
	}
	
	public ArrayList<Gimnasio> sedesDisponibles(ArrayList<Maquina> maquinas) {
		// Quiero la lista de máquinas del gimnasio en string. Ejemplo: ("barra", "polea", "caminadora")
		
		ArrayList<Gimnasio> sedesDisponibles = new ArrayList<>();
		ArrayList<String> maquinasEnString = new ArrayList<>();
		
		for (Maquina m : maquinas) { // Obtengo los nombres de las máquinas
			maquinasEnString.add(m.getNombre());
		}
		
		for (Gimnasio g : listaGimnasios) {
			// Obtengo las máquinas que hay en mi sede
			
			ArrayList<String> maquinasSedeEnString = new ArrayList<>();
			
			for (Maquina m : g.getListaMaquinas()) {
				// Paso la lista a String para hacer la comparación
				maquinasSedeEnString.add(m.getNombre());
			}
			
			if (g.abierto) {
				// Si g está abierto y contiene todas las máquinas que necesito
				// para hacer mi rutina
				// Entonces es una sede disponible
				
				if (maquinasSedeEnString.containsAll(maquinasEnString)) {
					sedesDisponibles.add(g); // La agrego a mi lista de sedes disponibles
				}
			}
		}
		return sedesDisponibles;
	}
	
	public ArrayList<Cliente> clientesSimilares(Cliente cliente) {
		// Este método recibe un cliente.
		// Dentro del gimnasio de mi cliente revisa una serie de condiciones
		// Para encontrar los clientes similares dentro del gimnasio
				
		ArrayList<Cliente> clientesSimilares = new ArrayList<>(); // Clientes similares en el gimansio
		
		// Tengo que revisar igualdad de Sexo
		// preferenciaAlimenticia.
		// objetivoCliente
		
		for (Cliente c : this.listaClientes) {
			// Para cada cliente del gimnasio.
			
			if (!c.equals(cliente)) { // Si el cliente es distinto a mi cliente actual
				if (c.getSexo().equalsIgnoreCase(cliente.getSexo()) 
				&& c.getPreferenciaAlimenticia().name().equalsIgnoreCase(cliente.getPreferenciaAlimenticia().name())
				&& c.getObjetivoCliente().equals(cliente.getObjetivoCliente())) {
	
					// Revisar restricciones de Peso, Altura y Edad.
					// Peso dentro de un rango de +-5kg el peso de mi cliente.
					// Edad dentro de un rango de +-2 años la edad de mi cliente.
					// Altura dentro de un rango de +-3cm la altura de mi cliente.
					
					if ((c.getPeso() - 2 < cliente.getPeso() 
							&& cliente.getPeso() < c.getPeso() + 2)
						&& (c.getEdad() - 2 < cliente.getEdad() 
								&& cliente.getEdad() < c.getEdad() + 2) 
						&& (c.getAltura() - 3 < cliente.getAltura() 
								&& cliente.getAltura() < c.getAltura() + 3)	) {
						clientesSimilares.add(c);
						// Agrego todos los clientes similares a mi cliente actual.

					}
				}
			}
		}
		return clientesSimilares;
	}
}
