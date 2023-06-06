import random
from src.gestorAplicacion.clasesEnum import TipoEjercicio, NivelCliente, ObjetivoCliente
from src.gestorAplicacion.clasesHerencia.Movimiento import Movimiento
from src.gestorAplicacion.clasesPrincipales.Ejercicio import Ejercicio

# Autor: Jacobo Ochoa
# Finalidad de la clase: Simular una rutina de ejercicios para un entrenamiento


class Rutina:
    NUMEJERCIOS = 7

    def __init__(self, nombre=None, ejercicios=None, tipoEjercicio=None):
        self.nombre = nombre
        self.ejercicios = ejercicios if ejercicios else []
        self.tipoEjercicio = tipoEjercicio

    # Componentes: atributos de nombre, TipoEjercicio y una constante con el máximo número de ejercicios en una rutina
    # Estructura de datos: Lista con todos los ejercicios que hacen parte de una rutina

    @staticmethod
    def generarRutina(tipoEjercicio: TipoEjercicio, objetivo: ObjetivoCliente, dificultad: NivelCliente):
        ejercicios = []

        # Filtra los movimientos por dificultad y por tipo de movimiento y los agrega a una lista

        movimientosDisponibles = Movimiento.filtrarMovimientosPorDificultad(Movimiento.filtrarMovimientosPorTipo(tipoEjercicio), dificultad)

        # Filtra los movimientos por tipo para obtener aquellos de tipo Calentamiento y Estiramiento

        movCalentamiento = Movimiento.filtrarMovimientosPorTipo(TipoEjercicio.Enum.CALENTAMIENTO)
        movEstiramiento = Movimiento.filtrarMovimientosPorTipo(TipoEjercicio.Enum.ESTIRAMIENTO)

        # Convierte los movimientos en ejercicios

        ejercicios.append(Ejercicio.generarEjercicio(random.choice(movCalentamiento), objetivo))

        # Añade los ejercicios a la lista para retornar la rutina

        random.shuffle(movimientosDisponibles)

        for i in range(len(movimientosDisponibles)):
            if i == (Rutina.NUMEJERCIOS - 2):
                break
            else:
                ejercicios.append(Ejercicio.generarEjercicio(movimientosDisponibles[i], objetivo))

        ejercicios.append(Ejercicio.generarEjercicio(random.choice(movEstiramiento), objetivo))
        
        return Rutina(ejercicios, tipoEjercicio)

    def __str__(self):
        # Muestra la rutina en pantalla
        toString = str(self.tipoEjercicio) + "\n"
        for ejercicio in self.ejercicios:
            toString += "{} = {} ---> {}x{}\n".format(ejercicio.nombre, ejercicio.maquina.nombre, ejercicio.repeticiones, ejercicio.series)
        return toString
