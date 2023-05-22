package gestorAplicacion.clasesHerencia;

import gestorAplicacion.clasesEnum.NivelCliente;
import gestorAplicacion.clasesEnum.ObjetivoCliente;

public interface Plan {    
    public String toString();
    public Plan crearPLanSemanal(ObjetivoCliente objetivo);

}
