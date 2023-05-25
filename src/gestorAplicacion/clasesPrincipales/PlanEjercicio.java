package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import java.util.HashMap;
import java.io.Serializable;
import java.util.Random;


import gestorAplicacion.clasesHerencia.Plan;

public class PlanEjercicio implements Plan, Serializable {
    private static final long serialVersionUID = 1L;
    
    /*Atributos: nombre, dificultad-> de las rutinas*/
    
    //Estructuras de datos: Hashhmap planSemanalEjercicio-> a cada día de la semana se le asigna una
    //												 Rutina(Conjunto de ejercios)
    
    private String nombre;
    private NivelCliente dificultad;
    private HashMap<DiaSemana, Rutina> planSemanalEjercio = new HashMap<DiaSemana, Rutina>();

    //Sobrecarga de constructores
    
    public PlanEjercicio(HashMap<DiaSemana, Rutina> planSemanalEjercio){    
        this.planSemanalEjercio = planSemanalEjercio;
    }
    
    public PlanEjercicio(String nombre, HashMap<DiaSemana, Rutina> planSemanalEjercio){
        this.nombre = nombre;
        this.planSemanalEjercio = planSemanalEjercio;
    }
    
    //Necesario para el funcionamiento del código
    //Sobre objetos de PlanEjercicio creados con el constructor vacío se puede correr el método crearPlanSemanal
    
    public PlanEjercicio(){}

    //Sobreescribe el método Plan crearPlanSemana(ObjetivoCliente) de la interfaz Plan
    //Crea un objeto de tipo Plan con rutinas para todos los días de la semana basandose en el objetivo del cliente y 
    // la dificultad de la rutina
    
    @Override
    public Plan crearPlanSemanal(ObjetivoCliente objetivo) {
    	/*El array guarda 7 constantes que van a determinar cuales serán las rutinas que se van a realizar en la semana*/

    	TipoEjercicio[] array = {TipoEjercicio.EMPUJAR, 
				    			TipoEjercicio.EMPUJAR, 
				    			TipoEjercicio.HALAR, 
					            TipoEjercicio.HALAR, 
					            TipoEjercicio.PIERNA, 
					            TipoEjercicio.PIERNA, 
					            TipoEjercicio.CARDIO};
    	
        Random rand = new Random();
        HashMap<DiaSemana, Rutina> planSemanalEjercio = new HashMap<DiaSemana, Rutina>();
        
        //Cambia el orden del array para que los planes de ejercicio siempre tengan un orden distinto

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            TipoEjercicio temp = array[randomIndexToSwap];
			array[randomIndexToSwap] = array[i];
			array[i] = temp;
        }  
        //A cada día le genera una rutina tomando en cuenta el tipo de ejercicio del día,el objetivo y la dificultad

        int index = 0;
        for (DiaSemana dia: DiaSemana.values()){
            planSemanalEjercio.put(dia, Rutina.generarRutina(array[index], objetivo, getDificultad()));
            index++;
        }
        return new PlanEjercicio(planSemanalEjercio);
    }

    public Plan crearPlanSemanal(ObjetivoCliente objetivo, NivelCliente nivel){
        setDificultad(nivel);
        return crearPlanSemanal(objetivo);
    }
    
    public PlanEjercicio crearPlanEjercicioSemanal(ObjetivoCliente objetivo, NivelCliente nivel) {
    	PlanEjercicio plan = new PlanEjercicio();
    	return (PlanEjercicio) plan.crearPlanSemanal(objetivo, nivel);
    }

    //toString para mostrarle en pantalla al usuario, el plan de alimentación semanal

    @Override
    public String toString(){
        return "\n" 
        		+ "----------------TU PLAN DE EJERCICIO----------------\n" 
        		+ "\n"
		        + "Lunes: " 
		        + getPlanSemanalEjercio().get(DiaSemana.LUNES)
		        + "\nMartes: " 
		        + getPlanSemanalEjercio().get(DiaSemana.MARTES)
		        + "\nMiercoles: " 
		        + getPlanSemanalEjercio().get(DiaSemana.MIERCOLES) 
		        + "\nJueves: " 
		        + getPlanSemanalEjercio().get(DiaSemana.JUEVES)
		        + "\nViernes: " 
		        + getPlanSemanalEjercio().get(DiaSemana.VIERNES)
		        + "\nSabado: " 
		        + getPlanSemanalEjercio().get(DiaSemana.SABADO)
		        + "\nDomingo: " 
		        + getPlanSemanalEjercio().get(DiaSemana.DOMINGO);
    }

    //Métodos Set y Get

    public void setplanSemanalEjercio (HashMap<DiaSemana, Rutina> planSemanalEjercio) {
        this.planSemanalEjercio = planSemanalEjercio;
    }

    public void setNombre (String nombre){
        this.nombre = nombre;
    }

    public void setDificultad(NivelCliente dificultad){
        this.dificultad = dificultad;
    }
    
    public HashMap<DiaSemana, Rutina> getPlanSemanalEjercio() {
        return planSemanalEjercio;
    }

    public String getNombre(){
        return nombre;
    }

    public NivelCliente getDificultad(){
        return dificultad;
    }
}