from src.gestorAplicacion.clasesEnum import DiaSemana, ObjetivoCliente, NivelCliente



class Historial:


    # Autores: Juan Jose Ospina Erazo.

    def __init__(self, cliente):
        # Finalidad de la clase:
        # El historial sirve para almacenar la historia de planes de ejercicio
        # la historia de los planes de alimentación, entre otros aspectos de un cliente.
        
        # Estructuras de datos:
        # Utilizamos un List para los historiales de planes
        # Utilizamos un Set para guardar elementos no duplicados de gimnasio
        # Utilizamos un Map para guardar llaves de gimnasio y valores de las veces que se ha asistido a este gimnasio
        
        # Componentes:
        # Las listas de historiales, la lista de gimnasios visitados
        # y el HashMap del gimnasio visitado y las veces que el cliente lo visita.
        
        self.cliente = cliente
        self.historialPlanesEjercicio = []  # List de PlanEjercicio
        self.historialPlanesAlimentacion = []  # List de PlanAlimentacion
        self.gimnasiosVisitados = set()  # Set de Gimnasio
        self.visitasGimnasio = {}  # Mapa de Gimnasio a Integer (veces visitado)

    def agregarPlanEjercicio(self, plan):
        # Métodos Set y Get
        self.historialPlanesEjercicio.append(plan)

    def agregarPlanAlimentacion(self, plan):
        self.historialPlanesAlimentacion.append(plan)

    def agregarGimnasio(self, gimnasio):
        self.gimnasiosVisitados.add(gimnasio)
    
        # Si el gimnasio ya ha sido visitado, incrementa el contador
        if gimnasio in self.visitasGimnasio:
            self.visitasGimnasio[gimnasio] += 1
        else:
            # Si es la primera visita al gimnasio, inicializa el contador en 1
            self.visitasGimnasio[gimnasio] = 1

    def vecesAsistidasAlGimnasio(self):
        # Hace la sumatoria de visitas al gimnasio
        totalVisitas = sum(self.visitasGimnasio.values())
        return totalVisitas

    def recomendarPlan(self):
        from src.gestorAplicacion.clasesPrincipales import PlanEjercicio
        # Método de funcionalidad 4 para documentar

        asistencias = self.vecesAsistidasAlGimnasio()
        objetivoActual = self.cliente.getObjetivoCliente()
        dificultadActual = self.cliente.getNivelCliente()

        if asistencias < 10:
            planSemanalEjercicio = PlanEjercicio().crearPlanSemanal(objetivoActual, dificultadActual).planSemanalEjercicio
            planRecomendado = PlanEjercicio("Plan Basico", planSemanalEjercicio)
        elif asistencias >= 10 and asistencias < 20:
            planSemanalEjercicio = PlanEjercicio().crearPlanSemanal(objetivoActual, dificultadActual).planSemanalEjercicio
            planRecomendado = PlanEjercicio("Plan Medio", planSemanalEjercicio)
        else:
            planSemanalEjercicio = PlanEjercicio().crearPlanSemanal(objetivoActual, dificultadActual).planSemanalEjercicio
            planRecomendado = PlanEjercicio("Plan Alto", planSemanalEjercicio)

        return planRecomendado