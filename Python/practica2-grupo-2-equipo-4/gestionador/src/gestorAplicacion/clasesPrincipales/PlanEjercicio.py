from src.gestorAplicacion.clasesEnum.DiaSemana import DiaSemana
from src.gestorAplicacion.clasesEnum.TipoEjercicio import TipoEjercicio
from src.gestorAplicacion.clasesEnum.NivelCliente import NivelCliente
from src.gestorAplicacion.clasesEnum.ObjetivoCliente import ObjetivoCliente
from src.gestorAplicacion.clasesHerencia import Plan
from src.gestorAplicacion.clasesPrincipales import Rutina
import random


class PlanEjercicio():

    #  public PlanEjercicio(){} es necesario para el funcionamiento del codigo en Java. Qué hacer aquí?

    def __init__(self, planSemanalEjercicio=None, nombre=None, dificultad=None):
        self.nombre = nombre
        self.dificultad = dificultad
        self.planSemanalEjercicio = planSemanalEjercicio 
        
    def crearPlanSemanal(self, objetivo: ObjetivoCliente):
        from src.gestorAplicacion.clasesPrincipales.Rutina import Rutina
        array = [TipoEjercicio.EMPUJAR,
                 TipoEjercicio.EMPUJAR,
                 TipoEjercicio.HALAR,
                 TipoEjercicio.HALAR,
                 TipoEjercicio.PIERNA,
                 TipoEjercicio.PIERNA,
                 TipoEjercicio.CARDIO]
        
        random.shuffle(array)

        planSemanalEjerciciosLocalFuncion = {}

        count = 0
        for  dia in DiaSemana:

            rutina = Rutina().generarRutina(array[count], objetivo, self.dificultad)
            planSemanalEjerciciosLocalFuncion[dia] = rutina
            count += 1
        count = 0
        
        return PlanEjercicio(planSemanalEjerciciosLocalFuncion)

    def crearPlanSemanalConNivel(self, objetivo: ObjetivoCliente, nivel: NivelCliente):
        self.set_dificultad(nivel)
        return self.crear_plan_semanal(objetivo)

    def crearPlanEjercicioSemanal(self, objetivo: ObjetivoCliente, nivel: NivelCliente):
        plan = PlanEjercicio()
        return plan.crear_plan_semanal_con_nivel(objetivo, nivel)

    def __str__(self):
        result = "\n----------------TU PLAN DE EJERCICIO----------------\n"
        for dia in DiaSemana:
            result += f"\n{dia.name}: {self.planSemanalEjercicio.get(dia)}"
        return result



