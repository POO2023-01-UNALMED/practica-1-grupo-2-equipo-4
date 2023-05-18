package gestorAplicacion.clasesPrincipales;

import gestorAplicacion.clasesEnum.*;
import java.util.*;

public class Historial {
    private Cliente cliente;
    private List<PlanEjercicio> historialPlanes;
    private Set<Gimnasio> gimnasiosVisitados;
    private Map<Gimnasio, Integer> visitasGimnasio;


    public Historial(Cliente cliente) {
        this.cliente = cliente;
        this.historialPlanes = new ArrayList<>();
        this.gimnasiosVisitados = new HashSet<>();
        this.visitasGimnasio = new HashMap<>();
    }
    

    public Cliente getCliente() {
        return cliente;
    }

   
    

    public List<PlanEjercicio> getHistorialPlanes() {
        return historialPlanes;
    }

    public Set<Gimnasio> getGimnasiosVisitados() {
        return gimnasiosVisitados;
    }

    public void agregarPlan(PlanEjercicio plan) {
        this.historialPlanes.add(plan);
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
        String intensidad;
    
        if(asistencias < 10) {
            intensidad = "Básico";
        } else if(asistencias >= 10 && asistencias < 20) {
            intensidad = "Medio";
        } else {
            intensidad = "Alto";
        }
        planSemanalEjercicio = ((PlanEjercicio)new PlanEjercicio().crearPLanSemanal(objetivoActual, dificultadActual, intensidad)).getPlanSemanalEjercicio();
        planRecomendado = new PlanEjercicio("Plan " + intensidad, planSemanalEjercicio);
        
        return planRecomendado;
    }
    
    
    
}





