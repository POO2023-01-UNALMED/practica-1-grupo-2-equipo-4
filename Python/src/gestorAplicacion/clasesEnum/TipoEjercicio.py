from enum import Enum

# Cada ejercicio puede ser de uno de los tipos.

class TipoEjercicio(Enum):
    EMPUJAR = "EMPUJAR"
    HALAR = "HALAR"
    PIERNA = "PIERNA"
    CALENTAMIENTO = "CALENTAMIENTO"
    ESTIRAMIENTO = "ESTIRAMIENTO"
    CARDIO = "CARDIO"
