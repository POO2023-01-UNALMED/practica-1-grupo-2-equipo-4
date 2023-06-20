from enum import Enum

# Cada cliente tiene un objetivo dentro del gimnasio.
# Según este objetivo existen comidas que ayudan a cumplir el objetivo,
# También existen rutinas de ejercicio que ayudan a cumplir estos objetivos.
# Dependiendo del objetivo del cliente, se asignará un entrenador cuya formación esté relacionada a dicho objetivo
# (esto es útil para la funcionalidad 5).

class ObjetivoCliente(Enum):
    AUMENTAR = "AUMENTAR"
    DEFINIR = "DEFINIR"
    BAJARPESO = "BAJARPESO"
    MANTENER = "MANTENER"
    ACONDICIONAR = "ACONDICIONAR"
