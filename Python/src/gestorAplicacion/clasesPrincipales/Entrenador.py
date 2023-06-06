from src.gestorAplicacion.clasesHerencia import Persona
from src.gestorAplicacion.clasesPrincipales import Cliente, Gimnasio
from src.gestorAplicacion.clasesEnum import NivelCliente
import random

# Autores: Esteban Vásquez Pérez.

# Finalidad de la clase:
# La clase Entrenador sirve para crear objetos de los entrenadores que pertenecen a
# un gimnasio. Los entrenadores se pueden asignar a clientes según un nivel.

# Estructuras de datos:
# Utilizamos una lista (list) para guardar cada uno de los entrenadores.

# Componentes:
# Atributos básicos que describen al entrenador: Nombre, gimnasio, identificación.
# Un atributo de formación que puede ser.
# Un cliente personalizado que se


class Entrenador(Persona):
    listaEntrenadores = []

    def __init__(self, nombre: str, gimnasio: Gimnasio, identificacion: int,
                 edad: int, formacion: str, cliente: Cliente, nivelEntrenador: NivelCliente, disponibilidad: str):

        super().__init__(nombre, gimnasio, identificacion)

        self.edad = edad
        self.formacion = formacion
        self.cliente = cliente
        self.nivelEntrenador = nivelEntrenador
        self.disponibilidad = disponibilidad # MAÑANA/TARDE/NO DISPONIBLE

        self.calificaciones = self.generarListaCalificaciones()
        self.calificacionPromedio = self.calcularCalificacionPromedio(self.calificaciones)
        self.planAlimentacionRecomendado = None
        self.planEjercicioRecomendado = None

        self.gimnasio.agregarEntrenador(self)
        Entrenador.listaEntrenadores.append(self)

    # Funciones para efectos de la creación de objetos
    def generarListaCalificaciones(self):
        calificaciones = [random.randint(1, 5) for _ in range(10, random.randint(10, 20))]
        return calificaciones

    def calcularCalificacionPromedio(self, calificaciones):
        promedio = round(sum(calificaciones) / len(calificaciones), 1)
        return promedio

    # Método de funcionalidad
    def filtroEntrenadores(self, cliente):
        # Filtro de un entrenador que se acomode a las necesidades del cliente

        entrenadorFiltrado = None

        if self.nivelEntrenador == cliente.nivelCliente and abs(self.edad - cliente.edad) <= 10:
            if cliente.objetivoCliente.name == 'AUMENTAR' and self.formacion.upper() == 'MUSCULACION':
                self.calcularCalificacionPromedio(self.calificaciones)
                entrenadorFiltrado = self
            elif cliente.objetivoCliente.name == 'DEFINIR' and self.formacion.upper() == 'MUSCULACION':
                self.calcularCalificacionPromedio(self.calificaciones)
                entrenadorFiltrado = self
            elif cliente.objetivoCliente.name == 'BAJARPESO' and self.formacion.upper() == 'CARDIO':
                self.calcularCalificacionPromedio(self.calificaciones)
                entrenadorFiltrado = self
            elif cliente.objetivoCliente.name == 'MANTENER' and self.formacion.upper() == 'GIMNASIA':
                self.calcularCalificacionPromedio(self.calificaciones)
                entrenadorFiltrado = self
            elif cliente.objetivoCliente.name == 'ACONDICIONAR' and self.formacion.upper() == 'CROSSFIT':
                self.calcularCalificacionPromedio(self.calificaciones)
                entrenadorFiltrado = self

        return entrenadorFiltrado

    # Métodos para mostrar información en pantalla
    def __str__(self):
        return f"Nombre: {self.nombre}\nGimnasio: {self.gimnasio}\nNivel: {self.nivelEntrenador}\nCliente: {self.cliente.nombre}\nDisponibilidad: {self.disponibilidad}\n"

    def descripcionHojaVida(self):
        return f"{self.nombre}\nCalificacion Promedio: {self.calificacionPromedio}\nEdad: {self.edad}\nFormacion: {self.formacion}\nNivel: {self.nivelEntrenador}\nGimnasio: {self.gimnasio}\nDisponibilidad: {self.disponibilidad}\n"

    # Método de funcionalidad
    def entrenadoresDisponibles(self, horarioAsistencia, intensidad):
        # Filtro de entrenadores por intensidad y horario de asistencia adecuado
        entrenadorDisponible = None
        if self.nivelEntrenador == intensidad and self.disponibilidad == horarioAsistencia:
            entrenadorDisponible = self

        return entrenadorDisponible
