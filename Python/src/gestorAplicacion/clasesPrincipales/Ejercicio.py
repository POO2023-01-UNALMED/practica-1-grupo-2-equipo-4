from src.gestorAplicacion.clasesHerencia.Movimiento import Movimiento
from src.gestorAplicacion.clasesEnum import TipoEjercicio, NivelCliente, ObjetivoCliente
from random import randint

# Falta documentar Ejercicio


class Ejercicio(Movimiento):
    def __init__(self, nombre, tipo_ejercicio, maquina, repeticiones, series, dificultad: NivelCliente = None):
        super().__init__(nombre, tipo_ejercicio, maquina, dificultad)
        self.repeticiones = repeticiones
        self.series = series

    @classmethod
    def generarEjercicio(self, movimiento, objetivo):
        repeticiones = 0
        series = 0

        if movimiento.tipo_ejercicio == TipoEjercicio.CALENTAMIENTO:
            repeticiones = 10 + randint(0, 4)
            series = 1
            movimiento.descripcion += "	|Recuerda que los calentamientos están expresados en minutos"
        else:
            if objetivo == ObjetivoCliente.AUMENTAR:
                repeticiones = 8 + randint(0, 3)
                series = 2 + randint(0, 1)
            elif objetivo == ObjetivoCliente.DEFINIR:
                repeticiones = 14 + randint(0, 2)
                series = 3 + randint(0, 1)
            elif objetivo == ObjetivoCliente.BAJARPESO:
                repeticiones = 9 + randint(0, 4)
                series = 2 + randint(0, 1)
            elif objetivo == ObjetivoCliente.MANTENER:
                repeticiones = 11 + randint(0, 1)
                series = 2 + randint(0, 1)
            elif objetivo == ObjetivoCliente.ACONDICIONAR:
                repeticiones = 7 + randint(0, 2)
                series = 4 + randint(0, 1)

        return Ejercicio(movimiento.nombre, movimiento.tipo_ejercicio, movimiento.maquina, repeticiones, series,
                         movimiento.dificultad)


def generarEjercicio(mo1, ACONDICIONAR):
    return None