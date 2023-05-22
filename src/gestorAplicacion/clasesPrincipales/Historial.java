package gestorAplicacion.clasesPrincipales;

import gestorAplicacion.clasesEnum.*;
import java.util.*;

public class Historial {
    private Cliente cliente;
    private List<PlanEjercicio> historialPlanesEjercicio = new ArrayList<>();
    private List<PlanAlimentacion> historialPlanesAlimentacion = new ArrayList<>();
    private Set<Gimnasio> gimnasiosVisitados = new HashSet<>();
    private Map<Gimnasio, Integer> visitasGimnasio = new HashMap<>();

    public Historial(Cliente cliente) {
        this.cliente = cliente;
        this.historialPlanesEjercicio = new ArrayList<>();
        this.gimnasiosVisitados = new HashSet<>();
        this.visitasGimnasio = new HashMap<>();
    }    

    public Cliente getCliente() {
        return cliente;
    }

    public List<PlanEjercicio> getHistorialPlanesEjercicio() {
        return historialPlanesEjercicio;
    }

    public List<PlanAlimentacion> getHistorialPlanesAlimentacion() {
		return historialPlanesAlimentacion;
	}

	public Set<Gimnasio> getGimnasiosVisitados() {
        return gimnasiosVisitados;
    }

    public void agregarPlanEjercicio(PlanEjercicio plan) {
        this.historialPlanesEjercicio.add(plan);
    }
    
    public void agregarPlanAlimentacion(PlanAlimentacion plan) {
        this.historialPlanesAlimentacion.add(plan);
    }

    public void agregarGimnasio(Gimnasio gimnasio) {
        this.gimnasiosVisitados.add(gimnasio);
    
        // Si el gimnasio ya ha sido visitado, incrementa el contador
        if(this.visitasGimnasio.containsKey(gimnasio)) {
            this.visitasGimnasio.put(gimnasio, this.visitasGimnasio.get(gimnasio) + 1);
        } else {
            // Si es la primera visita al gimnasio, inicializa el contador en 1
            this.visitasGimnasio.put(gimnasio, 1);
        }
    }

    public int vecesAsistidasAlGimnasio() {
        int totalVisitas = 0;
        for(Integer visitas : this.visitasGimnasio.values()) {
            totalVisitas += visitas;
        }
        return totalVisitas;
    }

    
    public PlanEjercicio recomendarPlan() {
        PlanEjercicio planRecomendado;
        HashMap<DiaSemana, Rutina> planSemanalEjercicio;
        int asistencias = vecesAsistidasAlGimnasio();
    
        // Obteniendo el objetivo y la dificultad del cliente actual.
        ObjetivoCliente objetivoActual = cliente.getObjetivoCliente();
        NivelCliente dificultadActual = cliente.getNivelCliente();
    
        if(asistencias < 10) {
            planSemanalEjercicio = ((PlanEjercicio)new PlanEjercicio().crearPLanSemanal(objetivoActual, dificultadActual)).getPlanSemanalEjercio();
            planRecomendado = new PlanEjercicio("Plan Basico", planSemanalEjercicio);
        } else if(asistencias >= 10 && asistencias < 20) {
            planSemanalEjercicio = ((PlanEjercicio)new PlanEjercicio().crearPLanSemanal(objetivoActual, dificultadActual)).getPlanSemanalEjercio();
            planRecomendado = new PlanEjercicio("Plan Medio", planSemanalEjercicio);
        } else {
            planSemanalEjercicio = ((PlanEjercicio)new PlanEjercicio().crearPLanSemanal(objetivoActual, dificultadActual)).getPlanSemanalEjercio();
            planRecomendado = new PlanEjercicio("Plan Alto", planSemanalEjercicio);
        }
    
        return planRecomendado;
    }
    
    
}
