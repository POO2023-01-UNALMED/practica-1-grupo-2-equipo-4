package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import gestorAplicacion.clasesHerencia.*;
import java.util.HashMap;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class PlanAlimentacion implements Plan, Serializable {
	private static final long serialVersionUID = 1L;
	public String nombrePlan;
    private final int NUMCOMIDAS = 3;
    private ArrayList<Comida> comidasFiltradas;
    private HashMap<DiaSemana, ArrayList<Comida>> planSemanal = new HashMap<DiaSemana, ArrayList<Comida>>();


    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public int getNUMCOMIDAS() {
        return NUMCOMIDAS;
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

    @Override
    public Plan crearPLanSemanal(ObjetivoCliente objetivo) {
        Empresa empresa = new Empresa();
        Random random = new Random();
        ArrayList<Comida> comidasFiltradas= new ArrayList<Comida>();

        int limiteCalBajo = 0;
        int limiteCalAlto = 0;


        switch(objetivo){
            case ACONDICIONAR:
                limiteCalAlto = 2500/NUMCOMIDAS;
                limiteCalBajo = 2000/NUMCOMIDAS;
            case AUMENTAR:
                limiteCalAlto = 3000/NUMCOMIDAS;
                limiteCalBajo = 2500/NUMCOMIDAS;
            case DEFINIR:
                limiteCalAlto = 1500/NUMCOMIDAS;
                limiteCalBajo = 1700/NUMCOMIDAS;
            case BAJARPESO:
                limiteCalAlto = 1300/NUMCOMIDAS;
                limiteCalBajo = 1800/NUMCOMIDAS;
            case MANTENER:
                limiteCalAlto = 1500/NUMCOMIDAS;
                limiteCalBajo = 2000/NUMCOMIDAS;
                
        }

        for (Comida comida: empresa.getComidas()){
            if (comida.getCalorias() <= limiteCalAlto && comida.getCalorias() >= limiteCalAlto){
                comidasFiltradas.add(comida);
            }
        }
        setComidasFiltradas(comidasFiltradas);

        for (DiaSemana dia: DiaSemana.values()){
            ArrayList<Comida> comidasDelDia = new ArrayList<Comida>();
            for (int i=0; i< NUMCOMIDAS; i++){
                comidasDelDia.add(comidasFiltradas.get(random.nextInt(comidasFiltradas.size())));
            }
            planSemanal.put(dia, comidasDelDia);
        }
        return this;
    }

   
  
    
}
