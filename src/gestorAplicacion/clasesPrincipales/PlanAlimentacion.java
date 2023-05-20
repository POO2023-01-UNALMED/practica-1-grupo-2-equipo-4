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
    
    public PlanAlimentacion(String nombrePlan, HashMap<DiaSemana, ArrayList<Comida>> planSemanal) {
    	this.nombrePlan = nombrePlan;
    	this.numComidas = 3;
        this.planSemanal = planSemanal;
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
    
    @Override
    public Plan crearPLanSemanal(ObjetivoCliente objetivo, NivelCliente dificultad, String intensidad) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Plan crearPLanSemanal(ObjetivoCliente objetivo, NivelCliente dificultad) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public PlanAlimentacion filtrarPorAlergenos(ArrayList<Alergeno> alergias) {
    	for (ArrayList<Comida> comidasDia : planSemanal.values()) { // Para las comidas de cada día
            for (Comida comida : comidasDia) { // Para cada comida
            	
                ArrayList<Alimento> alimentosAlergenos = new ArrayList<>(); // Crear lista para almacenar los alimentos a eliminar
                
                for (Alimento alimento : comida.listaAlimentos) { // Para cada alimento en la comida
                    if (alergias.contains(alimento.getAlergeno())) { // Agregar alimentos que dan alergia
                        alimentosAlergenos.add(alimento);
                    }
                }
                
                comida.listaAlimentos.removeAll(alimentosAlergenos); // Eliminar todos los que dan alergia en esa comida
                
                comida.listaAlimentos.add(new Alimento("Proteina", 100, 24, 3, 0, null));
                // Se agrega un nuevo alimento con proteína para complementar esa comida.
            }
        }
        return this;
    }
    
    public String toString() {
        String planFormateado = "";
        ArrayList<DiaSemana> dias = new ArrayList<>();

        for (DiaSemana dia : DiaSemana.values()) {
            ArrayList<Comida> comidas = planSemanal.get(dia);

            if (!comidas.isEmpty() && !dias.contains(dia)) {
                planFormateado += dia + ":\n";
                dias.add(dia);

                for (Comida comida : comidas) {
                    planFormateado += "\t" + comida.getNombre() + ": ";

                    ArrayList<Alimento> alimentos = comida.getListaAlimentos();
                    for (int i = 0; i < alimentos.size(); i++) {
                        Alimento alimento = alimentos.get(i);
                        planFormateado += alimento.getNombre();

                        if (i < alimentos.size() - 1) {
                            planFormateado += ", ";
                        }
                    }

                    planFormateado += "\n";
                }

                planFormateado += "\n";
            }
        }

        return planFormateado;
    }

}
