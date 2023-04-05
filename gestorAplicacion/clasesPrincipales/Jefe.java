package clasesPrincipales;

public class Jefe extends Usuario {
	Proyecto proyectosAsignados;
	Equipo equipo;
	public Jefe(String username, String nombre, String correo, String contraseña, Calendario calendario,
			Proyecto proyectosAsignados, Equipo equipo) {
		
		super(username,nombre,correo,contraseña,calendario);
		this.proyectosAsignados = proyectosAsignados;
		this.equipo = equipo;
		
	}
}
