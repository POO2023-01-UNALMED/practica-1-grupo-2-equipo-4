package clasesPrincipales;

public class Usuario {
	String username;
	String nombre;
	String correo;
	String contraseña;
	Calendario calendario;
	
	public Usuario(String username, String nombre, String correo, String contraseña, Calendario calendario) {
		this.username = username;
		this.nombre = nombre;
		this.correo = correo;
		this.contraseña = contraseña;
		this.calendario = calendario;
	}
	
	
}