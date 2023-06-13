from Gimnasio import Gimnasio

# Autores: Juan Manuel Rodríguez Sánchez

# Finalidad de la clase:
# La clase Comida sirve para almacenar listas de alimentos que componen
# una de las tres comidas diarias.

# Estructuras de datos:
# Utilizamos una lista (ArrayList) para guardar la lista de alimentos.

# Componentes:
# Unos atributos de nombre, TipoComida, PreferenciaAlimenticia y ObjetivoCliente
# que describen el tipo de la comida.

# Unos atributos de Macronutrientes que se calculan con un método que mostraremos más adelante.
# Una lista estática de todas las comidas que se van creando.


class Maquina:
    def __init__(self, nombre: str, gimnasio: Gimnasio):
        self.nombre = nombre
        self.gimnasio = gimnasio
        self.movimientoRealizado = None

        self.gimnasio.agregarMaquina(self)

        
