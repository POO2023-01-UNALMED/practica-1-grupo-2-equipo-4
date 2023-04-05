package clasesPrincipales;

public class Empleado extends Usuario {
	Jefe[] jefe;
	Equipo equipo;
	public Empleado(String username, String nombre, String correo, String contraseña, Calendario calendario,
			Jefe[] jefe, Equipo equipo) {
		super(username,nombre,correo,contraseña,calendario);
		this.jefe = jefe;
		this.equipo = equipo;
		
	}
}
