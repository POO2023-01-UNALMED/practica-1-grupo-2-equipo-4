from abc import ABC, abstractmethod
from src.gestorAplicacion.clasesEnum import ObjetivoCliente


# Autores: Jacobo ochoa

# Finalidad de la clase:
# La clase abstracta Plan sirve como un modelo para heredar atributos a las clases
# PlanAlimentacion y PlanEjercicio. Es una clase sencilla que tiene dos métodos abstractos

class Plan(ABC):
    @abstractmethod
    def __str__(self):
        pass

    @abstractmethod
    def crearPlanSemanal(self, objetivo: ObjetivoCliente):
        pass
