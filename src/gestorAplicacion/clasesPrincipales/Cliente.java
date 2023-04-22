package gestorAplicacion.clasesPrincipales;
import java.io.Serializable;

public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	
	public Cliente(String name) {this.name = name;}
}
