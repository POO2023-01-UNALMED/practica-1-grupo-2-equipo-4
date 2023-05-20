package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import java.util.HashMap;
import java.io.Serializable;
import java.util.Random;


import gestorAplicacion.clasesHerencia.Plan;

public class PlanEjercicio implements Plan, Serializable {
    private static final long serialVersionUID = 1L;
	
    String nombre;
    private HashMap<DiaSemana, Rutina> planSemanalEjercio = new HashMap<DiaSemana, Rutina>();

    public PlanEjercicio(HashMap<DiaSemana, Rutina> planSemanalEjercio){    
        this.planSemanalEjercio = planSemanalEjercio;
    }
    public PlanEjercicio(String nombre, HashMap<DiaSemana, Rutina> planSemanalEjercio){
        this.nombre = nombre;
        this.planSemanalEjercio = planSemanalEjercio;
    }

    public PlanEjercicio(){}

    @Override
    public Plan crearPLanSemanal(ObjetivoCliente objetivo, NivelCliente dificultad) {
        return crearPLanSemanal(objetivo, dificultad, "Medio");
    }

    @Override
    public Plan crearPLanSemanal(ObjetivoCliente objetivo, NivelCliente dificultad, String intensidad) {
    	TipoEjercicio[] array = {TipoEjercicio.EMPUJAR, TipoEjercicio.EMPUJAR, TipoEjercicio.HALAR, 
            TipoEjercicio.HALAR, TipoEjercicio.PIERNA, TipoEjercicio.PIERNA, TipoEjercicio.CARDIO};
        Random rand = new Random();
        HashMap<DiaSemana, Rutina> planSemanalEjercio = new HashMap<DiaSemana, Rutina>();
        
        int factorIntensidad;
        switch(intensidad) {
            case "Básico":
                factorIntensidad = 1;
                break;
            case "Medio":
                factorIntensidad = 2;
                break;
            case "Alto":
                factorIntensidad = 3;
                break;
            default:
                factorIntensidad = 2;
        }

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            TipoEjercicio temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
        }    
        int index = 0;
        for (DiaSemana dia: DiaSemana.values()){
            planSemanalEjercio.put(dia, Rutina.generarRutina(array[index], objetivo, dificultad, factorIntensidad));
            index++;
        }
        return new PlanEjercicio("Plan " + intensidad, planSemanalEjercio);
    }

    @Override
    public Plan crearPLanSemanal() {
        throw new UnsupportedOperationException("Unimplemented method 'crearPLanSemanal'");
    }

    @Override
    public String toString(){
        return "TU PLAN PARA LA SEMANA\n" + "Lunes: " + getPlanSemanalEjercicio().get(DiaSemana.LUNES)
        + "\nMartes: " + getPlanSemanalEjercicio().get(DiaSemana.MARTES)+ "\nMiercoles: " + getPlanSemanalEjercicio().get(DiaSemana.MIERCOLES) 
        + "\nJueves: " + getPlanSemanalEjercicio().get(DiaSemana.JUEVES)+ "\nViernes: " + getPlanSemanalEjercicio().get(DiaSemana.VIERNES)
        + "\nSabado: " + getPlanSemanalEjercicio().get(DiaSemana.SABADO)+ "\nDomingo: " + getPlanSemanalEjercicio().get(DiaSemana.DOMINGO);
    }

    //metodos get y set

    public void setplanSemanalEjercio (HashMap<DiaSemana, Rutina> planSemanalEjercio) {
        this.planSemanalEjercio = planSemanalEjercio;}

    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    
    public HashMap<DiaSemana, Rutina> getPlanSemanalEjercicio() {
        return planSemanalEjercio;}

    public String getNombre(){
        return nombre;
    }
    
}

