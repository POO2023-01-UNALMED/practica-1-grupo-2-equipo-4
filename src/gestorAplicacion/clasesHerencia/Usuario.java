package gestorAplicacion.clasesHerencia;
import gestorAplicacion.clasesPrincipales.*;

public abstract class Usuario {
	public String username;
	public String nombre;
	private String correo;
	private String contrasena;
	public Calendario calendario;
	
	public Usuario(String username, String nombre, String correo, String contrasena, Calendario calendario) {
		this.username = username;
		this.nombre = nombre;
		this.setCorreo(correo);
		this.setContrasena(contrasena);
		this.contrasena = contrasena;
		this.calendario = calendario;
	}
	
	public Usuario() {
		this("", "", "", "", null);
	}
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contraseña) {
		this.contrasena = contraseña;
	}
	
	public void iniciarSesion(String username, String contrasena) {
		if (this.username == username && this.contrasena == contrasena) {
			System.out.println("Bienvenido a Timety " + username);
		}
		
		else {System.out.println("Ingresó un nombre de usuario o una contraseña incorrecta");}
	}
	
	public void cerrarSesion() {System.out.println("Cerrando sesión");}
	
	public void eliminarCuenta() {System.out.println("Cuenta eliminada");}
	
	// METODO ABSTRACTO
	
	// INTERFAZ
	
	// LISTA EMPLEADOS?
	
	// CONSTANTE
}