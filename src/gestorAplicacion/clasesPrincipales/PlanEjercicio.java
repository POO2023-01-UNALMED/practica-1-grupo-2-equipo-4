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

    	TipoEjercicio[] array = {TipoEjercicio.EMPUJAR, TipoEjercicio.EMPUJAR, TipoEjercicio.HALAR, 
            TipoEjercicio.HALAR, TipoEjercicio.PIERNA, TipoEjercicio.PIERNA, TipoEjercicio.CARDIO};
        Random rand = new Random();
        HashMap<DiaSemana, Rutina> planSemanalEjercio = new HashMap<DiaSemana, Rutina>();
        

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            TipoEjercicio temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
        }
        int index = 0;
        for (DiaSemana dia: DiaSemana.values()){
            planSemanalEjercio.put(dia, Rutina.generarRutina(array[index], objetivo, dificultad));
        }
        
        return new PlanEjercicio(planSemanalEjercio);
    }

    @Override
    public Plan crearPLanSemanal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearPLanSemanal'");
    }

    @Override
    public String toString(){
        return "TU PLAN PARA LA SEMANA\n" + "Lunes: " + getPlanSemanalEjercio().get(DiaSemana.LUNES)
        + "\nMartes: " + getPlanSemanalEjercio().get(DiaSemana.MARTES)+ "\nMiercoles: " + getPlanSemanalEjercio().get(DiaSemana.MIERCOLES) 
        + "\nJueves: " + getPlanSemanalEjercio().get(DiaSemana.JUEVES)+ "\nViernes: " + getPlanSemanalEjercio().get(DiaSemana.VIERNES)
        + "\nSabado: " + getPlanSemanalEjercio().get(DiaSemana.SABADO)+ "\nDomingo: " + getPlanSemanalEjercio().get(DiaSemana.DOMINGO);
    }

    //metodos get y set

    public void setplanSemanalEjercio (HashMap<DiaSemana, Rutina> planSemanalEjercio) {
        this.planSemanalEjercio = planSemanalEjercio;}

    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    
    public HashMap<DiaSemana, Rutina> getPlanSemanalEjercio() {
        return planSemanalEjercio;}

    public String getNombre(){
        return nombre;
    }
    
}
