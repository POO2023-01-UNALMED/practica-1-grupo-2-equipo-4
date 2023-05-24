package gestorAplicacion.clasesHerencia;

import gestorAplicacion.clasesEnum.ObjetivoCliente;

//La clase plan sirve como una interfaz que define métodos para heredar a 
//PlanEjercicio y PlanAlimentacion.

public interface Plan {    
    public String toString();
    public Plan crearPlanSemanal(ObjetivoCliente objetivo);

}