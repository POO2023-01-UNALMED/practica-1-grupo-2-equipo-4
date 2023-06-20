from src.gestorAplicacion.clasesEnum import TipoComida, ObjetivoCliente, PreferenciaAlimenticia

# Autores: Juan Jose Ospina Erazo.

# Finalidad de la clase:
# La clase Comida sirve para almacenar listas de alimentos que componen
# una de las tres comidas diarias.

# Estructuras de datos:
# Utilizamos una lista (list) para guardar la lista de alimentos.

# Componentes:
# Unos atributos de nombre, TipoComida, PreferenciaAlimenticia y ObjetivoCliente
# que describen el tipo de la comida.
# Unos atributos de Macronutrientes que se calculan con un método que mostraremos más adelante.
# Una lista estática de todas las comidas que se van creando.

class Comida:
    listaComidas = []

    def __init__(self, nombre, listaAlimentos, tipo: TipoComida, preferenciaAlimenticia: PreferenciaAlimenticia, objetivoCliente: ObjetivoCliente):
        self.nombre = nombre
        self.listaAlimentos = listaAlimentos
        self.tipo = tipo
        self.preferenciaAlimenticia = preferenciaAlimenticia
        self.objetivoCliente = objetivoCliente

        Comida.listaComidas.append(self)

    def calcularCalorias(self):
        # Método para calcular el total de calorías haciendo la suma de calorías de cada alimento
        return sum(alimento.calorias for alimento in self.listaAlimentos)

