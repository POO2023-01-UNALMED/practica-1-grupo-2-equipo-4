package gestorAplicacion.clasesHerencia;

import gestorAplicacion.clasesEnum.ObjetivoCliente;

public interface Plan {    
    public String toString();
    public Plan crearPlanSemanal(ObjetivoCliente objetivo);

}