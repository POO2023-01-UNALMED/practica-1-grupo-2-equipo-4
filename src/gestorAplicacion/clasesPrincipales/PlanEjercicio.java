package gestorAplicacion.clasesPrincipales;

import java.util.HashMap;

import gestorAplicacion.clasesHerencia.Plan;

public class PlanEjercicio implements Plan{
    String nombre;
    private HashMap<String, Rutina> planSemanalEjercio = new HashMap<String, Rutina>();

    public PlanEjercicio(String nombre, HashMap<String, Rutina> planSemanalEjercio){
        this.nombre = nombre;
        this.planSemanalEjercio = planSemanalEjercio;
    }
}
