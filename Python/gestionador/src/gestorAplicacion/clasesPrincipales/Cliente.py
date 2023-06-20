from src.gestorAplicacion.clasesHerencia.Persona import Persona


# Autores: Esteban Vásquez Pérez.

# Finalidad de la clase: 
# La clase cliente representa una de las Personas que está asistiendo a nuestros Gimnasios
# El cliente es el usuario principal de la aplicación. 
# Tiene acceso a todas las funcionalidades a través de su número de identificación.

# Estructuras de datos:
# Utilizamos un lista para guardar cada uno de los clientes

# Componentes:
# Atributos heredados de Persona: nombre, gimnasio, identificación.
# Atributos que describen el físico del cliente
# Un objeto de entrenador

# Una serie de descripciones del cliente que incluyen
# preferencia alimenticia (por ejemplo si es vegano)
# nivel cliente que puede ser (PRINCIPIANTE, INTERMEDIO, AVANZADO)
# Un objetivo particular del cliente (por ejemplo bajar de peso)
# un PlanAlimentacion que el cliente sigue en este momento.
# un Plan que va a representar el PlanEjercicio
# un Historial de planes que contiene
# historial de gimnasios visitados
# historial de planes de ejercicio y alimentación
# un historial que tiene los gimnasios que ha visitado y la cantidad de veces que ha ido.


class Cliente(Persona):



    from src.gestorAplicacion.clasesEnum.NivelCliente import NivelCliente
    from src.gestorAplicacion.clasesEnum.ObjetivoCliente import ObjetivoCliente
    from src.gestorAplicacion.clasesEnum.PreferenciaAlimenticia import PreferenciaAlimenticia
    listaClientes = []

    def __init__(self, 
                nombre: str, 
                gimnasio,
                identificacion: int, 
                altura: float, 
                peso: float, 
                sexo: str, 
                edad: int,
                preferenciaAlimenticia: PreferenciaAlimenticia, 
                nivelCliente: NivelCliente,
                objetivoCliente: ObjetivoCliente):
        
        super().__init__(nombre, 
                        gimnasio, 
                        identificacion)

        self.altura = altura
        self.peso = peso
        self.sexo = sexo
        self.edad = edad
        self.entrenador = None
        self.preferenciaAlimenticia = preferenciaAlimenticia
        self.nivelCliente = nivelCliente
        self.objetivoCliente = objetivoCliente
        self.planAlimentacion = None
        self.planEjercicio = None
        self.historialPlanes = None

        self.gimnasio.agregarCliente(self)
        self.listaClientes.append(self)


    def __str__(self):
        return "Nombre: {}\nGimnasio: {}\nNivel: {}\nEntrenador: {}\nPlan Alimentacion: {}".format(
            self.nombre, 
            str(self.gimnasio), 
            self.nivelCliente.value, 
            self.entrenador.nombre,
            self.planAlimentacion.nombrePlan
        )
    
    def asignarEntrenador(self, entrenador):
        self.entrenador = entrenador
        entrenador.cliente = self
        self.entrenador.disponibilidad = "NO DISPONIBLE"

    def asignarPlanAlimentacion(self, planAlimentacion):
        from src.gestorAplicacion.clasesPrincipales.Historial import Historial
        self.planAlimentacion = planAlimentacion

        if self.historialPlanes is None:
            historialParaPlanesAlimentacion = Historial(self)
            self.historialPlanes = historialParaPlanesAlimentacion
            self.historialPlanes.agregarPlanAlimentacion(planAlimentacion)

        else:
            self.historialPlanes.agregarPlanAlimentacion(planAlimentacion)

    def asignarPlanEjercicio(self, planEjercicio):

        from src.gestorAplicacion.clasesPrincipales.Historial import Historial
        self.planEjercicio = planEjercicio

        if self.historialPlanes is None:
            historialParaPlanesEjercicio = Historial(self)
            self.historialPlanes = historialParaPlanesEjercicio
            self.historialPlanes.agregarPlanEjercicio(planEjercicio)

        else:
            self.historialPlanes.agregarPlanEjercicio(planEjercicio)

    def generarPlanEjercicio(self):

        from src.gestorAplicacion.clasesPrincipales.PlanEjercicio import PlanEjercicio
        plan = PlanEjercicio()
        plan.dificultad = self.nivelCliente
        self.planEjercicio = plan.crearPlanSemanal(self.objetivoCliente)
        return str(self.planEjercicio)

