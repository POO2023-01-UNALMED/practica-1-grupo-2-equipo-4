# Autores: Esteban Vásquez Pérez

# Finalidad de la clase:
# La clase abstracta Persona sirve como un modelo para heredar atributos a las clases
# Entrenador y Cliente. Es una clase sencilla que implementa atributos de nombre, identificación
# y gimnasio en el que entrena.

from abc import ABC, abstractmethod


class Persona(ABC):
    def __init__(self, nombre=None, gimnasio=None, identificacion=0):
        self.nombre = nombre
        self.gimnasio = gimnasio
        self.identificacion = identificacion

    def getNombre(self):
        return self.nombre

    def setNombre(self, nombre):
        self.nombre = nombre

    def getIdentificacion(self):
        return self.identificacion

    def getGimnasio(self):
        return self.gimnasio

    @abstractmethod
    def __str__(self):
        pass
