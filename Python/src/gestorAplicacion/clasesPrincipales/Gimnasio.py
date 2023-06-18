from src.gestorAplicacion.clasesEnum import NivelCliente
# Autores: Jacobo Ochoa Ramírez

# Finalidad de la clase:
# Esta clase sirve como una base de datos.
# Se pueden hacer búsquedas complejas sobre los atributos de un gimnasio.

# Estructuras de datos:
# Tiene listas para máquinas, entrenadores, clientes y una lista estática para los gimnasios.

# Componentes:
# Cada gimnasio tiene un nombre, una ciudad y una sede.
# Contiene listas de máquinas, entrenadores y clientes del gimnasio.


class Gimnasio:
    




    listaGimnasios = []

    def __init__(self, 
                nombre: str, 
                ciudad: str, 
                sede: str, 
                abierto: bool):
        
        self.nombre = nombre
        self.ciudad = ciudad
        self.sede = sede
        self.abierto = abierto
        self.listaMaquinas = []
        self.listaEntrenadores = []
        self.listaClientes = []


    def agregarEntrenador(self, e):
        self.listaEntrenadores.append(e)

    def agregarMaquina(self, m):

        self.listaMaquinas.append(m)

    def agregarCliente(self, c):
        self.listaClientes.append(c)


    def tieneEntrenadoresPrincipiante(self):
        b = False
        
        for e in self.listaEntrenadores:
            if e.nivelEntrendor == NivelCliente.PRINCIPIANTE:
                b = True
                break
        
        return b
    
    def tieneEntrenadoresIntermedio(self):
        b = False
        
        for e in self.listaEntrenadores:
            if e.nivelEntrendor == NivelCliente.INTERMEDIO:
                b = True
                break
        
        return b
    
    def tieneEntrenadoresAvanzado(self):
        b = False
        
        for e in self.listaEntrenadores:
            if e.nivelEntrendor == NivelCliente.AVANZADO:
                b = True
                break
        
        return b


    def __str__(self):
        return f"{self.nombre} {self.ciudad} sede {self.sede}"


    def sedesDisponibles(self, maquinas):
        sedesDisponibles = []
        maquinasEnString = []

        for m in maquinas:
            maquinasEnString.append(m.nombre)

        for g in Gimnasio.listaGimnasios:
            maquinasSedeEnString = []

            for ms in g.listaMaquinas:
                maquinasSedeEnString.append(ms.nombre)

            if g.abierto and (g.ciudad == self.ciudad):
                if set(maquinasEnString).issubset(set(maquinasSedeEnString)):
                    sedesDisponibles.append(g)

        return sedesDisponibles

    def clientesSimilares(self, cliente):
        clientesSimilares = []

        for c in self.listaClientes:
            if c != cliente:
                if (c.sexo.lower() == cliente.sexo.lower() and \
                c.preferenciaAlimenticia.lower() == cliente.preferenciaAlimenticia.lower() and \
                c.objetivoCliente == cliente.objetivoCliente):
                    if (c.peso - 2 < cliente.peso and cliente.peso < c.peso + 2 and \
                    c.edad - 2 < cliente.edad and cliente.edad < c.edad + 2 and \
                    c.altura - 3 < cliente.altura and cliente.altura < c.altura + 3):
                        clientesSimilares.append(c)
        return clientesSimilares
    
