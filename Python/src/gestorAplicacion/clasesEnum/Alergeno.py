from enum import Enum

# En esta clase tenemos algunos tipos de alimentos que pueden generar alergias.
# Esto es útil en la Funcionalidad 2.

class Alergeno(Enum):
    HUEVO = "HUEVO"
    MARISCO = "MARISCO"
    LACTOSA = "LACTOSA"
    GLUTEN = "GLUTEN"
    FRUTOSECO = "FRUTOSECO"
    NINGUNO = "NINGUNO"
