from src.gestorAplicacion.clasesEnum import DiaSemana, TipoEjercicio, NivelCliente, ObjetivoCliente
from src.gestorAplicacion.clasesHerencia import Plan
from src.gestorAplicacion.clasesPrincipales import Rutina
import random


class PlanEjercicio(Plan):

    #  public PlanEjercicio(){} es necesario para el funcionamiento del codigo en Java. Qué hacer aquí?

    def __init__(self, planSemanalEjercicio=None, nombre=None, dificultad=None):
        self.nombre = nombre
        self.dificultad = dificultad
        self.planSemanalEjercicio = planSemanalEjercicio 
        
    def crearPlanSemanal(self, objetivo: ObjetivoCliente):
        array = [TipoEjercicio.Enum.EMPUJAR,
                 TipoEjercicio.Enum.EMPUJAR,
                 TipoEjercicio.Enum.HALAR,
                 TipoEjercicio.Enum.HALAR,
                 TipoEjercicio.Enum.PIERNA,
                 TipoEjercicio.Enum.PIERNA,
                 TipoEjercicio.Enum.CARDIO]
        
        random.shuffle(array)

        planSemanalEjerciciosLocalFuncion = {}

        for i, dia in enumerate(DiaSemana):
            planSemanalEjerciciosLocalFuncion[dia] = Rutina.generarRutina(array[i], objetivo, self.dificultad)
        
        return PlanEjercicio(planSemanalEjerciciosLocalFuncion)

    def crearPlanSemanalConNivel(self, objetivo: ObjetivoCliente, nivel: NivelCliente):
        self.set_dificultad(nivel)
        return self.crear_plan_semanal(objetivo)

    def crearPlanEjercicioSemanal(self, objetivo: ObjetivoCliente, nivel: NivelCliente):
        plan = PlanEjercicio()
        return plan.crear_plan_semanal_con_nivel(objetivo, nivel)

    def __str__(self):
        result = "\n----------------TU PLAN DE EJERCICIO----------------\n"
        for dia in DiaSemana.Enum:
            result += f"\n{dia.name}: {self.plan_semanal_ejercicio.get(dia)}"
        return result



