from src.gestorAplicacion.clasesEnum import TipoEjercicio, NivelCliente

# Autores: Juan Manuel Rodríguez Sánchez, Jacobo Ochoa Ramirez.

# Finalidad de la clase:
# La clase Movimiento sirve para representar una acción física que se hace al entrenar.
# La clase Movimiento además sirve para ser Padre de la Clase ejercicio.
# Un ejercicio es un tipo de Movimiento, pero la diferencia es que el ejercicio tiene unas
# repeticiones y unas series.

# Estructuras de datos:
# Utilizamos un ArrayList para guardar cada uno de los movimientos

# Componentes:
# Atributos básicos que describen el movimiento.
# Una máquina que DEBE SER ASIGNADA en el momento de crear un movimiento.


class Movimiento:
    listaMovimientos = []

    def __init__(self, nombre, tipoEjercicio: TipoEjercicio, maquina, dificultad: NivelCliente):
        self.nombre = nombre
        self.tipoEjercicio = tipoEjercicio
        self.maquina = maquina()  # Asignación obligatoria de máquina
        self.dificultad = dificultad

        self.maquina.setMovimientoRealizado(self)

        Movimiento.listaMovimientos.append(self)

    @classmethod
    def filtrarMovimientosPorTipo(cls, tipoEjercicio: TipoEjercicio):
        # Se encarga de recibir un tipoEjercicio que ingresa el cliente
        # Por ejemplo TipoEjercicio.CALENTAMIENTO.
        # Luego filtra todos los movimientos dentro de mi lista que tienen este tipo
        movimientosFiltrados = [movimiento for movimiento in cls.listaMovimientos if movimiento.tipoEjercicio == tipoEjercicio]
        return movimientosFiltrados

    @classmethod
    def filtrarMovimientosPorDificultad(cls, movimientosPorTipo, dificultad: NivelCliente):
        # Se encarga de recibir una lista de movimientos
        # Sobre esta lista hace un filtro de dificultad y retorna
        # únicamente los movimientos de esta lista que tienen la dificultad deseada.
        movimientosFiltrados = [movimiento for movimiento in movimientosPorTipo if movimiento.dificultad == dificultad]
        return movimientosFiltrados

    # Getters y Setters

    def setCompletado(self, completado):
        self.completado = completado

    def isCompletado(self):
        return self.completado

    @classmethod
    def setListaMovimientos(cls, listaMovimientos):
        cls.listaMovimientos = listaMovimientos

    @classmethod
    def getListaMovimientos(cls):
        return cls.listaMovimientos
