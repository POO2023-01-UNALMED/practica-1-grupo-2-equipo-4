package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import gestorAplicacion.clasesHerencia.*;
import java.util.HashMap;
import java.util.Random;
import java.io.Serializable;
import java.util.ArrayList;

/*Autores: Juan Ospina, Esteban Vásquez, Jacobo Ochoa
 * Finalidad de la clase: La clase guarda la información del plan de alimentación para la semana recomendado al cliente */

public class PlanAlimentacion implements Plan, Serializable {
	private static final long serialVersionUID = 1L;
	
	/*Atributos: nombrePlan, numComidas-> comidas al día*/
	//Estructuras de datos: HashMap planSemanal-> A cada día de la semana se le asigna un ArrayList de comidas
	//						ArrayList comidasFiltradas-> comidas que puede consumir el cliente 
	//										   basado en especificaciones como alergias, cantidad de macronutrientes/calorias, entre otros
	
	public String nombrePlan;
    private final int NUMCOMIDAS = 3;
    private ArrayList<Comida> comidasFiltradas;
    private HashMap<DiaSemana, ArrayList<Comida>> planSemanal = new HashMap<DiaSemana, ArrayList<Comida>>();

    //Sobrecarga de constructores
    
    public PlanAlimentacion(String nombrePlan) {
        this.nombrePlan = nombrePlan;
        this.comidasFiltradas = new ArrayList<Comida>(); // Tiene 3 comidas únicamente
        this.planSemanal = new HashMap<>();
    }
    
    public PlanAlimentacion(String nombrePlan, HashMap<DiaSemana, ArrayList<Comida>> planSemanal) {
    	this.nombrePlan = nombrePlan;
        this.planSemanal = planSemanal;
    }

    //Métodos Set y Get
    
    public String getNombrePlan() {
        return nombrePlan;
    }

    public void setNombrePlan(String nombrePlan) {
        this.nombrePlan = nombrePlan;
    }

    public int getNumComidas() {
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

    //Método que descarta todos los alimentos que contenga alguno de los alérgenos listados en el parámetro

    public PlanAlimentacion filtrarPorAlergenos(ArrayList<Alergeno> alergias) {
    	Alimento proteinaComplementaria = new Alimento("Proteina", 100, 24, 3, 0, null);
    	
    	for (ArrayList<Comida> comidasDia : planSemanal.values()) { // Para las comidas de cada día
            for (Comida comida : comidasDia) { // Para cada comida
            	
                ArrayList<Alimento> alimentosAlergenos = new ArrayList<>(); // Crear lista para almacenar los alimentos a eliminar
                
                for (Alimento alimento : comida.listaAlimentos) { // Para cada alimento en la comida
                    if (alergias.contains(alimento.getAlergeno())) { // Agregar alimentos que dan alergia
                        alimentosAlergenos.add(alimento);
                    }
                }
                
                comida.listaAlimentos.removeAll(alimentosAlergenos); // Eliminar todos los que dan alergia en esa comida         
                // Se recomienda un nuevo alimento con proteína para complementar esa comida.
                
                if (!comida.listaAlimentos.contains(proteinaComplementaria)) {
                	comida.listaAlimentos.add(proteinaComplementaria);
                }
            }   
        }
        return this;
    }
    
    //toString para mostrarle en pantalla al usuario, el plan de alimentación semanal
    
    @Override
    public String toString() {
        String planFormateado = "--------------------TU PLAN DE ALIMENTACIÓN--------------------\n" + "\n";
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
    
    //Sobreescribe el método Plan crearPlanSemana(ObjetivoCliente) de la interfaz Plan
    //Crea un plan de alimentación para todos los días de la semana, 
    //cada comida comprendida en el plan debe estar en un rango de calorias determinado por el objetivo del parametro
    
    @Override
    public Plan crearPlanSemanal(ObjetivoCliente objetivo) {
        Empresa empresa = new Empresa();
        Random random = new Random();
        ArrayList<Comida> comidasFiltradas= new ArrayList<Comida>();

        int limiteCalBajo = 0;
        int limiteCalAlto = 0;

        //Asigna un rango de calorias para las comidas según el objetivo

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
        //Agrega las comidas que cumplen con el parametro a una lista

        for (Comida comida: empresa.getComidas()){
            if (comida.getCalorias() <= limiteCalAlto && comida.getCalorias() >= limiteCalAlto){
                comidasFiltradas.add(comida);
            }
        }
        setComidasFiltradas(comidasFiltradas);
        //Agrega tres comidas cualquiera que hagan parte de la lista de comidas filtradas a cada día de la semana

        for (DiaSemana dia: DiaSemana.values()){
            ArrayList<Comida> comidasDelDia = new ArrayList<Comida>();
            for (int i=0; i< 3; i++){
                comidasDelDia.add(comidasFiltradas.get(random.nextInt(comidasFiltradas.size())));
            }
            planSemanal.put(dia, comidasDelDia);
        }
        return this;
    }
}
