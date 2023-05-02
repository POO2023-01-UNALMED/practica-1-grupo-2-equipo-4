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
}
