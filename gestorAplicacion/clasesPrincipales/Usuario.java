package clasesPrincipales;

public class Usuario {
	String username;
	String nombre;
	String correo;
	String contrasena;
	Calendario calendario;
	
	public Usuario(String username, String nombre, String correo, String contrasena, Calendario calendario) {
		this.username = username;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.calendario = calendario;
	}
	public void setCorreo (String correo) {
		this.correo = correo;}
	public void setCalendario (Calendario calendario) {
		this.calendario = calendario;}
	public void setContrasena (String contrasena) {
		this.contrasena = contrasena;}
	public void setNombre (String nombre) {
		this.nombre = nombre;}
	public void setUsername (String username) {
		this.username = username;}
	
	public String getCorreo() {
		return correo;}
	public Calendario getCalendario() {
		return calendario;}
	public String getContrasena() {
		return contrasena;}
	public String getNombre() {
		return nombre;}
	public String getUsername() {
		return username;}
	
	
	
}