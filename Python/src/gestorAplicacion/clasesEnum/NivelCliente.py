from enum import Enum

# Estos niveles serán asignados a los clientes y a los entrenadores.
# Tienen que ver con el nivel de intensidad del entrenamiento.

class NivelCliente(Enum):
    PRINCIPIANTE = "PRINCIPIANTE"
    INTERMEDIO = "INTERMEDIO"
    AVANZADO = "AVANZADO"
