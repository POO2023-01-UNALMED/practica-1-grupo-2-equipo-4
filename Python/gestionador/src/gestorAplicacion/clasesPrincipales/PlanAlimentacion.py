from src.gestorAplicacion.clasesEnum import DiaSemana, ObjetivoCliente, Alergeno

from random import randint

class PlanAlimentacion:


    NUMCOMIDAS = 3

    def __init__(self, nombrePlan, planSemanal=None):
        self.nombrePlan = nombrePlan
        self.comidasFiltradas = []
        self.planSemanal = planSemanal if planSemanal else {}

    def filtrarPorAlergenos(self, alergias):
        from src.gestorAplicacion.clasesPrincipales.Alimento import Alimento

        proteinaComplementaria = Alimento("Proteina", 100, 24, 3, 0, Alergeno.Enum.NINGUNO)

        for comidasDia in self.planSemanal.values():
            for comida in comidasDia:
                alimentosAlergenos = [alimento for alimento in comida.listaAlimentos if alimento.alergeno in alergias]
                comida.listaAlimentos = [alimento for alimento in comida.listaAlimentos if alimento not in alimentosAlergenos]

                if proteinaComplementaria not in comida.listaAlimentos:
                    comida.listaAlimentos.append(proteinaComplementaria)
        return self

    def __str__(self):
        planFormateado = "--------------------TU PLAN DE ALIMENTACIÓN--------------------\n\n"
        dias = []

        for dia in DiaSemana.Enum:
            comidas = self.planSemanal.get(dia)

            if comidas and dia not in dias:
                planFormateado += f"{dia.name}:\n"
                dias.append(dia)

                for comida in comidas:
                    planFormateado += f"\t{comida.nombre}: "
                    alimentos = ', '.join([alimento.nombre for alimento in comida.listaAlimentos])
                    planFormateado += f"{alimentos}\n"

                planFormateado += "\n"

        return planFormateado

    # Asumiendo que 'Empresa' es otra clase que tiene el método 'getComidas' 
    # que devuelve una lista de objetos 'Comida'.
    # También asumiremos que existe una clase 'Empresa' en el módulo 'clasesPrincipales.Empresa'

    def crearPlanSemanal(self, objetivo):

        ## Revisar cómo funciona con objetos serializados

        from src.gestorAplicacion.clasesPrincipales import Empresa
        empresa = Empresa()
        comidasFiltradas = []
        limiteCalBajo = 0
        limiteCalAlto = 0

        # Asigna un rango de calorias para las comidas según el objetivo
        if objetivo == ObjetivoCliente.Enum.ACONDICIONAR:
            limiteCalAlto = 2500 / PlanAlimentacion.NUMCOMIDAS
            limiteCalBajo = 2000 / self.NUMCOMIDAS
        elif objetivo == ObjetivoCliente.Enum.AUMENTAR:
            limiteCalAlto = 3000 / self.NUMCOMIDAS
            limiteCalBajo = 2500 / self.NUMCOMIDAS
        elif objetivo == ObjetivoCliente.Enum.DEFINIR:
            limiteCalAlto = 1500 / self.NUMCOMIDAS
            limiteCalBajo = 1700 / self.NUMCOMIDAS
        elif objetivo == ObjetivoCliente.Enum.BAJARPESO:
            limiteCalAlto = 1300 / self.NUMCOMIDAS
            limiteCalBajo = 1800 / self.NUMCOMIDAS
        elif objetivo == ObjetivoCliente.Enum.MANTENER:
            limiteCalAlto = 1500 / self.NUMCOMIDAS
            limiteCalBajo = 2000 / self.NUMCOMIDAS

        # Agrega las comidas que cumplen con el parametro a una lista
        for comida in empresa.getComidas():
            if comida.calorias <= limiteCalAlto and comida.calorias >= limiteCalBajo:
                comidasFiltradas.append(comida)

        self.comidasFiltradas = comidasFiltradas

        # Agrega tres comidas cualquiera que hagan parte de la lista de comidas filtradas a cada día de la semana
        for dia in DiaSemana.Enum:
            comidasDelDia = [comidasFiltradas[randint(0, len(comidasFiltradas) - 1)] for _ in range(3)]
            self.planSemanal[dia] = comidasDelDia

        return self