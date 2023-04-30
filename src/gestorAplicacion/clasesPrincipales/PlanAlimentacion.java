package gestorAplicacion.clasesPrincipales;
import java.util.HashMap;
import java.util.Map;

public class PlanAlimentacion extends Plan {
    public String nombrePlan;
    private final int numComidas;
    private Comida[] comidasFiltradas;
    private Map<DiaSemana, Comida[]> planSemanal;

    public PlanAlimentacion(String nombrePlan, int numComidas) {
        this.nombrePlan = nombrePlan;
        this.numComidas = numComidas;
        this.comidasFiltradas = new Comida[numComidas];
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

    public Comida[] getComidasFiltradas() {
        return comidasFiltradas;
    }

    public void setComidasFiltradas(Comida[] comidasFiltradas) {
        this.comidasFiltradas = comidasFiltradas;
    }

    public Map<DiaSemana, Comida[]> getPlanSemanal() {
        return planSemanal;
    }

    public void setPlanSemanal(Map<DiaSemana, Comida[]> planSemanal) {
        this.planSemanal = planSemanal;
    }

    public void generarPlanAlimentacionPorObjetivo() {
        //  logica
    }
}
