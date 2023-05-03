package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import gestorAplicacion.clasesHerencia.*;
import java.util.HashMap;
import java.io.Serializable;
import java.util.ArrayList;

public class PlanAlimentacion implements Plan, Serializable {
	private static final long serialVersionUID = 1L;
	public String nombrePlan;
    private final int numComidas;
    private ArrayList<Comida> comidasFiltradas;
    private HashMap<DiaSemana, ArrayList<Comida>> planSemanal = new HashMap<DiaSemana, ArrayList<Comida>>();

    public PlanAlimentacion(String nombrePlan, int numComidas) {
        this.nombrePlan = nombrePlan;
        this.numComidas = numComidas;
        this.comidasFiltradas = new ArrayList<Comida>(); // Tiene 3 comidas únicamente
        this.planSemanal = new HashMap<>();
    }

    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public int getNumComidas() {
        return numComidas;
    }

    public ArrayList<Comida> getComidasFiltradas() {
        return comidasFiltradas;
    }

    public void setComidasFiltradas(ArrayList<Comida> comidasFiltradas) {
        this.comidasFiltradas = comidasFiltradas;
    }

    public HashMap<DiaSemana, ArrayList<Comida>> getPlanSemanal() {
        return planSemanal;
    }

    public void setPlanSemanal(HashMap<DiaSemana, ArrayList<Comida>> planSemanal) {
        this.planSemanal = planSemanal;
    }

    public Plan crearPLanSemanal() {
        PlanAlimentacion p = new PlanAlimentacion("", 3);
    	return p;
    }
    
    public ArrayList<Comida> filtrarComidaObjetivo(Cliente cliente) {
    	// Voy a filtrar comidas recomendadas
    	ArrayList<Comida> todasComidasPlan = new ArrayList<>();
    	ArrayList<Comida> comidasRecomendadas = new ArrayList<>();
    	
    	for (ArrayList<Comida> comidasDia : this.getPlanSemanal().values()) {
    		todasComidasPlan.addAll(comidasDia);
    	}
    	
    	// Ahora quiero filtrar segun el objetivo del cliente
    	if (cliente.getObjetivoCliente().equals(ObjetivoCliente.ACONDICIONAR)) { // Dieta Balanceada
    		comidasRecomendadas = todasComidasPlan;
    	}
    	
    	else if (cliente.getObjetivoCliente().equals(ObjetivoCliente.AUMENTAR)) { // +Proteina +Calorias
    		ArrayList<Comida> topCincoComidas = new ArrayList<>();
    		// Sacar las 5 comidas con mas Proteina
    		
    		// https://www.youtube.com/watch?v=Q93JsQ8vcwY vamos a utilizar .stream() minuto 7:13
    		
    		todasComidasPlan.sort
    		
    		
    	}
    	
    	else if (cliente.getObjetivoCliente().equals(ObjetivoCliente.BAJARPESO)) { //+Proteina -Calorias
    		
    		// Sortear todasComidasPlan por masProteicos()
    		
    	}
    	
    	else if (cliente.getObjetivoCliente().equals(ObjetivoCliente.DEFINIR)) { //+Proteina -Calorias
    		
    		// Sortear todasComidasPlan por masProteicos()
    		
    	}
    	
    	else if (cliente.getObjetivoCliente().equals(ObjetivoCliente.MANTENER)) { // Dieta Balanceada
    		comidasRecomendadas = todasComidasPlan;
    	}
    	
    	return comidasRecomendadas;
    }
}
