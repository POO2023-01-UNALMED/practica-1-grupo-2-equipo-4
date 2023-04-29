package gestorAplicacion.clasesPrincipales;

import java.util.HashMap;

import gestorAplicacion.clasesHerencia.Plan;

public class PlanEjercicio implements Plan{
    private String nombre;
    private HashMap<String, Rutina> planSemanalEjercio = new HashMap<String, Rutina>();

    public PlanEjercicio(String nombre, HashMap<String, Rutina> planSemanalEjercio){
        this.nombre = nombre;
        this.planSemanalEjercio = planSemanalEjercio;
    }

    //metodos get y set

    public void setplanSemanalEjercio (HashMap<String, Rutina> planSemanalEjercio) {
        this.planSemanalEjercio = planSemanalEjercio;}
    public void setNombre (String nombre) {
        this.nombre = nombre;}
    
    public HashMap<String, Rutina> getPlanSemanalEjercio() {
        return planSemanalEjercio;}
    public String getNombre() {
        return nombre;}
    
}
