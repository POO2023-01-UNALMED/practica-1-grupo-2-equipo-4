from src.gestorAplicacion.clasesEnum.Alergeno import Alergeno

# Autores: Juan Jose Ospina Erazo.

# Finalidad de la clase:
# La clase Alimento contiene un alimento individual dentro de una comida.
# Este alimento puede ser, por ejemplo, una papa.
# Esta clase nos ayudará a representar una comida.

# Estructuras de datos:
# Ninguna estructura particular. Se utiliza el Enum Alergeno para determinar si un alimento
# puede generar alergias.

# Nótese que todos los Alergenos son alimentos ricos en Proteinas.
# Si un cliente tiene problemas para consumir un alimento Alergeno,
# se puede cambiar este alimento por una Proteina de elección del cliente.

# Componentes:
# El nombre y los
# Macronutrientes: calorías, proteínas, carbohidratos y grasas.


class Alimento:
    def __init__(self, nombre, calorias, proteinas, carbohidratos, grasas, alergeno: Alergeno):
        self._nombre = nombre
        self.calorias = calorias
        self.proteinas = proteinas
        self.carbohidratos = carbohidratos
        self.grasas = grasas
        self._alergeno = alergeno

    @property
    def nombre(self):
        return self._nombre

    @nombre.setter
    def nombre(self, nombre):
        self._nombre = nombre

    @property
    def alergeno(self):
        return self._alergeno

    @alergeno.setter
    def alergeno(self, alergeno: Alergeno):
        self._alergeno = alergeno


    def encontrarAlimentos(self, maxCal, minProt, aler ):

        if self._alergeno == aler:
            return False
        elif self.calorias > int(maxCal):

            return False
        elif self.proteinas < int(minProt):

            return False
        else:

            return True

    def __str__(self):
        return "{}\n\nCalorías: {}\nProteínas: {}\nCarbohidratos: {}\nGrasas: {}\nAlergeno: {}".format(
            self.nombre.upper(),
            self.calorias,
            self.proteinas,
            self.carbohidratos,
            self.grasas,
            self._alergeno
        )

