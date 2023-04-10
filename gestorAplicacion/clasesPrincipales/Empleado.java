package clasesPrincipales;

public class Empleado extends Usuario {
	Jefe[] jefe;
	Equipo equipo;
	public Empleado(String username, String nombre, String correo, String contrasena, Calendario calendario,
			Jefe[] jefe, Equipo equipo) {
		super(username,nombre,correo,contrasena,calendario);
		this.jefe = jefe;
		this.equipo = equipo;
		
	}
	public void setEquipo (Equipo equipo) {
		this.equipo = equipo;}
	public void setJefe (Jefe[] jefe) {
		this.jefe = jefe;}
	
	public Equipo getEquipo() {
		return equipo;}
	public Jefe[] getJefe() {
		return jefe;}
	
	
}
