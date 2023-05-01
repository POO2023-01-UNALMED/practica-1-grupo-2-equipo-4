package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import java.util.HashMap;

import gestorAplicacion.clasesHerencia.Plan;

public class PlanEjercicio implements Plan{
    private String nombre;
    private HashMap<DiaSemana, Rutina> planSemanalEjercio = new HashMap<DiaSemana, Rutina>();

    public PlanEjercicio(String nombre, HashMap<DiaSemana, Rutina> planSemanalEjercio){
        this.nombre = nombre;
        this.planSemanalEjercio = planSemanalEjercio;
    }

    //metodos get y set

    public void setplanSemanalEjercio (HashMap<DiaSemana, Rutina> planSemanalEjercio) {
        this.planSemanalEjercio = planSemanalEjercio;}
    public void setNombre (String nombre) {
        this.nombre = nombre;}
    
    public HashMap<DiaSemana, Rutina> getPlanSemanalEjercio() {
        return planSemanalEjercio;}
    public String getNombre() {
        return nombre;}
    
    public Plan crearPLanSemanal() {
    	HashMap<DiaSemana, Rutina> planEjercicio = new HashMap<DiaSemana, Rutina>();
        PlanEjercicio p = new PlanEjercicio("", planEjercicio);
    	return p;
    }
}
