package clasesPrincipales;

public class Equipo {
	Usuario[] miembrosEquipo;
	Proyecto proyectoAsignado;
	public Equipo(Usuario[] miembrosEquipo, Proyecto proyectoAsignado) {
		this.miembrosEquipo = miembrosEquipo;
		this.proyectoAsignado = proyectoAsignado;
		
	}
	public void setMiembrosEquipo (Usuario[] miembrosEquipo) {
		this.miembrosEquipo = miembrosEquipo;}
	public void setProyectoAsignado (Proyecto proyectoAsignado) {
		this.proyectoAsignado = proyectoAsignado;}
	
	public Usuario[] getMiembrosEquipo() {
		return miembrosEquipo;}
	public Proyecto getProyectoAsignado() {
		return proyectoAsignado;}
	
	
}
