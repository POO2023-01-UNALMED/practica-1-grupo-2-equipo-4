from src.gestorAplicacion.clasesEnum import TipoEjercicio, NivelCliente, ObjetivoCliente
from src.gestorAplicacion.clasesHerencia.Movimiento import Movimiento
from random import randint

# Falta documentar Ejercicio


class Ejercicio(Movimiento):
    def __init__(self, nombre, tipo_ejercicio, maquina, repeticiones, series, dificultad: NivelCliente = None):
        super().__init__(nombre, tipo_ejercicio, maquina, dificultad)
        self.repeticiones = repeticiones
        self.series = series

    @staticmethod
    def generarEjercicio(movimiento, objetivo: TipoEjercicio):
        repeticiones = 0
        series = 0

        if movimiento.tipo_ejercicio == TipoEjercicio.Enum.CALENTAMIENTO:
            repeticiones = 10 + randint(0, 4)
            series = 1
            movimiento.descripcion += "	|Recuerda que los calentamientos están expresados en minutos"
        else:
            if objetivo == ObjetivoCliente.Enum.AUMENTAR:
                repeticiones = 8 + randint(0, 3)
                series = 2 + randint(0, 1)
            elif objetivo == ObjetivoCliente.Enum.DEFINIR:
                repeticiones = 14 + randint(0, 2)
                series = 3 + randint(0, 1)
            elif objetivo == ObjetivoCliente.Enum.BAJARPESO:
                repeticiones = 9 + randint(0, 4)
                series = 2 + randint(0, 1)
            elif objetivo == ObjetivoCliente.Enum.MANTENER:
                repeticiones = 11 + randint(0, 1)
                series = 2 + randint(0, 1)
            elif objetivo == ObjetivoCliente.Enum.ACONDICIONAR:
                repeticiones = 7 + randint(0, 2)
                series = 4 + randint(0, 1)

        return Ejercicio(movimiento.nombre, movimiento.tipo_ejercicio, movimiento.maquina, repeticiones, series,
                         movimiento.dificultad)
