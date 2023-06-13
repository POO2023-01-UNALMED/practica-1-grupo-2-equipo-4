from enum import Enum

# Cada cliente tiene una preferencia alimenticia,
# Cada comida tiene una preferencia alimenticia.

class PreferenciaAlimenticia(Enum):
    VEGETARIANO = "VEGETARIANO"
    VEGANO = "VEGANO"
    SINRESTRICCIONES = "SINRESTRICCIONES"
    