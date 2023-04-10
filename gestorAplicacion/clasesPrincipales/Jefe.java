package clasesPrincipales;

public class Jefe extends Usuario {
	Proyecto proyectosAsignados;
	Equipo equipo;
	public Jefe(String username, String nombre, String correo, String contrasena, Calendario calendario,
			Proyecto proyectosAsignados, Equipo equipo) {
		
		super(username,nombre,correo,contrasena,calendario);
		this.proyectosAsignados = proyectosAsignados;
		this.equipo = equipo;
		
	}
	public void setProyectosAsignados (Proyecto proyectosAsignados) {
		this.proyectosAsignados = proyectosAsignados;}
	public void setEquipo (Equipo equipo) {
		this.equipo = equipo;}
	
	public Proyecto getProyectosAsignados() {
		return proyectosAsignados;}
	public Equipo getEquipo() {
		return equipo;}
}
