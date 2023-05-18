package gestorAplicacion.clasesHerencia;

import gestorAplicacion.clasesEnum.NivelCliente;
import gestorAplicacion.clasesEnum.ObjetivoCliente;

public interface Plan {    
    public String toString();
    public Plan crearPLanSemanal(ObjetivoCliente objetivo, NivelCliente dificultad);
    Plan crearPLanSemanal(ObjetivoCliente objetivo, NivelCliente dificultad, String nombrePlan);
    public Plan crearPLanSemanal();
}
